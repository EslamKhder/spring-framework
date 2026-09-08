<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Player Form</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        .form-container {
            width: 400px;
            margin: auto;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        button {
            padding: 10px 20px;
            cursor: pointer;
        }
    </style>
</head>

<body>

<div class="form-container">

    <h2>Add Player</h2>

    <form action="/player/save" method="post">

        <div class="form-group">
            <label>Name:</label>

            <input type="text"
                   name="name"
                   required>
        </div>

        <div class="form-group">
            <label>Player Number:</label>

            <input type="number"
                   name="number"
                   required>
        </div>

        <div class="form-group">
            <label>Salary:</label>

            <input type="number"
                   name="salary"
                   step="0.01"
                   required>
        </div>

        <button type="submit">
            Save Player
        </button>

    </form>

</div>

</body>
</html>