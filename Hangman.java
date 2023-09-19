import java.util.Random;
public class Hangman { // domain

    private String secretWord;
    private String userGuess;

    public Hangman() // default constructor
    {
        Random myRan = new Random();
        int ranNum = myRan.nextInt(1,6);

        if (ranNum == 1)
        {
            this.secretWord = "movies";
        }
        else if (ranNum == 2)
        {
            this.secretWord = "sunset";
        }
        else if (ranNum == 3)
        {
            this.secretWord = "music";
        }
        else if (ranNum == 4)
        {
            this.secretWord = "candy";
        }
        else if (ranNum == 5)
        {
            this.secretWord = "blue";
        }

        int numLetters = secretWord.length();
        userGuess = "";
        for (int i = 0; i < numLetters; i++)
        {
            System.out.println("");
            userGuess = userGuess + "_";
        }
    }

    // getters
    public String getSecretWord() {
        return secretWord;
    }

    public String getUserGuess() {
        return userGuess;
    }

    // setters
    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }
}
