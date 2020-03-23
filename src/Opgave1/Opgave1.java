package Opgave1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Opgave1 extends Application{
    static TextArea text = new TextArea();
    @Override
    public void start(Stage stage) throws Exception {
        text.setWrapText(true);
//        // Create task
//        Runnable printA = new PrintChar('a', 10);
//        Runnable printB = new PrintChar('b', 10);
//        Runnable print100 = new PrintNum(10);
//
//        // Create threads
//        Thread thread1 = new Thread(printA);
//        Thread thread2 = new Thread(printB);
//        Thread thread3 = new Thread(print100);
//
//        // Start threads
//        thread1.start();
//        thread2.start();
//        thread3.start();

        // den vejledende løsning, den kan skrive flere tal før den laver out of bounds exception
        //men det er næsten umuligt at lave en lang tekst uden fejl
        Thread printA = new Thread(new PrintChar('a', 10));
        Thread printB = new Thread(new PrintChar('b', 10));
        Thread printNumber = new Thread(new PrintNum(10));

        printA.start();
        printB.start();
        printNumber.start();


        Scene scene = new Scene(text,300,300);
        stage.setTitle("Opgave 1");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args)  {
        launch(args);
    }

}

// The task for printing a specified character in specified times
class PrintChar implements Runnable {
    private char charToPrint; // The character to print
    private int times; // The times to repeat

    /** Construct a task with specified character and number of
     *  times to print the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override /** Override the run() method to tell the system
     *  what the task to perform
     */
    public void run() {
        for (int i = 0; i < times; i++) {
            Opgave1.text.appendText(String.valueOf(charToPrint + ""));
        }
    }
}

// The task class for printing number from 1 to n for a given n
class PrintNum implements Runnable {
    private int lastNum;

    /** Construct a task for printing 1, 2, ... i */
    public PrintNum(int n) {
        lastNum = n;
    }

    @Override /** Tell the thread how to run */
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            Opgave1.text.appendText(String.valueOf(i + ""));
        }
    }
}