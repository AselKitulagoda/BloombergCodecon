
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem4 {
    /*The big day has finally arrived, Bloomberg has come to your university and prepared a fun contest for
you. To satisfy basic student needs, Bloomberg has prepared some tables arranged in a row with some
different goodies including socks, pens, and other useful items. Due to logistic reasons, there is only a
single type of goodie on each table. Two adjacent tables are exactly one metre apart, every table is
considered of negligible width for this problem and the tables are numbered from left to right. Of course,
you want to maximize the number of different goodies you can get. One restriction applies however: as
you do not want to appear greedy to your fellow friends, you want to make sure that between every two
tables you take goodies from there is at least some given distance.*/

    static void goodieCollector(int no_of_table,int no_of_goodies,int dist_between_tab, int[] table_goodies){
        List<Integer> goodieTypescollected = new ArrayList<Integer>();
        if (dist_between_tab > no_of_table) {
            System.out.println("1");
        }
        int[] temp_window ;
        int GoodyTypesFound;
        for (int i=0;i<no_of_table;i++){
            temp_window = table_goodies;
            for (int j=1;j<=dist_between_tab;j++){
                if (i-j > 0 ){
                    table_goodies[i-j] = -1;
                }
                if (i+j < no_of_table){
                    table_goodies[i+j] = -1;
                }
            }
            GoodyTypesFound = countGoodieTypes(temp_window,no_of_table);
            goodieTypescollected.add(GoodyTypesFound);

        }
        System.out.println(Collections.max(goodieTypescollected));
    }

    public static int countGoodieTypes(int[] window,int length_of_window){
        List <Integer> Goodies = new ArrayList<>();
        for (int i=0;i<length_of_window;i++){
            if (!Goodies.contains(window[i]) && window[i] != -1) {
                Goodies.add(window[i]);
            }
        }
        return Goodies.size();
    }


    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file_in = new FileInputStream(new File("src/Q4_inputs/input.txt"));
        System.setIn(file_in);
        Scanner in = new Scanner(System.in);
        int no_of_table = in.nextInt();
        int no_of_goodies = in.nextInt();
        int dist_between_tab = in.nextInt();
        int[] table_goodies = new int [no_of_table];
        for (int i=0;i<no_of_table;i++){
            table_goodies[i] = in.nextInt();
        }
        goodieCollector(no_of_table,no_of_goodies,dist_between_tab,table_goodies);



        System.out.println("finished problem");
    }

    public static class Goodie{
        int GoodyCount;
        int index;
        public Goodie(int GoodyCount, int index){
            this.GoodyCount = GoodyCount;
            this.index = index;

        }
    }
}

