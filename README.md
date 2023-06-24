# daofab-transaction-app
# Parent Transactions API and Frontend

This GitHub repository contains a Spring Boot application that implements a REST API for fetching parent transactions from a JSON file, along with an Angular frontend application for displaying and interacting with the parent transaction data.

## Implemented Features

### Backend API (Spring Boot)

- Fetches parent transactions from the provided JSON file (Parent.json).
- Supports server-side pagination to retrieve a subset of parent transactions per page.
- Allows sorting of parent transactions based on different fields.
- Calculates the total paid amount for each parent transaction by considering the child installment payments from a separate JSON file (Child.json).
- Provides response headers with pagination details, including the total number of parent transactions, total pages, and current page.

### Frontend Application (Angular)

- Displays the parent transactions in a table format.
- Supports server-side pagination for navigating through the parent transactions.
- Enables sorting of parent transactions based on different fields.
- Provides a clickable "Total Paid Amount" column that navigates to a separate page showing the corresponding child installment data.

## Technologies Used

### Backend API (Spring Boot)

- Spring Boot
- Spring Web MVC

### Frontend Application (Angular)

- Angular
- TypeScript
- HTML
- CSS

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/parent-transactions.git

2. Build and run the Spring Boot application:
   
   ```bash
   ./gradlew clean build
   ./gradlew bootRun

3. Open the frontend project (Angular)

   Install the dependencies:

   ```bash
   npm install
   ng serve

4.  The API documentation for the backend API provides detailed information about the available endpoints, request/response formats, and query parameters. It can be accessed by opening the following URL in a web browser:

  ```bash
http://localhost:8080/swagger-ui.html
# frontend
http://localhost:4200
