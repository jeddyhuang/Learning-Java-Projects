
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				//Sudoku_Board s = new Sudoku_Board();
				//s.Create();
                                //s.toString();
                int[][] board = new int[][]{{0,0,3,0,0,6,7,8,0},
                                            {0,5,6,0,0,9,0,0,3},
                                            {7,0,9,0,2,3,0,0,0},
                                            {0,3,4,0,0,0,8,0,1},
                                            {0,0,7,8,9,0,0,0,4},
                                            {8,9,0,2,0,4,0,0,0},
                                            {3,0,5,0,0,0,9,0,2},
                                            {0,7,8,0,0,2,3,0,0},
                                            {0,1,2,0,0,0,6,7,0}};
                                Sudoku.reflect(board);
                                for(int i = 0; i < board.length; i++){
                                    for(int j = 0; j < board.length; j++){
                                        System.out.print(board[i][j] + " ");
                                    }
                                    System.out.println();
                                }
      int[][] MRDAVIDPLZHELP = new int [][]{{1,2,3,4,5,6,7,8,9},
                                            {5,5,6,7,8,9,1,2,3},
                                            {7,8,9,1,2,3,4,5,6},
                                            {2,3,4,1,6,7,8,9,1},
                                            {5,6,7,8,9,1,2,3,4},
                                            {8,9,1,2,3,4,5,6,8},
                                            {3,4,5,6,7,8,9,1,2},
                                            {3,7,8,9,1,2,3,4,5},
                                            {9,1,2,3,4,5,6,7,8}};
                                for(int j = 0; j < board[0].length; j++){
                                    System.out.println(Sudoku.ValidRow(MRDAVIDPLZHELP,j));
                                }
                                int[][] robert = Sudoku.Generate();
                                for(int i = 0; i < robert.length; i++){
                                    for(int j = 0; j < robert.length; j++){
                                        System.out.print(robert[i][j] + " ");
                                    }
                                    System.out.println();
                                }
                                
	}
	
}