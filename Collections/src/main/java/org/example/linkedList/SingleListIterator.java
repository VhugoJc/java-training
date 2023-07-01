package org.example.linkedList;

import java.util.Iterator;

public class SingleListIterator implements Iterator <SingleNode>{
    private SingleNode node;
    @Override
    public boolean hasNext() {
        return node!=null;
    }

    @Override
    public SingleNode next() {
        SingleNode current = node;
        node = node.getNext();
        return current;
    }

    public SingleListIterator(SingleNode head) {
        this.node = head;
    }
}
