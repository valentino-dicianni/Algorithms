package src.esercizio3;

import java.util.*;

public class Kosaraju {

  private Stack<Vertex> finishingTime = new Stack<Vertex>();
  private HashSet discoveredNodes = new HashSet();

  private ArrayList<Vertex> listOfStronglyConnectedNodes = new ArrayList<Vertex>();

  public Kosaraju() {
  }

  public void visited() {
    System.out.println(discoveredNodes.size());
  }


  /**
   * -> this algorithm is called Kosaraju Algorithm.
   * CFC: after first dfs, finishingTime stack is full. Thanks to
   * this result, the dfsR is made on reverse graph: this method
   * fills the listOfStronglyConnectedNodes list for every cfc component.
   * Than, the list is printed by the gatherStronglyConnected method.
   */

  public void gatherStronglyConnected(HashMap<Vertex, ArrayList<Edge>> adj, HashMap<Vertex, ArrayList<Edge>> adjRev) {
    dfs(adj);
    discoveredNodes.clear();
    int count = 1;
    while (!finishingTime.isEmpty()) {
      Vertex v = finishingTime.pop();
      if (discoveredNodes.contains(v)) {
        continue;
      }
      listOfStronglyConnectedNodes.clear();
      dfsR(adjRev, v);
      // this will print the list of the strongly conn comp.
      if (listOfStronglyConnectedNodes.size() >= 1) {
        System.out.println("Component number " + count + " SIZE: " + listOfStronglyConnectedNodes.size());
        count++;
      }
    }
  }

  public String gatherStronglyConnectedString(HashMap<Vertex, ArrayList<Edge>> adj, HashMap<Vertex, ArrayList<Edge>> adjRev) {
    String gsc = "";
    dfs(adj);
    discoveredNodes.clear();
    int count = 1;
    while (!finishingTime.isEmpty()) {
      Vertex v = finishingTime.pop();
      if (discoveredNodes.contains(v)) {
        continue;
      }
      listOfStronglyConnectedNodes.clear();
      dfsR(adjRev, v);
      // this will print the list of the strongly conn comp.
      if (listOfStronglyConnectedNodes.size() > 1) {
        gsc += "[";
        for (int i = 0; i < listOfStronglyConnectedNodes.size(); i++) {
          Vertex temp = listOfStronglyConnectedNodes.get(i);
          gsc += temp.getName()+" ";
        }
        gsc += "]\n";
//        gsc += "Component number " + count + " SIZE: " + listOfStronglyConnectedNodes.size()+"\n";
        count++;
      }
    }
    return gsc;
  }


  /**
   * DFS: deep first search trough graph and trasposed graph
   * For every vertex, if it has not been discovered, the dfs function
   * is recursively called which visits the vertex and his adj.
   * After that, the vertex is put into the finishingTime stack.
   *
   * DFSR: the second dfs puts vertex into the listOfStronglyConnectedNodes
   * list and calls itself recursively on Vertex's adj list.
   * The dfsR in made according to the first dfs's results.
   */

  public void dfs(HashMap<Vertex, ArrayList<Edge>> adj) {
    for (Map.Entry<Vertex, ArrayList<Edge>> entry : adj.entrySet()) {
      if (!discoveredNodes.contains(entry.getKey()))
        dfs(adj, entry.getKey());
    }
  }

  public void dfs(HashMap<Vertex, ArrayList<Edge>> adj, Vertex v) {
    if (v == null) return;
    if (!adj.containsKey(v)) return;
    discoveredNodes.add(v);
    for (Edge edge : adj.get(v)) {
      if (!discoveredNodes.contains(edge.getAdjacentNode(v))) {
        dfs(adj, edge.getAdjacentNode(v));
      }
    }
    finishingTime.push(v);
  }

  public void dfsR(HashMap<Vertex, ArrayList<Edge>> adj, Vertex v) {
    if (v == null) return;
    if (!adj.containsKey(v)) return;
    discoveredNodes.add(v);
    listOfStronglyConnectedNodes.add(v);
    for (Edge edge : adj.get(v)) {
      if (!discoveredNodes.contains(edge.getAdjacentNode(v))) {
        dfsR(adj, edge.getAdjacentNode(v));
      }
    }
  }


  public void printList(ArrayList<Vertex> cfc) {
    for (Vertex v : cfc) {
      System.out.print(v.getName() + "-");
    }
    System.out.println("");
  }


}
