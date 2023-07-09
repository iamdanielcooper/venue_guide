# Venue Guide.
Venue guide is a platform where users can view and submit information and reviews for music venues.

## Routes
All routes are outlined below.
A Postman collection is also available [here](src/main/resources/postman_collection.json)

| Method | Endpoint           | params           | body                                              | 
|--------|--------------------|------------------|---------------------------------------------------|
| GET    | /venues            |                  |                                                   |
| POST   | /venues            |                  | name: String (required), capacity: Int (optional) |
| GET    | /venues/{venue_id} | venue_id: String |                                                   |

## Technologies Used
- Kotlin
- Spring Boot
- Gradle

