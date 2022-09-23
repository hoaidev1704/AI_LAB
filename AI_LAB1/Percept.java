package AI_LAB1;

public class Percept<T> {
  private T agentLocation;
  private EnvironmentSimple.LocationState state;

  public Percept(T agentLocation, EnvironmentSimple.LocationState state) {
    this.agentLocation = agentLocation;
    this.state = state;
  }

  public EnvironmentSimple.LocationState getLocationState() {
    return this.state;
  }

  public T getAgentLocation() {
    return this.agentLocation;
  }
}
