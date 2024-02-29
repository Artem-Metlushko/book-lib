package com.metlushko.bookservice.rest.dto;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;
@Builder
public record BookRequestDto(String name,

                             String author,

                             String description,

                             MultipartFile imageFile

) {
}
