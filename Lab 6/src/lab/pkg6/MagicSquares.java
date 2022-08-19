/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg6;

/**
 *
 * @author jerrywang
 */
public class MagicSquares {
    int[][] data;
    
    public MagicSquares(){
        data = new int[3][3];
        int x = 0;
        int y = (int)(data.length/2);
        data[x][y] = 1;
        for(int i = 2; i <= (data.length * data[0].length); i++){
            if(i%data.length != 1){
                x--;
                y++;
                if(x == -1){
                    x = data.length-1;
                }
                if(y == data[0].length){
                    y = 0;
                }
            }
            x--;
            if(x == -1){
                x = data.length-1;
            }
            data[x][y] = i;
        }
    }
    
    public MagicSquares(int n){
        data = new int[n][n];
        int x = 0;
        int y = (int)(data.length/2);
        data[x][y] = 1;
        for(int i = 2; i <= (data.length * data[0].length); i++){
            if(i%data.length != 1){
                x--;
                y++;
                if(x == -1){
                    x = data.length-1;
                }
                if(y == data[0].length){
                    y = 0;
                }
            }
            x--;
            if(x == -1){
                x = data.length-1;
            }
            data[x][y] = i;
        }
    }
    
}
