package org.assignment2.multimethodpaymentcheckout;

public class MultiMethodPaymentCheckout {
// Problem 2: Multi-Method Payment Checkout

//Requirements
// Support:
//    Credit Card
//    UPI
//    Wallet
//    NetBanking

//    Validation Rules:
//    Credit Card
//    Card Number = 16 digits
//    Expiry should be valid
//
//    UPI
//    Must contain @

//    Wallet
//    Balance >= Order Amount
//
//    NetBanking
//    Bank must be supported

//    Additional Requirements:
//    Payment can randomly fail
//    Retry up to 2 times
//    Notify user through:
//    SMS
//    Email
//    Maintain payment history

//   initial Understanding We need a central Payment Processor.
//    The processor should:
//    Validate payment
//    Process payment
//    Retry on failure
//    Notify user
//    Store payment history

//    API
//    PaymentProcessor processor = new PaymentProcessor();
//    processor.addNotifier(new SmsNotifier());
//    processor.addNotifier(new EmailNotifier());

//    Order order = new Order("ORD-101",1500.0);
//    processor.pay(order,new UpiPayment("user@upi"));

//    From this API we immediately discover:
//    PaymentProcessor
//    Order
//    PaymentMethod
//    Notifier
//    PaymentHistory

//   Core Entities
//   PaymentProcessor
//    Order
//    PaymentMethod
//    CreditCardPayment
//    UpiPayment
//    WalletPayment
//    NetBankingPayment
//    Notifier
//    SmsNotifier
//    EmailNotifier
//    PaymentHistory
//    PaymentResult


//    My first thought:
//    class PaymentProcessor {
//        public void pay(Order order,String paymentType) {
//            if(paymentType.equals("UPI")) {
//                validateUpi();
//                processUpi();
//                sendSms();
//                sendEmail();
//            }
//            else if(paymentType.equals("CARD")) {
//                validateCard();
//                processCard();
//                sendSms();
//                sendEmail();
//            }
//        }
//    }

//   Problems i identified...
//    Validation logic mixed with payment logic.
//    Notification logic mixed with payment logic.
//    Every new payment method requires modifying PaymentProcessor.
//    Retry logic becomes duplicated.
//    Large if-else chain.

//    What Changes Frequently?
//    Payment Methods
//    Examples: Credit Card. UPI etc.. These will keep increasing.

//    What Remains Stable? PaymentProcessor, Order, PaymentResult, Payment History

//    Since payment methods vary: i am thinking to introduce the abstraction here..
//    interface PaymentMethod {
//        boolean validate();
//        PaymentResult process(Order order);
//    }

//    Every payment method follows the same contract.

//    Observation:
//    Different payment methods
//    Different validation
//    Different processing
//    Same operation

//    This naturally leads to: Strategy Pattern
//    Runtime Flow
//    Example:
//      processor.pay(order,new UpiPayment("user@upi"));

//    Flow:
//    Client
//    PaymentProcessor
//    Validate UPI
//    Process Payment
//    Retry if Failed
//    Store History
//    Notify SMS
//    Notify Email
//    Return Result

//
// Q : If you add "Cash on Delivery" tomorrow, do you modify existing classes or just add new ones? If you're modifying, can you restructure?
//    Existing classes changed: Zero
//    Only create: CashOnDeliveryPayment


//  Q; Notification Loop Duplication?
//    Avoided using: List<Notifier> . Processor iterates through all notifiers once.
//  Q : Retry Logic?
//    Retry should not be inside: UPI, Card, Wallet. because retry policy may vary. Keep retry handling inside:



}
