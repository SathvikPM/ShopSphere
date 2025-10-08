# 🛒 ShopSphere Backend

**ShopSphere** is a Spring Boot backend for an e-commerce platform. It provides RESTful APIs to manage categories, products, and file uploads (images), ready to integrate with any frontend such as React. 🚀  

---

## 📌 Table of Contents
- [✨ Features](#-features)  
- [💻 Tech Stack](#-tech-stack)  
- [📂 Project Structure](#-project-structure)  
- [🚀 Getting Started](#-getting-started)  
- [📡 API Endpoints](#-api-endpoints)  
- [🖼️ File Upload](#-file-upload)  
- [🔮 Future Enhancements](#-future-enhancements)  

---

## ✨ Features
- ✅ CRUD operations for **Category** and **Product**  
- 🖼️ File upload support for images (categories/products)  
- 💾 Image URLs stored in database; files stored on server  
- 🔧 Reusable `FileStorageService` for future file management  
- 🏭 Follows **industry standards**: constructor injection, DTO usage, RESTful APIs  

---

## 💻 Tech Stack
- Java 17 ☕  
- Spring Boot 3 🌱  
- Spring Data JPA / Hibernate 🗄️  
- MySQL / H2 Database 🛢️  
- Maven 📦  
- Postman 📝 (for API testing)  

---

## 🔮 Future Enhancements

- Add Product CRUD with category relationship 🛍️
- Integrate with React frontend ⚛️
- Add global exception handling 🚨
- Add pagination and search for categories and products 🔍
- Move file storage to cloud (AWS S3 / GCP Storage) ☁️

