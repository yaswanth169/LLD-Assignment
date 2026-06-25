package org.assignment2.problem9;

public class Accesscontrolsystem {

//    Requirements:
//    1. Resources:
//          Document
//          Report
//          Settings
//    2. Actions:
//          READ
//          WRITE
//          DELETE
//          ADMIN
//    3. Roles:
//          Viewer
//          Editor
//          Admin
//    4. Users can have
//       multiple roles.
//    5. Support
//          authorize()
//    6. Support role hierarchy.
//          Admin
//              ↓
//          Editor
//              ↓
//          Viewer
//    7. Add/Remove roles at runtime.
//    8. Print effective permissions.


//    My initial thinking is:
//    Suppose I directly write everything inside AccessControl.

//    class AccessControl{
//        authorize(){}
//        if(role.equals("Viewer")){}
//        if(role.equals("Editor")){}
//        if(role.equals("Admin")){}
//    }
//
//    Initially this works. But tomorrow if they ask me to add
//          Manager
//          Auditor
//          SuperAdmin
//    I need to modify AccessControl again. It slowly becomes responsible for everything.


//    Problems with this approach:
//    1. Large if-else blocks for every role.
//    2. AccessControl knows every role. This violates Open Closed Principle.


//    If I observe carefully, the changing parts are:
//          Roles
//              Viewer
//              Editor
//              Admin
//              Manager
//              Auditor
//          Permissions
//              READ
//              WRITE
//              DELETE
//              ADMIN These can keep increasing.
//    The stable parts are:
//          User
//          Resource
//          Permission
//    Since every role has permissions and can inherit another role, Composite Pattern fits well.


//    Instead of AccessControl knowing every role, I can create
//    class Role{
//          name
//          permissions
//          parentRole
//    }
//
//    Every user simply stores assigned roles. Permission checking happens through Role.


//    Relationship:
//    User HAS-A List<Role>
//    Role HAS-A List<Permission>
//    Role HAS-A Parent Role


//    Runtime Flow:

//    Client
//    authorize()
//    Get User
//    Get Assigned Roles
//    Traverse Parent Roles
//    Collect Permissions
//    Permission Found ?
//          YES
//          Allow
//          NO
//          Deny

// Q1. How do you check inherited roles?
// Traverse parent roles until no parent exists.


// Q2. What if inheritance forms a diamond?
// Use a Set to avoid duplicate permissions.

// Q3. What if Deny rules are introduced?
// Permission model needs to support both Allow and Deny rules.

// Q4. User has two roles with conflicting permissions?
// Resolve using predefined priority (for example, Deny overrides Allow).

// Q5. printEffectivePermissions() cache or compute?
// Compute on demand or cache based on application needs.

}
