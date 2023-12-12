package WorkP2;

import java.util.Arrays;
import java.util.Random;

/* Grassland.java */

/**
 *  The Grassland class defines an object that models an meadow full of rabbits and
 *  carrots.  Descriptions of the methods you must implement appear below.  They
 *  include a constructor of the form
 *
 *      public Grassland(int i, int j, int starveTime);
 *
 *  that creates an empty meadow having width i and height j, in which rabbits
 *  starve after starveTime timesteps.
 *
 *
 */

public class Grassland {

    /**
     *  Do not rename these constants.  WARNING:  if you change the numbers, you
     *  will need to recompile Test4.java.  Failure to do so will give you a very
     *  hard-to-find bug.
     */

    public final static int EMPTY = 0;
    public final static int RABBIT = 1;
    public final static int CARROT = 2;

    /**
     *  Define any variables associated with an Grassland object here.  These
     *  variables MUST be private.
     */

    private Random random;
    private int[][] meadowArr;
    private int meadowWidth;
    private int meadowHeight;
    private int starveTime;


    /**
     *  Grassland() is a constructor that creates an empty meadow having width i and
     *  height j, in which rabbits starve after starveTime timesteps.
     *  @param i is the width of the meadow.
     *  @param j is the height of the meadow.
     *  @param starveTime is the number of timesteps rabbits survive without food.
     */

    public Grassland(int i, int j, int starveTime) {
        this.meadowArr = new int[i][j];
        this.meadowWidth = i;
        this.meadowHeight = j;

        this.random = new Random();

        this.starveTime = starveTime;


        fillGrassland();

        System.out.println(Arrays.deepToString(meadowArr));

    }

    /**
     *  width() returns the width of an Grassland object.
     *  @return the width of the meadow.
     */

    public int width() {
        // Replace the following line with your solution.
        return this.meadowWidth;
    }

    /**
     *  height() returns the height of an Grassland object.
     *  @return the height of the meadow.
     */

    public int height() {
        // Replace the following line with your solution.
        return this.meadowHeight;
    }

    /**
     *  starveTime() returns the number of timesteps rabbits survive without food.
     *  @return the number of timesteps rabbits survive without food.
     */

    public int starveTime() {
        // Replace the following line with your solution.
        return this.starveTime;
    }

    /**
     *  addCarrot() places a carrot in cell (x, y) if the cell is empty.  If the
     *  cell is already occupied, leave the cell as it is.
     *  @param x is the x-coordinate of the cell to place a carrot in.
     *  @param y is the y-coordinate of the cell to place a carrot in.
     */

//    public void addCarrot(int x, int y) {
//        if (meadowArr[x][y] == 0) {
//            meadowArr = new Rabbit;
//        }
//
//
//
//
//    }

    /**
     *  addRabbit() (with two parameters) places a newborn rabbit in cell (x, y) if
     *  the cell is empty.  A "newborn" rabbit is equivalent to a rabbit that has
     *  just eaten.  If the cell is already occupied, leave the cell as it is.
     *  @param x is the x-coordinate of the cell to place a rabbit in.
     *  @param y is the y-coordinate of the cell to place a rabbit in.
     */

    public void addRabbit(int x, int y) {
        // Your solution here.
    }

    /**
     *  cellContents() returns EMPTY if cell (x, y) is empty, CARROT if it contains
     *  a carrot, and RABBIT if it contains a rabbit.
     *  @param x is the x-coordinate of the cell whose contents are queried.
     *  @param y is the y-coordinate of the cell whose contents are queried.
     */

    public int cellContents(int x, int y) {
        // Replace the following line with your solution.
        return EMPTY;
    }

    /**
     *  timeStep() performs a simulation timestep
     *  @return a meadow representing the elapse of one timestep.
     */

    public Grassland timeStep() {
        // Replace the following line with your solution.
        return new Grassland(1, 1, 1);
    }

    private void fillGrassland() {
        for (int i = 0; i < meadowWidth; i++) {
            for (int j = 0; j < meadowHeight; j++) {
                meadowArr[i][j] = random.nextInt(3);

            }
        }
    }




}

