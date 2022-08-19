package lab.pkg6;

/**
 *
 * @author jerrywang
 */
public class MagicSquare {
    private int[][] data;
    
    public MagicSquare()
    {
        data = new int[3][3];                                                   //initiate the magic square as a 3 by 3 as the default
        computeMagicSquare();                                                   //fill the magic square
    }
    
    public MagicSquare(int n)
    {
        data = new int[n][n];                                                   //initiate the magic square as a n by n by the given input
        computeMagicSquare();                                                   //fill the magic square
    }
    
    public void computeMagicSquare()
    {
        int x = 0;                                                              //initiate the x value of the array
        int y = (int)(data.length/2);                                           //find the middle of the magic square
        data[x][y] = 1;                                                         //fill in the first number
        for(int i = 2; i <= (data.length * data[0].length); i++)                //loop for the remaining numbers
        {
            if(i%data.length != 1)                                              //check if it is not one more than a multiple of the side
            {
                x--;                                                            //adjust the x value
                y++;                                                            //adjust the y value
                if(x == -1)                                                     //check if you need to wrap around
                {
                    x = data.length-1;                                          //initiate the wrap around
                }
                if(y == data[0].length)                                         //check if you need to wrap around
                {
                    y = 0;                                                      //initiate the wrap around
                }
            }else
            {
                x++;                                                            //just move it down if it is one more than the multiple of the side
                if(x == data.length)                                            //check if you need to wrap around
                {
                    x = 0;                                                      //initiate the wrap around
                }
            }
            data[x][y] = i;                                                     //set the selected box with the given number
        }
    }
    
    public int[][] getData()
    {
        return data;                                                            //simply return the necessary data
    }
    
    public boolean checkRows(int[][] andrew)
    {
        int rishi = 0;                                                          //set a temporary variable as the sum of the first row
        int robert;                                                             //set a changing variable to check the other rows
        for(int i = 0; i < andrew[0].length; i++)                               //loop to add the numbers for the first row
        {
            rishi = rishi + andrew[0][i];                                       //add the numbers together
        }
        for(int i = 1; i < andrew.length; i++)                                  //loop for the remaining rows to check
        {
            robert = 0;                                                         //reset the second variable
            for(int j = 0; j < andrew[i].length; j++)                           //loop for the elements of the next row
            {
                robert = robert + andrew[i][j];                                 //add the numbers together
            }
            if(robert != rishi)                                                 //check if the numbers are the same
            {
                return false;                                                   //return false if the numbers do not equal one another
            }
        }
        return true;                                                            //return true if all the tests are passed
    }
    
    public boolean checkColumns(int[][] andrew)
    {
        int rishi = 0;                                                          //set a temporary variable as the sum of the first column
        int robert;                                                             //set a changing variable to check the other columns
        for(int i = 0; i < andrew.length; i++)                                  //loop to add the numbers for the first column
        {
            rishi = rishi + andrew[i][0];                                       //add the numbers together
        }
        for(int i = 1; i < andrew[0].length; i++)                               //loop for the remaining columns to check
        {
            robert = 0;                                                         //reset the second variable
            for(int j = 0; j < andrew.length; j++)                              //loop for the elements of the next column
            {
                robert = robert + andrew[j][i];                                 //add the numbers together
            }
            if(robert != rishi)                                                 //check if the numbers are the same
            {
                return false;                                                   //return false if the numbers do not equal one another
            }
        }
        return true;                                                            //return true if all the tests are passed
    }
    
    public boolean checkDiagonals(int[][] andrew)
    {
        int rishi = 0;                                                          //set a variable for the sum of the numbers in the first diagonal
        int robert = 0;                                                         //set a variable for the sum of the numbers in the second diagonal
        for(int i = 0; i < andrew[0].length; i++)                               //loop for the amount of numbers in the diagonal
        {
            rishi = rishi + andrew[i][i];                                       //add the numbers together for the variable
        }
        for(int i = 0; i < andrew[0].length; i++)                               //loop for the amount of numbers in the diagonal
        {
            robert = robert + andrew[andrew.length-1-i][i];                     //add the numbers together for the variable
        }
        if(robert != rishi)                                                     //check if the numbers are the same
        {
            return false;                                                       //return false if the numbers do not equal one another
        }
        return true;                                                            //return true if all the tests are passed
    }
    
    public void displayMagicSquare()
    {
        for(int i = 0; i < data.length; i++)                                    //loop to display every row 
        {
            for(int j = 0; j < data[0].length; j++)                             //loop to display every element in the row
            {
                System.out.print(data[i][j] + "\t");                            //print the value of every single thing in the row
            }
            System.out.println();                                               //seperate each row on each line
        }
    }
    
    public boolean checkMagicSquare(int[][] andrew)
    {
        if(checkRows(andrew) != true)                                           //check if the test passes
        {
            return false;                                                       //return false if the test fails
        }
        if(checkColumns(andrew) != true)                                        //check if the test passes
        {
            return false;                                                       //return false if the test fails
        }
        if(checkDiagonals(andrew) != true)                                      //check if the test passes
        {
            return false;                                                       //return false if the test fails
        }
        return true;                                                            //return true if all the tests pass
    }
    
    /*
    What keyword is used to define a class in Java?
    
    class
    */
    
    /*
    What are instance variables with respect to classes?
    
    They are variables within the class that are used by the class.
    */
    
    /*
    What are accessors and mutators? What are other names these might be known as in the Java world?
    
    If the instance variables are private, they allow access to them.
    They access the instance variables and alter them.
    Also known as getters or setters.
    */
    
    /*
    What is encapsulation and why is it necessary to make instance variables private?
    
    A class should not expose its internal state.
    It should only use it for performing its methods.
    It does not allow the user to access the instance variables without the getters.
    This makes it easier to keep information private and make code harder to break.
    */
    
    /*
    What is a constructor used for in Java? When is this constructor called?
    
    It creates an instance of a class. This can also be called creating an object.
    The thing that instantiates the given variable to the things in the class.
    */
}