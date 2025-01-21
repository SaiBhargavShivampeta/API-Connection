# API Connection

## Overview
The **Employee Management System** is a web-based application that allows users to search, filter, and manage employee records. It provides functionality to search employees by their unique ID or within a specific joining date range. The application is built using a **Spring Boot backend** and a **React frontend**, ensuring a robust and interactive experience.

---

## Features
- Search employees by their unique Employee ID.
- Filter employees based on their joining date range.
- Display a list of employees with their details.
- Seamless interaction between the backend (REST API) and frontend.
- Responsive and user-friendly UI.

---

## Technologies Used
### Backend
- **Spring Boot** (REST API)
- **Java 17+**
- **H2 Database** (or any relational database, configurable)
- **Maven** (for dependency management)

### Frontend
- **React** (with functional components and hooks)
- **CSS** (for styling)

### Tools
- **Postman** (for API testing)
- **Git** (version control)
- **VS Code / IntelliJ IDEA** (development environment)

---

## Project Structure

### Backend
employee-management-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/example/employee/
│   │   │   │   ├── controller/
│   │   │   │   │   └── EmployeeController.java          # Handles API endpoints
│   │   │   │   ├── model/
│   │   │   │   │   └── Employee.java                   # Employee entity class
│   │   │   │   ├── repository/
│   │   │   │   │   └── EmployeeRepository.java         # Interface for DB operations
│   │   │   │   └── EmployeeManagementApplication.java  # Main Spring Boot application
│   │   ├── resources/
│   │   │   ├── application.properties                  # Configuration properties
│   │   │   └── data.sql                                # (Optional) Sample data for testing
├── pom.xml                                             # Maven dependencies and build configuration

### Frontend
employee-management-frontend/
├── public/                                             # Static files and assets
│   ├── index.html                                      # Main HTML file
│   └── favicon.ico                                     # App icon
├── src/
│   ├── components/
│   │   ├── EmployeeList.js                             # Component to display employee list
│   │   ├── EmployeeSearchById.js                      # Component to search by Employee ID
│   │   ├── EmployeeSearchByDateRange.js               # Component to search by date range
│   ├── App.js                                          # Main app component
│   ├── index.js                                        # React entry point
│   └── App.css                                         # Styling for the app
├── package.json                                        # Frontend dependencies and scripts
├── .gitignore                                          # Ignore unnecessary files in version control


---

## Installation and Setup

### Prerequisites
1. **Java 17+** (for backend)
2. **Node.js** and **npm** (for frontend)
3. **Postman** (optional, for API testing)

### Backend Setup
1. Navigate to the backend directory:
   cd employee-management-backend

2. Build and run the Spring Boot application:
   mvn spring-boot:run

3. The backend server will be available at: http://localhost:8080.

### Frontend Setup
1. Navigate to the frontend directory:
   cd employee-management-frontend
   
2. Install dependencies:
   npm install

3. Start the React application:
   npm start

4. The frontend server will be available at: http://localhost:3000.

## API Endpoints

### Employee APIs

| Method | Endpoint                                                        | Description                                     |
|--------|------------------------------------------------------------------|-------------------------------------------------|
| GET    | `/employees`                                                    | Retrieve all employees                         |
| GET    | `/employees/{empid}`                                            | Retrieve an employee by their unique ID        |
| GET    | `/employees/search-by-date?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD` | Retrieve employees within a date range         |
