package org.example.decorator.child;

import org.example.decorator.interfaces.basepizza;

public class Margerita implements basepizza{

    @Override
    public String getDescription() {
        return "Margerita Pizza";
    }

    @Override
    public int getCost() {
        return 220;
    }
}
