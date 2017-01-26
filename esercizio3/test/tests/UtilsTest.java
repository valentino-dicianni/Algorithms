package src.esercizio3.test.tests;


import src.esercizio3.Graph;
import src.esercizio3.Vertex;

import java.util.ArrayList;

public class UtilsTest {

    public static Graph createGraph(int n){
        Graph graph = new Graph();

        if(n == 1) {
            graph.add(new String[]{"1", "2", "4"});
            graph.add(new String[]{"1", "5", "8"});
            graph.add(new String[]{"1", "6", "3"});
            graph.add(new String[]{"2", "0", "7"});
            graph.add(new String[]{"3", "5", "5"});
            graph.add(new String[]{"3", "7", "7"});
            graph.add(new String[]{"4", "7", "2"});
            graph.add(new String[]{"5", "1", "5"});
            graph.add(new String[]{"5", "6", "3"});
            graph.add(new String[]{"5", "7", "3"});
            graph.add(new String[]{"6", "4", "6"});
            graph.add(new String[]{"6", "5", "4"});
            graph.add(new String[]{"7", "6", "5"});
        }else if(n == 2){
            graph.add(new String[]{"1", "0", "1"});
            graph.add(new String[]{"1", "2", "1"});
            graph.add(new String[]{"2", "4", "1"});
            graph.add(new String[]{"2", "6", "1"});
            graph.add(new String[]{"3", "0", "1"});
            graph.add(new String[]{"3", "5", "1"});
            graph.add(new String[]{"4", "2", "1"});
            graph.add(new String[]{"4", "6", "1"});
            graph.add(new String[]{"5", "2", "1"});
            graph.add(new String[]{"5", "3", "1"});
            graph.add(new String[]{"6", "4", "1"});
            graph.add(new String[]{"6", "2", "1"});
            graph.add(new String[]{"6", "1", "1"});
            graph.add(new String[]{"7", "6", "1"});
        }else if(n == 3){
            graph.add(new String[]{"a", "d", "1"});
            graph.add(new String[]{"b", "c", "1"});
            graph.add(new String[]{"c", "d", "1"});
            graph.add(new String[]{"d", "b", "1"});
            graph.add(new String[]{"d", "e", "1"});
            graph.add(new String[]{"e", "f", "1"});
            graph.add(new String[]{"f", "e", "1"});
        }
        return graph;
    }

    public static String getShortestPathString(ArrayList<Vertex> shortestPath){
        String sp = "";
        if(shortestPath.size()>0) {
            Vertex temp = shortestPath.get(0);
            sp += "[" + temp.getDistance() + "]";
        }
        return  sp;
    }

}
