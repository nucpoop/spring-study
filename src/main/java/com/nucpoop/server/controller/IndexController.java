package com.nucpoop.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        int i = 0;
        String temp = "";
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/test")
    public ResponseEntity<String> testApi(){
        return ResponseEntity.ok("test");
    }

    @GetMapping("/abcd")
    public ResponseEntity<String> abcd() {
        return ResponseEntity.ok("abcd");
    }

    @GetMapping("/temp")
    public ResponseEntity<String> temp() {
        return ResponseEntity.ok("temp");
    }
}
