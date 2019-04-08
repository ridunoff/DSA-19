/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;


public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;
    private List<Board> output = new ArrayList<>();


    /**
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State {
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves; // equal to g-cost in A*
        public int cost; // equal to f-cost in A*
        private State prev;

        public State(Board board, int moves, State prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            // TODO
            cost = moves + board.manhattan();
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }
    }

    /*
     * Return the root state of a given state
     */
    private State root(State state) {
        // TODO: Your code here
        if(state.prev!=null){
            root(state.prev);
            output.add(state.board);
        }
        return state;
    }

    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */
    public Solver(Board initial) {
        // TODO: Your code here
        HashMap<Board,Integer> visited = new HashMap<>();

        Queue<State> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if(o1.cost < o2.cost) return -1;
            if(o1.cost > o2.cost) return 1;
            return 0;
        });

        State next;

        solutionState = new State(initial, 0 , null);
        priorityQueue.add(solutionState);
        //priorityQueue.();

        visited.put(solutionState.board,solutionState.cost);

        while(!priorityQueue.isEmpty()){
            State curr = priorityQueue.poll();
            if (curr.board.isGoal()) {
                solutionState = curr;
                solved = true;
                minMoves = curr.moves;
                break;
            }
            for(Board b : curr.board.neighbors()) {
                if(visited.getOrDefault(b,null) == null) {
                    next = new State(b, curr.moves + 1, curr);
                    visited.put(b,next.cost);
                    priorityQueue.add(next);
                }else{
                    next = new State(b, curr.moves + 1, curr);
                    if(visited.get(b) > next.cost) {
                        //System.out.println("Shouldnt happen");
                        visited.put(b,next.cost);
                        priorityQueue.add(next);
                    }
                }
            }

        }




    }

    /*
     * Is the input board a solvable state
     * Research how to check this without exploring all states
     */
    public boolean isSolvable() {
        // TODO: Your code here
        return solutionState.board.solvable();
    }


    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution() {
        // TODO: Your code here
        if(!isSolvable()) return null;

        root(solutionState);
        return output;
    }

    public State find(Iterable<State> iter, Board b) {
        for (State s : iter) {
            if (s.board.equals(b)) {
                return s;
            }
        }
        return null;
    }

    /*
     * Debugging space
     */
    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board initial = new Board(initState);

        Solver solver = new Solver(initial);
    }


}
