package life_beings;

import main.Grassland;

public class Rabbit extends LifeBeing {
  public int starveTime = 0;

  public Rabbit(int x, int y, int starveTime) {
    super(Grassland.RABBIT, x, y);
    this.starveTime = starveTime;
  }
}
