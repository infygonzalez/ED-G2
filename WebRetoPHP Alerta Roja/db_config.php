<?php
$servername = "127.0.0.1:33060";
$username = "root"; 
$password = "elorrieta"; 
$dbname = "etazi";


$conn = new mysqli($servername, $username, $password, $dbname);


if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}
?>
