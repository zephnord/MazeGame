/**
 * Contains the DrawableTreasure class
 * 
 * @author Zeph Nord
 * @author Joseph DeLuca
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */
public class DrawableTreasure extends Treasure implements Drawable {

    /**
     * Calls the parents constructor
     * 
     * @param maze
     */
    public DrawableTreasure(Maze maze) {
        super(maze);
    }

    /**
     * Calls the parent's constructor
     * 
     * @param maze
     * @param seed
     */
    public DrawableTreasure(Maze maze, long seed) {
        super(maze, seed);
    }

    /**
     * Calls the parent's constructor
     * 
     * @param maze
     * @param location
     */
    public DrawableTreasure(Maze maze, Square location) {
        super(maze, location);
    }

    @Override
    public void draw() {
        /*
        if (this.location().seen() && !this.found()) {
            fill(128, 107, 21);
            ellipse(this.location().x() + 25, this.location().y() + 25, 30, 30);
            fill(170, 167, 57);
            ellipse(this.location().x() + 25, this.location().y() + 22, 30, 30);
            // rotate(PI/4);
            // rect(this.location().x(), this.location().y(), 50, 5);
            // rotate(PI/4);
            // rect(this.location().x() + 50, this.location().y(), 5, 50);
        }

        else if (this.found()) {
            // pushMatrix();
            fill(255);
            ellipse(this.location().x() + 25, this.location().y() + 25, 30, 30);
            fill(255);
            ellipse(this.location().x() + 25, this.location().y() + 22, 30, 30);
        }
        */
    }

}