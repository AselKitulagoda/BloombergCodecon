

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
//Your submission should *ONLY* use the following class name
public class Problem {


    static Boolean Oddproblem(ArrayList<Integer> integers, Integer len) {
        Integer count = 0;
        Integer evencount = 0;
        Boolean answer = false;
        for (int i = 0; i < len; i++) {
            count += integers.get(i);
            if (integers.get(i) % 2 == 0) {
                evencount += 1;
            }
        }
        if (((count % 2) == 0) && evencount % 2 == 0) {
            answer = false;
        }
        int oddcount = (len - evencount);
        while ((count % 2) == 1 || oddcount % 2 == 1) {
            for (int i = 0; i < len; i++) {
                if (integers.get(i) % 2 == 1) {
                    integers.remove(i);
                    for (Integer j : integers) {
                        count += j;
                    }
                    oddcount -= 1;
                    if (integers.isEmpty()) {
                        answer = false;
                    }
                }

            }
        }

        for (int i = 0; i < len; i++) {
            count += integers.get(i);
            if (integers.get(i) % 2 == 0) {
                evencount += 1;
            }
        }
        if (((count % 2) == 0) && evencount % 2 == 0) {
            answer = false;
        }

        return answer;
    }



    static void Oddprob(ArrayList<Integer> integers, Integer len) {

        if (Oddproblem(integers, len) == false) {
            System.out.println("NO");
        } else System.out.println("YES");
    }
}





