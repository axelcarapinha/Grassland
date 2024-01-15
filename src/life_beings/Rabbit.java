package life_beings;

import main.Grassland;

public class Rabbit extends LifeBeing {
    public int starveTime = 0;

    public Rabbit(int row, int column, int starveTime) {
        super(Grassland.RABBIT, row, column);
        this.starveTime = starveTime;
    }

    public void starve() {
        this.starveTime++;
    }

    public void eatCarrot() {
        this.starveTime = 0;
    }

    public boolean is_dead(int grasslandStarveTime) {
        return this.starveTime >= grasslandStarveTime; // >= because it is drawing the 0th generation before updating.
    }

    @Override
    public String toString() {
        return LifeBeing.ANSI_GREY + super.toString() + LifeBeing.ANSI_RESET;
    }
}
