package org.example.collections.hashmap;

import org.example.collections.Iterator;
import org.example.collections.NotNullAllowedException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTest {
    @Test
    public void testPutContainsItems () {
        HashMap<Integer, String> list = new HashMap<>();
        // A
        list.put(0,"hola");
        list.put(1,"mundo");
        list.put(2,"hello");
        list.put(3,"world");
        list.put(4,"!!");
        // Assert
        Assertions.assertTrue(list.containsKey(0));
        Assertions.assertTrue(list.containsKey(1));
        Assertions.assertTrue(list.containsKey(2));
        Assertions.assertTrue(list.containsKey(3));
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.put(null,"22")); // key = null
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.put(5,null)); // value = null
    }
    @Test
    public void testGetItem () {
        HashMap<Integer, String> list = new HashMap<>();
        // Arrange
        list.put(19,"APPLE");
        list.put(23,"BANANA");
        list.put(54,"WATERMELON");
        list.put(6,"APPLE");
        list.put(4777,"ORANGE");
        // Assert
        Assertions.assertEquals("APPLE",list.get(19));
        Assertions.assertEquals("BANANA",list.get(23));
        Assertions.assertEquals("WATERMELON",list.get(54));
        Assertions.assertEquals("ORANGE",list.get(4777));
        Assertions.assertNull(list.get(1));
    }
    @Test
    public void testRepeatedKey () {
        HashMap<Integer, String> list = new HashMap<>();
        // Arrange
        list.put(4,"APPLE");
        list.put(3,"BANANA");
        list.put(2,"WATERMELON");
        list.put(1,"APPLE");
        list.put(0,"ORANGE");
        list.put(0,"PEAR"); // repeated key
        // Assert
        Assertions.assertEquals("ORANGE",list.get(0));
    }
    @Test
    public void testDeleteItems(){
        HashMap<String, Float> list = new HashMap<>();
        //Arrange
        list.put("item1",12.5f);
        list.put("item2",11.5f);
        list.put("item3",10.0f);
        list.put("item4",19.2f);
        list.put("item5",42.3f);
        // Act
        list.remove("item1");
        list.remove("item2");
        list.remove("item3");
        list.remove("item4");
        list.remove("item5");
        // Assert
        Assertions.assertEquals(0,list.size());
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.remove(null));
    }
    @Test
    public void testDeleteAllItems () {
        HashMap<Integer, Double> list = new HashMap<>();
        // Arrange
        list.put(12,  12.00);
        list.put(111, 21.00);
        list.put(333, 34.00);
        list.put(142, 144.80);
        list.put(55,  92.01);
        // Action
        list.removeAll();
        //Assert
        Assertions.assertEquals(0,list.size());
    }

    @Test
    public void testIterator(){
        HashMap<Integer, String> list = new HashMap<>();
        // Arrange
        list.put(993,"APPLE");
        list.put(441,"BANANA");
        list.put(52,"WATERMELON");
        list.put(663,"ORANGE");
        list.put(74,"ORANGE");
        // Act
        Iterator <String> it = list.iterator();
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
        Assertions.assertFalse(it.hasNext());

    }
}
