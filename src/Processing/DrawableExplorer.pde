/**
 * Contains the DrawableExplorer class
 * 
 * @author Zeph Nord
 * @author Joseph DeLuca
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */
public class DrawableExplorer extends Explorer implements Drawable {

    public DrawableExplorer(Square square, Maze maze, String string) {
        super(square, maze, string);
    }

    @Override
    public void draw() {
       pushMatrix();
       fill(150);
       ellipse(this.location().x() + 25, this.location().y() + 25, 50, 50);
       stroke(255);
       noFill();
       //beginShape();
       //curveVertex(5, 25);
       //curveVertex(5, 25);
       //curveVertex(10, 30);
       //curveVertex(10, 30);
       //curveVertex(15, 35);
       //curveVertex(20, 40);
       //curveVertex(25, 40);
       //curveVertex(25, 40);
       
       endShape();
       //curveVertex(20, 35);
       line(this.location().x() + 10, this.location().y() + 20, this.location().x() + 15, this.location().y()+ 15);
       line(this.location().x() + 15,this.location().y() + 15, this.location().x() + 20,this.location().y() + 20);
       line(this.location().x() + 30,this.location().y() + 20,this.location().x() + 35,this.location().y() + 15);
       line(this.location().x() + 35,this.location().y() + 15,this.location().x() + 40,this.location().y() + 20);
       //curve(15, 30, 18, 33, 21, 35, 25, 40);
       //curve(25, 40, 35, 40, 40, 40, 25, 40);
       noStroke();
       popMatrix();        
    }
}