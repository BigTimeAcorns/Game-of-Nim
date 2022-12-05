import java.util.Random;
import java.util.Scanner;
 
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
 
    while (true) {
      System.out.print("Do you want to play? (y/n) ");
      String answer = scanner.nextLine();
      if (answer.equalsIgnoreCase("n")) {
        break;
      }
 
      int pileSize = random.nextInt(41) + 10;
      System.out.println("Starting game with " + pileSize + " pieces in the pile");
 
      while (pileSize > 0) {
        System.out.println("There are " + pileSize + " pieces in the pile");
        System.out.println("Choose how many pieces to take (1-" + (pileSize / 2) + "): ");
        int piecesToTake = Integer.parseInt(scanner.nextLine());
 
        while (piecesToTake < 1 || piecesToTake > pileSize / 2) {
          System.out.println("Invalid input. Please choose a number between 1 and " + (pileSize / 2));
          piecesToTake = Integer.parseInt(scanner.nextLine());
        }
 
        pileSize -= piecesToTake;
      }
 
      System.out.println("You lose!");
    }
  }
}
