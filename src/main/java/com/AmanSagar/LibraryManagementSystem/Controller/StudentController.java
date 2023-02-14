package com.AmanSagar.LibraryManagementSystem.Controller;

import com.AmanSagar.LibraryManagementSystem.RequestDto.StudentRequestDto;
import com.AmanSagar.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.AmanSagar.LibraryManagementSystem.Module.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentservice;

    @PostMapping("/add_student")
    public ResponseEntity<String> add_student(@RequestBody()StudentRequestDto studentrequestdto){
        String ans = studentservice.add_student(studentrequestdto);
        return new ResponseEntity(ans, HttpStatus.OK);
    }
    @GetMapping("/find_Student")
    public ResponseEntity<String> find_student_by_email(String email){
        Student st = studentservice.findbyEmail(email);
        return new ResponseEntity<>(st.getName(),HttpStatus.OK);
    }
}
