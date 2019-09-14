
public class Concealed {
	private int NUMBER_OF_POSSIBLE_VALUES =2;
	private int concealedValue;
	private int randomizer;
	private int randomizer2;
	
	public Concealed(char c) {
		
		encrypt(c);
	}
	
	public void encrypt(char c) {
		randomizer = (int) (Math.random() * 10);
		randomizer2 = (int) (Math.random() * 10);
		if(randomizer2 == 0) {
			while(randomizer2 == 0) {
				randomizer2 = (int) (Math.random() * 10);
			}
		}
		int asciiValue = (int) c;
		
		concealedValue = (asciiValue + (randomizer + 53)) * (randomizer2 + 5);
	}
	
	public char convertBack() {
		int value = concealedValue/ (randomizer2 + 5) - (randomizer + 53);
		return (char) value;
	}
	
	public double getConcealedValue() {
		int GCF = 1;
		String line = "";
		while(concealedValue / GCF != 0) {
			GCF++;
		}
		for(int i = GCF; i > 0; i--) {
			if(concealedValue <= (GCF * NUMBER_OF_POSSIBLE_VALUES)) {
				line+= "1";
				concealedValue -= (GCF*NUMBER_OF_POSSIBLE_VALUES);
			}else {
				line+= "0";
			}
		}
		return concealedValue;
	}
}
