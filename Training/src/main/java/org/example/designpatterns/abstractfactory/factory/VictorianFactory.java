package org.example.designpatterns.abstractfactory.factory;

import org.example.designpatterns.abstractfactory.IChair;
import org.example.designpatterns.abstractfactory.ICoffeeTable;
import org.example.designpatterns.abstractfactory.IFactory;
import org.example.designpatterns.abstractfactory.ISofa;
import org.example.designpatterns.abstractfactory.chair.VictorianChair;
import org.example.designpatterns.abstractfactory.coffeetable.VictorianCoffeeTable;
import org.example.designpatterns.abstractfactory.sofa.VictorianSofa;

public class VictorianFactory implements IFactory {
    @Override
    public IChair createChair() {
        return new VictorianChair();
    }
    @Override
    public ICoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
    @Override
    public ISofa createSofa() {
        return new VictorianSofa();
    }
}
