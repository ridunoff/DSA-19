import java.util.ArrayList;
import java.util.List;

public class NQueens {


    /**
     * Checks the 45° and 135° diagonals for an existing queen. For example, if the board is a 5x5
     * and you call checkDiagonal(board, 3, 1), The positions checked for an existing queen are
     * marked below with an `x`. The location (3, 1) is marked with an `o`.
     *
     * ....x
     * ...x.
     * x.x..
     * .o...
     * .....
     *
     * Returns true if a Queen is found.
     *
     * Do not modify this function (the tests use it)
     */
    public static boolean checkDiagonal(char[][] board, int r, int c) {
        int y = r - 1;
        int x = c - 1;
        while (y >= 0 && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y--;
        }
        y = r - 1;
        x = c + 1;
        while (y >= 0 && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y--;
        }
        return false;
    }

    public static boolean checkVertical(char[][] board, int c){
        for(int i = 0; i < board.length; i++){
            if(board[i][c]=='Q') return true;
        }
        return false;
    }


    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }


    public static List<char[][]> nQueensSolutions(int n) {
        // TODO
        List<char[][]> answers = new ArrayList<>();
        char[][] current = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                current[i][j] = '.';
            }
        }
        int startRow = 0;

        nQueensHelper(current,startRow,answers);
        return answers;
    }

    public static void printBoard(char[][] board){
        for (int r = 0; r < board.length; r++) {
            System.out.println(new String(board[r]));
        }
    }


    public static void nQueensHelper(char[][] current, int r, List<char[][]> answers){
        //base case
        char[][] temp = copyOf(current);
        if(r == temp.length){
            answers.add(temp);
        }
        else {
            for (int c = 0; c < temp[0].length; c++) {
                if (temp[r][c] != 'Q') {
                    if ((!checkDiagonal(temp, r, c) && !checkVertical(temp, c))) {
                        temp[r][c] = 'Q';
                        nQueensHelper(temp,r+1, answers);
                        temp[r][c] = '.';
                    }
                }
            }
        }
    }


}
