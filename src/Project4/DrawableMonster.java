/**
 * Contains the DrawableMonster class
 * 
 * @author Zeph Nord
 * @author Joseph DeLuca
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */
public class DrawableMonster extends Monster implements Drawable {

    /**
     * Invokes the parent's constructor
     * 
     * @param maze
     */
    public DrawableMonster(Maze maze) {
        super(maze);
    }

    /**
     * Invokes the parent's constructor
     * 
     * @param maze
     * @param seed
     */
    public DrawableMonster(Maze maze, long seed) {
        super(maze, seed);
    }

    /**
     * Invokes the parent's constructor
     * 
     * @param maze
     * @param location
     */
    public DrawableMonster(Maze maze, Square location) {
        super(maze, location);
    }

    @Override
    public void draw() {
        /*
        noStroke();
        if (location().inView()) {
            pushMatrix();
            fill(128, 21, 21);
            rect(super.location().x(), super.location().y(), 50, 50);

            stroke(0);
            line(super.location().x() + 5, super.location().y() + 5,
                    super.location().x() + 15, super.location().y() + 15);
            noStroke();
            stroke(0);
            line(super.location().x() + 45, super.location().y() + 5,
                    super.location().x() + 35, super.location().y() + 15);
            noStroke();
            fill(0);
            ellipse(super.location().x() + 10, super.location().y() + 20, 5, 5);

            fill(0);
            ellipse(super.location().x() + 40, super.location().y() + 20, 5, 5);

            fill(0);
            ellipse(super.location().x() + 25, super.location().y() + 40, 30,
                    5);
            popMatrix();
        }
        */
    }
}