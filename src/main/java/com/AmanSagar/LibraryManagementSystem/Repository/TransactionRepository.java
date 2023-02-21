package com.AmanSagar.LibraryManagementSystem.Repository;

import com.AmanSagar.LibraryManagementSystem.Module.Book;
import com.AmanSagar.LibraryManagementSystem.Module.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    public Transaction findByBook(Book book);

    @Query(value = "select * from transaction where card_id = :cardid",nativeQuery = true)
    public List<Transaction> findTransaction(int cardid);

    @Query(value = "select transaction_date from transaction where card_id =:cardid and book_id =:bookid",nativeQuery = true)
    public Date findDate(int bookid,int cardid);
}
