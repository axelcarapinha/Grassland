
/*
package main;

import java.util.ArrayList;

import life_beings.Carrot;
import life_beings.LifeBeing;
import life_beings.Grass;
import life_beings.Rabbit;


public class Main {

    public static boolean verbose;

    public static void main(String[] args) {
        // Print "debugging" information.
        verbose = args.length > 0 && (args[0].equals("--verbose") || args[0].equals("-v"));
        
        try {
            // Custom grassland.
            Grassland meadow = new Grassland(6, 6, 3);
            meadow.startGrasslandLife();
            
            // ArrayList<LifeBeing> l = new ArrayList<>();
            // for (int i = 0; i < 36; i++) {
            //     l.add(new Grass(0, 0));
            // }
            // l.add(new )
            
            System.out.println("Old Grassland: ");
            meadow.printGrassland(meadow.meadowArr);

            ArrayList<LifeBeing> neighbours = new ArrayList<>(8);
            neighbours.add(new Grass(0, 0)); neighbours.add(new Grass(0, 1)); neighbours.add(new Grass(0, 2));
            neighbours.add(new Grass(1, 0));                                  neighbours.add(new Grass(1, 2));
            neighbours.add(new Grass(2, 0)); neighbours.add(new Grass(2, 1)); neighbours.add(new Grass(2, 2));
            meadow.checkRabbitRules((Rabbit) (meadow.meadowArr[1][1]), neighbours);

            System.out.println("New Grassland: ");
            // System.out.println(((Rabbit)neighbours.get(0)).starveTime);
            meadow.printGrassland(meadow.nextMeadowArr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/


