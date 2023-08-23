package org.example.designpatterns.abstractfactory.factory;

import org.example.designpatterns.abstractfactory.IChair;
import org.example.designpatterns.abstractfactory.ICoffeeTable;
import org.example.designpatterns.abstractfactory.IFactory;
import org.example.designpatterns.abstractfactory.ISofa;
import org.example.designpatterns.abstractfactory.chair.ModernChair;
import org.example.designpatterns.abstractfactory.chair.VictorianChair;
import org.example.designpatterns.abstractfactory.coffeetable.ModernCoffeeTable;
import org.example.designpatterns.abstractfactory.coffeetable.VictorianCoffeeTable;
import org.example.designpatterns.abstractfactory.sofa.ModernSofa;
import org.example.designpatterns.abstractfactory.sofa.VictorianSofa;

public class ModernFactory implements IFactory {
    @Override
    public IChair createChair() {
        return new ModernChair();
    }
    @Override
    public ICoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
    @Override
    public ISofa createSofa() {
        return new ModernSofa();
    }
}
