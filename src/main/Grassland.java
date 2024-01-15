package main;

import life_beings.Grass;
import life_beings.LifeBeing;
import life_beings.Rabbit;

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
    public final static int GRASS = 0;
    public final static int RABBIT = 1;
    public final static int CARROT = 2;
    private static final String NEWLINE = "\n";


    private static int counterGrass = 0;
    private static int counterCarrots = 0;
    private static int counterRabbits = 0;

    // Percentagens vêm incluídas no simulador (mas podemos ter as nossas próprias)

    private static final int MAX_PERCENTAGE = 100;
    private static final int GRASS_PERCENTAGE = 50;

    private static final int RABBIT_PERCENTAGE = 10;
    private static final int CARROT_PERCENTAGE = 40;

    /**
     *  Define any variables associated with an Grassland object here.  These
     *  variables MUST be private.
     */
    public LifeBeing[][] meadowArr;
    private int width;
    private int height;

    // TODO: Try Make this non static!
    public static int starveTime;

    /**
     *  Grassland() is a constructor that creates an empty meadow having width i and
     *  height j, in which rabbits starve after starveTime timesteps.
     *  @param i is the width of the meadow.
     *  @param j is the height of the meadow.
     *  @param starveTime is the number of timesteps rabbits survive without food.
     */

    public Grassland(int i, int j, int starveTime) {
        this.width = i;
        this.height = j;
        Grassland.starveTime = starveTime;
        this.meadowArr = new LifeBeing[i][j];
    }

    public void startGrasslandLife () {
        // Fill the grass land.
        this.meadowArr = new LifeBeing[][] {
            {new Grass(0, 0), new Grass(1, 0),     new Grass(2, 0),     new Grass(3, 0), new Grass(4, 0), new Grass(5, 0)},
            {new Grass(0, 1), new Rabbit(1, 1, 0), new Grass(2, 1),     new Grass(3, 1), new Grass(4, 1), new Rabbit(5, 1, 0)},
            {new Grass(0, 2), new Grass(1, 2),     new Grass(2, 2),     new Grass(3, 2), new Grass(4, 2), new Grass(5, 2)},
            {new Grass(0, 3), new Grass(1, 3),     new Grass(2, 3),     new Grass(3, 3), new Grass(4, 3), new Grass(5, 3)},
            {new Grass(0, 4), new Grass(1, 4),     new Grass(2, 4),     new Grass(3, 4), new Grass(4, 4), new Grass(5, 4)},
            {new Grass(0, 5), new Grass(1, 5),     new Rabbit(2, 5, 0), new Grass(3, 5), new Grass(4, 5), new Rabbit(5, 5, 0)},
        };

        /*
        for (int i = 0; i < meadowHeight; i++) {
            for (int j = 0; j < meadowWidth; j++) {
                // Generate new cells randomly.
                int typeOfLife = GRASS;
                
                int randomPercentage = random.nextInt(MAX_PERCENTAGE + 1);

                if (randomPercentage < GRASS_PERCENTAGE) {
                    typeOfLife = GRASS;
                }
                else if (randomPercentage >= GRASS_PERCENTAGE &&
                         randomPercentage < GRASS_PERCENTAGE + CARROT_PERCENTAGE) {
                    typeOfLife = CARROT;
                }
                else if(randomPercentage >= GRASS_PERCENTAGE + CARROT_PERCENTAGE &&
                        randomPercentage < MAX_PERCENTAGE) {
                    typeOfLife = RABBIT;
                }

                switch (typeOfLife) {
                    case GRASS:
                        this.meadowArr[i][j] = new Grass(i, j);
                        counterGrass++;
                        break;
                    case RABBIT:
                        this.meadowArr[i][j] = new Rabbit(i, j, 0);
                        counterRabbits++;
                        break;
                    case CARROT:
                        this.meadowArr[i][j] = new Carrot(i, j);
                        counterCarrots++;
                        break;
                }
            }
        }
        */

        // There must be at least 1 rabbit in the grassland.
        // int i = this.random.nextInt(this.width() - 1);
        // int j = this.random.nextInt(this.height() - 1);

        // meadowArr[i][j] = new Rabbit(i, j, 0);
    }

    /**
     *  width() returns the width of an Grassland object.
     *  @return the width of the meadow.
     */

    public int width() { return this.width; }

    // If it returns "of a Grassland object,
    //? does it need to receive arguments with the address of the object?

    /**
     *  height() returns the height of an Grassland object.
     *  @return the height of the meadow.
     */

    public int height() { return this.height; }

    /**
     *  starveTime() returns the number of timesteps rabbits survive without food.
     *  @return the number of timesteps rabbits survive without food.
     */

    public int starveTime() { return Grassland.starveTime; }

    /**
     *  addCarrot() places a carrot in cell (x, y) if the cell is empty.  If the
     *  cell is already occupied, leave the cell as it is.
     *  @param x is the x-coordinate of the cell to place a carrot in.
     *  @param y is the y-coordinate of the cell to place a carrot in.
     */

    public void addCarrot(int x, int y) {
    }

    /**
     *  addRabbit() (with two parameters) places a newborn rabbit in cell (x, y) if
     *  the cell is empty.  A "newborn" rabbit is equivalent to a rabbit that has
     *  just eaten.  If the cell is already occupied, leave the cell as it is.
     *  @param x is the x-coordinate of the cell to place a rabbit in.
     *  @param y is the y-coordinate of the cell to place a rabbit in.
     */
    public void addRabbit(int x, int y) {
    }

    /**
     *  timeStep() performs a simulation timestep
     *  @return a meadow representing the elapse of one timestep.
     */
    public Grassland timeStep() {
        return null;
    }

    /**
     *  cellContents() returns EMPTY if cell (x, y) is empty, CARROT if it contains
     *  a carrot, and RABBIT if it contains a rabbit.
     *  @param column is the x-coordinate of the cell whose contents are queried.
     *  @param row is the y-coordinate of the cell whose contents are queried.
     */

    public LifeBeing cellContents(int column, int row) {
        return this.meadowArr[row][column];
    }

    public void printGrassland() {
        for (int row = 0; row < height; row++) {
            System.out.print(row + "-> ");

            for (int column = 0; column < width; column++) {
                System.out.print("[" + this.meadowArr[row][column] + "] ");
                // System.out.println("[" + cellContents(x,y) + "] ");
            }
            System.out.print(NEWLINE);
        }
        System.out.println("Grassland Update:");

        // if (Main.verbose) {
        //     System.out.print(
        //                     "CounterGrass  = "  + counterGrass    + "( " + (counterGrass   / (float)(meadowHeight * meadowWidth)) * 100 + " %)" + NEWLINE +
        //                     "CounterCarrot = "  + counterCarrots  + "( " + (counterCarrots / (float)(meadowHeight * meadowWidth)) * 100 + " %)" + NEWLINE +
        //                     "CounterRabbits = " + counterRabbits  + "( " + (counterRabbits / (float)(meadowHeight * meadowWidth)) * 100 + " %)" + NEWLINE
        //     );
        // }
    }
}

