package com.SakubDev;

import java.util.Scanner;

public class Main {

    public static int randomNumber;
    public static byte numberOfTries;
    public static int userGuess;
    public static void main(String[] args) {
        System.out.println("<<<Welcome in Guess the Number Game!>>>");
        System.out.println("<<<Try to guess number from 1 to 100!>>>");
        randomNumber = (int)(Math.random() * 100);
        numberOfTries = 1;

        game();
        System.out.println("You won! It took: "+numberOfTries+" tries");
        System.out.println("\n\n\n<<<Made by SakubDev>>>");
    }
    public static void game() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Try to guess: ");
        try{
            userGuess = scanner.nextInt();
        }catch (java.util.InputMismatchException e){
            System.out.println("Error! Number is too large or your guess is not a number!");
            game();
        }
        while (userGuess != randomNumber){
            if (userGuess > randomNumber){
                System.out.println("Too high!");
                numberOfTries++;
                game();
            }
            else if (userGuess < randomNumber){
                System.out.println("Too low!");
                numberOfTries++;
                game();
            }
        }
    }
}
