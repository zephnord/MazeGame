package src;

/**
 * Contains the class Treasure that extends RandomOccupant to model a Treasure
 * 
 * @author Zeph Nord
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */

public class Treasure extends RandomOccupant {
	public boolean found;

	/**
	 * constructor to randomly locate itself in the Maze. (Remember, the parent
	 * of this class is RandomOccupant.)
	 * 
	 * @param maze
	 */
	public Treasure(Maze maze) {
		this.maze = maze;
		this.found = false;
		// TODO
		// setTreasure
	}

	/**
	 * constructor to randomly locate itself in the Maze using a seed.
	 * 
	 * @param maze
	 * @param seed
	 */
	public Treasure(Maze maze, long seed) {
		// TODO
	}

	/**
	 * constructor to generate a Treasure in a specified location in the Maze.
	 * 
	 * @param maze
	 * @param location
	 */
	public Treasure(Maze maze, Square location) {
		// TODO
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
		// TODO
	}
}
