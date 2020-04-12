public class Org {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;
    private final int DEFAULT_TTL = 5;

    /* private var */
    int type;
    int ttl;

    /* public var */
    //

    /* constructor */
    Org() {
        this.type = EMPTY;
        this.ttl = DEFAULT_TTL;
    }

    /* getters */
    int getType() {
        return this.type;
    }

    int getTtl() {
        return this.ttl;
    }

    /* setters */
    void setType(int type) {
        this.type = type;
    }

    void setTtl(int ttl) {
        this.ttl = ttl;
    }

    /* toString */
    public String toString() {
        return String.format("Org {\nType: %d\n}\n", this.type);
    }
}