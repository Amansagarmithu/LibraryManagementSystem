package com.AmanSagar.LibraryManagementSystem.Module;

import com.AmanSagar.LibraryManagementSystem.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardstatus;

    @OneToOne
    @JsonIgnore
    private Student student;
    @JoinColumn
    @OneToMany
    private List<Book> cardholderbooks;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)

    private List<Transaction> transactionsList = new ArrayList<>();
}
