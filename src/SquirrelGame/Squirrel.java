package SquirrelGame;

import java.util.Scanner;

public class Squirrel extends Entity implements Moveable {


    private int pointsCollected;
    private int totalNutsEaten;

    public Squirrel() {
        symbol = ' ';
       // this.row = getRow();
        // this.column = getColumn();
    }

    public void setRow(int row) {
        this.row = row;
    }


    //prompts user to enter initial location of the squirrel. if out of bounds or wall, prompts user
    //to enter a different location. user asked to set a new row and column.
    @Override
    public void create() {
        System.out.println("enter row of squirrel in the maze: ");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter column of squirrel in the maze: ");
        int column = scanner.nextInt();
        scanner.nextLine();

        while (!Maze.available(row,column)) {

            System.out.println("WALL!! enter row for squirrel in the maze:");
            row = scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter column for squirrel in the maze:");
            column = scanner.nextInt();
            scanner.nextLine();
        }

      //squirrel set to the following values using the put() method
        System.out.println("I AM HERE!");
        symbol = '@';
        put(row,column);


    }
    //method to return points if squirrel eats nut
    public void nutEaten(){
        Entity[][]maze = Maze.getMaze();


        Entity squirrel = maze[row][column];
       // if (squirrel ==  )
    }

    //moves the squirrel one position to the direction specified by the user
    @Override
    public void move() {
        int totalScore = 0;
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit){
            int y = row;
            int x = column;
            int oldRow = row, oldCol = column;
            System.out.println("select following W:A:S:Z or press Q to Quit");
            Character selected = scanner.next().charAt(0);
            Entity[][]maze = Maze.getMaze();
            switch (selected){

                case 'q':
                    quit = true;
                    break;
                case 'w':
                    y--;
                    break;
                case 'z':
                    y++;
                    break;
                case 'd':
                    x++;
                    break;
                case 'a':
                    x--;
                    break;
            }
            //squirrel moves, old position becomes blank space i.e. new wall
            maze[oldRow][oldCol] = new Wall(oldRow,oldCol);
            if (maze[y][x]instanceof Nut){
                if (maze[y][x] instanceof Peanut){
                    totalScore +=5;
                    System.out.println("squirrel ate a Peanut worth 5 points. total points = " + totalScore);
                }else if (maze[y][x] instanceof Almond){
                    totalScore+=10;
                    System.out.println("squirrel ate a Almond worth 10 points. total points = " + totalScore);
                }
            }
            put(y,x);
            Maze.display();
            System.out.println("your total score = " + totalScore);
        }
        System.out.println("select from the following options:\n0 - QUIT\n1 - up\n2 - down\n3 - right\n4 - left");

    }
}
