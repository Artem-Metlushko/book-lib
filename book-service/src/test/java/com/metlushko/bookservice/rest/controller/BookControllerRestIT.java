package com.metlushko.bookservice.rest.controller;

import com.metlushko.bookservice.rest.dto.BookRequestDto;
import com.metlushko.bookservice.rest.dto.BookResponseDto;
import com.metlushko.bookservice.rest.entity.Book;
import com.metlushko.bookservice.rest.service.BookServiceRest;
import com.metlushko.bookservice.rest.util.BookIT;
import com.metlushko.bookservice.rest.util.TestDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class BookControllerRestIT extends BookIT {
    @Autowired
    private BookServiceRest bookServiceRest;

    @Test
    void getBookById() {

        Book book = TestDataBuilder.builder()
                .build().buildBook();

        Book bookById = bookServiceRest.getBookById(10L);

        assertEquals(bookById,book);
    }

    @Test
    void getAllBooks() {
        List<BookResponseDto> allBooks = bookServiceRest.getAllBooks();
        assertEquals(2,allBooks.size());
    }

    @Test
    void delete(){
        Book book = TestDataBuilder.builder()
                .build().buildBook();
        Long id = book.getId();

        boolean b = bookServiceRest.deleteBook(id);

        assertTrue(b);
    }

    @Test
    void update(){
        Book book = TestDataBuilder.builder()
                .build().buildBook();
        Long id = book.getId();
        BookRequestDto bookRequestDto = TestDataBuilder.builder()
                .withAuthor("Freddy")
                .withName("Mercury")
                .build().buildBookRequestDto();
        BookResponseDto expBookResponseDto = TestDataBuilder.builder()
                .withAuthor("Freddy")
                .withName("Mercury")
                .build().buildBookResponseDto();

        BookResponseDto actBookResponseDto = bookServiceRest.updateBook(id, bookRequestDto).orElseThrow();

        assertEquals(actBookResponseDto,expBookResponseDto);
    }

    @Test
    void save(){
        BookRequestDto bookRequestDto = TestDataBuilder.builder()
                .build().buildBookRequestDto();
        BookResponseDto expBookResponseDto = TestDataBuilder.builder()
                .build().buildBookResponseDto();

        BookResponseDto actBookResponseDto = bookServiceRest.addBook(bookRequestDto);

        assertEquals(actBookResponseDto,expBookResponseDto);


    }
}