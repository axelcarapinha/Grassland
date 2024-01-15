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
    public LifeBeing[][] nextMeadowArr;
    private int meadowWidth;
    private int meadowHeight;
    public static int starveTime;

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
        Grassland.starveTime = starveTime;

        this.random = new Random();
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

    public int starveTime() { return Grassland.starveTime; }

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

    //FIXME: professora NÃO tem starveTime no argumento
    public void addRabbit(int x, int y, int starveTime) {
        if (this.nextMeadowArr[x][y] instanceof Grass) {
            this.nextMeadowArr[x][y] = new Rabbit(x, y, starveTime);
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

        return new Grassland(this.meadowWidth, this.meadowHeight, Grassland.starveTime, this.nextMeadowArr); // por isso é que no enunciado está "novinho em folha"
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
    public void checkGrassRules(Grass oldGenGrass, ArrayList<LifeBeing> neighborsList) {
        LifeBeing[] carrots = this.getOccurrences(neighborsList, Grassland.CARROT);
        
        switch (carrots.length) {
            // Rule 6 -> Just keep empty when are less than 2 carrots as neighbours.
            case 0: case 1: this.nextMeadowArr[oldGenGrass.x][oldGenGrass.y] = oldGenGrass; break; 
            default: 
                LifeBeing[] rabbits =  this.getOccurrences(neighborsList, Grassland.RABBIT);
                if (rabbits.length <= 1) 
                    // Rule 7 -> A carrot spawns.
                    this.addCarrot(oldGenGrass.x, oldGenGrass.y);
                else 
                    // Rule 8 -> A rabbit is born.
                    this.addRabbit(oldGenGrass.x, oldGenGrass.y, 0);
                break;
        }
    }

    /**
     * Checks the rules 1, 2.
     * @return
     */
    public void checkRabbitRules(Rabbit oldGenRabbit, ArrayList<LifeBeing> neighborsList) {
        LifeBeing[] carrotsNeighbours = this.getOccurrences(neighborsList, Grassland.CARROT);
        switch (carrotsNeighbours.length) {
            // Rule 2 -> Rabbit will starve because hasn't eat a carrot.
            case 0: 
                oldGenRabbit.starveTime++;  
                if (oldGenRabbit.is_dead())
                    this.nextMeadowArr[oldGenRabbit.x][oldGenRabbit.y] = new Grass(oldGenRabbit.x, oldGenRabbit.y); 
                else 
                    this.nextMeadowArr[oldGenRabbit.x][oldGenRabbit.y] = oldGenRabbit;
                break;
            // Rule 1 -> Rabbit will eat the carrot.
            default: 
                oldGenRabbit.starveTime = 0;
                this.nextMeadowArr[oldGenRabbit.x][oldGenRabbit.y] = oldGenRabbit; 
                break;
        }
    }

    /**
     * Checks the rules 3, 4 and 5.
     * @return
     */
    public void checkCarrotRules(Carrot oldGenCarrot, ArrayList<LifeBeing> neighborsList) {
        LifeBeing[] rabbitNeighbours = this.getOccurrences(neighborsList, Grassland.RABBIT);
        
        switch (rabbitNeighbours.length) {
            // Rule 3 -> Carrot stays alive!
            case 0:  
                this.nextMeadowArr[oldGenCarrot.x][oldGenCarrot.y] = oldGenCarrot; 
                break; 
            // Rule 4 -> Carrot eaten by a Rabbit.
            case 1:  
                ((Rabbit) rabbitNeighbours[0]).starveTime = 0;
                this.nextMeadowArr[oldGenCarrot.x][oldGenCarrot.y] = rabbitNeighbours[0]; 
                break;
            // Rule 5 -> A Rabbit is born.
            default: 
                this.addRabbit(oldGenCarrot.x, oldGenCarrot.y, 0); 
                break;
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

    public void printGrassland(LifeBeing[][] mead) {
        for (int i = 0; i < meadowHeight; i++) {
            System.out.print(i + "-> ");

            for (int j = 0; j < meadowWidth; j++) {
                System.out.print("[" + mead[i][j] + "] ");

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

