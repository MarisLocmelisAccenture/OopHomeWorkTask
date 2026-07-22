# GoF Patterns Demonstration - Mafia Chat System

## 📋 Application Overview

This is an educational demonstration of Gang of Four (GoF) design patterns using a creative Mafia-themed chat system.
The application showcases how different patterns work together to create flexible, maintainable code.

---

## 🎯 GoF Patterns Implemented

### 1. **MEDIATOR PATTERN** ✔️

**Location:** `service.MessageMediatorServiceImpl`

**Purpose:** Centralizes complex communication logic between multiple objects (chat members) to reduce coupling.

**Implementation:**

```
- Mediator (MessageMediatorServiceImpl):
  - Maintains a list of chat members
  - Routes messages from sender to eligible receivers
  - Controls access based on message type rules
  
- Participants (ChatMember):
  - Don't communicate directly with each other
  - Send messages through the mediator
  - Only know about the mediator, not other members
```

**Benefits:**

- Loose coupling between chat members
- Centralized message routing logic
- Easy to add new message rules or member types
- Single point of control for communication flow

---

### 2. **SINGLETON PATTERN** ✔️

**Location:** `service.MessageMediatorServiceImpl`

**Purpose:** Ensures only one instance of MessageMediatorService exists throughout the application.

**Implementation:**

```java
public static MessageMediatorServiceImpl getInstance() {
    if (instance == null) {
        instance = new MessageMediatorServiceImpl();
    }
    return instance;
}
```

**Benefits:**

- Guarantees single mediator for all members
- Prevents accidental creation of multiple mediators
- Thread-safe access to global communication hub
- Easy access from anywhere in the application

---

### 3. **FACTORY METHOD PATTERN** ✔️

**Location:** `factory.FactoryMethod`

**Purpose:** Creates different message types without exposing the creation logic to clients.

**Implementation:**

```java
public static Message createFromString(String message, boolean whisper) {
    if (whisper) {
        return new FriendWhisperMessage(message);
    }
    return new LaudMessage(message);
}
```

**Message Types:**

- `LaudMessage`: Public message, everyone can hear
- `FriendWhisperMessage`: Private message, only friends can hear (Bandit filtered out)

**Benefits:**

- Decouples message creation from usage
- Easy to add new message types
- Centralized instantiation logic
- Clients don't need to know message class names

---

### 4. **DECORATOR PATTERN** ✔️

**Location:** `member.Bandit` (extends `Friend`)

**Purpose:** Dynamically adds behavior to objects (notifying MafiaBoss) without modifying the original class.

**Implementation:**

```
Regular Friend:
  - Receives message
  - Stores it locally
  
Decorated Friend (Bandit):
  - Receives message
  - Forwards to MafiaBoss (additional behavior)
  - Stores it locally
```

**Benefits:**

- Adds functionality without modifying Friend class
- Can add/remove decorator dynamically
- Multiple decorators can be stacked
- Single Responsibility Principle maintained

---

### 5. **OBSERVER PATTERN** ✔️

**Location:** `member.MafiaBoss`

**Purpose:** Notifies observers about events without coupling them to the event source.

**Implementation:**

```
Subject (Bandit):
  - Performs actions
  - Notifies observers via observer method
  
Observer (MafiaBoss):
  - Listens to Bandit's actions
  - Collects information
  - Maintains list of stolen info
```

**Benefits:**

- Event-driven architecture
- Loose coupling between event source and observers
- Easy to add new observers
- No observer needs to know about other observers

---

## 🎨 Application Flow

### Example 1: Mediator + Singleton

```
Maris → [sends public message] → Mediator → [routes to eligible receivers]
                                    ↓
                          ┌─────────┼─────────┐
                          ↓         ↓         ↓
                       Bandit    Friend    (Maris excluded)
```

### Example 2: Observer

```
Bandit receives message → [Decorator triggers] → MafiaBoss.provideInfo()
                                                   ↓
                                        MafiaBoss observes event
                                        & collects information
```

### Example 3: Decorator + Factory

```
FactoryMethod.create() → Creates LaudMessage/FriendWhisperMessage
                            ↓
                    Bandit receives (Decorated)
                    ├→ Forwards to MafiaBoss
                    └→ Stores locally
                    
                    Friend receives (Regular)
                    └→ Stores locally
```

---

## 🚀 Key Improvements Made

### 1. **Enhanced Logging System**

Created `util.PatternLogger` with color-coded output:

- **Yellow** `↔` : Mediator routing
- **Purple** `👁`: Observer notifications
- **Purple** `🎭`: Decorator behavior
- **Cyan** `⚙`: Factory creation
- **Green** `←/→`: Message sending/receiving
- **Blue** `🔷`: Pattern information

### 2. **Clear Pattern Identification**

- Each example clearly labels which patterns are demonstrated
- Pattern descriptions explain their purpose
- Visual section headers for better organization

### 3. **Better Output Clarity**

- Member names displayed clearly (Maris, Friend, Bandit, Boss)
- Message types explicitly shown
- Filter rejections logged with explanations
- Call stack visualization with visual separators

### 4. **User Experience Improvements**

- Structured sections with visual boxes
- Color-coded output for pattern types
- Informative status messages
- Clear cause-and-effect relationships shown

---

## 📊 Pattern Interaction Matrix

| Pattern   | Used In       | Purpose          | Interacts With     |
|-----------|---------------|------------------|--------------------|
| Mediator  | Service layer | Route messages   | All members        |
| Singleton | Mediator      | Single instance  | Mediator           |
| Factory   | Main app      | Create messages  | Message types      |
| Decorator | Bandit        | Add behavior     | Observer, Message  |
| Observer  | MafiaBoss     | Listen to events | Decorator, Message |

---

## 🔄 Message Flow Sequence

```
1. Create messages via Factory
   └─→ LaudMessage or FriendWhisperMessage
   
2. Members send through Mediator
   └─→ Mediator routes based on message type rules
   
3. Receivers are notified
   ├─→ Regular members store message
   └─→ Decorated members forward to observers
   
4. Observers collect information
   └─→ MafiaBoss maintains list
```

---

## 💡 Learning Outcomes

By studying this application, you'll understand:

✅ How Mediator reduces coupling between components  
✅ Why Singleton ensures single point of access  
✅ How Factory encapsulates object creation  
✅ How Decorator adds behavior dynamically  
✅ How Observer implements event notification  
✅ How patterns work together in a real system  
✅ Best practices for logging and visibility

---

## 🎓 Extension Ideas

The patterns can be extended to:

- Add more message types (SecretMessage, BroadcastMessage)
- Add more observers (Police, Informant)
- Implement message encryption/decryption
- Add message history and logging
- Create role-based access control
- Implement message acknowledgment system

---

Generated by: PatternLogger with enhanced GoF Pattern Demonstration
Version: 1.0 - Enhanced with better clarity and visibility
