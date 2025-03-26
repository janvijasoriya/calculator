package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        if (args.length != 3) {
            logger.error("Usage: java App <num1> <operation> <num2>");
            System.out.println("Usage: java App <num1> <operation> <num2>");
            return;
        }

        try {
            double num1 = Double.parseDouble(args[0]);
            String operation = args[1].trim().toLowerCase();
            double num2 = Double.parseDouble(args[2]);

            logger.info("Welcome to the Calculator!");
            calculate(num1, num2, operation);
            logger.info("Calculator session ended.");
        } catch (NumberFormatException e) {
            logger.error("Invalid number format: {}", e.getMessage());
            System.out.println("Error: Invalid number format");
        }
    }

    private static void calculate(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
            case "add":
                logger.info("{} + {} = {}", num1, num2, num1 + num2);
                System.out.println(num1 + num2);
                break;
            case "-":
            case "subtract":
                logger.info("{} - {} = {}", num1, num2, num1 - num2);
                System.out.println(num1 - num2);
                break;
            case "*":
            case "multiply":
                logger.info("{} * {} = {}", num1, num2, num1 * num2);
                System.out.println(num1 * num2);
                break;
            case "/":
            case "divide":
                if (num2 == 0) {
                    logger.error("Error: Division by zero!");
                    System.out.println("Error: Division by zero");
                } else {
                    logger.info("{} / {} = {}", num1, num2, num1 / num2);
                    System.out.println(num1 / num2);
                }
                break;
            default:
                logger.error("Invalid operation! Use: +, -, *, / or add, subtract, multiply, divide");
                System.out.println("Error: Invalid operation");
        }
    }
}