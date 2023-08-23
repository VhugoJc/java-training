package org.example.designpatterns.abstractfactory;

public interface IFactory {
    IChair createChair();
    ICoffeeTable createCoffeeTable();
    ISofa createSofa();
}
