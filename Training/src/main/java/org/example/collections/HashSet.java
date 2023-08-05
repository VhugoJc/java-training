package org.example.collections;
public class HashSet <E> implements Set<E> {
    private E [] array;
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
            int indexAux = 0;
            // E[] arrayAux ?
            E value = null;
            for (E e : array) {
                if (e != null) {
                    if (indexAux++ == index) {
                        value = e;
                        break;
                    }
                }
            }
            index++;
            return value;
        }
    }

    public HashSet() {
        @SuppressWarnings("unchecked")
        E[] auxArray = (E[]) new Object[INITIAL_LENGTH];
        array = auxArray;
        size = 0;
    }

    @Override
    public void add(E element) {
        // valid null exception
        if(element == null) {
            throw new NotNullAllowedException();
        }
        // check array size
        if(size == array.length ){
            // increase the array length
            int newArrayLength = array.length << 1 ; // NEW_ARRAY_LENGTH ?
            @SuppressWarnings("unchecked")
            E[] auxArray = (E[]) new Object[newArrayLength];
            for (E e : array) {
                int newPosition = Math.abs(e.hashCode()) % newArrayLength;
                if (auxArray[newPosition] == null) { // if the position is a null element
                    auxArray[newPosition] = e;
                    continue;
                }
                // find the next null position
                while (auxArray[newPosition] != null) {
                    newPosition = (newPosition + 1) % newArrayLength;
                }
                auxArray[newPosition] = e;
            }
            array = auxArray;
        }
        // get hash code
        int position = Math.abs(element.hashCode()) % array.length;

        // assign element
        if (array [position] == null){
            array [position] = element;
            size++;
            return;
        }
        // identify repeated element
        if(array[position] == element){
            return;
        }
        // use the next empty position
        while (array[position] != null) {
            position = (position + 1) % array.length;
        }
        array[position] = element;
        size++;
    }

    @Override
    public void remove(Object element) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new hashSetIterator();
    }
}
