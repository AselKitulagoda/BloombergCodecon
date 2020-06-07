import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {

    static void goodieCollector(int no_of_table,int no_of_goodies,int dist_between_tab, int[] table_goodies){

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
        System.out.println(no_of_table);
        System.out.println(no_of_goodies);
        System.out.println(dist_between_tab);
        System.out.println(Arrays.toString(table_goodies));


        goodieCollector(no_of_table,no_of_goodies,dist_between_tab,table_goodies);



        System.out.println("finished problem");
    }
}

