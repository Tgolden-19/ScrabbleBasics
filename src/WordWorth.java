//import java.util.Arrays;
public class WordWorth {
	String alpha  = "abcdefghijklmnopqrstuvwxyz ";
	int[] getPoints = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10, 0};
	
	
	public int value(String goo){
		int score = 0;
		goo = goo.toLowerCase();
		for (int j = 0; j < goo.length(); j++)
			{
				char letter = goo.charAt(j);
				int y = alpha.indexOf(letter);
				int x = getPoints[y];
				score = score + x;
			}
		return score;
		}
}
