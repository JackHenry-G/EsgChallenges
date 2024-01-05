package com.esg;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple App.
 */
public class StringCalculatorTest {

    public static StringCalculator stringCalculator;

    @BeforeClass
    public static void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testAdditionWithEmptyString() {
        String input = "";

        assertEquals(0, stringCalculator.add(input));
    }

    @Test
    public void testAdditionWithOneNumberString() {
        String input = "1";

        assertEquals(1, stringCalculator.add(input));
    }

    @Test
    public void testAdditionWithTwoNumbersString() {
        String input = "1,2";

        assertEquals(3, stringCalculator.add(input));
    }

    @Test
    public void testAdditionWithUnknownNumbersString() {
        String input = "1,2,3,4";

        assertEquals(10, stringCalculator.add(input));
    }

    @Test
    public void testAdditionWithCommaDelimeter() {
        String input = "1\n2,3";

        assertEquals(6, stringCalculator.add(input));
    }

    @Test
    public void testAdditionWithUserDefinedDelimeter() {
        String input = "//;\n1;2";

        assertEquals(3, stringCalculator.add(input));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAddWithNegativeNumbers() {
        thrown.expect(IllegalArgumentException.class);
        // you can test the exception message like
        thrown.expectMessage("Negatives not allowed: -4, -5");

        stringCalculator.add("2,-4,3,-5");
    }

    @Test
    public void testAddWithNumberGreaterThan1000() {
        String input = "1001,2";

        assertEquals(2, stringCalculator.add(input));

        String input2 = "1001,2,1";
        assertEquals(3, stringCalculator.add(input2));
    }

    @Test
    public void testAddWithDelimeterOfAnyLength() {
        String input = "//[|||]\n1|||2|||3";

        assertEquals(6, stringCalculator.add(input));
    }

    @Test
    public void testAddWithMultipleCustomDelimiters() {
        String input = "//[|][%]\n1|2%3";
        assertEquals(6, stringCalculator.add(input));

    }

    @Test
    public void testAddWithMultipleCustomDelimitersOfAnyLength() {
        String input = "//[||||][%][***&&&]\n1|2%3";
        assertEquals(6, stringCalculator.add(input));

    }

}
