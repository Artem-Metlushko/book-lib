package com.metlushko.bookservice.rest;

import com.metlushko.bookservice.rest.controller.BookControllerRest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceApplicationTest {

    @Autowired
    BookControllerRest bookControllerRest;

    @Test
    public void context(){
        Assertions.assertThat(bookControllerRest).isNotNull();
    }

}