import java.util.*;
public class Sim {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;

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

    /* helper */
    public void placeOrg(Board board, int x, int y, int org) {
        switch (org) {
            case FOOD:
                board.setFood(x, y);
                break;
            case BACTERIA:
                board.setBacteria(x, y);
                break;
            case VIRUS:
                board.setVirus(x, y);
                break;
            default:
                board.setEmpty(x, y);
        }
    }



    /* 
     * functions 
     */
    public boolean isSim(Board board) {
        if (this.length * this.length - board.countOrg(EMPTY) - board.countOrg(FOOD) > 0) return true;
        return false;
    }

    /* finds a random empty spot to place an organism */
    public void playOrg(Board board, int org, int max) {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (board.countOrg(org) >= max && max > 0) return;
        board.getOrgPosns(EMPTY, list); //! would like to make this work as a tripple pointer instead of having to make full sized array
        if (list.size() == 0) {
            System.out.println("No empty space");
            return; //! should this be an error?
        }
        int pos = r.nextInt(list.size());
        if (pos % 2 == 1) pos-=1;
        placeOrg(board, list.get(pos), list.get(pos+1), org);
    }

    public void reduceAllTtl(Board board) {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                board.reduceTtl(i, j);
            }
        }
    }

    //! gonna make this in board
    public void moveOrg(Board board, int x0, int y0, int x1, int y1) {
        // System.out.println(String.format("[%d, %d] already moved!", x0, y0));
        if (board.getMoved(x0, y0) == 1) {
            return;
        }
        // System.out.println(String.format("[%d, %d]; [%d, %d]", x0, y0, x1, y1));
        board.moveOrg(x0, y0, x1, y1);
        board.setMoved(x1, y1, 1);
    }

    //! perhaps this would be better if you picked a random org from the board
    public void moveOrgs(Board board) {
        Random r = new Random();
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                board.getMove(this.length, i, j, list);
                if (list.size() == 2)
                    moveOrg(board, i, j, list.get(0), list.get(1));
            }
        }
        board.resetMoved();
    }

    private boolean inBounds(int x, int y) {
        if (x >= this.length || y >= this.length) return false;
        if (x < 0 || y < 0) return false;
        return true;
    }

    //! I kind of want this inside of bacteria so that it can have access to the board and I can just call getMoveList... you get me
    public void validateMoveList(Board board, ArrayList<Integer> all) {
        ArrayList<Integer> valid = new ArrayList<Integer>();
        for (int i = 0; i < all.size(); i+=2) {
            if (!inBounds(all.get(i), all.get(i+1))) continue;
            valid.add(all.get(i));
            valid.add(all.get(i+1));
            // System.out.println(String.format("[%d]=[%d, %d]", i/2, all.get(i), all.get(i+1)));
        }

        // this is because I'm lazy and dont want another var in caller to = valid
        while (all.size() > 0) all.remove(0);
        for (int i = 0; i < valid.size(); i++) {
            all.add(valid.get(i));
        }
    }
}