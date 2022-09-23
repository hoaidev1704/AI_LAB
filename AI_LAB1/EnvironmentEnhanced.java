package AI_LAB1;

import java.util.Random;

public class EnvironmentEnhanced extends Environment<Location> {
  private static final double DIRT_RATE = 0.1;
  private static final double WALL_RATE = 0.2;
  private final int height;
  private final int width;
  private int score = 0;

  public EnvironmentEnhanced(int height, int width) {
    this.height = height;
    this.width = width;
    createEnvironmentState();
  }

  @Override
  protected void step() {
    envState.display();
    Location agentLocation = this.envState.getAgentLocation();
    Action anAction = agent.execute(getPerceptSeenBy());
    caculateScore(anAction);
    EnvironmentState es = executeAction(anAction);

    System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

    if (isDone(es)) {
      isDone = true;
    }
    es.displayDirtyOnly();
  }

  @Override
  protected boolean isDone(EnvironmentState es) {
    return !es.getState().values().contains(LocationState.DIRTY);
  }

  public EnvironmentState executeAction(Action action) {
    Agent.AgentAction agentAction = Agent.AgentAction.valueOf(action.toString());
    if (MOVING_ACTION.contains(agentAction)) {
      Location locationTmp =
          new Location(envState.getAgentLocation().getX(), envState.getAgentLocation().getY());
      locationTmp.move(agentAction);
      if (isAbleMove(locationTmp)) {
        envState.setAgentLocation(locationTmp);
      }
    } else {
      envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
    }
    return envState;
  }

  private int getFinalDirtRate() {
    return (int) (height * width * DIRT_RATE);
  }

  private int getFinalWallRate() {
    return (int) (height * width * WALL_RATE);
  }

  private void createEnvironmentState() {
    envState = new EnvironmentState();
    for (int i = 0; i < height; ) {
      for (int j = 0; j < width; j++) {
        envState.setLocationState(new Location(i, j), LocationState.CLEAN);
      }
      i++;
    }
    createDirt();
    createWall();
  }

  private void createDirt() {
    int rate = this.getFinalDirtRate();
    Random random = new Random();
    int i = 0;
    while (i < rate) {
      int x = random.nextInt(height - 1);
      int y = random.nextInt(width - 1);
      Location location = new Location(x, y);
      if (envState.getLocationState(location).equals(LocationState.CLEAN)) {
        envState.setLocationState(location, LocationState.DIRTY);
        i++;
      }
    }
  }

  private void createWall() {
    int rate = this.getFinalWallRate();
    Random random = new Random();
    int i = 0;
    while (i < rate) {
      int x = random.nextInt(height - 1);
      int y = random.nextInt(width - 1);
      Location location = new Location(x, y);
      if (envState.getLocationState(location).equals(LocationState.CLEAN)) {
        envState.setLocationState(location, LocationState.WALL);
        i++;
      }
    }
  }

  public void caculateScore(Action dynamicAction) {
    if (dynamicAction.toString().equals(Agent.AgentAction.SUCK)) {
      score += 500;
    } else {
      score -= 100;
    }
  }

  public boolean isAbleMove(Location location) {
    return envState.getState().keySet().contains(location);
  }
}
