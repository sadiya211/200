import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Choices: 1 = Rock, 2 = Paper, 3 = Scissors
        String[] choices = {"Rock", "Paper", "Scissors"};

        while (true) {
            System.out.println("Choose: 1 for Rock, 2 for Paper, 3 for Scissors, 4 to Exit");
            int userChoice = scanner.nextInt();

            if (userChoice == 4) {
                System.out.println("Thank you for playing!");
                break;
            }

            if (userChoice < 1 || userChoice > 4) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;

            System.out.println("You chose: " + choices[userChoice - 1]);
            System.out.println("Computer chose: " + choices[computerChoice - 1]);

            // Determine the winner
            if (userChoice == computerChoice) {
                System.out.println("It's a tie!");
            } else if ((userChoice == 1 && computerChoice == 3) || 
                       (userChoice == 2 && computerChoice == 1) || 
                       (userChoice == 3 && computerChoice == 2)) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        }
    }
}
