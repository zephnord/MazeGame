package src;

import java.awt.event.KeyEvent;

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
        super(location);
        this.maze = maze;
        this.name = name;
        this.maze.lookAround(square);
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
        this.square.row();
        this.square.col();
        if(key == KeyEvent.VK_UP) {
            if(!this.square.wall(square.UP)) {
                moveTo(maze.getSquare(square.row() - 1, square.col()));
            }
        }
        else if(key == KeyEvent.VK_DOWN) {
            if(!this.square.wall(square.DOWN)) {
                moveTo(maze.getSquare(square.row() + 1, square.col()));
            }
        }
        else if(key == KeyEvent.VK_RIGHT) {
            if(!this.square.wall(square.RIGHT)) {
                moveTo(maze.getSquare(square.row(), square.col() + 1));
            }
        }
        else if(key == KeyEvent.VK_LEFT) {
            if(!this.square.wall(square.LEFT)) {
                moveTo(maze.getSquare(square.row(), square.col() - 1));
            }
        }
    }

    /**
     * Commands the Explorer to move to another Square in the Maze Actual moving
     * of the Explorer is done via its parent's moveTo method.
     * 
     * @param s
     */
    public void moveTo(Square s) {
        super.moveTo(s);
        s.enter();
        maze.lookAround(s);
    }
}
