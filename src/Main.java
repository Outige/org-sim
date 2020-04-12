/* TODOS
 * Will probably make different classes for Orgs, ie food...
 * Might try inheritance so orgs can inherit
 * I want to use enums instead of const
 */
public class Main {
    static final int BOARD_SIZE = 8;
    public static void main(String[] args) {
        Board board = new Board(BOARD_SIZE);
        int maxFood = 5;

        Sim sim = new Sim(BOARD_SIZE, 5);
        do  {
            sim.placeFood(board.getBoard());
            board.print_board();
            sim.reduceAllTtl(board.getBoard());
        } while (sim.isSim(board.getBoard()));
    }
}