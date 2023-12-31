package org.example.collections.hashset;

import org.example.collections.Iterator;
import org.example.collections.NotNullAllowedException;
import org.example.collections.Set;
import org.example.collections.arraylist.ArrayList;


public class HashSet <E> implements Set<E> {
    private ArrayList<E>[] array;
    private int size;
    private static final int INITIAL_LENGTH = 4;
    private class HashSetIterator implements Iterator<E> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < size;
        }
        @Override
        public E next() {
            int counter = 0;
            E value = null;
            for (ArrayList<E> bucket : array) {
                if (bucket != null) {
                    if(index < (counter + bucket.size()) ){ //check if the index is within the bucket's range
                        value = bucket.getAt(index++ - counter);// get the value using the array list method and increase the index variable
                        break;
                    }
                    counter += bucket.size();
                }
            }
            return value;
        }
    }

    private void resetArray () {
        @SuppressWarnings("unchecked")
        ArrayList <E> [] auxArray = new ArrayList[INITIAL_LENGTH];
        array = auxArray;
        size = 0;
    }
    private int getPosition (E element, int length) {
        return Math.abs(element.hashCode()) % length;
    }
    private void changeArrayLength(int newArrayLength){
        @SuppressWarnings("unchecked")
        ArrayList<E> [] newArray = new ArrayList[newArrayLength];
        for (ArrayList<E> bucket: array){
            if(bucket != null) {
                Iterator<E> it = bucket.iterator();
                while (it.hasNext()){
                    E currentElement = it.next();
                    int newPosition = getPosition(currentElement, newArrayLength);
                    if (newArray[newPosition] == null ) {
                        newArray[newPosition] = new ArrayList<>();
                    }
                    newArray[newPosition].add(currentElement);
                }
            }
        }
        array = newArray;
    }
    public HashSet() {
        resetArray();
    }
    @Override
    public void add(E element) {
        // valid null exception
        if(element == null) {
            throw new NotNullAllowedException();
        }
        // check array size
        if(size == array.length ){ // each bucket with
            int newArrayLength = array.length << 1 ; // increase the array length
            changeArrayLength(newArrayLength);
        }
        // get hash code
        int position = getPosition(element, array.length);

        // assign element
        if (array [position] == null){
            array [position] = new ArrayList<>();
        }
        // identify repeated element
        if(array[position].contains(element)){
            return;
        }
        array[position].add(element);
        size++;
    }
    @Override
    public void remove(E element) {
        if(element == null){
            throw new NotNullAllowedException();
        }
        // find the position
        int position = getPosition(element, array.length);
        // get the bucket
        ArrayList<E> bucket = array[position];
        if(bucket!=null){
            bucket.remove(element); // remove the element
            size--;
        }
        if(size == array.length / 2 && size >= INITIAL_LENGTH){
            int newArrayLength = array.length >> 1 ; // decrease the array length
            changeArrayLength(newArrayLength);
        }
    }
    @Override
    public void removeAll() {
        resetArray();
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean contains(E element) {
        int position = getPosition(element, array.length);
        ArrayList<E> bucket = array[position];
        return bucket.contains(element);
    }
    @Override
    public Iterator<E> iterator() {
        return new HashSetIterator();
    }
}
