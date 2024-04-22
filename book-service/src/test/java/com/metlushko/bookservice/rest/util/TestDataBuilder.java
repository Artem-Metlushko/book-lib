package com.metlushko.bookservice.rest.util;

import com.metlushko.bookservice.rest.dto.BookRequestDto;
import com.metlushko.bookservice.rest.dto.BookResponseDto;
import com.metlushko.bookservice.rest.entity.Book;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@Builder(setterPrefix = "with", toBuilder = true)
public class TestDataBuilder {

    @Builder.Default
    private Long id = 10L;

    @Builder.Default
    private String name = "Kim";

    @Builder.Default
    private String author = "Chanin";

    @Builder.Default
    private String description = "Kudropali";

    public Book buildBook() {
        return Book.builder()
                .id(id)
                .author(author)
                .name(name)
                .description(description)
                .build();
    }

    public BookResponseDto buildBookResponseDto() {
        return BookResponseDto.builder()
                .author(author)
                .name(name)
                .description(description)
                .build();
    }

    public BookRequestDto buildBookRequestDto() {
        return BookRequestDto.builder()
                .author(author)
                .name(name)
                .description(description)
                .build();
    }

}
