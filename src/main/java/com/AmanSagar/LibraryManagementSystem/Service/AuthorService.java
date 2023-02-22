package com.AmanSagar.LibraryManagementSystem.Service;

import com.AmanSagar.LibraryManagementSystem.Convertor.AuthorConvertor;
import com.AmanSagar.LibraryManagementSystem.Module.Author;
import com.AmanSagar.LibraryManagementSystem.Module.Book;
import com.AmanSagar.LibraryManagementSystem.Repository.AuthorRepository;
import com.AmanSagar.LibraryManagementSystem.Repository.BookRepository;
import com.AmanSagar.LibraryManagementSystem.RequestDto.AuthorGetRequestDTO;
import com.AmanSagar.LibraryManagementSystem.RequestDto.AuthorRequestDto;
import com.AmanSagar.LibraryManagementSystem.RequestDto.BookGetRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorreopsitory;
    @Autowired
    BookRepository bookrepository;
    public String add_author(AuthorRequestDto authorrequestdto){
        Author author = AuthorConvertor.convertauthor(authorrequestdto);
        authorreopsitory.save(author);
        return "Sucessfully added";
    }
    public AuthorGetRequestDTO getAuthor(int authorId){
        Author ath = authorreopsitory.findById(authorId).get();

        List<Book> bk = ath.getAssignedbooks();

        List<BookGetRequestDTO> bkt = new ArrayList<>();
        for(Book b:bk){
            BookGetRequestDTO bkd = new BookGetRequestDTO();
            bkd.setName(b.getName());
            bkd.setPages(b.getPages());
            bkt.add(bkd);
        }
        AuthorGetRequestDTO atr  = new AuthorGetRequestDTO();
        atr.setName(ath.getName());
        atr.setGener(ath.getAuthortype());
        atr.setBookList(bkt);
        return atr;
    }

}
