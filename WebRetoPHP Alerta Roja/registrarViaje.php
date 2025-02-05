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
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link
    href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Open+Sans:ital,wght@0,300..800;1,300..800&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap"
    rel="stylesheet">
  <link rel="stylesheet" href="estilosRegistrarViaje.css">
</head>

<body>
  <header style="background-color: <?php echo $color_marca; ?>;">
   <a href="menu.php"><img class="fotoHeader" src="img_bienvenida/logoErrekaMari.png" alt="logo"></a>
    <span id="textoUsuario"></span>
    <div class="usuario">
      <span id="nombreUsuario"></span>
      <button id="botonCerrar" type="button">Cerrar Sesión</button>
    </div>
  </header>
  <fieldset>
    <!--Nombre-->
    <label for="Nombre">Nombre:</label>
    <input type="text">
    <!--Lista tipo de viaje-->
    <label for="Tipo de viaje">Tipo de Viaje:</label>
    <select id="tipos" name="viajes" required>
      <option value="">--Elige--</option>
      <option>Negocios</option>
      <option>Turismo</option>
      <option>Visita familiar</option>
      <option>Estudios</option>
      <option>Luna de miel</option>
      <option>Aventura</option>
      <option>Cultural</option>
      <option>Deportivo</option>
      <option>Crucero</option>
      <option>Religioso</option>
      <option>Otro</option>
    </select>
    <!--Lista tipo de viaje-->
    <label for="salida">Fecha de Inicio:</label>
    <input type="date">
    <!--Lista tipo de viaje-->
    <label for="salida">Fecha de Fin:</label>
    <input type="date">
    <!--Lista tipo de viaje-->
    <label for="Dias">Dias:</label>
    <input type="text">
    <!--Lista tipo de viaje-->
    <label for="Paises">Pais:</label>
    <select id="Paises" name="Paises" required>>
      <option value="">--Elige--</option>
      <option value="ALEMANIA">Alemania</option>
      <option value="ARGENTINA">Argentina</option>
      <option value="AUSTRIA">Austria</option>
      <option value="BÉLGICA">Bélgica</option>
      <option value="BRASIL">Brasil</option>
      <option value="CANADA">Canadá</option>
      <option value="CROACIA">Croacia</option>
      <option value="REPUBLICA_CHECA">República Checa</option>
      <option value="CUBA">Cuba</option>
      <option value="CHINA">China</option>
      <option value="CHIPRE">Chipre</option>
      <option value="DINAMARCA">Dinamarca</option>
      <option value="EGIPTO">Egipto</option>
      <option value="ESPAÑA">España</option>
      <option value="ESTADOS_UNIDOS">Estados Unidos</option>
      <option value="ESTONIA">Estonia</option>
      <option value="FINLANDIA">Finlandia</option>
      <option value="FRANCIA">Francia</option>
      <option value="GRECIA">Grecia</option>
      <option value="GUATEMALA">Guatemala</option>
      <option value="HONG_KONG">Hong Kong</option>
      <option value="HUNGRIA">Hungría</option>
      <option value="INDIA">India</option>
      <option value="INDONESIA">Indonesia</option>
      <option value="IRLANDA">Irlanda</option>
      <option value="ISLANDIA">Islandia</option>
      <option value="ISRAEL">Israel</option>
      <option value="ITALIA">Italia</option>
      <option value="JAMAICA">Jamaica</option>
      <option value="JAPON">Japón</option>
      <option value="KENIA">Kenia</option>
      <option value="LUXEMBURGO">Luxemburgo</option>
      <option value="MALDIVAS">Maldivas</option>
      <option value="MALTA">Malta</option>
      <option value="MARRUECOS">Marruecos</option>
      <option value="MEXICO">México</option>
      <option value="MÓNACO">Mónaco</option>
      <option value="NORUEGA">Noruega</option>
      <option value="PAISES_BAJOS">Países Bajos</option>
      <option value="PANAMA">Panamá</option>
      <option value="PERU">Perú</option>
      <option value="POLONIA">Polonia</option>
      <option value="PORTUGAL">Portugal</option>
      <option value="PUERTO_RICO">Puerto Rico</option>
      <option value="QATAR">Qatar</option>
      <option value="REINO_UNIDO">Reino Unido</option>
      <option value="RUMANIA">Rumania</option>
      <option value="RUSIA">Rusia</option>
      <option value="SEYCHELLES">Seychelles</option>
      <option value="SINGAPUR">Singapur</option>
      <option value="SUDAFRICA">Sudáfrica</option>
      <option value="SUECIA">Suecia</option>
      <option value="SUIZA">Suiza</option>
      <option value="TAILANDIA">Tailandia</option>
      <option value="TANZANIA">Tanzania (incluye Zanzíbar)</option>
      <option value="TUNEZ">Túnez</option>
      <option value="TURQUIA">Turquía</option>
      <option value="VENEZUELA">Venezuela</option>
      <option value="VIETNAM">Vietnam</option>
    </select>
    <!--Lista tipo de viaje-->
    <label for="">Descripcion:</label>
    <textarea name="Descripcion" id="Descripcion" placeholder="Max. 300 Palabras" maxlength="300"></textarea>
    <!--Lista tipo de viaje-->
    <Label>Servicios que se quedan fuera:</Label>
    <textarea name="Servicios" id="Servicios" placeholder="Max. 300 Palabras" maxlength="300"></textarea>

    <!--Lista tipo de viaje-->
    <button type="submit" id="guardar">Guardar Viaje</button>

  </fieldset>
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