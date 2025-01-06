<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rezultate - Rețete cu Ingrediente</title>
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
            text-align: center;
        }

        table {
            width: 100%;
            max-width: 800px;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
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

        .error {
            color: red;
            font-weight: bold;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Rezultate - Rețete cu Ingrediente</h1>

    <?php
    // Preluare și validare date din formular
    $ingredient = isset($_POST['Ingredient']) ? trim($_POST['Ingredient']) : '';
    $cantitate = isset($_POST['cantitate']) ? trim($_POST['cantitate']) : '';
    $um = isset($_POST['um']) ? trim($_POST['um']) : '';

    if (!$ingredient || !$cantitate || !$um) {
        echo '<p class="error">Trebuie să introduceți toate câmpurile: Ingredient, Cantitate și Unitate de Măsură!</p>';
        exit;
    }

    // Conectare la baza de date
    $user = 'root';
    $pass = '';
    $host = 'localhost';
    $db_name = 'restaurant';

    $connect = mysqli_connect($host, $user, $pass, $db_name);

    if (!$connect) {
        die('<p class="error">Eroare la conectare: ' . mysqli_connect_error() . '</p>');
    }

    // Interogare SQL
    $query = "SELECT * FROM `retetecuingrediente` WHERE nume_ingredient = ? AND cantitate = ? AND um = ?";
    $stmt = $connect->prepare($query);
    $stmt->bind_param("sis", $ingredient, $cantitate, $um); // s - string, i - integer
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        echo '<table>
            <tr>
                <th>#</th>
                <th>Nume Rețetă</th>
                <th>Ingredient</th>
                <th>Cantitate</th>
                <th>Unitate de Măsură</th>
            </tr>';

        $i = 0;
        while ($row = $result->fetch_assoc()) {
            $i++;
            echo '<tr>';
            echo '<td>' . $i . '</td>';
            echo '<td>' . htmlspecialchars($row['nume']) . '</td>';
            echo '<td>' . htmlspecialchars($row['nume_ingredient']) . '</td>';
            echo '<td>' . htmlspecialchars($row['cantitate']) . '</td>';
            echo '<td>' . htmlspecialchars($row['um']) . '</td>';
            echo '</tr>';
        }

        echo '</table>';
    } else {
        echo '<p class="error">Nu au fost găsite rețete pentru criteriile specificate.</p>';
    }

    // Închidere conexiune
    $stmt->close();
    $connect->close();
    ?>

    <div class="back-link">
        <a href="/Colocviu/Interogarea2.html">Înapoi</a>
    </div>
</body>
</html>
