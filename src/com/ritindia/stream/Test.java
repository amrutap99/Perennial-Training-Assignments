package com.ritindia.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* Java 8 stream methods
* Implementation of map(),filter(),collect()
* 1.map() is used to transform one object into other by applying a function.
* 2.filter() - filters and selects elements based upon a condition
* 3.collect() - collect to list
*
* */
public class Test {
    public static void main(String[] args) {

        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        List<Integer> even = numbers.stream()
                            .map(num -> Integer.valueOf(num)) //converting to int
                            .filter(evenNum -> evenNum %2==0)  //selecting stream of even condition satisfied values
                            .collect(Collectors.toList());     //collection list

        System.out.println(even);
    }
}
