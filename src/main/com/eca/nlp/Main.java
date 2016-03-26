package com.eca.nlp;

import java.util.Scanner;

public final class Main {

    public static void main(String[] args) {
        System.out.println("Please enter a calculation:");
        Scanner scanner = new Scanner(System.in);
        String op = scanner.next();
        System.out.println("Result:" + CalculatorInterface.calculate(op));
    }

}
