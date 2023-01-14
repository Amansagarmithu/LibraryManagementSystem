package com.AmanSagar.LibraryManagementSystem.Controller;

import com.AmanSagar.LibraryManagementSystem.RequestDto.StudentRequestDto;
import com.AmanSagar.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentservice;

    @PostMapping("/add_student")
    public ResponseEntity<String> add_student(@RequestBody()StudentRequestDto studentrequestdto){
        String ans = studentservice.add_student(studentrequestdto);
        return new ResponseEntity(ans, HttpStatus.OK);
    }
}
