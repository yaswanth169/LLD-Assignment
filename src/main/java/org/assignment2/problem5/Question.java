package org.assignment2.problem5;

public class Question {

//    Requirements:
//    1. Document contains:
//          - title
//          - list of lines
//    2. Support:
//          insertLine()
//          deleteLine()
//          editLine()
//          bold()
//          italic()
//    3. Every operation should support
//       Undo and Redo.
//    4. If a new operation is performed
//       after Undo,
//       Redo history should be cleared.
//    5. Support Batch Execution.
//    6. Batch should behave like
//       one single Undo operation.
//    7. Print document.
//    8. Print history.


//    My initial thinking is:
//    Suppose I directly write everything inside Document.

//    class Document{
//        insertLine(){}
//        deleteLine(){}
//        editLine(){}
//        bold(){}
//        italic(){}
//        undo(){}
//        redo(){}
//    }
//
//    Initially this works. But every operation now needs its own Undo logic. As more operations are added,
//    Document becomes bigger and difficult to maintain.


//    Problems with this approach:
//    1. Document is handling editing, undo, redo, history. This violates Single Responsibility Principle.
//    2. Every new operation requires modifying Document.This violates Open Closed Principle.


//    If I observe ,the changing part is the operations.
//    Today:
//          Insert
//          Delete
//          Edit
//          Bold
//          Italic
//    Tomorrow:
//          MoveLine
//          CopyLine
//          PasteLine
//
//    These can keep increasing. The stable part is:
//    Document
//    Every operation performs the same flow.
//    Execute
//    Undo
//    This fits int the form of Command Pattern.


//    Instead of Document knowing every operation, I can create one interface.

//    interface Command{
//          execute();
//          undo();
//    }

//    Every operation implements this interface.
//          InsertCommand
//          DeleteCommand
//          EditCommand
//          BoldCommand
//          ItalicCommand


//    Relationship:
//    Document HAS-A List<String>
//    DocumentEditor HAS-A Stack<Command> undoStack Stack<Command> redoStack
//    BatchCommand HAS-A List<Command>


//    Runtime Flow:
//    Client
//    Create Command
//    Execute Command
//    Push into Undo Stack
//    Clear Redo Stack
//    Undo
//    Pop from Undo Stack
//    undo()
//    Push into Redo Stack
//    Redo
//    Pop from Redo Stack
//    execute()
//    Push into Undo Stack



// Q1. How is Undo implemented?
// Every Command stores the data needed to undo itself.


// Q2. What is common among all operations?
// Every operation implements execute() and undo().

// Q3. Why clear the redo stack?
// A new operation creates a new history. Old redo operations are no longer valid.

// Q4. Batch undo order? Undo in reverse order o restore the document correctly.

// Q5. Tomorrow if MoveLine is added?
// Only create MoveLineCommand. Existing classes remain unchanged.

}

