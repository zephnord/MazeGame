

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

public abstract class RandomOccupant extends Occupant {
    private Random random = new Random();
    private Maze maze;

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
        moveTo(maze.getSquare(random.nextInt(maze.rows()),
                random.nextInt(maze.cols())));
    }

    /**
     * similar to above constructor with seed for random
     * 
     * @param maze
     * @param seed
     */
    public RandomOccupant(Maze maze, long seed) {
        random = new Random(seed);
        this.maze = maze;
        moveTo(maze.getSquare(random.nextInt(maze.rows()),
                random.nextInt(maze.cols())));
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
        this.maze = maze;
        moveTo(location);
    }

    /**
     * this method is responsible for moving the RandomOccupant in a random
     * fashion. The move must be legal, however, so that it does not move
     * through any walls in its current location.
     */
    public void move() { 
        Square square = this.location();
        // local variables to generate moving the row and column
        // by 1 or -1
        boolean hasMoved = false;
        while (!hasMoved) {
            int toMove =  random.nextInt(4);
            if (toMove == square.UP) {
                if (!square.wall(square.UP)) {
                    super.moveTo(
                            maze.getSquare(square.row() - 1, square.col()));
                    hasMoved = true;
                }
            } else if (toMove == square.RIGHT) {
                if (!square.wall(square.RIGHT)) {
                    super.moveTo(
                            maze.getSquare(square.row(), square.col() + 1));
                    hasMoved = true;
                }
            } else if (toMove == square.DOWN) {
                if (!square.wall(square.DOWN)) {
                    super.moveTo(
                            maze.getSquare(square.row() + 1, square.col()));
                    hasMoved = true;
                }
            } else if (toMove == square.LEFT) {
                if (!square.wall(square.LEFT)) {
                    super.moveTo(
                            maze.getSquare(square.row(), square.col() - 1));
                    hasMoved = true;
                }
            }
        }
    }
}