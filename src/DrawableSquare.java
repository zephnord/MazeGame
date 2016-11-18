package src;

public class DrawableSquare extends Square implements Drawable{

	public DrawableSquare(){}

	public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col){
		super(up, right, down, left, row, col);
	}

	public void draw(){
		if (!(this.seen())){
			//do nothing
		}
		else if (this.inView()){
			//draw the whole square with walls in proper place
		}
		else if (this.seen() && !(this.inView())){
			//draw the whole square with a darker color than the other one.
		}
	}
}
