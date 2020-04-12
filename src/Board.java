public class Board {
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