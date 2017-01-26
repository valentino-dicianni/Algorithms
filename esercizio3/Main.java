package src.esercizio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

  static String path = "italian_dist_graph.csv";

  static long start;
  static long elapsedTimeMillisec;


  public static void main(String[] args) {
    Graph graph = new Graph();

    BufferedReader br = null;
    try {
      String sCurrentLine;
      br = new BufferedReader(new FileReader(path));
      while ((sCurrentLine = br.readLine()) != null) {
        String[] fields = sCurrentLine.split(",");
        graph.add(fields);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null) br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    System.out.println("GRAPH size: " + graph.size());

//     TORINO - CATANIA
    start = System.currentTimeMillis();
    ArrayList<Vertex> path = graph.findShortestPath("torino", "catania");
    elapsedTimeMillisec += System.currentTimeMillis() - start;
    if (path != null) {
      float length = path.get(0).getDistance();
//      for (Vertex tmp : path) {
//        System.out.print(tmp.getName() + " -> ");
//      }
      System.out.println("DISTANCE : " + length/1000 + " Km find in " + elapsedTimeMillisec + " millsec");
    }
    else System.out.print("Path NOT found");

//      TORINO - BORSOI
    start = System.currentTimeMillis();
    ArrayList<Vertex> cammini = graph.findShortestPath("torino", "borsoi");
    elapsedTimeMillisec += System.currentTimeMillis() - start;
    if (cammini != null) {
      float lunghezza = cammini.get(0).getDistance();
//      for (Vertex tmp : cammini) {
//        System.out.print(tmp.getName() + " -> ");
//      }
      System.out.println("DISTANCE : " + lunghezza/1000 + " Km find in " + elapsedTimeMillisec + " millsec");
    }
    else System.out.println("Path NOT found");
    System.out.println("\nComponents Strongly Connected:\n");
    Kosaraju k = new Kosaraju();

     k.gatherStronglyConnected(graph.getGraph(), graph.getGraphRev());
  }


}
