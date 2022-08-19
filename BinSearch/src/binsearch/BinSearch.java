/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binsearch;

/**
 *
 * @author jerrywang
 */
public class BinSearch {
    
    public static int linSearch(int[] arr, int el){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == el) return i;
        }
        return -1;
    }
    
    public static int binSearch(int[] arr, int el){
        int start = 0, end = arr.length-1, middle = (end-start)/2;              //set integers for start middle and end indexes
        while(start <= end){                                                    //check if the start index is indeed the start and the end is indeed the end
            if(arr[middle] < el){                                               //check if the element is on the right side of the array
                start = middle + 1;                                             //adjust the start index to check the right side
                middle = (end + start)/2;                                       //adjust the middle index to check the right side
            } else{
                if(el < arr[middle]){                                           //check if the element is on the left side of the array
                    end = middle - 1;                                           //adjust the end index to check the left side
                    middle = (end + start)/2;                                   //adjust the middle index to check the left side
                } else{
                    if(arr[middle] == el){ return middle;}                      //return only if the element is in the middle of the array
                }
            }
        }
        return -1;                                                              //return negative one if the element is not in the array
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] andrew = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(binSearch(andrew,3));
    }
    
}
