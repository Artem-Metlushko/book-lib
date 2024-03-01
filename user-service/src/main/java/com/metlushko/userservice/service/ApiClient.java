package com.metlushko.userservice.service;

import com.metlushko.userservice.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "book-service")
public interface ApiClient {

    @GetMapping(value = "/api/v1/books/{id}")
    BookDto getBookById(@PathVariable("id") Long id);
}
