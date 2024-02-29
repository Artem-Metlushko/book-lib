package com.metlushko.userservice.dto;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;
@Builder
public record BookDto(String name,

                      String author,

                      String description,

                      MultipartFile imageFile

) {
}
