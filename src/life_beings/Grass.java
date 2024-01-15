package life_beings;

import main.Grassland;

public class Grass extends LifeBeing {
  public Grass(int row, int column) {
    super(Grassland.GRASS, row, column);
  }

  @Override
  public String toString() {
    return LifeBeing.ANSI_GREEN + super.toString() + LifeBeing.ANSI_RESET;
  }
}
