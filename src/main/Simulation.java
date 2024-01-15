package main;
import javax.swing.*;
import java.awt.*;

public class Simulation {
       private static final int cellSize = 30;

       private static int i = 6; //! 100                           // Default  width
       private static int j = 6; //! 100                         // Default  height
       private static int starveTime = 5;           // Default  starvation time

       private static void draw(Graphics graphics, Grassland mead) {
           if (mead != null) {
               int width = mead.width();
               int height = mead.height();

               for (int y = 0; y < height; y++) { // row
                   for (int x = 0; x < width; x++) { // columns
                       int contents = mead.cellContents(x, y); //! ACRESCENTADO o .ID
                       if (contents == Grassland.RABBIT) {
                           graphics.setColor(Color.GRAY);                   // Draw a red shark
                           graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                       } else if (contents == Grassland.CARROT) {
                           graphics.setColor(Color.ORANGE);                // Draw a green fish
                           graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                       } else {
                           graphics.setColor(Color.GREEN);
                           graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                       }
                   }
               }
           }
       }

       public static void main(String[] argv) throws InterruptedException {
           Grassland mea;

           /**
            *  Read the input parameters.
            */

           if (argv.length > 0) {
               try {
                   i = Integer.parseInt(argv[0]);
               }
               catch (NumberFormatException e) {
                   System.out.println("First argument to Simulation is not an number.");
               }
           }

           if (argv.length > 1) {
               try {
                   j = Integer.parseInt(argv[1]);
               }
               catch (NumberFormatException e) {
                   System.out.println("Second argument to Simulation is not an number.");
               }
           }

           if (argv.length > 2) {
               try {
                   starveTime = Integer.parseInt(argv[2]);
               }
               catch (NumberFormatException e) {
                   System.out.println("Third argument to Simulation is not an number.");
               }
           }
           JFrame frame = new JFrame("Rabbits and Carrots");

            // FIXME: 
           frame.setSize(i * cellSize, j * cellSize );
           // frame.setSize(800, 800);
           frame.show();

           /**
            *  Create a "Canvas" we can draw upon; attach it to the window.
            */

           Canvas canvas = new Canvas();
           canvas.setBackground(Color.white);
           // FIXME:
           canvas.setSize(i * cellSize, j * cellSize);
           // canvas.setSize(800, 800);
           frame.add(canvas);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Graphics graphics = canvas.getGraphics();
           frame.setLocationRelativeTo(null);
           //TODO: maybe apply
            //    frame.setResizable(false); // pode dar jeito
            //     ImageIcon image = new ImageIcon("logo.png");
            //     frame.setIconImage(image.getImage());
            //     frame.getContentPane().setBackground(new Color(0x000000));

           /**
            *  Create the initial grassland.
            */

            mea = new Grassland(i, j, starveTime);
            mea.startGrasslandLife();

            /**
                *  Visit each cell (in a roundabout order); randomly place a rabbit, carrot,
                *  or nothing in each.
                */

            /*Random random = new Random(0);      // Create a "Random" object with seed 0
            int x = 0;
            int y = 0;
            for (int xx = 0; xx < i; xx++) {
                x = (x + 78887) % i;           // This will visit every x-coordinate once
                if ((x & 8) == 0) {
                    for (int yy = 0; yy < j; yy++) {
                        y = (y + 78887) % j;       // This will visit every y-coordinate once
                        if ((y & 8) == 0) {
                            int r = random.nextInt();     // Between -2147483648 and 2147483647
                            if (r < 0) {                        // 50% of cells start with carrot
                                mea.addCarrot(x, y);
                            } else if (r > 1500000000) {     // ~15% of cells start with rabbit
                                mea.addRabbit(x, y, 0);
                            }

                        }
                    }
                }
            }*/

            /**
             *  Perform timesteps forever.
             */

            int i = 0;
            draw(graphics, mea);
            while (true) {  // Loop forever
                if (i != 0) {
                    Thread.sleep(1000 * 3); // Wait one second (1000 milliseconds)
                }

                // Tests
                // - - - -
                // L = 1 C = 5
//                System.out.println(mea.collectCellNeighbors(0,0));




                // - - - -
                draw(graphics, mea);                       // Draw the current meadow
                mea.printGrassland();
                //  For fun, you might wish to change the delay in the next line.
                //  If you make it too short, though, the graphics won't work properly.
                // mea = mea.timeStep();                              // Simulate a timestep
                i++;
            }
       }

   }
