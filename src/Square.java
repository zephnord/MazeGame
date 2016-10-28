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
    public int SQUARE_SIZE = 50;
    public int UP = 0;
    public int RIGHT = 1;
    public int DOWN = 2;
    public int LEFT = 3;

    public Square(boolean up, boolean right, boolean down, boolean left,
            int row, int col) {
        // TODO
    }

    /**
     * a query for a wall in the given direction
     * 
     * @param direction
     * @return
     */
    public boolean wall(int direction) {
        // TODO
        return false;
    }

    /**
     * a query method for seen
     * 
     * @return
     */
    public boolean seen() {
        // TODO
        return false;
    }

    /**
     * a query method for inView
     * 
     * @return
     */
    public boolean inView() {
        // TODO
        return false;
    }

    /**
     * a query method for row
     * 
     * @return
     */
    public int row() {
        // TODO
        return 0;
    }

    /**
     * a query method for col
     * 
     * @return
     */
    public int col() {
        // TODO
        return 0;
    }

    /**
     * a query method for treasure
     * 
     * @return
     */
    public boolean treasure() {
        // TODO
        return false;
    }

    /**
     * a query for the x-value (in pixels) of the upper left corner of the
     * Square. Use row and/or column, and SQUARE_SIZE to determine this.
     * 
     * @return
     */
    public int x() {
        // TODO
        return 0;
    }

    /**
     * a query for the y-value (in pixels) of the upper left corner of the
     * Square. Use row and/or column, and SQUARE_SIZE to determine this.
     * 
     * @return
     */
    public int y() {
        // TODO
        return 0;
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
        // TODO
    }

    /**
     * sets the treasure reference to the parameter t.
     * 
     * @param t
     */
    public void setTreasure(Treasure t) {
        // TODO
    }

    /**
     * a command to tell the Square that the Explorer has entered it. Simply
     * check to see if Square contains a Treasure, and if it does, invoke the
     * treasure's setFound() method.
     */
    public void enter() {
        // TODO
    }
}
