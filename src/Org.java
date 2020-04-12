public class Org {
    /* private var */
    Type type;
    int ttl;

    /* public var */
    //

    /* constructor */
    Org() {
        this.type = Type.EMPTY;
    }

    /* getters */
    Type getType() {
        return this.type;
    }

    /* setters */
    //

    /* toString */
    public String toString() {
        return String.format("Org {\nType: %s\n}\n", this.type.toString());
    }


   /*
     * Maybe food is org specific?
     * Maybe or should be a Type and not an enum
     */
    public enum Type {
      BACTERIA,
      VIRUS,
      CANCER,
      FOOD,
      EMPTY
    }
}