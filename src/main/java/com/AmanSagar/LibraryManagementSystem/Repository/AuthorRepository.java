package com.AmanSagar.LibraryManagementSystem.Repository;

import com.AmanSagar.LibraryManagementSystem.Module.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
