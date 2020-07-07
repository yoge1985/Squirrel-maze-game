package SquirrelGame;

public class Wall extends Entity {

    public Wall(int row, int column) {

        symbol = ' ';
        this.row = row;
        this.column  = column;
    }

    @Override
    public void create() {
        symbol = '*';
    }

}
