
package main;

/*
public class Main {

    public static boolean verbose;

    public static void main(String[] args) {
        // Print "debugging" information.
        verbose = args.length > 0 && (args[0].equals("--verbose") || args[0].equals("-v"));

        try {
            // Custom grassland.
            Grassland meadow = new Grassland(5, 5, 3);
            meadow.startGrasslandLife();
            while(true) {
                meadow.printGrassland();
                meadow = meadow.timeStep();
                Thread.sleep(1000);
            }
            
            // ----------------------------------------------
            // Just to test.
            LifeBeing[][] grassland = new LifeBeing[3][3];

            for (int i = 0; i < grassland.length; i++) {
                for (int j = 0; j < grassland.length; j++) {
                    grassland[i][j] = new Grass(i, j); 
                }
            }

            for (int i = 0; i < grassland.length; i++) {
                for (int j = 0; j < grassland.length; j++) {
                    System.out.println(grassland[i][j]);
                }
            }
            // ---------------------------------------------

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/



//TODO ExitOnClose (quando se matarem os coelhos)
//TODO comparable nos coelhos por causa do starve time
//TODO retornar valores de erro em funções de contagem