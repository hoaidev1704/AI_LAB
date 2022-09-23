package AI_LAB1;

public class TestSimpleReflexAgent {
  public static void main(String[] args) {
    Environment env = EnvironmentFactory.getEnvironment(EnvironmentType.TWO_SQUARES);
    Agent agent = new Agent(new AgentProgram(), EnvironmentType.TWO_SQUARES);
    env.addAgent(agent, Environment.LOCATION_A);

    Environment envE = EnvironmentFactory.getEnvironment(EnvironmentType.GIRD);
    Agent agentE = new Agent(new AgentProgram(), EnvironmentType.GIRD);
    envE.addAgent(agentE, new Location(0, 0));

    envE.stepUntilDone();
  }
}
