package org.example.collections.linkedList;

import org.example.collections.Iterator;
import org.example.collections.List;
import org.example.collections.NotNullAllowedException;

public class DoubleList<E> implements List<E> { // nested class
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node <F>{ // static nested class
        Node<F> previous;
        Node<F> next;
        F data;

        public Node(F data){
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
            try {
            Node<E> current = node;
            node = node.next;
            return current.data;
            }catch (NullPointerException npe){
                System.out.println("next method: "+npe);
            }
            return null;
        }
    }

    @Override
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
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
    public void remove(E data) throws NotNullAllowedException {
        if(data==null){
            throw new NotNullAllowedException();
        }
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
        E value = null;
        try{
            Node<E> currentNode = head;

            for(int i = 0; currentNode != null && i <position; i++){
                currentNode = currentNode.next;
            }
                value = currentNode.data;

        }catch (NullPointerException npe){
            System.out.println("getAt method: "+npe);
        }
        return value;
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
