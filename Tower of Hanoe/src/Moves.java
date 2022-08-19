public class Moves {
	/**
	 * An array of disc movements. Each movement is a pair of two ints.
	 * For example one complete movement defined by 0, 1 is a move from peg 0 to peg 1. 
	 */
	DynamicArray moves;
	/**
	 * An indicator set to true if the number of disc in the game is even.
	 */
	
	boolean even;
        int discs;
	
	/**
	 * The container stands for each peg. 
	 * There are three pegs in the game in total. 
	 * The left, center and right peg.
	 * All of the discs will be on the left most peg at the start of the game.
	 * Discs be biggest to smallest from the start. 
	 */
	DynamicArray left;
	DynamicArray center;
	DynamicArray right;
	
	/**
	 * Construct a move object that contains all the moves.  
	 * @param n the number of disc on the game.
         * The 
	 */
	public Moves(int n){
                moves = new DynamicArray();
                left = new DynamicArray();
                center = new DynamicArray();
                right = new DynamicArray();
                for(int i = 0; i < n; i ++) left.add(n - i);
                discs = n;
                even = (n%2)==0;
                generateMoves();

	}
	
	/**
	 * Provide a list of steps for the code to run to solve the game
	 * Tower of Hanoi. 
	 * 
	 * Each move should consist of 2 numbers representing the from and to rod location.
	 * For example, if you are wanting to move from rod 0 to rod 2 then you will add
	 * 2 numbers to the moves array using moves.add(0), moves.add(2). These two represent a move from rod 0 to rod 2. 
	 * There are three rods in the game. The left rod is 0, center is 1 and right rod is 2.
	 * 
	 */
	
/*	make the legal move between pegs A and B (in either direction)
	make the legal move between pegs A and C (in either direction)
	make the legal move between pegs B and C (in either direction)
	repeat until complete
*/
	public void generateMoves(){
            System.out.println("Generating moves");
            
            /*if(even){
                while(true){
                    if(left.size() == 0 && center.size() == 0) break;
                    if(center.size() == 0 || left.getLast() < center.getLast()){
                        moves.add(0);
                        moves.add(1);
                        center.add(left.remove());
                    } else{
                        moves.add(1);
                        moves.add(0);
                        left.add(center.remove());
                    }
                    
                    if(left.size() == 0 && right.size() == 0) break;
                    if(right.size() == 0 || left.getLast() < right.getLast()){
                        moves.add(0);
                        moves.add(2);
                        right.add(left.remove());
                    } else{
                        moves.add(2);
                        moves.add(0);
                        left.add(right.remove());
                    }
                    
                    if(center.size() == 0 && right.size() == 0) break;
                    if(right.size() == 0 || center.getLast() < right.getLast()){
                        moves.add(1);
                        moves.add(2);
                        right.add(center.remove());
                    } else{
                        moves.add(2);
                        moves.add(1);
                        center.add(right.remove());
                    }
                }
            } else{
                while(true){
                    if(left.size() == 0 && right.size() == 0) break;
                    if(right.size() == 0 || left.getLast() < right.getLast()){
                        moves.add(0);
                        moves.add(2);
                        right.add(left.remove());
                    } else{
                        moves.add(2);
                        moves.add(0);
                        left.add(right.remove());
                    }
                    
                    if(left.size() == 0 && center.size() == 0) break;
                    if(center.size() == 0 || left.getLast() < center.getLast()){
                        moves.add(0);
                        moves.add(1);
                        center.add(left.remove());
                    } else{
                        moves.add(1);
                        moves.add(0);
                        left.add(center.remove());
                    }
                    
                    if(center.size() == 0 && right.size() == 0) break;
                    if(right.size() == 0 || center.getLast() < right.getLast()){
                        moves.add(1);
                        moves.add(2);
                        right.add(center.remove());
                    } else{
                        moves.add(2);
                        moves.add(1);
                        center.add(right.remove());
                    }
                }
                
            }*/
            
            main(discs, 0, 2, 1);        
	}
	
        public void main(int discs, int start, int end, int temp){
            if(discs == 1){
                moves.add(start);
                moves.add(end);
            } else{
                main(discs - 1, start, temp, end);
                moves.add(start);
                moves.add(end);
                main(discs - 1, temp, end, start);
            }
        }
}
