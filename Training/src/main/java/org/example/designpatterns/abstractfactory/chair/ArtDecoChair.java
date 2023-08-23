package org.example.designpatterns.abstractfactory.chair;

import org.example.designpatterns.abstractfactory.IChair;

public class ArtDecoChair implements IChair {
    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public void sitOn() {
        System.out.println("you are sited on a Art Deco Chair");
    }
}
