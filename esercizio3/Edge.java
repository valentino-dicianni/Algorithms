package src.esercizio3;


public class Edge {
  private final Vertex source, destination;
  private final float distance;

  public Edge (Vertex source, Vertex destination, float distance) {
    this.source = source;
    this.destination = destination;
    this.distance = distance;
  }

  public Vertex getAdjacentNode (Vertex v) {
    return v.getName().equals(this.source.getName()) ? this.destination : null;
  }

  public float getDistance() {
    return distance;
  }

  public Vertex getSource() {
    return this.source;
  }

  public Vertex getDestination() {
    return this.destination;
  }
}
