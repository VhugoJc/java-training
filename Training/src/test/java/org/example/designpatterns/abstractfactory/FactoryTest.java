package org.example.designpatterns.abstractfactory;


import org.example.designpatterns.abstractfactory.factory.ArtDecoFactory;
import org.example.designpatterns.abstractfactory.factory.ModernFactory;
import org.example.designpatterns.abstractfactory.factory.VictorianFactory;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FactoryTest {
    @ParameterizedTest
    @MethodSource("factoryProvider")
    public void furnitureSitOnTesting(IFactory factory){
        IChair chair = factory.createChair();
        ISofa sofa = factory.createSofa();
        ICoffeeTable coffeeTable = factory.createCoffeeTable();

        // sit On
        chair.sitOn();
        sofa.sitOn();
        coffeeTable.sitOn();

    }
    @ParameterizedTest
    @MethodSource("factoryProvider")
    public void furnitureHasLegTesting(IFactory factory){
        IChair chair = factory.createChair();
        ISofa sofa = factory.createSofa();

        // has leg
        System.out.println(chair.hasLegs());
        System.out.println(sofa.hasLegs());
    }
    @ParameterizedTest
    @MethodSource("factoryProvider")
    public void furnitureHasDrawersTesting(IFactory factory){
        ICoffeeTable coffeeTable = factory.createCoffeeTable();
        // has drawers
        System.out.println(coffeeTable.hasDrawers());
    }

    static Stream<IFactory> factoryProvider(){
        return Stream.of(new ArtDecoFactory(), new ModernFactory(), new VictorianFactory());
    }
}
