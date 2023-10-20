import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2;

            System.out.println("You rolled a " + die1 + " and a " + die2 + " for a total of " + crapsRoll);

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Craps! You lose.");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = crapsRoll;
                System.out.println("Point is " + point);
                boolean tryingForPoint = true;

                while (tryingForPoint) {
                    int newDie1 = rnd.nextInt(6) + 1;
                    int newDie2 = rnd.nextInt(6) + 1;
                    int newRoll = newDie1 + newDie2;

                    System.out.println("You rolled a " + newDie1 + " and a " + newDie2 + " for a total of " + newRoll);

                    if (newRoll == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        tryingForPoint = false;
                    } else if (newRoll == point) {
                        System.out.println("You rolled your point. You win!");
                        tryingForPoint = false;
                    }
                }
            }

            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing!");
    }
}

