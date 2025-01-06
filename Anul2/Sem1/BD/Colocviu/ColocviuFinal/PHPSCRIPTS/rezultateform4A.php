<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rezultate - Minim, Medie, Max, Dif</title>
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
    <h1>Rezultate - Minim, Medie, Max, Dif</h1>

    <?php
    // Create variables with short names
    $tip_id = $_POST['tip_id'];
    $tip_id = trim($tip_id);

    // Check if input is empty
    if (!$tip_id) {
        echo '<p class="error">Trebuie sa introduceti un ID valid.</p>';
        exit;
    }

    // Database connection
    $user = 'root';
    $pass = '';
    $host = 'localhost';
    $db_name = 'restaurant';

    // Connect to the database
    $connect = mysqli_connect($host, $user, $pass, $db_name);

    // Check if connection was successful
    if ($connect->connect_error) {
        die('<p class="error">Eroare la conectare: ' . $connect->connect_error . '</p>');
    }

    // Sanitize input to prevent SQL injection
    $tip_id = mysqli_real_escape_string($connect, $tip_id);

    // Prepare the SQL query
    // Preparăm interogarea SQL pentru a apela funcția UDF
    $query = "SELECT 
    categ_id,
    tip,
    timp_minim,
    timp_mediu,
    timp_maxim,
    calcul_diferenta_maxim_mediu($tip_id) AS diferenta
    FROM 
    categorii 
    WHERE 
    categ_id = '$tip_id'";

    // Executăm interogarea
    $result = mysqli_query($connect, $query);

    // Verificăm dacă interogarea a fost realizată cu succes
    if (!$result) {
    die('<p class="error">Interogare gresita: ' . mysqli_error($connect) . '</p>');
    }

    // Obținem numărul de rânduri returnate
    $num_results = mysqli_num_rows($result);

    // Afișăm rezultatele
    if ($num_results > 0) {
    echo '<table>
    <tr>
    <th>Categorie</th>
    <th>Tip</th>
    <th>Timp minim</th>
    <th>Timp mediu</th>
    <th>Timp maxim</th>
    <th>Diferenta (Maxim - Mediu)</th>
    </tr>';
    while ($row = mysqli_fetch_assoc($result)) {
    echo '<tr>';
    echo '<td>' . htmlspecialchars(stripslashes($row['categ_id'])) . '</td>';
    echo '<td>' . stripslashes($row['tip']) . '</td>';
    echo '<td>' . stripslashes($row['timp_minim']) . '</td>';
    echo '<td>' . stripslashes($row['timp_mediu']) . '</td>';
    echo '<td>' . stripslashes($row['timp_maxim']) . '</td>';
    echo '<td>' . stripslashes($row['diferenta']) . '</td>';
    echo '</tr>';
    }
    echo '</table>';
    } else {
    echo '<p class="error">Nu au fost gasite retete pentru acest tip.</p>';
    }
    ?>
    <div class="back-link">
        <a href="/Colocviu/Interogarea4.html">Înapoi</a>
    </div>
</body>
</html>
