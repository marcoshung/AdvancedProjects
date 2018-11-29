
public class Bracket {
	
	String name1;
	String name2;
	String winner;
	
	public Bracket(String name1, String name2) {
		this.name1 = name1.toUpperCase();
		this.name2 = name2.toUpperCase();
	}
	
	Bracket(String name){
		this.name1 = name;
	}
	
	public void setWinner(String name) {
		this.winner = name.toUpperCase();
	}
	
	public String getWinner() {
		return this.winner;
	}
	
	public void printNames() {
		if(name2 != null) {
			System.out.println(name1 + "\n" + name2);
		}else {
			System.out.println(name1);
		}
	}
}
