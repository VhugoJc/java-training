package org.example;
import org.example.collections.List;
import org.example.collections.NotNullAllowedException;
import org.example.collections.linkedList.DoubleList;

public class Main {

    public static void main(String[] args) { // throws NotNullAllowedException
        List<String> newList = new DoubleList<>();
        try {
            newList.remove(null);
        } catch (NotNullAllowedException e) {
//          throw new RuntimeException(e);
            System.out.println("####");
        }
    }
}