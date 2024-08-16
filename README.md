
# Smart Call - Contact Management System

## Project Overview

Smart Call is a comprehensive contact management system built using Java Spring Boot with Maven as the backend, and HTML, Tailwind CSS, and JavaScript as the frontend. The system allows users to register, log in (via email/password or OAuth with Google, GitHub, and Facebook), manage contacts, and perform operations like adding, searching, updating, and deleting contacts. The project is secured with email verification and stores data using a MySQL database.

## Features

- **User Authentication:**  
  Supports login via email/password and OAuth integration (Google, GitHub, and Facebook).

- **Profile Management:**  
  Users can view and update their profiles after logging in.

- **Contact Management:**  
  Add, search (by name, email, or phone number), update, and delete contacts with a user-friendly interface and SweetAlert for enhanced interaction.

- **Email Verification:**  
  Secure registration process with email verification links for account validation.

- **Responsive Design:**  
  Built with Tailwind CSS for a sleek and adaptive interface.

## Tech Stack

- **Backend:** Java Spring Boot, Maven, Spring Security, Thymeleaf
- **Frontend:** HTML, Tailwind CSS, JavaScript
- **Database:** MySQL
- **OAuth Integration:** Google, GitHub, Facebook
- **Alerting:** SweetAlert

## Getting Started

### Prerequisites

- Java 11 or above
- Maven
- MySQL
- Node.js (for Tailwind CSS)
- Git

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/smart-call.git
   ```

2. Navigate to the project directory:

   ```bash
   cd smart-call
   ```
   Or
   ```bash
   Open the Folder in Visual Studio Code.
   ```
   
4. Set up the MySQL database:

   - Create a database named `scm` in MySQL Workbench.
   - Update the `application.properties` file with your MySQL username and password and configure the URL.

5. Build and run the Spring Boot application:

   ```bash
   Go to Spring Boot Dashboard and Run the Application.
   ```
   Or
  ```bash
   Go to Java Project then Right click and Run the Application.
   ```

6. Navigate to the frontend folder and run Tailwind CSS:

   ```bash
   Run this Build Command On Your Terminal
   npx tailwindcss -i src/main/resources/static/css/input.css -o src/main/resources/static/css/output.css --watch
   ```

7. Access the application at `http://localhost:8081`.

### Usage

- Register a new account or log in using your credentials or OAuth.
- Manage your profile and contacts from the dashboard.
- Search, update, or delete contacts using the intuitive UI.

## Screenshots

**Login Page**
![image](https://github.com/user-attachments/assets/82a03239-c301-421d-ba90-2cecaedf5322)
**Register Page**
![image](https://github.com/user-attachments/assets/c7ec28a3-5b46-4c25-82fb-f925f8d5c4ca)
**Profile Page**
![image](https://github.com/user-attachments/assets/5819c543-ed1b-4c80-8bb2-f2f18b57e77c)
**Add Contact Page**
![image](https://github.com/user-attachments/assets/bae5bc43-40c0-45cb-aaa6-a4af37523831)
**View Contact Page**
![image](https://github.com/user-attachments/assets/27b0edd0-6a1d-449e-bdd4-3d08fbce3538)


## Contributing

Contributions are welcome! Please fork this repository and submit a pull request for any improvements.

