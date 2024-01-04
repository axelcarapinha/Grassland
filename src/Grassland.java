import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;


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
    private int[][] meadowArr;
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

    public Grassland(int i, int j, int starveTime) {
        // Meadow properties
        this.meadowArr = new int[i][j];
        this.meadowWidth = i;
        this.meadowHeight = j;
        this.starveTime = starveTime;

        this.random = new Random();

        startGrasslandLife(); //? can it be positioned here?
    }

    public void startGrasslandLife () {
        fillGrassland();
        printGrassland(); // this can be the future animation function
        // code

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
        //TODO compreender porque estava deste modo
        if (meadowArr[x][y] == GRASS) {
            meadowArr[x][y] = CARROT;
        }

//        meadowArr[x][y] = CARROT;
    }



    /**
     *  addRabbit() (with two parameters) places a newborn rabbit in cell (x, y) if
     *  the cell is empty.  A "newborn" rabbit is equivalent to a rabbit that has
     *  just eaten.  If the cell is already occupied, leave the cell as it is.
     *  @param x is the x-coordinate of the cell to place a rabbit in.
     *  @param y is the y-coordinate of the cell to place a rabbit in.
     */

    public void addRabbit(int x, int y) {
        //TODO mesma dúvida do de cima
        if (meadowArr[x][y] == GRASS) {
            meadowArr[x][y] = RABBIT;
        }

//        meadowArr[x][y] = RABBIT;

    }



    /**
     *  cellContents() returns EMPTY if cell (x, y) is empty, CARROT if it contains
     *  a carrot, and RABBIT if it contains a rabbit.
     *  @param x is the x-coordinate of the cell whose contents are queried.
     *  @param y is the y-coordinate of the cell whose contents are queried.
     */

    public int cellContents(int x, int y) {
        // Usar o método GetClass para que retorne uma String
        // (usa-se mais matéria assim)

        // usar o .getName() quando se tiver classes (para nome sem "class" antes, full name this way)
        // ou algo como .getNumericValue (oportunidade de enums)


        return meadowArr[x][y];
    }



    /**
     *  timeStep() performs a simulation timestep
     *  @return a meadow representing the elapse of one timestep.
     */

    //? Porque é que é public? (Dúvida)
    //TODO alterar para se basearem as regras apenas no anterior )(
    public Grassland timeStep() {

        for (int i = 0; i < meadowWidth; i++) {
            for (int j = 0; j < meadowHeight; j++) {
                meadowArr[i][j] = GrasslandRules(cellContents(i, j), cellNeighbors(i, j));
            }
        }


    // pixeis



        return new Grassland(meadowWidth, meadowHeight, starveTime); // por isso é que no enunciado está "novinho em folha"
    }

    // Returns the LifeBeing (after not using numbers)
    private int GrasslandRules(int oldGen, ArrayList<Integer> neighborsList) {
        int newGen = GRASS;

        // Sugiro usar-se instanceof quando for para as formas de vida
//        switch (oldGen) {
//            case GRASS:
//                if ()
//                    break;
//            case RABBIT:
//                newGen = (neighborsList.contains(CARROT)) ? RABBIT :
//            case CARROT:
//                if (neighborsList.(RABBIT)) newGen = RABBIT;
//
//        }

         return newGen;
    }

    //TODO fazer com módulos (que suportem números negativos)

    //TODO voltar a colocar isto private
    public ArrayList<Integer> cellNeighbors(int x, int y) {
        ArrayList<Integer> neighborsList = new ArrayList<>();

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j ++) {
                if (i != (x + 3 / 2) &&
                        j != (y + 3 / 2)) {
                    neighborsList.add(meadowArr[i % 5][j % 5]);
                }
            }
        }

        return neighborsList;
    }




    // Using the addresses of the newly created Grasslands
    // to copy the changed values (after step function) of the latest Grassland
    // to the new one (created)
    // just pass the array by reference, I guess (contará como "novinho em folha"?)
    protected void swapGrasslands (Grassland giver, Grassland taker) {

    }










    private void fillGrassland() {
        for (int i = 0; i < meadowWidth; i++) {
            for (int j = 0; j < meadowHeight; j++) {



                // Dúvida:
                // é necessário irem-se atualizando os valores enquanto se verifica
                // porque senão podia um coelho comer uma cenoura,
                // nascer um novo
                // e outro velho que fosse comer a cenoura acabava por substituir o novo
                    //! Resposta: NÃO. Cria-se um grassland "novinho em folha"

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

                this.meadowArr[i][j] = typeOfLife;

                //! VERBOSE
                if (Main.verbose) {
                    switch (typeOfLife) {
                        case GRASS:
                            counterGrass++;
                            break;
                        case RABBIT:
                            counterRabbits++;
                            break;
                        case CARROT:
                            counterCarrots++;
                            break;
                    }
                }






            }
        }
    }



    // Prints a grid with the (for now) numeric values
    // of the type of life they have
    public void printGrassland() {
        for (int i = 0; i < meadowWidth; i++) {
            System.out.print((i + 1) + "-> ");

            for (int j = 0; j < meadowHeight; j++) {
                System.out.print("[" + meadowArr[i][j] + "] ");

            }
            System.out.print(NEWLINE);
        }

        if (Main.verbose) {
            System.out.print(
                            "CounterGrass  = "  + counterGrass   + "( " + (counterGrass   / (float)(meadowHeight * meadowWidth)) * 100 + " %)"   + NEWLINE +
                            "CounterCarrot = " + counterCarrots  + "( " + (counterCarrots / (float)(meadowHeight * meadowWidth)) * 100 + " %)" + NEWLINE +
                            "CounterRabbits = " + counterRabbits + "( " + (counterRabbits / (float)(meadowHeight * meadowWidth)) * 100 + " %)" + NEWLINE
            );
        }


    }










}

