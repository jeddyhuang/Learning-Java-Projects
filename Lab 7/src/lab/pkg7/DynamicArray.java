package lab.pkg7;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerrywang
 */
public class DynamicArray {
    private int[] data;
    private int size = 0;
    
    public DynamicArray(){
        data = new int[2];
    }
    
    public void Add(int num){
        size ++;
        if(size == 1){
            data[0] = num;
            return;
        }
        if(size == 2){
            data[1] = num;
            return;
        }
        int[] temp = new int[size];
        for(int i = 0; i < size-1; i++){
            temp[i] = data[i];
        }
        temp[size - 1] = num;
        data = temp;
    }
    
    public int Remove(int index){
        int x = 0;
        size --;
        if(index >= size || index < 0){
            return 0;
        }
        if(size <= -1){
            size = 0;
            return 0;
        }
        if(size == 0){
            x = data[index];
            data = new int[2];
            return x;
        }
        if(size == 1){
            x = data[index];
            int y = data[1 - index];
            data[1] = 0;
            data[0] = y;
            return x;
        }
        x = data[index];
        int[] temp = new int[size];
        for(int i = 0; i < index; i++){
            temp[i] = data[i];
        }
        for(int i = index + 1; i < size + 1; i++){
            temp[i-1] = data[i];
        }
        data = temp; 
        return x;
    }
    
    public int Get(int index){
        if(index >= size || index < 0){
            return 0;
        }
        return data[index];
    }
    
    public int Length(){
        return size;
    }
    
    public int Remove(){
        int x = 0;
        if(size == 0){
            return 0;
        }
        if(size == 1){
            size --;
            x = data[0];
            data[0] = 0;
            return x;
        }
        if(size == 2){
            size --;
            x = data[1];
            data[1] = 0;
            return x;
        }
        size --;
        int[] temp = new int[size];
        for(int i = 0; i < size; i++){
            temp[i] = data[i];
        }
        x = data[size];
        data = temp;
        return x;
    }
    
    public int getLast(){
        if(size > 0){
            return data[size - 1];
        }
        return 0;
    }
    
}
