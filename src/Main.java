import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Get player names
        System.out.print("Enter player 1's name: ");
        String player1 = scanner.nextLine();
        System.out.print("Enter player 2's name: ");
        String player2 = scanner.nextLine();

        // Initialize game variables
        int pileSize = random.nextInt(41) + 10; // Random number between 10 and 50
        int currentPlayer = random.nextInt(2) + 1; // Random starting player
        boolean gameOver = false;

        // Play game
        while (!gameOver) {
            // Print current game state
            System.out.println("Pile size: " + pileSize);
            if (currentPlayer == 1) {
                System.out.println("Current player: " + player1);
            } else {
                System.out.println("Current player: " + player2);
            }

            // Get player's move
            System.out.print("Enter number of pieces to take (1-" + (pileSize / 2) + "): ");
            int move = scanner.nextInt();

            // Validate player's move
            if (move < 1 || move > pileSize / 2) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            // Update game state
            pileSize -= move;
            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }
            gameOver = (pileSize == 1);
        }

        // Announce winner
        if (currentPlayer == 1) {
            System.out.println("Game over! " + player1 + " wins!");
        } else {
            System.out.println("Game over! " + player2 + " wins!");
        }

        // Offer to play again
}
}
