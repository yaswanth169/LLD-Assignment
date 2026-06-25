package org.assignment2.problem4;

public class QuestionUnderstanding {

//    Requirements:
//    1. Product contains:
//          - id
//          - name
//          - price
//          - stockQuantity
//    2. Support:
//          addStock()
//          removeStock()
//          getStock()
//    3. Whenever stock changes, notify:
//          LowStockAlert
//          AutoReorder
//          PriceAdjuster
//          AuditLogger
//    4. Listeners can be added or removed at runtime.
//    5. Stock removal should fail if quantity is greater than available stock.
//    6. Support bulk update.
//       Events should fire only after all updates are completed.


//    My initial thinking is:
//    Suppose I directly write everything inside Inventory.

//    class Inventory{
//            removeStock(){
//            updateStock();
//            checkLowStock();
//            reorder();
//            adjustPrice();
//            auditLog();
//        }
//    }
//
//    Initially this works. But tomorrow if they ask me to add:
//          SlackNotifier
//          EmailNotifier
//          AnalyticsListener
//
//    Again I need to modify Inventory. Inventory slowly becomes responsible for everything.


//    If I observe carefully, the changing part is the listeners.
//    Today:
//          LowStockAlert
//          AutoReorder
//          PriceAdjuster
//          AuditLogger
//    Tomorrow:
//          SlackNotifier
//          SmsNotifier etc...
//    These listeners can keep increasing.


//    The stable part is:
//          Inventory
//          Product

//    Inventory should only manage stock. It should not know what every listener does.
//    So instead of Inventory calling every listener directly, I can create one common interface.

//    interface InventoryListener{
//          void onStockChanged(StockEvent event);
//    }
//
//    Every listener will implement this interface.
//    LowStockAlert
//    AutoReorder
//    PriceAdjuster
//    AuditLogger


//    Whenever stock changes, Inventory simply notifies all registered listeners.

//    Relationship:
//    Inventory HAS-A List<InventoryListener>
//    Inventory HAS-A Map<String, Product>


//    Runtime Flow:
//    Client
//    addStock()/removeStock()
//    Inventory updates stock
//    Create StockEvent
//    Notify all listeners
//    LowStockAlert
//    AutoReorder
//    PriceAdjuster
//    AuditLogger


//    For Bulk Update: nstead of firing events one by one, complete all stock updates first.
//    Store all StockEvents. After everything is finished, notify listeners for all events.



// Q1. Inventory doesn't know who is listening.
// How does notification work? Inventory only maintains a list of
// InventoryListeners. Whenever stock changes, it simply notifies every registered listener.
// Inventory never calls
//      LowStockAlert
//      AutoReorder
//      AuditLogger

// Q2. Tomorrow if SlackNotifier is added,
// how many classes change? Only one.
// Create SlackNotifier
// Implement InventoryListener Register it. Inventory remains unchanged.

// Q3. During bulk update,
// should listeners receive events immediately?
// No. First complete all stock updates.Store the generated events.Once every update is completed, notify all listeners.
// This avoids unnecessary intermediate notifications.


// Q4. Different listeners need different data.
// How will they get it?

// Create one StockEvent object.
// It can contain:
//      Product
//      Old Quantity
//      New Quantity
//      Timestamp
// Every listener can use whatever information it needs.


// Q5. If one listener throws an exception,
// should remaining listeners stop?
// No. Catch the exception. Continue notifying the remaining listeners.
// One failed listener should not stop. the complete notification flow.

}