/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
            Card andrew = new Card("Queen", "Hearts", 12);
            Card robert = new Card("Jack", "Spades", 11);
            Card ethan = new Card("Ace", "Diamonds", 1);
            
            System.out.println(andrew.suit());
            System.out.println(andrew.rank());
            System.out.println(andrew.pointValue());            
            System.out.println(robert.suit());
            System.out.println(robert.rank());
            System.out.println(robert.pointValue());
            System.out.println(ethan.suit());
            System.out.println(ethan.rank());
            System.out.println(ethan.pointValue());     
            
            System.out.println(andrew.matches(andrew));
            System.out.println(andrew.matches(robert));
            System.out.println(andrew.matches(ethan));
            System.out.println(robert.matches(andrew));
            System.out.println(robert.matches(robert));
            System.out.println(robert.matches(ethan));
            System.out.println(ethan.matches(andrew));
            System.out.println(ethan.matches(robert));
            System.out.println(ethan.matches(ethan));
            
            System.out.println(andrew.toString());
            System.out.println(robert.toString());
            System.out.println(ethan.toString());
	}
}
