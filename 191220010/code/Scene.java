package code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Scene {

    public static void main(String[] args) throws IOException {
        int []lev=new int[256];
        for(int i=0;i<256;i++)
            lev[i]=i;
        for(int i=0;i<256;i++){
            Random r=new Random();
            int a=r.nextInt(255);
            int temp=lev[a];
            lev[a]=lev[i];
            lev[i]=temp;
        }
        int c=0;
        //Line line = new matrix(256);
        Line line = new Line(256);
        for(Gourd g:Gourd.values())
            line.put(g,lev[c++],g.rr());
        Geezer theGeezer = Geezer.getTheGeezer();

        Sorter sorter = new QSorter();
        //Sorter sorter = new ASorter();

        theGeezer.setSorter(sorter);

       String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
