package org.example.remoteactionssystem;

public class RemoteActionsSystem {
//## Requirements

//  1. Turn devices ON/OFF
//  2. Increase and decrease volume
//  3. Support Undo functionality

//    Example:
//    TV ON
//    Volume Up
//    Volume Up
//    Undo
//    The last action should be reverted.

//## Initial Approach

//    My first thought was to directly call methods on the device.


//        tv.turnOn();
//        tv.volumeUp();
//        tv.volumeDown();
//        tv.turnOff();

//    ## Problems with this Approach
//    The remote control becomes tightly coupled with the device implementation.
//    If we want to support multiple actions such as:
//    Power ON
//    Power OFF
//    Volume Up
//    Volume Down
//    Mute
//    Channel Change

//    the remote control will need to know about all these operations.
//    Adding Undo functionality also becomes difficult because the remote does not keep track of the actions performed.

//## Observation
//    The main thing changing here is the action being executed.
//    Each action should be treated as an object so that it can be:
//         Executed
//         Stored
//         Undone later

//## Solution
//    I used the Command Pattern.
//    Each operation is represented as a command object.

//    Examples:
//    PowerOnCommand
//    PowerOffCommand
//    VolumeUpCommand
//    VolumeDownCommand

//    All commands implement a common interface.
//    interface Command {
//        void execute();
//        void undo();
//    }

//    The remote control only works with commands.
//    remote.pressButton(new PowerOnCommand(tv));

//    For Undo functionality, executed commands can be stored in a stack.
//    When Undo is pressed, the last command is removed from the stack and its undo method is executed.



//    1. Command Pattern.

//    2. Because each action can be represented as an object. This makes it easy to execute actions, store them, and support Undo functionality without tightly coupling the
//    remote control to specific device operations
//
//    3.
//            1. Direct method calls on the device.
//            2. Use enums and switch statements to execute actions.
//            3. Store action history manually and reverse operations without using Command objects.

}
