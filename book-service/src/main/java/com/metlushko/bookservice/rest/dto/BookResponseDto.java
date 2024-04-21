package com.metlushko.bookservice.rest.dto;

import lombok.Builder;

@Builder
public record BookResponseDto(String name,

                              String author,

                              String description,

                              String imageId

) {
}
