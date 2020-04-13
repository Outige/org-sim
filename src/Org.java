public class Org {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;

    /* private var */
    int type;
    int ttl;
    int moved;

    // Org org;

    /* public var */
    //

    /* constructor */
    Org() {
        this.type = EMPTY;
        this.ttl = 0;
        this.moved = 0;
    }

    /* getters */
    int getType() {
        return this.type;
    }

    int getTtl() {
        return this.ttl;
    }

    public int getMoved() {
        return this.moved;
    }

    /* setters */
    void setType(int type) {
        this.type = type;
    }

    void setTtl(int ttl) {
        this.ttl = ttl;
    }

    void setMoved(int x) {
        this.moved = x;
    }

    /* toString */
    public String toString() {
        return String.format("Org {\nType: %d\n}\n", this.type);
    }
}