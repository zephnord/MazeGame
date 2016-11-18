import java.awt.*;
import javax.swing.*;

/**
 * Contains the DrawableSquare class
 * 
 * @author Zeph Nord
 * @author Joseph DeLuca
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */
public class DrawableSquare extends Square implements Drawable {

    /**
     * Constructor to initialize data in the parent class Square
     * 
     * @param up
     * @param right
     * @param down
     * @param left
     * @param row
     * @param col
     */
    public DrawableSquare(boolean up, boolean right, boolean down, boolean left,
            int row, int col) {
        super(up, right, down, left, row, col);
    }

    public void draw() {
        /*
        pushMatrix();
        if (this.seen() && this.inView()) {
            fill(100, 96.1, 66.7);
            rect(this.x(), this.y(), SQUARE_SIZE, SQUARE_SIZE);
            //
            if (wall(UP)) {
                fill(0);
                rect(this.x(), this.y(), 50, 5);
            }
            if (wall(RIGHT)) {
                fill(0);
                rect(this.x() + 50, this.y(), 5, 50);
            }
            if (wall(DOWN)) {
                fill(0);
                rect(this.x(), this.y() + 50, 50, 5);
            }
            if (wall(LEFT)) {
                fill(0);
                rect(this.x(), this.y(), 5, 50);
            }
        }

        if (this.seen() && !this.inView()) {
            fill(83.1, 78.8, 41.6);
            rect(this.x(), this.y(), SQUARE_SIZE, SQUARE_SIZE);

            if (wall(UP)) {
                fill(0);
                rect(this.x(), this.y(), 50, 5);
            }
            if (wall(RIGHT)) {
                fill(0);
                rect(this.x() + 50, this.y(), 5, 50);
            }
            if (wall(DOWN)) {
                fill(0);
                rect(this.x(), this.y() + 50, 50, 5);
            }
            if (wall(LEFT)) {
                fill(0);
                rect(this.x(), this.y(), 5, 50);
            }
        }
        popMatrix();
        */
    }
}