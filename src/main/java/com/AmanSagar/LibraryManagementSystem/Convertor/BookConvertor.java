package com.AmanSagar.LibraryManagementSystem.Convertor;

import com.AmanSagar.LibraryManagementSystem.Module.Book;
import com.AmanSagar.LibraryManagementSystem.RequestDto.BookRequestDto;

public class BookConvertor {
    public static Book convertbook(BookRequestDto bookrequestdto){
        Book book = Book.builder().name(bookrequestdto.getName()).pages(bookrequestdto.getPages()).build();
        return book;
    }
}
