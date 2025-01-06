<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Afisare Ingrediente</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            color: #333;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            color: #4CAF50;
            margin-bottom: 20px;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            border: 1px solid #ddd;
            text-align: left;
            padding: 12px;
        }

        th {
            background-color: #4CAF50;
            color: white;
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        .back-link {
            margin-top: 20px;
            font-size: 16px;
        }

        .back-link a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
        }

        .back-link a:hover {
            text-decoration: underline;
        }

        .error-message {
            color: red;
            font-weight: bold;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Afisare Ingrediente</h1>
    <?php
    // creare variabile cu nume scurte
    $secv = $_POST['Secventa'];
    $nr_matr = trim($secv);
    if (!$secv) {
        echo '<p class="error-message">Trebuie să introduceți o secvență pentru căutare.</p>';
        exit;
    }
    $user = 'root';
    $pass = '';
    $host = 'localhost';
    $db_name = 'restaurant';
    // se conectează la BD
    $connect = mysqli_connect($host, $user, $pass, $db_name);
    // se verifică dacă a funcţionat conectarea
    if ($connect->connect_error) {
        die('<p class="error-message">Eroare la conectare: ' . $connect->connect_error . '</p>');
    }
    // se emite interogarea
    $query = "SELECT ingred_id, nume_ingredient AS Nume FROM ingredient WHERE nume_ingredient LIKE '%$secv%' ORDER BY nume_ingredient ASC";
    $result = mysqli_query($connect, $query);
    // verifică dacă rezultatul este în regulă
    if (!$result) {
        die('<p class="error-message">Interogare greșită: ' . mysqli_error($connect) . '</p>');
    }
    // se obţine numărul tuplelor returnate
    $num_results = mysqli_num_rows($result);
    if ($num_results > 0) {
        echo '<table>
                <tr>
                    <th>#</th>
                    <th>Ingred_id</th>
                    <th>Nume Ingredient</th>
                </tr>';
        for ($i = 0; $i < $num_results; $i++) {
            $row = mysqli_fetch_assoc($result);
            echo '<tr>
                    <td>' . ($i + 1) . '</td>
                    <td>' . htmlspecialchars(stripslashes($row['ingred_id'])) . '</td>
                    <td>' . htmlspecialchars(stripslashes($row['Nume'])) . '</td>
                  </tr>';
        }
        echo '</table>';
    } else {
        echo '<p class="error-message">Nu s-au găsit rezultate pentru criteriile introduse.</p>';
    }
    // deconectarea de la BD
    mysqli_close($connect);
    ?>
    <div class="back-link">
        <a href="/Colocviu/Interogarea1.html">Înapoi</a>
    </div>
</body>
</html>
