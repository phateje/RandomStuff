package com.jovan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class WeightedGraph {

    public static void main(String[] args) {
        WeightedGraph x = new WeightedGraph();
        Graph graph = x.new Graph();


        Node vancouver = x.new Node("Vancouver");
        Node kelowna = x.new Node("Kelowna");
        graph.addEdge(vancouver, kelowna, 400);

        Node bigwhite = x.new Node("Big White");
        graph.addEdge(kelowna, bigwhite, 80);

        Node seattle = x.new Node("Seattle");
        graph.addEdge(bigwhite, seattle, 700);
        graph.addEdge(vancouver, seattle, 600);

        Node losangeles = x.new Node("Los Angeles");
        graph.addEdge(seattle, losangeles, 1200);

        graph.printGraph();
    }
    public class Graph {
        HashMap<Node, HashSet<Edge>> adjacencyLists = new HashMap<>();

        public void addEdge(Node n1, Node n2, int distance) {
            Node[] nodes = {n1, n2};
            for (Node n : nodes) {
                HashSet<Edge> adjacentEdges = adjacencyLists.get(n);
                if (adjacentEdges == null) {
                    adjacentEdges = new HashSet<>();
                    adjacencyLists.put(n, adjacentEdges);
                }
                adjacentEdges.add(new Edge(n1, n2, distance));
            }
        }

        public void printGraph() {
            for (Node n : adjacencyLists.keySet()) {
                HashSet<Edge> edges = adjacencyLists.get(n);
                System.out.println("adjacent nodes for: " + n.city);
                for (Edge e : edges) {
                    String nodeToDisplay = n.equals(e.getNodes().get(0)) ? e.getNodes().get(1).city : e.getNodes().get(0).city;

                    System.out.println(" ---> " + nodeToDisplay + ", distance " + e.distance);
                }
                System.out.println("==============================");
            }
        }
    }

    public class Edge {
        private ArrayList<Node> nodes;
        private int distance;

        public Edge(Node n1, Node n2, int distance) {
            nodes = new ArrayList<>();
            nodes.add(n1);
            nodes.add(n2);
            this.distance = distance;
        }

        public ArrayList<Node> getNodes() {
            return nodes;
        }
    }

    public class Node {
        public String city;

        public Node(String cityName) {
            this.city = cityName;
        }
    }
}
