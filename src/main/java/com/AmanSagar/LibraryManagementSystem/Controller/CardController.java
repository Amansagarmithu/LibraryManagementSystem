package com.AmanSagar.LibraryManagementSystem.Controller;

import com.AmanSagar.LibraryManagementSystem.RequestDto.CardBookDto;
import com.AmanSagar.LibraryManagementSystem.RequestDto.CardRequestDto;
import com.AmanSagar.LibraryManagementSystem.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @Autowired
    CardService cardservice;
    @PostMapping("/add_card")
    public ResponseEntity<String> add_card(CardRequestDto cardrequestdto){
        String ans = cardservice.add_card(cardrequestdto);
        return new ResponseEntity(ans, HttpStatus.OK);
    }
    @PostMapping("/add_book_in_card")
    public ResponseEntity<String> add_book(CardBookDto cardbookdto){
        String ans = cardservice.add_book_in_card(cardbookdto);
        return new ResponseEntity(ans,HttpStatus.OK);
    }
}
