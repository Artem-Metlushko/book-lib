package com.metlushko.bookservice.rest.mapper;

import com.metlushko.bookservice.rest.dto.BookRequestDto;
import com.metlushko.bookservice.rest.dto.BookResponseDto;
import com.metlushko.bookservice.rest.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toBook(BookRequestDto bookRequestDto, String imageId) {
        return Book.builder()
                .author(bookRequestDto.author())
                .name(bookRequestDto.name())
                .description(bookRequestDto.description())
                .imageId(imageId)
                .build();
    }


    public BookResponseDto toBookResponseDto(Book book) {
        return new BookResponseDto(book.getName(), book.getAuthor(), book.getDescription(), book.getImageId());
    }

    public Book toCopyBook(Book book, BookRequestDto bookRequestDto) {
        return Book.builder()
                .id(book.getId())
                .author(bookRequestDto.author())
                .name(bookRequestDto.name())
                .description(bookRequestDto.description())
                .build();

    }

}
