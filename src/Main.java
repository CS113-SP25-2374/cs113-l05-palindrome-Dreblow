import Palindrome.Palindrome;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String test1 = "racecar";
        String test2 = "level";
        String test3 = "civic";
        String test4 = "kayak";
        String test5 = "hello";
        String test6 = "java";

        String test7 = "A man a plan a canal Panama";
        String test8 = "No lemon, no melon";

        String[] testCases = {test1, test2, test3, test4, test5, test6, test7, test8};

        Palindrome testPalindrome = new Palindrome();

        for (String test : testCases) {
            System.out.println("Running test case: " + test);
            System.out.println("Is it a palindrome? " + testPalindrome.isPalindrome(test));
            System.out.println("");
        }
    }
};