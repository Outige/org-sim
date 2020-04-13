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
    //

    /* setters */
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
                    // a[count][0] = i;
                    // a[count][1] = j;
                    // count += 1;
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

    /* toString */
    // public String toString() {
    //     String string = "Board {\n";
    //     for (int i = 0; i < this.length; i++) {
    //         for (int j = 0; j < this.length; j++) {
    //             string += String.format("[%d][%d]\n%s", i, j, this.board[i][j]);
    //         }
    //     }
    //     string += " }\n";
    //     return string;
    // }
}