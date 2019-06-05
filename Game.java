package com.company;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    int chosenNumbers = 5;
    int chosenNumber;
    String numbers;
    int[] cupponNums = new int[chosenNumbers];
    int[] raffleNums = new int[chosenNumbers];
    int[] matchingNums = new int[chosenNumbers];
    int howManyMatches = 0;
    int arrayFlag=0;


    public int[] askForNumbers(){
        try {
            Scanner in = new Scanner(System.in);
            numbers = in.nextLine();
            String[] playersNumbers = (numbers.split(" "));
            int[] intPlayersNumbers = new int[playersNumbers.length];

        for(int a =0; a<playersNumbers.length; a++ ){
            intPlayersNumbers[a] = Integer.parseInt(playersNumbers[a]);
        }

        int flag = 0;

        if(intPlayersNumbers.length != chosenNumbers){
            System.out.println("Please enter 5 numbers.");
            askForNumbers();
        }else{
            for(int i = 0; i<intPlayersNumbers.length; i++){
                if(intPlayersNumbers[i]<50 && intPlayersNumbers[i]>0){
                    flag++;
                }else{
                    System.out.println("Please enter 5 nums from 1 to 50.");
                    askForNumbers();
                }
            }
        }

        //checking if there are no duplictaes
            int duplicateFlag = 0;
            for(int t =0; t<intPlayersNumbers.length; t++) {
                for (int b = 0; b < intPlayersNumbers.length; b++) {
                    if (intPlayersNumbers[t] == intPlayersNumbers[b]) {
                        duplicateFlag++;
                    }
                }
                }
            if (duplicateFlag > chosenNumbers) {
                System.out.println("Please enter the numbers again, no duplicates this time!");
                duplicateFlag = 0;
                askForNumbers();
            }

        if(flag==chosenNumbers){
            cupponNums = intPlayersNumbers;
        }
        }catch(NumberFormatException ex){
            System.out.println("Please input only numbers!");
            askForNumbers();
        }
        Arrays.sort(cupponNums);
        return cupponNums;
    }

    //Choosing 5 random numbers from 1 to 50.
    public int[] chooseNumbers(){
        for(int i=0; i<chosenNumbers; i++){
            chosenNumber = (int)(Math.random()*49)+1;
            raffleNums[i] = chosenNumber;
        }
        int duplicateFlag = 0;
        for(int t =0; t<raffleNums.length; t++){
            for(int b = 0; b<raffleNums.length; b++){
                if(raffleNums[t]==raffleNums[b]) {
                    duplicateFlag++;
                }
            }
            if(duplicateFlag>chosenNumbers){
                chooseNumbers();
            }
        }
        Arrays.sort(raffleNums);
        return raffleNums;
    }



    public int[] checkTheMatchingNumbers(){
        for(int i = 0; i < raffleNums.length; i++){
            for(int y =0; y< cupponNums.length; y++){
                if(raffleNums[i] == cupponNums[y]){
                    matchingNums[i] = raffleNums[i];
                    howManyMatches++;
                }
            }
        }

        int[] matchesArray = new int[howManyMatches];
        for(int z= 0; z< matchingNums.length; z++){
            if(matchingNums[z]>0){
                matchesArray[arrayFlag] = matchingNums[z];
                arrayFlag++;
            }
        }
        Arrays.sort(matchesArray);
        return matchesArray;
    }

    public void displayTheMessage(){
        switch (arrayFlag){
            case 0:
                System.out.println("No luck this time! Please try again!");
                break;
            case 1:
                System.out.println("Congratulations! One matching numbers, you have won $20.");
                break;
            case 2:
                System.out.println("Congratulations! Two matching numbers, you have won $100.");
                break;
            case 3:
                System.out.println("Congratulations! Three matching numbers, you have won $1000.");
                break;
            case 4:
                System.out.println("Congratulations! Four matching numbers, you have won $50000.");
                break;
            case 5:
                System.out.println("Congratulations! Five matching numbers , you have won $10000000.");
                break;
            default:
                System.out.println("Please try again.");
    }
}}
