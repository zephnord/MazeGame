import java.util.Scanner;

/**
 * Contains the abstract class Occupant
 * 
 * @author Zeph Nord
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */

public abstract class Occupant {
    private Square square;

    /**
     * Default constructor
     */
    public Occupant() {
    }

    /**
     * Overloaded constructor for Occupant
     * 
     * @param start
     */
    public Occupant(Square start) {
        this.square = start;
    }

    /**
     * a query method for the location
     * 
     * @return
     */
    public Square location() {
        return square;
    }

    /**
     * a command to change the Occupants location
     * 
     * @param newLoc
     */
    public void moveTo(Square newLoc) {
        this.square = newLoc;
    }
    
    public String toText(char delimiter) {        
        return (getClass().getName() + delimiter
                + location().row() + delimiter
                + location().col());
    }
    
    public void toObject(Scanner input) {
        //nothing to operate on
    }
}