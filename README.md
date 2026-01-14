# Employee Management System 🧑‍💼📋

A simple Spring Boot application that allows user registration, login, and secure access to employee-related APIs using JWT-based authentication.

## 🚀 Features

- User Registration & Login
- Passwords hashed using BCrypt
- JWT Authentication & Authorization
- Protected API Endpoints
- Integrated with MySQL Database
- Swagger/OpenAPI for testing endpoints

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.rehan.example.employeemanagement/
│   │       ├── controller/
│   │       ├── entity/
│   │       ├── repository/
│   │       ├── security/
│   │       └── service/
│   └── resources/
│       └── application.properties
```

## 🧪 How to Run

1. **Clone the repository**  
   `git clone <your-repo-url>`

2. **Configure MySQL**  
   Update your `application.properties` with your DB username, password, and schema.

3. **Run the Application**  
   Use IntelliJ or run:  
   `./mvnw spring-boot:run`

4. **Test with Swagger**  
   Visit `http://localhost:8080/swagger-ui.html`

## 🔐 Authentication Flow

- Register using `/auth/register`
- Login with `/auth/login` to receive a JWT token
- Use the token in Postman (Header → `Authorization: Bearer <token>`) to access secured endpoints like `/employees`

## 💻 Technologies Used

- Java 21
- Spring Boot 3
- Spring Security
- JPA & Hibernate
- MySQL
- JWT (jjwt)
- Swagger/OpenAPI

## 📦 Future Improvements

- Role-based access control (Admin/User)
- Frontend integration with React or Angular
- Token refresh & logout functionality
