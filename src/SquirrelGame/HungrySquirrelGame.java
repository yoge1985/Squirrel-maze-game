package SquirrelGame;

import java.util.Random;

public class HungrySquirrelGame {

    public static void main(String[] args) {

        Maze.create("C:\\Users\\family gefen\\Downloads\\Maze.txt");
        Squirrel squirrel = new Squirrel();
        squirrel.create();

        Nut[] typeOfnut = new Nut[5];
        Random random = new Random();

        for (int i = 0; i < typeOfnut.length; i++) {
            typeOfnut[i] = random.nextBoolean() ? new Almond() : new Peanut();
            typeOfnut[i].create();
        }
        Maze.display();

        squirrel.move();

    }


}
