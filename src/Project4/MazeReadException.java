/**
 * Creates an exception whenever certain errors occur when reading a maze from a file
 * 
 * @author Zeph Nord
 * @author Joseph DeLuca
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */

public class MazeReadException extends Exception {
    /**
     * Messages
     * "Rows and columns not specified."
     * "Duplicate square."
     * "Unknown Type."
     * "Line format or other error."
     */
    private String line; //the full line at which the error occured
    private int lineNumber; //the number of the line at which the error occured

    /**
     * Constructor for the exception
     */
    public MazeReadException(String message, String line, int lineNumber){
        super(message); //sets the message instance variable in the superclass
        this.line = line;
        this.lineNumber = lineNumber;
    }

    /**
     * Accessor methods for the instance variables
     */
    public String getLine(){
        return this.line;
    }

    public int getLineNum(){
        return this.lineNumber;
    }

    /*
     * creates an output for the exception
     */
    /*public String toString(){
        return getMessage() + "\n\tLine Contents: " + getLine() + "\n\tLine Number: " + getLineNumber(); 
    }*/
}