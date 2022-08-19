import java.util.ArrayList;

public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            ArrayList<Integer> my_nums = new ArrayList<>();
            for(int i = 0; i < 50000; i ++){
                my_nums.add((int)(Math.random()*1000+1));
            }
            
            selectionSort(my_nums);
            for(int i = 0; i < my_nums.size(); i ++){
                System.out.print(my_nums.get(i) + " ");
            }
            System.out.println();
            
            
            insertionSort(my_nums);
            for(int i = 0; i < my_nums.size(); i ++){
                System.out.print(my_nums.get(i) + " ");
            }
            System.out.println();
            
            
            mergeSort(my_nums);
            for(int i = 0; i < my_nums.size(); i ++){
                System.out.print(my_nums.get(i) + " ");
            }
            System.out.println();
            
	}
	
	public static void selectionSort(ArrayList<Integer> numbers){
		int min, temp;
		for(int index = 0; index < numbers.size() - 1; index++){
			min = index;
			for(int scan = index+1; scan < numbers.size(); scan++){
				if(numbers.get(scan) < numbers.get(min)){
					min = scan;
				}
			}

			//swap
			temp = numbers.get(min);
			numbers.set(min, numbers.get(index));
			numbers.set(index, temp);
		}
	}
	
	public static void insertionSort(ArrayList<Integer> numbers){
		for(int index = 1; index < numbers.size(); index++){
			int key = numbers.get(index);
			int position = index;
			
			//shift larger values to the right
			while(position > 0 && numbers.get(position-1) > key){
				numbers.set(position, numbers.get(position-1));
				position--;
			}
			numbers.set(position, key);
		}
	}
	
	public static void mergeSort(ArrayList<Integer> numbers){
		doMergeSort(numbers, 0 , numbers.size()-1);
	}
	
	public static void doMergeSort(ArrayList<Integer> numbers, int start, int end){
		if(start < end){
			int middle = (start+end)/2;
			doMergeSort(numbers,start, middle);
			doMergeSort(numbers,middle+1, end);
			merge(numbers, start, middle, end);
		}
	}
	
	/*complete the method merge which will merge two sorted list into a bigger sorted list*/
	/* first list is from start to middle. this is sorted*/
	/* the second list is from middle+1 to end */
	public static void merge(ArrayList<Integer> numbers, int start, int middle, int end){
		ArrayList<Integer> first = new ArrayList<>();                   //make an array for the first sorted array
		ArrayList<Integer> second = new ArrayList<>();                  //make an array for the second sorted array
                for(int i = start; i <= middle; i++){                           //cycle through the numbers of the first sorted array
                    first.add(numbers.get(i));                                  //add the numbers from the original array to the first sorted array
                }
                for(int i = middle + 1; i <= end; i++){                         //cycle through the numbers of the second sorted array
                    second.add(numbers.get(i));                                 //add the numbers from the original array to the second sorted array
                }
                
                for(int i = start; i <= end; i++){                              //start comparing the two arrays that you have made
                    if(!first.isEmpty() && !second.isEmpty()){                  //check if both arrays have something in them
                        if(first.get(0) >= second.get(0)){                      //check if the first element of the second array is less than or equal to the first element of the first array
                            numbers.set(i, second.get(0));                      //set the first number in the original array with the lower number in the second array
                            second.remove(0);                                   //remove that number from the second array
                        } else{                                                 //make sure only one of these operations happens only once
                            if(first.get(0) < second.get(0)){                   //check if the first element of the first array is less than the first element of the second array
                                numbers.set(i, first.get(0));                   //set the first number in the original array with the lower number in the first array
                                first.remove(0);                                //remove that number from the first array
                            }
                        }
                        
                    } else{                                                     //start filling the numbers if one of the arrays have no numbers left in it
                        if(first.isEmpty()){                                    //check if the first array is empty
                            numbers.set(i, second.get(0));                      //set the first number in the original array with the lower number in the second array
                            second.remove(0);                                   //remove that number from the second array
                        } else{                                                 //make sure only one of these operations happens only once
                            if(second.isEmpty()){                               //check if the second array is empty
                                numbers.set(i, first.get(0));                   //set the first number in the original array with the lower number in the first array
                                first.remove(0);                                //remove that number from the first array
                            }
                        }
                    }
                }
	}
	

}
