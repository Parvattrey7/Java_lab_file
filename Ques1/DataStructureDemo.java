package Ques1;
public class DataStructureDemo {

    public static void main(String[] args) {
        int integerValue = 25;
        double doubleValue = 10.5;
        boolean booleanValue = true;
        char characterValue = 'A';

        System.out.println("Data Types Demonstration");
        System.out.println("Integer Value: " + integerValue);
        System.out.println("Double Value: " + doubleValue);
        System.out.println("Boolean Value: " + booleanValue);
        System.out.println("Character Value: " + characterValue);
        System.out.println();

        System.out.println("If-Else Demonstration");
        if (integerValue > 30) {
            System.out.println("The integer value is greater than 30.");
        } else if (integerValue == 25) {
            System.out.println("The integer value is exactly 25.");
        } else {
            System.out.println("The integer value is less than 30 and not equal to 25.");
        }
        System.out.println();

        System.out.println("Switch Demonstration");
        char grade = 'B';
        switch (grade) {
            case 'A':
                System.out.println("Excellent grade!");
                break;
            case 'B':
                System.out.println("Good grade!");
                break;
            case 'C':
                System.out.println("Passing grade.");
                break;
            default:
                System.out.println("Needs improvement.");
        }
        System.out.println();

        System.out.println("For Loop Demonstration (Count 1 to 5)");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        System.out.println();

        System.out.println("While Loop Demonstration (Countdown from 3)");
        int count = 3;
        while (count > 0) {
            System.out.println("Countdown: " + count);
            count--;
        }
    }
}