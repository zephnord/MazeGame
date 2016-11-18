
import java.io.*;
import java.util.*;

/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters,
 * and an Explorer.
 * 
 * @author Zeph Nord
 * @version Project 3
 * @version CPE102-5
 * @version Fall 2016
 */
public class Maze {
    // named constants
    public static final int ACTIVE = 0;
    public static final int EXPLORER_WIN = 1;
    public static final int MONSTER_WIN = 2;

    // instance variables
    private Square[][] squares;
    private ArrayList<RandomOccupant> randOccupants;
    private Explorer explorer;
    private int rows = 0;
    private int cols = 0;

    /**
     * Default constructor for maze class - added for project 4
     */
    public Maze() {
        randOccupants = new ArrayList<RandomOccupant>();
    }

    /**
     * Constructor for objects of class Maze
     */
    public Maze(Square[][] squares, int rows, int cols) {
        this.squares = new Square[rows + 1][cols + 1];
        this.squares = squares;
        this.rows = rows;
        this.cols = cols;

        randOccupants = new ArrayList<RandomOccupant>();
    }

    // QUERIES
    public Square getSquare(int row, int col) {
        return squares[row][col];
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public String explorerName() {
        return explorer.name();
    }

    public Explorer getExplorer() {
        return explorer;
    }

    public RandomOccupant getRandomOccupant(int index) {
        return randOccupants.get(index);
    }

    public int getNumRandOccupants() {
        return randOccupants.size();
    }

    public void addRandomOccupant(RandomOccupant ro) {
        randOccupants.add(ro);
    }

    public void setExplorer(Explorer e) {
        explorer = e;
    }

    public void explorerMove(int key) {
        explorer.move(key);
    }

    public void randMove() {
        // CHANGE - instruct each object in the RandomOccupant to move
        for (int i = 0; i < getNumRandOccupants(); i++) {
            getRandomOccupant(i).move();
        }
    }

    /**
     * Returns the status of the game.
     *
     * If all treasures have been found, return EXPLORER_WIN. If not, check each
     * maze occupant, if it is a Monster and it is in the same location as the
     * Explorer, return MONSTER_WIN. Note that you can use == to check
     * locations, do you know why? Otherwise, return ACTIVE.
     */
    public int gameStatus() {
        int status = ACTIVE;

        for (int i = 0; i < getNumRandOccupants(); i++) {
            if (getRandomOccupant(i) instanceof Monster) {
                if (getExplorer()
                        .location() == (getRandomOccupant(i).location()))
                    status = MONSTER_WIN;
            }
        }

        if (foundAllTreasures())
            return EXPLORER_WIN;

        return status;
    }

    private boolean foundAllTreasures() {
        boolean foundAll = true;

        for (int i = 0; i < getNumRandOccupants(); i++) {
            if (getRandomOccupant(i) instanceof Treasure)
                if (!((Treasure) getRandomOccupant(i)).found())
                    foundAll = false;
        }

        return foundAll;
    }

    public void lookAround(Square s) {
        int row = s.row();
        int col = s.col();

        // Clear what was previously in view
        resetInView();

        // Set the current square so that we are viewing it (obviously)
        s.setInView(true);

        if (!s.wall(s.UP)) {
            getSquare(row - 1, col).setInView(true);
            if (!getSquare(row - 1, col).wall(s.LEFT))
                getSquare(row - 1, col - 1).setInView(true);
            if (!getSquare(row - 1, col).wall(s.RIGHT))
                getSquare(row - 1, col + 1).setInView(true);
        }
        if (!s.wall(s.LEFT)) {
            getSquare(row, col - 1).setInView(true);
            if (!getSquare(row, col - 1).wall(s.DOWN))
                getSquare(row + 1, col - 1).setInView(true);
            if (!getSquare(row, col - 1).wall(s.UP))
                getSquare(row - 1, col - 1).setInView(true);
        }
        if (!s.wall(s.DOWN)) {
            getSquare(row + 1, col).setInView(true);
            if (!getSquare(row + 1, col).wall(s.RIGHT))
                getSquare(row + 1, col + 1).setInView(true);
            if (!getSquare(row + 1, col).wall(s.LEFT))
                getSquare(row + 1, col - 1).setInView(true);

        }
        if (!s.wall(s.RIGHT)) {
            getSquare(row, col + 1).setInView(true);
            if (!getSquare(row, col + 1).wall(s.UP))
                getSquare(row - 1, col + 1).setInView(true);
            if (!getSquare(row, col + 1).wall(s.DOWN))
                getSquare(row + 1, col + 1).setInView(true);
        }
    }

    private void resetInView() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                squares[i][j].setInView(false);
            }
        }
    }

    /**
     * Writes every Square and Occupant in the Maze to a text file as
     * comma-delimited text with one Occupant/Square per line. Uses the toText
     * method from each class.
     * 
     * @param fileName
     * @throws IOException
     */
    public void writeMazeToFile(String fileName) throws IOException {
        // Create a file to write to
        PrintStream outFile = new PrintStream(new File(fileName));

        // Write rows/cols of Maze
        outFile.println(rows + "," + cols);

        // Write Squares
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                outFile.println(squares[i][j].toText(','));
            }
        }

        // Write Occupants
        // Write Explorer
        outFile.println(explorer.toText(','));

        // Write Treasures and Monsters
        for (int i = 0; i < getNumRandOccupants(); i++) {
            if (getRandomOccupant(i) instanceof Treasure)
                outFile.println(((Treasure) getRandomOccupant(i)).toText(','));
            else
                outFile.println(((Monster) getRandomOccupant(i)).toText(','));
        }
        outFile.close();
    }

    /**
     * Reads comma-delimited text files in the format specified for the toText
     * method of Occupant class, its subclasses, and Square class. Makes use of
     * the toObect method within Occupant class, its subclasses, and Square.
     * 
     * @param fileName
     * @throws IOException
     * @throws FileNotFoundException
     * @throws MazeReadException
     */
    public void readMazeFromFile(String fileName)
            throws IOException, FileNotFoundException, MazeReadException {
        // Create input stream
        Scanner inFile = new Scanner(new File(fileName));

        // Determine Maze size and create a new one
        Scanner createMaze = new Scanner(inFile.nextLine()).useDelimiter(",");
        rows = createMaze.nextInt();
        cols = createMaze.nextInt();
        squares = new Square[rows][cols];

        // Read through rest of file
        while (inFile.hasNextLine()) {
            // Identify the object type
            Scanner in = new Scanner(inFile.nextLine())
                    .useDelimiter(",");
            String type = in.next();
            
            //Create objects based on the type input
            if(type.equals("Square")) {
                int row = in.nextInt();
                int col = in.nextInt();
                squares[row][col] = new Square(row, col);
                squares[row][col].toObject(in);
            }
            
            else if(type.equals("Explorer")) {
                //explorer = new Explorer(Maze);
                explorer.toObject(in);                
            }
            
            else if(type.equals("Monster")) {
                Monster monster = new Monster(maze);
            }
                

        }

        // TODO

    }
}