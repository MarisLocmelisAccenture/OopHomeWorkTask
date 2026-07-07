# GoF Patterns - Visual Architecture

## Application Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────────┐
│                      PATTERNS APPLICATION                           │
│                                                                     │
│  ┌────────────────────────────────────────────────────────────┐    │
│  │                   PATTERN EXAMPLES                         │    │
│  │                                                            │    │
│  │  Example 1: Mediator + Singleton                          │    │
│  │  Example 2: Observer Pattern                              │    │
│  │  Example 3: Decorator + Factory                           │    │
│  └────────────────────────────────────────────────────────────┘    │
│                                                                     │
└─────────────────────────────────────────────────────────────────────┘
```

## 1. MEDIATOR PATTERN - Message Routing

```
┌─────────────────────────────────────────────────────────────┐
│                  Message Sender                              │
│                 (ChatMember)                                 │
│                  │ message.send()                            │
│                  ▼                                           │
│   ┌─────────────────────────────────────┐                   │
│   │  MEDIATOR SERVICE                   │                   │
│   │  (MessageMediatorServiceImpl)         │                   │
│   │                                     │                   │
│   │  - Maintains member list            │                   │
│   │  - Routes messages                  │                   │
│   │  - Enforces access rules            │                   │
│   └─────────────────────────────────────┘                   │
│          ▲    ▲    ▲                                        │
│          │    │    │ message.receive()                      │
│          ▼    ▼    ▼                                        │
│       Maris Friend Bandit                                   │
│    (Receivers)                                              │
│                                                             │
│  Access Rules (enforced by message type):                   │
│  - LaudMessage: Everyone receives                           │
│  - FriendWhisperMessage: Blocked from Bandit               │
└─────────────────────────────────────────────────────────────┘
```

## 2. SINGLETON PATTERN - Single Instance

```
┌──────────────────────────────────────────────────────────┐
│         MessageMediatorServiceImpl                        │
│                                                          │
│  - private static instance                              │
│  - private constructor()                                │
│  - public static getInstance()                          │
│                                                          │
│  ╔══════════════════════════════════════════════════╗   │
│  ║ GUARANTEES:                                      ║   │
│  ║ - Only ONE instance exists                       ║   │
│  ║ - All members use SAME mediator                  ║   │
│  ║ - Global access point                            ║   │
│  ╚══════════════════════════════════════════════════╝   │
│                                                          │
│  getInstance() → Returns same instance always           │
└──────────────────────────────────────────────────────────┘
```

## 3. FACTORY METHOD PATTERN - Object Creation

```
┌────────────────────────────────────────────────────────────┐
│            FactoryMethod.createFromString()                │
│                                                            │
│   Input: (String message, boolean whisper)               │
│                                                            │
│   ┌──────────────────────────────────────────┐            │
│   │  if (whisper == true)                    │            │
│   │    ↓ Creates:                            │            │
│   │  FriendWhisperMessage                    │            │
│   │    - Can only be received by Friends     │            │
│   └──────────────────────────────────────────┘            │
│                                                            │
│   ┌──────────────────────────────────────────┐            │
│   │  else (whisper == false)                 │            │
│   │    ↓ Creates:                            │            │
│   │  LaudMessage                             │            │
│   │    - Can be received by Everyone         │            │
│   └──────────────────────────────────────────┘            │
│                                                            │
│  CLIENT CODE: Don't know class names!                    │
│  Just call: FactoryMethod.createFromString()            │
└────────────────────────────────────────────────────────────┘
```

## 4. DECORATOR PATTERN - Dynamic Behavior Addition

```
┌─────────────────────────────────────────────────────────────┐
│                    DECORATOR PATTERN                        │
│                                                             │
│   Regular Friend:                                          │
│   ┌──────────────────────────────────────────────┐         │
│   │ receive(message)                             │         │
│   │   ├─ Print: "Friend received message"        │         │
│   │   └─ Store message locally                   │         │
│   └──────────────────────────────────────────────┘         │
│                                                             │
│   VS                                                        │
│                                                             │
│   Decorated Friend (Bandit):                               │
│   ┌──────────────────────────────────────────────┐         │
│   │ receive(message)                   [WRAPPER] │         │
│   │   ├─ Print: "Bandit received message"        │         │
│   │   ├─ Forward to MafiaBoss  ◄─── ADDED      │         │
│   │   ├─ Print: "Shared with Boss"  ◄─── ADDED│         │
│   │   └─ Store message locally                   │         │
│   └──────────────────────────────────────────────┘         │
│                                                             │
│  Key Insight:                                              │
│  - Bandit EXTENDS Friend (inherits all methods)           │
│  - Bandit OVERRIDES receive() (adds behavior)             │
│  - Original Friend class NOT MODIFIED                     │
│  - Behavior added at runtime                              │
└─────────────────────────────────────────────────────────────┘
```

## 5. OBSERVER PATTERN - Event Notification

```
┌─────────────────────────────────────────────────────────────┐
│                    OBSERVER PATTERN                         │
│                                                             │
│              Subject (Event Source)                         │
│                                                             │
│         ┌─────────────────────────────────────┐            │
│         │            Bandit                   │            │
│         │  (Decorated Friend)                 │            │
│         │                                     │            │
│         │  receive(message) {                 │            │
│         │    boss.provideInfo(message)        │            │
│         │          ↓ NOTIFIES                 │            │
│         │  }                                  │            │
│         └─────────────────────────────────────┘            │
│                       ▲                                     │
│                       │ (Subject notifies)                  │
│                       ▼                                     │
│         ┌─────────────────────────────────────┐            │
│         │  Observer: MafiaBoss                │            │
│         │                                     │            │
│         │  provideInfo(String info) {         │            │
│         │    stolenInfo.add(info)             │            │
│         │    System.out.println(...)          │            │
│         │  }                                  │            │
│         │                                     │            │
│         │  Maintains: List<String>            │            │
│         │  stolenInfo                         │            │
│         └─────────────────────────────────────┘            │
│                                                             │
│  Benefits:                                                  │
│  - Loose coupling (Bandit doesn't know MafiaBoss type)    │
│  - Multiple observers can be attached                      │
│  - Observers don't interfere with each other              │
└─────────────────────────────────────────────────────────────┘
```

## Pattern Interactions - Complete Flow

```
START: Main Application
   │
   ├─→ Get Singleton Mediator
   │   └─→ MessageMediatorServiceImpl.getInstance()
   │       (Returns SAME instance every time)
   │
   ├─→ Create Members
   │   ├─→ new Maris(mediator)
   │   ├─→ new Friend(mediator)  
   │   └─→ new Bandit(mediator, boss)
   │       All REGISTER with mediator
   │
   ├─→ Create Message (Factory)
   │   ├─→ FactoryMethod.createFromString(text, false)
   │   │   └─→ New LaudMessage(text)
   │   └─→ FactoryMethod.createFromString(text, true)
   │       └─→ New FriendWhisperMessage(text)
   │
   ├─→ Send Message
   │   ├─→ sender.send(message)
   │   │   └─→ mediator.send(message, sender)
   │   │       ├─→ Filter receivers by message type
   │   │       └─→ Call receive() on eligible receivers
   │   │
   │   └─→ message.canReceive(receiver)
   │       ├─→ LaudMessage: Always true
   │       └─→ FriendWhisperMessage: 
   │           Returns !(receiver instanceof Bandit)
   │
   ├─→ Receive in Regular Member
   │   └─→ Friend.receive(message)
   │       └─→ Store in messages list
   │
   └─→ Receive in Decorated Member
       └─→ Bandit.receive(message)
           ├─→ Call boss.provideInfo(message)  [DECORATOR]
           │   └─→ MafiaBoss.provideInfo()    [OBSERVER]
           │       └─→ Add to stolenInfo list
           └─→ Store in messages list
```

## Message Type Decision Tree

```
Message created via Factory
         │
         ├─ LaudMessage (public)
         │  │
         │  ├─→ Can Maris receive? YES ✓
         │  ├─→ Can Friend receive? YES ✓
         │  └─→ Can Bandit receive? YES ✓
         │
         └─ FriendWhisperMessage (private to friends)
            │
            ├─→ Can Maris receive? YES ✓
            ├─→ Can Friend receive? YES ✓
            └─→ Can Bandit receive? NO ✗ (filtered out)
```

## Class Hierarchy

```
ChatMember [Interface]
    ▲
    │
AbstractChatMember [Abstract]
    │
    ├── Maris
    │
    ├── Friend
    │   │
    │   └── Bandit [Decorated Friend]
    │
    └── MafiaBoss [Observer]


Message [Interface]
    ├── LaudMessage [Public]
    └── FriendWhisperMessage [Private to Friends]
```

## Output with Enhanced PatternLogger

```
Each execution now shows:

✓ Section headers with visual boxes
✓ Pattern identification with emoji
✓ Clear member names (not full class names)
✓ Message types in parentheses
✓ Action flow with visual indicators
✓ Filter rejections with explanations
✓ Observer notifications highlighted
✓ Decorator behavior highlighted
✓ Factory creation details
✓ Color-coded by pattern type
```

---

**Legend:**
- ✓ = Action performed
- ✗ = Action rejected
- → = Flow direction
- ↔ = Bidirectional communication
- ▲ = Inheritance/generalization
- ◄ = Addition/enhancement
