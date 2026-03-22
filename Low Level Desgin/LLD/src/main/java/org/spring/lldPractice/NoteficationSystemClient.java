package org.spring.lldPractice;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// ========================== 1. Notification Interface ==========================
// This interface defines a common contract for all types of notifications.
// Any new notification type (Email, SMS, Push, WhatsApp, etc.) must implement this.
// WHY?
// - Ensures uniform behavior
// - Enables polymorphism
// - Follows Open/Closed Principle (easy to extend)
interface Notification {
    String send(); // Each notification will define how it is sent
}

// ========================== 2. Email Implementation ==========================
// Concrete class implementing Notification interface
// Represents Email notification
class Email implements Notification {

    String text; // message content

    // Constructor to initialize email message
    public Email(String text){
        this.text = text;
    }

    // Implementation of send method
    // Returns formatted email message
    public String send(){
        return "Email -> " + text;
    }
}

// ========================== 3. SMS Implementation ==========================
// Concrete class for SMS notification
class SMS implements Notification {

    String text; // message content

    // Constructor to initialize SMS message
    public SMS(String text){
        this.text = text;
    }

    // Implementation of send method
    public String send(){
        return "SMS -> " + text;
    }
}

// ========================== 4. Notification Manager ==========================
// This class manages all notifications
// It acts like a container (similar to Document in previous example)
class NotificationManager {

    // List to store different types of notifications
    List<Notification> notificationList = new ArrayList<>();

    // Method to add notification (Email/SMS/etc.)
    // Uses polymorphism → accepts any Notification type
    public void addNotification(Notification notification){
        notificationList.add(notification);
    }

    // Sends all notifications and collects results
    public List<String> sendAll(){

        List<String> results = new ArrayList<>();

        // Loop through all notifications
        for(Notification n : notificationList){
            // Call send() → runtime polymorphism
            results.add(n.send());
        }

        return results; // return all responses
    }
}

// ========================== 5. Persistence Interface ==========================
// Defines how logs/data should be saved
// WHY?
// - Decouples storage logic
// - Allows multiple implementations (File, DB, Cloud)
interface Persistence {
    void save(String data);
}

// ========================== 6. File Storage Implementation ==========================
// Saves notification logs into a file
class FileStorage implements Persistence {

