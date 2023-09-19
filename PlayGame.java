/**
 *
 * @author 6310944
 * Title: Challenge #5 - Hangman
 * Semester: COP2210 - Spring 2022
 * Professor's Name: Prof. Charters
 *
 * Description of Program’s Functionality: This program demonstrates the use of a driver and domain class,
 * do-while loops, setters, getters, objects, constructors, and more. The main logic of the program is to let the
 * user make guesses with letters to try and guess the full word. The program gives the user a set amount of chances
 * to guess the correct answer, just like a true game of hangman.
 *
 */

import java.util.Scanner;
public class PlayGame { // driver
    public static int gamesWon = 0;
    public static int gamesLost = 0;

    /**
     * This method is the main method. This method
     *
     * @param (args) The parameter "args" is an array of strings that stores arguments in a method. This is
     * used since this is the main method and there are arguments that the user inputs in order to get the program
     * to function correctly.
     * Preconditions: This method needs the variables and data that was stored in the Hangman class
     * Post Conditions: This method needs to give the data to the processGuesses, determineWinner,
     *                  and summarize methods.
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String playAgain = ""; // used a string because the boolean confused me

        do {
            Hangman aGame = new Hangman();
            processGuesses(aGame);
            determineWinner(aGame);
            System.out.println("Would you like to play again? (yes/no)");
            playAgain = keyboard.nextLine();
        } while (playAgain.equalsIgnoreCase("yes"));
        summarize();
    }

    /**
     * This method is the "processGuesses" method. This method processes the guesses that the user makes and considers
     * them correct or incorrect. If correct, this method will replace the underscore with the guessed letter until
     * the user gets the correct word.
     *
     * @param (aGame) This parameter allows this method to receive the secret word and format of the guesses.
     * Preconditions: This method needs the info stored in the hangman class and guesses from the user.
     * Post Conditions: This method needs to properly place the user's letter guesses in the correct location of
     *                that letter in the secret word.
     */
    public static void processGuesses(Hangman aGame)
    {
        Scanner keyboard = new Scanner(System.in);
        int secretWordLength = aGame.getSecretWord().length();
        int chances = 3 * secretWordLength;
        int usedChances = 0;
        int loc = -1;
        String partA, partB;

        while (usedChances < chances && !(aGame.getUserGuess().equalsIgnoreCase(aGame.getSecretWord())))
        {
            loc = -1;
            String letter;
            
            System.out.println("\nEnter a letter to guess the secret word: ");
            letter = keyboard.nextLine();
            usedChances++;

            do
            {
                loc++;
                loc = aGame.getSecretWord().indexOf(letter, loc);

                if (loc != -1)
                {
                    partA = aGame.getUserGuess().substring(0, loc);
                    partB = aGame.getUserGuess().substring(loc + 1);
                    aGame.setUserGuess(partA + letter + partB );

                }
            } while (loc != -1);
            System.out.println(aGame.getUserGuess());
        }

    }

    /**
     * This method is the "determineWinner" method. This method determines whether the user has guessed the correct
     * word or ran out of chances. It displays the result to the user, then asking if they want to play again or not.
     *
     * @param (aGame) This parameter allows this method to receive the secret word and format of the guesses.
     * Preconditions: This method needs the info stored in the hangman class and result of the guesses from the user.
     * Post Conditions: This method needs to correctly display the results of the user's hangman game.
     */
    public static void determineWinner(Hangman aGame)
    {
        if (aGame.getUserGuess().equalsIgnoreCase(aGame.getSecretWord())) {
            System.out.println("\nCongrats, you guessed the word correctly!");
            gamesWon++;
        }
        else {
            System.out.println("\nYou ran out of chances.");
            gamesLost++;
        }

    }

    /**
     * This method is the "summarize" method. This method simply prints out how many games the user has lost and won.
     *
     * Preconditions: This method needs the gamesWon and gamesLost variables from the previous method.
     * Post Conditions: This method needs to correctly display the games lost and won to the user.
     */
    public static void summarize()
    {
        System.out.println("\nYou won " + gamesWon + " game(s).");
        System.out.println("You lost " + gamesLost + " game(s).");
    }


}
