package SPLT_A4;

public class SPLT implements SPLT_Interface{
	private BST_Node root;
	private int size;
	public SPLT() {
		this.size = 0;
	} 
	
	public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
		return this.root;
	}
	
	@Override
	public void insert(String s) {
		if (empty()) {
			root = new BST_Node(s);
		}else {
			root = root.insertNode(s);
		}
		
		if(root.justMade) {
			size +=1;
			root.justMade = false;
		}
	}
	
	@Override
	public void remove(String s) {
		if ((root == null) || (!contains(s))) {
		      return;
		}
		if (root.left == null){
			root = root.right;
		} else {
			BST_Node R = root.right;
			if(R!=null) 
				root = root.left.findMax();
			else 
				root = root.left;
			
		    if (R != null) {
		        root.right = R;
		    }
		    if (root.right != null) {
		        root.right.parent = root;
		    }
		 }
		    
		if (root != null) {
			root.parent = null;
		}
		
		this.size -= 1;
	}

	@Override
	public String findMin() {
	    if (empty()==true) {
	        return null;
	    }
	    root = root.findMin();
	    return root.data;
		
	}

	@Override
	public String findMax() {
		if(empty()==true) {
			  return null;
		}
		this.root = root.findMax();
		return root.data;
	}

	@Override
	public boolean empty() {
		return root == null;
	}

	@Override
	public boolean contains(String s) {		
		if (root == null) {
		      return false;
		}
		root = root.containsNode(s);
		return root.data.equals(s);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int height() {
		if(empty()==true) {
			  return -1;
		  }else {
			  return root.getHeight();
		}
	}


}