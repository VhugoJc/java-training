package org.example.collections;

import org.example.collections.ArrayList;
import org.example.collections.Iterator;
import org.example.collections.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ArrayListTest {
    @Test
    public void testAddItems() {
        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        // Arrange
        newArrayList.add(5);
        newArrayList.add(4);
        newArrayList.add(11);
        newArrayList.add(31);
        newArrayList.add(33); // increase the array length
        // Asserts
        Assertions.assertEquals(5, newArrayList.size());
        Assertions.assertEquals( 5, (int) newArrayList.getAt(0));
        Assertions.assertEquals( 4, (int) newArrayList.getAt(1));
        Assertions.assertEquals( 11, (int) newArrayList.getAt(2));
        Assertions.assertEquals( 31, (int) newArrayList.getAt(3));
        Assertions.assertEquals( 31, (int) newArrayList.getAt(3));

        Assertions.assertThrows(NotNullAllowedException.class, () -> newArrayList.add(null));
    }
    @Test
    public void testDeleteItems(){
        ArrayList<String> newArrayList = new ArrayList<String>();
        // Arrange
        newArrayList.add("APPLE");
        newArrayList.add("BANANA");
        newArrayList.add("WATERMELON");
        newArrayList.add("ORANGE");
        newArrayList.add("PEAR"); // increase the array length
        // Act
        newArrayList.remove("APPLE"); // increase the array length
        newArrayList.remove("BANANA");
        newArrayList.remove("WATERMELON");
        newArrayList.remove("ORANGE");
        newArrayList.remove("PEAR");
        // Asserts
        Assertions.assertEquals(0, newArrayList.size());
        Assertions.assertThrows(NotNullAllowedException.class, ()->newArrayList.remove(null));
    }
    @Test
    public void testDeleteDuplicatedItems(){
        ArrayList<String> newArrayList = new ArrayList<String>();
        // Arrange
        newArrayList.add("APPLE");
        newArrayList.add("BANANA");
        newArrayList.add("WATERMELON");
        newArrayList.add("APPLE");
        newArrayList.add("ORANGE");
        newArrayList.add("PEAR");
        newArrayList.add("APPLE");
        // Act
        newArrayList.remove("APPLE");
        // Asserts
        Assertions.assertEquals(4, newArrayList.size());
    }
    @Test
    public void testDeleteAllItems(){
        ArrayList<Double> newArrayList = new ArrayList<Double>();
        // Arrange
        newArrayList.add(5.00023);
        newArrayList.add(4.99999);
        newArrayList.add(11.7474);
        newArrayList.add(31.3221);
        // Act
        newArrayList.removeAll();
        // Asserts
        Assertions.assertEquals(0, newArrayList.size());
    }
    @Test
    public void testSetGetItems() {
        ArrayList<Float> newArrayList = new ArrayList<Float>();
        // Arrange
        newArrayList.add(5.0f);
        newArrayList.add(4.0f);
        newArrayList.add(11.0f);
        newArrayList.add(31.0f);
        // Act
        newArrayList.setAt(1, 91.0f);
        // Asserts
        Assertions.assertEquals(91.0f,(float) newArrayList.getAt(1));
        Assertions.assertThrows(NotNullAllowedException.class, () -> newArrayList.setAt(0,null));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> newArrayList.setAt(4,12.0f));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> newArrayList.getAt(5));
    }
    @Test
    public void testIterator(){
        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        // Arrange
        newArrayList.add(5);
        newArrayList.add(4);
        newArrayList.add(11);
        newArrayList.add(31);
        // Act
        Iterator<?> it = newArrayList.iterator();
        // Asserts
        Assertions.assertEquals(5,it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(4, it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(11, it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(31, it.next());
        Assertions.assertFalse(it.hasNext());


    }
}
