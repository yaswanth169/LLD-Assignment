package org.example.legacyloggerintegration;

public class LegacyLoggerIntegration {

//## Requirements
//      1. Old Logger Interface
//        logMessage(String message)
//      2. New Logger Interface
//        log(String level, String message)

// Integrate the old logger with the new system without modifying the old code.
//

//    My first thought was to directly modify the old logger class.

//    class OldLogger {
//        public void log(String level, String message) {
//            logMessage(message);
//        }
//    }

//  Problems with this
//    The old logger may belong to a legacy system or third-party library.
//    Modifying existing code can be risky and may affect other applications that are already using it.
//    Also, we may not have access to change the source code.

//  Observation
//    The main issue is that the interfaces are different.

//    Old System:
//    logMessage(String message)

//    New System:
//    log(String level, String message)

//    The functionality is similar, but the method signatures do not match.

//    I can use the Adapter Pattern.
//
//    The adapter acts as a bridge between the new interface and the old implementation.
//
//    The new system interacts with the adapter, and the adapter internally calls the old logger.
//
//    Example:
//
//            ```java
//    Logger logger =
//            new LoggerAdapter(new OldLogger());
//
//logger.log("INFO", "Application Started");
//```
//
//    Internally:
//
//            ```java
//oldLogger.logMessage("Application Started");
//```
//
//    The client does not need to know that an old logger is being used.
//
//            ## Reflection
//
//### Which approach did you use?
//
//    Adapter Pattern.
//
//            ### Why did you choose this approach?
//
//    Because the old logger and the new logger have incompatible interfaces. Adapter allows them to work together without modifying the existing implementation.
//
//### Can you think of another way to solve this?
//
//    Yes.
//
//1. Modify the old logger directly.
//2. Create a completely new logger implementation.
//            3. Use a wrapper class with custom conversion logic.
//
//    However, Adapter is the cleanest solution because it preserves the legacy code and provides compatibility with the new interface.

}
