package life_beings;

public abstract class LifeBeing {
  public final int ID;
  public int x, y;
  
  public LifeBeing(int ID, int x, int y) {
    this.ID = ID;
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
