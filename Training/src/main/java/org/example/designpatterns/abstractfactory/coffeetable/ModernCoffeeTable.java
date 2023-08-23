package org.example.designpatterns.abstractfactory.coffeetable;

import org.example.designpatterns.abstractfactory.ICoffeeTable;

public class ModernCoffeeTable implements ICoffeeTable {
    @Override
    public void sitOn() {
        System.out.println("Yo are using a Modern Coffee Table ");
    }
    @Override
    public boolean hasDrawers() {
        return false;
    }
}
