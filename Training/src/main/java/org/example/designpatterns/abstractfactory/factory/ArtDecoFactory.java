package org.example.designpatterns.abstractfactory.factory;

import org.example.designpatterns.abstractfactory.IChair;
import org.example.designpatterns.abstractfactory.ICoffeeTable;
import org.example.designpatterns.abstractfactory.IFactory;
import org.example.designpatterns.abstractfactory.ISofa;
import org.example.designpatterns.abstractfactory.chair.ArtDecoChair;
import org.example.designpatterns.abstractfactory.chair.ModernChair;
import org.example.designpatterns.abstractfactory.coffeetable.ArtDecoCoffeeTable;
import org.example.designpatterns.abstractfactory.coffeetable.ModernCoffeeTable;
import org.example.designpatterns.abstractfactory.sofa.ArtDecoSofa;
import org.example.designpatterns.abstractfactory.sofa.ModernSofa;

public class ArtDecoFactory implements IFactory {
    @Override
    public IChair createChair() {
        return new ArtDecoChair();
    }
    @Override
    public ICoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }
    @Override
    public ISofa createSofa() {
        return new ArtDecoSofa();
    }
}
