package Ques3;
public class SecondLargestFinder {

    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Error: Array must contain at least two elements.");
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x > largest) {
                secondLargest = largest;
                largest = x;
            } else if (x > secondLargest && x != largest) {
                secondLargest = x;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No distinct second largest element found.");
            return -1;
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] data1 = {10, 5, 20, 8, 15};
        System.out.print("Array: (");
        for (int i = 0; i < data1.length; i++) {
            System.out.print(data1[i] + (i < data1.length - 1 ? ", " : ""));
        }
        System.out.println(")");

        System.out.println("Second Largest Element Is :" + findSecondLargest(data1));
    }
}