/**
 * Contains the DrawableMaze class
 * 
 * @author Zeph Nord
 * @author Joseph DeLuca
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */
public class DrawableMaze extends Maze implements Drawable {

    /**
     * Invokes the parent's constructor
     * 
     * @param squares
     * @param rows
     * @param cols
     */
    public DrawableMaze(Square[][] squares, int rows, int cols) {
        super(squares, rows, cols);
    }

    @Override
    public void draw() {
        /*
        fill(255, 242, 170);
        rect(0, 0, 500, 500);

        for (int i = 0; i < super.rows(); i++) {
            for (int j = 0; j < super.cols(); j++) {

                ((DrawableSquare) getSquare(i, j)).draw();

            }
        }

        for (int i = 0; i < getNumRandOccupants(); i++) {

            if (getRandomOccupant(i) instanceof Treasure) {
                ((DrawableTreasure) getRandomOccupant(i)).draw();
            }

            if (getRandomOccupant(i) instanceof Monster) {
                ((DrawableMonster) getRandomOccupant(i)).draw();
            }

        }

        ((DrawableExplorer) getExplorer()).draw();
        */
    }

}