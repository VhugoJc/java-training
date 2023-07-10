package org.example.collections.linkedList;

import org.example.collections.Iterator;
import org.example.collections.List;

public class DoubleList<E> implements List<E> { // nested class
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node <E>{ // static nested class
        Node<E> previous;
        Node<E> next;
        E data;

        public Node(E data){
            previous = null;
            next = null;
            this.data = data;
        }

    }

    private class DoubleListIterator implements Iterator<E> { // inner class
        private Node<E> node;

        public DoubleListIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public E next() {
            Node<E> current = node;
            node = node.next;
            return current.data;
        }
    }

    @Override
    public void add(E data) {
        Node<E> newNode = new Node<E>(data);
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
    public void remove(E data) {
        Node<E> currentNode = head;
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
    public void setAt(int position, E newData) {
        Node<E> currentNode = head;

        for(int i = 0; currentNode != null && i <position; i++){
            currentNode = currentNode.next;
        }
        if(currentNode==null){
            return;
        }
        currentNode.data = newData;
    }

    @Override
    public E getAt(int position) {
        Node<E> currentNode = head;

        for(int i = 0; currentNode != null && i <position; i++){
            currentNode = currentNode.next;
        }

        assert currentNode != null; // exception here
        return (E) currentNode.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new DoubleListIterator();
    }
}
