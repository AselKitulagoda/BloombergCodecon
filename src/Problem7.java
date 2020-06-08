import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem7 {
    /* Daenerys Targaryen can rule over 7 kingdoms if she has all her dragons by her side.
Daenerys has built N dragon-pits in her kingdom. The dragon-pits are located in a straight line at
positions x1, x2, ..., xN.
She has C dragons. The dragons are feisty and don’t like being restrained. Once they are put into the
dragon-pits they try to burn and bite each other.
Tyrion, being her loyal and intelligent adviser, is given the task of preventing the dragons from hurting
each other. To do so Tyrion wants to assign the dragons such that minimum distance between the
dragons is as large as possible.
Help Tyrion find the largest minimum distance.*/

    public static int largestMinDist(List<Integer> pits,int no_of_dragons){
        int result = -1;
        int left = pits.get(0);
        int right = pits.get(pits.size()-1);

        while (left < right){
            int mid = (left+right)/2;
            if (checkFeasible(pits,no_of_dragons,mid)) {
                result = Math.max(result, mid);
                left = mid + 1;

                }
            else {
                right = mid;
            }
            }
        return result;
        }





    static void min_largest_distance(List<Integer> pits, int no_of_dragons){
        System.out.println(largestMinDist(pits,no_of_dragons));
    }

    static boolean checkFeasible(List<Integer> pits, int no_of_dragons, int mid_distance){
        List <Integer> results = new ArrayList<Integer>();
        int current_pos = pits.get(0);
        int elements =1;
        for (int i=1;i<pits.size();i++){
            if ((pits.get(i) - current_pos)>= mid_distance){
                current_pos = pits.get(i);
                elements += 1;
            }
            if (elements == no_of_dragons){
                return true;
            }

        }
        return false;
    }

    public static class Pit {
        Integer seperationValue;
        Integer original_val;
        public Pit(Integer seperationValue,Integer index_in_original){
            this.seperationValue = seperationValue;
            this.original_val = index_in_original;

        }

        @Override
        public boolean equals(Object obj) {
            Pit temp = (Pit) obj;
            if (temp.original_val == this.original_val && temp.seperationValue == this.seperationValue){
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (this.seperationValue.hashCode() + this.original_val.hashCode());
        }

        @Override
        public String toString() {
            return ("Seperation Value: " + this.seperationValue + " Val: " + this.original_val  + "\n");
        }
    }




    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file_in = new FileInputStream(new File("src/Q7_inputs/input1.txt"));
        System.setIn(file_in);
        Scanner in = new Scanner(System.in);

        int no_of_pits = in.nextInt();
        int no_of_dragons = in.nextInt();

        List <Integer> pits = new ArrayList<Integer>();

        for (int i=0;i<no_of_pits;i++){
            pits.add(in.nextInt());
        }
        Collections.sort(pits);

        min_largest_distance(pits,no_of_dragons);

        System.out.println("Problem finished");

    }
}
