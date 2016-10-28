package src;

import java.util.Random;

/**
 * Contains the abstract class RandomOccupant that extends Occupant and its
 * method implementations
 * 
 * @author Zeph Nord
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */

abstract class RandomOccupant extends Occupant {
    public Random random;
    public Maze maze;

    /**
     * Default constructor
     */
    public RandomOccupant() {
    }

    /**
     * a constructor to initialize the maze variable and randomly set its
     * location in the maze. To do so, it will need the following methods: From
     * Maze: rows, cols, getSquare From Occupant (its parent): default
     * constructor, moveTo
     * 
     * @param maze
     */
    public RandomOccupant(Maze maze) {
        this.maze = maze;
    }

    /**
     * similar to above constructor with seed for random
     * 
     * @param maze
     * @param seed
     */
    public RandomOccupant(Maze maze, long seed) {
        // TODO
    }

    /**
     * a constructor to initialize the maze variable and the location of its
     * parent. (This constructor is used if the location of the RandomOccupant
     * needs to not be random.)
     * 
     * @param maze
     * @param location
     */
    public RandomOccupant(Maze maze, Square location) {
        // TODO
    }

    /**
     * this method is responsible for moving the RandomOccupant in a random
     * fashion. The move must be legal, however, so that it does not move
     * through any walls in its current location.
     */
    public void move() {
        // TODO
    }
}
