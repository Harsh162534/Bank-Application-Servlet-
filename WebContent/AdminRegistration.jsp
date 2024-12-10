<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Registration Form</title>
    <style>
        /* Body styling */
        body {
            background-color: #d9f7be; /* Light green background color */
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Arial, sans-serif;
            margin: 0;
        }

        /* Container styling */
        .form-container {
            width: 400px;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: white;
        }

        .form-container h2 {
            text-align: center;
            font-size: 2rem;
            color: #333;
            margin-bottom: 20px;
        }

        /* Input and label styling */
        .form-container label {
            font-weight: bold;
            margin-bottom: 10px;
        }

        .form-container input[type="text"],
        .form-container input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 20px;
            font-size: 1rem;
        }

        /* Submit button styling */
        .form-container input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 25px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        /* Submit button hover effect */
        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Add some margin to the bottom of the form */
        .form-container .form-group {
            margin-bottom: 20px;
        }

    </style>
</head>
<body>

    <div class="form-container">
        <h2>Admin Registration Form</h2>
        <!-- Form for username and password -->
        <form action="AdminRegistrationController" method="post">

            <!-- Username Field -->
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>

            <!-- Password Field -->
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>

            <!-- Submit Button -->
            <input type="submit" value="Submit">
        </form>
    </div>

</body>
</html>
