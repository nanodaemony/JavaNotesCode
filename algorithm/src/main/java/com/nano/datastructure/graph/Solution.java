package com.nano.datastructure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * 旅游问题
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] data = line.split(" ");
        int cityCounter = Integer.parseInt(data[0]);
        int pathNumber = Integer.parseInt(data[1]);
        int meetCity = Integer.parseInt(data[2]);
        String[] paths = new String[pathNumber];
        for (int i = 0; i < pathNumber; i++) {
            paths[i] = scanner.nextLine();
        }
        Graph graph = generateGraph(paths);

        // 得到meet城市
        Node meetNode = graph.nodes.get(meetCity);

        int maxDistance = Integer.MIN_VALUE;

        HashMap<Node, Integer> backDistanceMap = dijkstra(meetNode);

        for (Node curNode : graph.nodes.values()) {
            // Key 是编号  value是Node
            if(curNode != (meetNode)) {
                // 以CurNode为头到其他节点的距离
                HashMap<Node, Integer> goDistanceMap = dijkstra(curNode);
                int goDistance = goDistanceMap.get(meetNode);
                int backDistance = backDistanceMap.get(curNode);
                maxDistance = Math.max(maxDistance, goDistance + backDistance);
            }
        }
        System.out.println(maxDistance);

    }


    private static HashMap<Node, Integer> dijkstra(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

//4 8 2
//1 2 4
//1 3 2
//1 4 7
//2 1 1
//2 3 5
//3 1 2
//3 4 4
//4 2 3

    /**
     * Generate the graph by given paths
     */
    private static Graph generateGraph(String[] paths){
        Graph graph = new Graph();
        for (String path : paths) {
            String[] data = path.split(" ");
            int from  = Integer.parseInt(data[0]);
            int to = Integer.parseInt(data[1]);
            int weight = Integer.parseInt(data[2]);
            // Put node into the graph
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

}
