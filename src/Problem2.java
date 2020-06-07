import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    /* Inspector Catchburgle is on a case! He is chasing a mysterious villain that goes by the name Vile Angus.
Fortunately, Angus has a bad memory and tends to write a lot of things down. And Catchburgle just found
a pile of the scoundrel's notes! There must be lots of valuable clues in them!
However, Angus isn't stupid; he was encrypting his messages with some cipher, so that they are not so
easy to read.
Inspector Catchburgle has applied his brilliant logic, and found out that the villain uses some sort of a
substitution cipher. It seems that he goes over the text multiple times, and each time swaps two letters
in part of the text from a random position to the end.
But that's not all! The bright detective has even figured out the mechanism by which Angus decides
which letters to swap and from which position.
Well, inspector Catchburgle didn't share the details of this mechanism with you, but before he went on a
well deserved coffee break, he wrote down all the substitutions for each encoded message.
Will you, the inspector's assistant, be able to impress the inspector by decoding the messages before he
returns from his coffee break? It will surely help to catch the villain (and you will deserve part of the
credit)*/

    static void decrypt(String message, int[] pos, String[] first_arr, String[] second_arr,int size_of_arr){
        int length_of_message = message.length();
        String temp_message = message;
        String pos_substring = "";
        String replacement_string = "";
        String final_replacement_string = "";
        String regex = "(\\p{Lu})";
        for (int i=size_of_arr-1;i>=0;i--){
            if (pos[i] >= 0 && pos[i] < length_of_message){
                pos_substring = temp_message.substring(pos[i],length_of_message);
                replacement_string = pos_substring.replaceAll(first_arr[i],second_arr[i]);
                final_replacement_string = replacement_string.replaceAll(regex+first_arr[i],second_arr[i].toUpperCase());
                if ((pos_substring.contains("(")) && (pos_substring.contains(")"))){
                    temp_message = temp_message.replaceFirst(pos_substring, final_replacement_string);
                }
                else if (pos_substring.contains(")")) {
                    temp_message = temp_message.replaceFirst("\\)", "").replaceFirst(pos_substring.replaceFirst("\\)", ""), final_replacement_string);
                }
                else if (pos_substring.contains("(")){
                    temp_message=temp_message.replaceFirst("\\(", "").replaceFirst(pos_substring.replaceFirst("\\(", ""),final_replacement_string);

                }
                else {
                    temp_message = temp_message.replaceFirst(pos_substring, final_replacement_string);
                }

            }
        }
        System.out.println(temp_message);
    }

    public static void main(String[] args) {
        FileInputStream file_in = null;
        try {
             file_in = new FileInputStream(new File("src/Q2_inputs/input5.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        System.setIn(file_in);
        Scanner in = new Scanner(file_in);
        String message = in.nextLine();
        int size_of_arr = in.nextInt();
        int[] pos_arr = new int[size_of_arr];
        String[] first_arr = new String[size_of_arr];
        String[] second_arr = new String[size_of_arr];

        for (int i=0;i<size_of_arr;i++){
            pos_arr[i] = in.nextInt();
            first_arr[i] = in.next();
            second_arr[i] = in.next();

        }
        // System.out.println(Arrays.toString(pos_arr));
//        System.out.println(Arrays.toString(first_arr));
//        System.out.println(Arrays.toString(second_arr));

        decrypt(message,pos_arr,second_arr,first_arr,size_of_arr);



        System.out.println("problem finished");
    }
}
