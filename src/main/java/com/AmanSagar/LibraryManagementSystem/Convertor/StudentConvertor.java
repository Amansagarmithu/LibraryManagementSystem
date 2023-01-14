package com.AmanSagar.LibraryManagementSystem.Convertor;

import com.AmanSagar.LibraryManagementSystem.Module.Student;
import com.AmanSagar.LibraryManagementSystem.RequestDto.StudentRequestDto;

public class StudentConvertor {

    public static Student convertstudent(StudentRequestDto studentrequestdto){
        Student student = Student.builder().name(studentrequestdto.getName()).email(studentrequestdto.getEmail()).build();
        return student;
    }
}
