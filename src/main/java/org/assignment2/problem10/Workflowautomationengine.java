package org.assignment2.problem10;

public class Workflowautomationengine {

//    Requirements:
//    1. Workflow contains multiple Steps.
//    2. Step types:
//          ActionStep
//          ConditionStep
//          DelayStep
//          ParallelStep
//    3. Every step has:
//          name
//          retryCount
//          failurePolicy
//    4. Support
//          STOP
//          SKIP
//          RETRY
//    5. Maintain execution log.
//    6. Support Dry Run.

//    My initial thinking is:
//    Suppose I write everything inside Workflow.
//    class Workflow{
//            execute(){
//            if(ActionStep){}
//            if(ConditionStep){}
//            if(DelayStep){}
//            if(ParallelStep){}
//        }
//    }
//
//    Initially this works. But tomorrow if they ask me to add LoopStep ApprovalStep NotificationStep I need to modify Workflow again. Workflow slowly becomes responsible for everything.


//    Problems with this approach:
//    1. Large if-else blocks.
//    2. Workflow knows every step type. This violates Open Closed Principle.


//    If I observe carefully, the changing parts are: Step Types
//              Action
//              Condition
//              Delay
//              Parallel
//              Loop
//          Failure Policies
//              STOP
//              SKIP
//              RETRY These can keep increasing.
//    The stable part is: Workflow Since every step is executed in the same way, I can create one common Step interface. ParallelStep contains multiple Steps.
//    ConditionStep also points to other Steps. This naturally reminds me of Composite Pattern.


//    Instead of Workflow knowing every step, I can create
//    interface Step{
//          execute();
//    }
//
//    Every step implements this interface.
//          ActionStep
//          ConditionStep
//          DelayStep
//          ParallelStep


//    Relationship:
//    Workflow HAS-A List<Step>
//    ParallelStep HAS-A List<Step>
//    ConditionStep HAS-A True Step False Step


//    Runtime Flow:
//    Client
//    Workflow
//    Execute Step
//    Success ?
//    YES
//    Next Step
//    NO
//    Failure Policy
//          STOP
//          SKIP
//          RETRY


// Q1. How are all step types handled?
// All steps implement the Step interface.

// Q2. Can ParallelStep contain another ParallelStep?
// Yes. Composite Pattern supports nesting.

// Q3. Tomorrow if LoopStep comes?
// Only create LoopStep. Existing classes remain unchanged.

// Q4. Where should retry logic live?
// Keep retry logic inside the Workflow Engine to avoid duplication.

// Q5. How is Dry Run handled?
// Execute through a DryRunExecutor instead of actual execution.

// Q6. How is data shared between steps?
// Store data inside a shared WorkflowContext.

}