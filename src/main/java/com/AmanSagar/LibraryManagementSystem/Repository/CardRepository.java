package com.AmanSagar.LibraryManagementSystem.Repository;

import com.AmanSagar.LibraryManagementSystem.Module.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
