package src;

/**
 * Contains methods to perform operations on squares inside the maze
 * 
 * @author Zeph Nord
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */

public class Square {
    public final int SQUARE_SIZE = 50;
    public final int UP = 0;
    public final int RIGHT = 1;
    public final int DOWN = 2;
    public final int LEFT = 3;
    public boolean[] wall = {false, false, false, false};
    public boolean seen;
    public boolean inView;
    public int row;
    public int col;
    public Treasure treasure = null;
    

    /**
     * A constructor to initialize the walls array and the row and column.
     * The booleans to keep track of "seen" and "inView" should default to 
     * false. The Treasure reference starts out null.
     * @param up
     * @param right
     * @param down
     * @param left
     * @param row
     * @param col
     */
    public Square(boolean up, boolean right, boolean down, boolean left,
            int row, int col) {
        // TODO
        this.wall[0] = up;
        this.wall[1] = right;
        this.wall[2] = down;
        this.wall[3] = left;
        this.row = row;
        this.col = col;
        this.seen = false;
        this.inView = false;
    }

    /**
     * a query for a wall in the given direction
     * 
     * @param direction
     * @return
     */
    public boolean wall(int direction) {
        return this.wall[direction];
    }

    /**
     * a query method for seen
     * 
     * @return
     */
    public boolean seen() {
        return seen;
    }

    /**
     * a query method for inView
     * 
     * @return
     */
    public boolean inView() {
        return inView;
    }

    /**
     * a query method for row
     * 
     * @return
     */
    public int row() {
        return row;
    }

    /**
     * a query method for col
     * 
     * @return
     */
    public int col() {
        return col;
    }

    /**
     * a query method for treasure
     * 
     * @return
     */
    public Treasure treasure() {
        return treasure;
    }

    /**
     * a query for the x-value (in pixels) of the upper left corner of the
     * Square. Use row and/or column, and SQUARE_SIZE to determine this.
     * 
     * @return
     */
    public int x() {
        return row  * SQUARE_SIZE;
    }

    /**
     * a query for the y-value (in pixels) of the upper left corner of the
     * Square. Use row and/or column, and SQUARE_SIZE to determine this.
     * 
     * @return
     */
    public int y() {
        return col * SQUARE_SIZE;
    }

    /**
     * a command to tell the Square if it is currently in view of the Explorer.
     * This command should also set the seen variable to true if the value of
     * inView is true. (If it has been in view once then it logically has been
     * seen.)
     * 
     * @param inView
     */
    public void setInView(boolean inView) {
        this.inView = inView;
    }

    /**
     * sets the treasure reference to the parameter t.
     * 
     * @param t
     */
    public void setTreasure(Treasure t) {
        treasure = t;
    }

    /**
     * a command to tell the Square that the Explorer has entered it. Simply
     * check to see if Square contains a Treasure, and if it does, invoke the
     * treasure's setFound() method.
     */
    public void enter() {
        if(treasure() != null)
            treasure.setFound();
    }
}
