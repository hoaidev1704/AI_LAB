package AI_LAB1;

import java.util.Random;

public class DynamicAction extends Action {
  private String name;

  public DynamicAction(String name) {
    this.name = name;
  }

  @Override
  public boolean isNoOp() {
    return false;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public static Action createRandomActionMoving() {
    Random random = new Random();
    return new DynamicAction(
        Environment.MOVING_ACTION.get(random.nextInt(Environment.MOVING_ACTION.size())).name());
  }
}
