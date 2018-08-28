package SPLT_A4;

public class SPLT_Playground {
  public static void main(String[] args){
    genTest();
  }
  
  public static void genTest(){
    SPLT tree= new SPLT();
    /*tree.insert("hello");
    tree.insert("world");
    tree.insert("my");
    tree.insert("name");
    tree.insert("is");
    tree.insert("blank");
    tree.remove("hello");*/
    
    //Message:Case 1: insert(B), insert(A), insert(D), insert(C), insert(E), remove(B), remove(A), remove(D), remove(C), remove(E),empty() == true
    tree.insert("B");
    printLevelOrder(tree);
    tree.insert("A");
    printLevelOrder(tree);
    tree.insert("D");
    printLevelOrder(tree);
    tree.insert("C");
    printLevelOrder(tree);
    tree.insert("E");
    printLevelOrder(tree);
    
    tree.remove("B");
    tree.remove("A");
    tree.remove("D");
    tree.remove("C");
    tree.remove("E");
    System.out.println("size is "+tree.size());
    
    printLevelOrder(tree);
    //Message:NEW 1(zig zag): insert(E), insert(C), insert(F), insert(B), insert(D) in-order = (B, C, D, E, F) && root == D
    //remove test3: Message:Case 3(leaf, REDO): iansert(C), insert(D), insert(B), insert(F), insert(E), remove(C), in-order = (B, D, E, F) && (root == B)
    //remove test6: Message:NEW 0(Complex Root): insert(E), insert(C), insert(F), insert(B), insert(D), remove(D),in-order = (B, C, E, F) && Root==C
  }

    static void printLevelOrder(SPLT tree){ 
    //will print your current tree in Level-Order...Requires a correct height method
    //https://en.wikipedia.org/wiki/Tree_traversal
      int h=tree.getRoot().getHeight();
      System.out.println(h);
      for(int i=0;i<=h;i++){
        System.out.print("Level "+i+":");
        printGivenLevel(tree.getRoot(), i);
        System.out.println();
      }
      
    }
    static void printGivenLevel(BST_Node root,int level){
      if(root==null)return;
      if(level==0)System.out.print(root.data+" ");
      else if(level>0){
        printGivenLevel(root.left,level-1);
        printGivenLevel(root.right,level-1);
      }
    }
   static void printInOrder(BST_Node root){
      if(root!=null){
      printInOrder(root.getLeft());
      System.out.print(root.getData()+" ");
      printInOrder(root.getRight());
      }
  }
  
}
