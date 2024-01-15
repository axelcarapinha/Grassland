package life_beings;

import main.Grassland;

public class Carrot extends LifeBeing {
  public Carrot(int x, int y) {
    super(Grassland.CARROT, x, y);
  }

  @Override
  public String toString() {
    return LifeBeing.ANSI_ORANGE + super.toString() + LifeBeing.ANSI_RESET;
  }
}
