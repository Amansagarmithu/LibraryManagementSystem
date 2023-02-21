package com.AmanSagar.LibraryManagementSystem.Service;
import com.AmanSagar.LibraryManagementSystem.Convertor.Transaction_convertor;
import com.AmanSagar.LibraryManagementSystem.Module.Book;
import com.AmanSagar.LibraryManagementSystem.Module.Card;
import com.AmanSagar.LibraryManagementSystem.Module.Transaction;
import com.AmanSagar.LibraryManagementSystem.Repository.BookRepository;
import com.AmanSagar.LibraryManagementSystem.Repository.CardRepository;
import com.AmanSagar.LibraryManagementSystem.Repository.TransactionRepository;
import com.AmanSagar.LibraryManagementSystem.RequestDto.BookIssued;
import com.AmanSagar.LibraryManagementSystem.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.*;

@Service
public class BookIssuedService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardrepository;

    public String issueBook(BookIssued bookissued) throws Exception{
        Book bk = bookRepository.findById(bookissued.getBookid()).get();
        bk.setBookissued(true);
        Card cr = cardrepository.findById(bookissued.getCardid()).get();
        Transaction transaction = Transaction_convertor.convertor(bk,cr);
        if(bk==null){
            throw new Exception("book is not present");
        }
        if(cr==null){
            throw new Exception("Card is not present");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        List<Transaction> ListOfTransactioninBook = bk.getTransactions();
        ListOfTransactioninBook.add(transaction);
        bk.setTransactions(ListOfTransactioninBook);

        List<Transaction> ListOfTrasactioninCard = cr.getTransactionsList();
        ListOfTrasactioninCard.add(transaction);
        cr.setTransactionsList(ListOfTrasactioninCard);
        transactionRepository.save(transaction);

        return "success";
    }

    public int ListOfTransaction(int cardId){
        if(cardrepository.findById(cardId)==null){
            return -1;
        }

        List<Transaction> ans = transactionRepository.findTransaction(cardId);
        return ans.size();
    }
    public  void returnBook(int bookid,int cardid){
        Date returndate = new Date();
        Date issuedDate = transactionRepository.findDate(bookid,cardid);
        long diff = Duration.between(returndate.toInstant(),  issuedDate.toInstant()).toDays();
        int fine  = 0;
        if(diff>10l){
            fine = (int)((diff-10l)*10);
        }
        Book bk = bookRepository.findById(bookid).get();

        bk.setBookissued(false);
        Card cr = cardrepository.findById(cardid).get();
        Transaction tr = Transaction_convertor.convertor(bk,cr);
        List<Book> bookList = cr.getCardholderbooks();
        for(int i = 0;i<bookList.size();i++){
            if(bookList.get(i)==bk){
                bookList.remove(i);
                break;
            }
        }
        cr.setCardholderbooks(bookList);
        tr.setFine(fine);
        tr.setTransactionStatus(TransactionStatus.COMPLETE);
        List<Transaction> ListOfTransactioninBook = bk.getTransactions();
        ListOfTransactioninBook.add(tr);
        bk.setTransactions(ListOfTransactioninBook);

        List<Transaction> ListOfTrasactioninCard = cr.getTransactionsList();
        ListOfTrasactioninCard.add(tr);
        cr.setTransactionsList(ListOfTrasactioninCard);
        transactionRepository.save(tr);
    }
    public static void main(String[] args) {
        BookIssuedService bks = new BookIssuedService();
        bks.returnBook(1,1);
    }
}



