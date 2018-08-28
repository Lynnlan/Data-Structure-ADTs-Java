package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  
  int size;
  
  public BST(){
	  size=0; 
	  root=null;
  }
  
  //getRoot
  //used for testing, please leave as is
  public BST_Node getRoot(){
	  if(empty()==true) {
		  return null;
	  }else return root;
  }

  //empty
  public boolean empty() {
	  return root==null;
  }
	
  //contains
  public boolean contains(String s) {
	  if(empty()==true) {
		  return false;
	  }else {
		  return root.containsNode(s, root);
	  }
  }

//size
  public int size() {
	  if(empty()==true) {
		  return 0;
	  }else {
		  return root.size(root);
	  }
  }
	
  // height
  public int height() {
	  if(empty()==true) {
		  return -1;
	  }else {
		  return root.getHeight(root);
	  }
  }
  
  //insert
  public boolean insert(String s) {
	  if(empty()) {
		  BST_Node node = new BST_Node(s);
		  root = node;
	  }
	  if(contains(s)==true) {
		  return false;
	  }else {
		  return root.insertNode(s, root);
	  }
  }
	
  //remove
  public boolean remove(String s) {
	  if(contains(s)==false || size()==0) {
		  return false;
	  }else if(s==root.data){
		  if(root.left==null&&root.right==null) {
			  root=null;
		  }else if(root.left==null&&root.right!=null) {
			  root=root.right;
		  }else if(root.left!=null&&root.right==null) {
			  root=root.left;
		  }else {
			  BST_Node temp = new BST_Node(null);
			  temp=root.findMin(root.right);
			  root.removeNode(temp.data, root);
			  root.data=temp.data;
		  }
		  return true;
	  }else{
		  return root.removeNode(s, root);
	  }
  }
	
  //findMin
  public String findMin() {
	  if(empty()==true) {
		  return null;
	  }else {
		  return root.findMin(root).data;
	  }
  }
	
  //findMax
  public String findMax() {
	  if(empty()==true) {
		  return null;
	  }else {
		  return root.findMax(root).data;
	  }
  }
	

}