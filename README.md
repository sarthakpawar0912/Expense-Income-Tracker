# Expense & Income Tracker - Backend API

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

**A powerful REST API for managing personal finances - track your income, expenses, and get insightful statistics**

[Features](#-features) | [Quick Start](#-quick-start) | [API Documentation](#-api-documentation) | [Examples](#-real-world-examples)

</div>

---

## What is This Project?

Imagine you have a personal assistant that keeps track of every rupee you earn and spend. That's exactly what this application does! It's the "brain" (backend) of a personal finance tracker that:

- **Remembers all your income** - salary, freelance work, investments, etc.
- **Tracks all your expenses** - groceries, bills, entertainment, etc.
- **Calculates statistics** - total balance, spending patterns, etc.
- **Organizes everything** - by date, category, and amount

This is the **backend/server** part - it stores all your data safely and provides it to the frontend (website) whenever needed.

---

## How Does It Work? (For Non-Technical People)

Think of this like a restaurant:

| Restaurant Analogy | This Application |
|-------------------|------------------|
| **Kitchen** | This Backend Server |
| **Menu** | API Endpoints (URLs) |
| **Waiter** | HTTP Requests |
| **Customer** | Frontend Website |
| **Recipe Book** | Database (MySQL) |

When you add an expense on the website:
1. The website (customer) sends a request (waiter) to the server (kitchen)
2. The server processes the request using the correct endpoint (menu item)
3. The server saves the data in the database (recipe book)
4. The server sends back a confirmation

---

## Features

### Core Features

| Feature | Description | Benefit |
|---------|-------------|---------|
| **Expense Tracking** | Add, edit, delete expenses | Never forget where your money went |
| **Income Management** | Track all income sources | Know exactly how much you earn |
| **Smart Categories** | Organize by category | See spending patterns at a glance |
| **Dashboard Stats** | Total income, expenses, balance | Quick financial overview |
| **Chart Data** | Time-based financial data | Visualize trends over time |
| **Pagination** | Load data in chunks | Fast performance with large datasets |

### Categories Available

**For Expenses:**
- Education
- Groceries
- Health
- Subscription
- Takeaways
- Clothing
- Travelling
- Other

**For Income:**
- Salary
- Freelancing
- Investment
- Stocks
- Bitcoin
- Bank Transfer
- Youtube
- Other

---

## Quick Start

### What You Need (Prerequisites)

Before you begin, make sure you have these installed on your computer:

| Software | Version | What is it? | Download Link |
|----------|---------|-------------|---------------|
| **Java JDK** | 21 or higher | Programming language runtime | [Download](https://adoptium.net/) |
| **MySQL** | 8.0 or higher | Database to store your data | [Download](https://dev.mysql.com/downloads/) |
| **Maven** | 3.6+ | Tool to build the project | [Download](https://maven.apache.org/) |
| **Git** | Any version | To download the code | [Download](https://git-scm.com/) |

### Step-by-Step Installation

#### Step 1: Download the Code

Open your terminal/command prompt and run:

```bash
git clone https://github.com/sarthakpawar0912/Expense-Income-Tracker.git
cd Expense-Income-Tracker
```

#### Step 2: Set Up the Database

1. Open MySQL command line or MySQL Workbench
2. Run this command to create the database:

```sql
CREATE DATABASE expensetracker;
```

#### Step 3: Configure Database Connection

Open the file `src/main/resources/application.properties` and update these settings:

```properties
# Your database connection settings
spring.datasource.url=jdbc:mysql://localhost:3306/expensetracker
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

**Replace:**
- `YOUR_MYSQL_USERNAME` with your MySQL username (usually `root`)
- `YOUR_MYSQL_PASSWORD` with your MySQL password

#### Step 4: Run the Application

```bash
# Build the project
mvn clean install

# Start the server
mvn spring-boot:run
```

#### Step 5: Verify It's Working

Open your web browser and go to:
```
http://localhost:8080/api/stats
```

If you see a JSON response, congratulations! The server is running!

---

## API Documentation

### What is an API?

Think of an API like a restaurant menu. Each item (endpoint) on the menu has:
- A **name** (URL path like `/api/expense`)
- An **action** (GET = read, POST = create, PUT = update, DELETE = remove)
- **What you send** (request body)
- **What you get back** (response)

### Base URL

All API endpoints start with:
```
http://localhost:8080
```

---

## Expense Endpoints

### 1. Create a New Expense

**When to use:** When you spent money and want to record it.

| Property | Value |
|----------|-------|
| **URL** | `/api/expense` |
| **Method** | `POST` |
| **What it does** | Saves a new expense to the database |

**What to Send (Request Body):**

```json
{
  "title": "Weekly Groceries",
  "description": "Vegetables and fruits from local market",
  "category": "Groceries",
  "date": "2024-01-15",
  "amount": 1500
}
```

**Field Explanations:**

| Field | Type | Required | Description | Example |
|-------|------|----------|-------------|---------|
| `title` | Text | Yes | Short name for the expense | "Weekly Groceries" |
| `description` | Text | Yes | More details about the expense | "Vegetables and fruits" |
| `category` | Text | Yes | Category from the list above | "Groceries" |
| `date` | Date | Yes | When you spent the money (YYYY-MM-DD) | "2024-01-15" |
| `amount` | Number | Yes | How much you spent (in rupees) | 1500 |

**What You Get Back (Success Response):**

```json
{
  "id": 1,
  "title": "Weekly Groceries",
  "description": "Vegetables and fruits from local market",
  "category": "Groceries",
  "date": "2024-01-15",
  "amount": 1500
}
```

---

### 2. Get All Expenses (with Pagination)

**When to use:** When you want to see your expense history.

| Property | Value |
|----------|-------|
| **URL** | `/api/expense/all` |
| **Method** | `GET` |
| **What it does** | Returns a list of your expenses |

**URL Parameters (Optional):**

| Parameter | Default | Description | Example |
|-----------|---------|-------------|---------|
| `page` | 0 | Which page to show (starts from 0) | `?page=0` |
| `size` | 10 | How many items per page | `?size=20` |

**Example Request:**
```
GET http://localhost:8080/api/expense/all?page=0&size=10
```

**What You Get Back:**

```json
{
  "content": [
    {
      "id": 5,
      "title": "Netflix Subscription",
      "description": "Monthly subscription",
      "category": "Subscription",
      "date": "2024-01-20",
      "amount": 649
    },
    {
      "id": 4,
      "title": "Weekly Groceries",
      "description": "Vegetables and fruits",
      "category": "Groceries",
      "date": "2024-01-15",
      "amount": 1500
    }
  ],
  "pageNumber": 0,
  "pageSize": 10,
  "totalElements": 25,
  "totalPages": 3,
  "first": true,
  "last": false
}
```

**Response Field Explanations:**

| Field | Description |
|-------|-------------|
| `content` | Array of expenses on this page |
| `pageNumber` | Current page number (starts from 0) |
| `pageSize` | Number of items per page |
| `totalElements` | Total number of expenses in database |
| `totalPages` | Total number of pages available |
| `first` | Is this the first page? (true/false) |
| `last` | Is this the last page? (true/false) |

---

### 3. Get Single Expense

**When to use:** When you want details of a specific expense.

| Property | Value |
|----------|-------|
| **URL** | `/api/expense/{id}` |
| **Method** | `GET` |
| **What it does** | Returns one specific expense |

**Example:**
```
GET http://localhost:8080/api/expense/5
```

---

### 4. Update an Expense

**When to use:** When you made a mistake and need to correct an expense.

| Property | Value |
|----------|-------|
| **URL** | `/api/expense/{id}` |
| **Method** | `PUT` |
| **What it does** | Updates an existing expense |

**Example:**
```
PUT http://localhost:8080/api/expense/5
```

**Request Body (send all fields, even unchanged ones):**
```json
{
  "title": "Updated Groceries",
  "description": "Added more items",
  "category": "Groceries",
  "date": "2024-01-15",
  "amount": 1800
}
```

---

### 5. Delete an Expense

**When to use:** When you want to remove an expense permanently.

| Property | Value |
|----------|-------|
| **URL** | `/api/expense/{id}` |
| **Method** | `DELETE` |
| **What it does** | Permanently removes an expense |

**Example:**
```
DELETE http://localhost:8080/api/expense/5
```

---

## Income Endpoints

### 1. Create New Income

| Property | Value |
|----------|-------|
| **URL** | `/api/income` |
| **Method** | `POST` |

**Request Body:**
```json
{
  "title": "Monthly Salary",
  "description": "January 2024 salary from XYZ Company",
  "category": "Salary",
  "date": "2024-01-01",
  "amount": 50000
}
```

---

### 2. Get All Income (with Pagination)

| Property | Value |
|----------|-------|
| **URL** | `/api/income/all?page=0&size=10` |
| **Method** | `GET` |

---

### 3. Get Single Income

| Property | Value |
|----------|-------|
| **URL** | `/api/income/{id}` |
| **Method** | `GET` |

---

### 4. Update Income

| Property | Value |
|----------|-------|
| **URL** | `/api/income/{id}` |
| **Method** | `PUT` |

---

### 5. Delete Income

| Property | Value |
|----------|-------|
| **URL** | `/api/income/{id}` |
| **Method** | `DELETE` |

---

## Statistics Endpoints

### 1. Get Financial Summary

**When to use:** When you want to see your overall financial status.

| Property | Value |
|----------|-------|
| **URL** | `/api/stats` |
| **Method** | `GET` |

**What You Get Back:**

```json
{
  "income": 150000.0,
  "expense": 45000.0,
  "balance": 105000.0,
  "latestIncome": {
    "id": 10,
    "title": "Freelance Payment",
    "amount": 25000,
    "date": "2024-01-20"
  },
  "latestExpense": {
    "id": 15,
    "title": "Electric Bill",
    "amount": 2500,
    "date": "2024-01-18"
  },
  "minIncome": 5000.0,
  "maxIncome": 50000.0,
  "minExpense": 100.0,
  "maxExpense": 15000.0
}
```

**Field Explanations:**

| Field | Description |
|-------|-------------|
| `income` | Total of all income entries |
| `expense` | Total of all expense entries |
| `balance` | Income minus Expenses (your savings) |
| `latestIncome` | Most recent income entry |
| `latestExpense` | Most recent expense entry |
| `minIncome` | Smallest income amount |
| `maxIncome` | Largest income amount |
| `minExpense` | Smallest expense amount |
| `maxExpense` | Largest expense amount |

---

### 2. Get Chart Data

**When to use:** When you want to display graphs showing income/expense trends.

| Property | Value |
|----------|-------|
| **URL** | `/api/stats/chart` |
| **Method** | `GET` |

**What You Get Back:**

```json
{
  "expenseList": [
    { "id": 1, "title": "Groceries", "amount": 1500, "date": "2024-01-15" },
    { "id": 2, "title": "Rent", "amount": 15000, "date": "2024-01-01" }
  ],
  "incomeList": [
    { "id": 1, "title": "Salary", "amount": 50000, "date": "2024-01-01" },
    { "id": 2, "title": "Freelance", "amount": 10000, "date": "2024-01-10" }
  ]
}
```

---

## Complete API Reference Table

| Action | Method | Endpoint | Description |
|--------|--------|----------|-------------|
| Create Expense | `POST` | `/api/expense` | Add new expense |
| Get All Expenses | `GET` | `/api/expense/all?page=0&size=10` | List expenses (paginated) |
| Get One Expense | `GET` | `/api/expense/{id}` | Get specific expense |
| Update Expense | `PUT` | `/api/expense/{id}` | Modify expense |
| Delete Expense | `DELETE` | `/api/expense/{id}` | Remove expense |
| Create Income | `POST` | `/api/income` | Add new income |
| Get All Income | `GET` | `/api/income/all?page=0&size=10` | List income (paginated) |
| Get One Income | `GET` | `/api/income/{id}` | Get specific income |
| Update Income | `PUT` | `/api/income/{id}` | Modify income |
| Delete Income | `DELETE` | `/api/income/{id}` | Remove income |
| Get Statistics | `GET` | `/api/stats` | Financial summary |
| Get Chart Data | `GET` | `/api/stats/chart` | Data for graphs |

---

## Real-World Examples

### Example 1: Recording Your Monthly Salary

You just received your salary of Rs. 50,000. Here's how to record it:

**Step 1:** Send this request:
```
POST http://localhost:8080/api/income
```

**Step 2:** With this body:
```json
{
  "title": "January Salary",
  "description": "Monthly salary from ABC Company",
  "category": "Salary",
  "date": "2024-01-01",
  "amount": 50000
}
```

**Step 3:** You'll get back:
```json
{
  "id": 1,
  "title": "January Salary",
  "description": "Monthly salary from ABC Company",
  "category": "Salary",
  "date": "2024-01-01",
  "amount": 50000
}
```

### Example 2: Recording Daily Expenses

You bought groceries worth Rs. 800 and paid your internet bill of Rs. 599.

**Grocery Expense:**
```json
{
  "title": "Weekly Vegetables",
  "description": "Bought vegetables from local market",
  "category": "Groceries",
  "date": "2024-01-15",
  "amount": 800
}
```

**Internet Bill:**
```json
{
  "title": "Internet Bill",
  "description": "Monthly broadband bill",
  "category": "Subscription",
  "date": "2024-01-15",
  "amount": 599
}
```

### Example 3: Checking Your Balance

Want to know how much money you've saved?

```
GET http://localhost:8080/api/stats
```

Response will show:
- Total income: Rs. 50,000
- Total expenses: Rs. 1,399
- Balance: Rs. 48,601

---

## Error Handling

When something goes wrong, the API returns clear error messages:

| Status Code | Meaning | Example |
|-------------|---------|---------|
| `200 OK` | Request successful | Data returned correctly |
| `201 Created` | New record created | Expense/Income added |
| `400 Bad Request` | Invalid data sent | Missing required fields |
| `404 Not Found` | Record doesn't exist | Expense ID not found |
| `500 Server Error` | Something went wrong | Database connection issue |

**Example Error Response:**
```json
{
  "status": 404,
  "message": "Expense is not present with id 999"
}
```

---

## Project Structure

```
ExpenseTracker/
├── src/main/java/com/SRP/ExpenseTracker/
│   ├── Controller/           # Handles incoming requests
│   │   ├── ExpenseController.java
│   │   ├── IncomeController.java
│   │   └── StatsController.java
│   ├── Service/              # Business logic
│   │   ├── Expense/
│   │   ├── income/
│   │   └── stats/
│   ├── Repository/           # Database operations
│   │   ├── ExpenseRepository.java
│   │   └── IncomeRepository.java
│   ├── entity/               # Database tables
│   │   ├── Expense.java
│   │   └── Income.java
│   └── dto/                  # Data transfer objects
│       ├── ExpenseDTO.java
│       ├── IncomeDTO.java
│       ├── StatsDTO.java
│       ├── GraphDTO.java
│       └── PagedResponseDTO.java
└── src/main/resources/
    └── application.properties  # Configuration
```

---

## Technologies Used

| Technology | Purpose | Why We Use It |
|------------|---------|---------------|
| **Spring Boot 3.3.5** | Web Framework | Fast development, built-in features |
| **Java 21** | Programming Language | Modern, reliable, widely used |
| **MySQL 8.0** | Database | Stores all your financial data |
| **Spring Data JPA** | Database Access | Easy database operations |
| **Lombok** | Code Helper | Reduces repetitive code |
| **Maven** | Build Tool | Manages dependencies |

---

## Troubleshooting

### Problem: Application won't start

**Solution:** Check if MySQL is running and database exists:
```sql
SHOW DATABASES;
```

### Problem: Connection refused

**Solution:** Verify MySQL credentials in `application.properties`

### Problem: Port 8080 already in use

**Solution:** Either stop the other application or change port:
```properties
server.port=8081
```

---

## Future Improvements

- [ ] User authentication (login/register)
- [ ] Budget setting and alerts
- [ ] Export to CSV/PDF
- [ ] Email notifications
- [ ] Multiple currency support
- [ ] Recurring transactions

---

## Related Repository

**Frontend (Angular):** [Expense-Income-Tracker-Web](https://github.com/sarthakpawar0912/Expense-Income-Tracker-Web)

---

## Contact

**Developer:** Sarthak Pawar

**Email:** pawarsr06@gmail.com

**GitHub:** [@sarthakpawar0912](https://github.com/sarthakpawar0912)

---

## License

This project is licensed under the MIT License - feel free to use it for your personal projects!

---

<div align="center">

**Made with mass love**

If you found this helpful, please give it a star on GitHub!

</div>
