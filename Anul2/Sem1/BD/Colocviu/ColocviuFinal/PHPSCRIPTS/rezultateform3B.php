<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Afisare note studenti Rezultate</title>
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
    <h1>Afisare note studenti Rezultate</h1>

    <?php
    // creare variabile cu nume scurte

    $ingredient = $_POST['ingredient'];
    //$ingredient = trim($ingredient);

    $um = $_POST['um'];
    //$um = trim($um);

    $reteta = $_POST['reteta'];
    //$reteta = trim($reteta);

    echo "Ingredient: $ingredient<br>";
    echo "UM: $um<br>";
    echo "Reteta: $reteta<br>";

    if (!$reteta || !$um || !$ingredient)
    {
        echo '<p class="error">Trebuie sa introduceti litera D(DA) sau litera N(NU)</p>';
        exit;
    }
    $user = 'root';
    $pass = '';
    $host = 'localhost';
    $db_name = 'restaurant';
    // se conectează la BD
    $connect = mysqli_connect($host, $user, $pass, $db_name);
    // se verifică dacă a funcţionat conectarea
    if ($connect->connect_error)
    {
        die('<p class="error">Eroare la conectare: ' . $connect->connect_error . '</p>');
    }
    // se emite interogarea

    $ingredient = mysqli_real_escape_string($connect, trim(strtolower($_POST['ingredient'])));
    $reteta = mysqli_real_escape_string($connect, trim(strtolower($_POST['reteta'])));
    $um = mysqli_real_escape_string($connect, trim(strtolower($_POST['um'])));

    echo "Ingredient: $ingredient<br>";
    echo "UM: $um<br>";
    echo "Reteta: $reteta<br>";

    $query = "SELECT 
        r.nume AS nume_reteta, 
        r.descriere, 
        r.timp_preparare, 
        si.cantitate, 
        si.um
    FROM 
        Reteta r
    JOIN 
        Set_Ingrediente si ON r.reteta_id = si.reteta_id
    JOIN 
        Ingredient i ON si.ingred_id = i.ingred_id
    WHERE 
        TRIM(LOWER(i.nume_ingredient)) LIKE TRIM(LOWER('%$ingredient%')) 
        AND si.cantitate > (
            SELECT 
                si2.cantitate
            FROM 
                Reteta r2
            JOIN 
                Set_Ingrediente si2 ON r2.reteta_id = si2.reteta_id
            JOIN 
                Ingredient i2 ON si2.ingred_id = i2.ingred_id
            WHERE 
                TRIM(LOWER(r2.nume)) LIKE TRIM(LOWER('%$reteta%')) 
                AND TRIM(LOWER(i2.nume_ingredient)) LIKE TRIM(LOWER('%$ingredient%')) 
                AND si2.um = '$um'
        )
        AND si.um = '$um';
    ";

    $result = mysqli_query($connect, $query);
    // verifică dacă rezultatul este în regulă
    if (!$result)
    {
        die('<p class="error">Interogare gresita: ' . mysqli_error() . '</p>');
    }
    // se obţine numărul tuplelor returnate
    $num_results = mysqli_num_rows($result);
    // se afişează fiecare tuplă returnată
    echo '<table>
      <tr>
        <th>#</th>
        <th>Reteta</th>
        <th>Descriere</th>
      </tr>';
    for ($i = 0; $i < $num_results; $i++)
    {
        $row = mysqli_fetch_assoc($result);

        echo '<tr><td>'.($i+1).'</td>';
        echo '<td>'.htmlspecialchars(stripslashes($row['nume_reteta'])).'</td>';
        echo '<td>'.stripslashes($row['descriere']).'</td></tr>';
    }
    echo '</table>';
    // deconectarea de la BD
    mysqli_close($connect);
    ?>

    <div class="back-link">
        <a href="/Colocviu/interogarea3.html">Înapoi</a>
    </div>
</body>
</html>
