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
<title>Customer Dashboard</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
/* Custom styles for Customer Dashboard */
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
	max-height: 400px;
	overflow-y: auto;
	padding-right: 10px;
}
/* Styling form fields */
.form-control {
	border-radius: 0.25rem;
}
/* Hover effect for navbar items */
.navbar-nav .nav-link:hover {
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
			<a class="navbar-brand" href="#">Customer Dashboard</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<!-- Customer Dashboard Options -->

					<li class="nav-item">
						<form id="viewPassbookForm"
							action="CustomerViewPassbookController" method="POST"
							style="display: inline;">
							<a class="nav-link" id="viewPassbookTab" href="#"
								onclick="document.getElementById('viewPassbookForm').submit();">Passbook</a>
						</form>
					</li>

					<li class="nav-item"><a class="nav-link"
						id="newTransactionTab" href="#">New Transaction</a></li>
					<li class="nav-item"><a class="nav-link" id="editProfileTab"
						href="#">Edit Profile</a></li>

					<div>
						<form>
							<!-- Button with Bootstrap classes and custom styling -->
							<a href="login.jsp">
								<button type="button" class="btn-admin-home">LogOut</button>
							</a>
						</form>
					</div>

				</ul>

				<!-- Admin Home Button -->

			</div>
		</div>
	</nav>


	<!-- New Transaction Section -->
	<div id="newTransactionContent" class="content-section">
		<h2>New Transaction</h2>
		<form action="CustomerNewTransactionController" method="Post">
			<div class="mb-3">
				<label for="receiverAccount" class="form-label">Sender
					Account Number</label> <input type="text" class="form-control"
					id="senderAccount" name="senderAccount"
					placeholder="Enter sender account number">
			</div>
			<div class="mb-3">
				<label for="receiverAccount" class="form-label">Receiver
					Account Number</label> <input type="text" class="form-control"
					id="receiverAccount" name="receiverAccount"
					placeholder="Enter receiver account number">
			</div>

			<div class="mb-3">
				<label for="amounttype" class="form-label">Type Of
					Transaction</label> <input type="text" class="form-control"
					id="transactionType" name="transactionType"
					placeholder="Enter Transaction Type">
			</div>

			<div class="mb-3">
				<label for="transactionAmount" class="form-label">Transaction
					Amount</label> <input type="number" class="form-control"
					id="transactionAmount" name="amount" placeholder="Enter amount">
			</div>
			<button type="submit" class="btn btn-primary">Transfer Money</button>
		</form>
	</div>

	<!-- Edit Profile Section -->
	<div id="editProfileContent" class="content-section">
		<h2>Edit Profile</h2>
		<form action="CustomerEditProfileController" method="Post">

			<div class="mb-3">
				<label for="customerEmail" class="form-label">Current Email</label>
				<input type="email" class="form-control" id="currentEmail"
					name="Currentemail" placeholder="Enter your Current  email">
			</div>

			<div class="mb-3">
				<label for="customerEmail" class="form-label">New Email</label> <input
					type="email" class="form-control" id="customerEmail"
					name="Newemail" placeholder="Enter your new email">
			</div>

			<div class="mb-3">
				<label for="customerPassword" class="form-label">New
					Password</label> <input type="password" class="form-control"
					id="customerPassword" name="Newpassword"
					placeholder="Enter your new password">
			</div>
			<button type="submit" class="btn btn-primary">Update Profile</button>
		</form>
	</div>

	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<!-- Custom JavaScript for content switching -->
	<script>
		$(document).ready(function() {
			// Initially hide all content sections
			$(".content-section").hide();

			// Show the Passbook section by default
			$("#passbookContent").show();

			// Handle navbar clicks
			$("#passbookTab").click(function(e) {
				e.preventDefault();
				$(".content-section").hide();
				$("#passbookContent").show();
			});

			$("#newTransactionTab").click(function(e) {
				e.preventDefault();
				$(".content-section").hide();
				$("#newTransactionContent").show();
			});

			$("#editProfileTab").click(function(e) {
				e.preventDefault();
				$(".content-section").hide();
				$("#editProfileContent").show();
			});
		});
	</script>

</body>
</html>
