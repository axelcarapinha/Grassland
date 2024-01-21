package main;

import life_beings.Carrot;
import life_beings.Grass;
import life_beings.LifeBeing;
import life_beings.Rabbit;
import java.util.Random;
import main.InvalidGrasslandRuleException;

import java.util.ArrayList;

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

    private static final int MAX_PERCENTAGE = 100;
    private static final int GRASS_PERCENTAGE = 30;
    private static final int RABBIT_PERCENTAGE = 10;
    private static final int CARROT_PERCENTAGE = 60;

    /**
     *  Define any variables associated with an Grassland object here. These
     *  variables MUST be private.
     */
    private LifeBeing[][] meadowArr;
    private int width;
    private int height;

    private int starveTime;

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
        this.starveTime = starveTime;
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
        // this.meadowArr = new LifeBeing[][] {
        //     { new Grass(0, 0), new Rabbit(0, 1,0),        new Rabbit(0, 2,0), new Grass(0, 3), new Grass(0, 4), new Grass(0, 5) },
        //     { new Grass(1, 0),     new Rabbit(1, 1,0),    new Carrot(1, 2), new Grass(1, 3), new Grass(1, 4), new Grass(1, 0) },
        //     { new Grass(2, 0),    new Carrot(2, 1), new Grass(2, 2), new Grass(2, 3), new Grass(2, 4), new Grass(2, 5) },
        //     { new Grass(3, 0),     new Grass(3, 1),    new Carrot(3, 2), new Grass(3, 3), new Grass(3, 4), new Grass(3, 5) },
        //     { new Grass(4, 0),     new Carrot(4, 1),    new Grass(4, 2), new Grass(4, 3), new Grass(4, 4), new Grass(4, 5) },
        //     { new Grass(5, 0),     new Grass(5, 1),    new Carrot(5, 2), new Grass(3, 3), new Grass(5, 4), new Grass(5, 5) },
        // };

        Random random = new Random(); 
        for (int row = 0; row < this.height; row++) {

            for (int column = 0; column < this.width; column++) {
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
                        this.meadowArr[row][column] = new Grass(row, column);
                        break;
                    case RABBIT:
                        this.meadowArr[row][column] = new Rabbit(row, column, 0);
                        break;
                    case CARROT:
                        this.meadowArr[row][column] = new Carrot(row, column);
                        break;
                }
            }
        }
    }

    /**
     *  width() returns the width of an Grassland object.
     *  @return the width of the meadow.
     */

    public int width() { return this.width; }

    /**
     *  height() returns the height of an Grassland object.
     *  @return the height of the meadow.
     */

    public int height() { return this.height; }

    /**
     *  starveTime() returns the number of timesteps rabbits survive without food.
     *  @return the number of timesteps rabbits survive without food.
     */
    public int starveTime() { return this.starveTime; }


    /**
     *  addCarrot() places a carrot in cell (x, y) if the cell is empty.  If the
     *  cell is already occupied, leave the cell as it is.
     *  @param column is the x-coordinate of the cell to place a carrot in.
     *  @param row is the y-coordinate of the cell to place a carrot in.
     */
    public void addCarrot(int column, int row) {
        if (cellContents(column, row) == Grassland.GRASS) { 
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
        if (cellContents(column, row) == Grassland.GRASS) {
            this.meadowArr[row][column] = new Rabbit(row, column, 0);
        }
    }

    /**
     *  timeStep() performs a simulation timestep
     *  @return a meadow representing the elapse of one timestep.
     */
    public Grassland timeStep() throws Exception {
        Grassland newGrassland = new Grassland(this.width, this.height, this.starveTime);
        for (int row = 0; row < this.height; row++) {
            for (int column = 0; column < this.width; column++) {
                LifeBeing currentCell = getCell(column, row);
                int ruleNumber = grasslandRules(currentCell, collectCellNeighbors(row, column));

                // To test the InvalidGrasslandRuleException.java
                // ruleNumber = 44;

                switch (ruleNumber) {
                    
                    // Rabbit eats a carrot.
                    case 1: 
                        // newGrassland.addGrass(row, column);
                        ((Rabbit) currentCell).eatCarrot();
                        newGrassland.meadowArr[row][column] = currentCell;
                        break;
                    
                    // Rabbit Starves :(
                    case 2: 
                        Rabbit curRabbit = (Rabbit) currentCell;
                        curRabbit.starve();
                        if (!curRabbit.is_dead(this.starveTime)) {
                            newGrassland.meadowArr[row][column] = curRabbit;
                        }
                        break;

                    // Carrot survives.
                    case 3: 
                        newGrassland.meadowArr[row][column] = currentCell;
                        break;
                        
                    // Carrot is eaten by the rabbit
                    case 4: 
                        break;

                    // A RABBIT IS BORN.
                    case 5: 
                        newGrassland.addRabbit(column, row);
                        break;
                    
                    // Grass stays alive :)
                    case 6: 
                        newGrassland.meadowArr[row][column] = currentCell;
                        break;
                    
                    // A Carrot is planted.
                    case 7:
                        newGrassland.addCarrot(column, row);
                        break;

                    // A Rabbit is born.
                    case 8:
                        newGrassland.addRabbit(column, row);
                        break;

                    default: 
                        throw new InvalidGrasslandRuleException("Error: Invalid rule '" + ruleNumber + "' with the '" + currentCell + "' life being.");   
                }
            }
        }

        return newGrassland;
    }

    private int grasslandRules(LifeBeing currentCell, ArrayList<LifeBeing> neighbors) throws Exception {
        int rule = 0;

        switch (currentCell.ID) {
            case GRASS: rule = grassRules(currentCell, neighbors); break;
            case RABBIT: rule = rabbitRules(currentCell, neighbors); break;
            case CARROT: rule = carrotRules(currentCell, neighbors); break;
            default:
                throw new Exception("Error: Couldn't identify the '" + currentCell + "' with the '" + currentCell.ID + "' ID.");
        }
        
        return rule;
    }

    // Checks the rules 6, 7 and 8.
    private int grassRules(LifeBeing currentCell, ArrayList<LifeBeing> neighbors) {
        int rule = 0;

        LifeBeing[] carrotsNei = getOccurrences(neighbors, Grassland.CARROT);

        switch (carrotsNei.length) {
            case 0:  case 1: rule = 6; break; // Grass stays alive :)
            default: 
                LifeBeing[] rabbitsNei = getOccurrences(neighbors, Grassland.RABBIT);
                rule = rabbitsNei.length <= 1 ? 7 : 8; 

                // RABBIT IS BORN in the 8th rule. (different from rule 5)
                break;
              
        }

        return rule;
    }

    // Checks the rules 1 and 2.
    private int rabbitRules(LifeBeing currentCell, ArrayList<LifeBeing> neighbors) {
        int rule = 0;

        LifeBeing[] carrotsNei = getOccurrences(neighbors, Grassland.CARROT);

        switch (carrotsNei.length) {
            case 0:  rule = 2; break; // Rule 2 -> rabbit starves :(
            default: rule = 1; break; // Rule 1 -> rabbit eats carrot
        }

        return rule;
    }


    // Checks rules 3, 4 and 5.
    private int carrotRules(LifeBeing oldGen, ArrayList<LifeBeing> neighbors) {
        int rule = 0;

        LifeBeing[] rabbitsNei = getOccurrences(neighbors, Grassland.RABBIT);

        switch (rabbitsNei.length) {
            case 0:  rule = 3; break; // Rule 3 -> Carrot survives :)
            case 1:  rule = 4; break; // Rule 4 -> Rabbit eats carrot
            default: rule = 5; break; // Rule 5 -> A Rabbit 
        }

        return rule;
    }

    /**
     * @return The number of the elements of same type
     */
    private LifeBeing[] getOccurrences(ArrayList<LifeBeing> lifeBeings, int lifeId) {
        return lifeBeings.stream().filter(lf -> lf.ID == lifeId).toArray(LifeBeing[]::new);
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
    
    private LifeBeing getCell(int column, int row) { // (row,column) <=> (y, x)
        return this.meadowArr[(row + this.width) % this.width][(column + this.height) % this.height];
    }
    
    private ArrayList<LifeBeing> collectCellNeighbors(int x, int y) {
        ArrayList<LifeBeing> neighborsList = new ArrayList<>();

        for (int row = x - 1; row < x + 2; row++) {
            for (int column = y - 1; column < y + 2; column ++) {
                neighborsList.add(getCell(column, row));
            }
        }

        // Remove the center cell.
        neighborsList.remove(4);

        return neighborsList;
    }
    
    public void printGrassland() {
        for (int row = 0; row < height; row++) {
            System.out.print(row + "-> ");

            for (int column = 0; column < width; column++) {
                System.out.print("[" + this.meadowArr[row][column] + "] ");
            }
            System.out.print(NEWLINE);
        }
        System.out.println("Grassland Update:");
    }
}

