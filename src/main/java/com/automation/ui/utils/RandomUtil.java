package com.automation.ui.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class RandomUtil {

    @SneakyThrows
    public int getRandomNumber(int maxDigit) {
        return SecureRandom.getInstanceStrong().nextInt(maxDigit);
    }

    public List<Integer> getEvenNumbersFromFibonacci(int limit) {
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