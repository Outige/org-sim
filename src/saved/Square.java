public class Square {
    /* const var */
    private final int EMPTY = 0;
    private final int FOOD = 1;
    private final int BACTERIA = 2;
    private final int VIRUS = 3;
    private final int CANCER = 4;

    /* private var */
    private int count; /* number of orgs on specific square */
    private Org[] orgs;    /* the organism on the square, might make array */

    /* public var */
    //

    /* constructor */
    Square () {
        this.orgs = new Org[1];
        this.orgs[0] = new Org();
        this.count = 0;
    }

    /* getters */
    public int getCount() {
        return this.count;
    }

    public Org[] getOrgs() {
        return this.orgs;
    }

    public Org getOrg(int i) {
        return this.orgs[i];
    }
    
    /* setters */
    public void setOrg(int i, int type, int ttl) {
        this.orgs[i].setType(type);
        this.orgs[i].setTtl(ttl);
    }

    public void setOrg(int i, Org org) {
        this.orgs[i].setTtl(org.getTtl());
        this.orgs[i].setType(org.getType());
    }

    /* toString */
    public String toString(){
        // return String.format("Sqr {\nCount: %d\n\n%s\n}\n", this.count, this.org.toString());
        return String.format("todo\n");
    }

    /* functions */
    public void deleteOrg(int i) {
        this.orgs[0] = new Org();
    }
}