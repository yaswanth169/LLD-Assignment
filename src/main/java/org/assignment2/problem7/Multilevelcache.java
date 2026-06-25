package org.assignment2.problem7;

public class Multilevelcache {

//    Requirements:
//    1. Support multiple cache levels.
//          L1
//          L2
//    2. get(key)
//          Check L1
//          ↓
//          Check L2
//          ↓
//          Return null if not found
//    3. If found in L2,
//       promote it to L1.
//    4. put(key,value)
//          Write to every level.
//    5. Every cache level has
//       its own eviction policy.
//          LRU
//          LFU
//    6. Maintain cache statistics.
//    7. Support:
//          remove()
//          clear()


//    My initial thinking is: Suppose I write everything inside MultiLevelCache.

//    class MultiLevelCache{
//            get(){
//            checkL1();
//            checkL2();
//            lru();
//            lfu();
//            updateStats();
//        }
//    }

//    Initially this works. But tomorrow if they ask me to add L3 Cache or FIFO Eviction I need to modify the same class again. MultiLevelCache slowly starts handling everything.

//    Problems with this approach:
//    1. MultiLevelCache knows every eviction policy. This violates Open Closed Principle and Cache logic and eviction logic are tightly coupled. and Stats logic is mixed with cache logic. and Adding a new cache level requires modifying MultiLevelCache.


//    If I observe carefully, the changing parts are:
//       Cache Levels
//              L1
//              L2
//              L3
//       Eviction Policies
//              LRU
//              LFU
//              FIFO
//    These can keep increasing. The stable part is: MultiLevelCache CacheLevel Since eviction policy changes, Strategy Pattern fits well.
//    Since cache levels are arranged one after another, Chain of Responsibility also fits naturally.


//    Instead of CacheLevel knowing every eviction policy, I can create
//    interface EvictionPolicy{
//          evict();
//    }

//    Every policy implements this interface.
//          LRU
//          LFU Similarly, every cache level follows one common structure.


//    Relationship:
//    MultiLevelCache HAS-A List<CacheLevel>
//    CacheLevel HAS-A EvictionPolicy


//    Runtime Flow:
//    Client
//    get(key)
//    Check L1
//    Found?
//    YES → Return
//    NO
//    Check L2
//    Found?
//    YES
//    Promote to L1
//    NO
//    Cache Miss


// Q1. How does CacheLevel support different eviction policies?
// CacheLevel depends on EvictionPolicy interface.

// Q2. Tomorrow if L3 Cache comes?
// Only create a new CacheLevel. MultiLevelCache remains unchanged.

// Q3. Where does promotion logic live?
// Inside MultiLevelCache while coordinating cache levels.

// Q4. How do you track stats?
// Keep stats in a separate CacheStatistics class.

// Q5. Can two cache levels use the same eviction policy? Yes.
// Every CacheLevel can use any EvictionPolicy implementation.

}
