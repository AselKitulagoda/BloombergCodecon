import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem3 {
    /* Upon arrival at an international airport, passengers must go through passport control. They are arranged
in a line and must go to the lowest numbered available passport control booth, where a border agent will
check their travel documents.
Passengers can come alone or in groups. You should assume that every passenger will get through
passport control after 1 minute, so a group of 5 passengers will have all its checks completed after 5
minutes. Each group of passengers will be processed by a single border agent.
Each passenger group is immediately assigned to the lowest numbered available border agent, so you
should assume no time is spent for this.
Case 1: The group of passengers should go to Booth 2
Passengers ---->
Booth 1
Unavailable
Booth 2
Available
Booth 3
Available
...
... Booth N
Available
...
... Booth N
Available
Case 2: The group of passengers should go to Booth 1
Passengers ---->
Booth 1
Available
Booth 2
Available
Booth 3
Unavailable
After checking 10 passenger groups (regardless of size), each border agent is allowed to take a break,
which will make their respective booth unavailable during 5 minutes.
Your task is to count how many groups were through each booth. */

     static void passportControl(List<Integer> booths_avail, List<Integer> groups_arr, int avail_booths_size){
        int[] proccessed_groups_for_booth = new int[avail_booths_size];
        int[] isbreak = new int[avail_booths_size];
        int[] breaktime = new int[avail_booths_size];
        Arrays.fill(isbreak,0);
        Arrays.fill(proccessed_groups_for_booth,0);
        Arrays.fill(breaktime,5);
        boolean flag = true;
        while (boothsStillWorking(booths_avail,avail_booths_size) || flag) {
            int current_group;
            if (groups_arr.size() > 0) {
                    current_group = groups_arr.get(0);
                }
                else {
                    current_group = -1;
                }
                int index_of_avail_booth = findAvailableBooth(booths_avail,isbreak,avail_booths_size);
                if (index_of_avail_booth == -1 || current_group == -1 ){
                    for (int i=0;i<avail_booths_size;i++){
                        if (booths_avail.get(i)!=0)
                        booths_avail.set(i,booths_avail.get(i)-1);
                        if (booths_avail.get(i)==0){
                            if (proccessed_groups_for_booth[i] % 10 ==0 && isbreak[i] == 0){
                                isbreak[i] = 1;
                            }
                            if (isbreak[i] == 1){
                                breaktime[i] -= 1;

                            }
                            if (breaktime[i] ==0){
                                isbreak[i] = 0;
                                breaktime[i] = 5;
                            }
                        }
                    }
                }
                if (index_of_avail_booth != -1 && current_group != -1 && flag) {
                    booths_avail.set(index_of_avail_booth, current_group);
                    proccessed_groups_for_booth[index_of_avail_booth] +=1;
                    groups_arr.remove(0);
                    if (groups_arr.size() == 0) {
                        flag = false;
                    }
                    }
        }
         System.out.println(Arrays.toString(proccessed_groups_for_booth));



    }

    public static int findAvailableBooth(List<Integer> booths,int[] isBreak, int available_booths_size){
         for (int i=0;i<available_booths_size;i++){
             if (booths.get(i) == 0 && isBreak[i] == 0){
                 return i;
             }
         }
         return -1;
    }

    public static boolean boothsStillWorking(List<Integer> booths_avail, int avail_booths_size){
         for (int i=0;i<avail_booths_size;i++){
             if (booths_avail.get(i) != 0){
                 return true;
             }
         }
         return false;

    }








    public static void main(String[] args) {
        FileInputStream file_in = null;
        try {
            file_in = new FileInputStream(new File("src/Q3_inputs/input5.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(file_in);
        Scanner in = new Scanner(System.in);
        int available_booths = in.nextInt();
        int number_of_groups = in.nextInt();
        List <Integer> groups_arr = new ArrayList<Integer>();
        List <Integer> booths_avail = new ArrayList<Integer>(Collections.nCopies(available_booths,0));

        for (int i=0;i<number_of_groups;i++){
            groups_arr.add(in.nextInt());
        }

        passportControl(booths_avail,groups_arr,available_booths);




        System.out.println("Problem finished");

    }
}
