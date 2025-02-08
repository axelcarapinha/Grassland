
package main;

public class Main {
    public static void main(String[] argv) {
        int i, j, starveTime, maxTime;
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
        maxTime = inputWindow.getGrasslandMaxTimeField();

        Simulation simulation = new Simulation(i, j, starveTime, maxTime);
        simulation.start();
    }
}