package org.example.chatroomsystem;

public class ChatRoomSystem {
//Requirements
//    1. Users can join a chat room.
//    2. Users can send messages.
//    3. Messages should be broadcast to all users in the chat room.


//    Yash joins Chat Room
//    John joins Chat Room
//    Yash: Hello Everyone
//    John receives:
//              Hello Everyone
//    Users should communicate through the chat room.

//    My first thought was to let users communicate directly with each other.

//    class User {
//        List<User> users;
//        public void sendMessage(String message) {
//            for(User user : users) {
//                user.receive(message);
//            }
//        }
//    }
//    But if we use this approach we might face some problems ..
//    Every user needs to know about every other user.

//    User A knows User B
//    User A knows User C
//    User A knows User D
//    User B knows User A
//    User B knows User C
//    User B knows User D

//    As the number of users increases, the dependencies increase significantly.
//    Managing joins, leaves, and message broadcasting becomes difficult.


//    The main issue is communication between users. Instead of users talking directly to each other,
//    there should be a central object responsible for managing communication.


//    there is a pattern called Mediator Pattern. where we can use it to make sure out design works with the central.
//    A ChatRoom acts as the mediator.
//    Users do not communicate directly.
//    They send messages to the ChatRoom, and the ChatRoom forwards the messages to the appropriate users.
//      chatRoom.sendMessage("Hello Everyone", yash);

//    The ChatRoom broadcasts the message to all other users.
//    Users only know about the ChatRoom and do not need references to other users.


//   1. Mediator Pattern.
//   2. Because communication between users should be managed centrally. Mediator reduces direct dependencies between
//   users and makes the system easier to maintain.
//   3. Direct communication between users.

}
