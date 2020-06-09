import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Problem8 {
    /* Together with your friends, you organize a party in the forest. What would a party be without someone
making a fool of themselves? To help loosen up the atmosphere and make the evening fun, you decide
to create a little game. In this game, everyone has to travel between two places taking up the pre-set
challenges as they come, (which were cunningly prepared by you the previous day). For instance, you
may have to cross a small river over a fallen tree trunk, or you may have to walk some distance with
stilts. To reach the target destination, you might have to use several paths. For every path that you use,
you must take up the challenge along that path.
As you are an absolutely evil person, your goal is not to finish the race first, but to make the others look
more foolish than you. To achieve this, you categorized every path by its potential to make a fool of
yourself and gave every path a FI (Foolishness Index) number. A higher number means that you will very
likely make a fool of yourself. Your goal is now to find how to reach the destination by keeping the
maximum FI number that you encounter as low as possible. The FI number for a sequence of paths is
the maximum FI number of a path of that sequence.
Unfortunately, you do not know yet where the game will start and where it will end. As you suspect that
some configurations are more likely than others (your even more evil friend wants you to fall into the
river), you prepared a list of very likely routes. Every route contains the start location and the end
location. For every route, you want to find out the minimum FI number over all sequences of paths
between the starting location and the ending location.
An empty sequence of paths is considered to have an FI number of 0. Furthermore, there may be
several direct paths between the same locations. There might even be direct paths that loop back to
their start location. All paths can be used in both directions. Finally, at the time that you created the
paths and the corresponding challenges, you made sure that it is always possible to reach every location
from every location. */


    static void getMinimumFI(List<Path> paths, int no_of_paths, int no_of_locations, List <Query> queries, int no_of_queries){
        for (int i=0;i<no_of_queries;i++){
            int start_loc_for_query = queries.get(i).start;
            int end_loc_for_query = queries.get(i).end;
            Node[] visited_paths = new Node[no_of_locations];
            for (int j=0;j<no_of_locations;j++){
                visited_paths[j] = new Node(j+1);
            }
            visited_paths[start_loc_for_query-1].value = start_loc_for_query;
            visited_paths[start_loc_for_query-1].visited = true;
            visited_paths[start_loc_for_query-1].cummu_FI = 0;
            List <Path> paths_around_startloc = getSurroundingNodes(start_loc_for_query,paths,visited_paths);
            Collections.sort(paths_around_startloc,(Path p1, Path p2) -> p1.FI-p2.FI);
            while (visited_paths[end_loc_for_query-1].visited != true){
                for (Path k: paths_around_startloc){
                    visited_paths[k.end-1].cummu_FI = Math.min(k.FI+visited_paths[k.start-1].cummu_FI,visited_paths[k.end-1].cummu_FI);
                }
                int next_node = pickNext(visited_paths,no_of_locations) ;

                if (next_node == -1) break;
                visited_paths[next_node-1].visited = true;

                paths_around_startloc = getSurroundingNodes(next_node,paths,visited_paths);
                Collections.sort(paths_around_startloc,(Path p1, Path p2) -> p1.FI-p2.FI);
            }

            System.out.println(visited_paths[end_loc_for_query-1].cummu_FI);

        }
    }

    static int pickNext(Node[] nodes, int no_of_locations){
        Node CurrentLowest = new Node(-1);
        CurrentLowest.cummu_FI = Integer.MAX_VALUE;
        boolean flag = true;
        for (int i=0;i<no_of_locations;i++){
            if (nodes[i].visited == false && nodes[i].cummu_FI < CurrentLowest.cummu_FI){
                CurrentLowest = nodes[i];
            }
            if (nodes[i].visited == false){
                 flag = false;
            }

        }
        if (flag){
            return -1;
        }
        return CurrentLowest.value;
    }



    static List<Path> getSurroundingNodes(int start_loc_for_query,List<Path> paths, Node[] visited){
        List <Path> result = paths.stream().filter(path-> (path.start == start_loc_for_query || path.end == start_loc_for_query)).collect(Collectors.toList());
        for (Path i:result){
            if (i.end == start_loc_for_query){
                i.end = i.start;
                i.start = start_loc_for_query;
            }
        }
        List <Path> filtered = result;
        if (result.size() > 1){
            Path[] arr = new Path[result.size()];
            result.toArray(arr);
            for (int i=0;i< result.size();i++){
                for (int j=0;j<visited.length;j++){
                    if (arr[i].end == visited[j].value && visited[j].visited == true){
                        filtered.remove(i);
                    }
                }
            }
        }
        return filtered;
    }

    public static class Node{
        Integer value;
        Boolean visited;
        Integer cummu_FI;
        public Node(Integer value){
            this.value = value;
            this.visited = false;
            this.cummu_FI = Integer.MAX_VALUE;
        }

        @Override
        public boolean equals(Object obj) {
            Node temp = (Node) obj;
            if (temp.value == value){
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (value.hashCode());
        }

        @Override
        public String toString() {
            return ("Node value: " + this.value + " cummu_FI: " + this.cummu_FI + " Visited: " + visited + "\n");
        }
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







        System.out.println("Problem finished");
    }
}
