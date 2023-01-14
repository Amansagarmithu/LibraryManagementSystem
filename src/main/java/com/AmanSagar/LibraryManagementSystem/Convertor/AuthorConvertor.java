package com.AmanSagar.LibraryManagementSystem.Convertor;

import com.AmanSagar.LibraryManagementSystem.Module.Author;
import com.AmanSagar.LibraryManagementSystem.RequestDto.AuthorRequestDto;

public class AuthorConvertor {
    public static Author convertauthor(AuthorRequestDto authorrequestdto){
        Author author = Author.builder().name(authorrequestdto.getName()).Authortype(authorrequestdto.getAuthorgener()).build();
        return author;
    }
}
