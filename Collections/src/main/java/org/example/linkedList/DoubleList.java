package org.example.linkedList;

import org.example.List;

public class DoubleList implements List {
    public DoubleNode head = null;
    public DoubleNode tail = null;
    @Override
    public void add(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if(head==null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.setPrevious(tail); // newNode.previous = tail
        tail.setNext(newNode);     // tail.next = newNode
        tail = newNode;
    }

    @Override
    public void removeAll() {
        head = null;
        tail = null;
    }

    @Override
    public void remove(int data) {
        DoubleNode currentNode = head;
        if(currentNode==null) {
            return;
        }
        if(currentNode.getData()==data){
            currentNode.getNext().setPrevious(null); // currentNode.next.previous = null
            head = currentNode.getNext();
            return;
        }
        while (currentNode!=null){
            if(currentNode.getData()==data){
                if(currentNode.getNext()==null){
                    currentNode.getPrevious().setNext(null);//currentNode.previous.next = null
                    tail = currentNode.getPrevious();
                }else{
                    currentNode.getPrevious().setNext(currentNode.getNext());// currentNode.previous.next = currentNode.next
                    currentNode.getNext().setPrevious(currentNode.getPrevious());// currentNode.next.previous = current.previous
                }

                return;
            }
            currentNode = currentNode.getNext();
        }
    }

    @Override
    public void remove() {
        DoubleNode currentNode = head;
        if(currentNode==null){
            return;
        }
        head = currentNode.getNext();
    }

    @Override
    public void setAt(int position, int newData) {
        DoubleNode currentNode = head;
        if(currentNode==null){
            return;
        }
        for(int i = 0; currentNode != null && i <position; i++){
            currentNode = currentNode.getNext();
        }
        if(currentNode==null){
            return;
        }
        currentNode.setData(newData);
    }

    @Override
    public Integer getAt(int position) {
        DoubleNode currentNode = head;
        if(currentNode==null){
            return null;
        }
        for(int i = 0; currentNode != null && i <position; i++){
            currentNode = currentNode.getNext();
        }
        if(currentNode==null){
            return null;
        }
        return currentNode.getData();
    }

    @Override
    public int size() {
        DoubleNode currentNode = head;
        int size = 0;
        if(currentNode==null) {
            return size;
        }
        while (currentNode!=null) {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    public void print() {
        DoubleNode currentNode = head;
        if(currentNode==null) {
            return;
        }
        System.out.print("[");
        while (currentNode!=null) {
            System.out.print(currentNode.getData()+" ");
            currentNode = currentNode.getNext();
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
//        DoubleLinkedList list = new DoubleLinkedList();

    }
}
