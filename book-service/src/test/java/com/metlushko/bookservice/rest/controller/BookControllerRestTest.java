package com.metlushko.bookservice.rest.controller;

import com.metlushko.bookservice.rest.dto.BookResponseDto;
import com.metlushko.bookservice.rest.entity.Book;
import com.metlushko.bookservice.rest.service.BookServiceRest;
import com.metlushko.bookservice.rest.service.ImageService;
import com.metlushko.bookservice.rest.util.TestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookControllerRest.class)
class BookControllerRestTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookServiceRest bookServiceRest;

    @MockBean
    private ImageService imageService;


    @Test
    void getBookById() throws Exception {
        //given
        Long bookId = 10L;

        Book expectedBook = TestDataBuilder.builder().build().buildBook();
        given(bookServiceRest.getBookById(bookId))
                        .willReturn(expectedBook);
        //when
        ResultActions responce = mockMvc.perform(get("/api/v1/books/{id}",bookId));

        //then
        responce.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.imageId",is(expectedBook.getImageId())))
                .andExpect(jsonPath("$.name",is(expectedBook.getName())))
                .andExpect(jsonPath("$.author",is(expectedBook.getAuthor())))
                .andExpect(jsonPath("$.description",is(expectedBook.getDescription())));

    }

    @Test
    void getAllBooks() throws Exception {
        //given
        BookResponseDto bookResponseDto = TestDataBuilder.builder()
                .withAuthor("asdsad").build().buildBookResponseDto();
        BookResponseDto bookResponseDtoSecond = TestDataBuilder.builder()
                .build().buildBookResponseDto();
        List<BookResponseDto> BookResponseDtoList = List.of(bookResponseDto,bookResponseDtoSecond);

        given(bookServiceRest.getAllBooks())
                .willReturn(BookResponseDtoList);

        //when
        ResultActions response = mockMvc.perform(get("/api/v1/books"));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(BookResponseDtoList.size())));

    }


    @Test
    void delete() throws Exception {
        // given
        Long bookId = 10L;
        BDDMockito.doReturn(true).doThrow(new RuntimeException()).when(bookServiceRest).deleteBook(bookId);

        // when
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/books/{id}", bookId));

        // then
        response.andExpect(status().isNoContent())
                .andDo(print());
    }



}