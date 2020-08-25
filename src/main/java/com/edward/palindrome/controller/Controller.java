package com.edward.palindrome.controller;

import com.edward.palindrome.service.PalindromeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class Controller {

    private PalindromeGenerator palindromeGenerator;

    @Autowired
    public Controller(PalindromeGenerator palindromeGenerator) {
        this.palindromeGenerator = palindromeGenerator;
    }

    @GetMapping(path = "/palindrome")
    public String palindrome(@PathParam(value = "word")String word) {
        return palindromeGenerator.generate(word);
    }
}
