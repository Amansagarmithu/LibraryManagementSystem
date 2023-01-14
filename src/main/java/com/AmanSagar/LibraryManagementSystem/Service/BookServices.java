package com.AmanSagar.LibraryManagementSystem.Service;

import com.AmanSagar.LibraryManagementSystem.Convertor.BookConvertor;
import com.AmanSagar.LibraryManagementSystem.Module.Author;
import com.AmanSagar.LibraryManagementSystem.Module.Book;
import com.AmanSagar.LibraryManagementSystem.Repository.AuthorRepository;
import com.AmanSagar.LibraryManagementSystem.Repository.BookRepository;
import com.AmanSagar.LibraryManagementSystem.RequestDto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServices {

    @Autowired
    BookRepository bookrepository;
    @Autowired
    AuthorRepository authorrepository;
    public String add_book(BookRequestDto bookrequestdto){
        Book book = BookConvertor.convertbook(bookrequestdto);
        Author author = authorrepository.findById(bookrequestdto.getAuthorid()).get();
        book.setAuthor(author);
        bookrepository.save(book);
        return "sucessfully added";
    }
}
