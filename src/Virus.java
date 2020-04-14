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

    /* functions */
    
}