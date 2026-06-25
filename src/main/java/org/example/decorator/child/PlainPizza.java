package org.example.decorator.child;

import org.example.decorator.interfaces.basepizza;

public class PlainPizza implements basepizza {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public int getCost() {
        return 200;
    }
}
