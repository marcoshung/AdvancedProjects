import java.util.Scanner;

public class PrisonerGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter how many prisoners");
		int numPrisoners = scanner.nextInt();
		System.out.println("Enter the countdown number");
		int count = scanner.nextInt();
		LinkedList list = new LinkedList();
		Node finalNode = list.playGame(numPrisoners, count);
			
		System.out.println("Prisoner " + finalNode.getData() + " will be released");
	}
}
