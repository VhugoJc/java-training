package org.example.linkedList;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class DoubleListTest {
    @Test
    public void testIterator() {
        DoubleList list = new DoubleList();
        list.add(8);
        list.add(10);
        list.add(1);
        list.add(7);
        Iterator<DoubleNode> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next().getData());
        }
    }
}
