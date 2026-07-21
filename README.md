# 💰 Finance Tracker API

A RESTful Finance Tracker API built with **Spring Boot** and **MySQL** for managing personal finance transactions. This project demonstrates CRUD operations, exception handling, and bulk transaction management using Spring Data JPA.

---

## 🚀 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Git
- GitHub
- Postman

---

## 📋 Prerequisites

- Java 21 or later
- MySQL 8+
- IntelliJ IDEA (or any Java IDE)
- Maven

---

## 🔐 Environment Variable

Before running the application, create the following environment variable:

```text
DB_PASSWORD=your_mysql_password
```

---

## ▶️ Running the Application

1. Clone the repository.

```bash
git clone <your-repository-url>
```

2. Navigate to the project directory.

```bash
cd finance-tracker-api
```

3. Create the `DB_PASSWORD` environment variable.

4. Start the MySQL server.

5. Run the Spring Boot application.

The application will start at:

```text
http://localhost:8080
```

---

## 📌 Features

- ✅ Create a transaction
- ✅ Get all transactions
- ✅ Get transaction by ID
- ✅ Update a transaction (PUT)
- ✅ Partially update a transaction (PATCH)
- ✅ Delete a transaction
- ✅ Bulk insert multiple transactions
- ✅ Global exception handling
- ✅ Custom error response
- ✅ Spring Data JPA integration
- ✅ MySQL database integration
- ✅ Environment variable support for database password

---

## 🌐 REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/transactions` | Create a new transaction |
| POST | `/transactions/bulk` | Create multiple transactions |
| GET | `/transactions` | Get all transactions |
| GET | `/transactions/{id}` | Get transaction by ID |
| PUT | `/transactions/{id}` | Replace an existing transaction |
| PATCH | `/transactions/{id}` | Partially update a transaction |
| DELETE | `/transactions/{id}` | Delete a transaction |

---

## 🗄️ Database

- MySQL
- Spring Data JPA
- Automatic table creation using Hibernate

---

## 📈 Project Status

### ✅ Completed

- REST CRUD APIs
- Bulk Insert API
- Global Exception Handling
- Custom Exception
- MySQL Integration
- Environment Variable Configuration

### 🚧 Upcoming Features

- Input Validation
- DTOs
- Pagination & Sorting
- Search & Filter APIs
- Spring Security & JWT Authentication
- Unit Testing
- Docker
- Deployment

---

## 👨‍💻 Author

**Udit Jain**