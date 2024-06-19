import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int playerScore = 0;
    private static int computerScore = 0;
    private static String gameHistory = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("Enter your name:");
        String playerName = scanner.nextLine();

        while (true) {

            System.out.println("Enter your choice (rock, paper, scissors): ");
            String playerChoice = scanner.nextLine().toLowerCase();


            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', or 'scissors'.");
                continue;
            }


            int computerChoice = random.nextInt(3);
            String computerChoiceStr = "";
            switch (computerChoice) {
                case 0:
                    computerChoiceStr = "rock";
                    break;
                case 1:
                    computerChoiceStr = "paper";
                    break;
                case 2:
                    computerChoiceStr = "scissors";
                    break;
            }

            System.out.println("Computer chose: " + computerChoiceStr);


            String result = determineWinner(playerChoice, computerChoiceStr);
            System.out.println(result);


            if (result.startsWith("You win!")) {
                playerScore++;
            } else if (result.startsWith("Computer wins!")) {
                computerScore++;
            }
            gameHistory += "You: " + playerChoice + ", Computer: " + computerChoiceStr + ", Result: " + result + "\n";


            System.out.println("Score - " + playerName + ": " + playerScore + ", Computer: " + computerScore);
            System.out.println("Game History:\n" + gameHistory);


            System.out.println("Play again? (yes/no)");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        scanner.close();
        System.out.println("Thanks for playing, " + playerName + "!");


        System.out.println("Final Score:");
        System.out.println("--------------");
        System.out.println("| You | Comp |");
        System.out.println("--------------");
        System.out.println("| " + playerScore + "   | " + computerScore + "    | ");
        System.out.println("--------------");
    }

    private static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if (
            (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
            (playerChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}