
# 🚀 GitHub Repository Searcher  

A **Spring Boot** application to search GitHub repositories, store results in a **PostgreSQL** database, and provide an API for retrieval with filters and sorting. This project follows SOLID principles, clean architecture, and efficient database operations to ensure high performance and scalability.  

The application includes two key endpoints:  
- **POST /api/github/search** – Fetches repositories from GitHub and stores them in the database.  
- **GET /api/github/repositories** – Retrieves stored repositories with filtering and sorting options.  

---

## ✅ Features  
- Search GitHub repositories using keywords, language, and sorting options  
- Store search results in PostgreSQL with upsert handling  
- Filter and sort stored results by stars, forks, and last updated date  
- Efficient API calls with error handling and rate limit management  

---

## 📌 Endpoints  
### POST /api/github/search  
**Request:**  
```json
{
  "query": "spring boot",
  "language": "Java",
  "sort": "stars"
}
Response:

json
Copy
Edit
{
  "message": "Repositories fetched and saved successfully",
  "repositories": [
    {
      "id": 123456,
      "name": "spring-boot-example",
      "description": "An example repository for Spring Boot",
      "owner": "user123",
      "language": "Java",
      "stars": 450,
      "forks": 120,
      "lastUpdated": "2024-01-01T12:00:00Z"
    }
  ]
}
GET /api/github/repositories
Request:
/api/github/repositories?language=Java&minStars=100&sort=stars

Request Parameters:

Parameter	Type	Description
language	String	(Optional) Filter by programming language
minStars	Integer	(Optional) Minimum stars count
sort	String	(Optional) Sort by stars, forks, or updated (default is stars)
Response:

json

{
  "repositories": [
    {
      "id": 123456,
      "name": "spring-boot-example",
      "description": "An example repository for Spring Boot",
      "owner": "user123",
      "language": "Java",
      "stars": 450,
      "forks": 120,
      "lastUpdated": "2024-01-01T12:00:00Z"
    }
  ]
}
🏆 How to Run
Clone the Repository
bash
Copy
Edit
git clone https://github.com/your-username/github-repository-searcher.git
Update PostgreSQL Credentials
Modify the src/main/resources/application.properties file:
properties
Copy
Edit
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/github_db
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Build and Run
bash
Copy
Edit
mvn spring-boot:run
Test with Postman or CURL
Example:
bash
Copy
Edit
curl -X POST "http://localhost:8080/api/github/search" \
-H "Content-Type: application/json" \
-d '{"query":"spring boot","language":"Java","sort":"stars"}'
🌟 Tech Stack
Backend: Spring Boot
Database: PostgreSQL
HTTP Client: RestTemplate
DTO Mapping: ModelMapper
Rate Limit Handling: Resilience4j
Testing: JUnit, MockMVC
📂 Folder Structure
css

src/main/java/com/githubsearcher/
├── controller
│   └── GitHubController.java
├── service
│   └── GitHubService.java
├── entity
│   └── RepositoryEntity.java
├── repository
│   └── RepositoryRepository.java
├── dto
│   └── GitHubRepositoryDto.java
├── client
│   └── GitHubApiClient.java
├── exception
│   └── GlobalExceptionHandler.java
└── resources
    └── application.properties
🛠️ Code Highlights
The project follows a clean, layered architecture with the following components:

GitHubController.java – Handles HTTP requests and passes data to the service layer.
GitHubService.java – Business logic layer that calls GitHub API, processes data, and saves it to the database.
GitHubApiClient.java – Handles HTTP calls to the GitHub API with error handling and rate limit management.
RepositoryEntity.java – JPA entity representing the repository table.
RepositoryRepository.java – Spring Data JPA repository interface for database operations.
GitHubRepositoryDto.java – Data Transfer Object for clean data flow between layers.
GlobalExceptionHandler.java – Centralized exception handler for returning meaningful error responses.
🚨 Error Handling
Handles invalid responses from GitHub API with detailed error messages.
Detects rate limits and implements retry with backoff using Resilience4j.
Provides meaningful error codes and messages for easier debugging.
📊 Performance Optimizations
Batch Inserts: Uses saveAll() for efficient bulk inserts.
Upsert Strategy: Avoids duplication by updating existing records instead of creating new ones.
Pagination: Optimized retrieval of large datasets with sorting and filtering.
ModelMapper: Ensures clean object mapping without boilerplate code.
🚧 Challenges and Solutions
GitHub API Rate Limits: Implemented retry and fallback strategy using Resilience4j.
Data Duplication: Used upsert strategy to avoid duplication.
JSON Parsing: Optimized with Jackson for faster processing.

🚀 Test Coverage
Layer	Test Type	Tool
Controller	Integration Tests	MockMVC
Service	Unit Tests	JUnit
API	API Contract Test	Postman
🚢 Best Practices Followed
✅ Clean Code
✅ SOLID Principles
✅ Modular Design
✅ Design Patterns
✅ Batch Processing
✅ Centralized Error Handling
✅ High Test Coverage
💡 Future Enhancements
Add user authentication for personalized search results.
Include pagination for large dataset retrieval.
Improve API response time with in-memory caching.
🔥 Why This Project Stands Out
Follows SOLID Principles
Clean and professional code structure
Efficient error handling and retry mechanism
Batch processing for high performance
High-quality test coverage with clean structure
👨‍💻 Contact
If you encounter any issues or have suggestions, feel free to open an issue or submit a pull request.

⭐ If you find this useful, consider giving it a star!







