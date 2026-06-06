package org.example.ridefarecalculator;

public class RideFareCalculator {
//Requirements
//1. Support Bike and Car pricing.
//2. Support Surge Pricing.
//3. Calculate fare based on the selected ride type.

//    Example:

//    Bike Ride
//    Distance = 10 km
//    Fare = Bike Pricing Logic

//    Car Ride
//    Distance = 10 km
//    Fare = Car Pricing Logic

//    Surge Pricing
//    Distance = 10 km
//    Fare = Base Fare * Surge Multiplier

//    My first thought was to use if-else conditions based on the ride type.

//    public double calculateFare(String rideType, double distance) {
//        if(rideType.equals("BIKE")) {
//            return distance * 10;
//        }
//        else if(rideType.equals("CAR")) {
//            return distance * 20;
//        }
//    }
//   Problems I got in my mind are : As new ride types are introduced, the if-else block keeps growing.
//    Bike
//    Car
//    Auto
//    Premium Car
//    Luxury Car
//    Shared Ride

//    Every time a new pricing model is added, the existing code must be modified.
//    The fare calculation logic also becomes tightly coupled to one class.
//    The main thing changing here is the fare calculation algorithm.

//    Different ride types use different pricing strategies.
//    Bike → Distance * 10
//    Car → Distance * 20
//    Surge Ride → Base Fare * Surge Multiplier
//    The calculation logic changes, but the overall operation remains the same.\


//    So for this type of scenarios we can use the Strategy Pattern.
//    A common interface is created for fare calculation.

//    interface FareStrategy {
//        double calculateFare(double distance);
//    }

//    Different ride types provide their own implementations.

//    BikeFareStrategy
//    CarFareStrategy
//    SurgeFareStrategy

//    The RideFareCalculator works with the interface and can switch pricing logic at runtime.

//    FareStrategy strategy = new BikeFareStrategy();
//
//    RideFareCalculator calculator = new RideFareCalculator(strategy);

//    calculator.calculateFare(10);

//    If the user selects a car ride:

//    calculator.setStrategy(new CarFareStrategy());


//    1. Strategy Pattern.
//    2. Because the fare calculation algorithm changes depending on the ride type. Strategy Pattern allows different pricing
//    algorithms to be plugged in without modifying existing code.
//     3.
//     1. Use if-else conditions based on ride type.
//     2. Use switch statements with enums.
//     3. Use a Factory along with Strategy to create the correct pricing strategy.

}
