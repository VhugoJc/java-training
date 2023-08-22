package org.example.collections.hashmap;

import org.example.collections.Iterator;
import org.example.collections.Map;
import org.example.collections.NotNullAllowedException;
import org.example.collections.arraylist.ArrayList;

import java.util.Objects;


public class HashMap<K, V> implements Map<K,V> {
    private class Entry { // inner class
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            @SuppressWarnings("unchecked")
            Entry entry = (Entry) o;
            return Objects.equals(key, entry.key);
        }
    }
    private ArrayList<Entry>[] array;
    private int size;
    private static final int INITIAL_LENGTH = 4;
    private class HashMapIterator implements Iterator<V> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < size;
        }
        @Override
        public V next() {
            int counter = 0;
            V value = null;
            for (ArrayList<Entry> bucket : array) {
                if (bucket != null) {
                    if(index < (counter + bucket.size()) ){ //check if the index is within the bucket's range
                        value = bucket.getAt(index++ - counter).value;// get the value using the array list method and increase the index variable
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
        ArrayList <Entry> [] auxArray = new ArrayList[INITIAL_LENGTH];
        array = auxArray;
        size = 0;
    }
    private int getPosition (K key, int length) {
        return Math.abs(key.hashCode()) % length;
    }
    private void changeArrayLength(int newArrayLength){
        @SuppressWarnings("unchecked")
        ArrayList<Entry> [] newArray = new ArrayList[newArrayLength];
        for (ArrayList<Entry> bucket: array){
            if(bucket != null) {
                Iterator<Entry> it = bucket.iterator(); //
                while (it.hasNext()){
                    Entry currentElement = it.next();
                    int newPosition = getPosition(currentElement.key, newArrayLength);
                    if (newArray[newPosition] == null ) {
                        newArray[newPosition] = new ArrayList<>();
                    }
                    newArray[newPosition].add(currentElement);
                }
            }
        }
        array = newArray;
    }
    public HashMap() {
        resetArray();
    }
    @Override
    public void put(K key, V value) {
        // valid null exception
        if(value == null || key == null) {
            throw new NotNullAllowedException();
        }
        // check array size
        if(size == array.length ){ // each bucket with
            int newArrayLength = array.length << 1 ; // increase the array length
            changeArrayLength(newArrayLength);
        }
        // get hash code
        int position = getPosition(key, array.length);
        if (array [position] == null){ // assign element
            array [position] = new ArrayList<>();
        }
        // identify repeated element
        Entry newEntry = new Entry(key,value);
        if(array[position].contains(newEntry)){
            return;
        }
        array[position].add(newEntry);
        size++;
    }
    @Override
    public V get(K key) {
        if( key == null){
            throw new NotNullAllowedException();
        }
        V value = null;
        int position = getPosition(key, array.length);

        if(array[position] != null){ // check if the bucket is not empty
            Iterator<Entry> it = array[position].iterator();
            while(it.hasNext()){
                Entry entry = it.next();
                if ( entry.equals(new Entry(key, null) ) ){
                    value = entry.value;
                    break;
                }
            }
        }

        return value;
    }
    @Override
    public void remove(K key) {
        if( key == null){
            throw new NotNullAllowedException();
        }
        int position = getPosition(key, array.length);
        if(array[position] != null){ // check if the bucket is not empty
            Iterator<Entry> it = array[position].iterator();
            while(it.hasNext()){
                Entry entry = it.next();
                if ( entry.equals(new Entry(key, null) ) ){
                    array[position].remove(entry);
                    size--;
                    break;
                }
            }
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
    public boolean containsKey(K key) {
        int position = getPosition(key, array.length);
        ArrayList<Entry> bucket = array[position];
        Entry element = new Entry(key, null);
        return bucket.contains(element);
    }
    @Override
    public Iterator<V> iterator() {
        return new HashMapIterator();
    }
}
