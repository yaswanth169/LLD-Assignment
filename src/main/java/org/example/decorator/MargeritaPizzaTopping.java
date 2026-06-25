package org.example.decorator;

import org.example.decorator.interfaces.basepizza;

public class MargeritaPizzaTopping extends PizzaDecorator {

    public MargeritaPizzaTopping(basepizza basepizza){
        super(basepizza);
    }

    @Override
    public String getDescription() {
        return basepi.getDescription() + "Extra Margerita";
    }

    @Override
    public int getCost() {
        return basepi.getCost() + 20;
    }
}
