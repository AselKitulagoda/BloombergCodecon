import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem6 {
    /* Henry is a curious student, studying at Hogwarts. Being smarter, faster and displaying more zeal for
magic than other students, he became popular among three witches at the school. They knew Henry has
a secret desire to be a warrior. So each gave him a super power to fight against his enemies.
The first witch gave Henry the power to reduce the strength of his enemies by 1
unit.
The second witch gave Henry the power to divide the strength of his enemies by 2.
The third witch gave Henry the power to divide the strength of his enemies by 3.
The witches clearly told him that the strength of every enemy must remain an integer at all times.
Henry can defeat an enemy when the strength of the enemy equals 1.
K is the initial strength of his enemy. Help Henry to find the minimum number of times he needs to apply
his super powers to defeat the enemy and become a warrior. */

    static Integer calculateNumberofSteps(Integer PowerLevel ){
        if (PowerLevel == 1)
            return 0;
        else if (PowerLevel%3==0 && PowerLevel%2 == 0){
            return 1 + Math.min(calculateNumberofSteps(PowerLevel/3),calculateNumberofSteps(PowerLevel/2));
        }
        else if (PowerLevel%3 ==0){
            return 1 + calculateNumberofSteps(PowerLevel/3);
        }
        else if (PowerLevel%2 == 0){
            return 1 + calculateNumberofSteps(PowerLevel/2);
        }
        else {
            return 1 + calculateNumberofSteps(PowerLevel-1);
        }

    }




    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file_in = new FileInputStream(new File("src/Q6_inputs/input2.txt"));
        System.setIn(file_in);
        Scanner in = new Scanner(System.in);

        Integer enemyPowerLevel = in.nextInt();

        System.out.println(calculateNumberofSteps(enemyPowerLevel));



        System.out.println("Problem finished");
    }
}
