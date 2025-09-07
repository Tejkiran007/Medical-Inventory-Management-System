🏥Medical Inventory Management System
🚀 Features

✅ Medicine Management: Add, view, update, and delete medicines

✅ User Roles: Admin and Staff with different access levels

✅ Automatic Alerts: Daily notifications for expired medicines and low stock (< 5 items)

✅ Search Functionality: Search medicines by name

✅ Permanent Storage: All data stored in MySQL database

✅ Simple Authentication: Basic username/password authentication

✅ REST API: Easy to integrate with any frontend or mobile app

🛠️ Technologies Used

Backend: Java 17, Spring Boot 3.2.0

Database: MySQL 8.0

Security: Spring Security with Basic Authentication

ORM: Spring Data JPA / Hibernate

Build Tool: Maven

Scheduler: Spring Scheduler for automatic alerts

⚙️ Setup Instructions
1. Clone the Repository
git clone https://github.com/Tejkiran007/Medical-Inventory-Management-System
cd Medical-Inventory-Management-System

2. Setup MySQL Database
CREATE DATABASE medical_store;
CREATE USER 'medicalstore_user'@'localhost' IDENTIFIED BY 'password123';
GRANT ALL PRIVILEGES ON medical_store.* TO 'medicalstore_user'@'localhost';
FLUSH PRIVILEGES;

3. Configure Application Properties

Edit src/main/resources/application.properties:

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/medical_store
spring.datasource.username=medicalstore_user
spring.datasource.password=password123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Security Configuration (Default Login)
spring.security.user.name=admin
spring.security.user.password=admin123

# Server Configuration
server.port=8080

4. Run the Application

Using Maven:

mvn clean install
mvn spring-boot:run


Or using IDE:
Run the SimpleMedicalStoreApplication.java main class.

✅ Success Message:

🏥 Medical Store Backend is running!
📋 Access API at: http://localhost:8080/api/
👤 Default login: admin / admin123

🔗 API Endpoints
🔐 Authentication

Username: admin

Password: admin123

Type: Basic Authentication

📦 Medicine Management APIs
Method	Endpoint	Description	Access
GET	/api/medicines	Get all medicines	Admin/Staff
GET	/api/medicines/{id}	Get medicine by ID	Admin/Staff
POST	/api/medicines	Add new medicine	Admin only
PUT	/api/medicines/{id}	Update medicine	Admin only
DELETE	/api/medicines/{id}	Delete medicine	Admin only
GET	/api/medicines/search?name={name}	Search medicines by name	Admin/Staff
GET	/api/medicines/low-stock	Get low stock medicines (< 5)	Admin/Staff
GET	/api/medicines/expired	Get expired medicines	Admin/Staff
GET	/api/medicines/expiring	Get medicines expiring in 30 days	Admin/Staff
👤 User Management APIs
Method	Endpoint	Description	Access
GET	/api/auth/users	Get all users	Admin only
POST	/api/auth/register	Register new user	Admin only
POST	/api/auth/login	Login user	All
📝 Sample API Requests
1. Add New Medicine
POST http://localhost:8080/api/medicines
Authorization: Basic YWRtaW46YWRtaW4xMjM=
Content-Type: application/json

{
  "name": "Paracetamol",
  "batchNumber": "BATCH001",
  "stock": 50,
  "price": 15.50,
  "expiryDate": "2025-12-31"
}

2. Get All Medicines
GET http://localhost:8080/api/medicines
Authorization: Basic YWRtaW46YWRtaW4xMjM=

3. Search Medicine
GET http://localhost:8080/api/medicines/search?name=paracetamol
Authorization: Basic YWRtaW46YWRtaW4xMjM=

4. Get Low Stock Medicines
GET http://localhost:8080/api/medicines/low-stock
Authorization: Basic YWRtaW46YWRtaW4xMjM=

🔔 Automatic Alerts

Runs daily at 9:00 AM and every 2 minutes (testing).

Alerts:

⚠️ Low Stock (stock < 5)

⛔ Expired Medicines

⏳ Expiring Soon (within 30 days)

Alerts are displayed in console/logs.

🗂️ Project Structure
src/main/java/com/medicalstore/
├── SimpleMedicalStoreApplication.java    # Main application class
├── entity/
│   ├── User.java                         # User entity (Admin/Staff)
│   └── Medicine.java                     # Medicine entity
├── repository/
│   ├── UserRepository.java               # User data access
│   └── MedicineRepository.java           # Medicine data access
├── service/
│   ├── UserService.java                  # User business logic
│   └── MedicineService.java              # Medicine business logic
├── controller/
│   ├── AuthController.java               # Authentication APIs
│   └── MedicineController.java           # Medicine APIs
├── config/
│   └── SecurityConfig.java               # Security configuration
└── scheduler/
    └── AlertScheduler.java               # Automatic alert system

🧪 Testing with Postman

Import the API collection or create requests manually.

Set Authentication: Basic Auth (admin / admin123).

Test endpoints from the API section above.

Add test medicines with different stock & expiry dates.

Check console logs for automatic alerts.

📊 Database Tables

The application automatically creates:

users → Stores user information (Admin/Staff)

medicines → Stores medicine inventory data
