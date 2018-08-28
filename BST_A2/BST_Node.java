package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){
	  this.data=data;
  }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

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

  //containNode
  public boolean containsNode(String s, BST_Node node){
	  
	  if(node==null) return false;
	  
	  int compareResult = s.compareTo(node.data);
	  
	  if(compareResult<0) {
		  return containsNode(s, node.left);
	  }else if(compareResult>0) {
		  return containsNode(s, node.right);
	  }else 
		  return true;
  }
  
  public boolean insertNode(String s, BST_Node node) {
	  
	 BST_Node newNode = new BST_Node(s);
	 if(node==null) {
		  node = newNode;
		  return true;
	  }else {
		  if(s.compareTo(node.data)<0) {
			  if(node.left!=null)
				  return insertNode(s, node.left);	
			  else{
				  node.left = newNode;
				  return true;
			  }
		  }else if(s.compareTo(node.data)>0) {
			  if(node.right!=null) 
				  return insertNode(s, node.right);
			  else{
				  node.right = newNode;
				  return true;
			  }
		  }
	}
	return true;
  }
  
  public boolean removeNode(String s,BST_Node node){
	  
	  BST_Node currentNode = node;
	  BST_Node parentNode = node; 
	  BST_Node successor = null;
	  boolean isLeftChild = false;
	  
	  // find elt to be removed, and whether it's in leftChildTree
	  while (currentNode.data != s) {  
          parentNode = currentNode;  
          if (s.compareTo(currentNode.data)<0) {  
              isLeftChild = true;   
              if(currentNode.left!=null){  
                  parentNode=currentNode; 
                  currentNode=currentNode.left;  
              } 
              
          } else {  
              isLeftChild = false;  
              if(currentNode.right!=null){  
                  parentNode=currentNode;  
                  currentNode=currentNode.right;  
              }  
          }  
      }
	  
	  if(currentNode.left==null && currentNode.right==null) {
		  // remove leave
		  if(isLeftChild==true) {
			  parentNode.left = null;
		  }else {
			  parentNode.right = null;
		  }
		  return true;
	  }
	  else if(currentNode.left==null && currentNode.right!=null) {
		  // remove one elt which has only right child
		  if(isLeftChild){ 
			  parentNode.left=currentNode.right;
		  }else{  
			  parentNode.right=currentNode.right;
		  } 
	  }
	 else if(currentNode.left!=null && currentNode.right==null) {
		// remove one elt which has only left child
		  if(isLeftChild){  
        	  	parentNode.left=currentNode.left;
          }else{  
        	  	parentNode.right=currentNode.left;
          }  
	  } else {
		  // remove one elt which has 2 children
		  successor=findMin(currentNode.right);
	  	  removeNode(successor.data, node);
		  currentNode.data=successor.data;
	  }
	  return true;
  }
  
  //findMin
  public BST_Node findMin(BST_Node node){
	  if(node==null)
		  return null;
	  else if( node.left == null )
		  return node;
	  
	  return findMin(node.left);
  }
  
  //findMax
  public BST_Node findMax(BST_Node node){
	  if(node==null)
		  return null;
	  else if (node.right==null)
		  return node;
	  
	  return findMax(node.right);
  }
  
  //height
  public int getHeight(BST_Node node){
	  if(node == null) {
			 return -1;
		 }else {
			 int i = getHeight(node.left);
			 int j = getHeight(node.right);
			 return (i<j)?(j+1):(i+1);
		 }
  }

  // --- end fill in these methods --------------------------------------
  
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
  
  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+ this.data + ", Left: "+ ((this.left!=null)? left.data:"null")
            + ",Right: " + ((this.right!=null)?right.data:"null");
  }

}