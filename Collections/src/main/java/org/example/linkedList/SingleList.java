package org.example.linkedList;

import org.example.List;

public class SingleList implements List {
    public SingleNode head = null;
    public SingleNode tail = null;

    @Override
    public void add (int data)  {
        SingleNode newSingleNode = new SingleNode(data);
        if(head == null) {
            head = newSingleNode;
            tail = newSingleNode;
            return;
        }
        tail.setNext(newSingleNode); //tail.next = newNode
        tail = newSingleNode;
    }
    @Override
    public void removeAll () {
        head = null;
        tail = null;
    }
    @Override
    public void remove(int data) {
        SingleNode currentSingleNode = head;
        if(currentSingleNode ==null) { //if the linked list is empty
            return;
        }
        if(currentSingleNode.getData()==data) { // if the data is the head node
            head = currentSingleNode.getNext();
            return;
        }
        while (currentSingleNode !=null) {
            if(currentSingleNode.getNext().getData()==data){
                SingleNode nextSingleNode = currentSingleNode.getNext().getNext();
                if(nextSingleNode ==null){
                    tail = currentSingleNode;
                }
                currentSingleNode.setNext(nextSingleNode);
                return;
            }
            currentSingleNode = currentSingleNode.getNext();
        }
    }
    @Override
    public void remove() {
        SingleNode currentSingleNode = head;
        if(currentSingleNode ==null){
            return;
        }
        head = currentSingleNode.getNext();
    }
    @Override
    public void setAt (int position, int newData) {
        SingleNode currentSingleNode = head;
        if(currentSingleNode == null) {
            return;
        }
        // get the node by position
        for(int i = 0; currentSingleNode !=null && i<position; i++){
            currentSingleNode = currentSingleNode.getNext();
        }
        if(currentSingleNode ==null){ //avoid position error
            return;
        }
        currentSingleNode.setData(newData); //set node data
    }
    @Override
    public Integer getAt(int position) {
        SingleNode currentSingleNode = head;
        if(currentSingleNode == null) {
            return null;
        }
        // get the node by position
        for(int i = 0; currentSingleNode !=null && i<position; i++){
            currentSingleNode = currentSingleNode.getNext();
        }
        if(currentSingleNode ==null){ //avoid position error
            return null;
        }
        return currentSingleNode.getData();
    }
    @Override
    public int size () {
        SingleNode currentSingleNode = head;
        int size = 0;
        if(currentSingleNode == null) {
            return size;
        }
        while (currentSingleNode !=null) {
            size++;
            currentSingleNode = currentSingleNode.getNext();
        }
        return size;
    }

    public void print () {
        SingleNode currentSingleNode = head;
        if(currentSingleNode ==null){
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        while(currentSingleNode !=null){
            System.out.print(currentSingleNode.getData()+" ");
            currentSingleNode = currentSingleNode.getNext();
        }
        System.out.println("]");
    }


    public static void main(String[] args) {
        SingleList list = new SingleList();
    }
}
