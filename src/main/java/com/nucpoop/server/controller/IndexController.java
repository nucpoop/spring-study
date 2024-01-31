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

    @GetMapping("/bye")
    public ResponseEntity<String> bye() {
        return ResponseEntity.ok("bye");
    }

}
