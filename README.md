# JDBC-MINI-PROJ

## Overview
The **JDBC-MINI-PROJ** is a database-driven application designed to implement a School Management System using **Java** and **JDBC**. It follows a **layered architecture**, ensuring separation of concerns and maintainability. The system includes modules for managing students, teachers, courses, and libraries, alongside database operations.

---

## Features
- **Database Integration**: Uses **JDBC** for seamless database operations.
- **Layered Architecture**: Includes DAO, Service, and Entity layers for modularity.
- **Scalability**: Designed to handle growing data and traffic.
- **Test-Driven**: Includes unit and integration tests to ensure quality.
- **Extensible Design**: Easily adaptable to add new features.

---

## Installation

### Prerequisites
1. Install **Java Development Kit (JDK)** version 8 or later.
2. Install **Apache Maven** for dependency management.
3. Set up a relational database like **MySQL** or **PostgreSQL**.

### Installation Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/JDBC-MINI-PROJ.git
   cd JDBC-MINI-PROJ/imt2022025_JDBC_Project
    ```
### Configure the Database:

1. Execute the SQL scripts in the `sql/` folder:
   ```bash
   mysql -u your-username -p your-database < sql/schema.sql
   mysql -u your-username -p your-database < sql/insert.sql
   ```
2. Update the database credentials in DatabaseManager.java:
   ```bash
   private static final String URL = "jdbc:mysql://localhost:3306/your-database";
   private static final String USER = "your-username";
   private static final String PASSWORD = "your-password";
   ```
3. Install and run the application
   ```bash
   mvn clean install
   java -cp target/jdbc-mini-proj.jar com.schoolmanagement.main.Main
   ```

## Contributors

We would like to thank the following contributors for their valuable input and contributions to this project:

- **[Varnit Mittal](https://github.com/varnit-mittal)** 
- **[Aditya Priyadarshi](https://github.com/ap5967ap)** 
- **[Hemang Seth](https://github.com/Hemang-2004)** 
- **[Rutul Patel](https://github.com/RutulPatel007)** 


If you would like to contribute, feel free to fork the repository and submit a pull request!






   
## License

[MIT](https://github.com/varnit-mittal/JDBC-MINI-Proj/blob/main/LICENSE)
