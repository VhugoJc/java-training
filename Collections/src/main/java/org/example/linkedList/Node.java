package org.example.linkedList;

class NodeData {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeData(int data) {
        this.data = data;
    }
}

class Node extends NodeData {
    private Node next;

    public Node(int data) {
        super(data);
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class DoubleNode extends NodeData {
    private DoubleNode previous;
    private DoubleNode next;
    public DoubleNode (int data){
        super(data);
        this.previous = null;
        this.next = null;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}