package com.SakubDev.guessthenumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String AUTHOR = "SakubDev and contributors";
    private static final int MIN = 1;
    private static final int MAX = 100;

    private void run() {
        Game game = new Game(MIN, MAX);

        System.out.println("<<<Welcome in Guess the Number Game!>>>");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            game.start();
            System.out.println("<<<Try to guess number from " + game.getMin() + " to " + game.getMax() + "!>>>");

            GuessResult result = null;
            while (result != GuessResult.EXACT) {

                Integer input = null;
                while (input == null) {
                    try {
                        input = Integer.parseInt(scanner.next());
                    } catch (NumberFormatException ex) {
                        System.out.println("Error! Number is too large or your guess is not a number! Type correct number.");
                    }
                }

                result = game.guess(input);

                if (result == GuessResult.BIGGER) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
            }

            System.out.println("You won! It took: " + game.getLastNumberOfTries() + " tries");

            System.out.println("Do you want to play one more time? Type yes or no.");
            Boolean next = null;
            while (next == null) {
                switch (scanner.next().toLowerCase()) {
                    case "yes": {
                        next = true;
                        break;
                    }

                    case "no": {
                        next = false;
                        break;
                    }

                    default: {
                        System.out.println("Wrong input, type yes or no.");
                    }
                }
            }

            if (!next) {
                running = false;
            }
        }
        System.out.println("\n\n\n<<<Made by " + AUTHOR + " >>>");
    }

    public static void main(String[] args) {
        new Main().run();
    }

}

