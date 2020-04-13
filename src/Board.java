import java.util.*;
public class Board {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;

    //! this will be passed in a params
    private final int DEF_TTL = 5;

    /* private var */
    private final int length;
    Org[][] board;

    /* public var */
    //

    /* constructor */
    Board(int length) {
        this.length = length;
        this.board = new Org[this.length][this.length];
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                this.board[i][j] = new Empty();
            }
        }
    }

    /* getters */
    //! this seems shit
    int getType(int x, int y) {
        return board[x][y].type;
    }

    int getMoved(int x, int y) {
        return board[x][y].moved;
    }

    /* setters */
    void setMoved(int x, int y, int set) {
        board[x][y].setMoved(set);
    }

    public void setEmpty(int x, int y) {
        this.board[x][y] = new Empty();
    }

    public void setFood(int x, int y) {
        this.board[x][y] = new Food(DEF_TTL);
    }

    public void setBacteria(int x, int y) {
        this.board[x][y] = new Bacteria(DEF_TTL);
    }

    /* helper */
    void print_board() {
        String string = "";
        for (int i = 0; i < this.length; i++) {
            string += String.format("%d\t", i);
        }
        string += "\n";
        for (int i = 0; i < this.length; i++) {
            string += String.format("- - -\t");
        }
        string += "\n";
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (this.board[i][j].getTtl() > 0)
                    string += String.format("%d, %d\t", this.board[i][j].getType(), this.board[i][j].getTtl());
                else
                    string += String.format("%d\t", this.board[i][j].getType());

            }
            string += String.format("|%d", i);
            string += "\n";
        }

        System.out.println(string);
    }

    public void resetMoved() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                board[i][j].setMoved(0);
            }
        }
    }

    /* functions */
    public int countOrg(int org) {
        int count = 0;
        for (Org[] orgs: this.board) {
            for (Org o: orgs) {
                if (o.getType() == org) count+=1;
            }
        }

        return count;
    }

    public void getOrgPosns(int org, ArrayList<Integer> list) {
        int count = 0;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (this.board[i][j].getType() == org) {
                    list.add(i);
                    list.add(j);
                }
            }
        }
    }

    public void reduceTtl(int x, int y) {
        int ttl = board[x][y].getTtl();
        if (ttl > 1)
            board[x][y].setTtl(ttl-1);
        else
            board[x][y] = new Empty();
    }

    public void getMoveList(int size, int x, int y, ArrayList<Integer> list) {
        //! this is gonna be a huge case statement
        Org org = board[x][y];
        if (org.getType() == BACTERIA) {
            ((Bacteria) org).getMoveList(size, x, y, list);
        }
    }

    public void moveOrg(int x0, int y0, int x1, int y1) {
        //! gonna be a big switch statement
        if (board[x0][y0].getType() == BACTERIA) {
        if (board[x1][y1].getType() == FOOD) {
        board[x1][y1] = new Bacteria(DEF_TTL);
                board[x0][y0] = new Empty();
            } else if (board[x1][y1].getType() == EMPTY) {
        board[x1][y1] = new Bacteria(board[x0][y0].getTtl());
                board[x0][y0] = new Empty();
            }
        }
    }
}