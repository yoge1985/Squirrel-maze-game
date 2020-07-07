package SquirrelGame;

public abstract class  Entity {

    protected char symbol;
    protected int row;
    protected int column;



    public abstract void create();

    //puts an entity at location(newRow, newColumn) in the maze.it returns an object that was replaced in the maze
    public void put(int newRow, int newColumn){


        //return replaced object
        Entity[][]maze = Maze.getMaze();
        Entity replaceEntity = maze[newRow][newColumn];
        replaceEntity = new Wall(newRow,newColumn);


        this.row = newRow;
        this.column = newColumn;
        maze[newRow][newColumn] = this;

    }

    public char getSymbol() {
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
