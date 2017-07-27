import java.util.Scanner;
import java.util.Random;

/**
 * File: Lottery.java
 * Author: William Crutchfield
 * Date: February 7, 2016
 * Description: Plays a set of pick-3, pick-4, or pick-5 lottery games.
 * Then, calculates the sum of all pick numbers generated.
 */
public class Lottery {
    public static void main(String[] args) {
        Random randomGen = new Random();        // random number generator
        Scanner input = new Scanner(System.in); // takes user input

        // Variables
        final int MAX_GAMES = 10;   // Max number of picks
        final int MAX_PICK = 9;     // Max number for each pick
        int sum = 0;                // Sum of all pick numbers

        // Lotto Pick numbers
        int pickOne;
        int pickTwo;
        int pickThree;
        int pickFour;
        int pickFive;


        // Question 1 Variables
        boolean repeatQ1 = true;    // loop var
        String decision1;           // input string

        //Question 2 Variables
        boolean repeatQ2 = true;    // loop var
        int pickAmount = 0;         // number of picks
        String decision2;           // input string

        //Question 3 Variables
        boolean repeatQ3 = true;    // loop var
        int inputQ3;                // input int
        int numOfGames = 0;         // number of games to play

        // Welcome Note
        System.out.println("Welcome to The Lottery Simulator!\n");

        //Question 1
        System.out.println("Do you wish to make lottery game selections? Input Y for yes, or N for no");

        while (repeatQ1) {
            decision1 = input.nextLine();   // Takes input
            switch (decision1) {
                case "y":                       // if yes, breaks loop, continues on to question 2
                case "Y":
                    repeatQ1 = false;
                    System.out.println("");
                    break;

                case "n":                       // if no, program exits
                case "N":
                    repeatQ1 = false;
                    System.out.println("\nThe program will now exit.");
                    System.exit(1);
                    break;

                default:                        // if invalid input, alert user, try again
                    System.out.println("Invalid input. Please enter again.");
            }
        }

        //Question 2
        System.out.println("Which lottery game do you want to play?");
        System.out.println("Enter 3 for pick-3, 4 for pick-4, 5 for pick-5");

        while (repeatQ2) {
            decision2 = input.nextLine();       // Takes input
            switch (decision2) {
                case "3":                           // if 3, breaks loop, changes pickAmount to 3
                    repeatQ2 = false;
                    pickAmount = pickAmount + 3;
                    System.out.println("");
                    break;

                case "4":                           // if 4, breaks loop, changes pickAmount to 4
                    repeatQ2 = false;
                    pickAmount = pickAmount + 4;
                    System.out.println("");
                    break;

                case "5":                           // if 5, breaks loop, changes pickAmount to 5
                    repeatQ2 = false;
                    pickAmount = pickAmount + 5;
                    System.out.println("");
                    break;

                default:                            // if invalid input, alert user, try again
                    System.out.println("Invalid input. Please enter again.");
                    break;
            }
        }

        //Question 3
        System.out.println("How many games would you like to play?");
        while (repeatQ3) {
            inputQ3 = input.nextInt();      // Takes input
            if (inputQ3 <= MAX_GAMES) {     // if input is less than MAX_GAMES
                numOfGames = inputQ3;       // use input for generating pick numbers
                repeatQ3 = false;           // break loop
            }
            System.out.println("Invalid input. Please enter again.");
        }

        //Generate Numbers
        System.out.println("\nThank you! The numbers randomly generated were: \n");

        // Assigns random numbers to picks, loops for numOfGames times
        while (numOfGames > 0) {
            if (pickAmount == 3) {
                pickOne = randomGen.nextInt(MAX_PICK + 1);
                pickTwo = randomGen.nextInt(MAX_PICK + 1);
                pickThree = randomGen.nextInt(MAX_PICK + 1);
                sum = sum + pickOne + pickTwo + pickThree;
                System.out.println("" + pickOne + pickTwo + pickThree);
            } else if (pickAmount == 4) {
                pickOne = randomGen.nextInt(MAX_PICK + 1);
                pickTwo = randomGen.nextInt(MAX_PICK + 1);
                pickThree = randomGen.nextInt(MAX_PICK + 1);
                pickFour = randomGen.nextInt(MAX_PICK + 1);
                sum = sum + pickOne + pickTwo + pickThree + pickFour;
                System.out.println("" + pickOne + pickTwo + pickThree + pickFour);
            } else if (pickAmount == 5) {
                pickOne = randomGen.nextInt(MAX_PICK + 1);
                pickTwo = randomGen.nextInt(MAX_PICK + 1);
                pickThree = randomGen.nextInt(MAX_PICK + 1);
                pickFour = randomGen.nextInt(MAX_PICK + 1);
                pickFive = randomGen.nextInt(MAX_PICK + 1);
                sum = sum + pickOne + pickTwo + pickThree + pickFour + pickFive;
                System.out.println("" + pickOne + pickTwo + pickThree + pickFour + pickFive);
            }
            numOfGames--;
        }

        System.out.println("\nThe sum of each individually selected number is: " + sum);
        System.out.println("The program will now exit. Thank you for playing!");
    }
}