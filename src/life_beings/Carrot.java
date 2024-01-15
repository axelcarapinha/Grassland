package life_beings;

import main.Grassland;

public class Carrot extends LifeBeing {
    public Carrot(int row, int column) {
        super(Grassland.CARROT, row, column);
    }

    @Override
    public String toString() {
        return LifeBeing.ANSI_ORANGE + super.toString() + LifeBeing.ANSI_RESET;
    }
}
