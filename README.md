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

## 📚 API Documentation

### 💸 Expense Endpoints

#### ➕ Create Expense
```http
POST /api/expense/
Content-Type: application/json

{
  "amount": 125.50,
  "description": "Weekly groceries",
  "category": "Food",
  "date": "2023-07-15"
}



