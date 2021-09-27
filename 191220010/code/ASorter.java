package code;

public class ASorter implements Sorter {

    private int[] a;
    

    @Override
    public void load(int[] a) {
        this.a=a;
        /*for(int i=0;i<b.length;i++){
            this.a[a[i]]=b[i];
        }*/
    }

    

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        asort();
    }

    public int getParentIndex(int child) {
        return (child - 1) / 2;
    }
    public int getLeftChildIndex(int parent) {
        return 2 * parent + 1;
    }

    public void adjustHeap(int i, int len) {
        int left, right, j;
        left = getLeftChildIndex(i);
        while (left <= len) {
            right = left + 1;
            j = left;
            if (j < len && a[left] < a[right]) {
                j++;
            }
            if (a[i] < a[j]) {
                swap( i, j);
                i = j;
                left = getLeftChildIndex(i);
            } else {
                break; 
            }
        }
    }

    public void asort() {
        int last = a.length - 1;
        
        for (int i = getParentIndex(last); i >= 0; --i) {
            adjustHeap(i, last);
        }
        
        while (last >= 0) {
            swap(0, last--);
            adjustHeap(0, last);
        }
    }
    @Override
    public String getPlan() {
        return this.plan;
    }

    
       
    
}