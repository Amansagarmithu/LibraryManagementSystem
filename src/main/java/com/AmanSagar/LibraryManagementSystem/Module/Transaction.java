package com.AmanSagar.LibraryManagementSystem.Module;

import com.AmanSagar.LibraryManagementSystem.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.util.*;
import java.util.UUID;

@Entity
@Table(name="Transaction")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private int fine;

    private String transactionID = UUID.randomUUID().toString();

    @CreationTimestamp
    private Date transactionDate;

    private boolean bookIssued;

    @ManyToOne
    @JoinColumn
    private Book book;

    @ManyToOne
    @JoinColumn
    private Card card;

}
