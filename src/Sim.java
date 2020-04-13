import java.util.Random;
public class Sim {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;
    private final int DEFAULT_TTL = 10; //! make this a var from constructor
    private final int MAX_FOOD = 10; //! make this a var from constructor

    /* private var */
    private final int length;
    private int running;
    

    /* public var */
    //

    /* constructor */
    Sim(int length) {
        this.length = length;
        this.running = 1;
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
        // if (board[i][j].getOrg(0).getType() == BACTERIA) {
        //     System.out.println(String.format("Bacteria %d\n", board[i][j].getOrg(0).getTtl()));
        // }
        int ttl = board[i][j].getOrg(0).getTtl()-1;
        if (ttl < 0) return;
        if (ttl > 0 && board[i][j].getOrg(0).getType() == BACTERIA) System.out.println(String.format("bac [%d, %d] ttl: %d\n", i, j, ttl));
        board[i][j].getOrg(0).setTtl(ttl);
        if (ttl == 0 && board[i][j].getOrg(0).getType() != BACTERIA) board[i][j].setOrg(0, EMPTY, 0); //! this doesn't seem to be working

    }

    /* functions */
    /* tests if there are any organisms alive */
    boolean isSim(Square[][] board) {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                Org org = board[i][j].getOrg(0);
                if (org.getType() != EMPTY && org.getType() != FOOD && org.getTtl() != 0) {
                    // System.out.println(String.format("[%d, %d]\nType: %d\nTTL: %d\n", i, j, org.getType(), org.getTtl()));
                    return true;
                }
            }
        }
        return false;
    }

    //! right now we are only having 1 org per square so we must make sure food is on uneque block
    //! just returinging int for now
    /* function that adds random food to the map if less then maxfood */
    int placeFood(Square[][] board) {
        Random rand = new Random();
        int x = rand.nextInt(this.length);
        int y = rand.nextInt(this.length);
        if (countType(board, FOOD) >= MAX_FOOD) return -1; // means no more food
        if (board[x][y].getOrg(0).getType() != 0) return 0; // means food miss
        board[x][y].setOrg(0, FOOD, DEFAULT_TTL); //! zero for now
        System.out.println(String.format("F [%d, %d]", x, y));
        return 1; // means food hit
    }

    //! this will probably be moved to won class along with stratagy, bac will only need to know i and j then come up with list of moves
    //! sim will sort out the legal ones
    void placeBacteria(Square[][] board) {
        Random rand = new Random();
        int x = rand.nextInt(this.length);
        int y = rand.nextInt(this.length);
        board[x][y].setOrg(0, BACTERIA, DEFAULT_TTL); //! zero for now
    }

    /* function that reduces the ttl of all orgs on the board */
    void reduceAllTtl(Square[][] board) {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                reduceTtl(board, i, j);
            }
        }
    }

    // void step(Square[][] board) {
    //     int[] move = new int[2];
    //     for (int i = 0; i < this.length; i++) {
    //         for (int j = 0; j < this.length; j++) {
    //             Org org = board[i][j].getOrg(0);
    //             if (org.getType() != EMPTY && org.getType() != FOOD) {
    //                 // System.out.println(String.format("[%d, %d]", i, j));
    //                 Strategy.strategy(org, board, i, j, move);
    //                 //! this would be make move on backteria as differnt orgs perorm diffent moves
    //                 if (move[0] > -1) {
    //                     Org o = board[move[0]][move[1]].getOrg(0);
    //                     if (o.getType() == FOOD) {
    //                         org.setTtl(DEFAULT_TTL);
    //                     }
    //                     board[move[0]][move[1]].setOrg(0, org);
    //                     // board[i][j].setOrg(i, new Org());
    //                     // org.setTtl(0);
    //                     // org.setType(EMPTY);
    //                     board[i][j].deleteOrg(0);
    //                 }
    //                 // System.out.println(String.format("move: [%d, %d]", move[0], move[1]));

    //             }
    //         }
    //     } 
    // }


    /* toString */
    //
}