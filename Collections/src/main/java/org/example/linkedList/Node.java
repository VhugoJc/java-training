package org.example.linkedList;

class Node {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node(int data) {
        this.data = data;
    }
}
class SingleNode extends Node {
    private SingleNode next;

    public SingleNode(int data) {
        super(data);
        this.next = null;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }
}

class DoubleNode extends Node {
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