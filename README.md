Project Overview

The Hospital Appointment Management System is a console-based, menu-driven application developed using Core Java, JDBC, and MySQL.
It helps manage hospital appointments by allowing patients to book appointments and administrators to view, search, and cancel appointment records efficiently.

Features:
Book new hospital appointments
View all appointments
Search appointments by doctor name
Cancel appointments
Data stored persistently using MySQL

Technologies Used:
Programming Language: Java (Core Java)
Database: MySQL
Connectivity: JDBC
IDE: Eclipse
Version Control: Git, GitHub

Project Architecture:
The project follows a layered architecture:
HospitalAppointment
│
├── DBConnection.java
├── AppointmentDTO.java
├── AppointmentDAO.java
├── AppointmentDAOImpl.java
├── AppointmentService.java
├── HospitalMain.java

DTO (Data Transfer Object): Holds appointment data
DAO (Data Access Object): Handles database operations
Service Layer: Contains business logic
Main Class: Handles user interaction and menu


Database Structure:
Database Name
hospital_db

Table: appointments
CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(50),
    doctor_name VARCHAR(50),
    department VARCHAR(50),
    appointment_date DATE,
    appointment_time TIME
);

How to Run the Project:
Clone the repository:
git clone https://github.com/Neethu-14/HospitalAppointmentSystem.git
Open the project in Eclipse.
Add MySQL Connector/J to the project build path.
Create the database and table in MySQL.
Update database credentials in DBConnection.java.
Run HospitalMain.java.

Sample Output:
1. Book Appointment
2. View Appointments
3. Search by Doctor
4. Cancel Appointment
5. Exit

Learning Outcomes:
Understanding of JDBC and database connectivity
Hands-on experience with MySQL
Implementation of layered architecture
Improved knowledge of Core Java concepts

Author:
Neethu Chauhan
GitHub: https://github.com/Neethu-14
