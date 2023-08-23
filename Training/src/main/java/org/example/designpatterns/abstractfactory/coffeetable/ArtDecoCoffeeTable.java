package org.example.designpatterns.abstractfactory.coffeetable;

import org.example.designpatterns.abstractfactory.ICoffeeTable;

public class ArtDecoCoffeeTable implements ICoffeeTable {
    @Override
    public void sitOn() {
        System.out.println("Yo are using a Art Deco Coffee Table ");
    }

    @Override
    public boolean hasDrawers() {
        return false;
    }
}
