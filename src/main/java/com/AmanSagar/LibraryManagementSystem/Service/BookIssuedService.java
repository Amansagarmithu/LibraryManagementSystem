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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
