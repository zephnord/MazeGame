
/**
 * Contains the class Monster that extends RandomOccupant to model a Monster.
 * 
 * @author Zeph Nord
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */

public class Monster extends RandomOccupant {
    
    /**
     * constructor to randomly locate itself in the Maze. (Remember, the parent
     * of this class is RandomOccupant.)
     * 
     * @param maze
     */
    public Monster(Maze maze) {
        super(maze);
    }

    /**
     * constructor to randomly locate itself in the Maze with a seed for the
     * Random class.
     * 
     * @param maze
     * @param seed
     */
    public Monster(Maze maze, long seed) {
        super(maze, seed);
    }

    /**
     * constructor to generate a Monster in a specified location in the Maze.
     * 
     * @param maze
     * @param location
     */
    public Monster(Maze maze, Square location) {
        super(maze, location); 
    }
}