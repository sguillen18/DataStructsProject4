package Project4;

public class GoFish {
	private Pile deck = new Pile();
	private Pile yourHand = new Pile();
	private Pile opponentHand = new Pile();
	private Pile yourPairs = new Pile();
	private Pile opponentPairs = new Pile();
	
	public GoFish() {
	}
	
	public Pile getYourHand() {
		return yourHand;
	}
	
	public Pile getOpponentHand() {
		return opponentHand;
	}
	
	public Pile getDeck() {
		return deck;
	}
	
	//returns user's hand
	public Pile setUp() {
		deck.createDeck();
		for(int i = 0; i < 15; i++) {
			Card r = deck.remove();
			if(i%2==0) {
				opponentHand.add(r);
			}
			else {
				yourHand.add(r);
			}
		}
		return yourHand;
	}
	
	public void checkForPairsUser() {
		Card[] c = yourHand.toArray();
		Card r = null;
		int add = 0;
		for(int i = 0; i < c.length; i++) {
    		for(int j = 0; j < c.length; j++) {
    			if(i != j && c[i].sameRank(c[j])) {
    				add++;
    				yourPairs.add(c[i]);
    				r = yourHand.removePair(c[i]);
    				yourPairs.add(r);
    			}
    		}
    	}
		System.out.println("You had " + add + " pair(s) added. Now you have a total of " + yourPairs.getLength()/2 + " pairs.");
	}
	
	public void checkForPairsOpponent() {
		Card[] c = yourHand.toArray();
		Card r = null;
		int add = 0;
		for(int i = 0; i < c.length; i++) {
    		for(int j = 0; j < c.length; j++) {
    			if(i != j && c[i].sameRank(c[j])) {
    				add++;
    				opponentPairs.add(c[i]);
    				r = opponentHand.removePair(c[i]);
    				opponentPairs.add(r);
    			}
    		}
    	}
		System.out.println("Your opponent had " + add + " pair(s) added. Now your opponent have a total of " + yourPairs.getLength()/2 + " pairs.");
	}
	
	public boolean userAsk(Card inhand) {
		if(opponentHand.hasRank(inhand)) {
			System.out.println("Your opponent has a(n) " + inhand.getRank());
			userAddPair(inhand);
			return true;
			
		}
		else {
			System.out.println("Your opponent des not have a(n) " + inhand.getRank() + ". Go fish!");
			Card newCard = deck.remove();
			yourHand.add(newCard);
			System.out.println(newCard.getRank() + ", " + newCard.getSuit() + " was added to your hand.");
			return false;
		}
	}
	
	public void userAddPair(Card c) {
		Card toBeRemoved = opponentHand.askedFor(c);
		yourPairs.add(toBeRemoved);
		yourPairs.add(c);
		yourHand.remove(c);
		opponentHand.remove(toBeRemoved);
	}
	
	public boolean opponentAsk() {
		int r = (int) (Math.random()* opponentHand.getLength()) + 1;
		Card c = opponentHand.getEntry(r);
		if(opponentHand.hasRank(c)) {
			opponentAddPair(c);
			return true;
			
		}
		else {
			Card newCard = deck.remove();
			opponentHand.add(newCard);
			return false;
		}
	}
	
	public void opponentAddPair(Card c) {
		Card toBeRemoved = yourHand.askedFor(c);
		opponentPairs.add(toBeRemoved);
		opponentPairs.add(c);
		opponentHand.remove(c);
		yourHand.remove(toBeRemoved);
		System.out.println("Your opponent took " + toBeRemoved.getRank() + ", " + toBeRemoved.getSuit());
	}

}
