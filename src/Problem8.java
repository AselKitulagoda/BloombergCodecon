import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem8 {


    static void getMinimumFI(List<Path> paths, int no_of_paths, int no_of_locations, List <Query> queries, int no_of_queries){
        for (int i=0;i<no_of_queries;i++){
            int start_loc_for_query = queries.get(i).start;
            int end_loc_for_query = queries.get(i).end;
            List<Path> visited_paths = new ArrayList<Path>();
            List <Path> paths_around_startloc = getSurroundingNodes(start_loc_for_query,paths);
            System.out.println(paths_around_startloc);

        }
    }

    static  int minCost(List<Path> paths, int no_of_paths,int )

    static List<Path> getSurroundingNodes(int start_loc_for_query,List<Path> paths){
        List <Path> result = paths.stream().filter(path-> (path.start == start_loc_for_query || path.end == start_loc_for_query)).collect(Collectors.toList());
        for (Path i:result){
            if (i.end == start_loc_for_query){
                i.end = i.start;
                i.start = start_loc_for_query;

            }
        }
        return result;
    }



    public static class Path{
        Integer start;
        Integer end;
        Integer FI;
        public Path(Integer start, Integer end, Integer FI){
            this.start = start;
            this.end = end;
            this.FI = FI;
        }

        @Override
        public boolean equals(Object obj) {
            Path temp = (Path) obj;
            if (temp.start == this.start && temp.end == this.end && temp.FI == this.FI){
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (this.start.hashCode() + this.end.hashCode() + this.FI.hashCode());
        }

        @Override
        public String toString() {
            return ("PATH Start loc: " + this.start + " End loc: " + this.end  + " FI : " + this.FI + "\n");
        }
    }

    public static class Query{
        Integer start;
        Integer end;
        public Query(Integer start, Integer end){
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            Query temp = (Query) obj;
            if (temp.start == this.start && temp.end == this.end ){
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (this.start.hashCode() + this.end.hashCode() );
        }

        @Override
        public String toString() {
            return ("QUERY Start loc: " + this.start + " End loc: " + this.end + "\n");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file_in = new FileInputStream(new File("src/Q8_inputs/input.txt"));
        System.setIn(file_in);
        Scanner in = new Scanner(System.in);

        int no_of_locations = in.nextInt();
        int no_of_paths = in.nextInt();
        List <Path> paths = new ArrayList<>();

        for (int i=0;i<no_of_paths;i++){
            paths.add(new Path(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        int no_of_queries = in.nextInt();
        List<Query> queries = new ArrayList<>();
        for (int i=0;i<no_of_queries;i++){
            queries.add(new Query(in.nextInt(), in.nextInt()));
        }

        getMinimumFI(paths,no_of_paths,no_of_locations,queries,no_of_queries);


        System.out.println(paths);
        System.out.println(queries);




        System.out.println("Problem finished");
    }
}
