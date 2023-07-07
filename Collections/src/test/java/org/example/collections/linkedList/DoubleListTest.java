package org.example.collections.linkedList;

import org.example.collections.Iterator;
import org.example.collections.linkedList.DoubleList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleListTest {
    @Test
    public void testList() {
        //inizializacion
        DoubleList list = new DoubleList();
        list.add(8);
        list.add(10);
        list.add(1);
        list.add(7);

        Assertions.assertEquals(4,list.size());

        Assertions.assertEquals(8,(int)list.getAt(0));
        Assertions.assertEquals(10,(int)list.getAt(1));
        Assertions.assertEquals(1,(int)list.getAt(2));
        Assertions.assertEquals(7,(int)list.getAt(3));
    }

    @Test
    public void testIterator2() {
        //inizializacion
        DoubleList list = new DoubleList();
        list.add(8);
        list.add(10);
        list.add(1);
        list.add(7);
        Iterator it = list.iterator();

        //validacion
        Assertions.assertEquals(4,list.size());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(8,it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(10,it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(1,it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(7,it.next());
        Assertions.assertFalse(it.hasNext());
    }
}
