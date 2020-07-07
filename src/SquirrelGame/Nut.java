package SquirrelGame;

public abstract class Nut extends Entity {

    protected final int TOTAL_NUTS = 5;
    protected int nutritionPoints;
    protected String nameOfNut;

    public int getTOTAL_NUTS() {
        return TOTAL_NUTS;
    }

    public int getNutritionPoints() {
        return nutritionPoints;
    }

    //randomly generates the position of the nuts in the maze. nut must only occupy a blank space in the maze
    @Override
    public void create() {

        //define random position for rows
        int minRow = 0;
        int max = 19;
        int range = max - minRow + 1;
        int rowNum = 0;
        int colNum = 0;

       // int row = (int) (Math.random() * range) + minRow;

        //define random position for column
        int minColumn = 0;
        int maxColumn = 19;
        range = maxColumn - minColumn + 1;

        //int column = (int) (Math.random() * range) + minColumn;

        //set the row and the column
        while (!Maze.available(rowNum,colNum)) {

            rowNum = (int) (Math.random() * range) + minRow;
            colNum = (int) (Math.random() * range) + minColumn;
        }

        put(rowNum,colNum);
    }
}
