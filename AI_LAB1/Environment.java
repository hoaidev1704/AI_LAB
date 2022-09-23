package AI_LAB1;

import java.util.List;

public abstract class Environment<T> {
  public static final Action MOVE_LEFT = new DynamicAction(Agent.AgentAction.LEFT.name());
  public static final Action MOVE_RIGHT = new DynamicAction(Agent.AgentAction.RIGHT.name());
  public static final Action MOVE_UP = new DynamicAction(Agent.AgentAction.UP.name());
  public static final Action MOVE_DOWN = new DynamicAction(Agent.AgentAction.DOWN.name());
  public static final Action SUCK_DIRT = new DynamicAction(Agent.AgentAction.SUCK.name());
  public static final String LOCATION_A = "A";
  public static final String LOCATION_B = "B";
  protected EnvironmentState<T> envState;
  protected boolean isDone = false; // all squares are CLEAN
  protected Agent agent = null;
  public static final List<Agent.AgentAction> MOVING_ACTION =
      List.of(
          Agent.AgentAction.LEFT,
          Agent.AgentAction.DOWN,
          Agent.AgentAction.RIGHT,
          Agent.AgentAction.UP);

  public enum LocationState {
    CLEAN,
    DIRTY,
    WALL
  }

  protected abstract void step();

  protected abstract boolean isDone(EnvironmentState es);

  public void step(int n) {
    for (int i = 0; i < n; i++) {
      step();
      System.out.println("-------------------------");
    }
  }

  public void stepUntilDone() {
    int i = 0;
    while (!isDone) {
      System.out.println("step: " + i++);
      step();
    }
  }

  // add an agent into the enviroment
  public void addAgent(Agent agent, T location) {
    envState.setAgentLocation(location);
    this.agent = agent;
  }

  public EnvironmentState getCurrentState() {
    return this.envState;
  }

  // get percept<AgentLocation, LocationState> at the current location where agent
  // is in.
  public Percept getPerceptSeenBy() {
    return new Percept(
        envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
  }
}
