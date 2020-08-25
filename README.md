Code is not ready for production, there are still error handling controls that need to be done like sending an empty string.

Space complexity is not easy to calculate is it will differ based on the number of different characters in the string sent.
Time complexity is 2n as it will iterate the string first to check the frequencies of the different characters and then the resulting map will be iterated to check how many times should a character be added to the palindrome.