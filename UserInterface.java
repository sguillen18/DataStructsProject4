package Project4;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How to Play Go Fish(You VS Computer: \n"
				+ "You and your opponent will be given seven cards each.");
		System.out.println("Do you want to play GoFish? y/n");
		String ans = sc.next();
		
		while(ans.equalsIgnoreCase("y")) {
			GoFish newGame = new GoFish();
			newGame.setUp();
			System.out.println("\nYour current hand: ");
			newGame.getYourHand().printList();
			newGame.checkForPairsUser();
			newGame.checkForPairsOpponent();
			
			//finding pairs
			while(newGame.getDeck().getLength() != 0) {
				//if user hand empty
				if(newGame.getYourHand().getLength() == 0) {
					for(int z = 0; (z < 8) && newGame.getDeck().getLength() != 0; z++) {
						Card c = newGame.getDeck().remove();
						newGame.getYourHand().add(c);
						newGame.checkForPairsUser();
					}
				}
				
				//if opponent hand empty
				else if(newGame.getOpponentHand().getLength() == 0) {
					for(int z = 0; (z < 8) && newGame.getDeck().getLength() != 0; z++) {
						Card c = newGame.getDeck().remove();
						newGame.getOpponentHand().add(c);
						newGame.checkForPairsOpponent();
					}
				}
				
				//user goes first
				else {
					boolean has = false;
					Card c = null;
					while(!has) {
						System.out.println("Choose a card to ask for.. ");
						
						//rank
						System.out.println("Rank (in words): ");
						String rank = sc.next();
						Rank r = null;
						r = newGame.makeRank(rank);
						
						//suit
						System.out.println("Suit (in words): ");
						String suit = sc.next();
						Suit s = null;
						s = newGame.makeSuit(suit);
						
						if(newGame.cardExists(r, s)) {
							c = new Card(r, s);
							if(newGame.getYourHand().contains(c)) {
								has = true;
								break;
							}
							else {
								System.out.println("There is no such card in your hand. Please input one that is in your hand.");
							}
						}
						else {
							System.out.println("Please input a valid card");
						}
					}
					
					//user's turn
					boolean turn = true;
					while(turn) {
						turn = newGame.userAsk(c);
					}
					
					//opponent's turn
					turn = true;
					while(turn) {
						turn = newGame.opponentAsk();
					}
				}
				
			}
			
			while(newGame.getYourHand().getLength() != 0 && newGame.getOpponentHand().getLength() != 0) {
				boolean has = false;
				Card c = null;
				while(!has) {
					System.out.println("\nChoose a card to ask for.. ");						
					//rank
					System.out.println("Rank (in words): ");
					String rank = sc.next();
					Rank r = null;
					r = newGame.makeRank(rank);
						
					//suit
					System.out.println("Suit (in words): ");
					String suit = sc.next();
					Suit s = null;
					s = newGame.makeSuit(suit);
						
					if(newGame.cardExists(r, s)) {
						c = new Card(r, s);
						if(newGame.getYourHand().contains(c)) {
							has = true;
							break;
						}
						else {
							System.out.println("There is no such card in your hand. Please input one that is in your hand.");
						}
					}
					else {
						System.out.println("Please input a valid card");
					}
				}
					
				//user's turn
				newGame.userAsk(c);
					
				//opponent's turn
				newGame.opponentAsk();
			}
			
			//ending game
			
		}
		
		sc.close();

	}

}
