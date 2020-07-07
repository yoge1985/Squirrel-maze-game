package SquirrelGame;

import java.io.File;
import java.util.Scanner;

public class Maze {


    private static final int MAX_MAZE_ROW = 20;
    private static final int MAX_MAZE_COLUMN = 50;
    //2 D array (matrix)
    private static Entity[][] maze;

    public static int getMaxMazeRow() {
        return MAX_MAZE_ROW;
    }

    public static int getMaxMazeColumn() {
        return MAX_MAZE_COLUMN;
    }

    public static Entity[][] getMaze() {
        return maze;
    }

    //reads the file passed to the method (i.e maze.txt) and initializes the 2-d array with maze content in the file
    public static void create(String fileName) {

        maze = new Entity[MAX_MAZE_ROW][MAX_MAZE_COLUMN];

        try {

            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNextLine()) {
                //go through each row and create a string for each row
                for (int i = 0; i < MAX_MAZE_ROW; i++) {
                    String string = scanner.nextLine();
                    //for each string, create chars.
                    for (int j = 0; j < MAX_MAZE_COLUMN; j++) {
                        //initialize the Entity array. Each element contains position of the
                        maze[i][j] = new Wall(i,j);

                        if (string.charAt(j) == '*') {
                            maze[i][j].create();
                        }

                    }
                }
//                display();
//                //create new squirrel
//                Squirrel squirrel = new Squirrel();
//                //prompt user for position of squirrel in maze
//                squirrel.create();
//                maze[squirrel.row][squirrel.column] = squirrel;
//                //display maze with squirrel included
//                display();
//                //allow squirrel to move position
//                squirrel.move();
//                //squirrel moves to new position. old position becomes blank
//                maze[squirrel.row][squirrel.column] = squirrel;
//                display();
//
            }

        } catch (Exception e) {
            System.out.println("cannot find file");
        }
    }

    //this method displays the maze structure and the containing entities
    public static void display() {
//        int row = HungrySquirrelGame.squirrel.row;
//        int column = HungrySquirrelGame.squirrel.column;
       // maze[row][column] = HungrySquirrelGame.squirrel;
        //maze[HungrySquirrelGame.almond.row][HungrySquirrelGame.almond.column] = HungrySquirrelGame.almond;

        String mazeStr  = new String();
        for (int i = 0; i < MAX_MAZE_ROW; i++) {
            for (int j = 0; j < MAX_MAZE_COLUMN; j++) {

                mazeStr = mazeStr.concat(String.valueOf(maze[i][j].getSymbol()));

            }
            mazeStr = mazeStr.concat("\n");
        }
        System.out.println(mazeStr);
        //re-sets the cell to blank so that if squirrel moves, the prev. cell won't display '@'
//        maze[row][column] = new Wall(row,column);

    }

    //checks row and column to see if blank space. returns true if so, otherwise false
    public static boolean available(int row, int col) {

        return (maze[row][col].getSymbol() == ' ');

    }
}


