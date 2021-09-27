package code;


public class matrix extends Line{
    public matrix(int length){
        super(length);
    }

    @Override
    public String toString() {
        String lineString = "\t";
        lineString+='\n';
        int c=0;
        for (Position p :this.pos() ) {
            if(c==16){
                lineString+='\n';
                c=0;
            }
            lineString += p.lin().toString();
            c++;
        }
        return lineString;
    }
}