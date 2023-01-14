package com.AmanSagar.LibraryManagementSystem.Controller;

import com.AmanSagar.LibraryManagementSystem.RequestDto.BookRequestDto;
import com.AmanSagar.LibraryManagementSystem.Service.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookServices bookservice;

    @PostMapping("/add_book")
    public ResponseEntity<String> add_student(BookRequestDto bookrequestdto){
        String ans = bookservice.add_book(bookrequestdto);
        return new ResponseEntity(ans, HttpStatus.OK);
    }
}
