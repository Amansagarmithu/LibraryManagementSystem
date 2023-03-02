package com.AmanSagar.LibraryManagementSystem.Module;

import com.AmanSagar.LibraryManagementSystem.enums.Gener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gener Authortype;


    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> assignedbooks;
}
