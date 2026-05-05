# Student Task Manager

The Student Task Manager is a REST-based Spring Boot application designed to manage personal tasks[cite: 1]. It serves as a practical demonstration of real-world backend concepts, including authentication, authorization, and automated testing.

## 🚀 Features

This project implements the following core functionalities:
* **User Authentication:** Secure login and registration system.
* **Role-Based Access Control:** Distinct permissions for `ROLE_USER` and `ROLE_ADMIN`.
* **JWT Integration:** Token-based security for protected API routes.
* **CRUD Operations:** Create, read, and delete functionalities for tasks.
* **Testing:** Comprehensive coverage using JUnit and Mockito (Unit & Integration tests).

## 👥 User Roles & Permissions

* **User (`ROLE_USER`):** Can create new tasks and view only their own tasks.
* **Admin (`ROLE_ADMIN`):** Can view all tasks across the system, delete any task, and create new users.

## 🛠️ Technology Stack
* **Java 17**
* **Spring Boot 3.x** (Web, Data JPA, Validation)
* **Spring Security** & **JSON Web Tokens (JWT)**
* **H2 Database** (In-memory database for fast testing)
* **Lombok**
* **JUnit 5 & Mockito**

## 🚦 API Endpoints Overview

**Public Endpoints:**
* `POST /auth/register` - Register a new user
* `POST /auth/login` - Authenticate user and receive JWT

**User Endpoints (Requires `Bearer Token`):**
* `GET /tasks/my` - Get tasks belonging to the logged-in user
* `POST /tasks` - Create a new task[

**Admin Endpoints (Requires `ROLE_ADMIN`):**
* `GET /tasks` - List all tasks
* `DELETE /tasks/{id}` - Delete a specific task
* `POST /admin/users` - Create a new user (Admin only)

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
