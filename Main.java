package com.company;
import java.util.Arrays;

public class Main {
    public static void main(String [] args){
        System.out.println("Welcome to the raffle! Please enter 5 numbers from 1 to 50 to win an exciting prize! Please divide the numbers with a space.");
        Game game = new Game();
        int[] chosenNumbers = game.askForNumbers();
        System.out.println("Please see your numbers: "+Arrays.toString(chosenNumbers));
        int[] winningNumbers = game.chooseNumbers();
        System.out.println("Please see the winning numbers: "+Arrays.toString(winningNumbers));
        int[] matchingNumbers = game.checkTheMatchingNumbers();
        if(matchingNumbers.length>0){
            System.out.println("Please see the matching numbers: "+Arrays.toString(matchingNumbers));
        }else{
            System.out.println("Zero matching numbers :(");
        }
        game.displayTheMessage();
    }}