# 🎫 Ticketera / Catalog API

## Project Description
This is a Backend REST API project built with **Java** and **Spring Boot**. The main goal of this project is to manage **Events** and **Venues** (locations).

The project was developed over 4 weeks, evolving from a simple application with mock data to a robust **Hexagonal Architecture** with database persistence, advanced relationships, and optimizations.

---

## 🛠️ Technologies Used
* **Java 17** (or higher)
* **Spring Boot 3** (Web, Data JPA, Validation)
* **H2 Database** (In-memory database for development)
* **Lombok** (To reduce boilerplate code)
* **MapStruct** (For object mapping between layers)
* **Flyway** (For database migrations and version control)
* **Maven** (Dependency manager)

---

## 🏗️ Architecture
The project follows the **Hexagonal Architecture (Ports and Adapters)** pattern to decouple the business logic from frameworks and external agents.

### Folder Structure
* **`domain`**: Contains the **Models** and **Ports** (Interfaces). [cite_start]It has **no dependencies** on Spring or Database libraries[cite: 9].
* **`application`**: Contains the **Use Cases**. It implements the Input Ports and orchestrates the business logic.
* **`infrastructure`**: Contains the technical implementation:
    * **Adapters**: REST Controllers (Input) and JPA Repositories (Output).
    * **Configuration**: Spring Beans and setup.
    * **Entities**: Database representation of the models.

---

## 📅 Project Evolution (Modules)

### Week 1: Basic Structure
* Initial setup of the Spring Boot project.
* Basic **CRUD** operations for Events and Venues using mock data (in-memory lists).

### Week 2: Persistence & Validation
* [cite_start]**JPA & H2**: Migrated from lists to a real database using Spring Data JPA[cite: 6].
* [cite_start]**Validations**: Implemented `@NotBlank`, `@Size`, and `@Future` to validate input data[cite: 6].
* [cite_start]**Pagination**: Added `Pageable` support to list events efficiently[cite: 6].
* [cite_start]**Error Handling**: Created a `GlobalExceptionHandler` to manage errors like 400 (Bad Request) and 409 (Conflict)[cite: 6].

### Week 3: Hexagonal Refactor
* [cite_start]**Refactoring**: Transformed the layered architecture into **Hexagonal Architecture**[cite: 9].
* **Ports & Adapters**: Defined Input/Output ports to separate the Domain from Infrastructure.
* [cite_start]**MapStruct**: Integrated MapStruct to map data between Domain Objects and JPA Entities automatically[cite: 9].

### Week 4: Advanced Persistence & Optimization
* [cite_start]**Relationships**: Configured **OneToMany** and **ManyToOne** relationships between Events and Venues[cite: 3].
* [cite_start]**Optimization**: Improved query performance using **JPQL** and `@EntityGraph` to solve the *N+1 Query Problem*[cite: 3].
* [cite_start]**Transactions**: Applied `@Transactional` to ensure data consistency in Use Cases[cite: 3].
* [cite_start]**Migrations**: Integrated **Flyway** to manage database schemas using SQL scripts (`V1__init.sql`, etc.)[cite: 3].

---

## 🚀 How to Run the Project

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YourUser/HU_final.git](https://github.com/YourUser/HU_final.git)
    cd HU_final
    ```

2.  **Build the project:**
    ```bash
    mvn clean install
    ```

3.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Access the API:**
    The server will start at `http://localhost:8080`.
    * **H2 Console:** `http://localhost:8080/h2-console`

---

## 🧪 API Endpoints (Examples)

You can test these endpoints using **Postman** or **Swagger** (if enabled).

### 1. Create an Event (POST)
**URL:** `http://localhost:8080/events`
**Body (JSON):**
```json
{
  "name": "Tech Conference 2026",
  "category": "Technology",
  "startDate": "2026-10-15",
  "venue": {
    "name": "Grand Hotel",
    "city": "New York",
    "address": "5th Avenue"
  }
}
```
---
### 2. Get Events with Pagination (GET)
URL: http://localhost:8080/events?page=0&size=5&sort=name,asc

## 👤 Author
