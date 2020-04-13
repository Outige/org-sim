public class Empty extends Org {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;

    /* constructor */
    Empty() {
        setType(EMPTY);
        setTtl(0);
    }
}