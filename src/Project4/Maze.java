
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
    private int rows;
    private int cols;

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
        // PrintStream outFile = new PrintStream(new File(fileName));

        try {
            File outFile = new File(fileName);
            // PrintStream outFile = new PrintStream(new File(fileName));
            PrintWriter out = new PrintWriter(outFile);
            // Write rows/cols of Maze
            out.println(rows + "," + cols);
            // out.write("\n");

            // Write Squares
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    out.println(squares[i][j].toText(','));
                    // writer.write("\n");
                }
            }

            // Write the Explorer
            if(getExplorer() != null)
                out.println(getExplorer().toText(','));

            // Write Treasures and Monsters
            for (int i = 0; i < getNumRandOccupants(); i++) {
                if (getRandomOccupant(i) instanceof Treasure)
                    out.println(((Treasure) getRandomOccupant(i)).toText(','));
            }
            for (int i = 0; i < getNumRandOccupants(); i++) {
                if (getRandomOccupant(i) instanceof Monster)
                    out.println(((Monster) getRandomOccupant(i)).toText(','));
                // out.println("\n");
            }

            out.close();
        } catch (IOException ex) {
            // throw new RuntimeException(e.toString());
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            //ex.printStackTrace();
            System.out.print(ex);
        }
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
        // String inFile = fileName;
        String line = "";
        int lineNum = 1;
        
        try {
            // FileReader fileReader = new FileReader(fileName);
            Scanner in = new Scanner(new File(fileName));
            // reader.useDelimiter(",");

            Scanner maze = new Scanner(in.nextLine());
            maze.useDelimiter(",");
            if(maze.hasNextInt()){
                rows = maze.nextInt();
                cols = maze.nextInt();
            }
            else {
                line = maze.nextLine();
                throw new MazeReadException("Rows and columns not specified.", line, lineNum);
            }
            
            lineNum++;
            
            squares = new Square[rows][cols];
            maze.close();

            // Read through rest of file
            while (in.hasNextLine()) {
                Scanner inReader = new Scanner(in.nextLine());
                //Scanner errorReader = new Scanner(in.nextLine());
                inReader.useDelimiter(",");

                // Identify the object type
                //line = in.nextLine();
                String type = inReader.next();

                // Create objects based on the type input
                if (type.equals("Square")) {
                    int row = inReader.nextInt();
                    int col = inReader.nextInt();
                    if(squares[row][col] != null) {
                        line = type + "," + row + "," + col + inReader.nextLine();
                        throw new MazeReadException("Duplicate square.", line, lineNum);
                    }
                    lineNum++;
                    squares[row][col] = new Square(row, col);
                    squares[row][col].toObject(inReader);
                }

                else if (type.equals("Explorer")) {
                    explorer = new Explorer(this);
                    setExplorer(explorer);
                    lineNum++;
                    explorer.toObject(inReader);
                }

                else if (type.equals("Monster")) {
                    Monster monster = new Monster(this);
                    lineNum++;
                    monster.toObject(inReader);
                    addRandomOccupant(monster);

                }

                else if (type.equals("Treasure")) {
                    if(!inReader.hasNextInt() && inReader.hasNextInt()){
                        System.out.println(inReader.nextLine());
                        throw new MazeReadException("Line format or other error.", inReader.nextLine(), lineNum);
                    }
                    Treasure treasure = new Treasure(this);
                    lineNum++;
                    treasure.toObject(inReader);
                    addRandomOccupant(treasure);
                }
                else {
                    line = type + inReader.nextLine();
                    throw new MazeReadException("Unknown type.", line, lineNum);
                }

                inReader.close();
            }
            in.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InputMismatchException ex) {
            throw new MazeReadException("Rows and columns not specified.", line, lineNum);
        }
    }
}