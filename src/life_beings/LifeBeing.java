package life_beings;


public abstract class LifeBeing {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_ORANGE = "\u001B[33m";
  public static final String ANSI_GREY = "\u001B[90m";
  //
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
