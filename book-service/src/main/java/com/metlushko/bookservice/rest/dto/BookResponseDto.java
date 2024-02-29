package com.metlushko.bookservice.rest.dto;

public record BookResponseDto(String name,

                              String author,

                              String description,

                              String imageId

) {
}
