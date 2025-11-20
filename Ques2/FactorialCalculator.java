package Ques2;
public class FactorialCalculator {

    public static long calculateFactorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long calculateFactorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        int number = 5;

        long iterativeResult = calculateFactorialIterative(number);
        System.out.println("Factorial of " + number + " (Iterative): " + iterativeResult);

        long recursiveResult = calculateFactorialRecursive(number);
        System.out.println("Factorial of " + number + " (Recursive): " + recursiveResult);
    }
}