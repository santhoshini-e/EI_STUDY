
# EI CODING ASSESSMENT
Name : Santhoshini E\
Roll Number : 224037\
College : KLN College of Engineering

# Exercise One : Design Patterns
## *Behavioural pattern*

## Chain of Responsibility Pattern : ATM Cash Dispenser System
**ATMDispenserService .java**: Main service that validates amounts and initiates the dispensing chain.

**DispenseChain.java**: Interface defining the contract for all handlers in the chain.

**Rupee2000Dispenser.java**: Handles dispensing of ₹2000 notes.

**Rupee500Dispenser.java**:
Handles dispensing of ₹500 notes.

**Rupee100Dispenser.java**: 
Handles dispensing of ₹100 notes.

**Currency.java**: 
Simple data class holding the amount to be dispensed.

**InvalidAmountException.java**: 
Custom exception for invalid withdrawal amounts.

**Main.java**: Entry point that runs the ATM simulation and handles user input.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20020429.png?raw=true)

## Observer Pattern : Live Score Notification System

**ScoreSubject.java**: Interface for subjects that can register and notify observers.

**LiveScore.java**: Concrete subject that maintains score and broadcasts updates to observers.

**ScoreObserver.java**: Interface for observers that receive updates from subjects.

**MobileDisplay.java**:Concrete observer that displays score updates on mobile devices.

**ScoreApp.java**: Main application that provides user interface for managing observers and score updates.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20020724.png?raw=true)

## *Creational Pattern*

## Builder Pattern : Course Builder System

**Course.java**: The product class with immutable properties built using the Builder pattern.

**Course.Builder.java**: Static inner builder class that constructs Course objects step-by-step.

**CourseInputHandler.java**: Handles user input and guides the course creation process.

**CourseManager.java**: Manages the collection of courses and coordinates the building process.

**CourseBuilderApplication.java**:  Main application that runs the course builder system.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20021226.png?raw=true)

## Singleton Pattern : Logger

**Logger.java**: Contains the singleton implementation for the logger class.

**Main.java**: Demonstrates the usage of the singleton logger and ensures only one instance is created.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20021432.png?raw=true)

## *Structural Pattern*

## Bridge Pattern : Remote Control System

**Device.java**: Implementor interface defining operations that all devices must support.

**Television.java**: Concrete device implementor with TV-specific functionality.

**Radio.java**: Concrete device implementor with radio-specific functionality.

**RemoteControl.java**: Abstraction class defining the remote control interface.

**BasicRemote.java**: Concrete abstraction providing basic remote control operations.

**AdvancedRemote.java**: Extended abstraction with advanced features like mute and specific volume.

**RemoteControlDemo.java**: Main demo application showcasing bridge pattern with interactive menu.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20024500.png?raw=true)

## Adapter Pattern : Message System

**MessageSender.java**: Target interface that defines the standard messaging contract.

**SMSSender.java**: Modern service that natively implements the MessageSender interface.

**EmailService.java**: Adaptee class with legacy email interface that needs adaptation.

**EmailAdapter.java**: Adapter class that makes EmailService compatible with MessageSender.

**MessageDemo.java**: Demonstration application showcasing both adapted and modern services.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20024752.png?raw=true)
<hr style="height:5px; border:none; background-color:#333;">

# Exercise Two : Virtual Classroom Manager Programming Exercise

## Overview

A comprehensive terminal-based classroom management system that enables educators to create virtual classrooms, enroll students, schedule assignments, and track submissions. This Java application provides a complete backend solution for educational institutions with robust validation, logging, and command-line interface for efficient classroom administration.

## Features

- Create and manage virtual classrooms with student enrollment tracking
- View classroom statistics including student counts and assignment details
- Enroll students using unique IDs across multiple classrooms
- Schedule and track assignments for specific classroom groups
- Provide comprehensive input validation and error handling
- Maintain activity logs and user-friendly command interface

## Design Patterns Used

**Command Pattern**: CommandService processes user commands through a unified interface

**Manager Pattern**: ClassroomManager centralizes business logic and data management

**DTO Pattern**: Assignment, Classroom, and Student act as data transfer objects

## Classes

### Model

**Classroom.java**: Represents a virtual classroom with students and assignments

**Student.java**: Manages student data, enrollments, and assignment submissions

**Assignment.java**: Stores assignment details with classroom association.

### Service

**ClassroomManager.java**: Main business logic handler for all operations.

**CommandService.java**: Processes and executes user commands.

**Assignment.java**: Validates all inputs and command formats.

### Utility

**Logger.java**: Provides timestamped logging for application activities.

**Constants.java**: Stores application constants and messages.

### Main Application

**VirtualClassroomManager.java**: Main application class that orchestrates the system.

## Commands

**add_classroom** : Creates a new virtual classroom.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20025542.png?raw=true)

**add_student**: Enrolls student in specified classroom.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20025628.png?raw=true)

**schedule_assignment**: Schedules new assignment for classroom.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20025712.png?raw=true)

**submit_assignment**: Submits assignment for specific student.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20025736.png?raw=true)

**list_classrooms**: Displays all classrooms with statistics.

**list_students**: Shows students enrolled in a classroom.

**list_assignments**: Lists assignments for a classroom.

![Description](https://github.com/santhoshini-e/images/blob/main/assets/Screenshot%202025-10-02%20025929.png?raw=true)