import java.util.ArrayList;

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
    }

    /* functions */
    public void getMoveList(int size, int x, int y, ArrayList<Integer> list) {
        // list.add(69);
        for (int[] dir: this.directions) {
            list.add(x+dir[0]);
            list.add(y+dir[1]);
        }
    }
}