package org.example.decorator;

import org.example.decorator.interfaces.basepizza;

public abstract class PizzaDecorator implements basepizza {
    basepizza basepi;

    public PizzaDecorator(basepizza basepi){
        this.basepi = basepi;
    }
}

