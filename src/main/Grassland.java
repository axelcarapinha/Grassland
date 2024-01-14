package main;

import java.util.ArrayList;
import java.util.Random;

import life_beings.Carrot;
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
    private Random random;
    public LifeBeing[][] meadowArr;
    private LifeBeing[][] nextMeadowArr;
    private int meadowWidth;
    private int meadowHeight;
    protected int starveTime;

    /**
     *  Grassland() is a constructor that creates an empty meadow having width i and
     *  height j, in which rabbits starve after starveTime timesteps.
     *  @param i is the width of the meadow.
     *  @param j is the height of the meadow.
     *  @param starveTime is the number of timesteps rabbits survive without food.
     */

    public Grassland(int i, int j, int starveTime) throws Exception {
        this(i, j, starveTime, null);
    }

    public Grassland(int i, int j, int starveTime, LifeBeing[][] meadowArray) throws Exception {


        // Check if the starveTime is a valid nu
        if (starveTime <= 0 || i == 0 || j == 0) throw new Exception("Error: Invalid starve time");
        
        // Meadow properties
        this.meadowArr = meadowArray;
        
        // Fill the next Grassland meadow with 'Grass'.
        this.nextMeadowArr = new LifeBeing[i][j];
        for (int xx = 0; xx < this.nextMeadowArr.length; xx++) {
            for (int yy = 0; yy < this.nextMeadowArr.length; yy++) {
                this.nextMeadowArr[xx][yy] = new Grass(xx, yy);
            }
        }

        this.meadowWidth = i;
        this.meadowHeight = j;
        this.starveTime = starveTime;

        this.random = new Random();
    }

    public void startGrasslandLife () {
        // Fill the grass land.
        this.meadowArr = new LifeBeing[this.width()][this.height()];

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
                        this.meadowArr[i][j] = new Rabbit(i, j, this.starveTime);
                        counterRabbits++;
                        break;
                    case CARROT:
                        this.meadowArr[i][j] = new Carrot(i, j);
                        counterCarrots++;
                        break;
                }
            }
        }

        // There must be at least 1 rabbit in the grassland.
        int i = this.random.nextInt(this.width() - 1);
        int j = this.random.nextInt(this.height() - 1);

        meadowArr[i][j] = new Rabbit(i, j, this.starveTime);
    }

    /**
     *  width() returns the width of an Grassland object.
     *  @return the width of the meadow.
     */

    public int width() { return this.meadowWidth; }

    // If it returns "of a Grassland object,
    //? does it need to receive arguments with the address of the object?

    /**
     *  height() returns the height of an Grassland object.
     *  @return the height of the meadow.
     */

    public int height() { return this.meadowHeight; }

    /**
     *  starveTime() returns the number of timesteps rabbits survive without food.
     *  @return the number of timesteps rabbits survive without food.
     */

    public int starveTime() { return this.starveTime; }

    /**
     *  addCarrot() places a carrot in cell (x, y) if the cell is empty.  If the
     *  cell is already occupied, leave the cell as it is.
     *  @param x is the x-coordinate of the cell to place a carrot in.
     *  @param y is the y-coordinate of the cell to place a carrot in.
     */

    public void addCarrot(int x, int y) {
        if (this.nextMeadowArr[x][y] instanceof Grass) {
            this.nextMeadowArr[x][y] = new Carrot(x, y);
        }
    }

    /**
     *  addRabbit() (with two parameters) places a newborn rabbit in cell (x, y) if
     *  the cell is empty.  A "newborn" rabbit is equivalent to a rabbit that has
     *  just eaten.  If the cell is already occupied, leave the cell as it is.
     *  @param x is the x-coordinate of the cell to place a rabbit in.
     *  @param y is the y-coordinate of the cell to place a rabbit in.
     */

    public void addRabbit(int x, int y) {
        if (this.nextMeadowArr[x][y] instanceof Grass) {
            this.nextMeadowArr[x][y] = new Rabbit(x, y, this.starveTime);
        }
    }

    /**
     *  cellContents() returns EMPTY if cell (x, y) is empty, CARROT if it contains
     *  a carrot, and RABBIT if it contains a rabbit.
     *  @param x is the x-coordinate of the cell whose contents are queried.
     *  @param y is the y-coordinate of the cell whose contents are queried.
     */

    public LifeBeing cellContents(int x, int y) { return meadowArr[x][y]; }

    /**
     *  timeStep() performs a simulation timestep
     *  @return a meadow representing the elapse of one timestep.
     */
    public Grassland timeStep() throws Exception {
        for (int i = 0; i < meadowHeight; i++) {
            for (int j = 0; j < meadowWidth; j++) {
                grasslandRules(cellContents(i, j), collectCellNeighbors(i, j));
            }
        }

        return new Grassland(this.meadowWidth, this.meadowHeight, this.starveTime, this.nextMeadowArr); // por isso é que no enunciado está "novinho em folha"
    }

    public void grasslandRules(LifeBeing oldGen, ArrayList<LifeBeing> neighborsList) throws Exception {
        switch (oldGen.ID) {
            case GRASS:
                this.checkGrassRules(((Grass) oldGen), neighborsList);
                break;
            case RABBIT:
                this.checkRabbitRules((Rabbit) oldGen, neighborsList);
                break;
            case CARROT:
                this.checkCarrotRules(((Carrot) oldGen), neighborsList);
                break;
            default:
                throw new Exception("Error: Couldn't identify the life being '" + oldGen.getClass() + "' with " + oldGen.ID + " ID.");
        }
    }
    
    /**
     * Checks the rules 6, 7. and 8.
     * @return
     */
    public void checkGrassRules(Grass oldGen, ArrayList<LifeBeing> neighborsList) {
        LifeBeing[] carrots = this.getOccurrences(neighborsList, Grassland.CARROT);
        
        switch (carrots.length) {
            case 0: case 1: this.nextMeadowArr[oldGen.x][oldGen.y] = oldGen; break; // less than 2 carrots
            default: 
                LifeBeing[] rabbits =  this.getOccurrences(neighborsList, Grassland.RABBIT);
                if (rabbits.length <= 1) 
                    this.addCarrot(oldGen.x, oldGen.y);
                else 
                    this.addRabbit(oldGen.x, oldGen.y);
                break;
        }
    }

    /**
     * Checks the rules 1, 2.
     * @return
     */
    public void checkRabbitRules(Rabbit oldGen, ArrayList<LifeBeing> neighborsList) {
        LifeBeing[] targets = this.getOccurrences(neighborsList, Grassland.CARROT);
        switch (targets.length) {
            case 0:  this.nextMeadowArr[oldGen.x][oldGen.y] = oldGen; break; 
            default: this.addRabbit(targets[0].x,targets[0].y); break;
            // default: this.addRabbit(oldGen.x, oldGen.y); break;
        }
    }

    /**
     * Checks the rules 3, 4 and 5.
     * @return
     */
    public void checkCarrotRules(Carrot oldGen, ArrayList<LifeBeing> neighborsList) {
        LifeBeing[] lifeBeings = this.getOccurrences(neighborsList, Grassland.CARROT);
        
        switch (lifeBeings.length) {
            case 0:  this.nextMeadowArr[oldGen.x][oldGen.y] = oldGen; break; 
            case 1:  this.addRabbit(lifeBeings[0].x, lifeBeings[0].y); break;
            default: this.addRabbit(oldGen.x, oldGen.y); break;
        }
    }
    
    /**
     * @return The number of the elements of same type
     */
    private LifeBeing[] getOccurrences(ArrayList<LifeBeing> lifeBeings, int lifeId) {
        return lifeBeings.stream().filter(lf -> lf.ID == lifeId).toArray(LifeBeing[]::new);
    }
    
    private ArrayList<LifeBeing> collectCellNeighbors(int x, int y) {
        ArrayList<LifeBeing> neighborsList = new ArrayList<>();

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j ++) {
                int xLifeBeing = (i + meadowWidth) % meadowWidth;
                int yLifeBeing = (j + meadowHeight) % meadowHeight;
                neighborsList.add(meadowArr[xLifeBeing][yLifeBeing]);
            }
        }
        
        // Remove the center field.
        neighborsList.remove(5);

        return neighborsList;
    }

    public void printGrassland() {
        for (int i = 0; i < meadowHeight; i++) {
            System.out.print((i + 1) + "-> ");

            for (int j = 0; j < meadowWidth; j++) {
                System.out.print("[" + this.meadowArr[i][j] + "] ");

            }
            System.out.print(NEWLINE);
        }

        // if (Main.verbose) {
        //     System.out.print(
        //                     "CounterGrass  = "  + counterGrass    + "( " + (counterGrass   / (float)(meadowHeight * meadowWidth)) * 100 + " %)" + NEWLINE +
        //                     "CounterCarrot = "  + counterCarrots  + "( " + (counterCarrots / (float)(meadowHeight * meadowWidth)) * 100 + " %)" + NEWLINE +
        //                     "CounterRabbits = " + counterRabbits  + "( " + (counterRabbits / (float)(meadowHeight * meadowWidth)) * 100 + " %)" + NEWLINE
        //     );
        // }
    }
}

