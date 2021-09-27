package code;

public class QSorter implements Sorter {

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a=a;
        /*for(int i=0;i<a.length;i++){
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
        qsort(0, a.length-1);
    }

    public void qsort(int lf,int rt){
        if(lf<rt){
            int q=part(lf, rt);
            qsort(lf, q-1);
            qsort(q+1, rt);
        }
    }
    public int part(int lf,int rt){
        int pivot=a[rt];
        int i=lf-1;
        for(int j=lf;j<rt;j++){
            if(a[j]<pivot){
                i++;
                swap(i, j);
            }
        }
        swap(i+1,rt);
        return i+1;
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}