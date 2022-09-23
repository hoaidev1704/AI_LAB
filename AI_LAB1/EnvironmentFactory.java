package AI_LAB1;

public class EnvironmentFactory {
  public static final Environment getEnvironment(EnvironmentType environmentType) {
    switch (environmentType) {
      case TWO_SQUARES:
        return new EnvironmentSimple(
            EnvironmentSimple.LocationState.CLEAN, EnvironmentSimple.LocationState.DIRTY);
      case GIRD:
        return new EnvironmentEnhanced(5, 5);
      default:
        throw new IllegalArgumentException("This environment type is unsupported");
    }
  }
}
