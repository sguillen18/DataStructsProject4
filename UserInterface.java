package Project4;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Do you want to play GoFish? y/n");
		String ans = sc.next();
		
		while(ans.equalsIgnoreCase("y")) {
			GoFish newGame = new GoFish();
			newGame.setUp();
			System.out.println("Your current hand: ");
			newGame.getYourHand().printList();
			while(newGame.getDeck().getLength() != 0) {
				
			}
		}
		
		sc.close();

	}

}
