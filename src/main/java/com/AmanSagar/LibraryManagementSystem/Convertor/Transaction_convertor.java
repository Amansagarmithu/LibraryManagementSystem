package com.AmanSagar.LibraryManagementSystem.Convertor;

import com.AmanSagar.LibraryManagementSystem.Module.Book;
import com.AmanSagar.LibraryManagementSystem.Module.Card;
import com.AmanSagar.LibraryManagementSystem.Module.Transaction;

public class Transaction_convertor {

    public static Transaction convertor(Book book, Card card){
        return Transaction.builder().book(book).card(card).bookIssued(true).build();
    }
}
