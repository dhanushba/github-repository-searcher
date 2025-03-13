# 🚀 GitHub Repository Searcher  
A **Spring Boot** application to search GitHub repositories using the GitHub REST API, store the results in a **PostgreSQL** database, and provide an API to retrieve stored data with filters and sorting.  

## ✅ Features  
- Search GitHub repositories by name, language, and sort order  
- Store search results in PostgreSQL (avoiding duplicates)  
- Retrieve stored results with filtering and sorting options  
- Efficient batch inserts and upsert handling  

## 📌 Endpoints  
### 1. **Search Repositories**  
**POST** `/api/github/search`  
Request:  
{  
  "query": "spring boot",  
  "language": "Java",  
  "sort": "stars"  
}  
Response:  
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

### 2. **Get Stored Repositories**  
**GET** `/api/github/repositories?language=Java&minStars=100&sort=stars`  
Response:  
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

## 🏆 How to Run  
1. **Clone the Repository**  
git clone https://github.com/dhanushba/github-repository-searcher.git
2. **Update PostgreSQL Credentials** in `application.properties`:  
spring.datasource.url=jdbc:postgresql://localhost:5432/github_db  
spring.datasource.username=postgres  
spring.datasource.password=password  
3. **Build and Run**  
mvn spring-boot:run  
4. **Test with Postman or CURL**  
Example:  
curl -X POST "http://localhost:8080/api/github/search" \  
-H "Content-Type: application/json" \  
-d '{"query":"spring boot","language":"Java","sort":"stars"}'  

## 🌟 Tech Stack  
- Spring Boot  
- PostgreSQL  
- RestTemplate  
- JUnit  
- ModelMapper  

## 📂 Folder Structure  
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

## 🚨 Error Handling  
- Handles invalid responses from GitHub API with detailed error messages.  
- Detects rate limits and implements retry with backoff using **Resilience4j**.  
- Provides meaningful error codes and messages for easier debugging.  

## 🚧 Challenges and Solutions  
**GitHub API Rate Limits:** Implemented retry and fallback strategy using **Resilience4j**.  
**Data Duplication:** Used upsert strategy to avoid duplication.  
**JSON Parsing:** Optimized with Jackson for faster processing.  

## 🚀 Test Coverage  
| Layer | Test Type | Tool |  
| ----- | --------- | ---- |  
| Controller | Integration Tests | MockMVC |  
| Service | Unit Tests | JUnit |  
| API | API Contract Test | Postman |  

## 🚢 Best Practices Followed  
- ✅ Clean Code  
- ✅ SOLID Principles  
- ✅ Modular Design  
- ✅ Design Patterns  
- ✅ Batch Processing  
- ✅ Centralized Error Handling  
- ✅ High Test Coverage  

## 💡 Future Enhancements  
- Add user authentication for personalized search results.  
- Include pagination for large dataset retrieval.  
- Improve API response time with in-memory caching.  

## 🔥 Why This Project Stands Out  
- Follows **SOLID Principles**  
- Clean and professional code structure  
- Efficient error handling and retry mechanism  
- Batch processing for high performance  
- High-quality test coverage with clean structure  

## ⭐ **If you find this useful, consider giving it a star!**  

