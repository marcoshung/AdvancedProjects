import java.util.*;
public class BracketBuilder {
	
	public static void main(String[] args) {
		
		System.out.print("Enter the names of the contestants");
		Scanner input = new Scanner(System.in);
		boolean done = false;
		ArrayList<String> names = new ArrayList<String>();
		while(!done) {
			String entry = input.nextLine().toUpperCase();
			if(entry.equals("QUIT") || entry.equals("DONE")) {
				done = true;
				createBrackets(names);
			}else {
				System.out.println("NAME :" + (names.size() + 1));
				names.add(entry);
			}
			
		}
		
	}
	
	public static void createBrackets(ArrayList<String> names) {
		ArrayList<Bracket> matches = new ArrayList<Bracket>();
		int count = 0;
		if(names.size() % 2 != 0) {
			matches.add(new Bracket(names.get((int) (Math.random() * (names.size())))));
		}
		while(names.size() > 0) {
			int index1 =(int) (Math.random() * (names.size()));
			String name1= names.get(index1);

			int index2 = (int) (Math.random() * (names.size()));
			String name2 = names.get(index2);
			
			while(name2.equals(name1)) {
				index2 = (int) (Math.random() * (names.size()));
				name2 = names.get(index2);
			}
			matches.add(new Bracket(name1,name2));
			matches.remove(index1); matches.remove(index2);
		}
		
		for(int i = 0;i < matches.size(); i++) {
			System.out.println("BRACKET " + (i +1));
			matches.get(i).printNames();
		}
	}
}
