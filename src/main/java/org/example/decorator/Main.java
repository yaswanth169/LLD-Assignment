package org.example.decorator;
import org.example.decorator.child.PlainPizza;
import org.example.decorator.interfaces.basepizza;

public class Main {
    public static void main() {
        basepizza base1 = new PlainPizza();
        System.out.println(base1.getDescription() + " and the cost is : " + base1.getCost());

        PizzaDecorator pizzaDecorator = new MargeritaPizzaTopping(base1);
        System.out.println(pizzaDecorator.getDescription() + " and the cost is : " + pizzaDecorator.getCost());

        PizzaDecorator pizzaDecorator1 = new CheesePizzaTopping(new MargeritaPizzaTopping(new PlainPizza()));
        System.out.println(pizzaDecorator1.getDescription() + " and the cost is : " + pizzaDecorator1.getCost());
    }
}
