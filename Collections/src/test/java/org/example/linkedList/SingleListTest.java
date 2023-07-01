package org.example.linkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class SingleListTest {
    @Test
    @DisplayName("Add Node to Linked List")
    public void addDataTest () {
        SingleList list = new SingleList();
        list.add(6);
        int headData = list.getAt(0);
        Assertions.assertEquals(6, headData);
    }
    @Test
    @DisplayName("remove Node from Linked List")
    public void removeDataTest () {
        SingleList list = new SingleList();
        list.add(7);
        list.add(8);
        list.remove(8);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    @DisplayName("remove all Nodes from Linked List")
    public void removeAllDataTest () {
        SingleList list = new SingleList();
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.removeAll();
        Assertions.assertEquals(0, list.size());
    }
}
