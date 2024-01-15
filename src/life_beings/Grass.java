package life_beings;

import main.Grassland;

public class Grass extends LifeBeing {
  public Grass(int x, int y) {
    super(Grassland.GRASS, x, y);
  }

  @Override
  public String toString() {
    return LifeBeing.ANSI_GREEN + super.toString() + LifeBeing.ANSI_RESET;
  }
}
