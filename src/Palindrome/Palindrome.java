package Palindrome;

public class Palindrome {
    private ArrayListStack<Character> stack1;
    private ArrayListStack<Character> stack2;

    public Palindrome() {
        stack1 = new ArrayListStack<>();
        stack2 = new ArrayListStack<>();
    }

    /**
     * Break a stack into two, push the first half to one stack, then push
     * second half to a stack, then pop & push to a second stack.
     * If the string is odd, the middle element goes to both stacks (or neither!)
     * R A C E C A R
     * Stack 1: R A C E
     * Middle Letter: E
     * Stack 2: E C A R
     * Re-stack either the first or second stack and compare them.
     * @param s a string to test
     * @return true if they are the same
     */
    public boolean isPalindrome(String s) {
        // initialize and clear out the stacks
        stack1 = new ArrayListStack<>();
        stack2 = new ArrayListStack<>();

        // normalize the string
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // convert to character array
        char[] chars = s.toCharArray();
        int length = chars.length;
        int mid = length / 2;

        // push first half onto stack1
        for (int i = 0; i < mid; i++) {
            stack1.push(chars[i]);
        }
        System.out.println("stack1: " + stack1);

        // handle odd-length strings (ignore middle character)
        int startSecondHalf = (length % 2 == 0) ? mid : mid + 1;

        // push second half onto stack2 in reverse order
        for (int i = length - 1; i >= startSecondHalf; i--) {
            stack2.push(chars[i]);
        }
        System.out.println("stack2: " + stack2);

        // Compare both stacks
        while (!stack1.empty()) {
            if (!stack1.pop().equals(stack2.pop())) {
                return false; // Not a palindrome
            }
        }

        return true; // If all characters match, it's a palindrome
    }
}
