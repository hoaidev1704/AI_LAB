package AI_LAB1;

public class AgentProgram {

  public Action execute(Percept p, EnvironmentType environmentType) { // location, status
    if (environmentType.equals(EnvironmentType.TWO_SQUARES)) {
      return executeForSimpleEnvironment(p);
    } else {
      return executeForEnhancedEnvironment(p);
    }
  }
  ;

  private Action executeForSimpleEnvironment(Percept p) {
    if (p.getLocationState().equals(EnvironmentSimple.LocationState.DIRTY)) {
      return EnvironmentSimple.SUCK_DIRT;
    } else if (p.getAgentLocation().equals(EnvironmentSimple.LOCATION_A)) {
      return EnvironmentSimple.MOVE_RIGHT;
    } else if (p.getAgentLocation().equals(EnvironmentSimple.LOCATION_B)) {
      return EnvironmentSimple.MOVE_LEFT;
    }
    return NoOpAction.NO_OP;
  }

  private Action executeForEnhancedEnvironment(Percept p) {
    if (p.getLocationState().equals(EnvironmentSimple.LocationState.DIRTY)) {
      return EnvironmentSimple.SUCK_DIRT;
    } else {
      return DynamicAction.createRandomActionMoving();
    }
  }
}
