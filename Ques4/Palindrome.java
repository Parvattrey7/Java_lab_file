package Ques4;
public class Palindrome
{
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;      
            }
            i++;
            j--;
        }
        return true;       
    }

    public static void main(String[] args) {
        
        String s1 = "Level";
        String s2 = "Honest";

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (isPalindrome(s1)) {
            System.out.println("\"" + s1 + "\" is a palindrome.");
        } else {
            System.out.println("\"" + s1 + "\" is not a palindrome.");
        }

        if (isPalindrome(s2)) {
            System.out.println("\"" + s2 + "\" is a palindrome.");
        } else {
            System.out.println("\"" + s2 + "\" is not a palindrome.");
        }
    }
}