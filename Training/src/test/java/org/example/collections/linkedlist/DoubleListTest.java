package org.example.collections.linkedlist;

import org.example.collections.Iterator;
import org.example.collections.NotNullAllowedException;
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
        Assertions.assertTrue(list.contains(8));
        Assertions.assertTrue(list.contains(10));
        Assertions.assertTrue(list.contains(1));
        Assertions.assertTrue(list.contains(7));
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.add(null));
    }

    @Test
    public void testDeleteNode()  {
        // arrange
        DoubleList<String> list = new DoubleList<>();
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
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.remove(null)); // null pointer exception
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
    public void testSetGetNode()  {
        // arrange
        DoubleList<Float> list = new DoubleList<>();
        list.add(8.5f);
        list.add(10.0f);
        list.add(1.03f);
        list.add(7.51f);
        // act
        list.setAt(1,11f);
        // assert
        Assertions.assertEquals(11f,(float)list.getAt(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getAt(11)); //Null Pointer Exception
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.setAt(5,12f));
        Assertions.assertThrows(NotNullAllowedException.class,   () -> list.setAt(0,null));
    }
    @Test
    public void testIterator()  {
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

        Assertions.assertThrows(NotNullAllowedException.class, () -> it.next()); // NullPointerException
        Assertions.assertFalse(it.hasNext());

    }
}
