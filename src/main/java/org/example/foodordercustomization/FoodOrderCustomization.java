package org.example.foodordercustomization;

public class FoodOrderCustomization {

//  Requirements

//  1. Have a base Pizza.
//  2. Add toppings dynamically.
//  3. Support multiple topping combinations.


//    Base Pizza
//    Base Pizza + Cheese
//    Base Pizza + Cheese + Mushroom
//    Base Pizza + Cheese + Mushroom + Olives
//    The user should be able to add toppings as needed.

//    My first thought was to create separate classes for every combination.

//    CheesePizza
//    MushroomPizza
//    OlivePizza etc...

//    there might be some problems ... occured with this solution...
//    The number of classes grows very quickly.

//    Cheese
//    Mushroom
//    Olive
//    Paneer

//    Different combinations would require many new classes. This makes the system difficult to maintain and extend.

//    The main thing changing here is the toppings. The base pizza remains the same.
//    New toppings should be added dynamically without creating separate classes for every possible combination.
//    so we can use the Decorator Pattern.
//
//    A Pizza interface is created.

//    interface Pizza {
//        String getDescription();
//        double getCost();
//    }
//    Base Pizza:
//    Toppings are implemented as decorators:
//      CheeseDecorator
//      MushroomDecorator
//      OliveDecorator

//    Each decorator wraps an existing Pizza object and adds its own cost and description.

//    Pizza pizza = new CheeseDecorator(new MushroomDecorator(new BasePizza()));

//    This creates:
//    Base Pizza + Mushroom + Cheese
//    without creating a separate class for that combination.


//    1. Decorator Pattern.
//    2. Because toppings need to be added dynamically and multiple toppings can be combined. Decorator allows adding new
//    behavior without modifying the base pizza class or creating many subclasses.
    // 3. Same as initial approach..

}
