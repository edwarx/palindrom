package com.edward.palindrome.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PalindromeGenerator {

    public String generate(String string) {
        String result;
        //Generate map with different characters and their frequencies
        Map<Character, Integer> characters = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (!characters.containsKey(string.charAt(i))) {
                characters.put(string.charAt(i), 1);
            } else {
                characters.put(string.charAt(i), characters.get(string.charAt(i)) + 1);
            }
        }

        //Add all the characters with frequencies > 2 the number of times they are repeated in pairs, a char that is 3 times will be added once, another that is 4 times will be added twice, etc.
        StringBuilder palindrome = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
                for (int i = 0; i < (entry.getValue() / 2); i++) {
                    palindrome.append(entry.getKey());
                }
            }
            // If there is no possibility of creating a palindrome, it will return the first character of the string
            if (palindrome.length() == 0) {
                result = string.substring(0, 1);
            } else {
                //Mirror the previous string to generate the palindrome.
                StringBuilder reversed = new StringBuilder(palindrome.toString());
                palindrome.append(reversed.reverse().toString());

                //Add one character with frequency an odd frequency
                for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
                    if (entry.getValue() % 2 == 1) {
                        palindrome.insert(palindrome.length() / 2, entry.getKey());
                        break;
                    }
                }
                result = palindrome.toString();
            }
        return result;
    }
}
