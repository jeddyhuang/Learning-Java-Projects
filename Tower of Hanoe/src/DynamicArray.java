public class DynamicArray {
	private int[] data;
	private int size;
	
	
	public DynamicArray(){
		data = new int[2];
		size = 0;
	}
	
	/*add element to the end of the list*/
	public void add(int el){
		if(size>= data.length){
			int[] temp = new int[size*2];
			for(int i = 0; i < size;i++){
				temp[i] = data[i];
			}
			data = temp;
		}
		data[size] = el;
		size++;
	}
	
	/*
	 * remove the last element and return the element to the user
	 */
	public int remove(){
		if(size>0){
			size--;
			return data[size];
		}
		return 9999;
	}
	
	public int get(int n){
		if(n<size){
			return data[n];
		}
		
		return -1;
	}
	
	public int size(){
		return size;
	}

	
	/**
	 * return the last element.
	 * @return
	 */
	public int getLast(){
		if(size>0){
			return data[size-1];
		}else{
			return 9999999;
		}
	}
	
	/**
	 * Remove the element at the specified index. Elements to the right of the
	 * removed element should be shifted to the left.
	 * @param index
	 */
	public void remove(int index){
		if(index < size && index >= 0){
			for(int start = index; start <=size; start++){
				data[start]=data[start+1];
			}
			size = size -1;
		}
		
	}
}
