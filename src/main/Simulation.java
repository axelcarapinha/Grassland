package main;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

import exceptions.InvalidGrasslandException;
//
public class Simulation {
    private static final int cellSize = 10;

    // private static int i = 100;        // Default  width
    // private static int j = 100;        // Default  height
    // private static int starveTime = 5; // Default  starvation time
    private int width = 100;        // Default  width
    private int height = 100;        // Default  height
    private int starveTime = 5; // Default  starvation time
    
    private static ArrayList<Grassland> timestamps =  new ArrayList<>(23); // default starting size for the timeStamps array

    public Simulation(int width, int height, int starveTime) {
        this.width = width;
        this.height = height;
        this.starveTime = starveTime;
    }

    public void startGrassland(Grassland mea) {
        /**
            *  Visit each cell (in a roundabout order); randomly place a rabbit, carrot,
            *  or nothing in each.
            */

        Random random = new Random(0);      // Create a "Random" object with seed 0
        int x = 0;
        int y = 0;
        for (int xx = 0; xx < width; xx++) {
            x = (x + 78887) % width;           // This will visit every x-coordinate once
            if ((x & 8) == 0) {
                for (int yy = 0; yy < height; yy++) {
                    y = (y + 78887) % height;       // This will visit every y-coordinate once
                    if ((y & 8) == 0) {
                        int r = random.nextInt();     // Between -2147483648 and 2147483647
                        if (r < 0) {                        // 50% of cells start with carrot
                            mea.addCarrot(x, y);
                        } else if (r > 1500000000) {     // ~15% of cells start with rabbit
                            mea.addRabbit(x, y);
                        }

                    }
                }
            }
        }
    }

    private static void draw(Graphics graphics, Grassland mead) {
        if (mead != null) {
            int width = mead.width();
            int height = mead.height();

            for (int y = 0; y < height; y++) { // Go through each row.
                for (int x = 0; x < width; x++) { // Go through each column.
                    int contents = mead.cellContents(x, y); 
                    if (contents == Grassland.RABBIT) {
                        graphics.setColor(Color.GRAY);                   
                        graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    } else if (contents == Grassland.CARROT) {
                        graphics.setColor(Color.ORANGE);                
                        graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    } else {
                        graphics.setColor(Color.GREEN);
                        graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    }
                }
            }
        }
    }

    public void start() { 
        Grassland mea;

        JFrame frame = new JFrame("Rabbits and Carrots");
        
        frame.setSize(this.width * cellSize, this.height * cellSize );
        frame.setVisible(true);
        // frame.show();

        /**
        *  Create a "Canvas" we can draw upon; attach it to the window.
        */

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.setSize(this.width * cellSize, this.height * cellSize);
        frame.add(canvas);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Graphics graphics = canvas.getGraphics();
        frame.setLocationRelativeTo(null);

        //TODO: maybe apply
        //    frame.setResizable(false); // pode dar jeito
        //     ImageIcon image = new ImageIcon("logo.png");
        //     frame.setIconImage(image.getImage());
        //     frame.getContentPane().setBackground(new Color(0x000000));

        // Create the initial grassland.

        try {

            mea = new Grassland(this.width, this.height, this.starveTime);
            // mea.startGrasslandLife(); // has a built-in random
            this.startGrassland(mea);

            // Perform timesteps forever. 
            int i = 0;
            while (i < Grassland.MAX_TIME) {  // Loop forever
                if (i != 0) {
                    Thread.sleep(1000); // Wait one second (1000 milliseconds)
                }

                // Draw the current meadow.
                mea.printGrassland();
                draw(graphics, mea); 

                // Simulate a time-step.
                try {
                    mea = mea.timeStep();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                i++;

                // Save the state for future reference
                Simulation.timestamps.add(mea);
            }
        } catch(InvalidGrasslandException | InterruptedException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
