package src.esercizio3;

import java.util.*;


public class Graph {

  private final HashMap<Vertex, ArrayList<Edge>> adj;
  private final HashMap<Vertex, ArrayList<Edge>> adjRev;


  public Graph() {
    this.adj = new HashMap<Vertex, ArrayList<Edge>>();
    this.adjRev = new HashMap<Vertex, ArrayList<Edge>>();
  }

  public HashMap<Vertex, ArrayList<Edge>> getGraph() {
    return this.adj;
  }
  public HashMap<Vertex, ArrayList<Edge>> getGraphRev() {
    return this.adjRev;
  }


  /**
   * Add method that create adjacency lists for the graph
   * and also create his transposed.
   */
  public void add(String[] fields) {
    if (fields == null) return;
    Vertex v1 = new Vertex(fields[0]);
    Vertex v2 = new Vertex(fields[1]);
    Edge edge = new Edge(v1, v2, Float.parseFloat(fields[2]));
    Edge edgeRev = new Edge(v2, v1, Float.parseFloat(fields[2]));
    ArrayList<Edge> tmp;
    ArrayList<Edge> arr;
    if (this.adj.containsKey(v1)) {
      tmp = this.adj.get(v1);
      tmp.add(edge);
    }
    else {
      arr = new ArrayList<Edge>();
      arr.add(edge);
      this.adj.put(v1, arr);
    }
    if (this.adjRev.containsKey(v2)) {
      tmp = this.adjRev.get(v2);
      tmp.add(edgeRev);
    }
    else {
      arr = new ArrayList<Edge>();
      arr.add(edgeRev);
      this.adjRev.put(v2, arr);
    }
  }


  /**
   * This method is a Dijkstra algorithm implementation, but
   * it only returns path form "source" to "dest".
   * We decided to use an HashMap as a priorityQueue, and we created
   * a method that searches the minimum through the Map. (we opted for the
   * hashMap because it was easier to handle and more suitable for our purposes)
   *
   * The first part of this method searches the source vertex into the graph,
   * sets his distance to 0 and put it inside the queue.
   * The following while cycle remove from the queue the min vertex and puts it
   * into the visited hashSet.
   *
   * -> IF: the vertex is the dest vertex, then the shortest path is found:
   * a doneSet arrayList is created and is filled with all fathers from
   * dest to source.
   *
   * -> ELSE: for every edge of minVertex, the father is set, the distance
   * is set and, if the vertex has not been visited, it is insert into the
   * queue.(if the vertex is already into the queue, if the distance is different,
   * the new vertex with the new distance is set instead of the old one)
   */

  public ArrayList<Vertex> findShortestPath(String source, String dest) {
    HashMap<Vertex, Float> queue = new HashMap<Vertex, Float>();
    HashSet<Vertex> visited = new HashSet<Vertex>();

    for (Map.Entry<Vertex, ArrayList<Edge>> entry : adj.entrySet()) {
      Vertex currNode = entry.getKey();
      if (source.equals(currNode.getName()) && !visited.contains(currNode)) {
        currNode.setDistance(0f);
        queue.put(currNode, currNode.getDistance());
        System.out.print("\nShortest path from: " + currNode.getName() + " to " + dest + "\n");
      }
    }

    while (!queue.isEmpty()) {
      Vertex minVertex = findMinVertex(queue);
      queue.remove(minVertex);
      visited.add(minVertex);

      //IF shortest path is found

      if (dest.equals(minVertex.getName())) {
        ArrayList<Vertex> doneSet = new ArrayList<Vertex>();
        Vertex Fpoint = minVertex;
        while(Fpoint.father != null) {
         doneSet.add(Fpoint);
          Fpoint = Fpoint.father;
        }
        return doneSet;
      }

      //ELSE
      if (this.adj.containsKey(minVertex)) {
        for (Edge edge : this.adj.get(minVertex)) {
          Vertex currentVertex = edge.getAdjacentNode(minVertex);
          currentVertex.father = minVertex;
          float newDistance = minVertex.getDistance() + edge.getDistance();
          if (newDistance < currentVertex.getDistance())
            currentVertex.setDistance(newDistance);
          if (!visited.contains(currentVertex)) {
            if ((queue.containsKey(currentVertex) && queue.get(currentVertex)>=currentVertex.getDistance()) || !queue.containsKey(currentVertex))
            queue.put(currentVertex, currentVertex.getDistance());
          }
        }
      }
    }
  return null;
  }


  public Vertex findMinVertex(HashMap<Vertex,Float> queue) {
    Map.Entry<Vertex, Float> min = null;
    for (Map.Entry<Vertex, Float> entry : queue.entrySet()) {
      if (min == null || min.getValue() > entry.getValue()) {
        min = entry;
        min.getKey().setDistance(entry.getValue());
      }
    }
  return min.getKey();
  }



  public int size() {
    return this.adj.size();
  }

  public int sizeRev() {
    return this.adjRev.size();
  }

  public void print() {
    int i = 0;
    for (Map.Entry<Vertex, ArrayList<Edge>> tmp : this.adj.entrySet()) {
      ArrayList<Edge> pointer = tmp.getValue();
      System.out.println("" + tmp.getKey().getName() + "--> " + pointer.size() + ", " + "\n");
      i++;
      if (i == 100) break;
    }
  }

  public String printAll() {
    int i = 0;
    String graph = "";
    for (Map.Entry<Vertex, ArrayList<Edge>> tmp : this.adj.entrySet()) {
      ArrayList<Edge> pointer = tmp.getValue();
      String adj = "";
      for (int j = 0; j < pointer.size(); j++) {
        Edge temp = pointer.get(j);
        adj+= temp.getDestination().getName() +"("+temp.getDistance()+"), ";
      }
      graph += "" + tmp.getKey().getName() + "--> " + adj + "\n";
      i++;
      if (i == 100) break;
    }
    return graph;
  }

  public String printString() {
    int i = 0;
    String graph = "";
    for (Map.Entry<Vertex, ArrayList<Edge>> tmp : this.adj.entrySet()) {
      ArrayList<Edge> pointer = tmp.getValue();
      graph += "" + tmp.getKey().getName() + "--> " + pointer.size() + ", " + "\n";
      i++;
      if (i == 100) break;
    }
    return graph;
  }

  public void printR() {
    int i = 0;
    for (Map.Entry<Vertex, ArrayList<Edge>> tmp : this.adjRev.entrySet()) {
      ArrayList<Edge> pointer = tmp.getValue();
      System.out.println("" + tmp.getKey().getName() + "--> " + pointer.size() + ", " + "\n");
      i++;
      if (i == 100) break;
    }
  }

  public String printRString() {
    int i = 0;
    String graph = "";
    for (Map.Entry<Vertex, ArrayList<Edge>> tmp : this.adjRev.entrySet()) {
      ArrayList<Edge> pointer = tmp.getValue();
      graph += "" + tmp.getKey().getName() + "--> " + pointer.size() + ", " + "\n";
      i++;
      if (i == 100) break;
    }
    return graph;
  }
}

