package A6_Dijkstra;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
    exTest();
    //exTest();
    }
	
    public static void exTest(){
      DiGraph d = new DiGraph();
      
      printTOPO(d.topoSort());
      printShortestPath(d.shortestPath("f"));
      
    }
    

    
    public static void printTOPO(String[] toPrint){
      System.out.print("TOPO Sort: ");
      for (String string : toPrint) {
      System.out.print(string+" ");
    }
      System.out.println();
    }
    
    public static void printShortestPath(ShortestPathInfo[] list)
    {
      ShortestPathInfo[] arrayOfShortestPathInfo = list;int j = list.length;
      for (int i = 0; i < j; i++)
      {
        ShortestPathInfo s = arrayOfShortestPathInfo[i];
        System.out.println(s);
      }
    }

}