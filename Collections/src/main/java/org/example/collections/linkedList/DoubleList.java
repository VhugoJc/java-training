package org.example.collections.linkedList;

import org.example.collections.Iterator;
import org.example.collections.List;

public class DoubleList implements List { // nested class
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private static class Node { // static nested class
        Node previous;
        Node next;
        int data;

        public Node(int data){
            previous = null;
            next = null;
            this.data = data;
        }

    }

    private class DoubleListIterator implements Iterator { // inner class
        private Node node;

        public DoubleListIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public int next() {
            Node current = node;
            node = node.next;
            return current.data;
        }
    }

    @Override
    public void add(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void remove(int data) {
        Node currentNode = head;
        if(currentNode.data==data){ //first node
            if(size==1){
                head = null;
                tail = null;
                size = 0;
                return;
            }
            currentNode.next.previous = null;
            head = currentNode.next;
            size--;
            return;
        }
        while (currentNode!=null){
            if(currentNode.data==data){
                if(currentNode.next==null){ //last node

                    currentNode.previous.next = null;
                    tail = currentNode.previous;
                }else{
                     currentNode.previous.next = currentNode.next;
                    currentNode.next.previous = currentNode.previous;
                }
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }


    @Override
    public void setAt(int position, int newData) {
        Node currentNode = head;

        for(int i = 0; currentNode != null && i <position; i++){
            currentNode = currentNode.next;
        }
        if(currentNode==null){
            return;
        }
        currentNode.data = newData;
    }

    @Override
    public Integer getAt(int position) {
        Node currentNode = head;

        for(int i = 0; currentNode != null && i <position; i++){
            currentNode = currentNode.next;
        }

        assert currentNode != null; // exception here
        return currentNode.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new DoubleListIterator();
    }
}
