<?php
session_start();
include('db_config.php'); 

if (!isset($_SESSION['nombre'])) {
    header("Location: Index.php");
    exit();
}

$nombre_usuario = $_SESSION['nombre'];
$color_usuario = $_SESSION['color_usuario'];
$texto_usuario = $_SESSION['texto_usuario'];


$query = "SELECT colorMarca FROM agencia WHERE nombre = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("s", $nombre_usuario);
$stmt->execute();
$result = $stmt->get_result();


if ($result->num_rows > 0) {
    $user = $result->fetch_assoc();
    $color_marca = $user['colorMarca']; 
} else {
    $color_marca = '#F467474'; 
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Viajes Erreka-Mari</title>
  <link rel="stylesheet" href="estilosMenu.css">
</head>
<body>
  <header style="background-color: <?php echo $color_marca; ?>;">
   <a href="menu.php"><img class="fotoHeader" src="img_bienvenida/logoErrekaMari.png" alt="logo"></a>
    <span id="textoUsuario"><?php echo strtoupper($nombre_usuario); ?></span>
    <div class="usuario">
      <span id="nombreUsuario">Hola, <?php echo $nombre_usuario; ?></span>
      <button id="botonCerrar" type="button">Cerrar Sesión</button>
    </div>
  </header>

  <nav>
    <ul class="navegacion">
        <li><a href="registrarViaje.php">Registrar Viaje</a></li>
        <li><a href="registrarServicios.php">Registrar Servicio</a></li>
    </ul>
  </nav>
  <main class="contenedor">
    <div class="carrusel">
        <div class="imagenes-transformables" style="background-image: url(img_bienvenida/torreeifel.jpg)">
          <div class="fade">
            <div class="border-text">
            </div>
          </div>
      </div>
    <div class="imagenes-transformables" style="background-image: url(img_bienvenida/ibiza.jpeg)">
      <div class="fade">
            <a href="http://google.cl" target="_blank" class="border-text">
            </a>
          </div>
      </div>
    <div class="imagenes-transformables" style="background-image: url(img_bienvenida/roma.jpg)">
      <div class="fade">
            <a href="http://google.cl" target="_blank" class="border-text">
            </a>
          </div>
      </div>
    <div class="imagenes-transformables" style="background-image: url(img_bienvenida/tajmahal.jpg)"></div>

      <div class="fade">
            <a href="http://google.cl" target="_blank" class="border-text">
            </a>
          </div>
      </div>   
  </main>

  <footer style="background-color: <?php echo $color_marca; ?>;">
    <ul class="Terminos">
        <li>Legal</li>
        <li>Privacidad</li>
        <li>Condiciones</li>
        <li>Política de cookies</li>
        <li>Propiedad intelectual</li>
    </ul>
    <ul class="Preguntas">
        <li>Preguntas frecuentes</li>
        <li>Destinos</li>
        <li>Prensa</li>
        <li>Contacto</li>
        <li>Código promocional</li>
    </ul>
    <img class="FooterCC" src="img_bienvenida/CC.png" alt="Creative Commons Logo">
  </footer>

  <script>
    document.getElementById("botonCerrar").addEventListener("click", function(event) {
        event.preventDefault();
        window.location.replace("logout.php");
    });
  </script>
</body>
</html>

