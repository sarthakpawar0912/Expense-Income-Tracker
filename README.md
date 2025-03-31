# 💰 Personal Finance Tracker API 📊

![API Architecture](https://img.shields.io/badge/Architecture-Spring_Boot-green)
![Database](https://img.shields.io/badge/Database-Hibernate/JPA-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

## 📖 Table of Contents
1. [Project Overview](#-project-overview)
2. [Features](#-features)
3. [API Documentation](#-api-documentation)
   - [Expense Endpoints](#-expense-endpoints)
   - [Income Endpoints](#-income-endpoints)
   - [Statistics Endpoints](#-statistics-endpoints)
4. [Data Models](#-data-models)
5. [Error Handling](#-error-handling)
6. [Setup & Installation](#-setup--installation)
7. [Usage Examples](#-usage-examples)
8. [Contributing](#-contributing)
9. [License](#-license)

## 🌐 Project Overview
A robust RESTful API built with Spring Boot for tracking personal finances, including income, expenses, and generating financial analytics. The API follows REST conventions and implements proper CRUD operations with validation.

## ✨ Features
- **Complete Financial Tracking**:
  - Record income and expenses
  - Categorize transactions
  - Add descriptions and dates
- **Comprehensive Analytics**:
  - Monthly balance calculations
  - Expense/income comparison charts
  - Top spending categories
- **RESTful Design**:
  - Proper HTTP status codes
  - JSON request/response format
  - Resource-oriented endpoints
- **Error Handling**:
  - Meaningful error messages
  - Consistent response structure
  - Validation for all inputs

## 📚 API Documentation

### 💸 Expense Endpoints

#### Create New Expense
```http
POST /api/expense/
Content-Type: application/json
{
  "amount": 125.50,
  "description": "Weekly groceries",
  "category": "Food",
  "date": "2023-07-15"
}


Success Response:{
  "id": 42,
  "amount": 125.50,
  "description": "Weekly groceries",
  "category": "Food",
  "date": "2023-07-15",
  "createdAt": "2023-07-15T14:30:22Z"
}



###Other Expense Operations:
Endpoint          	Method	      Description          	     Parameters
/api/expense/all	    GET	         Get all expenses	          ?page=1&size=10
/api/expense/{id} 	 GET	         Get specific expense	       Path: id
/api/expense/{id}	    PUT           Update expense	             Body: ExpenseDTO
/api/expense/{id}	    DELETE	      Delete expense	             Path: id



###💰 Income Endpoints
Create New Income
http:
POST /api/income

Content-Type: application/json

{
  "amount": 3000.00,
  "description": "Monthly salary",
  "category": "Employment",
  "date": "2023-07-01"
}

Success Response:
json
{
  "id": 17,
  "amount": 3000.00,
  "description": "Monthly salary",
  "category": "Employment",
  "date": "2023-07-01",
  "createdAt": "2023-07-01T09:15:33Z"
}

Other Income Operations:
Endpoint	            Method	       Description	                     Parameters
/api/income/all	     GET	        Get all income records	            ?sort=date,desc
/api/income/{id}	     GET	        Get specific income   	            Path: id
/api/income/{id}    	  PUT	        Update income	                     Body: IncomeDTO
/api/income/{id}	    DELETE	     Delete income                     	Path: id


📈 Statistics Endpoints
Get Financial Summary
http:
GET /api/stats

Sample Response:
json:
{
  "totalIncome": 6500.00,
  "totalExpense": 4200.00,
  "balance": 2300.00,
  "topExpenseCategories": [
    {"category": "Rent", "amount": 2000.00},
    {"category": "Food", "amount": 1200.00}
  ],
  "monthlyTrend": {
    "incomeChange": 15.5,
    "expenseChange": -8.2
  }
}


Get Chart Data
http:
GET /api/stats/chart

Sample Response:
json:
{
  "incomeData": [3000, 3200, 3500],
  "expenseData": [2500, 2400, 2600],
  "labels": ["April", "May", "June"],
  "averageMonthlySavings": 633.33
}




🗃️ Data Models
Expense Entity
java:
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Double amount;
    
    private String description;
    private String category;
    
    @Column(nullable = false)
    private LocalDate date;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}


Income Entity
java:
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Double amount;
    
    private String description;
    private String category;
    
    @Column(nullable = false)
    private LocalDate date;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}


🚨 Error Handling
The API returns consistent error responses:
Resource Not Found (404)
json:
{
  "timestamp": "2023-07-15T16:45:30Z",
  "status": 404,
  "error": "Not Found",
  "message": "Expense with id 99 not found",
  "path": "/api/expense/99"
}
Validation Error (400)
json:
{
  "timestamp": "2023-07-15T16:48:12Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "errors": [
    "Amount must be positive",
    "Date cannot be in the future"
  ],
  "path": "/api/expense/"
}
Server Error (500)
json:
{
  "timestamp": "2023-07-15T16:50:45Z",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Database connection failed",
  "path": "/api/income/"
}


🛠️ Setup & Installation

Prerequisites
Java 17+
Maven 3.6+
MySQL

Installation Steps
Clone the repository:

bash
Copy
git clone https://github.com/yourusername/expense-tracker-api.git
cd expense-tracker-api
Configure database:

propertiesP
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=dbuser
spring.datasource.password=dbpass
Build and run:

bash
Copy
mvn clean install
mvn spring-boot:run

Access the API:
http://localhost:8080/api/
💻 Usage Examples
Using cURL
bash
Copy
# Create new expense
curl -X POST -H "Content-Type: application/json" \
-d '{"amount": 75.25, "description": "Dinner", "category": "Food", "date": "2023-07-15"}' \
http://localhost:8080/api/expense/

# Get monthly stats
curl http://localhost:8080/api/stats
Using JavaScript (Fetch API)
javascript
Copy
// Get all expenses
fetch('http://localhost:8080/api/expense/all')
  .then(response => response.json())
  .then(data => console.log(data));

// Post new income
fetch('http://localhost:8080/api/income', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({
    amount: 3000,
    description: "Salary",
    category: "Employment",
    date: "2023-07-01"
  })
});


🤝 Contributing
Fork the project

Create your feature branch (git checkout -b feature/AmazingFeature)

Commit your changes (git commit -m 'Add some amazing feature')

Push to the branch (git push origin feature/AmazingFeature)

Open a Pull Request



📧 Contact
Sarthak Pawar - pawarsr06@gmail.com
Project Link: [https://github.com/yourusername/expense-tracker-api]


This README includes:
1. Complete API documentation with examples
2. Detailed setup instructions
3. Usage examples for different clients
4. Clear data model definitions
5. Comprehensive error handling documentation
6. Contribution guidelines
7. License information

The markdown formatting ensures excellent readability both on GitHub and in raw text form. You can customize the database configuration, contact information, and repository URLs as needed for your specific deployment.
