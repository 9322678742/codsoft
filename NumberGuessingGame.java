import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("Guess the number between %d and %d%n", lowerBound, upperBound);

        boolean playAgain = true;

        while (playAgain) {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please guess within the specified range.");
                } else if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
            }

            System.out.println("Rounds won: " + roundsWon);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thank you for playing!");
    }
}
