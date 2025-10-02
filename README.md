
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

<img width="1007" height="379" alt="Screenshot 2025-10-02 020429" src="https://github.com/user-attachments/assets/5e3d5077-60c0-4f1f-8f95-1b73e95a2130" />

## Observer Pattern : Live Score Notification System

**ScoreSubject.java**: Interface for subjects that can register and notify observers.

**LiveScore.java**: Concrete subject that maintains score and broadcasts updates to observers.

**ScoreObserver.java**: Interface for observers that receive updates from subjects.

**MobileDisplay.java**:Concrete observer that displays score updates on mobile devices.

**ScoreApp.java**: Main application that provides user interface for managing observers and score updates.

<img width="918" height="658" alt="Screenshot 2025-10-02 020724" src="https://github.com/user-attachments/assets/20ec9175-aa90-49aa-8828-dc37783324be" />

## *Creational Pattern*

## Builder Pattern : Course Builder System

**Course.java**: The product class with immutable properties built using the Builder pattern.

**Course.Builder.java**: Static inner builder class that constructs Course objects step-by-step.

**CourseInputHandler.java**: Handles user input and guides the course creation process.

**CourseManager.java**: Manages the collection of courses and coordinates the building process.

**CourseBuilderApplication.java**:  Main application that runs the course builder system.

<img width="985" height="706" alt="Screenshot 2025-10-02 021226" src="https://github.com/user-attachments/assets/c57e4297-06ba-4785-8ec8-b233f071cd85" />

## Singleton Pattern : Logger

**Logger.java**: Contains the singleton implementation for the logger class.

**Main.java**: Demonstrates the usage of the singleton logger and ensures only one instance is created.

<img width="906" height="206" alt="Screenshot 2025-10-02 021432" src="https://github.com/user-attachments/assets/51c0eeb1-6f1d-4c2e-b704-ab2f84bc4ddd" />

## *Structural Pattern*

## Bridge Pattern : Remote Control System

**Device.java**: Implementor interface defining operations that all devices must support.

**Television.java**: Concrete device implementor with TV-specific functionality.

**Radio.java**: Concrete device implementor with radio-specific functionality.

**RemoteControl.java**: Abstraction class defining the remote control interface.

**BasicRemote.java**: Concrete abstraction providing basic remote control operations.

**AdvancedRemote.java**: Extended abstraction with advanced features like mute and specific volume.

**RemoteControlDemo.java**: Main demo application showcasing bridge pattern with interactive menu.

<img width="1265" height="879" alt="Screenshot 2025-10-02 024500" src="https://github.com/user-attachments/assets/acb33cc2-b31c-4b8f-a208-883b06f3f2b7" />

## Adapter Pattern : Message System

**MessageSender.java**: Target interface that defines the standard messaging contract.

**SMSSender.java**: Modern service that natively implements the MessageSender interface.

**EmailService.java**: Adaptee class with legacy email interface that needs adaptation.

**EmailAdapter.java**: Adapter class that makes EmailService compatible with MessageSender.

**MessageDemo.java**: Demonstration application showcasing both adapted and modern services.

<img width="775" height="402" alt="Screenshot 2025-10-02 024752" src="https://github.com/user-attachments/assets/490cb9f8-6be5-4317-a113-4c19e10b10e1" />
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

<img width="980" height="409" alt="Screenshot 2025-10-02 025542" src="https://github.com/user-attachments/assets/f9322127-cb21-46ae-a38c-b88ad527ccec" />

**add_student**: Enrolls student in specified classroom.

<img width="746" height="99" alt="Screenshot 2025-10-02 025628" src="https://github.com/user-attachments/assets/c022ec9a-f753-4498-aeef-b70744480a90" />

**schedule_assignment**: Schedules new assignment for classroom.

<img width="892" height="92" alt="Screenshot 2025-10-02 025712" src="https://github.com/user-attachments/assets/7df94125-aad1-4c31-8a00-aa64bbe85975" />

**submit_assignment**: Submits assignment for specific student.

<img width="925" height="92" alt="Screenshot 2025-10-02 025736" src="https://github.com/user-attachments/assets/64322376-68ce-4db5-92a7-2adeab5a16da" />

**list_classrooms**: Displays all classrooms with statistics.

**list_students**: Shows students enrolled in a classroom.

**list_assignments**: Lists assignments for a classroom.

<img width="751" height="384" alt="Screenshot 2025-10-02 025929" src="https://github.com/user-attachments/assets/905fd398-0fa9-44db-9aed-eb7640b28070" />

