package com.AmanSagar.LibraryManagementSystem.Service;

import com.AmanSagar.LibraryManagementSystem.Convertor.CardConvertor;
import com.AmanSagar.LibraryManagementSystem.Module.Book;
import com.AmanSagar.LibraryManagementSystem.Module.Card;
import com.AmanSagar.LibraryManagementSystem.Module.Student;
import com.AmanSagar.LibraryManagementSystem.Repository.BookRepository;
import com.AmanSagar.LibraryManagementSystem.Repository.CardRepository;
import com.AmanSagar.LibraryManagementSystem.Repository.StudentRepository;
import com.AmanSagar.LibraryManagementSystem.RequestDto.CardBookDto;
import com.AmanSagar.LibraryManagementSystem.RequestDto.CardRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CardService {

    @Autowired
    CardRepository cardrepository;
    @Autowired
    StudentRepository studentrepository;
    @Autowired
    BookRepository bookrepository;
    public String add_card(CardRequestDto cardrequestdto){
        Card card = CardConvertor.convertcard(cardrequestdto);
        Student student = studentrepository.findById(cardrequestdto.getStudentid()).get();
        card.setStudent(student);
        cardrepository.save(card);
        return "sucessfully added";
    }
    public String add_book_in_card(CardBookDto cardbookdto){
        Card card = cardrepository.findById(cardbookdto.getCardid()).get();
        Book book = bookrepository.findById(cardbookdto.getBookid()).get();
        List<Book> cardbooks = card.getCardholderbooks();
        cardbooks.add(book);
        card.setCardholderbooks(cardbooks);
        return "Sucessfully added ";
    }
}
