package Project4;


public class Testing {

	public static void main(String[] args) {
		Pile p = new Pile();
		
		p.createDeck();
		System.out.println("Top card on unshuffled deck is: " + p.printCard(p.remove()));
		
		p.shuffle(1);
		System.out.println("Top card on deck shuffled once is: " + p.printCard(p.remove()));
		
		p.shuffle(4);
		System.out.println("Top card on deck shuffled 4 times is: " + p.printCard(p.remove()));
		
		p.clear();
		System.out.println("Is the pile empty?");
		System.out.println(p.isEmpty());
		
		Card newEntry = new Card(Rank.QUEEN, Suit.DIAMOND);
		Card newEntry1 = new Card(Rank.QUEEN, Suit.CLUB);
		Card newEntry2 = new Card(Rank.QUEEN, Suit.HEART);
		Card newEntry3 = new Card(Rank.QUEEN, Suit.SPADE);
		p.add(newEntry1);
		p.add(newEntry);
		p.add(newEntry2);
		DoublyLinkedList <Card> pile1 = p.copy();
		Pile co = new Pile(pile1);
		co.remove(newEntry);
		System.out.println("\n");
		System.out.println("In first list: ");
		p.printList();
		System.out.println("\n");
		System.out.println("In copy of first list with Queen of Diamonds removed: ");
		co.printList();
		System.out.println("\n");
		
		p.replace(1, newEntry3);
		System.out.println("In first list wth Queen of Diamonds switched with Queen of Spades: ");
		p.printList();
		System.out.println("\n");
		
		System.out.println("First Pile at position 2: " + p.printCard(p.getEntry(2)));
		System.out.println("First Pile length: " + p.getLength());
		System.out.println("Does the first pile contain Ace of Hearts: " + p.contains(new Card(Rank.ACE, Suit.HEART)));
		System.out.println("\n");
		
		Pile a = new Pile();
		Pile b = new Pile();
		
		Card c = new Card(Rank.ACE, Suit.CLUB);
		Card d = new Card(Rank.ACE, Suit.DIAMOND);
		Card e = new Card(Rank.ACE, Suit.HEART);
		Card f = new Card(Rank.ACE, Suit.SPADE);
		
		a.add(c);
		a.add(d);
		System.out.println("In first list: ");
		a.printList();
		System.out.println("\n");
		
		b.add(e);
		b.add(f);
		System.out.println("In second list: ");
		b.printList();
		System.out.println("\n");
		
		System.out.println("In union of first and second List: ");
		a.union(b);
		a.printList();
		System.out.println("\n");
		
		
		//need to test getLength and contains
		
		
		

	}

}
