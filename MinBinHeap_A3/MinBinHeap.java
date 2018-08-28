package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; //load this array
	private int size;
	private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]
	public MinBinHeap() {
	    this.array = new EntryPair[arraySize];
	    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
	}
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  	public EntryPair[] getHeap() {
	  	return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		int hole = size()+1;
		if(size()==0) array[1]=entry;
		for(array[0]=entry; entry.priority < array[hole/2].priority; hole= hole/2) {
			 array[hole] = array[hole/2];
		 }
		 array[hole] = entry;
	}
	
	@Override
	public void delMin() {
		if(size()==0) {
			System.out.println("Error: null Heap!");
		}else {
			EntryPair temp = new EntryPair(null, 0);
			EntryPair temp1 = new EntryPair(null, 0);
			temp = array[size()];
			array[size()]=null;
		
			int hole = 1;
			while( hole <= size()) {
				if (array[2*hole+1]!=null) {
					temp1 = (array[2*hole].priority<array[2*hole+1].priority)?array[2*hole]:array[2*hole+1];
					if(temp.priority< temp1.priority) {
						array[hole]=temp;
						break;
					}else {
						array[hole]=temp1;
						hole = (array[2*hole].priority<array[2*hole+1].priority)? (2*hole):(2*hole+1);
					}
				} else if(array[2*hole]!=null){
					temp1 = array[2*hole];
					if(temp.priority< temp1.priority) {
						array[hole]=temp;
						break;
					}else {
						array[hole]=temp1;
						array[2*hole]=temp;
						hole = 2*hole;
					}
				}else {
					array[hole]=temp;
					break;
				}
			}
		}
	}
	
	@Override
	public EntryPair getMin() {
		// TODO Auto-generated method stub
		if(size()==0) {
			return null;
		}else {
			return array[1];
		}
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		size=0;
		int i=1;
		while(array[i]!=null){
			i++;
			size++;
		}
		return size;
	}
	
	@Override
	public void build(EntryPair[] entries) {
		for(int i=0; i<entries.length; i++) {
			array[i+1]=entries[i];
		}
		
		for(int i= entries.length/2; i>0; i--) {
			int hole;
			EntryPair temp = new EntryPair(null, 0);
			if(array[2*i+1]==null) {
				hole = 2*i;
				if(array[i].priority >array[hole].priority) {
					temp = array[i];
					array[i]=array[hole];
					array[hole]=temp;
				}
			}else {
				hole = (array[2*i].priority < array[2*i+1].priority)? (2*i):(2*i+1);
				if(array[i].priority >array[hole].priority) {
					temp = array[i];
					array[i]=array[hole];
					array[hole]=temp;
				}
			}
		}
		
		for(int i=1; i<=entries.length/2; i++) {
			int hole;
			EntryPair temp = new EntryPair(null, 0);
			if(array[2*i+1]==null) {
				hole = 2*i;
				if(array[i].priority >array[hole].priority) {
					temp = array[i];
					array[i]=array[hole];
					array[hole]=temp;
				}
			}else {
				hole = (array[2*i].priority < array[2*i+1].priority)? (2*i):(2*i+1);
				if(array[i].priority >array[hole].priority) {
					temp = array[i];
					array[i]=array[hole];
					array[hole]=temp;
				}
			}
		}		
	}
}