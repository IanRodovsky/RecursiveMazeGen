
/**
 * This program generates and prints a random maze using recursive division to the output console.
 *
 * Completion time: Approx. two hours.
 *
 * @author Ian Rodovsky, Acuna
 * @version 05/24/2021
 */
import java.util.Random;

public class RodovskyMazeGen {

    //standard console size in characters.
    private static final int LEVEL_HEIGHT = 25;
    private static final int LEVEL_WIDTH = 80;

    private static final char ICON_WALL = '#';
    private static final char ICON_BLANK = ' ';

    /**
     * Returns a 2D array containing a statically created maze with dimentions
     * 80x24.
     *
     * @return 2D array containing a maze
     */
    private static char[][] makeMazeStatic() {
        //the following maze was generated with the recursive division method and then modified by hand.

        char level[][]
                = {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', ' ', '#', ' ', ' ', '#', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
                {'#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

        return level;
    }

    /**
     * Creates a random maze in a 2D array.
     *
     * @see
     * <a href="http://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_division_method">Recursive_division_method</a>
     * @return 2D array containing a maze
     */
    private static char[][] makeMaze() {
        char level[][] = createBlankLevel();

        makeMazeRecursive(level, 1, 1, LEVEL_WIDTH - 2, LEVEL_HEIGHT - 2); //TODO: may need to change but probably not.

        return level;
    }

    /**
     * Creates an empty level of standard level height and width. Level will be
     * blank but bordered with wall characters.
     *
     * @return 2D array containing a maze
     */
    private static char[][] createBlankLevel() {
        char level[][] = new char[LEVEL_HEIGHT][LEVEL_WIDTH];

        //reset level to be entirely blank
        for (int y = 0; y < LEVEL_HEIGHT; y++) {
            for (int x = 0; x < LEVEL_WIDTH; x++) {
                level[y][x] = ' ';
            }
        }

        //top barrier
        for (int x = 0; x < LEVEL_WIDTH; x++) {
            level[0][x] = ICON_WALL;
        }

        //bottom barrier
        for (int x = 0; x < LEVEL_WIDTH; x++) {
            level[LEVEL_HEIGHT - 1][x] = ICON_WALL;
        }

        //left barrier
        for (int y = 0; y < LEVEL_HEIGHT; y++) {
            level[y][0] = ICON_WALL;
        }

        //left barrier
        for (int y = 0; y < LEVEL_HEIGHT; y++) {
            level[y][LEVEL_WIDTH - 1] = ICON_WALL;
        }

        return level;
    }

    private static int randNumGen(int lower, int upper) {
        Random rand = new Random();
        return rand.nextInt(upper - lower) + lower;
    }

    //TODO: complete method.
    private static void makeMazeRecursive(char[][] level, int startX, int startY, int endX, int endY) {
        if (endX - startX <= 2 || endY - startY <= 2) {
            return;
        } else {
            int wallY = randNumGen(startX + 1, endX - 1), wallX = randNumGen(startY + 1, endY - 1);
            int firstXDoor = randNumGen(startX, wallY), secondXDoor = randNumGen(wallY + 1, endX);
            int firstYDoor = randNumGen(startY, wallX), secondYDoor = randNumGen(wallX + 1, endY);
            for (int y = startY; y <= endY; y++) {
                if ((y == firstYDoor || y == secondYDoor) && (level[y - 1][wallY] != ICON_WALL || level[y + 1][wallY] != ICON_WALL)) {
                    level[y][wallY] = ICON_BLANK;
                } else {
                    level[y][wallY] = ICON_WALL;
                }
            }
            for (int x = startX; x <= endX; x++) {
                if ((x == firstXDoor || x == secondXDoor) && (level[wallX][x - 1] != ICON_WALL || level[wallX][x + 1] != ICON_WALL)) {
                    level[wallX][x] = ICON_BLANK;
                } else {
                    level[wallX][x] = ICON_WALL;
                }
            }
            makeMazeRecursive(level, startX, startY, wallY - 1, wallX - 1);
            makeMazeRecursive(level, wallY + 1, startY, endX, wallX - 1);
            makeMazeRecursive(level, startX, wallX + 1, wallY - 1, endY);
            makeMazeRecursive(level, wallY + 1, wallX + 1, endX, endY);
        }
    }

    /**
     * Displays a level in the console.
     *
     * @param level 2D array containing a maze
     */
    private static void drawLevel(char[][] level) {
        int y, x;

        for (y = 0; y < LEVEL_HEIGHT; y++) {
            for (x = 0; x < LEVEL_WIDTH; x++) {
                System.out.print(level[y][x]);
            }
            System.out.println();
        }
    }

    /**
     * Entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Statically Drawn Maze: \n");
        drawLevel(makeMazeStatic());
        System.out.print("\n\n\nRecursively Drawn Maze: \n");
        drawLevel(makeMaze());
    }
}
