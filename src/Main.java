/* TODOS
 * Will probably make different classes for Orgs, ie food...
 * Might try inheritance so orgs can inherit
 * I want to use enums instead of const
 */
public class Main {
    /* const var */
    private static final int EMPTY = 0;
    private static final int FOOD = 1;
    private static final int BACTERIA = 2;
    private static final int VIRUS = 3;
    private static final int CANCER = 4;
    static final int BOARD_SIZE = 8;
    
    public static void main(String[] args) {
        Board board = new Board(BOARD_SIZE);
        Sim sim = new Sim(BOARD_SIZE);

        /* sim */
        // while (true) {
        // sim.playOrg(board, FOOD);
        // sim.playOrg(board, BACTERIA);

        // board.print_board();

        // sim.moveOrgs(board);
        // sim.reduceAllTtl(board);
        // board.print_board();
        // }

        sim.playOrg(board, FOOD);
        sim.playOrg(board, BACTERIA);
        do {
            board.print_board();
            sim.moveOrgs(board);
            sim.reduceAllTtl(board);
        } while (sim.isSim(board));
        board.print_board();
    }
}