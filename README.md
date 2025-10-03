# Employee Records Management System (JDBC)

A **Command-Line Interface (CLI)** application in Java for managing employee records using **JDBC** to connect with a MySQL database.  
This project allows users to **Create, Read, Update, and Delete (CRUD)** employee details such as ID, name, department, and salary. It demonstrates **database connectivity, prepared statements, and basic CRUD operations** in Java.

## Features
1. Add new employee records to the database
2. View all employee records
3. Update existing employee details
4. Delete employee records
5. Safe database operations using **Prepared Statements**

## How CRUD Operations Work

1. **Create (Add Employee)**  
   - Enter employee details such as ID, name, department, and salary.  
   - The record is inserted into the MySQL database.

2. **Read (Display All Employees)**  
   - Retrieves and displays all employee records from the database.

3. **Update (Modify Employee)**  
   - Search for an employee using their ID.  
   - Enter new details to update the employee’s information in the database.

4. **Delete (Remove Employee)**  
   - Search for an employee by ID.  
   - Confirm deletion to remove the employee record from the database.

## How to Run
1. Ensure **MySQL** is installed and running.
2. Create a database and an `employee` table with columns `id`, `name`, `department`, `salary`.
3. Update the database connection details in your Java program (`url`, `user`, `password`).
4. Open the project in **Eclipse** or any Java IDE.
5. Compile and run `EmployeeAccess.java` or your main class.
6. Follow the on-screen menu to perform CRUD operations.

## Project Structure
    EmployeeCRUD/
    │
    ├── src/
    │ ├── Employee.java
    │ ├── EmployeeAccess.java
    │ └── DB_Employee.java
    ├── README.md


## References / Acknowledgements
 [YouType Java Tutorials](https://www.youtype.com) – for concepts and guidance on Java CRUD operations using JDBC.
 Help and guidance from ChatGPT (OpenAI) for code structure, explanations, and README formatting.

## Author
Priyanka M  |  https://github.com/codewith-us-dev

