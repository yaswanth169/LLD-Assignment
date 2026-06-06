package org.example.orderstateflow;

public class OrderStateFlow {

//## Requirements
//
//     1. Order lifecycle should follow:
//            Created → Paid → Shipped → Delivered
//     2. Behavior should change based on the current state.

//    An order that is already delivered should not be shipped again.

//    ## Initial Approach
//    My first thought was to store the state as a string and use if-else conditions.

//    class Order {
//        private String state;
//        public void nextState() {
//
//            if(state.equals("CREATED")) {
//                state = "PAID";
//            }
//            else if(state.equals("PAID")) {
//                state = "SHIPPED";
//            }
//            else if(state.equals("SHIPPED")) {
//                state = "DELIVERED";
//            }
//        }
//    }
//    ## Problems with this Approach
//
//    As the number of states increases he if-else conditions become larger.

//    Created
//    Paid
//    Shipped
//    Delivered
//    Cancelled
//    Returned
//    Refunded

//    Managing transitions becomes difficult.
//    Every time a new state is added existing code needs to be modified.
//    The behavior for each state also gets mixed into a single class.

//    ## Observation
//    The main thing changing here is the behavior based on the current order state.
//    Different states have different rules and actions.

//    Examples:
//    Created   Can Pay
//    Paid      Can Ship
//    Shipped   Can Deliver
//    Delivered No further transitions

//    ## Solution
//    I can use the State Pattern.
//    Each state is represented by a separate class.

//    OrderState

//    Implementations:
//    CreatedState
//    PaidState
//    ShippedState
//    DeliveredState

//    The Order object keeps a reference to the current state.
//    order.setState(new PaidState());

//    Each state decides what the next valid transition should be.
//    This removes large if-else chains and makes adding new states easier.
//

//    1. State Pattern.

//    2. Because the behavior of the order changes depending on its current state. State Pattern allows each state to manage its own behavior and transitions without creating large conditional blocks.

//    3.
    //1. Use String values with if-else conditions.
    //2. Use an Enum and switch statements.
    //3. Store state transition rules in a configuration or database.


}
