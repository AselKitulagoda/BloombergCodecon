import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {

    static void multiplayer(int[][] maze, int size_of_grid){
        int Numways[][] = new int[size_of_grid][size_of_grid];
        for (int[] row: Numways)
            Arrays.fill(row, 0);
        Numways[0][0] = 1;
        for (int i=1;i<size_of_grid;i++){
            Numways[0][i] = 1;
        }
        for (int j=1;j<size_of_grid;j++){
            Numways[j][0] = 1;
        }

        for (int i=1; i<size_of_grid;i++){
            for (int j=1;j<size_of_grid;j++){
                Numways[i][j] = Numways[i-1][j] + Numways[i][j-1];
            }
        }
        int counter = 0;
        for (int i=0;i<size_of_grid;i++){
            for (int j=0;j<size_of_grid;j++){
                if (maze[j][i] == 1 && Numways[j][i] != 0){
                    System.out.println("Numways " + Numways[j][i] + " Maze " + maze[j][i]);
                    counter += 1;
                    System.out.println(counter);
                }
            }
        }
        System.out.println(Arrays.deepToString(Numways));
//        System.out.println(Arrays.deepToString(maze));


        System.out.println("Fin counter is "+counter);

    }

    static  int  calculatePaths(int[][] maze, int size_of_grid){

    }








    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file_in = new FileInputStream(new File("src/Q5_inputs/input.txt"));
        System.setIn(file_in);
        Scanner in = new Scanner(System.in);
        System.out.println("Problem finished");
        int size_of_grid = in.nextInt();
        int[][] maze = new int[size_of_grid][size_of_grid];
        for (int i=0;i<size_of_grid;i++){
            String input_string = in.next();
//            System.out.println(input_string);
//            int[] array = new int[size_of_grid];
//            int j = 0;
//            for (char c : input_string.toCharArray())
//                array[j++] = c - '0';
            System.out.println(input_string.charAt(0));

            for (int k=0;k<size_of_grid;k++){
                maze[i][k] = Integer.parseInt(Character.toString(input_string.charAt(k)));
            }

        }
//        System.out.println(Arrays.deepToString(maze));

        multiplayer(maze,size_of_grid);
    }
}
