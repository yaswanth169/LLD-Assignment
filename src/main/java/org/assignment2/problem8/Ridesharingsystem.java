package org.assignment2.problem8;

public class Ridesharingsystem {

//    Requirements:
//    1. Riders can request rides.
//    2. Drivers can register.
//    3. Match nearest available driver.
//    4. Calculate fare based on vehicle type.
//    5. Apply surge pricing.
//    6. Ride lifecycle:
//          REQUESTED
//          MATCHED
//          IN_PROGRESS
//          COMPLETED
//          RATED
//    7. Rider can rate driver.
//    8. Maintain driver ratings.


//    My initial thinking is:
//    Suppose I write everything inside RideService.
//
//    class RideService{
//        requestRide(){}
//        calculateFare(){}
//        matchDriver(){}
//        startRide(){}
//        completeRide(){}
//        rateRide(){}
//    }

//    Initially this works. But tomorrow if they ask me to add
//          Luxury Car
//          Cancel Ride
//          Match by Rating
//          Peak Hour Pricing
//    I need to modify RideService again. RideService slowly becomes responsible for everything.


//    Problems with this approach:
//    1. RideService knows every fare calculation. This violates Open Closed Principle.
//    2. RideService controls every ride state using if-else.


//    If I observe carefully, the changing parts are:
//          Fare Calculation
//              Bike
//              Auto
//              Car
//              Luxury Car
//          Driver Matching
//              Nearest
//              Highest Rated
//              Cheapest
//          Ride States
//              Requested
//              Matched
//              In Progress
//              Completed
//              Rated
//              Cancelled
//
//    These will keep increasing. The stable parts are:
//          Ride
//          Driver
//          Rider
//    Since fare calculation changes, Strategy Pattern fits well. Since ride behavior changes based on current state, State Pattern fits well.


//    Instead of RideService knowing every fare calculation, I can create
//    interface FareStrategy{
//          calculateFare();
//    }
//    BikeFare
//    AutoFare
//    CarFare Similarly, every ride state follows one common contract.
//    interface RideState{
//          next();
//    }

//    Driver matching also changes.
//    interface MatchingStrategy{
//          findDriver();
//    }


//    Relationship:
//    RideService HAS-A FareStrategy MatchingStrategy
//    Ride HAS-A RideState


//    Runtime Flow:
//    Client
//    Request Ride
//    Matching Strategy
//    Driver Found
//    Fare Strategy
//    Ride Created


//    State Changes
//    REQUESTED
//    MATCHED
//    IN_PROGRESS
//    COMPLETED
//    RATED



// Q1.How do you prevent invalid state changes?
// Each state controls the next valid state.

// Q2. Tomorrow if CANCELLED comes?
// Create a new state. Existing states need minimal changes.

// Q3. Where does fare logic live?
// Inside FareStrategy.

// Q4. Surge pricing?
// Apply it as another pricing strategy on top of base fare.

// Q5. Tomorrow if matching changes?
// Create a new MatchingStrategy.

}