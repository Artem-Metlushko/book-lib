package com.metlushko.bookservice.rest.controller;


import com.metlushko.bookservice.rest.dto.BookRequestDto;
import com.metlushko.bookservice.rest.dto.BookResponseDto;
import com.metlushko.bookservice.rest.entity.Book;
import com.metlushko.bookservice.rest.service.BookServiceRest;
import com.metlushko.bookservice.rest.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/books")
public class BookControllerRest {

    private final BookServiceRest bookService;
    private final ImageService imageService;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookResponseDto addBook(@Valid @RequestBody BookRequestDto bookResponseDto) {
        return bookService.addBook(bookResponseDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BookResponseDto handleJsonAndMultipartInput(@RequestPart("data") BookRequestDto bookResponseDto,
                                                       @RequestPart("file") MultipartFile file) {
        return bookService.addBook(bookResponseDto, file);
    }

    @PutMapping("{id}")
    public BookResponseDto update(@PathVariable("id") Long id,
                                  @Valid @RequestBody BookRequestDto bookRequestDto) {
        return bookService.updateBook(id, bookRequestDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        if (!bookService.deleteBook(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<InputStreamResource> download(@PathVariable("id") String id) throws IOException {
        InputStreamResource inputStreamResource = imageService.download(id);


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("video/mp4"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")

                .body(inputStreamResource);
    }


}
