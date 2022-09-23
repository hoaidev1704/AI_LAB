package AI_LAB1;

public class Agent {
  private AgentProgram program;
  private EnvironmentType environmentType;

  public enum AgentAction {
    LEFT,
    DOWN,
    RIGHT,
    UP,
    SUCK
  }

  public Agent() {}

  public Agent(AgentProgram aProgram, EnvironmentType anEnvironmentType) {
    program = aProgram;
    environmentType = anEnvironmentType;
  }

  public Action execute(Percept p) {
    if (program != null) {
      return program.execute(p, environmentType);
    }
    return NoOpAction.NO_OP;
  }
}
