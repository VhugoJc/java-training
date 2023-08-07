package org.example.collections.hashSet;

import org.example.collections.Iterator;
import org.example.collections.NotNullAllowedException;
import org.example.collections.Set;
import org.example.collections.arrayList.ArrayList;


public class HashSet <E> implements Set<E> {
    private ArrayList<E>[] array;
    private int size;
    private static final int INITIAL_LENGTH = 4;
    private class hashSetIterator implements Iterator<E> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < size;
        }
        @Override
        public E next() {
            int counter = 0;
            // E[] arrayAux ?
            E value = null;
            for (ArrayList<E> arrayList : array) {
                if (arrayList != null) {
                    for(int i = 0; i < arrayList.size() ; i++){
                        if(index == counter++){
                            value = arrayList.getAt(i);
                            break;
                        }
                    }
                }
            }
            index++;
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
        for (ArrayList<E> a: array){
            if(a != null) {
                Iterator<E> it = a.iterator();
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
        ArrayList<E> arrayList = array[position];
        if(arrayList!=null){
            arrayList.remove(element); // remove the element
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
        boolean exists = false;
        int position = getPosition(element, array.length);
        ArrayList<E> arrayList = array[position];
        if (arrayList.contains(element)){
            exists = true;
        }
        return exists;
    }

    @Override
    public Iterator<E> iterator() {
        return new hashSetIterator();
    }
}
