package com.AmanSagar.LibraryManagementSystem.Controller;

import com.AmanSagar.LibraryManagementSystem.RequestDto.AuthorRequestDto;
import com.AmanSagar.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorservice;
    @PostMapping("/add_author")
    public ResponseEntity<String> add_author(AuthorRequestDto authorrequestdto){
        String ans = authorservice.add_author(authorrequestdto);
        return new ResponseEntity(ans, HttpStatus.OK);
    }
}
