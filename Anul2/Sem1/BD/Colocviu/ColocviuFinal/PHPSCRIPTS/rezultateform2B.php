<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rezultate - Perechi Ingrediente</title>
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
    <h1>Rezultate - Perechi Ingrediente</h1>

    <?php
    // creare variabile cu nume scurte
    $cantitate = $_POST['cantitate'];
    $cantitate = trim($cantitate);

    $um = $_POST['um'];
    $um = trim($um);

    if (!$cantitate || !$um) {
        echo '<p class="error">Trebuie să introduceți o cantitate și o unitate de măsură!</p>';
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
        die('<p class="error">Eroare la conectare: ' . $connect->connect_error . '</p>');
    }

    // se emite interogarea
    $query = "SELECT DISTINCT 
        LEAST(a.ingred_id, b.ingred_id) AS ingred_id1,
        GREATEST(a.ingred_id, b.ingred_id) AS ingred_id2
    FROM 
        Set_Ingrediente a
    JOIN 
        Set_Ingrediente b
    ON 
        a.cantitate = b.cantitate
        AND a.um = b.um
        AND a.reteta_id != b.reteta_id
        AND a.ingred_id < b.ingred_id
    WHERE 
        a.cantitate = $cantitate
        AND a.um = '$um'
    ORDER BY ingred_id1, ingred_id2";

    $result = mysqli_query($connect, $query);

    // verifică dacă rezultatul este în regulă
    if (!$result) {
        die('<p class="error">Interogare greșită: ' . mysqli_error($connect) . '</p>');
    }

    // se obţine numărul tuplelor returnate
    $num_results = mysqli_num_rows($result);

    if ($num_results > 0) {
        // se afişează fiecare tuplă returnată
        echo '<table>
            <tr>
                <th>#</th>
                <th>Ingred_Id1</th>
                <th>Ingred_Id2</th>
            </tr>';

        for ($i = 0; $i < $num_results; $i++) {
            $row = mysqli_fetch_assoc($result);

            echo '<tr>';
            echo '<td>' . ($i + 1) . '</td>';
            echo '<td>' . htmlspecialchars(stripslashes($row['ingred_id1'])) . '</td>';
            echo '<td>' . htmlspecialchars(stripslashes($row['ingred_id2'])) . '</td>';
            echo '</tr>';
        }

        echo '</table>';
    } else {
        echo '<p class="error">Nu au fost găsite rezultate pentru cantitatea și unitatea de măsură specificate.</p>';
    }

    // deconectarea de la BD
    mysqli_close($connect);
    ?>

    <div class="back-link">
        <a href="/Colocviu/Interogarea2.html">Înapoi</a>
    </div>
</body>
</html>
