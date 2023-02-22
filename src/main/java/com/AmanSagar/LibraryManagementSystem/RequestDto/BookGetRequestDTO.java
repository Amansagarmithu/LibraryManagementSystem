package com.AmanSagar.LibraryManagementSystem.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookGetRequestDTO {

    private String name;
    private int pages;

}
