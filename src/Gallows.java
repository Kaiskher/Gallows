import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Gallows {
	Scanner scanner = new Scanner(System.in);
	String s = "";
	
	public static void main(String args[]) {
		Gallows game = new Gallows();				
		
		do {
			int fails = -1;
			game.newGame();
			Gibbet gibbet = new Gibbet();
			GuessWord guessWord = new GuessWord();	
			char currentChar;
			
			do {
				currentChar = game.inputChar();
				fails += guessWord.checkLetter(currentChar);
				gibbet.addPart(fails);
				gibbet.print();
				guessWord.print(fails + 1);				
			} while((fails < 5) && (!guessWord.checkWin()));
			
			if (fails == 5) System.out.println("Вы проиграли");
			else System.out.println("Вы выиграли");
		} while (1 > 0);				
	}
	
	public void newGame() {
		do {			
			System.out.println("1. Начать новую игру");
			System.out.println("2. Выйти");
			s = scanner.nextLine();
			if (s.equals("2")) {
				System.out.println("До новых встреч!");
				System.exit(1);
			}
		} while(!s.equals("1")); 	
	}
	
	public char inputChar() {
		do {
			System.out.println("Введите букву:");
			s = scanner.nextLine();
			if ((s.length() != 1) || (s.charAt(0) < 'a') || (s.charAt(0) > 'z')) continue;
			else return s.charAt(0);
		} while (1 > 0);
	}
	
}
