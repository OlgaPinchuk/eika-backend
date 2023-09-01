# EIKA Shopping List

This is a full-stack shopping list application, which includes a basic user sign-up system. After registering, users can view and manage their shopping lists, marking items as either pending or completed.

## Backend
The backend will be developed using Java with Spring Boot and Hibernate within IntelliJ IDEA, connected to a MySQL database.


## Running the Application

To get the application up and running, follow these steps:

1. **Clone this project**
2. **Create a Database:** In your MySQL instance, create a new database that the application will use.
3. **Configure Database Connection** 
<br>
   * Locate the code `application.properties` file in the `src/main/resources` folder of the directory.
   * Update this file with the following information:
     - **URL:** Set the URL to point to your MySQL database.
     - **Username:** Provide the username to access your database.
     - **Password:** Enter the corresponding password for the provided username.
* Build the project using Maven
* Run the jar file
* Backend shoud be available at http://localhost:8080.

## Project documentation
* [Project requirements and backlog](https://docs.google.com/spreadsheets/d/1ivMQt8TucBqNtSndDSTMuvZO85m08hWWY0iufFsw_UE)
* [User stories](https://docs.google.com/document/d/1O7JpmKHTHHm0QBQuzu4n9lhm5XcubO_daa-LEajNjPY)
* [Use Case Diagram](https://lucid.app/lucidchart/dba4cb21-40c7-4cb3-bb6c-148d56c064c4/edit?viewport_loc=-2035%2C-1135%2C3872%2C1799%2CHs68-Svgrdj8&invitationId=inv_7823189b-c516-4961-8440-a4b1d7481c4e)
* [Class diagram](https://lucid.app/lucidchart/36e21bc2-f523-440a-97f1-0e828e5fcba2/edit?viewport_loc=-4370%2C484%2C2287%2C1049%2C0_0&invitationId=inv_99b2e1d3-fdb1-4634-a0f9-8a190604e951)

## Technology Stack

`Java` v.17.0.2

