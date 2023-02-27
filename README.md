Crime Information Management System

This is a Crime Information Management System that allows law enforcement officials to manage and track crime-related data. The system is built using Java and MySQL.


Getting Started



Prerequisites

To run this project, you will need:

Java Development Kit (JDK) 8 or higher
MySQL Server 8.0 or higher
MySQL Connector/J 8.0 or higher
Eclipse IDE or any other Java IDE of your choice
Installing
Clone this repository to your local machine.
Open the project in your Java IDE.
Create a new MySQL database named cims.
Update the database connection details in the DBUtils.java file.
Run the SQL scripts in the sql folder to create the required database tables.
Run the project.


Features
Add new crimes with details such as date, place, description, victims, etc.
Add new criminals with details such as name, gender, age, address, etc.
Assign a criminal to a crime and vice versa.
View all crimes and their associated criminals.
Search for a crime or criminal by ID or keyword.
Update or delete a crime or criminal.


Built With
Java - The programming language used
MySQL - The relational database management system used
MySQL Connector/J - The JDBC driver used to connect to the MySQL database
Eclipse IDE - The integrated development environment used for coding and debugging




ER Diagram:
            +---------------+
            |     crime     |
            +---------------+
            | crime_id      |
            | date          |
            | place         |
            | description   |
            | victims       |
            | details       |
            | suspected     |
            | status        |
            | area          |
            | police_station|
            +---------------+
                  |
                  |
                  |
            +---------------+
            | crime_criminal|
            +---------------+
            | crime_id      |
            | criminal_id   |
            +---------------+
                  |
                  |
                  |
            +---------------+
            |   criminal    |
            +---------------+
            | criminal_id   |
            | name          |
            | gender        |
            | age           |
            | address       |
            | phone_number  |
            | crime_history |
            | arrested      |
            | police_station|
            +---------------+

