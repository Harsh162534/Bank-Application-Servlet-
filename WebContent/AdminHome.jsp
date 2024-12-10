<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String username = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Home</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    const randomNumberGenerator = () => {
        let acc_num = "";
        // Generate 15 random digits
        for (let i = 0; i < 15; i++) {
            let digit = Math.floor(Math.random() * 10);  // Generate a random number between 0 and 9
            acc_num += digit;  // Append the digit to the string
        }
        document.getElementById('accountNumber').value = acc_num; 
    }
</script>

<style>
/* Custom styles for Admin Home */

/* Sticky Navbar */
.navbar {
	position: sticky;
	top: 0;
	z-index: 1000;
}

/* Styling the content sections */
.content-section {
	display: none;
	padding: 20px;
	margin-top: 20px;
	border: 1px solid #ddd;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* Scrollable content area */
.scrollable-content {
	max-height: 400px; /* Max height for scrolling */
	overflow-y: auto; /* Enable vertical scrolling */
	padding-right: 10px;
}

/* Styling form fields */
.form-control {
	border-radius: 0.25rem;
}

/* Hover effect for navbar items */
.navbar-nav .nav-link:hover {
	/* background-color: #f8f9fa; */
	border-radius: 5px;
}

/* Button Hover Effect */
.btn:hover {
	background-color: #0056b3;
}

/* Styling headings */
h2 {
	color: #007bff;
}

/* Margin for form elements */
.mb-3 {
	margin-bottom: 1.5rem;
}

/* Padding for the body content */
.container {
	padding-top: 50px;
}

/* Add a smooth transition effect for the visibility of content */
.content-section {
	transition: all 0.3s ease;
}

/* Customize the Add Customer and Add Account form buttons */
.btn-custom {
	background-color: #28a745;
	color: white;
	font-size: 16px;
}

.btn-custom:hover {
	background-color: #218838;
}

/* Add background color to the body */
body {
	background-color: #f4f6f9; /* Light gray background */
}
/* Admin Home Button Styling */
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
    z-index: 1000; /* Keep button on top */
}

.btn-admin-home:hover {
    background-color: #80e080; /* Slightly darker green for hover */
    text-decoration: none;
}
</style>
</head>
<body>
	
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Admin Dashboard</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						id="addCustomerTab" href="#">Add New Customer</a></li>

					<li class="nav-item">
					<a class="nav-link" id="addBankAccountTab" href="#" onClick="randomNumberGenerator()">Add Bank Account</a>
						</li>

					<li class="nav-item">
						<form id="viewCustomerForm" action="AdminViewCustomerController"
							method="POST" style="display: inline;">

							<a class="nav-link" id="viewCustomerTab" href="#"
								onclick="document.getElementById('viewCustomerForm').submit();">View
								Customer</a>
						</form>
					</li>

					<li class="nav-item">
						<form id="viewTransactionForm"
							action="AdminViewTransactionController" method="POST"
							style="display: inline;">

							<a class="nav-link" id="viewTransactionTab" href="#"
								onclick="document.getElementById('viewTransactionForm').submit();">View
								Transaction</a>
						</form>
					</li>

				</ul>

				<!-- Admin Home Button -->
				<div>
					<form>
						<!-- Button with Bootstrap classes and custom styling -->
						<a href="login.jsp">
							<button type="button" class="btn-admin-home">LogOut</button>
						</a>
					</form>
				</div>
			</div>
		</div>
	</nav>

	<!-- Main Content -->
	<div class="container">
		<!-- Add New Customer Form -->
		<div id="addCustomerContent" class="content-section">
			<h2>Add New Customer</h2>
			<form action="AdminAddCustomerController" method="Post">
				<div class="mb-3">
					<label for="customerName" class="form-label">Customer First
						Name</label> <input type="text" class="form-control" id="customerfName"
						name="fname" placeholder="Enter customer fname">
				</div>
				<div class="mb-3">
					<label for="customerName" class="form-label">Customer Last
						Name</label> <input type="text" class="form-control" id="customerlName"
						name="lname" placeholder="Enter customer lname">
				</div>
				<div class="mb-3">
					<label for="customerEmail" class="form-label">Customer
						Email</label> <input type="email" class="form-control" id="customerEmail"
						name="email" placeholder="Enter customer email">
				</div>
				<div class="mb-3">
					<label for="customerEmail" class="form-label">Customer
						Password</label> <input type="password" class="form-control"
						id="customerPassword" name="password"
						placeholder="Enter customer password">
				</div>
				<button type="submit" class="btn btn-custom">Add Customer</button>
			</form>
		</div>

		<!-- Add Bank Account Form -->
		<div id="addBankAccountContent" class="content-section"
			style="display: none;">
			<h2>Add Bank Account</h2>
			<form action="AdminAddBankAccountController" method="Post">
				<div class="mb-3">
					<label for="customerEmail" class="form-label">Customer
						Email</label> <input type="email" class="form-control" id="customerCEmail"
						name="Cemail" placeholder="Enter customer email">
				</div>
				<div class="mb-3">
					<label for="accountNumber" class="form-label">Account
						Number</label> <input type="text" class="form-control" id="accountNumber"
						name="AccountNumber" placeholder="Enter account number">
				</div>

				<div class="mb-3">
					<label for="accountType" class="form-label">Account Type</label> <select
						class="form-control" id="accountType" name="AccountType">
						<option value="Current">Current</option>
						<option value="Saving">Savings</option>
					</select>
				</div>

				<button type="submit" class="btn btn-custom">Add Account</button>
			</form>
		</div>

		<!-- Bootstrap JS -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

		<!-- Custom JavaScript for content switching -->
		<script>
			$(document).ready(function() {
				// Initially hide all content sections 
				$(".content-section").hide();

				// Show the Add New Customer section by default 
				$("#addCustomerContent").show();

				// Handle navbar clicks 
				$("#addCustomerTab").click(function(e) {
					e.preventDefault();
					$(".content-section").hide();
					$("#addCustomerContent").show();
				});

				$("#addBankAccountTab").click(function(e) {
					e.preventDefault();
					$(".content-section").hide();
					$("#addBankAccountContent").show();
				});

				$("#viewCustomerTab").click(function(e) {
					e.preventDefault();
					$(".content-section").hide();
					$("#viewCustomerContent").show();
				});

				$("#viewTransactionTab").click(function(e) {
					e.preventDefault();
					$(".content-section").hide();
					$("#viewTransactionContent").show();
				});
			});
		</script>
</body>
</html>
