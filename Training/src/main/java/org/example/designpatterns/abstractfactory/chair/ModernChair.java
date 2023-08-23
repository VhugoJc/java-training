package org.example.designpatterns.abstractfactory.chair;

import org.example.designpatterns.abstractfactory.IChair;

public class ModernChair implements IChair {
    @Override
    public boolean hasLegs() {
        return false;
    }

    @Override
    public void sitOn() {
        System.out.println("you are sited on a modern");
    }
}
