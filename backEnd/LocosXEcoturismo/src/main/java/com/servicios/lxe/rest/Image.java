package com.servicios.lxe.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins="*")
public class Image {

    @Value("${upload.path}")
    private String path;
  
    @PostMapping("/image/upload")
    public ResponseEntity<Object> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

                         
         int rand = ThreadLocalRandom.current().nextInt(1,100);
         String fileName = Math.ceil(rand) + "_" + file.getOriginalFilename();
         InputStream is = file.getInputStream();

        Files.copy(is, Paths.get(path + fileName),
                StandardCopyOption.REPLACE_EXISTING);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("file", fileName));
        
    }
}