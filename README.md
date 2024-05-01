# Backend Patient Record System

This is a Java-based web application using the Spring Boot framework and Maven for dependency management. It's a patient record system, which allows managing patients, their medical histories, and appointments.

## Project Structure

- src/main/java/org/example/backendpatientsrecordsystem/controllers: This directory contains the controller classes which handle HTTP requests.

- src/main/java/org/example/backendpatientsrecordsystem/service: This directory contains the service classes which contain the business logic of the application. The services include PatientService, MedicalHistoryService, and AppointmentService.

- src/main/java/org/example/backendpatientsrecordsystem/models: This directory contains the model classes which represent the entities in the system. The models include Patient, MedicalHistory, and Appointment.

- src/main/java/org/example/backendpatientsrecordsystem/repositories: This directory contains the repository interfaces for accessing the database.

- src/main/java/org/example/backendpatientsrecordsystem/exceptions: This directory contains custom exceptions used in the project.

## Services

- PatientService: Contains business logic related to patients. It includes methods for adding or updating a patient, getting a patient by ID, deleting a patient by ID, and getting all patients.

- MedicalHistoryService: Contains business logic related to medical histories. It includes methods for getting a medical history by ID, adding or updating a medical history, deleting a medical history by ID, and getting a list of medical histories by patient ID.

- AppointmentService: Contains business logic related to appointments. It includes methods for getting a list of appointments by patient ID, getting an appointment by ID, adding or updating an appointment, and deleting an appointment by ID.

## Technologies Used

- Java
- Spring Boot
- Maven
- JPA (Java Persistence API)
- Lombok

## Setup

To run this project, you will need to have Java and Maven installed on your machine. You can then clone the repository and run the application using the following command:

```bash
mvn spring-boot:run
```

## Project Tree Structure
```
backendpatientsrecordsystem
├── src
│   └── main
│       └── java
│           └── org
│               └── example
│                   └── backendpatientsrecordsystem
│                       ├── controllers
│                       │   ├── PatientController.java
│                       │   ├── AppointmentController.java
│                       │   └── MedicalHistoryController.java
│                       ├── service
│                       │   ├── PatientService.java
│                       │   ├── AppointmentService.java
│                       │   └── MedicalHistoryService.java
│                       ├── models
│                       │   ├── Patient.java
│                       │   ├── Appointment.java
│                       │   └── MedicalHistory.java
│                       ├── repositories
│                       │   ├── PatientRepository.java
│                       │   ├── AppointmentRepository.java
│                       │   └── MedicalHistoryRepository.java
│                       └── exceptions
│                           ├── PatientNotFoundException.java
│                           ├── AppointmentNotFoundException.java
│                           └── MedicalHistoryNotFoundException.java
└── pom.xml
```
