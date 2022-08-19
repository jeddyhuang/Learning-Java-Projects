import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test Demo code.

		// Demo has a method with the signature
		// int sum(int[] arr).
		// This method should return the sum of all
		// the elements in the array given as an parameter
		// and return this sum as an int.

		// Test of Demo
		// regular case 1 ?
		int[] test = { 1, 2, 3, 4, 0 };
		if (Demo.sum(test) != 10) {
			System.out.println("test1 bad result! sum is:" + Demo.sum(test));
		} else {
			System.out.println("sum passed using array {1, 2, 3, 4, 0}");
		}
		
		
		

		// empty case?
		int[] test2 = {};
		if (Demo.sum(test2) != 0) {
			System.out.println("test2 bad result! sum is:" + Demo.sum(test));
		} else {
			System.out.println("sum passed using array {}");
		}
                System.out.println();

		// Test Buggy1.java here
      int[][] MRDAVIDPLZHELP = new int [][]{{1,2,3,4,5,6,7,8,9},
                                            {5,5,6,7,8,9,1,2,3},
                                            {7,8,9,0,2,3,4,5,6},
                                            {2,3,4,1,6,7,8,9,1},
                                            {5,6,7,8,9,11,2,3,4},
                                            {8,9,1,2,3,4,5,6,8},
                                            {3,4,5,6,7,8,9,1,2},
                                            {3,7,8,0,0,0,3,4,5},
                                            {9,1,2,3,4,5,6,7,8}};
                int[] andrew = Buggy1.allRowSum(MRDAVIDPLZHELP);
                for(int i = 0; i < andrew.length; i++){
                    System.out.print(andrew[i] + " ");
                }
                System.out.println();
                for(int i = 0; i < andrew.length; i++){
                    int rishi = 0;
                    rishi = MRDAVIDPLZHELP[i][0] + MRDAVIDPLZHELP[i][1] + MRDAVIDPLZHELP[i][2] + MRDAVIDPLZHELP[i][3] + MRDAVIDPLZHELP[i][4] + MRDAVIDPLZHELP[i][5] + MRDAVIDPLZHELP[i][6] + MRDAVIDPLZHELP[i][7] + MRDAVIDPLZHELP[i][8];
                    System.out.print(rishi + " ");
                }
                System.out.println();
                System.out.println();
                
                //allRowSum does not sum the last row and/or puts it into the resulting array before returning the correct array
                
		/* Test Buggy2.java here
		 * This method is supposed to return true if the given
		 * row of the 2D array is a valid row for a 9x9 Sudoku.
		 * Remember that valid doesn't mean complete and empty spaces are 0s. 
		 * 
		 *  boolean validRow(int[][] arr, int row){
		*/
                 int[][] rik = new int [][]{{1,2,3,4,5,6,7,8,9},
                                            {0,0,6,7,8,9,1,2,3},
                                            {7,0,9,0,2,3,4,5,6},
                                            {2,3,4,1,6,7,8,9,1},
                                            {5,6,7,0,9,11,2,3,4},
                                            {8,9,-1,-2,3,4,5,6,1},
                                            {3,4,5,6,7,8,9,1,2},
                                            {3,7,8,0,0,0,2,4,5},
                                            {9,1,20,3,4,5,6,7,8}};
                for(int i = 0; i < rik.length; i++){
                    System.out.println(Buggy2.validRow(rik, i));
                }
                System.out.println();
                
                //the validRow does not run properly when there are multiple of a valid number in the row
                
                // Test Buggy3.java here.
		// This method is supposed to return true if the given
		// column of the 2D array is a valid column for a 9x9 Sudoku.
		// * Remember that valid doesn't mean complete and empty spaces are 0s. 
		//  boolean validCol(int[][] arr, int col){
               int[][] ethan = new int [][]{{1,2,3,4,5,6,7,8,9},
                                            {0,0,6,7,8,9,1,2,3},
                                            {7,0,9,0,2,3,4,5,6},
                                            {2,3,4,1,6,7,8,9,1},
                                            {5,6,7,0,9,11,2,3,4},
                                            {8,9,-1,-2,3,4,5,6,1},
                                            {3,4,5,6,7,8,9,1,2},
                                            {3,7,8,0,0,0,2,4,5},
                                            {9,1,20,3,4,5,6,7,8}};
                for(int i = 0; i < ethan[0].length; i++){
                    System.out.println(Buggy3.validCol(ethan, i));
                }
                System.out.println();
		
                //the validCol does not work if there are more than one 0 in the a column
                //validCol does not account for numbers less than 0 or greater than 9		
		
		// Test Buggy4.java here
		// Buggy4 contains a reflect method that takes in a 2D int array
		// and is supposed to flip the 2d array horizontally.
               int[][] talha = new int [][]{{1,2,3,4,5,6,7,8,9},
                                            {0,0,6,7,8,9},
                                            {7,0,9,0,2,3,4,5,6},
                                            {2,3,4,1},
                                            {5,6,7,0,9},
                                            {8,9,-1,-2,3,4,5,6,1},
                                            {3,4,5,6,7,8,9,1,2},
                                            {3,7,8,0,0,0,2,4,5},
                                            {9,1,3,20,4,5}};
                Buggy4.reflect(talha);
                for(int i = 0; i < talha.length; i++){
                    for(int j = 0; j < talha[i].length; j++){
                        System.out.print(talha[i][j] + " ");
                    }
                    System.out.println();
                }
                
                //reflect only reflects the last half and places it into the first half
                //but it does not complete the replacements after the 1st half

	}

}
