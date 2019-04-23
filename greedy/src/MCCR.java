import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class MCCR {
        public static int MCCR(EdgeWeightedGraph G) {
            // TODO
            int minCost = 0;

            Iterator<Integer> vertices = G.vertices.iterator();
            int first = vertices.next();

            IndexPQ pq = new IndexPQ(G.numberOfV());
            pq.insert(first,0);

            HashMap<Integer, Integer> path = new HashMap<>();
            path.put(first,-1);

            HashSet<Integer> isntVisited = new HashSet<>();
            isntVisited.add(first);

            for (Iterator<Integer> v = vertices;v.hasNext();) {
                Integer curr = v.next();
                pq.insert(curr, Integer.MAX_VALUE);
                isntVisited.add(curr);
            }

            while(!pq.isEmpty()){
                Integer currMin = pq.delMin();
                isntVisited.remove(currMin);
                for(Edge e :G.edges(currMin)){
                    int neighbor = e.other(currMin);
                    if(isntVisited.contains(neighbor) && (int)pq.keys[neighbor]>e.weight()){
                        path.put(neighbor,currMin);
                        pq.changeKey(neighbor,e.weight());
                    }
                }
            }

            for(int node: path.keySet()){
                for(Edge e :G.edges(node)) {
                    if(path.get(node)==e.other(node)){
                        minCost+=e.weight();
                    }
                }
            }

                return minCost;
        }

    }

