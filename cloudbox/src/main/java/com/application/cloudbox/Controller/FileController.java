package com.application.cloudbox.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @GetMapping("test")
    private String test() {
        return "Hello World";
    }

    @PostMapping("upload-file")
    public String uploadFile(
            @RequestParam("file") MultipartFile file
            ) {
        MultipartFile temp = file;
        return "done";
    }

}
