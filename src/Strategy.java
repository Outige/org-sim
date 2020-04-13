//! this class should be something else like a bacteria class
//! for example you have curtain data as a bacteria to your advantage
import java.util.Random;
public class Strategy {
    /* const var */
    private static final int EMPTY = 0;
    private static final int FOOD = 1;
    private static final int BACTERIA = 2;
    private static final int VIRUS = 3;
    private static final int CANCER = 4;
    private static int[][] dirs = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    
    private static int[][] append(int[][] array, int x, int y) {
        int[][] result = new int[array.length + 1][2];
        for (int i = 0; i < array.length; i++) {
            result[i][0] =  array[i][0];
            result[i][1] = array[i][1];
        }
        result[array.length][0] = x;
        result[array.length][1] = y;
        return result;
    }
    
    /* helper */
    private static boolean validLoc(int size, int x, int y) {
        if (x >= size || y >= size) return false;
        if (x < 0 || y < 0) return false;
        return true;
    }
    
    /* functions */
    private static int[] bacteriaStrat(Org org, Square[][] board, int x, int y, int[] move) {
        Random rand = new Random();
        int [] result = new int[2];
        // System.out.println(String.format("bac [%d, %d]", x, y));
        int[][] moves = new int[][]{}; //! would prefer to do this "dnamically"

        int x_;
        int y_;
        //! should have a validator
        for (int i = 0; i < 8; i++) {
            x_ = x + dirs[i][0];
            y_ = y + dirs[i][1]; //! will need to validate these
            if (validLoc(board[0].length, x_, y_)) {
                Org o = board[x_][y_].getOrg(0);
                if (o.getType() == EMPTY || o.getType() == FOOD) {
                    moves = append(moves, x_, y_);
                }
            }
        }
        if (moves.length > 0) {
            int r = rand.nextInt(moves.length);
            move[0] = moves[r][0];
            move[1] = moves[r][1];
        } else {
            move[0] = -1;
            move[1] = -1;
        }
        // System.out.println(String.format("move: [%d, %d]", move[0], move[1]));
        return move;
    }

    public static int[] strategy(Org org, Square[][] board, int x, int y, int[] move) {
        if (org.type == BACTERIA) bacteriaStrat(org, board, x, y, move);

        return new int[1];
    }
    
}