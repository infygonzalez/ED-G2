<?php
session_start();
include('db_config.php'); 

if (isset($_POST['submit'])) {
    $nombre_usuario = $_POST['nombre'];
    $contraseña = $_POST['contraseña'];  

    $query = "SELECT * FROM agencia WHERE nombre = ? AND clave = ?";
    $stmt = $conn->prepare($query);
    $stmt->bind_param("ss", $nombre_usuario, $contraseña);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $user = $result->fetch_assoc();
        
        $_SESSION['nombre'] = $user['nombre'];
        $_SESSION['color_usuario'] = $user['color'];
        $_SESSION['texto_usuario'] = $user['texto'];

        header("Location: menu.php");
        exit();
    } else {
        $error = "Credenciales incorrectas";
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Viajes Erreka-Mari</title>
  <link rel="stylesheet" href="estilosLogin.css">
</head>
<body>
  <main>
    <form class="login" method="POST" action="">
      <img class="fotoLogin" src="img_bienvenida/logoErrekaMari.png" alt="logo">
      <div class="form-group">
        <input class="inputLogin" type="text" name="nombre" placeholder="Introduce el nombre de usuario" required>
      </div>
      <div class="form-group">
        <input class="inputLogin" type="password" name="contraseña" placeholder="Introduce la contraseña" required>
      </div>
      <button class="loginBtn" type="submit" name="submit">Iniciar sesión</button>
    </form>

    <?php if (isset($error)) { echo "<div class='alerta'>$error</div>"; } ?>
    <style>
    .alerta {
        background-color: #f44336;
        color: white;
        padding: 10px;
        margin-top: 20px;
        text-align: center;
        border-radius: 5px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        font-size: 16px;
    }
</style>
  </main>
</body>
</html>