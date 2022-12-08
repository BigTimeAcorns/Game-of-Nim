package src;

import javax.management.openmbean.CompositeType;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initializing
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String player1;
        int p1Points = 0;

        String player2;
        int p2Points = 0;

        boolean robot = false;

        String opt = "n";

        // Get player names
            System.out.println("Would you like to play against the computer? (y/n)");

            if (scanner.nextLine().equalsIgnoreCase("y")) {
                robot = true;
            }
            System.out.print("Enter player 1's name: ");
            player1 = scanner.nextLine();
            if (!robot) {
                System.out.print("Enter player 2's name: ");
                player2 = scanner.nextLine();
            } else {
                player2 = "Computer";
            }

            while(true){

            // Initialize game variables
            int pileSize = random.nextInt(41) + 10; // Random number between 10 and 50
            int currentPlayer;
            if(!robot){
                currentPlayer = random.nextInt(2) + 1; // Random starting player if there is no computer;
            }else{
                currentPlayer = 1;
            }
            boolean gameOver = false;

            System.out.println("Initial pile size: " + pileSize);
            // Play game
            while (!gameOver) {
                // Print current game state
                if (currentPlayer%2 == 1) {
                    System.out.println("Current player: " + player1);
                } else {
                    System.out.println("Current player: " + player2);
                }

                // Get player's move
                System.out.println("Enter number of pieces to take (1-" + pileSize / 2 + "): ");
                int move = scanner.nextInt();

                // Validate player's move
                if (move < 1 || move > pileSize / 2 && move != 1) {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }

                // Update game state
                pileSize -= move;

                currentPlayer++;

                gameOver = (pileSize == 1);

                System.out.println("Pile size: " + pileSize);

                if (robot && !gameOver) {
                    int c = (int) (Math.random() * (pileSize / 2) + 1);
                    pileSize -= c;
                    System.out.println("Computer chose " + c + " pieces. \nNew pile size is " + pileSize);
                    currentPlayer++;
                }
                gameOver = (pileSize == 1);
            }

            // Announce winner
            if (currentPlayer%2 == 1) {
                System.out.println("Game over! " + player1 + " wins!");
                p1Points++;
            } else {
                System.out.println("Game over! " + player2 + " wins!");
                p2Points++;
            }
                System.out.println(player1 + " is at " + p1Points + "\n" + player2 + " is at " + p2Points);
                System.out.print("Would you like to play again? (y/n)");
                // do not delete this line below . im serious ,
                scanner.nextLine();
                if(scanner.nextLine().equalsIgnoreCase("n")){
                    break;
                }
            }
        }
    }
