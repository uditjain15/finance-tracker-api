# 💰 Finance Tracker API

A RESTful Finance Tracker API built with **Spring Boot** and **MySQL** for managing personal finance transactions. This project demonstrates RESTful CRUD operations, DTO architecture, validation, global exception handling, and bulk transaction management using Spring Data JPA.

---

## 🚀 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Jakarta Bean Validation
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
- ✅ DTO Architecture (Request & Response DTOs)
- ✅ Entity to DTO and DTO to Entity Mapping
- ✅ Input Validation using Jakarta Bean Validation
- ✅ Validation for Bulk Requests
- ✅ Global Exception Handling
- ✅ Custom Exception Handling
- ✅ Structured Validation Error Responses
- ✅ Spring Data JPA Integration
- ✅ MySQL Database Integration
- ✅ Environment Variable Support for Database Password

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

## ✅ Validation

The API validates incoming requests before processing them.

Supported validations include:

- Title cannot be blank
- Amount must be greater than 0
- Type cannot be blank
- Category cannot be blank
- Date is required

Bulk requests also provide detailed validation responses indicating the index of the invalid object.

Example:

```json
{
  "errors": [
    {
      "index": 0,
      "field": "type",
      "message": "Type is required"
    },
    {
      "index": 1,
      "field": "title",
      "message": "Title cannot be blank"
    }
  ]
}
```

---

## 🗄️ Database

- MySQL
- Spring Data JPA
- Hibernate ORM
- Automatic table creation using Hibernate

---

## 📈 Project Status

### ✅ Completed

- REST CRUD APIs
- Bulk Insert API
- DTO Architecture
- Entity ↔ DTO Mapping
- Input Validation
- Bulk Request Validation
- Global Exception Handling
- Custom Exception Handling
- Custom Validation Error Responses
- MySQL Integration
- Environment Variable Configuration

### 🚧 Upcoming Features

- Swagger / OpenAPI Documentation
- Pagination & Sorting
- Search & Filter APIs
- Logging
- Spring Security & JWT Authentication
- Unit Testing
- Docker
- Deployment

---

## 👨‍💻 Author

**Udit Jain**