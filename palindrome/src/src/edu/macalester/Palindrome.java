package src.edu.macalester;

import acm.program.ConsoleProgram;

/**
 * Created by Khanh-Long on 2/13/14.
 */
public class Palindrome
    extends ConsoleProgram
{
    public boolean isPalindrome(String s)
    {
        String cleanString = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        println(cleanString);
        int i1 = 0;
        int i2 = cleanString.length() - 1;
        while (i2 > i1)
        {

            if (cleanString.charAt(i1) != cleanString.charAt(i2))
            {
                return false;
            }
            i1++;
            i2--;
        }
        return true;
    }

    public void run()
    {
        print("Please enter a string:");
        String userInput = readLine();
        println("Palindrome?" + isPalindrome(userInput));

    }
}
