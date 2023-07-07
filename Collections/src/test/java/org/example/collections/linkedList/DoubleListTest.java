package org.example.collections.linkedList;

import org.example.collections.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleListTest {
    // AAA Pattern Arrange, Act, Asser
    @Test
    public void testAddNodes() {
        //Arrange
        DoubleList list = new DoubleList();
        list.add(8);
        list.add(10);
        list.add(1);
        list.add(7);
        // Act
        // Assert
        Assertions.assertEquals(4,list.size());
        Assertions.assertEquals(8,(int)list.getAt(0));
        Assertions.assertEquals(10,(int)list.getAt(1));
        Assertions.assertEquals(1,(int)list.getAt(2));
        Assertions.assertEquals(7,(int)list.getAt(3));
    }

    @Test
    public void testDeleteNode() {
        // arrange
        DoubleList list = new DoubleList();
        list.add(8);
        list.add(10);
        list.add(1);
        list.add(7);
        // act
        list.remove(10);
        list.remove(8);
        list.remove(7);
        list.remove(1);
        // assert
        Assertions.assertEquals(0,list.size());
    }

    @Test
    public void testDeleteAllNodes(){
        // arrange
        DoubleList list = new DoubleList();
        list.add(8);
        list.add(10);
        list.add(1);
        list.add(7);
        // act
        list.removeAll();
        // assert
        Assertions.assertEquals(0,list.size());
    }
    @Test
    public void testSetGetNode() {
        // arrange
        DoubleList list = new DoubleList();
        list.add(8);
        list.add(10);
        list.add(1);
        list.add(7);
        // act
        list.setAt(1,11);
        // assert
        Assertions.assertEquals(11,(int)list.getAt(1));
    }
    @Test
    public void testIterator() {
        // arrange
        DoubleList list = new DoubleList();
        list.add(8);
        list.add(10);
        list.add(1);
        list.add(7);
        // act
        Iterator it = list.iterator();
        // assert
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
