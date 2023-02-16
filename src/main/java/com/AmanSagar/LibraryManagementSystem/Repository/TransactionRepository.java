package com.AmanSagar.LibraryManagementSystem.Repository;

import com.AmanSagar.LibraryManagementSystem.Module.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
