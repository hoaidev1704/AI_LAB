package AI_LAB1;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentState<T> {
  private Map<T, Environment.LocationState> state = new HashMap<>();
  private T agentLocation = null; //

  public EnvironmentState() {}

  public void setAgentLocation(T location) {
    this.agentLocation = location;
  }

  public T getAgentLocation() {
    return this.agentLocation;
  }

  public Environment.LocationState getLocationState(T location) {
    return this.state.get(location);
  }

  public void setLocationState(T location, EnvironmentSimple.LocationState locationState) {
    this.state.put(location, locationState);
  }

  public void display() {
    System.out.println("Environment state: \n\t" + this.state);
  }

  public void displayDirtyOnly() {
    System.out.println("Environment state: \n\t");
    this.state
        .keySet()
        .forEach(
            key -> {
              if (state.get(key).equals(Environment.LocationState.DIRTY)) {
                System.out.println(key.toString() + " ");
              }
            });
  }

  public Map<T, EnvironmentSimple.LocationState> getState() {
    return this.state;
  }
}
