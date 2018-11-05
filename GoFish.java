package Project4;

public class GoFish {
	private Pile deck = new Pile();
	private Pile yourHand = new Pile();
	private Pile opponentHand = new Pile();
	private int yourPairs;
	private int opponentPairs;
	
	public GoFish() {
		yourPairs = 0;
		opponentPairs = 0;
	}
	
	public Pile getYourHand() {
		return yourHand;
	}

}
