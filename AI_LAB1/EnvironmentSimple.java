package AI_LAB1;

public class EnvironmentSimple extends Environment<String> {

  public EnvironmentSimple(LocationState locAState, LocationState locBState) {
    envState = new EnvironmentState<String>();
    envState.setLocationState(EnvironmentSimple.LOCATION_A, locAState);
    envState.setLocationState(EnvironmentSimple.LOCATION_B, locAState);
  }

  // Update environment state when agent do an action
  public EnvironmentState<String> executeAction(Action action) {
    if (action.equals(EnvironmentSimple.MOVE_LEFT)) {
      envState.setAgentLocation(LOCATION_A);
    } else if (action.equals(EnvironmentSimple.MOVE_RIGHT)) {
      envState.setAgentLocation(LOCATION_B);
    } else if (action.equals(EnvironmentSimple.SUCK_DIRT)) {
      envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
    }
    return envState;
  }

  @Override
  protected void step() {
    envState.display();
    String agentLocation = this.envState.getAgentLocation();
    Action anAction = agent.execute(getPerceptSeenBy());
    EnvironmentState es = executeAction(anAction);

    System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

    isDone(es); // if both squares are clean, then agent do not need to do any action
    es.display();
  }

  @Override
  protected boolean isDone(EnvironmentState es) {
    if (!isDone) {
      isDone =
          ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
              && (es.getLocationState(LOCATION_B) == LocationState.CLEAN));
    }
    return isDone;
  }
}
