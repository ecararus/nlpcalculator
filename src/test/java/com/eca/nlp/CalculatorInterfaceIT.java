package com.eca.nlp;

import com.eca.nlp.kb.exception.UnknownLexicon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Integration Test for Calculator interface.
 * This test reflect user acceptance scenarios.
 */
public class CalculatorInterfaceIT {

    @Test(expected = UnknownLexicon.class)
    public void calculate_empty_expression() throws Exception {
        CalculatorInterface.calculate("");
    }

    @Test
    public void calculate_nine() throws Exception {
        executeTest("9", "nine");
    }

    @Test
    public void calculate_NINE_key_not_sensitive() throws Exception {
        executeTest("9", "NINE");
    }

    @Test(expected = UnknownLexicon.class)
    public void calculate_nine_plus() throws Exception {
        CalculatorInterface.calculate("nine plus");
    }

    @Test
    public void calculate_nine_over_eight_plus_four_times_two_divide_by_three() throws Exception {
        executeTest("3.79", "nine over eight plus four times two divide-by three");
    }

    @Test
    public void calculate_one_plus_two() throws Exception {
        executeTest("3", "one plus two");
    }

    @Test
    public void calculate_seven_times_eight_minus_nine() throws Exception {
        executeTest("47", "seven times eight minus nine");
    }

    @Test
    public void calculate_four_times_five_subtract_six_over_one_plus_nine() throws Exception {
        executeTest("23", "four times five subtract six over one plus nine");
    }

    @Test
    public void calculate_one_plus_two_times_three() throws Exception {
        executeTest("7", "one plus two times three");
    }

    @Test
    public void calculate_nine_minus_three_times_seven() throws Exception {
        executeTest("-12", "nine minus three times seven");
    }

    @Test
    public void calculate_four_minus_eight_plus_six_times_nine() throws Exception {
        executeTest("50", "four minus eight plus six times nine");
    }

    @Test
    public void calculate_seven_over_nine_plus_one() throws Exception {
        executeTest("1.78", "seven over nine plus one");
    }

    private void executeTest(String expectedValue, String expression) throws Exception {
        assertEquals(expectedValue, CalculatorInterface.calculate(expression));
    }
}