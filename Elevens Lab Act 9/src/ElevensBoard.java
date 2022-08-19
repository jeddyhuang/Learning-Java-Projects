
import java.util.List;



/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards){
		if(selectedCards.size() == 2){                                  //check if only 2 cards are selected
                    return containsPairSum11(selectedCards);                    //check if the 2 cards sum to 11
                }
                if(selectedCards.size() == 3){                                  //check if only 3 cards are selected
                    return containsJQK(selectedCards);                          //check if the 3 cards are a J Q and K
                }
                return false;                                                   //return false if it selects a number of cards that is not 2 or 3
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
            return containsPairSum11(cardIndexes()) || containsJQK(cardIndexes());  //check if you can do a sum or J Q and K triplet with the cards on the board
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
                for(int i = 0; i < selectedCards.size(); i ++){                 //go through the cards one at a time
                    for(int j = i+1; j < selectedCards.size(); j++){            //compare the cards with ever other card once
                        if(cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue()== 11){ //check if the point value adds up to 11
                            return true;                                        //return true if the cards add up to 11
                        }
                    }
                }
		return false;                                                   //return false if the cards do not add up to 11
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		int x=0, y=0, z=0;                                              //count the number of J Q and K are in the list
                for (Integer k : selectedCards) {                               //check for ever single selected card
                    if(cardAt(k).rank().equals("jack")){                        //check if the card is J
                        x++;                                                    //increase the temp integer
                    }
                    if(cardAt(k).rank().equals("queen")){                       //check if the card is Q
                        y++;                                                    //increase the temp integer
                    }
                    if(cardAt(k).rank().equals("king")){                        //check if the card is K
                        z++;                                                    //increase the temp integer
                    }
		}
                return (x > 0 && y > 0 && z > 0);                               //return true if at least one pair is possible
	}
}
