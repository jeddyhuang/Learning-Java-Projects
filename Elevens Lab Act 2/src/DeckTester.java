/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
            Deck andrew = new Deck(new String[]{"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"},new String[]{"Heart","Diamond","Spades","Clubs"},new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13});
            Deck robert = new Deck(new String[]{"Tesla","Honda","Lexus","Toyota","GMC"},new String[]{"Blue","Red","Yellow","Green"},new int[]{1,2,3,4,5});
            Deck ethan = new Deck(new String[]{"Panda","Gecko","Leopard","Panther","Lion","Husky","Tanuki","Eagle"},new String[]{"Zoo","Wild","Undiscovered"},new int[]{1,2,3,4,5,6,7,8});
	
            System.out.println(andrew.isEmpty());
            System.out.println(robert.isEmpty());
            System.out.println(ethan.isEmpty());
            
            System.out.println(andrew.size());
            System.out.println(robert.size());
            System.out.println(ethan.size());
            
            System.out.println(andrew.deal().rank());
            System.out.println(andrew.deal().suit());
            System.out.println(andrew.deal().pointValue());
            System.out.println(robert.deal().rank());
            System.out.println(robert.deal().suit());
            System.out.println(robert.deal().pointValue());
            System.out.println(ethan.deal().rank());
            System.out.println(ethan.deal().suit());
            System.out.println(ethan.deal().pointValue());
            
            System.out.println(andrew.size());
            System.out.println(robert.size());
            System.out.println(ethan.size());
            
            System.out.println(andrew.toString());
            System.out.println(robert.toString());
            System.out.println(ethan.toString());
        }
}
