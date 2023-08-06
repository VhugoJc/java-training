package org.example.collections;

import org.junit.jupiter.api.Test;

public class HashSetTest {
    @Test
    public void TestAddItem (){
        HashSet<String> list = new HashSet<>();
        list.add("s");
        list.add("Hello World");
        list.add("World");
        list.add("htrgertgrt");
        list.add("3e");
        list.remove("3e");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
