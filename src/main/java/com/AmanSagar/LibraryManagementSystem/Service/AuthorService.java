package com.AmanSagar.LibraryManagementSystem.Service;

import com.AmanSagar.LibraryManagementSystem.Convertor.AuthorConvertor;
import com.AmanSagar.LibraryManagementSystem.Module.Author;
import com.AmanSagar.LibraryManagementSystem.Repository.AuthorRepository;
import com.AmanSagar.LibraryManagementSystem.RequestDto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorreopsitory;
    public String add_author(AuthorRequestDto authorrequestdto){
        Author author = AuthorConvertor.convertauthor(authorrequestdto);
        authorreopsitory.save(author);
        return "Sucessfully added";
    }
}
