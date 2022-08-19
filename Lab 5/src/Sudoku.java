
import java.util.HashMap;

public class Sudoku {

    public int[][] board;
    public boolean solved = false;

    public static int RowSum(int[][] arr, int row)
    {
        int sum = 0;                                                            //have a temporary integer for the sum
        for (int col = 0; col < arr[row].length; col++)                         //go through the row a cell at a time
        {
            sum += arr[row][col];                                               //update the sum
        }
        return sum;                                                             //return your result
    }

    public static int ColSum(int[][] arr, int col)
    {
        int sum = 0;                                                            //have a temporary integer for the sum
        for (int row = 0; row < arr.length; row++)                              //go through the column a cell at a time
        {
            sum += arr[row][col];                                               //update the sum
        }
        return sum;                                                             //return your result
    }

    public static int SumDiag(int[][] arr)
    {
        int sum = 0;                                                            //have a temporary integer for the sum
        for (int andrew = 0; andrew < arr.length; andrew++)                     //goes through the diagonal from the top left to the bottom right
        {
            sum += arr[andrew][andrew];                                         //update the sum
        }
        for (int andrew = 0; andrew < arr.length; andrew++)                     //goes through the diagonal from the top right to the bottom left
        {
            sum += arr[andrew][arr.length - andrew - 1];                        //update the sum

        }
        return sum;                                                             //return your result
    }

    public static int[] AllRowSum(int[][] arr)
    {
        int[] andrew = new int[arr.length];                                     //find the amount of rows present
        for (int i = 0; i < andrew.length; i++)                                 //go through each row at a time
        {
            int sum = 0;                                                        //set a temporary integer for the current sum
            for (int j = 0; j < arr.length; j++)                                //go through the row and sum it
            {
                sum += arr[i][j];                                               //update the temporary sum
            }
            andrew[i] = sum;                                                    //set the sum into the array
        }
        return andrew;                                                          //return the array
    }

    public static int[] AllColSum(int[][] arr)
    {
        int[] andrew = new int[arr[0].length];                                  //find the amount of columns present
        for (int i = 0; i < andrew.length; i++)                                 //go through each column at a time
        {
            int sum = 0;                                                        //set a temporary integer for the current sum
            for (int j = 0; j < arr[0].length; j++)                             //go through the column and sum it
            {
                sum += arr[j][i];                                               //update the temporary sum
            }
            andrew[i] = sum;                                                    //set the sum into the array
        }
        return andrew;                                                          //return the array
    }

