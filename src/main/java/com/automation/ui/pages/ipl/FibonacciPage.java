package com.automation.ui.pages.ipl;

import java.util.ArrayList;
import java.util.List;

public class FibonacciPage {

    public List<Integer> fibonacciEvenNumbers(int limit) {
        List<Integer> evenFibonacciNumbers = new ArrayList<>();

        int a = 0;
        int b = 1;
        int fibonacciNumber = a + b;

        while (fibonacciNumber <= limit) {
            if (fibonacciNumber % 2 == 0) {
                evenFibonacciNumbers.add(fibonacciNumber);
            }

            a = b;
            b = fibonacciNumber;
            fibonacciNumber = a + b;
        }
        return evenFibonacciNumbers;
    }
}
