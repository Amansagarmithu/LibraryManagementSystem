package com.AmanSagar.LibraryManagementSystem.RequestDto;

import com.AmanSagar.LibraryManagementSystem.enums.Gener;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorRequestDto {

    private String name;

    private Gener authorgener;
}
