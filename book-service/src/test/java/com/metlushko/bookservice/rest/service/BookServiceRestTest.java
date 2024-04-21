package com.metlushko.bookservice.rest.service;

import com.metlushko.bookservice.rest.dto.BookResponseDto;
import com.metlushko.bookservice.rest.entity.Book;
import com.metlushko.bookservice.rest.mapper.BookMapper;
import com.metlushko.bookservice.rest.repository.BookRepository;
import com.metlushko.bookservice.rest.util.TestDataBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceRestTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @Mock
    private ImageService imageService;

    @InjectMocks
    private BookServiceRest bookServiceRest;

    @Test
    void getAllBooks() {
        Book expectedBookOne = TestDataBuilder.builder().build().buildBook();
        BookResponseDto bookResponseDtoOne = TestDataBuilder.builder().build()
                .buildBookResponseDto();
        Book expectedBookTwo = TestDataBuilder.builder().build().buildBook();
        BookResponseDto bookResponseDtoTwo = TestDataBuilder.builder().build()
                .buildBookResponseDto();
        List<Book> expBookList = List.of(expectedBookOne, expectedBookTwo);
        List<BookResponseDto> expBookResponseDto = List.of(bookResponseDtoOne, bookResponseDtoTwo);

        when(bookRepository.findAll()).thenReturn(expBookList);
        when(bookMapper.toBookResponseDto(expectedBookOne)).thenReturn(bookResponseDtoOne);
        when(bookMapper.toBookResponseDto(expectedBookTwo)).thenReturn(bookResponseDtoTwo);


        List<BookResponseDto> actualAllBooks = bookServiceRest.getAllBooks();

        assertEquals(expBookResponseDto,actualAllBooks);
    }

    @Test
    void getBookById() {
        //given
        Book expectedBook = TestDataBuilder.builder().build().buildBook();
        Long id = expectedBook.getId();
        when(bookRepository.findById(id))
                .thenReturn(Optional.of(expectedBook));

        //when
        Book actualBook = bookServiceRest.getBookById(id);

        //then
        assertEquals(expectedBook, actualBook);
    }



}