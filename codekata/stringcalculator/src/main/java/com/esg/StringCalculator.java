package com.esg;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that can process calculator based proccesses on string.
 *
 */
public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = "[,\n]";
    private static final int MAX_NUMBER = 1000;

    public int add(String input) {
        if (input == null || input.isEmpty()) { // if no string provided, the sum will be zero
            return 0;
        } else {
            // extract numbers as individuals from the string
            String[] individualNumbers = extractNumbers(input);

            // calculate the sum of the numbers
            return calculateSum(individualNumbers);
        }
    }

    private static int calculateSum(String[] numbersToSum) {
        // calculate sum of numbers
        int total = 0;
        for (String number : numbersToSum) {
            int numberAsInt = Integer.parseInt(number);
            if (numberAsInt < 0) {
                throw new IllegalArgumentException("Negatives not allowed: " + extractNegatives(numbersToSum));
            } else if (numberAsInt < MAX_NUMBER) {
                total += numberAsInt;
            }
        }
        return total;
    }

    private static String[] extractNumbers(String numbers) {
        if (numbers.startsWith("//")) { // custom delimeter
            String customDelimeters = findCustomDelimiters(numbers);

            // get everything after the delimiter definition
            numbers = numbers.substring(numbers.indexOf("\n") + 1);

            return numbers.split(customDelimeters);
        } else { // default delimiter
            return numbers.split(DEFAULT_DELIMITERS);
        }
    }

    private static String extractNegatives(String[] numbers) {
        // use regex to find all negative numbers in the string
        List<String> negativeNumbers = new ArrayList<String>();

        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                negativeNumbers.add(number);
            }
        }

        // return the negative numbers as a string message e.g -4, -5
        return String.join(", ", negativeNumbers);
    }

    private static String findCustomDelimiters(String numbers) {
        String customDelimeter = "";

        // find any delimiters defined in square brackets
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(numbers);
        List<String> customDelimeters = new ArrayList<>();
        while (matcher.find()) {
            // Extract the contents of the square brackets and escape any special characters
            customDelimeters.add(Pattern.quote(matcher.group(1)));
        }

        // check if any custom delimiteres were found in square brackets
        if (customDelimeters.isEmpty()) {
            // get the custom delimeter not defined in a square bracket e.g. //&
            // which is always at index 2
            customDelimeter = String.valueOf(numbers.charAt(2));
        } else if (customDelimeters.size() == 1) {
            // get the first, and only, custom delimiter found in a square bracket
            customDelimeter = customDelimeters.get(0);
        } else {
            // get all custom delimeters and define a regex pattern for them
            customDelimeter = "[" + String.join("", customDelimeters) + "]";
        }

        // return regex string for custom delimeters
        return customDelimeter;
    }
}
