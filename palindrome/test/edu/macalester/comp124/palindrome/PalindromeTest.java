package edu.macalester.comp124.palindrome;

import org.junit.Test;
import src.edu.macalester.Palindrome;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PalindromeTest {

    @Test
	public void testPalindrome1() {
        // After you finish, you should be able to uncomment these lines and pass the test.
        Palindrome pal = new Palindrome();
        assertTrue(pal.isPalindrome("racecar"));
        assertFalse(pal.isPalindrome("racecarz"));
        assertTrue(pal.isPalindrome("A man, a plan, a canal. Panama!"));
        assertTrue(pal.isPalindrome("Racecar"));
	}
	
	/*
	 * Write your own test methods below to test for fancier palindromes.
	 * Like the method above, each method be preceded by @Test
	 */
}