    public void save(String data) {
        try {
            // FileWriter writes data into file
            FileWriter outFile = new FileWriter("log.txt", true); // append mode
            outFile.write(data + "\n"); // write each log on new line
            outFile.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}

// ========================== 7. Notification Service ==========================
// This is the main controller/service layer
// It connects Manager and Persistence
// Uses Dependency Injection (DI)
class NotificationService {

    private NotificationManager manager; // handles notifications
    private Persistence persistence;     // handles storage

    // Constructor Injection (DI)
    // Dependencies are passed from outside instead of creating inside
    public NotificationService(NotificationManager manager, Persistence persistence){
        this.manager = manager;
        this.persistence = persistence;
    }

    // Main business logic method
    public void processNotifications(){

        // Step 1: Send all notifications
        List<String> results = manager.sendAll();

        // Step 2: Print and store results
        for(String res : results){
            System.out.println(res);  // display output
            persistence.save(res);    // save log
        }
    }
}

// ========================== 8. Client Class ==========================
// Entry point of the application
// Responsible for object creation and dependency injection
public class NoteficationSystemClient {

    public static void main(String[] args) {

        // Step 1: Create manager
        NotificationManager manager = new NotificationManager();

        // Step 2: Add different types of notifications
        manager.addNotification(new Email("Hello via Email"));
        manager.addNotification(new SMS("Hello via SMS"));

        // Step 3: Choose storage strategy (FileStorage / DBStorage etc.)
        Persistence persistence = new FileStorage();

        // Step 4: Inject dependencies into service (DI)
        NotificationService service = new NotificationService(manager, persistence);

        // Step 5: Process notifications
        service.processNotifications();
    }
}


// ========================== INTERVIEW POINTS ==========================

/*
1. Which design patterns are used?
   - Strategy Pattern → Persistence (FileStorage, DBStorage interchangeable)
   - Polymorphism → Notification interface (Email, SMS, etc.)
   - Dependency Injection → Constructor-based injection in NotificationService

2. SOLID Principles:
   - S (Single Responsibility): Each class has one job
   - O (Open/Closed): Can add new Notification without modifying existing code
   - L (Liskov Substitution): Email/SMS can replace Notification
   - I (Interface Segregation): Small interfaces (Notification, Persistence)
   - D (Dependency Inversion): Service depends on abstraction, not concrete class

3. Why use interface for Notification?
   - Enables extensibility
   - Avoids if-else conditions
   - Supports runtime polymorphism

4. Why Dependency Injection?
   - Loose coupling
   - Easy to switch implementations
   - Better unit testing

5. How to extend system?
   - Add new class: PushNotification implements Notification
   - Add new storage: DBStorage implements Persistence

6. What improvements can be added?
   - Retry mechanism for failed notifications
   - Async processing using threads
   - Priority-based notifications
   - Logging framework instead of FileWriter
   - Batch saving instead of per notification

7. Difference between Manager and Service?
   - Manager → Handles data collection and operations
   - Service → Orchestrates flow + integrates components

8. Real-world mapping:
   - Notification → Message system (Email/SMS/Push)
   - Manager → Queue/Buffer
   - Service → Backend service layer
   - Persistence → Logs/DB/Cloud storage

*/

/*
Client
  ↓
NotificationService  (DI)
  ↓
NotificationManager
  ↓
Notification (Email/SMS)
  ↓
Persistence (File/DB)




                +----------------------+
                |     Notification     |  <<interface>>
                +----------------------+
                | + send() : String    |
                +----------+-----------+
                           |
          ------------------------------------
          |                                  |
+-------------------+          +-------------------+
|       Email       |          |        SMS        |
+-------------------+          +-------------------+
| - text : String   |          | - text : String   |
+-------------------+          +-------------------+
| + send() : String |          | + send() : String |
+-------------------+          +-------------------+


                +-----------------------------+
                |   NotificationManager       |
                +-----------------------------+
                | - notificationList : List<> |
                +-----------------------------+
                | + addNotification()         |
                | + sendAll() : List<String>  |
                +-------------+---------------+
                              |
                              | uses
                              ↓
                +----------------------+
                |     Notification     |
                +----------------------+


                +----------------------+
                |     Persistence      | <<interface>>
                +----------------------+
                | + save(data:String)  |
                +----------+-----------+
                           |
                ------------------------
                |                      |
    +---------------------+   +----------------------+
    |    FileStorage      |   |      DBStorage       |
    +---------------------+   +----------------------+
    | + save(data)        |   | + save(data)         |
    +---------------------+   +----------------------+


                +-----------------------------+
                |    NotificationService      |
                +-----------------------------+
                | - manager : NotificationManager |
                | - persistence : Persistence     |
                +-----------------------------+
                | + processNotifications()    |
                +-------------+---------------+
                              |
                              | uses (DI)
                              ↓
        ----------------------------------------
        |                                      |
NotificationManager                   Persistence

 */

// ========================== INTERVIEW CROSS QUESTIONS ==========================

/*
Q1: Why use interface for Notification?
- Enables polymorphism
- Avoids if-else conditions
- Easy to extend (add new notification types)

Q2: Which design pattern is used in Persistence?
- Strategy Pattern (FileStorage, DBStorage interchangeable)

Q3: Where is Dependency Injection used?
- In NotificationService constructor
- Constructor Injection (best practice)

Q4: How to add new notification type?
- Create new class implementing Notification
- No change in existing code (Open/Closed Principle)

Q5: Why separate Manager and Service?
- Manager → handles collection
- Service → handles workflow & orchestration

Q6: What if sending fails?
- Add retry mechanism
- Maintain status (SUCCESS/FAILED)
- Use queue in real systems

Q7: How to make it async?
- Use threads / ExecutorService
- Process notifications in parallel

Q8: Limitations of current design?
- No error handling
- No batching for persistence
- Not scalable for large data

Q9: How to scale this system?
- Use message queues (Kafka, RabbitMQ)
- Microservices for each notification type
- Centralized logging

Q10: Why not call persistence in manager?
- Violates Single Responsibility Principle
- Manager should not handle storage


INTERVIEW PRO TIP:
"This design follows SOLID principles, uses dependency injection, and is easily extensible and scalable with async processing and message queues."
*/