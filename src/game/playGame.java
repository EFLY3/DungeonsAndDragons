package game;
import java.util.Scanner;

public class playGame {
 public static void main(String[] args)
 {
	 Scanner scan = new Scanner(System.in);
	 String continueGame = "y";
	do {
		Game game = new Game();
		game.run();
		System.out.println("Would you like to play again? Press y for yes, anything else for no.");
		continueGame = scan.nextLine();
		} while (continueGame == "Y" || continueGame == "y");
	 	scan.close();
 }
}