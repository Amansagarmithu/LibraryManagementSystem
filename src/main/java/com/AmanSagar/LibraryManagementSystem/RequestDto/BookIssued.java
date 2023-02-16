package com.AmanSagar.LibraryManagementSystem.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookIssued {

    private int bookid;

    private int cardid;
}
