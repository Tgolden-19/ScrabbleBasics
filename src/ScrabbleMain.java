import java.util.Scanner;
public class ScrabbleMain {
	public static void main(String[] args) {
		System.out.println("Hey, I'm running!");
		final boolean debugModifier = false;
		Possibilities poo = new Possibilities();
		WordWorth woo = new WordWorth();
		if(debugModifier == true) {
		System.out.println("Starting Testing please standby");
		System.out.println(poo.bestWord("gamerss"));
		System.out.println(poo.bestWord("bbaarrm"));
		System.out.println(poo.bestWord("bington"));
		System.out.println("Testing Complete; all scenarios functional");
		System.out.println("Please continue");
		}
		Scanner userInput = new Scanner(System.in);
		String s;
		do {
			System.out.print("Enter your random letters to test (END to end):");
			s = userInput.nextLine();
			
			for (String w:poo.bestWord(s))
			{
			System.out.println(w + ":" + woo.value(w));
			}
			
			

		} while (!s.equals("END"));
		userInput.close();
		System.out.println("So long!");
	}
}
