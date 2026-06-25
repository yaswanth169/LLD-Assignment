package org.assignment2.smartloggingframework;

public class SmartLoggingFramework {

//    # Problem 1: Smart Logging Framework

// Requirements:
// Support log levels:
//  DEBUG
//  INFO
//  WARN
//  ERROR
//  FATAL

// According to the requirements we need to Support multiple destinations:
//  Console
//  File
//  HTTP

// Each destination should have its own minimum log level.
//    Console -> DEBUG
//    File -> WARN
//    HTTP -> ERROR

// We need to Support adding/removing destinations at runtime.
// Log format:  [timestamp] [LEVEL] message and also one important thing is : Only one logger instance should exist.

// After reading this requirements i have an initial understanding about the provlem... here is my understanding now...

//    We need a central Logger.
//    Logger should: Accept log requests., Send logs to multiple destinations, Allow destinations to be added or removed dynamically, Support destination-specific filtering, Maintain a single logger instance.

//    Before designing classes, let's see how the client should use the system. Given...
//    Logger logger = Logger.getInstance();
//    logger.addDestination(new ConsoleDestination(DEBUG));
//    logger.addDestination(new FileDestination(WARN));
//    logger.addDestination(new HttpDestination(ERROR));
//    logger.log(INFO, "App Started");
//    logger.log(ERROR, "Database Down");
//    logger.removeDestination("FILE");
//    According to this data ... where after our udnerstanding refactoring of way of calling the driver or apis. This immediately tells us what API we need.
//

//    Main entities:

//    Logger
//    Destination
//    ConsoleDestination
//    FileDestination
//    HttpDestination
//    LogMessage
//    LogLevel


//    My first thought i got..

//    class Logger {
//        public void log(LogLevel level, String message) {
//            if(level >= DEBUG) {
//                System.out.println(message);
//            }
//            if(level >= WARN) {
//                System.out.println("[FILE]" + message);
//            }
//            if(level >= ERROR) {
//                System.out.println("[HTTP]" + message);
//            }
//        }
//    }


//    Problems with this approach are:
//    1. Logger knows every destination.
//    Console
//    File
//    HTTP

//    2. Adding a new destination requires modifying Logger. Future enhancments...
//    DatabaseDestination
//    KafkaDestination and also Filtering logic becomes duplicated.


//    My Observation is according to the thougths and the solution i provided and identified problems.. What Changes Frequently?

//    Destination Types
//    Console, File, HTTP, Database etc...

//    These can keep increasing.

//    What will be the stable wihtout touching..., These remain mostly unchanged:
//    Logger
//    LogMessage
//    LogLevel


//    Since destinations vary, i am thinking to create a common contract. where we can start reating an interface and the work with it..
//    interface Destination {
//        void receive(LogMessage message);
//    }

//    Now every destination follows the same contract. ConsoleDestination, FileDestination, HttpDestination

//    My Observation :
//    Logger sends logs.
//    Multiple destinations receive logs.
//    Destinations can be added/removed dynamically.
//    This naturally leads to: Observer-like Publisher/Subscriber Design
//    Additionally: Polymorphism through Destination interface.

//    Relationship: Logger HAS-A List<Destination>

//      if it is in runtime flow...
//      logger.log(ERROR,"Database Connection Lost");

//    Flow: Client -> Logger receives request -> Logger creates LogMessage -> Logger iterates destinations -> Destination checks filter -> Console accepts -> File accepts -> HTTP accepts -> Message written

// Q : Why does the requirement say "only one instance"? What breaks if someone creates two loggers?
//    Requirement says:
//    Only one logger instance.
//    If we create: Logger logger1; Logger logger2;
//    Then: Different destination lists, Different configurations, Different log streams
//    Application logs become inconsistent.


// Q : If a teammate adds a DatabaseDestination tomorrow, how many existing classes need to change? If the answer is more than zero, can you restructure so it's zero?
//    if i want to add the DatabaseDestination Later. How many existing classes change?
//    Zero class changes.. according to our desing now..
//    Only create: DatabaseDestination and register it. Logger remains untouched.

// Q: What if each destination wants to format the timestamp differently — where would that logic live?
//    Timestamp formatting. Not logging. Not destinations.
//    Possible abstraction can be done :
//    Formatter, so different destinations can use different formatters.

// Q; Look at your log() method. Is it doing too many things? Could you separate "who to notify" from "how to filter"?

//    Current responsibilities: Create Message, Filter, Notify Destinations
//    Potential improvement:
//    Separate: Filtering, Notification, Formatting into dedicated components if complexity grows.

//  Q : You have multiple destinations that all do the same thing (receive a log). How did you avoid copy-pasting the filtering logic into each one?

//    All destinations share the same filtering behavior. Instead of duplicating the filtering logic in ConsoleDestination, FileDestination, and HttpDestination, I can create an abstract BaseDestination class.
//    BaseDestination handles the common filtering logic based on minimum log level, while concrete destinations only implement the destination-specific write behavior.
//    This follows the DRY principle and allows new destinations such as DatabaseDestination to reuse the same filtering logic without any code duplication.
