import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Begun");
        ArrayList<Integer> ints = new ArrayList<Integer>(
                Arrays.asList(4,4,5,8,1));

        System.out.println(ints);

        Scanner stdin = new Scanner(System.in);
        System.out.println(stdin.nextLine());
        System.out.println();
        Problem.Oddprob(ints,5);
        while(stdin.hasNextLine())
        {

        }
        stdin.close();
    }}
