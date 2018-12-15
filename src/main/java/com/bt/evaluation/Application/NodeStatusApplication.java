package com.bt.evaluation.Application;

import com.bt.evaluation.Domain.Node;
import com.bt.evaluation.Domain.NodeState;
import com.bt.evaluation.Domain.NotificationType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NodeStatusApplication {
    public static void main(String[] args) throws IOException {
        NodeStatusApplication nodeStatusApplication = new NodeStatusApplication();
        File notificationRecordFile;
        List<Node> nodeList = new ArrayList<Node>();
        try {
            if (0 < args.length) {
                String filename = args[0];
                notificationRecordFile = new File(filename);
                Scanner sc = new Scanner(notificationRecordFile); //Better business reason to use Scanner rather than a BufferedReader
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] lineParts = line.split("[ \\t]");
                    if (lineParts[3].equals(NotificationType.HELLO.toString())) {
                        Node sourceNode = new Node(lineParts[0], lineParts[1], lineParts[2], NodeState.ALIVE, lineParts[2] + " " + lineParts[3]);
                        nodeStatusApplication.addOrUpdateNodeList(nodeList, sourceNode, NodeState.ALIVE);
                    }
                    if (lineParts[3].equals(NotificationType.FOUND.toString())) {
                        Node sourceNode = new Node(lineParts[0], lineParts[1], lineParts[2], NodeState.ALIVE, lineParts[2] + " " + lineParts[3] + " " + lineParts[4]);
                        Node destinationNode = new Node(lineParts[0], lineParts[1], lineParts[4], NodeState.ALIVE, lineParts[2] + " " + lineParts[3] + " " + lineParts[4]);
                        nodeStatusApplication.addOrUpdateNodeList(nodeList, sourceNode, NodeState.ALIVE);
                        nodeStatusApplication.addOrUpdateNodeList(nodeList, destinationNode, NodeState.ALIVE);
                    }
                    if (lineParts[3].equals(NotificationType.LOST.toString())) {
                        Node sourceNode = new Node(lineParts[0], lineParts[1], lineParts[2], NodeState.ALIVE, lineParts[2] + " " + lineParts[3] + " " + lineParts[4]);
                        Node destinationNode = new Node(lineParts[0], lineParts[1], lineParts[4], NodeState.DEAD, lineParts[2] + " " + lineParts[3] + " " + lineParts[4]);
                        nodeStatusApplication.addOrUpdateNodeList(nodeList, sourceNode, NodeState.ALIVE);
                        nodeStatusApplication.addOrUpdateNodeList(nodeList, destinationNode, NodeState.DEAD);
                    }
                }
            }
            nodeList.forEach(n -> System.out.println(n.printNodeStatus()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addOrUpdateNodeList(List<Node> nodeList, Node node, NodeState nodeState) {
        Node recentNodeInList = nodeList.stream().max(Comparator.comparingLong(Node::getNodeTime)).orElse(new Node());
        if (recentNodeInList.getNodeTime() <= node.getNodeTime()) {
            if (nodeList.stream().noneMatch(n -> n.getName().equals(node.getName()))) {
                nodeList.add(node);
            } else {
                nodeList.forEach(n -> {
                    if (n.getName().equals(node.getName())) {
                        n.setNodeTime(node.getNodeTime());
                        n.setMonitoringTime(node.getMonitoringTime());
                        n.setNodeState(nodeState);
                        n.setLastEventDetail(node.getLastEventDetail());
                    }
                });
            }
        }
    }

}
