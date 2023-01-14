package com.AmanSagar.LibraryManagementSystem.RequestDto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookRequestDto {

    private String name;
    private int pages;
    private int authorid;
}
