package org.example.collections.hashset;

import org.example.collections.Iterator;
import org.example.collections.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class HashSetTest {
    @Test
    public void TestAddContainsItem (){
        HashSet<Integer> list = new HashSet<>();
        // Arrange
        list.add(12);
        list.add(1);
        list.add(4);
        list.add(56);
        list.add(7); //increase the array
        // Assert
        Assertions.assertTrue(list.contains(12));
        Assertions.assertTrue(list.contains(1));
        Assertions.assertTrue(list.contains(4));
        Assertions.assertTrue(list.contains(56));
        Assertions.assertTrue(list.contains(7));
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.add(null));
    }
    @Test
    public void TestAddDuplicatedItems (){
        HashSet<Integer> list = new HashSet<>();
        // Arrange
        list.add(12);
        list.add(1);
        list.add(4);
        list.add(56);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        // Assert
        Assertions.assertEquals(5,list.size());
    }

    @Test
    public void TestRemoveItem () {
        HashSet<String> list = new HashSet<>();
        // Arrange
        list.add("APPLE");
        list.add("BANANA");
        list.add("WATERMELON");
        list.add("ORANGE");
        list.add("PEAR");
        // Act
        list.remove("APPLE");
        list.remove("BANANA");
        list.remove("WATERMELON");
        list.remove("ORANGE");
        list.remove("PEAR");
        // Assert
        Assertions.assertEquals(0, list.size());
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.remove(null));
    }
    @Test
    public void TestRemoveAllItems () {
        HashSet <Double> list = new HashSet<>();
        // Arrange
        list.add(12.0);
        list.add(1.12);
        list.add(4.99);
        list.add(56.7);
        list.add(7.10);
        // Act
        list.removeAll();
        // Assert
        Assertions.assertEquals(0, list.size());
    }
    @Test
    public void TestIterator () {
        HashSet <Float> list = new HashSet<>();
        // Arrange
        list.add(12.0f);
        list.add(1.12f);
        list.add(4.99f);
        list.add(56.7f);
        list.add(74.10f);
        list.add(75.10f);
        list.add(76.10f);
        list.add(75.10f);
        list.add(35.40f);
        // Act
        Iterator<Float> it = list.iterator();
        // Assert
        Assertions.assertTrue(it.hasNext());
        it.next();
        Assertions.assertTrue(it.hasNext());
        it.next();
        Assertions.assertTrue(it.hasNext());
        it.next();
        Assertions.assertTrue(it.hasNext());
        it.next();
        Assertions.assertTrue(it.hasNext());
        it.next();
        Assertions.assertTrue(it.hasNext());
        it.next();
        Assertions.assertTrue(it.hasNext());
        it.next();
        Assertions.assertTrue(it.hasNext());
        it.next();
        Assertions.assertFalse(it.hasNext());
    }
}
