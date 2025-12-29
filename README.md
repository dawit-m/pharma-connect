                🏥 PharmaConnect: Pharmacy Medicine Availability System

📌 Project Overview
PharmaConnect is a professional Java-based Web Application designed to solve a critical healthcare gap in Ethiopia: medicine accessibility. It provides a centralized digital bridge where pharmacies manage inventory and patients find life-saving medications instantly.

Architecture: Built using Spring Boot, following the MVC (Model-View-Controller) design pattern to ensure clean, maintainable, and scalable code.

🚀 Key Features
.🏢 Pharmacy Ecosystem: Secure registration and login for pharmacy owners to manage their digital storefront.

    .💊 Smart Inventory: Pharmacies can post medicines with specific attributes (price, quantity, and location links).

    .🔍 Intelligent Search: A patient-facing search engine that uses Case-Insensitive Keyword Matching to find drugs.

    .📈 Demand Tracking: Built-in logic to track "Search Counts," providing pharmacies with data on which medicines are most needed by the community.

    .📱 Universal Access (USSD): Integrated logic for a text-based menu (simulating *881#) to support users without smartphones or internet.

    .📍 Geo-Location: Direct integration with Google Maps links for immediate pharmacy navigation.

🛠️ Technical Stack & OOP Implementation
.Language: Java 21 (Core Logic)

.Framework: Spring Boot (Web & Data Management)

.Database: MySQL (Persistent Storage)

.Frontend: HTML5, CSS3, and Thymeleaf (Template Engine)

OOP Concepts Used:

.Encapsulation: Protecting data using Private fields and Public Getters/Setters.

.Relationships: Implemented a One-to-Many (@OneToMany) relationship between Pharmacies and Medicines.

.Abstraction: Using Repository Interfaces to handle complex database queries.

📂 Project Structure & Logic
Layer Responsibility
Entity, Defines the data structure (Database Models).
Repository, The bridge between Java logic and MySQL data.
Service, "The ""Brain"" – handles search logic and popularity tracking."
Controller, "Manages URLs, User requests, and Page navigation."
Templates, The User Interface (Views) that the client interacts with.
