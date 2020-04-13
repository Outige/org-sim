/* TODOS
 * Will probably make different classes for Orgs, ie food...
 * Might try inheritance so orgs can inherit
 * I want to use enums instead of const
 */
public class Main {
    static final int BOARD_SIZE = 8;
    public static void main(String[] args) {
        Board board = new Board(BOARD_SIZE);
        Square[][] b = board.getBoard();

        Sim sim = new Sim(BOARD_SIZE);
        sim.placeBacteria(b);
        do  {
            while (sim.placeFood(b) == 0) { //! bs

            }
            
            board.print_board();
            // sim.step(b);
            sim.reduceAllTtl(b);
        } while (sim.isSim(b));
        board.print_board();
    }
}