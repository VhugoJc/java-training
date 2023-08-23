package org.example.designpatterns.abstractfactory.coffeetable;

import org.example.designpatterns.abstractfactory.ICoffeeTable;

public class VictorianCoffeeTable implements ICoffeeTable {
    @Override
    public void sitOn() {
        System.out.println("Yo are using a Victorian Coffee Table ");
    }
    @Override
    public boolean hasDrawers() {
        return true;
    }
}
