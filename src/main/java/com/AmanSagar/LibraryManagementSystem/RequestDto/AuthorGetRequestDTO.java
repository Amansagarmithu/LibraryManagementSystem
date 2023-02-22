package com.AmanSagar.LibraryManagementSystem.RequestDto;

import com.AmanSagar.LibraryManagementSystem.enums.Gener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorGetRequestDTO {
    private String name;
    private Gener gener;
    private List<BookGetRequestDTO> bookList = new ArrayList<>();
}
