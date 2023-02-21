package com.AmanSagar.LibraryManagementSystem.Controller;

import com.AmanSagar.LibraryManagementSystem.RequestDto.BookIssued;
import com.AmanSagar.LibraryManagementSystem.Service.BookIssuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/BookIssued")
public class IssueBook {

    @Autowired
    BookIssuedService bookIssuedService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody BookIssued bookissued)throws Exception{
        return bookIssuedService.issueBook(bookissued);
    }
    @GetMapping("/listOfTransaction")
    public ResponseEntity<Integer> finList(@RequestParam("cardid") int cardid){
        return new ResponseEntity(bookIssuedService.ListOfTransaction(cardid), HttpStatus.OK);
    }
}
