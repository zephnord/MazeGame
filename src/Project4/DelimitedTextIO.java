import java.util.Scanner;

/**
 * Contains the DelimitedTextIO interface
 * 
 * @author Zeph Nord
 * @author
 * @version Project 4
 * @version CPE102-5
 * @version Fall 2016
 */
public interface DelimitedTextIO {
    /**
     * Retuns a String containing all the data of the implementing class as text
     * and with each element separated by the provided delimiter.
     */
    public String toText(char delimiter);

    /**
     * Uses the provided Scanner input to parse delimited text representing the
     * data for the implementing class and initializes the objects instance
     * variables with the parsed values. The delimiter to use must be specified
     * for the Scanner input before calling this method.
     */
    public void toObject(Scanner input);
}
