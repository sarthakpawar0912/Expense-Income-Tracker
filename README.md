# 💰 Personal Finance Tracker API 📊

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.5-green)
![Java](https://img.shields.io/badge/Java-17-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Database](https://img.shields.io/badge/MySQL-8.0-orange)

## 📖 Table of Contents
1. [Project Overview](#-project-overview)
2. [Key Features](#-key-features)
3. [API Documentation](#-api-documentation)
4. [Data Models](#-data-models)
5. [Error Handling](#-error-handling)
6. [Setup Guide](#-setup-guide)
7. [Usage Examples](#-usage-examples)
8. [Development](#-development)
9. [License](#-license)
10. [Contact](#-contact)

## 🌐 Project Overview
A complete RESTful API for personal finance management built with **Spring Boot** that helps users track income, expenses, and generate financial reports with analytics.

## ✨ Key Features
- 💸 **Expense Tracking** with categorization
- 💰 **Income Management** by source
- 📊 **Financial Analytics** and visualization
- 🔄 **Full CRUD Operations**
- 🛡️ **Data Validation** for all inputs
- ⚡ **RESTful Design** following best practices



📚 API Documentation
A complete guide to managing your finances programmatically



💸 Expense Management
Track every penny spent with smart categorization

➕ Add New Expense


📍 Endpoint: POST /api/expense/
📦 Request Body: Send amount, description, category, and date.


json:
{
  "amount": 125.50,
  "description": "Weekly groceries",
  "category": "Food",
  "date": "2023-07-15"
}

✅ Success Response: Returns the saved expense with a unique ID and timestamp.
❌ Errors: Handles invalid amounts, future dates, or missing fields.



🔍 Retrieve Expenses
📂 Get All Expenses: GET /api/expense/all
Supports pagination (?page=1&size=10).



🔎 Get One Expense: GET /api/expense/{id}
Fetches details for a specific transaction.








✏️ Update/Delete
🔄 Update: PUT /api/expense/{id} – Modify any field.
🗑️ Delete: DELETE /api/expense/{id} – Remove an expense permanently.










💰 Income Tracking
Monitor earnings with detailed records


➕ Add Income
📍 Endpoint: POST /api/income
📦 Request Body: Similar to expenses, but for income sources.
json:
{
  "amount": 3000.00,
  "description": "Monthly salary",
  "category": "Employment",
  "date": "2023-07-01"
}
✅ Success Response: Includes auto-generated ID and creation timestamp.






📊 View Income
📂 List All Income: GET /api/income/all
🔎 Single Record: GET /api/income/{id}





✏️ Update/Delete
🔄 Edit: PUT /api/income/{id}
🗑️ Remove: DELETE /api/income/{id}







📈 Financial Analytics
Gain insights with powerful statistics





📊 Summary Dashboard
📍 Endpoint: GET /api/stats





📊 Response:
total income/expenses
Current balance
Top spending categories





📉 Visual Chart Data
📍 Endpoint: GET /api/stats/chart






📈 Response:
Monthly trends (income vs. expenses)
Labels for time periods (e.g., ["Jan", "Feb", "Mar"])






🛠️ Setup & Usage
Get started in 3 easy steps







⚙️ Configure
Set up MySQL in application.properties.
Example:
properties:
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=youruser
spring.datasource.password=yourpass








🚀 Run the API

bash:
mvn clean install

mvn spring-boot:run









🔗 Test Endpoints

Use tools like Postman or cURL:
bash:
curl -X POST http://localhost:8080/api/expense/ -H "Content-Type: application/json" -d '{"amount":50.00, "category":"Transport"}'












🚨 Error Handling
Clear feedback for issues
🔍 404 Not Found: Missing records.
❌ 400 Bad Request: Invalid data (e.g., negative amounts).
⚠️ 500 Server Error: Database/connection failures.

Example error response:
json:
{
  "status": 400,
  "message": "Amount must be positive!"
}











🌟 Why Use This API?
✅ Simple: Intuitive endpoints.
📊 Insightful: Built-in analytics.
🔒 Reliable: Handles errors gracefully.













🎉 Ready to take control of your finances? Start integrating today!
For questions, contact: pawarsr06@gmail.com.
