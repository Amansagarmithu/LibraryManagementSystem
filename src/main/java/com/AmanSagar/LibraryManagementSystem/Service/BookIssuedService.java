package com.AmanSagar.LibraryManagementSystem.Service;

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

@Service
public class BookIssuedService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardrepository;

    public String issueBook(BookIssued bookissued){
        Book bk = bookRepository.findById(bookissued.getBookid()).get();
        Card cr = cardrepository.findById(bookissued.getCardid()).get();
        Transaction transaction = new Transaction();
        transaction.setBookIssued(true);
        transaction.setBook(bk);
        transaction.setCard(cr);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transactionRepository.save(transaction);

        return "success";
    }
}
