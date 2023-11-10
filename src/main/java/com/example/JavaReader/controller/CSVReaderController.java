package com.example.JavaReader.controller;

import com.example.JavaReader.service.CSVReaderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
@Tag(description = "test",name = "test")
public class CSVReaderController {
//    private final CSVReaderService csvReaderService;

    @GetMapping("/get-file")
    private void getFile(){

    }
    private void createFile(){

    }

}
