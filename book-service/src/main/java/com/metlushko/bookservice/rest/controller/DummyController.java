package com.metlushko.bookservice.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/dummy")
@RestController
public class DummyController {
    @GetMapping()
    public String getDummy() {
        return "Dummy";
    }
}
