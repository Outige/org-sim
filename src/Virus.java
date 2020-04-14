import java.util.*;

public class Virus extends Org {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;
    private final int[][] directions = new int[][]{ {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    /* constructor */
    Virus(int ttl) {
        setType(VIRUS);
        setTtl(ttl);
        setMoved(0);
    }

    private boolean inBounds(int size, int x, int y) {
        if (x >= size || y >= size) return false;
        if (x < 0 || y < 0) return false;
        return true;
    }

    private boolean canMove(int x, int y, Org[][] board) {
        if (board[x][y].getType() == FOOD || board[x][y].getType() == BACTERIA) return true;
        return false;
    }

    /* functions */
    public void getMove(int size, int x, int y, ArrayList<Integer> list, Org[][] board) {
        Random r = new Random(); int pos; int [] tmp;
        for (int[] dir: this.directions) {
            if (!inBounds(size, x+dir[0], y+dir[1])) continue;
            if (canMove(x+dir[0], y+dir[1], board)) {
                /* reducing move list to valid moves */
                list.add(x+dir[0]);
                list.add(y+dir[1]);
            }
        }

        if (list.size() == 0) return;

        /* return random move */
        pos = r.nextInt(list.size()/2);
        if (pos % 2 == 1) pos-=1;
        tmp = new int[2];
        tmp[0] = list.get(pos); tmp[1] = list.get(pos+1);
        list.clear();
        list.add(tmp[0]); list.add(tmp[1]);
    }
}