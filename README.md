# Student Management System

A web-based Student Management System developed using Spring Boot, JSP, JPA, Hibernate, and MySQL. This application helps administrators manage student records, enroll students, track fee payments, search students by batch, and update batch information.

## Features

- Admin Login Authentication
- Student Enrollment
- View All Students
- Search Students by Batch Number
- Update Student Fee Payments
- Shift Students Between Batches
- Remove Student Records
- MySQL Database Integration
- JSP-Based User Interface

## Technologies Used

- Java 17
- Spring Boot 3.4.3
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL
- JSP
- JSTL
- Bootstrap 5
- Maven

## Project Structure

```
src
├── main
│   ├── java
│   │   └── edu.cjc.main
│   │       ├── controller
│   │       ├── model
│   │       ├── repository
│   │       ├── service
│   │       └── serviceImpl
│   ├── resources
│   │   └── application.properties
│   └── webapp
│       └── WEB-INF
│           └── jsp
```

## Database Configuration

Create a MySQL database named:

```sql
CREATE DATABASE StudentManagement;
```

Update the database credentials in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/StudentManagement
spring.datasource.username=root
spring.datasource.password=your_password
```

## Default Login Credentials

```text
Username: admin
Password: admin
```

## Student Information Managed

- Student ID
- Full Name
- Email
- Age
- College Name
- Course
- Batch Number
- Batch Mode
- Fees Paid

## Setup and Run

### Clone Repository

```bash
git clone https://github.com/your-username/Student-Management-System.git
```

### Navigate to Project

```bash
cd StudentManagement
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

### Open Browser

```text
http://localhost:8080
```

## Screens Available

### Login Page
- Admin authentication

### Student Enrollment
- Register new students

### Student Dashboard
- View all students
- Search by batch
- Remove students

### Fee Management
- Add installment payments

### Batch Management
- Shift students to another batch

## Future Enhancements

- Role-based Authentication
- Student Login Module
- Spring Security Integration
- Email Notifications
- Dashboard Analytics
- REST API Support
- Fee Due Tracking
- Pagination and Sorting

## Learning Outcomes

This project demonstrates:

- MVC Architecture
- Spring Boot Application Development
- Database Connectivity using JPA
- CRUD Operations
- Form Handling using JSP
- Layered Architecture (Controller-Service-Repository)
- Maven Project Management

## License

This project is developed for learning and academic purposes.
