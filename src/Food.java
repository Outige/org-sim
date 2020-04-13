public class Food extends Org {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;

    /* constructor */
    Food(int ttl) {
        setType(FOOD);
        setTtl(ttl);
        setMoved(0);
    }
}