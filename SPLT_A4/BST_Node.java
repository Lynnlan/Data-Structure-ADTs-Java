package SPLT_A4;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  BST_Node parent;
  boolean justMade;
  
  BST_Node(String data){
	  this.data=data;
	  this.justMade = true;
  }
  
  BST_Node(String data, BST_Node left, BST_Node right, BST_Node parent){
    this.data = data;
    this.left = left;
    this.right = right;
    this.parent = parent;
    this.justMade = true;
  }
  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return this.data; }
  public BST_Node getLeft(){ return this.left; }
  public BST_Node getRight(){ return this.right; }
  public BST_Node getParent() {return this.parent;}

  // --- end used for testing -------------------------------------------
  
  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations
  
  	// splay
	private void splay(BST_Node toSplay) {
		while (toSplay.parent != null) {
			BST_Node P = toSplay.parent;
			BST_Node G = P.parent;
			//zig
			if (G == null){
				if (toSplay == P.left) {
	        			rotateRight(toSplay);
				} else {
					rotateLeft(toSplay);
				}
			}
	      
			else if (toSplay == P.left){
				if (P == G.left){
	        			rotateRight(P);
	        			rotateRight(toSplay);
				}else{
	        			rotateRight(toSplay);
	        			rotateLeft(toSplay);
				}
			}
	      
			else if (P == G.left){
	    	  		rotateLeft(toSplay);
	    	  		rotateRight(toSplay);
			} else {
	    	  		rotateLeft(P);
	    	  		rotateLeft(toSplay);
			}
		}
	}
	
	// rotate left
	private void rotateLeft(BST_Node toSplay) {
		BST_Node P = toSplay.parent;
		if (P.parent!= null) {
			if (P == P.parent.left) {
				P.parent.left = toSplay;
			} else {
				P.parent.right = toSplay;
			}
		}
	  
		if (toSplay.left != null) {
			toSplay.left.parent = P;
		}
		
		toSplay.parent = P.parent;
		P.parent = toSplay;
		P.right = toSplay.left;
		toSplay.left = P;
		
	}
	
	// rotate right
	private void rotateRight(BST_Node toSplay) {
		BST_Node P = toSplay.parent;
		if (P.parent != null) {
		    if (P == P.parent.left) {
		      P.parent.left = toSplay;
		    } else {
		      P.parent.right = toSplay;
		    }
		}
		  
		if (toSplay.right != null) {
		    toSplay.right.parent = P;
		}
		
		toSplay.parent = P.parent;
		P.parent = toSplay;
		P.left = toSplay.right;
		toSplay.right = P;
	}

	//contain node
	public BST_Node containsNode(String s){ 
		if(this.data.equals(s)) {
			splay(this);
			return this;
		}
		if(this.data.compareTo(s)>0){
			if(this.left==null) {
				splay(this);
				return this;
			}
			return left.containsNode(s);
		}
		if(this.data.compareTo(s)<0){
			if(this.right==null) {
				splay(this);
				return this;
			}
			return right.containsNode(s);
		}
		return null;
	}
	
	//insert node
	public BST_Node insertNode(String s){
		
		if (s.compareTo( data) < 0){
			if( left != null) {
				return  left.insertNode(s);
			}else 
				 left = new BST_Node(s,null,null,this);
			BST_Node toSplay =  left;
			splay(toSplay);
			return toSplay;
	    }
		
	    if (s.compareTo( data) > 0){
	      if ( right != null) {
	        return  right.insertNode(s);
	      }
	       right = new BST_Node(s, null, null, this);
	      BST_Node toSplay =  right;
	      splay(toSplay);
	      return toSplay;
	    }
	    
	    splay(this);
	    return this;
	}
	
	//findMin
  
  //findMin
	public BST_Node findMin(){
	  if (left != null) {
	      return left.findMin();
	  }
	  splay(this);
	  return this;
	}
  
  //findMax
  public BST_Node findMax(){
	  /*BST_Node toSplay = new BST_Node(null);
	  if(node==null) {
		  return null;
	  } else if (node.right==null){
		  toSplay = node;
		  return node;
	  }
	  splay(toSplay);
	  return findMax(node.right);*/
	  if (this.right != null) {
	      return this.right.findMax();
	    }
	  splay(this);
	  return this;
  }
  
  //height
  public int getHeight(){
	  	int l=0;
		int r=0;
		if(left!=null)
			l+=left.getHeight()+1;
		if(right!=null)
			r+=right.getHeight()+1;
	    return l > r ? l : r;
  }
  
  //size
  public int size(BST_Node node){
		 if(node == null) {
			 return 0;
		 }else {
			 int i = size(node.getLeft());
			 int j = size(node.getRight());
			 return i+j+1;
		 }
  }
  
  // toString
  public String toString(){
    return "Data: "+ this.data + ", Left: "+ ((this.left!=null)? left.data:"null")
            + ",Right: " + ((this.right!=null)?right.data:"null");
  }
  

}