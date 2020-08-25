package com.edward.palindrome.service;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeGeneratorTest {

    private PalindromeGenerator palindromeGenerator;

    @BeforeEach
    public void setUp() {
        palindromeGenerator = new PalindromeGenerator();
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void shouldReturnCorrectPalindrome(String original, String expected) {
        String palindrome = palindromeGenerator.generate(original);

        assertEquals(expected, palindrome);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("A", "A"),
                Arguments.of("AAB", "ABA"),
                Arguments.of("CAABB", "ABCBA"),
                Arguments.of("AAAAABB", "AABABAA"),
                Arguments.of("ABCD", "A")
        );
    }
}