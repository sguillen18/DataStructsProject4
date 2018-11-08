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
				if(newGame.getOpponentHand().getLength() == 0) {
					for(int z = 0; (z < 8) && newGame.getDeck().getLength() != 0; z++) {
						Card c = newGame.getDeck().remove();
						newGame.getOpponentHand().add(c);
						newGame.checkForPairsOpponent();
					}
				}
				
				//user goes first
				else {
					//user's turn
					boolean userTurn = true;
					Card c = null;
					while(userTurn && newGame.getYourHand().getLength() != 0) {
						c = null;
						while(c == null) {
							System.out.println("Choose a card to ask for.. ");
						
							//rank
							System.out.println("Rank (in words): ");
							String rank = sc.next();
						
							//suit
							System.out.println("Suit (in words): ");
							String suit = sc.next();
						
							c = newGame.newCardInput(rank, suit);
						}
						userTurn = newGame.userAsk(c);
					}
					
					//opponent's turn
					boolean turn = true;
					while(turn && newGame.getYourHand().getLength() != 0 && newGame.getOpponentHand().getLength() != 0) {
						turn = newGame.opponentAsk();
						if(newGame.getYourHand().getLength() == 0 || newGame.getOpponentHand().getLength() == 0) {
							if(newGame.getYourHand().getLength() == 0) {
								for(int i = 0; i < 8 && newGame.getDeck().getLength() != 0; i++) {
									newGame.getYourHand().remove();
								}
							}
							if(newGame.getOpponentHand().getLength() == 0) {
								for(int i = 0; i < 8 && newGame.getDeck().getLength() != 0; i++) {
									newGame.getOpponentHand().remove();
								}
							}
						}
					}
				}
				
			}
			
			while(newGame.getYourHand().getLength() != 0 && newGame.getOpponentHand().getLength() != 0) {
				boolean userTurn = false;
				Card c = null;
				while(userTurn && newGame.getYourHand().getLength() != 0) {
					c = null;
					while(c == null) {
						System.out.println("Choose a card to ask for.. ");
					
						//rank
						System.out.println("Rank (in words): ");
						String rank = sc.next();
					
						//suit
						System.out.println("Suit (in words): ");
						String suit = sc.next();
					
						c = newGame.newCardInput(rank, suit);
					}
					userTurn = newGame.userAsk(c);
				}
					
				//opponent's turn
				boolean turn = true;
				while(turn && newGame.getYourHand().getLength() != 0 && newGame.getOpponentHand().getLength() != 0) {
					turn = newGame.opponentAsk();
					if(newGame.getYourHand().getLength() == 0 || newGame.getOpponentHand().getLength() == 0) {
						if(newGame.getYourHand().getLength() == 0) {
							for(int i = 0; i < 8 && newGame.getDeck().getLength() != 0; i++) {
								newGame.getYourHand().remove();
							}
						}
						if(newGame.getOpponentHand().getLength() == 0) {
							for(int i = 0; i < 8 && newGame.getDeck().getLength() != 0; i++) {
								newGame.getOpponentHand().remove();
							}
						}
					}
				}
			}
			
			//ending game
			
		}
		
		sc.close();

	}

}
