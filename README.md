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
