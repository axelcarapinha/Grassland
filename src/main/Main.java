
package main;

public class Main {
    public static void main(String[] argv) {
        int i, j, starveTime;
        InputWindow inputWindow = new InputWindow();
        
        while (!inputWindow.isSimulationReady()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
 
        i = inputWindow.getGrasslandWidth();
        j = inputWindow.getGrasslandHeight();
        starveTime = inputWindow.getGrasslandStarveTime();

        Simulation simulation = new Simulation(i, j, starveTime);
        simulation.start();
    }
}