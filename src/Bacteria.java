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
                    System.out.println(String.format("found 2 a head [%d, %d] [%d, %d]", x, y, x+dir[0]*2, y+dir[1]*2));
                    return true;
                }
            }
        }
        return false;
    }

    /* functions */
    public void getMove(int size, int x, int y, ArrayList<Integer> list, Org[][] board) {
        Random r = new Random(); int pos; int [] tmp;
        for (int[] dir: this.directions) {
            if (inBounds(size, x+dir[0], y+dir[1])) {
                list.add(x+dir[0]);
                list.add(y+dir[1]);
            }
        }
        if (list.size() == 0) return;
        /* send back 1 look ahead */
        if (lookAhead1(list, board))
            return;
        
        /* send back 2 look */
        if (lookAhead2(size, x, y, list, board))
            return;

        /* send back random */
        pos = r.nextInt(list.size()/2);
        if (pos %2 == 1) pos -= 1;
        tmp = new int[2];
        tmp[0] = list.get(pos); tmp[1] = list.get(pos+1);
        list.clear();
        list.add(tmp[0]); list.add(tmp[1]);
    }
}