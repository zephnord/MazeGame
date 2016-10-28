package src;

/**
 * Contains the class and method implementations for Explorer, extends Occupant
 * abstract class.
 * 
 * @author Zeph Nord
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */

public class Explorer extends Occupant {
    private String name;
    private Maze maze; // reference to the Maze occupant/explorer is in

    /**
     * a constructor to initialize all the instance variables. Lastly, be sure
     * to call the lookAround method of the Maze to reveal the squares that the
     * Explorer can initially see.
     * 
     * @param location
     * @param maze
     * @param name
     */
    public Explorer(Square location, Maze maze, String name) {
        // TODO
    }

    /**
     * a query for the name
     * 
     * @return
     */
    public String name() {
        return name;
    }

    /**
     * Commands the Explorer to move a direction in the Maze based on a key
     * press from the user. This differentiates between a randomOccupant and an
     * Explorer that responds to input.
     * 
     * @param key
     */
    public void move(int key) {
        // TODO
    }

    // TODO
    // Possibly need to put in class getter methods

    /**
     * Commands the Explorer to move to another Square in the Maze Actual moving
     * of the Explorer is done via its parent's moveTo method.
     * 
     * @param s
     */
    public void moveTo(Square s) {
        // TODO
    }
}
