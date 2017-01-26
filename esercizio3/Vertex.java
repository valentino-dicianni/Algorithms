package src.esercizio3;


public class Vertex extends Object{

  private final String name;
  private float distance = 0;
  public Vertex father = null;

  public Vertex (String name) {
    this.name = name;
    this.distance = Float.MAX_VALUE;
  }

  public String getName() {
    return this.name;
  }

  public float getDistance() {
    return this.distance;
  }

  public Vertex getFather() {
    return this.father;
  }

  public void setDistance(float distance) {
    this.distance = distance;
  }


  /**
   *  Override equals and hashCode methods for
   *  a perfect use of hashTables.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Vertex vertex = (Vertex) o;

    return name.equals(vertex.name);

  }
  @Override
  public int hashCode() {
    return name.hashCode();
  }
}