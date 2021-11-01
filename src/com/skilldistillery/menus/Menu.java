package com.skilldistillery.menus;

import java.util.Scanner;

public abstract class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }


    /* ------------------------------------------------
        printInvalidEntry
    ------------------------------------------------ */
    protected void printInvalidEntry() {
        System.out.println("Invalid entry, try again please...\n");
    }


    /* ------------------------------------------------
        getNextInt
    ------------------------------------------------ */
    protected int getNextInt(String prompt) {
        int input;
        boolean hasNext;
        while (true) {
            System.out.print(prompt);

            hasNext = scanner.hasNextInt();
            if (hasNext) {
                input = scanner.nextInt();
                scanner.nextLine();

                break;

            } else {
                printInvalidEntry();
                scanner.nextLine();

            }
        }
        return input;
    }


    /* ------------------------------------------------
        getNextDouble
    ------------------------------------------------ */
    protected double getNextDouble(String prompt) {
        double input;
        boolean hasNext;
        while (true) {
            System.out.print(prompt);

            hasNext = scanner.hasNextDouble();
            if (hasNext) {
                input = scanner.nextDouble();
                scanner.nextLine();

                break;

            } else {
                printInvalidEntry();
                scanner.nextLine();

            }
        }

        return input;
    }

    
    /* ------------------------------------------------
        getNextLine
    ------------------------------------------------ */
    protected String getNextLine(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
                break;

            } else {
                printInvalidEntry();

            }
        }

        return input;
    }
}
