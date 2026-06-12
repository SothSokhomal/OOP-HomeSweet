# Week 8 Report: Polymorphism in HomeSweet Rental System

## 1. Project Information
* **Project Name**: HomeSweet Rental App System
* **Course Code**: OOP (Object-Oriented Programming)
* **Academic Week**: Week 8
* **Topic**: Polymorphism (Inheritance-based & Interface-based)
* **Team Name**: SothSokhomal / OOP-HomeSweet

---

## 2. Introduction to Polymorphism

### Definition of Polymorphism
Polymorphism originates from the Greek words *poly* (many) and *morph* (form), meaning "many forms." In Java, polymorphism refers to the ability of an object or a reference variable to take on multiple forms. It allows a parent class reference or an interface type to point to any of its subclass objects or implementing class instances.

### Connection to Inheritance and Overriding
Polymorphism does not exist in isolation; it builds directly upon **Inheritance** and **Method Overriding**:
1. **Inheritance**: Establishes an "is-a" relationship between a superclass (e.g., `Person`) and its subclasses (e.g., `Student`, `Landlord`, `Admin`). This relationship allows subclass objects to be referenced by a superclass reference type.
2. **Method Overriding**: Subclasses provide their own specific implementation of a method that is already defined in the superclass (e.g., `displayInfo()` and `performRole()`). The method signature remains identical, but the behavior changes.
3. **Dynamic Method Binding**: When an overridden method is called via a superclass reference, Java determines which method to execute at **runtime** (not compile-time) based on the actual type of the concrete object being referenced. This is the heart of runtime polymorphism.

---

## 3. Polymorphism in Action: Code Evidence

### Task 1: Subclass Polymorphism with `Person`
In our system, `Person` is the superclass, and `Student`, `Landlord`, and `Admin` are subclasses. Each subclass overrides `displayInfo()` and `performRole()`.

