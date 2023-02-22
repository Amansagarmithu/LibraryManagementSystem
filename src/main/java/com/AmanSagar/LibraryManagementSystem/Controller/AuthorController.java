package com.AmanSagar.LibraryManagementSystem.Controller;

import com.AmanSagar.LibraryManagementSystem.RequestDto.AuthorGetRequestDTO;
import com.AmanSagar.LibraryManagementSystem.RequestDto.AuthorRequestDto;
import com.AmanSagar.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/get_author")
    public ResponseEntity<AuthorGetRequestDTO> getAuthor(@RequestParam("authorId") int authorid){
        return new ResponseEntity<>(authorservice.getAuthor(authorid),HttpStatus.OK);
    }
}
