
public class Main {
    public static boolean verbose;

    public static void main(String[] args) {
        verbose = args.length > 0 && (args[0].equals("--verbose") || args[0].equals("-v"));
        Grassland meadow = new Grassland(5,5,0);

        // Create an iterator object
        //! Ver porque isto não acabou de preencher com o pretendido
//        for (int i = 0; i < meadow.width(); i++) {
//            for (int j = 0; j < meadow.height(); j++) {
//                meadow.addRabbit(i,j);
//            }
//        }
        meadow.printGrassland();
//        System.out.println(String.toString(meadow.cellNeighbors(3,3)));
        //TODO I was testin this (4 neighbors missing)
        System.out.println(meadow.cellNeighbors(3,3));





    }
}
