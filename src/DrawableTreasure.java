package src;

public class DrawableTreasure extends Treasure implements Drawable{

	public DrawableTreasure(){}

	public DrawableTreasure(Maze maze){
		super(maze);
	}

	public DrawableTreasure(Maze maze, Square location){
		super(maze, location);
	}

	public DrawableTreasure(Maze maze, long seed);{
		super(maze, seed);
	}

	public void draw(){
		if (this.location().seen()){
			//draw the treasure
		}
	}
}
