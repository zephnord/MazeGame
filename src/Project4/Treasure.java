import java.util.Scanner;

/**
 * Contains the class Treasure that extends RandomOccupant to model a Treasure
 * 
 * @author Zeph Nord
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */

public class Treasure extends RandomOccupant {
    private boolean found;

    /**
     * constructor to randomly locate itself in the Maze. (Remember, the parent
     * of this class is RandomOccupant.)
     * 
     * @param maze
     */
    public Treasure(Maze maze) {
        super(maze);
        this.found = false;
        super.location().setTreasure(this);
    }

    /**
     * constructor to randomly locate itself in the Maze using a seed.
     * 
     * @param maze
     * @param seed
     */
    public Treasure(Maze maze, long seed) {
        super(maze, seed);
        this.found = false;
        super.location().setTreasure(this);
    }

    /**
     * constructor to generate a Treasure in a specified location in the Maze.
     * 
     * @param maze
     * @param location
     */
    public Treasure(Maze maze, Square location) {
        super(maze, location);
        this.found = false;
        super.location().setTreasure(this);
    }

    /**
     * query method for the found value
     * 
     * @return
     */
    public boolean found() {
        return found;
    }

    /**
     * sets the found value to true
     */
    public void setFound() {
        found = true;
    }

    /**
     * override the move method of RandomOccupant so that it does nothing. Note
     * that a Treasure may still be moved via the moveTo() method, but cannot
     * move itself randomly about the Maze.
     */
    public void move() {
        // super.moveTo(square);
    }

    /**
     * Override the Occupants moveTo method
     */
    public void moveTo(Square newLoc) {
        if (this.location() != null) {
            this.location().setTreasure(null);
        }
        super.moveTo(newLoc);
        newLoc.setTreasure(this);

    }

    public String toText(char delimiter) {
        return (super.toText(delimiter) + delimiter + found);
    }

    public void toObject(Scanner input) {
        super.toObject(input);
        found = input.nextBoolean();
    }
}