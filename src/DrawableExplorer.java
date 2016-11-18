package src;

public class DrawableExplorer extends Explorer implements Drawable{

	public DrawableExplorer(){}

	public DrawableExplorer(Square location, Maze maze, String name){
		super(location, maze, name);
	}
	public void draw(){
		//draw self in the appropriate location on the screen
	}
}
