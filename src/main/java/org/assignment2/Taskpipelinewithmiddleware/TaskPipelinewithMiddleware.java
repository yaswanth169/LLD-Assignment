package org.assignment2.Taskpipelinewithmiddleware;

public class TaskPipelinewithMiddleware {
//    Requirements
//    A Task contains:
//          id
//          payload
//          priority (LOW, MEDIUM, HIGH)
//          userId
//    Before executing a task, it should pass through:
//            AuthMiddleware
//            RateLimitMiddleware
//            LoggingMiddleware
//            ValidationMiddleware
//    Middleware order should be configurable. Middleware can be skipped. If any middleware rejects the task, execution should stop. Execute tasks based on priority:
//            HIGH
//            MEDIUM
//            LOW
//    Support custom task handlers...


//    After reading the problem, this is what I understood.
//
//    We need one main class called TaskEngine. Its job is to receive tasks, store them based on priority, pass every task through all the middleware, and if everything is successful, execute the correct task handler.
//    The middleware should be flexible. Tomorrow if someone asks me to add a new middleware, I should not have to change the whole system.
//    Similarly, if a new task type comes in, I should just add a new handler without changing the existing code.

//    The driver code given is:
//    TaskEngine engine = new TaskEngine();
    //engine.addMiddleware(new AuthMiddleware(...));
    //engine.addMiddleware(new RateLimitMiddleware(...));
    //engine.addMiddleware(new LoggingMiddleware());
    //engine.addMiddleware(new ValidationMiddleware());
    //engine.registerHandler("EMAIL", new EmailTaskHandler());
    //engine.registerHandler("REPORT", new ReportTaskHandler());
    //engine.submit(task);
    //engine.executeAll();


//    I got some information while Looking at this API gives me a good idea of the design.
//    From here I can already identify that: There is one TaskEngine.
//    Middleware can be added dynamically.
//    Task handlers can also be registered dynamically.
//    Tasks are submitted first and executed later.

//    The main entities I found are:
//    TaskEngine
//    Task
//    Priority
//    Middleware
//    AuthMiddleware
//    RateLimitMiddleware
//    LoggingMiddleware
//    ValidationMiddleware
//    TaskHandler
//    EmailTaskHandler
//    ReportTaskHandler

// I just wanted to explain the responsibilties of the important classes or the abstraction layers.
//    TaskEngine : TaskEngine should only coordinate everything.
//    Its responsibilities are:
    //    Accept tasks.
    //    Store tasks.
    //    Maintain the middleware list.
    //    Execute middleware.
    //    Find the correct handler.
    //    Execute the handler.

//    Middleware : Each middleware should only do one job.
//    For example,
    //    AuthMiddleware checks authentication.
    //    RateLimitMiddleware checks rate limits.
    //    ValidationMiddleware validates the task.
    //    LoggingMiddleware logs the request.
    //    After doing its work, it either allows the task to continue or rejects it.

//  TaskHandler should only execute the business logic.
//    For example,
//    EmailTaskHandler sends email.
//    ReportTaskHandler generates report.

//    Task : Task is just a model object that holds the task information.

//
//   My first thought was something simple like this.

//    public void execute(Task task){
//        authenticate(task);
//        rateLimit(task);
//        log(task);
//        validate(task);
//        if(task.getType().equals("EMAIL")){
//            sendEmail(task);
//        }
//        if(task.getType().equals("REPORT")){
//            generateReport(task);
//        }
//    }

//    But after onbserving this there are couple of provlems...
// here are the problems :
//1. TaskEngine knows every middleware.
//    Auth
//    RateLimit
//    Logging
//    Validation
//    If tomorrow a new middleware comes I need to modify TaskEngine.
//
//2. TaskEngine knows every task handler.
//    Again, if a new task type comes, TaskEngine changes.
//
//The design is not easily extensible. Every new feature ends up modifying existing code.



//    What is actually changing?
//    I found two things.
//    Middleware
//    Today we have Auth, RateLimit, Logging, Validation
//    Tomorrow we may have Encryption and all.. etc....
//
//    Middleware will keep increasing and Task Handlers : Task handlers will also keep increasing.

//    The things that stay almost the same are
//    TaskEngin
//    Task
//    Priority Queue
//    So I should avoid changing these classes.


//    Since middleware is changing, I don't want TaskEngine to know every middleware.
//    So I can create one common interface.
//    interface Middleware {
//        boolean process(Task task);
//    }
//    Now every middleware follows the same contract.
//    Task handlers also change. So I can create another interface.

//    interface TaskHandler {
//        void execute(Task task);
//    }
//    Now every handler follows the same contract.

//
//    While thinking about the middleware flow, I noticed something.
//    Every middleware follows the same sequence.Since every middleware follows this flow, Chain of Responsibility fits well here.

//    Q1. Every middleware follows the same flow. How did you avoid duplicate code?
//    I created a common Middleware interface so every middleware follows the same contract. If there is any common logic in the future, I can move it into a base class and let all middleware reuse it instead of duplicating code.

//    Q2. Tomorrow if EncryptionMiddleware comes, what changes?
//    Nothing changes in the existing classes.
//    I can create EncryptionMiddleware and register it in the pipeline.

//    Q3. What if I change the middleware order?
//    The design still works. askEngine simply executes middleware in the configured order.

//    Q4. How does the pipeline stop?
//    If any middleware returns failure, TaskEngine immediately stops the execution and returns the rejection reason.

//    Q5. How does TaskEngine know which handler to execute?
//    Instead of using multiple if-else conditions, I register handlers in a Map<String, TaskHandler>. Using the task type, TaskEngine finds the correct handler and delegates the execution.
}
