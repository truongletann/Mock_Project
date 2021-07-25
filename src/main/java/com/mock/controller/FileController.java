package com.mock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("upload")
    public Object upload(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String userDirectory = Paths.get("").toAbsolutePath().toString();
            Path filePath = Paths.get(userDirectory + uploadDir);
            if(!Files.exists(filePath)){
                Files.createDirectories(filePath);
            }
            Path path = Paths.get(userDirectory + uploadDir + fileName);
            Files.write(path, file.getBytes());
            return new ResponseEntity<Object>(fileName, HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }
}
