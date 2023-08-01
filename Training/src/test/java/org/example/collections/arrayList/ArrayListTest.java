package org.example.collections.arrayList;

import org.example.collections.Iterator;
import org.junit.jupiter.api.Test;


public class ArrayListTest {
    @Test
    public void addTest(){
        ArrayList<Integer> newArrayList = new ArrayList<Integer>(Integer.class);
        newArrayList.add(5);
        newArrayList.add(4);
        newArrayList.add(11);
        newArrayList.add(31);
        newArrayList.add(2);
        newArrayList.add(8);
        newArrayList.remove(5);
        newArrayList.remove(8);
        Iterator<?> it = newArrayList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
