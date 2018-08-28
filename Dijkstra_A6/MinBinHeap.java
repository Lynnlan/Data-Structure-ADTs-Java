package A6_Dijkstra;

public class MinBinHeap{

    private ShortestPathInfo[] array; //load this array
    private int size;
    private static final int arraySize = 10000;

    public MinBinHeap() {
        this.array = new ShortestPathInfo[arraySize];
        array[0] = new ShortestPathInfo(null, -100000);
    }

	public ShortestPathInfo[] getHeap() {
		return this.array;
	}
	
	public void insert(ShortestPathInfo entry) {
        array[size()+1] = entry;
        bubbleUp(size()+1);
        size++;
	}

	public void delMin() {
        if (array[1] != null) {
            if (array[2] == null) array[1] = null;
            array[1] = array[size()];
            array[size()] = null;
            if (array[2] != null) bubbleDown(1);
            size--;
        }
		
	}

	public ShortestPathInfo getMin() {
		return array[1];
	}

	public int size() {
		return size;
	}

	public void build(ShortestPathInfo[] entries) {
        int idx = 0;
        while (idx < entries.length && entries[idx] != null) {
            array[idx+1] = entries[idx];
            size++;
            idx++;
        }
        for (int i = size() / 2; i > 0; i--) bubbleDown(i);
	}
	
    private void bubbleUp(int idx) {
        int par = getParent(idx);
        if (array[idx].getTotalWeight() < array[par].getTotalWeight()) {
            ShortestPathInfo tmp = array[par];
            array[par] = array[idx];
            array[idx] = tmp;
            if (par != 1) bubbleUp(par);
        }
    }

    private void bubbleDown(int idx) {
        int swp = getLeft(idx);
        if(swp>9999)return;
        if (array[getRight(idx)] != null && array[getRight(idx)].getTotalWeight() < array[swp].getTotalWeight())
            swp = getRight(idx);
        if (array[idx].getTotalWeight() > array[swp].getTotalWeight()) {
            ShortestPathInfo tmp = array[swp];
            array[swp] = array[idx];
            array[idx] = tmp;
            if (getLeft(swp)<9999&& array[getLeft(swp)] != null) bubbleDown(swp);
        }
    }
    
    private int getParent(int i) {
        return i/2;
    }

    private int getLeft(int i) {
        return 2*i;
    }

    private int getRight(int i) {
        return 2*i+1;
    }


}