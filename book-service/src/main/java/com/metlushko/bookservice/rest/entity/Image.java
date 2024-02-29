package com.metlushko.bookservice.rest.entity;

import lombok.Data;

@Data
public class Image {

    private String name;
    private String fileType;
    private byte[] file;
}
