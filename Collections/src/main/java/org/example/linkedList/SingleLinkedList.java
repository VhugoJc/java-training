package org.example.linkedList;

public class SingleLinkedList implements LinkedList{
    public Node head = null;
    public Node tail = null;

    @Override
    public void add (int data)  {
        Node newNode  = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.setNext(newNode); //tail.next = newNode
        tail = newNode;
    }
    @Override
    public void removeAll () {
        head = null;
        tail = null;
    }
    @Override
    public void remove(int data) {
        Node currentNode = head;
        if(currentNode==null) { //if the linked list is empty
            return;
        }
        if(currentNode.getData()==data) { // if the data is the head node
            head = currentNode.getNext();
            return;
        }
        while (currentNode!=null) {
            if(currentNode.getNext().getData()==data){
                Node nextNode = currentNode.getNext().getNext();
                if(nextNode==null){
                    tail = currentNode;
                }
                currentNode.setNext(nextNode);
                return;
            }
            currentNode = currentNode.getNext();
        }
    }
    @Override
    public void remove() {
        Node currentNode = head;
        if(currentNode==null){
            return;
        }
        head = currentNode.getNext();
    }
    @Override
    public void setAt (int position, int newData) {
        Node currentNode = head;
        if(currentNode == null) {
            return;
        }
        // get the node by position
        for( int i =0; currentNode!=null && i<position; i++){
            currentNode = currentNode.getNext();
        }
        if(currentNode==null){ //avoid position error
            return;
        }
        currentNode.setData(newData); //set node data
    }
    @Override
    public Integer getAt(int position) {
        Node currentNode = head;
        if(currentNode == null) {
            return null;
        }
        // get the node by position
        for( int i =0; currentNode!=null && i<position; i++){
            currentNode = currentNode.getNext();
        }
        if(currentNode==null){ //avoid position error
            return null;
        }
        return currentNode.getData();
    }
    @Override
    public int size () {
        Node currentNode = head;
        int size = 0;
        if(currentNode == null) {
            return size;
        }
        while (currentNode!=null) {
            size++;
            currentNode=currentNode.getNext();
        }
        return size;
    }

    public void print () {
        Node currentNode = head;
        if(currentNode==null){
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        while(currentNode!=null){
            System.out.print(currentNode.getData()+" ");
            currentNode = currentNode.getNext();
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
    }
}
