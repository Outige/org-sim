public class Board {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;

    /* private var */
    private final int length;
    Square[][] board;

    /* public var */
    //

    /* constructor */
    Board(int length) {
        this.length = length;
        this.board = new Square[this.length][this.length];
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                this.board[i][j] = new Square();
            }
        }
    }

    /* getters */
    Square[][] getBoard() {
        return this.board;
    }

    /* setters */
    //

    /* helper */
    void print_board() {
        String string = "";
        for (int i = 0; i < this.length; i++) {
            string += String.format("%d\t", i+1);
        }
        string += "\n";
        for (int i = 0; i < this.length; i++) {
            string += String.format("- - -\t", i+1);
        }
        string += "\n";
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                string += String.format("%d\t", this.board[i][j].getOrg(0).getType());
            }
            string += String.format("|%d", i+1);
            string += "\n";
        }

        System.out.println(string);
    }

    /* toString */
    public String toString() {
        String string = "Board {\n";
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                string += String.format("[%d][%d]\n%s", i, j, this.board[i][j]);
            }
        }
        string += " }\n";
        return string;
    }
}