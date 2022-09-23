package AI_LAB1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
  private int x;
  private int y;

  @Override
  public boolean equals(Object o) {
    if (o instanceof Location) {
      Location location = (Location) o;
      return this.x == location.getX() && this.y == location.getY();
    }
    return false;
  }

  @Override
  public int hashCode() {
    return (this.x + " " + this.y).hashCode();
  }

  @Override
  public String toString() {
    return "X: " + this.x + " & Y: " + this.y;
  }

  public void move(Agent.AgentAction agentAction) {
    switch (agentAction) {
      case RIGHT:
        y += 1;
        break;
      case LEFT:
        y -= 1;
        break;
      case DOWN:
        x -= 1;
        break;
      case UP:
        x += 1;
        break;
      default:
        break;
    }
  }
}
