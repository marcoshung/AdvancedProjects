import java.util.*;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		//13 represents value; 4 represents type; 0 =
		ArrayList<Integer> club = fillArray();
		ArrayList<Integer> spade = fillArray();
		ArrayList<Integer> diamond = fillArray();
		ArrayList<Integer> hearts = fillArray();
		
		for(int i = 0; i <52; i++) {
			int randomizer = (int) (Math.random() *5);
			if(randomizer == 0) {
				
			}
		}
	}
	
	public ArrayList<Integer> fillArray() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < 13; i++) {
			array.add(i=1);
		}
		return array;
	}
}
