package src;

public class DrawableMonster extends Monster implements Drawable {

	public DrawableMonster(){}

	public DrawableMonster(Maze maze){
		super(maze);
	}

	public DrawableMonster(Maze maze, long seed){
		super(maze, seed);
	}

	public DrawableMonster(Maze maze, Square location){
		super(maze, location);
	}

	public void draw(){
		if (this.location().inView()){
			//draw the monster
		}
	}
}
