import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem5 {
    /* We have two players playing a game on a square grid that contains rewards.
The two players start from the top left cell of the grid and on each move each of them moves down or to
the right.
They move at the same time and need to collaborate to collect the most number of rewards.
They can occupy the same cell in the grid at the same time but the reward, if any exists in the cell, is
collected only once.
The game finishes when there are no more possible moves. */

    static void multiplayer(int[][] maze, int size_of_grid){
        List<Point> Visited_points = new ArrayList<>();
        List<List <Point>> Paths = new ArrayList<>();
        List <Integer> max_points = new ArrayList<>();
        List<Point> rewardPoints = new ArrayList<>();
        for (int i=0;i<size_of_grid;i++){
            for (int j=0;j<size_of_grid;j++){
                if (maze[j][i] == 1){
                    rewardPoints.add(new Point(j,i));
                }

            }
        }
        for (Point i:rewardPoints){
            List <Point> current_path = calculatePaths(maze,size_of_grid,i.x,i.y,Visited_points);
            Paths.add(current_path);
            max_points.add(current_path.size());

        }
        System.out.println(Collections.max(max_points));
    }

    static  List<Point>  calculatePaths(int[][] maze, int size_of_grid, int x, int y, List <Point> VisitedPaths){
        List<Point> results = new ArrayList<>();
        int Numways[][] = new int[size_of_grid][size_of_grid];
        for (int[] row: Numways)
            Arrays.fill(row, 0);
        Numways[x][y] = 1;
        for (int i=x+1;i<size_of_grid;i++){
            Numways[0][i] = 1;
        }
        for (int j=y+1;j<size_of_grid;j++){
            Numways[j][0] = 1;
        }

        for (int i=x+1; i<size_of_grid;i++){
            for (int j=y+1;j<size_of_grid;j++){
                Numways[i][j] = Numways[i-1][j] + Numways[i][j-1];
            }
        }
        for (int i=0;i<size_of_grid;i++){
            for (int j=0;j<size_of_grid;j++){
                if (maze[j][i] == 1 && Numways[j][i] != 0 && !VisitedPaths.contains(new Point(x,y))){
                    results.add(new Point(j,i));
                }
            }
        }



        return results;
    }



    public static class Point {
        Integer x;
        Integer y;
        public Point(Integer x, Integer y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point temp = (Point) obj;
            if (this.x == temp.x && this.y == temp.y){
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (this.x.hashCode() + this.y.hashCode());
        }
    }




    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file_in = new FileInputStream(new File("src/Q5_inputs/input.txt"));
        System.setIn(file_in);
        Scanner in = new Scanner(System.in);
        int size_of_grid = in.nextInt();
        int[][] maze = new int[size_of_grid][size_of_grid];
        for (int i=0;i<size_of_grid;i++){
            String input_string = in.next();
            for (int k=0;k<size_of_grid;k++){
                maze[i][k] = Integer.parseInt(Character.toString(input_string.charAt(k)));
            }

        }

        multiplayer(maze,size_of_grid);
        System.out.println("Problem finished");

    }
}
