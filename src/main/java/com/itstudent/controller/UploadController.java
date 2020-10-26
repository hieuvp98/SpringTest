package com.itstudent.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("api/public/files")
public class UploadController {
    
    @Value("${file.upload.location}")
    private String location;

    @PostMapping
    public ResponseEntity<Object> upload(
            @RequestParam("files") MultipartFile[] files) throws Exception{
        Path folder = Paths.get(location); // lấy thư mục upload
        for (MultipartFile file : files) { // duyệt tất cả file
            // copy data từ multipart file -> file mới
            Files.copy(file.getInputStream(),
                    folder.resolve(file.getOriginalFilename()));// tạo file
        }
        return ResponseEntity.noContent().build();
    }
}
