package org.example.collections.linkedList;

import org.example.collections.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleListTest {
    // AAA Pattern Arrange, Act, Asser
    @Test
    public void testAddNodes() {
        //Arrange
        DoubleList<Integer> list = new DoubleList<> ();
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
        DoubleList<String> list = new DoubleList<>();
        list.remove(null);

        list.add("APPLE");
        list.add("BANANA");
        list.add("WATERMELON");
        list.add("ORANGE");
        // act

        list.remove("BANANA");
        list.remove("APPLE");
        list.remove("ORANGE");
        list.remove("WATERMELON");
        // assert
        Assertions.assertEquals(0,list.size());
    }

    @Test
    public void testDeleteAllNodes(){
        // arrange
        DoubleList<Double> list = new DoubleList<>();
        list.add(8.01999);
        list.add(10.1299);
        list.add(1.32999);
        list.add(7.81999);
        // act
        list.removeAll();
        // assert
        Assertions.assertEquals(0,list.size());
    }
    @Test
    public void testSetGetNode() {
        // arrange
        DoubleList<Float> list = new DoubleList<>();
        list.add(8.5f);
        list.add(10.0f);
        list.add(1.03f);
        list.add(7.51f);
        // act
        list.setAt(1,11f);
        // assert
        Assertions.assertNull(list.getAt(11));  //Null Pointer Exception
        Assertions.assertEquals(11f,(float)list.getAt(1));

    }
    @Test
    public void testIterator() {
        // arrange
        DoubleList<Integer> list = new DoubleList<>();
        list.add(8);
        list.add(10);
        list.add(1);
        list.add(7);
        // act
        Iterator<?> it = list.iterator();
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

        Assertions.assertNull(it.next()); // NullPointerException
        Assertions.assertFalse(it.hasNext());

    }
}