    public static void reflect(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++)                                    //loop for each row in the array
        {
            int[] andrew = new int[arr[i].length];                              //temporary array for the current row
            for (int j = 0; j < arr[i].length; j++)                             //fill out the row one at a time
            {
                andrew[j] = arr[i][j];                                          //update the temporary array
            }
            for (int g = 0; g < arr[i].length; g++)                             //replace the current array one at a time
            {
                arr[i][g] = andrew[andrew.length - g - 1];                      //update the current array
            }
        }
    }

    public static boolean ValidRow(int[][] arr, int row)
    {
        int[] andrew = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};                    //set up an empty array
        for (int i = 0; i < arr[row].length; i++)                               //go through the array one number at a time
        {
            if (arr[row][i] < 0 || arr[row][i] > 9)                             //check if the number is between 0 and 9
            {
                return false;                                                   //stop if it is not in the boundary
            }
            for (int j = 0; j < 9; j++)                                         //check for each number
            {
                if (arr[row][i] == j + 1)                                       //count of every number
                {
                    andrew[j]++;                                                //update the array
                }
            }
        }
        for (int i = 0; i < andrew.length; i++)                                 //loop for the temporary array
        {
            if (andrew[i] > 1)                                                  //check if there is only up to one of each number
            {
                return false;                                                   //stop if there is a number over one
            }
        }
        return true;                                                            //return true if it is right
    }

    public static boolean ValidCol(int[][] arr, int col)
    {
        int[] andrew = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};                    //set up an empty array
        for (int i = 0; i < arr.length; i++)                                    //go through the array one number at a time
        {
            if (arr[i][col] < 0 || arr[i][col] > 9)                             //check if the number is between 0 and 9
            {
                return false;                                                   //stop if it is not in the boundary
            }
            for (int j = 0; j < 9; j++)                                         //check for each number
            {
                if (arr[i][col] == j + 1)                                       //count of every number
                {
                    andrew[j]++;                                                //update the array
                }
            }
        }
        for (int i = 0; i < andrew.length; i++)                                 //loop for the temporary array
        {
            if (andrew[i] > 1)                                                  //check if there is only up to one of each number
            {
                return false;                                                   //stop if there is a number over one
            }
        }
        return true;                                                            //return true if it is right
    }

    public static boolean Valid(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (ValidRow(arr, i) != true || ValidCol(arr, i) != true || checkBox(arr) != true) {
                return false;
            }
        }
        return true;
    }

    public static void Erase(int[][] arr)
    {
        int x, y;                                                               //set up two temporary numbers
        x = (int) (Math.random() * 9);                                          //randomize a temporary number
        y = (int) (Math.random() * 9);                                          //randomize the other temproary number
        arr[x][y] = 0;                                                          //replace the random cell with a zero
    }

    public static boolean checkBox(int[][] arr)
    {
        int[] andrew = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};    		//set up an empty array
        for (int i = 0; i < arr.length; i++)                                    //loop for each row
        {
            for (int j = 0; j < arr[0].length; j++)                             //loop for each column
            {
                if (arr[i][j] < 0 || arr[i][j] > 9)                             //check if the number is between 0 and 9
                {
                    return false;                                               //stop if it is not in the boundary
                }
                for (int k = 0; k < 9; k++)                                     //check each box one at a time
                {
                    if (arr[i][j] == k + 1)                                     //if the box is valid, update the array
                    {
                        andrew[k]++;                                            //update the array
                    }
                }
            }
        }
        for (int i = 0; i < andrew.length; i++)                                 //loop for the temporary array
        {
            if (andrew[i] > 1)                                                  //check if there is only up to one of each number
            {
                return false;                                                   //stop if there is a number over one
            }
        }
        return true;                                                            //return true if it is right
    }

    public static int SumBox(int[][] arr, int row, int col)
    {
        int x = row - (row % 3);                                                //find the right set of where the 3 by 3 box is at
        int y = col - (col % 3);                                                //find the other coordinate
        int sum = 0;                                                            //set up a temporary integer as the sum
        for (int i = 0; i < 3; i++)                                             //loops for every row in the box
        {
            for (int j = 0; j < 3; j++)                                         //loops for every column in the box
            {
                sum += arr[x + i][y + j];                                       //updates the sum of the box
            }
        }
        return sum;                                                             //returns the sum
    }

    public static int[][] Generate()
    {
        int[][] board = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9},                //set up a random board with empty spaces
                                    {2, 3, 4, 5, 6, 7, 8, 9, 1},
                                    {3, 4, 5, 6, 7, 8, 9, 1, 2},
                                    {4, 5, 6, 7, 8, 9, 1, 2, 3},
                                    {5, 6, 7, 8, 9, 1, 2, 3, 4},
                                    {6, 7, 8, 9, 1, 2, 3, 4, 5},
                                    {7, 8, 9, 1, 2, 3, 4, 5, 6},
                                    {8, 9, 1, 2, 3, 4, 5, 6, 7},
                                    {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        /*
        Initiate so that there are 9 boxes of 3 by 3 arrays for each box of the sudoku
        */
        int[][] bot1 = new int[3][3],
                bot2 = new int[3][3],
                bot3 = new int[3][3],
                bot4 = new int[3][3],
                bot5 = new int[3][3],
                bot6 = new int[3][3],
                bot7 = new int[3][3],
                bot8 = new int[3][3],
                bot9 = new int[3][3];
        /*
        Loop so that all 9 of the 3 by 3 boxes are filled by the correct values
        */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bot1[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bot2[i][j] = board[i + 3][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bot3[i][j] = board[i + 6][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bot4[i][j] = board[i][j + 3];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bot5[i][j] = board[i + 3][j + 3];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bot6[i][j] = board[i + 3][j + 6];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bot7[i][j] = board[i + 6][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bot8[i][j] = board[i + 6][j + 3];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bot9[i][j] = board[i + 6][j + 6];
            }
        }
        /*
        Check if each box is valid, if not then loop
        */
        while (checkBox(bot1) == false || checkBox(bot2) == false || checkBox(bot3) == false || checkBox(bot4) == false || checkBox(bot5) == false || checkBox(bot6) == false || checkBox(bot7) == false || checkBox(bot8) == false || checkBox(bot9) == false) {
            /*
            Make 2 random numbers
            */
            int x = 0, y = 0;
            x = (int) (Math.random() * 9);
            y = (int) (Math.random() * 9);
            int[] andrew = board[x];
            /*
            Flip flop the two rows
            */
            board[x] = board[y];
            board[y] = andrew;
            /*
            Update every single 3 by 3 box
            */
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bot1[i][j] = board[i][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bot2[i][j] = board[i + 3][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bot3[i][j] = board[i + 6][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bot4[i][j] = board[i][j + 3];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bot5[i][j] = board[i + 3][j + 3];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bot6[i][j] = board[i + 3][j + 6];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bot7[i][j] = board[i + 6][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bot8[i][j] = board[i + 6][j + 3];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bot9[i][j] = board[i + 6][j + 6];
                }
            }
        }
        
        int[] ritwik = new int [81];
        for(int i = 0; i < ritwik.length; i++){
            ritwik[i] = i;
        }
        int[] jerry = new int [30];
        for(int i = 0; i < 30; i ++){
            int z = (int) (Math.random()*81);
            /*
            Find distinct numbers to replace
            */
            while(ritwik[z] == 0){
                z = (int) (Math.random()*81);
            }
            jerry[i] = ritwik[z];
            /*
            Assign the original array with the correct numbers
            */
            ritwik[z] = 0;
        }
        /*
        Replace the right boxes in the array with zero
        */
        for(int i = 0; i < jerry.length; i ++){
            int ethan, chris;
            ethan = jerry[i] % 9;
            chris = (jerry[i] -(jerry[i] % 9)) / 9;
            board[chris][ethan] = 0;
        }
        return board;
    }

    public Sudoku() {
        board = new int[9][9];
        board = Generate();

        /*
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				board[r][c] = 0;
			}
		}*/
    }

    public Sudoku(int dim) {
        board = new int[dim][dim];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] = 0;
            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                str += (board[r][c] + " ");
            }
            str += "\r\n";
        }
        return str;
    }

}
