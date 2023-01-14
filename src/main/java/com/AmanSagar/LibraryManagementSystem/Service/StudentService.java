package com.AmanSagar.LibraryManagementSystem.Service;

import com.AmanSagar.LibraryManagementSystem.Convertor.StudentConvertor;
import com.AmanSagar.LibraryManagementSystem.Module.Student;
import com.AmanSagar.LibraryManagementSystem.Repository.StudentRepository;
import com.AmanSagar.LibraryManagementSystem.RequestDto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentrepository;
    public String add_student(StudentRequestDto studentrequestdto){
        Student student = StudentConvertor.convertstudent(studentrequestdto);
        studentrepository.save(student);
        return "Sucessfully added";
    }
}
