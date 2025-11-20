package Ques6;
public class NumberPrinter {

    private static final Object lock = new Object();
    private static int currentNumber = 1;
    private static final int MAX = 100;

    static class OddPrinter implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    while (currentNumber <= MAX) {
                        while (currentNumber % 2 == 0) {
                            if (currentNumber > MAX) {
                                return;
                            }
                            lock.wait();
                        }

                        if (currentNumber <= MAX) {
                            System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                            currentNumber++;

                            lock.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Odd thread interrupted.");
            }
        }
    }

    static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    while (currentNumber <= MAX) {
                        while (currentNumber % 2 != 0) {
                            if (currentNumber > MAX) {
                                return;
                            }
                            lock.wait();
                        }

                        if (currentNumber <= MAX) {
                            System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                            currentNumber++;

                            lock.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Even thread interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting Odd/Even printing sequence (1-100)...");

        OddPrinter oddPrinter = new OddPrinter();
        EvenPrinter evenPrinter = new EvenPrinter();

        Thread oddThread = new Thread(oddPrinter, "OddThread");
        Thread evenThread = new Thread(evenPrinter, "EvenThread");

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }

        System.out.println("Printing complete.");
    }
}