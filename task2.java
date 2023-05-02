import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 5;
        int round = 1;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("You have " + numberOfAttempts + " attempts to guess the number between " + minRange + " and " + maxRange + ".");

        while (true) {
            // Generate random number
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            System.out.println("\nRound " + round + " - Guess the Number:");
            for (int i = 1; i <= numberOfAttempts; i++) {
                System.out.print("Attempt " + i + ": ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + i + " attempts.");
                    int points = numberOfAttempts - i + 1;
                    score += points;
                    System.out.println("You earned " + points + " points in this round.");
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("The number is higher.");
                } else {
                    System.out.println("The number is lower.");
                }

                if (i == numberOfAttempts) {
                    System.out.println("Sorry, you have used up all your attempts. The number was " + randomNumber + ".");
                }
            }

            System.out.print("\nDo you want to play another round? (Y/N): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("N")) {
                System.out.println("Thanks for playing Guess the Number!");
                System.out.println("Your final score is " + score + ".");
                break;
            } else {
                round++;
            }
        }
    }
}
