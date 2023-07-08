package com.automation.ui.pages.ipl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciPage {

    public List<Integer> fibonacciEvenNumbers() {
        int limit = 40;
        return Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .mapToInt(fib -> fib[0])
                .limit(limit)
                .filter(num -> num % 2 == 0)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
