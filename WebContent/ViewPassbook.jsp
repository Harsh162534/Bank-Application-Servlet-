<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Passbook</title>
    <!-- Adding Bootstrap CSS from CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Optional custom CSS for additional styling -->
    <style>
        body {
            background-color: #e0f7fa; /* Light blue background */
            font-family: Arial, sans-serif;
        }

        #passbookContent {
            margin-top: 20px;
        }

        table {
            margin-top: 20px;
            margin-bottom: 20px;
        }

        /* Styling for the button */
        .btn-home {
            position: fixed;
            top: 20px;
            right: 20px;
            background-color: #90EE90; /* Light Green */
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            z-index: 1000; /* Keep button on top */
        }

        .btn-home:hover {
            background-color: #80e080; /* Slightly darker green for hover */
            text-decoration: none;
        }

        /* Styling the table header */
        table th {
            background-color: #4CAF50; /* Green background for the header */
            color: white; /* White text */
        }

        /* Styling for table rows */
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
            <a href="CustomerHome.jsp">
                <button type="button" class="btn-home">Customer Home</button>
            </a>
        </form>
    </div>

    <!-- Main Content -->
    <div class="container">
        <!-- Passbook Section -->
        <div id="passbookContent" class="content-section">
            <h2 class="text-center mb-4">Your Passbook</h2>
          
            <!-- Table for displaying transactions -->
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Sender Acc No</th>
                        <th>Receiver Acc No</th>
                        <th>Type of Transaction</th>
                        <th>Amount</th>
                        <th>Date</th> <!-- Added Date column -->
                    </tr>
                </thead>
                <tbody>
                    <!-- Dynamic rows using JSTL -->
                    <c:forEach var="transaction" items="${transaction}">
                        <tr>
                            <td>${transaction.senderAccountNumber}</td>
                            <td>${transaction.receiverAccountNumber}</td>
                            <td>${transaction.transactionType}</td>
                            <td>${transaction.amount}</td>
                            <td>${transaction.date}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Adding Bootstrap JS and dependencies (jQuery, Popper.js) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
