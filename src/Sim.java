import java.util.Random;
public class Sim {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;

    /* private var */
    private final int length;
    private final int maxFood;
    private int running;
    

    /* public var */
    //

    /* constructor */
    Sim(int length, int maxFood) {
        this.length = length;
        this.running = 1;
        this.maxFood = maxFood;
    }

    /* getters */
    //

    /* setters */
    //

    /* helper */
    int countType(Square[][] board, int type) {
        int count = 0;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (board[i][j].getOrg(0).getType() == type) count++;
            }
        }
        return count;
    }

    void reduceTtl(Square[][] board, int i, int j) {
        int ttl = board[i][j].getOrg(0).getTtl()-1;
        if (ttl < 0) return;
        if (ttl == 0) board[i][j].setOrg(0, EMPTY);
        board[i][j].getOrg(0).setTtl(ttl);
    }

    /* functions */
    /* tests if there are any organisms alive */
    boolean isSim(Square[][] board) {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (board[i][j].getOrg(0).getType() != EMPTY) return true;
            }
        }
        return false;
    }

    /* function that adds random food to the map if less then maxfood */
    void placeFood(Square[][] board) {
        Random rand = new Random();
        int x = rand.nextInt(this.length);
        int y = rand.nextInt(this.length);
        if (countType(board, FOOD) >= maxFood) return;
        board[x][y].setOrg(0, FOOD); //! zero for now
        System.out.println(String.format("[%d, %d]", x, y));
    }

    /* function that reduces the ttl of all orgs on the board */
    void reduceAllTtl(Square[][] board) {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                reduceTtl(board, i, j);
            }
        }
    }


    /* toString */
    //
}