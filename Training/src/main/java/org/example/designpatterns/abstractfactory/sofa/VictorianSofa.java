package org.example.designpatterns.abstractfactory.sofa;

import org.example.designpatterns.abstractfactory.ISofa;

public class VictorianSofa implements ISofa {
    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public void sitOn() {
        System.out.println("you are sited on a Victorian Sofa");
    }
}
