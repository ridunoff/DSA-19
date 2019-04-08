import java.util.*;

import static java.lang.Math.abs;


/**
 * Board definition for the 8 Puzzle challenge
 */
public class Board {

    private int n; //size
    public int[][] tiles;

    //TODO
    // Create a 2D array representing the solved board state
    public int[][] goal = {{1,2,3},{4,5,6},{7,8,0}};

    /*
     * Set the global board size and tile state
     */
    public Board(int[][] b) {
        // TODO: Your code here
        tiles = new int[b.length][b.length];
        n=b.length;
        for(int x2=0; x2<n; x2++){
            for(int y2=0;y2<n;y2++){
                tiles[x2][y2] = b[x2][y2];
            }
        }

    }

    /*
     * Size of the board 
     (equal to 3 for 8 puzzle, 4 for 15 puzzle, 5 for 24 puzzle, etc)
     */
    private int size() {
        // TODO: Your code here
        return n;
    }

    /*
     * Sum of the manhattan distances between the tiles and the goal
     */
    public int manhattan() {
        // TODO: Your code here
        int total = 0;
        int currentValue;

        for(int x1=0; x1<n; x1++){
            for(int y1=0; y1<n; y1++){
                currentValue = tiles[x1][y1];

                for(int x2=0; x2<n; x2++){
                    for(int y2=0;y2<n;y2++){
                        if(currentValue == goal[x2][y2] && currentValue!=0){
                            total += abs(x1-x2) + abs(y1-y2);
                        }
                    }
                }
            }
        }

        return total;
    }

    /*
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        // TODO: Your code here
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                if(tiles[x][y] != goal[x][y]){
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * Returns true if the board is solvable
     * Research how to check this without exploring all states
     */
    public boolean solvable() {
        // TODO: Your code here

        int[] tempArr = new int[tiles.length * tiles.length];
        int inv_count = 0;
        int index = 0;

        for(int r=0; r<n; r++){
            for(int c=0;c<n; c++){
                tempArr[index] = tiles[r][c];
                index++;
            }
        }


        for(int i=0; i<tempArr.length;i++){
            Integer tempInt = tempArr[i];
            if(tempInt!=0) {
                int j = i+1;
                while(j<tempArr.length){
                    if(tempArr[j]>0 && tempArr[j] < tempInt){
                        inv_count++;
                    }
                    j++;
                }
            }
        }

        return (inv_count % 2 == 0);
    }

    public int hashCode(){
        int hash = 0;
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles.length; j++)
                hash = hash * 10 + tiles[i][j];
        return hash;
    }


    /*
     * Return all neighboring boards in the state tree
     */
    public Iterable<Board> neighbors() {
        // TODO: Your code here

        List<Board> output = new ArrayList<Board>();


        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){

                if(tiles[x][y] == 0){
                    if(x!=n-1){
                        Board newBoard = new Board(tiles);
                        //x+1 position will become the blank spot

                        newBoard.tiles[x][y] = tiles[x+1][y];
                        newBoard.tiles[x+1][y] = 0;
                        //swap tiles[x][y] (will always be 0) and tiles[x+1][y]
                        output.add(newBoard);

                    }
                    if(y!=n-1){

                        Board newBoard = new Board(tiles);
                        //y+1 position is now the blank spot
                        newBoard.tiles[x][y] = tiles[x][y+1];
                        newBoard.tiles[x][y+1] = 0;
                        output.add(newBoard);

                    }
                    if(y!=0){

                        Board newBoard = new Board(tiles);
                        //y-1 position is now blank
                        newBoard.tiles[x][y] = tiles[x][y-1];
                        newBoard.tiles[x][y-1] = 0;
                        output.add(newBoard);

                    }
                    if(x!=0){

                        Board newBoard = new Board(tiles);
                        //x-1 is now blank
                        newBoard.tiles[x][y] = tiles[x-1][y];
                        newBoard.tiles[x-1][y] = 0;
                        output.add(newBoard);

                    }

                }

            }
        }


        return output;
    }

    /*
     * Check if this board equals a given board state
     */
    @Override
    public boolean equals(Object x) {
        // Check if the board equals an input Board object
        if (x == this) return true;
        if (x == null) return false;
        if (!(x instanceof Board)) return false;
        // Check if the same size
        Board y = (Board) x;
        if (y.tiles.length != n || y.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != y.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can include whatever output you find useful
        int[][] initState = {{1, 2, 3}, {4, 0, 6}, {7, 8, 5}};

        String out1 = new String();
        for(int i=0; i<initState.length; i++){
            for(int j=0; j<initState[0].length; j++){
                out1 = out1 + " " + initState[i][j];
            }
        }
        System.out.println(out1);


        Board board = new Board(initState);

        System.out.println("Size: " + board.size());
        System.out.println("Solvable: " + board.solvable());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Is goal: " + board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
        for(Board n : it){
            String out = new String();
            for(int i=0; i<n.tiles.length; i++){
                for(int j=0; j<n.tiles[0].length; j++){
                    out = out + " " + n.tiles[i][j];
                }
                out = out + " / ";
            }
            System.out.println(out);
        }
    }
}
