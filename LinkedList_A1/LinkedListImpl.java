
/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	
	Node sentinel; //this will be the entry point to your linked list (the head)

	public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
		sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
	}
  
	//implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
	public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	public boolean insert(double elt, int index) {
		Node p = new Node(elt);
		Node temp = sentinel;
		if(index>size() || index<0) {
			return false;
		}else if(size()==0 && index==0){
			sentinel.prev=sentinel.next=p;
			p.prev=p.next=sentinel;
			return true;
		}else {
			int i=-1;
			while(i<index) {
				temp=temp.next;
				i++;
			}
			temp.prev.next=p;
			p.prev=temp.prev;
			p.next=temp;
			temp.prev=p;
			return true;
		}
	}
	
	public boolean remove(int index) {
		Node temp = sentinel;
		if(index>=size()||index<0) {
			return false;
		}else {
			int i=-1;
			while(i<index) {
				temp=temp.next;
				i++;
			}
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
			return true;
		}
	}
	
	public double get(int index) {
		Node p=sentinel.next;
		int i=0; 
		if(p==null || index>size()) {
			return Double.NaN;
		}else {
			while(!p.equals(sentinel) && i<index) {
				p=p.next;
				i++;
			}
			return p.data;
		}
	}
	
	public int size() {
		Node p=sentinel.next;
		int size=0; 
		if(p==null) {
			return size;
		}else {
			while(!p.equals(sentinel)){
				p=p.next;
				size ++;
			}
			return size;
		}
	}
	
	public boolean isEmpty() {
		if(size()==0){
			return true;
		}else {
			return false;
		}
	}
	
	public void clear() {
		sentinel.next=sentinel.prev=null;
	}
}