import java.util.*;

public class Bacteria extends Org {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;
    private final int[][] directions = new int[][]{ {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    /* constructor */
    Bacteria(int ttl) {
        setType(BACTERIA);
        setTtl(ttl);
        setMoved(0);
    }

    /* helper */
    private boolean inBounds(int size, int x, int y) {
        if (x >= size || y >= size) return false;
        if (x < 0 || y < 0) return false;
        return true;
    }

    private boolean lookAhead1(ArrayList<Integer> list, Org[][] board) {
        int[] tmp;
        for (int i = 0; i < list.size(); i+=2) {
            if (board[list.get(i)][list.get(i+1)].getType() == FOOD) {
                tmp = new int[2];
                tmp[0] = list.get(i); tmp[1] = list.get(i+1);
                list.clear();
                list.add(tmp[0]); list.add(tmp[1]);
                return true;
            }
        }
        return false;
    }

    //! could make this x if i wanted, but I don't want bacteria to be opop
    private boolean lookAhead2(int size, int x, int y, ArrayList<Integer> list, Org[][] board) {
        int[] tmp;
        for (int[] dir: this.directions) {
            if (inBounds(size, x+dir[0]*2, y+dir[1]*2)) {
                if (board[x+dir[0]*2][y+dir[1]*2].getType() == FOOD) {
                    list.clear();
                    list.add(x+dir[0]*1); list.add(y+dir[1]*1); //! see how you're just guiding in right dir
                    // System.out.println(String.format("found 2 a head [%d, %d] [%d, %d]", x, y, x+dir[0]*2, y+dir[1]*2));
                    return true;
                }
            }
        }
        return false;
    }

    private void getOrgPosns(Org[][] board, int size, ArrayList<Integer> list, int org) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].getType() == org) {
                    list.add(i);
                    list.add(j);
                }
            }
        }
    }

    private void findClosestFood(int size, ArrayList<Integer> list, Org[][] board) {
        Random r = new Random();
        ArrayList<Integer> f = new ArrayList<Integer>();
        int min; int index; int dist; int[] tmp;
        min = size*size+1; index = 0;
        getOrgPosns(board, size, f, FOOD);
        
        for (int i = 0; i < list.size(); i+=2) {
            for (int j = 0; j < f.size(); j+=2) {
                dist = (f.get(j)-list.get(i))*(f.get(j)-list.get(i)) 
                + (f.get(j+1)-list.get(i+1))*(f.get(j+1)-list.get(i+1));
                    // System.out.println(String.format("food: [%d, %d]\nmove [%d, %d]\ndist: %d", f.get(j), f.get(j+1), list.get(i), list.get(i+1), dist));
                    if (dist < min) {
                    min = dist;
                    index = i;
                }
            }
        }
        if (list.size() == 0) return;

        /* if no food on board return random entry from move list */
        if (min == size*size+1) {
            index = r.nextInt(list.size()/2);
            if (index %2 == 1) index -= 1;
        }

        /* make move list the best move */
        tmp = new int[2];
        tmp[0] = list.get(index); tmp[1] = list.get(index+1);
        list.clear();
        list.add(tmp[0]); list.add(tmp[1]);
    }

    boolean canMove(int x, int y, ArrayList<Integer> list, Org[][] board) {
        if (board[x][y].getType() == FOOD || board[x][y].getType() == EMPTY) return true;
        return false;
    }

    /* functions */
    public void getMove(int size, int x, int y, ArrayList<Integer> list, Org[][] board) {
        Random r = new Random(); int pos; int [] tmp;
        for (int[] dir: this.directions) {
            if (!inBounds(size, x+dir[0], y+dir[1])) continue;
            if (canMove(x+dir[0], y+dir[1], list, board)) {
                /* reducing move list to valid moves */
                list.add(x+dir[0]);
                list.add(y+dir[1]);
            }
        }
        findClosestFood(size, list, board);
    }
}