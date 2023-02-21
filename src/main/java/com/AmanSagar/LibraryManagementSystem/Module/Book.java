package com.AmanSagar.LibraryManagementSystem.Module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.*;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int pages;

    @JoinColumn
    @ManyToOne
    private Author author;
    private boolean bookissued = false;


    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

}
