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

        int count = 0;
        int bac = 1;
        for (int i = 0; i < bac; i++) {
            sim.playOrg(board, BACTERIA, bac);
        }
        do {
            sim.playOrg(board, FOOD, 5);
            board.print_board();
            sim.moveOrgs(board);
            sim.reduceAllTtl(board);
            
            //! jankey wait
            // long start = System.currentTimeMillis();
            // do {
            // } while ((System.currentTimeMillis() - start) < 1);
            count += 1;
        } while (sim.isSim(board));
        board.print_board();
        System.out.println(String.format("%d rounds", count));
    }
}