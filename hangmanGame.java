package hangman;
import java.util.Scanner;

public class hangmanGame {
	private static String[] words = {"onomatopoeia", "alligator", "Honda", "programmer", "lamp", "java" };
	private static String word = words[(int) (Math.random() * words.length)];
	private static String star = new String(new char[word.length()]).replace("\0", "*");
	private static int badGuess = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/**
		 * Loop that prompts the user to enter a letter
		 * while the badGuess counter is less than 7 and
		 * while the word still contains stars
		 */
		while (badGuess < 7 && star.contains("*")) {
			System.out.println("Guess any letter in the word");
			System.out.println(star);
			String guess = sc.next();
			hang(guess);
		}
		sc.close();
	}

	/**
	 * Traverses the worst and replaces each star (*) with the letter in word 
	 * that was randomly chosen
	 */
	public static void hang(String guess) {
		String newStar = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newStar += guess.charAt(0);
			} 
			else {
				if (star.charAt(i) != '*') {
				newStar += word.charAt(i);
			}
				else {
				newStar += "*";
			}
		   }
		}
		
		if (star.equals(newStar)) {
			badGuess++;
			gameBoard();
		} 
		else {
			star = newStar;
		}
		if (star.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}
	/**
	 * As the game continues, the badGuess counter increases with each incorrect guess
	 * further completing the hangman until it reaches a count of '7' which it
	 * then ends the game (hangman will also be complete). 
	 */
	public static void gameBoard() {
		if (badGuess == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (badGuess == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (badGuess == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (badGuess == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (badGuess == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (badGuess == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________"
			     +  "   |          _|_" 
			     +  "   |         /   \\" 
			     +  "   |        |     |" 
			     +  "   |         \\_ _/" 
			     +  "   |           |" 
			     +  "   |           |" 
			     +  "   |          / \\ " 
			     +  "___|___      /   \\" );
		}	
		if (badGuess == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________"
					+"   |          _|_"
					+"   |         /   \\"
					+"   |        |     |"
					+"   |         \\_ _/"
					+"   |          _|_"
					+"   |         / | \\"
					+"   |          / \\ "
					+"___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}
}