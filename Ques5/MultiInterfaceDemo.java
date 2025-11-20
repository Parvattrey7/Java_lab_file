package Ques5;
interface FirstInterface {
    void performActionOne();
}

interface SecondInterface {
    void performActionTwo();
}

class ImplementingClass implements FirstInterface, SecondInterface {
    public void performActionOne() {
        System.out.println("Executing method from FirstInterface.");
    }

    public void performActionTwo() {
        System.out.println("Executing method from SecondInterface.");
    }
}

public class MultiInterfaceDemo {
    public static void main(String[] args) {
        ImplementingClass myObject = new ImplementingClass();
        System.out.println("Demonstrating a single class implementing two interfaces:");
        myObject.performActionOne();
        myObject.performActionTwo();
    }
}