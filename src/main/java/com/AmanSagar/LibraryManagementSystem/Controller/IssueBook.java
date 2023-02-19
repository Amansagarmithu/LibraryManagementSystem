package com.AmanSagar.LibraryManagementSystem.Controller;

import com.AmanSagar.LibraryManagementSystem.RequestDto.BookIssued;
import com.AmanSagar.LibraryManagementSystem.Service.BookIssuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/BookIssued")
public class IssueBook {

    @Autowired
    BookIssuedService bookIssuedService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody BookIssued bookissued)throws Exception{
        return bookIssuedService.issueBook(bookissued);
    }
}
