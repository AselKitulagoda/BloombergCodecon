import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem1 {
 /* As part of his religion, your friend hates odd numbers and empty arrays. He hates odd numbers and
empty arrays so much that whenever he encounters an array, he tries to remove some values such that
the resulting array has an even sum. Furthermore, the resulting array must contain a non zero even
amount of even numbers after the transformation. When your friend can not remove any values from the
array such that the array satisfies the conditions given before, he becomes insane. Being a good friend,
you decide to check whether it is safe to give your friend an array.  */

    public static void oddNumberSol(int[] arr,int size_of_arr){
        int sum = IntStream.of(arr).sum();
        int evenNumCount = 0;
        if (sum%2 == 0){
            System.out.println("YES");
        }
        else {
            // sum is odd
            for (int i=0;i<size_of_arr;i++){
                if (arr[i] % 2 == 0){
                    evenNumCount += 1;
                }
                if (evenNumCount > 1){
                    break;
                }
            }
            if (evenNumCount == 1){
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }

    public static void main(String[] args) {
        FileInputStream file_in = null;
        try {
            file_in = new FileInputStream(new File("src/Q1_inputs/Q1_input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        System.setIn(file_in);
        Scanner sc = new Scanner(System.in);
        int size_of_array = sc.nextInt();
        int[] arr = new int[size_of_array];
        for (int i=0;i<size_of_array;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        oddNumberSol(arr,size_of_array);
        System.out.println(Arrays.toString(arr));
        System.out.println("problem run");
    }
}
