<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Customers</title>

    <!-- Include Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Custom CSS for better visual appearance */
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa; /* Light blue background */
        }

        .content-section {
            margin-top: 20px;
            margin-bottom: 20px;
        }

        .scrollable-content {
            max-height: 500px;
            overflow-y: auto;
        }

        table th, table td {
            text-align: center;
        }

        .container {
            margin-top: 20px;
        }

        /* Styling the Admin Home button */
        .btn-admin-home {
            position: fixed;
            top: 20px;
            right: 20px;
            background-color: #90EE90; /* Light Green */
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            z-index: 1000; /* Make sure it stays above the table */
        }

        .btn-admin-home:hover {
            background-color: #80e080; /* Slightly darker green for hover effect */
            text-decoration: none;
        }

        /* Add margin-top to content to ensure the table doesn't overlap with the button */
        .view-customers-content {
            margin-top: 80px; /* Adjust this value to make space for the button */
        }

        /* Table Header Styling */
        table th {
            background-color: #4CAF50; /* Green color for the header */
            color: white; /* White text color */
        }

        /* Table Rows Styling */
        table tr:nth-child(even) {
            background-color: #f2f2f2; /* Light grey for even rows */
        }
        
        table tr:hover {
            background-color: #ddd; /* Light grey when hovering over rows */
        }

    </style>
</head>
<body>

    <!-- Admin Home Button -->
    <div>
        <form>
            <!-- Button with Bootstrap classes and custom styling -->
            <a href="AdminHome.jsp">
                <button type="button" class="btn-admin-home">Admin Home</button>
            </a>
        </form>
    </div>

    <!-- View Customers Section -->
    <div id="viewCustomerContent" class="container content-section scrollable-content view-customers-content">

        <!-- Check if customers list is not empty -->
        <c:if test="${not empty customers}">
            <!-- Table for customer details -->
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <!-- You may choose not to display password for security reasons -->
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through customers and display data -->
                    <c:forEach var="customer" items="${customers}">
                        <tr>
                            <td>${customer.fname}</td>
                            <td>${customer.lname}</td>
                            <td>${customer.email}</td>
                            <td>${customer.password}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <!-- Display error message if there are no customers -->
        <c:if test="${empty customers}">
            <div class="alert alert-warning" role="alert">No customers available.</div>
        </c:if>

    </div>

    <!-- Include Bootstrap JS (optional, for features like modals, dropdowns, etc.) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
