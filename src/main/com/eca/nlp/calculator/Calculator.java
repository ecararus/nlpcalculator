package com.eca.nlp.calculator;

/**
 * Defines common behaviour for all sort o calculators.
 */
public interface Calculator<E> {

    <T> T calculate(E expression);

}


