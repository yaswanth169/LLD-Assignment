package org.example.decorator;

import org.example.decorator.interfaces.basepizza;

public class CheesePizzaTopping extends PizzaDecorator{
    public CheesePizzaTopping(basepizza basepizza){
        super(basepizza);
    }

    @Override
    public String getDescription() {
        return basepi.getDescription() + "Extra Cheese";
    }

    @Override
    public int getCost() {
        return basepi.getCost() + 40;
    }
}
