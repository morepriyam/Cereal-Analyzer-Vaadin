
# Cereal Analyzer Vaadin Application

This project is a Vaadin-based web application for analyzing cereal products and their manufacturers. It includes basic user authentication and supports managing cereals and manufacturers.

## Features

- **Vaadin UI**: Provides a modern, interactive user interface.
- **Login Page**: Secure login for users.
- **Cereals Page**: View and manage cereal data.
- **Manufacturers Page**: View and manage manufacturer data.
- **Spring Security**: Handles authentication and access control.
- **MySQL Database**: Stores cereal and manufacturer information.
- **Spring Boot Integration**: Simplifies configuration and setup.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java 17** or higher
- **Maven** for project build
- **MySQL** database server

## Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/yourusername/cereal-analyzer-vaadin.git
    cd cereal-analyzer-vaadin
    ```

2. **Configure the database**:

    Update the `application.properties` file with your MySQL credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/cereal_db?serverTimezone=UTC
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

3. **Run the application**:

    Use the following Maven command to start the application:
    ```bash
    mvn spring-boot:run
    ```

4. **Access the application**:

    Open your browser and go to `http://localhost:8080`.

## Project Structure

- **/login**: User login page.
- **/cereals**: View and manage cereal data.
- **/manufacturers**: View and manage manufacturer data.

## Dependencies

- Spring Boot
- Vaadin
- MySQL Connector
- Spring Security
- Lombok

## Development

To contribute to this project:

1. Fork the repository.
2. Create a new branch.
3. Make your changes and commit them.
4. Push to your fork and submit a pull request.

## License

This project is licensed under the MIT License.
