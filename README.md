# Student Task Manager

The Student Task Manager is a REST-based Spring Boot application designed to manage personal tasks[cite: 1]. It serves as a practical demonstration of real-world backend concepts, including authentication, authorization, and automated testing[cite: 1].

## 🚀 Features

This project implements the following core functionalities:
* **User Authentication:** Secure login and registration system[cite: 1].
* **Role-Based Access Control:** Distinct permissions for `ROLE_USER` and `ROLE_ADMIN`[cite: 1].
* **JWT Integration:** Token-based security for protected API routes[cite: 1].
* **CRUD Operations:** Create, read, and delete functionalities for tasks[cite: 1].
* **Testing:** Comprehensive coverage using JUnit and Mockito (Unit & Integration tests)[cite: 1].

## 👥 User Roles & Permissions

* **User (`ROLE_USER`):** Can create new tasks and view only their own tasks[cite: 1].
* **Admin (`ROLE_ADMIN`):** Can view all tasks across the system, delete any task, and create new users[cite: 1].

## 🛠️ Technology Stack
* **Java 17**
* **Spring Boot 3.x** (Web, Data JPA, Validation)
* **Spring Security** & **JSON Web Tokens (JWT)**
* **H2 Database** (In-memory database for fast testing)
* **Lombok**
* **JUnit 5 & Mockito**

## 🚦 API Endpoints Overview

**Public Endpoints:**
* `POST /auth/register` - Register a new user[cite: 1]
* `POST /auth/login` - Authenticate user and receive JWT[cite: 1]

**User Endpoints (Requires `Bearer Token`):**
* `GET /tasks/my` - Get tasks belonging to the logged-in user[cite: 1]
* `POST /tasks` - Create a new task[cite: 1]

**Admin Endpoints (Requires `ROLE_ADMIN`):**
* `GET /tasks` - List all tasks[cite: 1]
* `DELETE /tasks/{id}` - Delete a specific task[cite: 1]
* `POST /admin/users` - Create a new user (Admin only)[cite: 1]

## 💻 How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone <your-github-repo-link>

2. **Navigate to the project folder:**
   ```bash
   cd student-task-manager
   
3. **Build the project using Maven:**
   ```bash
   mvn clean install

4. **Run the application:**
   ```bash
   mvn spring-boot:run

Alternatively, you can open the project in IntelliJ IDEA / Eclipse and run the StudentTaskManagerApplication main class.

5. **Access the application:**
* **The server will start on http://localhost:8080.**