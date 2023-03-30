import java.io.*;
import java.nio.file.Paths;
import java.util.*;
public class GuessWord {
	
	String word;
	char[] guessedLetters, wordChars;
	List<Character> fails = new ArrayList<>();
	static char MASK = '_'; 
			
	//Paths.get("src", "Dictionary.txt").toFile()
	//"src/Dictionary.txt"
	
	public GuessWord() {
		try (FileReader fr = new FileReader(Paths.get("src", "Dictionary.txt").toFile())) {
			BufferedReader reader = new BufferedReader(fr);
			Random rand = new Random();
			int j = rand.nextInt(30170);
			
			for (int i = 0; i < j; i++)  
				word = reader.readLine();
		} catch(Exception e) {}
		guessedLetters = new char[word.length()];
		wordChars = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			guessedLetters[i] = MASK;
			wordChars[i] = word.charAt(i);
		}		
		print(0);
	}
	
	public int checkLetter(char letter) {
		
		int index = -1;
		
		for (int i = 0; i < word.length(); i++) 
			if (wordChars[i] == letter) {
				guessedLetters[i] = wordChars[i];				
				index = i;
			}
		if ((index == -1) && (!fails.contains(letter)))	{
			fails.add(letter);
			return 1;
		}
		
		return 0;
	}
	
	public boolean checkWin() {
		for (int i = 0; i < word.length(); i++) {
			if (guessedLetters[i] == MASK) 				
				return false;
		}
		return true;
	}
	
	public void print(int amountOfFails) {
		System.out.println("Слово: " + Arrays.toString(guessedLetters));
		System.out.println("Ошибки (" + amountOfFails +"): " + fails);
		
	}
		
}
