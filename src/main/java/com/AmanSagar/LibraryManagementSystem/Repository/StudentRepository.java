package com.AmanSagar.LibraryManagementSystem.Repository;

import com.AmanSagar.LibraryManagementSystem.Module.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);
    List<Student> findByName(String name);
}
