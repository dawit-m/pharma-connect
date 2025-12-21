# PharmaConnect – Pharmacy Medicine Availability System

## 📌 Project Description
PharmaConnect is a Java Spring Boot–based application designed to improve access to medicine availability in Ethiopia.  
The system allows pharmacies to register and publish available medicines, while clients can search medicines online or via a simulated USSD interface without internet access.

This project is designed as a beginner-friendly backend system focusing on real-world problems in healthcare access.

---

## 🎯 Features
- Pharmacy registration and login
- Medicine posting with expiry date and quantity
- Medicine search for clients
- Popular medicines tracking
- USSD simulation for non-internet users
- MySQL database integration
- RESTful API design

---

## 🛠️ Technologies Used
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman (API testing)
- NetBeans IDE

---

## 📱 USSD Simulation
The system simulates a USSD workflow similar to *999# services in Ethiopia.  
Users can:
- Search medicine by name
- Check availability status
- Get pharmacy location info

(Note: Telecom integration is simulated in Java logic.)

---

## 🗂️ Project Structure
- Controller: Handles API requests
- Service: Business logic
- Repository: Database access
- Entity: Database models

---

## 🚀 How to Run
1. Clone the repository
2. Create MySQL database: `pharma_app`
3. Update `application.properties`
4. Run `PharmaappApplication.java`
5. Test APIs using Postman

---

## 🔮 Future Improvements
- Real USSD telecom integration
- Authentication & security (JWT)
- SMS notifications
- Mobile application frontend

---

## 👤 Author
**Dawit Mekonnen Abera**  
Biomedical Engineering Student  
Ethiopia 🇪🇹

