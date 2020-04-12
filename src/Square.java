public class Square {
    /* private var */
    private int count; /* number of orgs on specific square */
    private Org org;    /* the organism on the square, might make array */

    /* public var */
    //

    /* constructor */
    Square () {
        this.org = new Org();
        this.count = 0;
    }

    /* getters */
    public int getCount() {
        return this.count;
    }
    
    /* setters */
    //

    /* toString */
    public String toString(){
        return String.format("Sqr {\nCount: %d\n\n%s\n}\n", this.count, this.org.toString());
    }
}