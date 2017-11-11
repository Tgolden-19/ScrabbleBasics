
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Possibilities  {
	ArrayList <String> possWords = new ArrayList<String>();
	ArrayList <String> equalWordsList = new ArrayList<String>();
	ArrayList <String> pub = new ArrayList<String>();
	String hand;
	WordWorth word = new WordWorth();
	private final boolean debugMod = false;
	

	/**
	 * Returns the first unused work in word list such that it can be made with the letters given.
	 * 
	 * 
	 * @param shoo
	 * @return
	 */
	private String wordPossibility (String shoo) {
		ArrayList <Character> beforeInDicWord = new ArrayList<Character>();
		ArrayList <Character> inUserWord = new ArrayList<Character>();
		int wordIndex = 0;
		String strung = null;
		String pung = null;
		while(wordIndex < pub.size()) {
			inUserWord.clear();
			beforeInDicWord.clear();
			pung = pub.get(wordIndex);
			if (pung.length() <= shoo.length()) {
				char holder2;

				for(int letterNum = 0; letterNum < pung.length() ; letterNum++) {
					beforeInDicWord.add(pung.charAt(letterNum)); 
				}

				for (int letterNum2 = 0; letterNum2 < shoo.length(); letterNum2++) {
					inUserWord.add(shoo.charAt(letterNum2));
				}
				int constant = 0;
				int counter = 0;
				int indexer = 0;
				int adder = 0;
				while(constant < inUserWord.size()){
					holder2 = beforeInDicWord.get(indexer);
					adder = inUserWord.indexOf(holder2);		

					if(inUserWord.indexOf(holder2) > -1) {
						inUserWord.remove(adder);
						indexer++;
						counter++;
						if(counter == pung.length()) {
							strung = pung;
							pub.remove(wordIndex);
							wordIndex = pub.size();
							break;
						}
					}
					else {
						pub.remove(wordIndex);
						wordIndex++;
						break;


					}
				}

			}

			else {
				pub.remove(wordIndex);
			}
			wordIndex++;
		}

		return strung;
	}


	/**
	 * 
	 * @param hand
	 * Creates array list of all possible words
	 * @return length of list
	 */
	private int AllPossibilities (String bub) {
		int howManyPossWords = 0;
		int coolio = 0;

		String tempHolder2 = null;
		while (coolio < pub.size()) {
			tempHolder2 = wordPossibility(bub);
			if(tempHolder2 == null)
			{
				coolio = pub.size();
			}else {
				possWords.add(tempHolder2);
			}
		}
		howManyPossWords = possWords.size();
		return howManyPossWords;
	}

	/**
	 * 
	 * @param hand
	 * @return highest score possible with these letters (v)
	 */

	public ArrayList<String> bestWord (String vod) {

		pub.clear();
		possWords.clear();
		equalWordsList.clear();
		Scanner getter = null;
		try {
			getter = new Scanner (new File ("Boggle2.txt"));
		}catch (FileNotFoundException f)  {
			f.printStackTrace();
		}

		// Load all words into pub
		String sling;
		while (getter.hasNext()) {
			sling = getter.next();
			sling = sling.substring(0, sling.length()-1);
			pub.add(sling);
		}
		if(debugMod == true)System.out.println("Starting Calculation!");
		
		
		AllPossibilities(vod);

if (possWords.size()==0)
	return(new ArrayList<String>());

		// INPUT: possWords - a list of words
		// GOAL: firstComparer holds value of highest word
		//       wood holds the highest word itself
		String highWord = possWords.get(0);
		int highValue = word.value(highWord);
		for (int i = 1; i < possWords.size(); i++) {
			String curr = possWords.get(i);
			int val = word.value(curr);

			if (val > highValue)
			{
				highValue = val;
				highWord = curr;
				equalWordsList.clear();
				equalWordsList.add(highWord);

			}
			else if (highValue == val) {
				equalWordsList.add(curr);

			}
		}
		if(debugMod == true)System.out.println("Calculations done!");
		
		
		return equalWordsList;
	}


}

