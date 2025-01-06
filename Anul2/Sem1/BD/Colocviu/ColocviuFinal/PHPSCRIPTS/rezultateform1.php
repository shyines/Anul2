<html>
 <head>
  <title>Afisare note studenti Rezultate</title>
  <style>
   table, th, td
   {
     border: 1px solid black;
   }
  </style>
 </head>
<body>
 <h1>Afisare note studenti Rezultate</h1>
<?php
// creare variabile cu nume scurte
$dSauN=$_POST['D/N'];
$nr_matr= trim($dSauN);
if (!$dSauN)
{
  echo 'Trebuie sa introduceti litera D(DA) sau litera N(NU)';
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
  die('Eroare la conectare: ' . $connect->connect_error);
}
// se emite interogarea
$query = "SELECT descriere FROM reteta WHERE vegetariana = '$dSauNs' order by timp_preparare desc, nume asc";
$result = mysqli_query($connect, $query);
// verifică dacă rezultatul este în regulă
if (!$result)
{
  die('Interogare gresita: ' . mysqli_error());
}
// se obţine numărul tuplelor returnate
$num_results = mysqli_num_rows($result);
// se afişează fiecare tuplă returnată
echo '<table style="width:100%">
  <tr>
    <th>Descriere</th>
  </tr>';
for ($i = 0; $i < $num_results; $i++)
{
  $row = mysqli_fetch_assoc($result);
  
  echo '<tr><td>'.($i+1).'</td>';
  echo '<td>'.htmlspecialchars(stripslashes($row['descriere'])).'</td></tr>';
}
echo '</table>';
// deconectarea de la BD
mysqli_close($connect);
?>
</body>
</html>