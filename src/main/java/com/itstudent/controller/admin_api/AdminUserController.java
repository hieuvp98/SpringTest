package com.itstudent.controller.admin_api;

import com.itstudent.repository.interfac.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/admin/users")
@RestController
@AllArgsConstructor
public class AdminUserController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }

}