**Reference Code Evidence:**
* **Superclass**: [Person.java](file:///Users/rose/Documents/OOP-HomeSweet/model/Person.java#L85-L95)
  ```java
  public class Person implements Displayable {
      // ...
      @Override
      public void displayInfo() {
          System.out.println("ID           : " + id);
          System.out.println("Name         : " + name);
          System.out.println("Email        : " + email);
          System.out.println("Phone Number : " + phoneNumber);
      }

      public void performRole() {
          System.out.println(name + " is performing a general role.");
      }
  }
  ```
* **Subclass Student**: [Student.java](file:///Users/rose/Documents/OOP-HomeSweet/model/Student.java#L66-L77)
  ```java
  public class Student extends Person {
      // ...
      @Override
      public void displayInfo() {
          super.displayInfo();
          System.out.println("National ID  : " + nationalId);
          System.out.println("Contracts    : " + contracts.size());
      }

      @Override
      public void performRole() {
          System.out.println("Student " + getName() + " is viewing houses and managing bills.");
      }
  }
  ```
* **Subclass Landlord**: [Landlord.java](file:///Users/rose/Documents/OOP-HomeSweet/model/Landlord.java#L109-L129)
  ```java
  public class Landlord extends Person {
      // ...
      @Override
      public void displayInfo() {
          super.displayInfo();
          System.out.println("Address      : " + address);
          System.out.println("National ID  : " + nationalID);
          System.out.println("Verified     : " + isVerified);
          System.out.println("Active       : " + isActive);
          System.out.println("Total Houses : " + houses.size());
      }

      @Override
      public void performRole() {
          System.out.println("Landlord " + getName() + " is adding properties and generating reports.");
      }
  }
  ```
* **Subclass Admin**: [Admin.java](file:///Users/rose/Documents/OOP-HomeSweet/model/Admin.java#L191-L206)
  ```java
  public class Admin extends Person {
      // ...
      @Override
      public void displayInfo() {
          System.out.println("\n========== Admin Summary ==========");
          super.displayInfo();
          System.out.println("Students     : " + students.size());
          System.out.println("Landlords    : " + landlords.size());
          System.out.println("Houses       : " + houses.size());
          System.out.println("Contracts    : " + contracts.size());
          System.out.println("Payments     : " + payments.size());
          System.out.println("===================================");
      }

      @Override
      public void performRole() {
          System.out.println("Admin " + getName() + " is managing the entire HomeSweet system.");
      }
  }
  ```

### Task 2: Interface Polymorphism with `Displayable`
The `Displayable` interface requires implementing classes to define `displayInfo()`. In our project, `Person` (and thus its subclasses `Student`, `Landlord`, `Admin`), `House`, `Contract`, and `Payment` all implement `Displayable`.

* **Interface**: [Displayable.java](file:///Users/rose/Documents/OOP-HomeSweet/interfaces/Displayable.java)
  ```java
  package interfaces;

  public interface Displayable {
      void displayInfo();
  }
  ```
* **Implementing Classes**:
  * `Person` (covers `Student`, `Landlord`, `Admin`)
  * `House` (overrides `displayInfo()` to output property details)
  * `Contract` (overrides `displayInfo()` to print agreement details)
  * `Payment` (overrides `displayInfo()` to print transaction details)

### Task 3: Interface Polymorphism with `StatusManageable`
The `StatusManageable` interface tracks stateful classes. The classes `House`, `Contract`, and `Payment` implement `StatusManageable` and provide concrete implementations for `getStatusText()` and `displayStatus()`.

* **Interface**: [StatusManageable.java](file:///Users/rose/Documents/OOP-HomeSweet/interfaces/StatusManageable.java)
  ```java
  package interfaces;

  public interface StatusManageable {
      String getStatusText();
      void displayStatus();
  }
  ```

---

## 4. Why Polymorphism makes HomeSweet Flexible & Scalable

Polymorphism makes our codebase resilient to change and easy to extend. 

**Example Case: Adding a new user type "Agent"**
Without polymorphism, if we wanted to introduce a new user role (like `Agent`), we would have to rewrite loops, search methods, and tables to explicitly support agents (e.g., creating a separate `ArrayList<Agent>`, writing distinct loops, and updating output logic).

With polymorphism:
1. We define `Agent extends Person`.
2. We override `displayInfo()` and `performRole()` inside `Agent`.
3. The rest of the application handles `Agent` implicitly. Any list of type `Person` (e.g., `ArrayList<Person> users`) can immediately store an `Agent` object.
4. Calling `user.displayInfo()` or `user.performRole()` will automatically trigger the `Agent`-specific logic. We do **not** need to change a single line of the main execution code or logic loops.

---

## 5. Output Verification Log (Polymorphism Test Section)

Running Option 3: **Run Week 8 Polymorphism Tests** executes the polymorphic loops and displays the following results:

```text
========== Week 8 Polymorphism Test ==========

--- Task 1: Subclass/Superclass Polymorphism (Person) ---
ID           : 7
Name         : Dara
Email        : dara@gmail.com
Phone Number : 0123456789
National ID  : 12345678901234
Contracts    : 0
Student Dara is viewing houses and managing bills.
----------------------------------------------
ID           : 8
Name         : Sokha
Email        : sokha@gmail.com
Phone Number : 0112233445
Address      : Phnom Penh
National ID  : 12345678901234
Verified     : true
Active       : true
Total Houses : 0
Landlord Sokha is adding properties and generating reports.
----------------------------------------------

========== Admin Summary ==========
ID           : 9
Name         : Admin
Email        : admin@gmail.com
Phone Number : 0987654321
Students     : 0
Landlords    : 0
Houses       : 0
Contracts    : 0
Payments     : 0
===================================
Admin Admin is managing the entire HomeSweet system.
----------------------------------------------

--- Task 2: Interface Polymorphism (Displayable) ---
ID           : 7
Name         : Dara
Email        : dara@gmail.com
Phone Number : 0123456789
National ID  : 12345678901234
Contracts    : 0
----------------------------------------------
ID           : 8
Name         : Sokha
Email        : sokha@gmail.com
Phone Number : 0112233445
Address      : Phnom Penh
National ID  : 12345678901234
Verified     : true
Active       : true
Total Houses : 0
----------------------------------------------

========== Admin Summary ==========
ID           : 9
Name         : Admin
Email        : admin@gmail.com
Phone Number : 0987654321
Students     : 0
Landlords    : 0
Houses       : 0
Contracts    : 0
Payments     : 0
===================================
----------------------------------------------
House ID     : 5
Address      : 789 Test Rd
City         : Siem Reap
Monthly Rent : $400.0
Status       : Available
Landlord     : Sokha
Landlord Tel : 0112233445
----------------------------------------------
Contract ID  : 5
Student      : Dara
House        : 789 Test Rd
Period       : 2026-07-01 to 2027-07-01
Value        : $400.0
Status       : PENDING
Landlord     : Sokha
----------------------------------------------
Payment ID   : 5
Amount       : $400.0
Payment Method: Default
Status       : PENDING
Contract ID  : 5
Student      : Dara
House        : 789 Test Rd
----------------------------------------------

--- Task 3: Interface Polymorphism (StatusManageable) ---
House Status: Available
----------------------------------------------
Contract Status: PENDING
----------------------------------------------
Payment Status: PENDING
----------------------------------------------
```

---

## 6. Problems Fixed & Enhancements (Task 4)

We successfully refactored the Week 7 problems before testing polymorphism:
1. **Rental Logic Consolidation**: Moved the scattered rental logic from `Contract.java` and `HomeSweetMain.java` into the dedicated [RentalService.java](file:///Users/rose/Documents/OOP-HomeSweet/model/RentalService.java) class. This follows clean separation of concerns.
2. **Missing Overloaded Method**: Ensured `search(double minPrice, double maxPrice)` in [HouseService.java](file:///Users/rose/Documents/OOP-HomeSweet/model/HouseService.java) has the exact parameter signature, compiling and running flawlessly.
3. **No Redundant Overloaded Declarations**: Ensured that the documentation describes only the real overloaded methods present in our code.

---

## 7. Limitations & Plan for Next Week

### Problems or Limitations
* **Services Dependency**: While `RentalService` handles the rental transaction cleanly, it directly interacts with mutable collection parameter inputs. In a larger production app, services should manage their own repositories or DAO layers rather than passing lists.
* **Manual Seed Syncing**: High coupling between the `Admin` class holding physical arrays of data (`students`, `landlords`, etc.) and the service classes holding lists. This requires manually updating both lists during seeding.

### What to Improve Next Week
* **Data Persistence**: Currently, all registered students, landlords, contracts, and payments are stored in memory and reset on exit. Next week, we plan to implement file persistence (e.g., CSV/JSON serialization or JDBC) to make the data permanent.
* **Abstract Base Classes**: Refine common parent classes (e.g., changing some concrete classes to `abstract` where it makes architectural sense, like `Person` if we never want direct instantiation of generic people).
