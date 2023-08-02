package org.example.collections.arrayList;


import org.example.collections.Iterator;
import org.example.collections.List;
import org.example.collections.NotNullAllowedException;

import java.lang.reflect.Array;

public class ArrayList <E> implements List<E> {
    private E[] array;
    private int size;
    private final Class<E> genericClass;
    private final int arrayLength = 4;

    public ArrayList(Class<E> genericClass) {
        this.genericClass = genericClass;
        resetArray();
    }

    private void resetArray(){
        @SuppressWarnings("unchecked")
        E [] auxArray = (E[]) Array.newInstance(genericClass,arrayLength);
        array = auxArray;
        size = 0;
    }
    private  class ArrayListIterator implements Iterator<E> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index<size;
        }
        @Override
        public E next()  {
            return array[index++];
        }
    }

    @Override
    public void add(E data) {
        if(data==null){
            throw new NotNullAllowedException();
        }

        if(size == array.length){ //increase the array
            @SuppressWarnings("unchecked")
            E [] newArray = (E[]) Array.newInstance(genericClass,array.length*2); // auxiliary array
            int i=0 ;
            while (i < array.length) { // fill the array with old values
                newArray[i] = array[i];
                i++;
            }
            array = newArray; // replace with the bigger array
        }
        array[size]=data;
        size++;
    }

    @Override
    public void removeAll() {
        resetArray();
    }

    @Override
    public void remove(E data) {
        if (data == null) {
            throw new NotNullAllowedException();
        }
        if(size==0) {
            return;
        }
        for(int i=0; i<size; i++) {
            if(array[i] == data) {
                for(int j=i; j<size-1; j ++) {
                    array[j] = array [j+1];
                }
                array[size-1] = null;
                size--;
            }
        }
        if(array.length/2 == size && size >= arrayLength) { // decrease the array length
            int arrayLength = array.length/2;
            @SuppressWarnings("unchecked")
            E [] newArray = (E[]) Array.newInstance(genericClass,arrayLength); // auxiliary array
            int i=0;
            while (i<arrayLength) { //fill the array with old values
                newArray[i]=array[i++];
            }
            array = newArray; // replace with the bigger array
        }
    }

    @Override
    public void setAt(int position, E newData)
    {
        if(newData==null){
            throw new NotNullAllowedException();
        }
        if(position >= size || position < 0){
            throw new IndexOutOfBoundsException();
        }
        array[position] = newData;
    }

    @Override
    public E getAt(int position)
    {
        if(position >= size || position < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        return array[position];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }
}
