package singletonpattren;

public class TestLogger {

    public static void main(String[] args) {
        // Retrieve singleton instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages using both instances
        logger1.log("First log message");
        logger2.log("Second log message");

        // Check if both instances are the same
        System.out.println("Are both instances same? " + (logger1 == logger2));
    }
}
