
public class Main {
    public static boolean verbose;

    public static void main(String[] args) {
        verbose = args.length > 0 && (args[0].equals("--verbose") || args[0].equals("-v"));
        Grassland meadow = new Grassland(5,5,0);

        // Create an iterator object
        //! Ver porque isto não acabou de preencher com o pretendido
        for (int i = 0; i < meadow.width(); i++) {
            for (int j = 0; j < meadow.height(); j++) {
                meadow.addCarrot(i,j);
            }
        }

        meadow.printGrassland();




    }
}
