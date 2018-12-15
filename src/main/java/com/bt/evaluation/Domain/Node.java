package com.bt.evaluation.Domain;

public class Node {

    private String name;
    private long nodeTime;
    private long monitoringTime;
    private NodeState nodeState;
    private String lastEventDetail;

    public Node(String monitoringTime, String nodeTime, String name, NodeState nodeState, String lastEventDetail) {
        this.name = name;
        this.nodeTime = Long.parseLong(nodeTime);
        this.monitoringTime = Long.parseLong(monitoringTime);
        this.nodeState = nodeState;
        this.lastEventDetail = lastEventDetail;
    }

    public Node(String monitoringTime, String nodeTime, String name, NodeState nodeState) {
        this.name = name;
        this.nodeTime = Long.parseLong(nodeTime);
        this.monitoringTime = Long.parseLong(monitoringTime);
        this.nodeState = nodeState;
    }

    public Node(String monitoringTime, String nodeTime, String name) {
        this.name = name;
        this.nodeTime = Long.parseLong(nodeTime);
        this.monitoringTime = Long.parseLong(monitoringTime);
        this.nodeState = NodeState.UNKNOWN;
    }

    public Node(String name, NodeState nodeState) {
        this.name = name;
        this.nodeState = NodeState.UNKNOWN;
    }

    public Node() {
        this.nodeState = NodeState.UNKNOWN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNodeTime() {
        return nodeTime;
    }

    public void setNodeTime(long nodeTime) {
        this.nodeTime = nodeTime;
    }

    public long getMonitoringTime() {
        return monitoringTime;
    }

    public void setMonitoringTime(long monitoringTime) {
        this.monitoringTime = monitoringTime;
    }

    public NodeState getNodeState() {
        return nodeState;
    }

    public void setNodeState(NodeState nodeState) {
        this.nodeState = nodeState;
    }

    public String getLastEventDetail() {
        return lastEventDetail;
    }

    public void setLastEventDetail(String lastEventDetail) {
        this.lastEventDetail = lastEventDetail;
    }

    public String printNodeStatus() {
        return this.name + " "
                + this.nodeState.toString() + " "
                + this.monitoringTime + " "
                + this.lastEventDetail;
    }
}
