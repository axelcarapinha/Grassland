package main;

import life_beings.Carrot;
import life_beings.Grass;
import life_beings.LifeBeing;
import life_beings.Rabbit;

import java.util.ArrayList;
import java.util.RandomAccess;

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
        this.fillWithGrass();
    }

    private void fillWithGrass() {
    for (int row = 0; row < this.height; row++) {
        for (int column = 0; column < this.width; column++) {
                this.meadowArr[row][column] = new Grass(row, column);
            }
        }
    }

    public void startGrasslandLife () {
        // Fill the grass land.
        this.meadowArr = new LifeBeing[][] {
            {new Grass(0, 0),   new Carrot(0, 1),     new Grass(0, 2),     new Grass(0, 3), new Grass(0, 4),  new Carrot(0, 5)},
            {new Carrot(1, 0),  new Rabbit(1, 1, 0),  new Grass(1, 2),     new Grass(1, 3), new Grass(1, 4), new Rabbit(1, 5, 0)},
            {new Grass(2, 0),   new Grass(2, 1),      new Grass(2, 2),     new Grass(2, 3), new Grass(2, 4),  new Grass(2, 5)},
            {new Grass(3, 0),   new Grass(3, 1),      new Grass(3, 2),     new Grass(3, 3), new Grass(3, 4),  new Grass(3, 5)},
            {new Grass(4, 0),   new Grass(4, 1),      new Grass(4, 2),     new Grass(4, 3), new Grass(4, 4),  new Grass(4, 5)},
            {new Carrot(5, 0),  new Carrot(5, 1),     new Grass(5, 2),     new Grass(3, 3), new Grass(5, 4),  new Carrot(5, 5)},
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
     *  @param column is the x-coordinate of the cell to place a carrot in.
     *  @param row is the y-coordinate of the cell to place a carrot in.
     */

    public void addCarrot(int column, int row) {
        if (cellContents(row, column) == Grassland.GRASS) {
            this.meadowArr[row][column] = new Carrot(row, column);
        }
    }

    /**
     *  addRabbit() (with two parameters) places a newborn rabbit in cell (x, y) if
     *  the cell is empty.  A "newborn" rabbit is equivalent to a rabbit that has
     *  just eaten.  If the cell is already occupied, leave the cell as it is.
     *  @param column is the x-coordinate of the cell to place a rabbit in.
     *  @param row is the y-coordinate of the cell to place a rabbit in.
     */
    public void addRabbit(int column, int row) {
        if (cellContents(row, column) == Grassland.GRASS) {
            this.meadowArr[row][column] = new Rabbit(row, column, 0);
        }
    }

    /**
     *  timeStep() performs a simulation timestep
     *  @return a meadow representing the elapse of one timestep.
     */
    public Grassland timeStep() throws Exception {
        Grassland newGrassland = new Grassland(this.width, this.height, Grassland.starveTime);
        for (int row = 0; row < this.height; row++) {
            for (int column = 0; column < this.width; column++) {
                int ruleNumber = grasslandRules(getCell(row, column), collectCellNeighbors(row, column));
                switch (ruleNumber) {
                    case 1: newGrassland.addCarrot(0, 0); break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    default: throw new Exception("Error: Invalid rule '" + ruleNumber + "'");
                }
            }
        }

        return newGrassland;
    }

    public int grasslandRules(LifeBeing oldGen, ArrayList<LifeBeing> neighbors) throws Exception {
        int rule = 0;

        switch (oldGen.ID) {
            case GRASS: rule = grassRules(oldGen, neighbors); break;
            case RABBIT: rule = rabbitRules(oldGen, neighbors); break;
            case CARROT: rule = carrotRules(oldGen, neighbors); break;
            default:
                throw new Exception("Error: Couldn't identify the '" + oldGen + "' with the '" + oldGen.ID + "' ID.");
        }

        return rule;
    }

    public int grassRules(LifeBeing oldGen, ArrayList<LifeBeing> neighbors) {
        int rule = 0;

        return rule;
    }

    public int rabbitRules(LifeBeing oldGen, ArrayList<LifeBeing> neighbors) {
        int rule = 0;

//        int nCarrots = neighbors.

        return rule;
    }

    public int carrotRules(LifeBeing oldGen, ArrayList<LifeBeing> neighbors) {
        int rule = 0;

        return rule;
    }

    /**
         *  cellContents() returns EMPTY if cell (x, y) is empty, CARROT if it contains
         *  a carrot, and RABBIT if it contains a rabbit.
         *  @param column is the x-coordinate of the cell whose contents are queried.
     *  @param row is the y-coordinate of the cell whose contents are queried.
     */
    public int cellContents(int column, int row) { // [(row,column) <=> (y, x)] => [(column, row) <=> (x,y)]
        return getCell(column, row).ID;
    }
    public LifeBeing getCell(int column, int row) { // (row,column) <=> (y, x)
        return this.meadowArr[(row + this.width) % this.width][(column + this.height) % this.height];
    }

    public ArrayList<LifeBeing> collectCellNeighbors(int x, int y) {
        ArrayList<LifeBeing> neighborsList = new ArrayList<>();

        for (int row = x - 1; row < x + 2; row++) {
            for (int column = y - 1; column < y + 2; column ++) {
                neighborsList.add(getCell(column, row));
            }
        }

        // Remove the center field.
        neighborsList.remove(4);

        return neighborsList;
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

