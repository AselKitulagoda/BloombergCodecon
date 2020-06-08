import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem7 {

    static int rec_largest_distance(List<Integer> pits,List <Pit> permaPits, int no_of_dragons,int no_of_pits,int rec_pits, Integer Minimize){
//        System.out.println("Minimize is" + Minimize);

        if (rec_pits == no_of_dragons || permaPits.size() == no_of_dragons){
            return Minimize;
        }
            List <Pit> pit_seperation = new ArrayList<Pit>();
            pit_seperation.addAll(permaPits);
//            System.out.println("FOR PIT SEPERATION VAL:" + pit_seperation.get(0).original_val);

        for (int i = 0; i < no_of_pits; i++) {
                if (!containsPit(pit_seperation,pits.get(i)) && !containsPit(permaPits,pits.get(i)) );
                { Pit new_pit = new Pit(getClosestValue(permaPits,pits.get(i)),pits.get(i));
                if (new_pit.seperationValue != 0){
                    pit_seperation.add(new_pit);
                }

                }
            }
            Collections.sort(pit_seperation, (p1, p2) -> Integer.compare(p2.seperationValue, p1.seperationValue));
            System.out.println(pit_seperation);
            while (rec_pits < no_of_dragons){
                for (int i=0;i < no_of_pits-1;i++) {
                    List <Pit> tempPits = permaPits;
                    if (!containsPit(tempPits,pit_seperation.get(i).original_val)) {
                        if (pit_seperation.get(i).seperationValue != 0) {
                            tempPits.add(pit_seperation.get(i));
                            Minimize= Math.min(rec_largest_distance(pits,tempPits,no_of_dragons,no_of_pits,rec_pits+1,pit_seperation.get(i).seperationValue),Minimize);

                        }
                    }
                }
                rec_pits = no_of_dragons;
            }

        return Minimize;
    }



    static Integer getClosestValue(List<Pit> pits,Integer value ){
        int dist = Math.abs(pits.get(0).original_val - value);
        int result = 0;
        for (int i=1;i<pits.size();i++){
            int temp_dist = Math.abs(pits.get(i).original_val - value);
            if (temp_dist < dist){
                result = i;
                dist = temp_dist;
            }
        }
//        System.out.println(pits.get(result));
        return (Math.abs(pits.get(result).original_val-value));
    }

    static boolean containsPit (List<Pit> pits, Integer Val){
        for (Pit i: pits){
            if (i.original_val == Val){
                return  true;
            }
        }
        return false;
    }

    static void min_largest_distance(List<Integer> pits, int no_of_dragons, int no_of_pits){
//        rec_largest_distance(pits,perma,no_of_dragons,no_of_pits);
        for (int i=0;i<no_of_pits;i++){
            int rec_pits = 0;
            List <Pit> perma = new ArrayList<Pit>();
            perma.add(new Pit(0,pits.get(i)));
            System.out.println("MATH MIN "+rec_largest_distance(pits,perma,no_of_dragons,no_of_pits,0,Integer.MAX_VALUE));


        }

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
        FileInputStream file_in = new FileInputStream(new File("src/Q7_inputs/input.txt"));
        System.setIn(file_in);
        Scanner in = new Scanner(System.in);

        int no_of_pits = in.nextInt();
        int no_of_dragons = in.nextInt();

        List <Integer> pits = new ArrayList<Integer>();

        for (int i=0;i<no_of_pits;i++){
            pits.add(in.nextInt());
        }
        Collections.sort(pits);
        System.out.println(pits);

        min_largest_distance(pits,no_of_dragons,no_of_pits);

        System.out.println("Problem finished");

    }
}
