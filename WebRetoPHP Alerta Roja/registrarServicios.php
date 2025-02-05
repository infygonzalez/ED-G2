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
    <link rel="stylesheet" href="estilosRegistrarServicios.css">
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

        <p>¿Que servicio quieres registar?</p>
        <div class="radio-group">
            <div class="agrupado">
                <input type="radio" name="ocultar" value="vuelo" onclick="mostrarFormulario('vuelo')">
                <label for="vuelo">Vuelo</label>
            </div>
            <div class="agrupado">
                <input type="radio" name="ocultar" value="hotel" onclick="mostrarFormulario('hotel')">
                <label for="alojamiento">Alojamiento</label>
            </div>
            <div class="agrupado">
                <input type="radio" name="ocultar" value="otros" onclick="mostrarFormulario('otros')">
                <label for="vuelo">Otros</label>
            </div>
        </div>
        <!--Sección Vuelo-->
        <div id="vuelo-section" class="ocultar">
            <p>¿Que tipo de vuelo es?</p>
            <div class="radio-group2">
                <div class="agrupado">
                    <input type="radio" name="tipoVuelo" value="ida" onclick="mostrarFormularioVuelo('ida')">
                    <label>Ida</label>
                </div>
                <div class="agrupado">
                    <input type="radio" name="tipoVuelo" value="ida-vuelta"
                        onclick="mostrarFormularioVuelo('ida-vuelta')">
                    <label>Ida / Vuelta</label>
                </div>
            </div>

            <label for="aeropuerto-procedencia">Aeropuerto de Procedencia:</label>
            <select id="aeropuerto-procedencia" name="aeropuerto-procedencia" required>
                <option value="Alicante">Alicante</option>
                <option value="Asturias">Asturias</option>
                <option value="Barcelona">Barcelona</option>
                <option value="Córdoba">Córdoba</option>
                <option value="Gerona">Gerona</option>
                <option value="Granada">Granada</option>
                <option value="Ibiza">Ibiza</option>
                <option value="La Coruña LCG">La Coruña LCG</option>
                <option value="Lanzarote">Lanzarote</option>
                <option value="Madrid">Madrid</option>
                <option value="MAHON">MAHON</option>
                <option value="Murcia">Murcia</option>
                <option value="Pamplona">Pamplona</option>
                <option value="Salamanca">Salamanca</option>
                <option value="Santa Cruz de la Palma">Santa Cruz de la Palma</option>
                <option value="Santiago de Compostela">Santiago de Compostela</option>
                <option value="Valencia">Valencia</option>
                <option value="Vigo">Vigo</option>
                <option value="Zaragoza">Zaragoza</option>
                <option value="Badajoz">Badajoz</option>
                <option value="Bilbao">Bilbao</option>
                <option value="VITORIA">VITORIA</option>
                <option value="Tenerife Norte">Tenerife Norte</option>
                <option value="Tenerife Sur">Tenerife Sur</option>
                <option value="SANTANDER">SANTANDER</option>
                <option value="SAN SEBASTIAN">SAN SEBASTIAN</option>
                <option value="REUS">REUS</option>
                <option value="PALMA DE MALLORCA">PALMA DE MALLORCA</option>
                <option value="MALAGA">MALAGA</option>
                <option value="JEREZ DE LA FRONTERA">JEREZ DE LA FRONTERA</option>
                <option value="GRAN CANARIA">GRAN CANARIA</option>
                <option value="FUERTEVENTURA">FUERTEVENTURA</option>
                <option value="HIERRO">HIERRO</option>
                <option value="LA GOMERA">LA GOMERA</option>
                <option value="Montreal, Québec">Montreal, Québec</option>
                <option value="CANADA Ottawa, Ontario YOW">CANADA Ottawa, Ontario YOW</option>
                <option value="CANADA Toronto, Ontario YTO">CANADA Toronto, Ontario YTO</option>
                <option value="CANADA VANCOUVER">CANADA VANCOUVER</option>
                <option value="Boston">Boston</option>
                <option value="Houston">Houston</option>
                <option value="Miami">Miami</option>
                <option value="LOS ANGELES">LOS ANGELES</option>
                <option value="Nueva York">Nueva York</option>
                <option value="DETROIT">DETROIT</option>
                <option value="Philadelphia PHL">Philadelphia PHL</option>
                <option value="SAN FRANCISCO">SAN FRANCISCO</option>
                <option value="Seattle">Seattle</option>
                <option value="WASHINGTON">WASHINGTON</option>
                <option value="REPUBLICA DOMINICANA (Santo Domingo)">REPUBLICA DOMINICANA (Santo Domingo)</option>
                <option value="JAMAICA (kingston)">JAMAICA (kingston)</option>
                <option value="Buenos Aires">Buenos Aires</option>
                <option value="BRASIL (Rio de Janeiro)">BRASIL (Rio de Janeiro)</option>
                <option value="BRASIL (Sao Paulo)">BRASIL (Sao Paulo)</option>
                <option value="COLOMBIA Bogotá">COLOMBIA Bogotá</option>
                <option value="PERU (Lima)">PERU (Lima)</option>
                <option value="VENEZUELA (CARACAS)">VENEZUELA (CARACAS)</option>
                <option value="AUSTRIA (Viena)">AUSTRIA (Viena)</option>
                <option value="REPUBLICA CHECA (Praga)">REPUBLICA CHECA (Praga)</option>
                <option value="FINLANDIA (Helsinki)">FINLANDIA (Helsinki)</option>
                <option value="FRANCIA (Lyon)">FRANCIA (Lyon)</option>
                <option value="FRANCIA, París (aeropuerto Charles de Gaulle)">FRANCIA, París (aeropuerto Charles de
                    Gaulle)</option>
                <option value="FRANCIA, Le Bourget">FRANCIA, Le Bourget</option>
                <option value="FRANCIA (ORLY)">FRANCIA (ORLY)</option>
                <option value="FRANCIA (Marsella)">FRANCIA (Marsella)</option>
                <option value="ALEMANIA (Berlín)">ALEMANIA (Berlín)</option>
                <option value="ALEMANIA (Dusseldorf)">ALEMANIA (Dusseldorf)</option>
                <option value="ALEMANIA (Frankfurt)">ALEMANIA (Frankfurt)</option>
                <option value="ALEMANIA (Munich)">ALEMANIA (Munich)</option>
                <option value="ALEMANIA (Hamburgo)">ALEMANIA (Hamburgo)</option>
                <option value="GRECIA (Atenas)">GRECIA (Atenas)</option>
                <option value="IRLANDA (DUBLIN)">IRLANDA (DUBLIN)</option>
                <option value="ITALIA (Milán)">ITALIA (Milán)</option>
                <option value="MÉXICO D.F.">MÉXICO D.F.</option>
                <option value="MÉXICO (ACAPULCO)">MÉXICO (ACAPULCO)</option>
                <option value="BRASIL (Brasilia)">BRASIL (Brasilia)</option>
                <option value="ALEMANIA (Stuttgart)">ALEMANIA (Stuttgart)</option>
                <option value="DINAMARCA">DINAMARCA</option>
                <option value="BELGICA (Bruselas)">BELGICA (Bruselas)</option>
                <option value="HOLANDA (Amsterdam)">HOLANDA (Amsterdam)</option>
                <option value="NORUEGA (Oslo)">NORUEGA (Oslo)</option>
                <option value="POLONIA (Varsovia) WAW">POLONIA (Varsovia) WAW</option>
                <option value="PORTUGAL (Lisboa)">PORTUGAL (Lisboa)</option>
                <option value="SUECIA (Estocolmo)">SUECIA (Estocolmo)</option>
                <option value="RUSIA (Moscú) MOW">RUSIA (Moscú) MOW</option>
                <option value="SUIZA (Ginebra)">SUIZA (Ginebra)</option>
                <option value="SUIZA (Zurich)">SUIZA (Zurich)</option>
                <option value="TURQUIA (ESTAMBUL)">TURQUIA (ESTAMBUL)</option>
                <option value="LONDRES (GATWICK)">LONDRES (GATWICK)</option>
                <option value="LONDRES (Heathrow)">LONDRES (Heathrow)</option>
                <option value="LONDRES (Stansted)">LONDRES (Stansted)</option>
                <option value="EGIPTO (El Cairo)">EGIPTO (El Cairo)</option>
                <option value="KENIA (Nairobi)">KENIA (Nairobi)</option>
                <option value="MARRUECOS (Casablanca)">MARRUECOS (Casablanca)</option>
                <option value="MARRUECOS (Marrakech)">MARRUECOS (Marrakech)</option>
                <option value="Túnez">Túnez</option>
                <option value="JORDANIA (Ammán) AMM">JORDANIA (Ammán) AMM</option>
                <option value="TAILANDIA (Bangkok)">TAILANDIA (Bangkok)</option>
                <option value="AUSTRALIA (Melbourne)">AUSTRALIA (Melbourne)</option>
                <option value="AUSTRALIA (Sydney)">AUSTRALIA (Sydney)</option>
            </select>

            <label for="aeropuerto-destino">Aeropuerto de Destino:</label>
            <select id="aeropuerto-destino" name="aeropuerto-destino" required>
                <option value="Alicante">Alicante</option>
                <option value="Asturias">Asturias</option>
                <option value="Barcelona">Barcelona</option>
                <option value="Córdoba">Córdoba</option>
                <option value="Gerona">Gerona</option>
                <option value="Granada">Granada</option>
                <option value="Ibiza">Ibiza</option>
                <option value="La Coruña LCG">La Coruña LCG</option>
                <option value="Lanzarote">Lanzarote</option>
                <option value="Madrid">Madrid</option>
                <option value="MAHON">MAHON</option>
                <option value="Murcia">Murcia</option>
                <option value="Pamplona">Pamplona</option>
                <option value="Salamanca">Salamanca</option>
                <option value="Santa Cruz de la Palma">Santa Cruz de la Palma</option>
                <option value="Santiago de Compostela">Santiago de Compostela</option>
                <option value="Valencia">Valencia</option>
                <option value="Vigo">Vigo</option>
                <option value="Zaragoza">Zaragoza</option>
                <option value="Badajoz">Badajoz</option>
                <option value="Bilbao">Bilbao</option>
                <option value="VITORIA">VITORIA</option>
                <option value="Tenerife Norte">Tenerife Norte</option>
                <option value="Tenerife Sur">Tenerife Sur</option>
                <option value="SANTANDER">SANTANDER</option>
                <option value="SAN SEBASTIAN">SAN SEBASTIAN</option>
                <option value="REUS">REUS</option>
                <option value="PALMA DE MALLORCA">PALMA DE MALLORCA</option>
                <option value="MALAGA">MALAGA</option>
                <option value="JEREZ DE LA FRONTERA">JEREZ DE LA FRONTERA</option>
                <option value="GRAN CANARIA">GRAN CANARIA</option>
                <option value="FUERTEVENTURA">FUERTEVENTURA</option>
                <option value="HIERRO">HIERRO</option>
                <option value="LA GOMERA">LA GOMERA</option>
                <option value="Montreal, Québec">Montreal, Québec</option>
                <option value="CANADA Ottawa, Ontario YOW">CANADA Ottawa, Ontario YOW</option>
                <option value="CANADA Toronto, Ontario YTO">CANADA Toronto, Ontario YTO</option>
                <option value="CANADA VANCOUVER">CANADA VANCOUVER</option>
                <option value="Boston">Boston</option>
                <option value="Houston">Houston</option>
                <option value="Miami">Miami</option>
                <option value="LOS ANGELES">LOS ANGELES</option>
                <option value="Nueva York">Nueva York</option>
                <option value="DETROIT">DETROIT</option>
                <option value="Philadelphia PHL">Philadelphia PHL</option>
                <option value="SAN FRANCISCO">SAN FRANCISCO</option>
                <option value="Seattle">Seattle</option>
                <option value="WASHINGTON">WASHINGTON</option>
                <option value="REPUBLICA DOMINICANA (Santo Domingo)">REPUBLICA DOMINICANA (Santo Domingo)</option>
                <option value="JAMAICA (kingston)">JAMAICA (kingston)</option>
                <option value="Buenos Aires">Buenos Aires</option>
                <option value="BRASIL (Rio de Janeiro)">BRASIL (Rio de Janeiro)</option>
                <option value="BRASIL (Sao Paulo)">BRASIL (Sao Paulo)</option>
                <option value="COLOMBIA Bogotá">COLOMBIA Bogotá</option>
                <option value="PERU (Lima)">PERU (Lima)</option>
                <option value="VENEZUELA (CARACAS)">VENEZUELA (CARACAS)</option>
                <option value="AUSTRIA (Viena)">AUSTRIA (Viena)</option>
                <option value="REPUBLICA CHECA (Praga)">REPUBLICA CHECA (Praga)</option>
                <option value="FINLANDIA (Helsinki)">FINLANDIA (Helsinki)</option>
                <option value="FRANCIA (Lyon)">FRANCIA (Lyon)</option>
                <option value="FRANCIA, París (aeropuerto Charles de Gaulle)">FRANCIA, París (aeropuerto Charles de
                    Gaulle)</option>
                <option value="FRANCIA, Le Bourget">FRANCIA, Le Bourget</option>
                <option value="FRANCIA (ORLY)">FRANCIA (ORLY)</option>
                <option value="FRANCIA (Marsella)">FRANCIA (Marsella)</option>
                <option value="ALEMANIA (Berlín)">ALEMANIA (Berlín)</option>
                <option value="ALEMANIA (Dusseldorf)">ALEMANIA (Dusseldorf)</option>
                <option value="ALEMANIA (Frankfurt)">ALEMANIA (Frankfurt)</option>
                <option value="ALEMANIA (Munich)">ALEMANIA (Munich)</option>
                <option value="ALEMANIA (Hamburgo)">ALEMANIA (Hamburgo)</option>
                <option value="GRECIA (Atenas)">GRECIA (Atenas)</option>
                <option value="IRLANDA (DUBLIN)">IRLANDA (DUBLIN)</option>
                <option value="ITALIA (Milán)">ITALIA (Milán)</option>
                <option value="MÉXICO D.F.">MÉXICO D.F.</option>
                <option value="MÉXICO (ACAPULCO)">MÉXICO (ACAPULCO)</option>
                <option value="BRASIL (Brasilia)">BRASIL (Brasilia)</option>
                <option value="ALEMANIA (Stuttgart)">ALEMANIA (Stuttgart)</option>
                <option value="DINAMARCA">DINAMARCA</option>
                <option value="BELGICA (Bruselas)">BELGICA (Bruselas)</option>
                <option value="HOLANDA (Amsterdam)">HOLANDA (Amsterdam)</option>
                <option value="NORUEGA (Oslo)">NORUEGA (Oslo)</option>
                <option value="POLONIA (Varsovia) WAW">POLONIA (Varsovia) WAW</option>
                <option value="PORTUGAL (Lisboa)">PORTUGAL (Lisboa)</option>
                <option value="SUECIA (Estocolmo)">SUECIA (Estocolmo)</option>
                <option value="RUSIA (Moscú) MOW">RUSIA (Moscú) MOW</option>
                <option value="SUIZA (Ginebra)">SUIZA (Ginebra)</option>
                <option value="SUIZA (Zurich)">SUIZA (Zurich)</option>
                <option value="TURQUIA (ESTAMBUL)">TURQUIA (ESTAMBUL)</option>
                <option value="LONDRES (GATWICK)">LONDRES (GATWICK)</option>
                <option value="LONDRES (Heathrow)">LONDRES (Heathrow)</option>
                <option value="LONDRES (Stansted)">LONDRES (Stansted)</option>
                <option value="EGIPTO (El Cairo)">EGIPTO (El Cairo)</option>
                <option value="KENIA (Nairobi)">KENIA (Nairobi)</option>
                <option value="MARRUECOS (Casablanca)">MARRUECOS (Casablanca)</option>
                <option value="MARRUECOS (Marrakech)">MARRUECOS (Marrakech)</option>
                <option value="Túnez">Túnez</option>
                <option value="JORDANIA (Ammán) AMM">JORDANIA (Ammán) AMM</option>
                <option value="TAILANDIA (Bangkok)">TAILANDIA (Bangkok)</option>
                <option value="AUSTRALIA (Melbourne)">AUSTRALIA (Melbourne)</option>
                <option value="AUSTRALIA (Sydney)">AUSTRALIA (Sydney)</option>
            </select>

            <label for="codigo-vuelo">Código del Vuelo:</label>
            <input type="text" id="codigo-vuelo">

            <label for="aerolinea">Aerolínea:</label>
            <select id="aerolinea" name="aerolinea" required>
                <option value="">--Elige--</option>
                <option value="Vueling">Aerolínea Vueling SA</option>
                <option value="Ryanair">RYANAIR</option>
                <option value="World2Fly">World2Fly</option>
                <option value="Air France">Air France</option>
                <option value="KLM">KLM</option>
                <option value="KLM Cityhopper">KLM Cityhopper</option>
                <option value="TAP Portugal">TAP Portugal</option>
                <option value="World2Fly Portugal">World 2 Fly Portugal, S.A.</option>
                <option value="Finnair">Finnair</option>
                <option value="Brussels Airlines">Brussels Airlines</option>
                <option value="Condor">Condor Flugdienst GmbH</option>
                <option value="Lufthansa">Lufthansa</option>
                <option value="Lufthansa CityLine">Lufthansa CityLine GmbH</option>
                <option value="TUIfly">TUIfly Gmbh</option>
                <option value="TUIfly Nordic">TUIfly Nordic AB</option>
                <option value="Croatia Airlines">Croatia Airlines d.d.</option>
                <option value="Air Nostrum">Air Nostrum, Líneas Aéreas del Mediterráneo SA</option>
                <option value="SATA Air Acores">SATA (Air Acores)</option>
                <option value="SATA Internacional">SATA Internacional - Azores Airlines, S.A.</option>
                <option value="Air Europa">Air Europa Líneas Aéreas, S.A.</option>
                <option value="British Airways">British Airways PLC</option>
                <option value="BA Euroflyer">BA Euroflyer Limited dba British Airways</option>
                <option value="Virgin Atlantic">Virgin Atlantic Airways Ltd</option>
                <option value="Norse Atlantic Airways">Norse Atlantic Airways AS</option>
                <option value="Challenge Airlines">Challenge Airlines (BE) S.A.</option>
                <option value="EasyJet UK">EASYJET UK LIMITED</option>
                <option value="EasyJet Switzerland">Easyjet Switzerland S.A.</option>
                <option value="Edelweiss Air">Edelweiss Air AG</option>
                <option value="Air Greenland">Air Greenland</option>
                <option value="SWISS">SWISS International Air Lines Ltd</option>
                <option value="Turkish Airlines">Turkish Airlines Inc</option>
                <option value="Pegasus Airlines">Pegasus Airlines</option>
                <option value="Malta Air">Malta Air Travel Ltd dba Malta MedAir</option>
                <option value="Alitalia">Alitalia</option>
                <option value="American Airlines">American Airlines</option>
                <option value="LATAM Cargo">BSA - Aerolinhas Brasileiras S.A dba LATAM Cargo Br</option>
                <option value="LATAM Brasil">Tam Linhas Aereas SA dba Latam Airlines Brasil</option>
                <option value="Delta">Delta Air Lines Inc</option>
                <option value="United Airlines">United Airlines Inc</option>
                <option value="China United Airlines">China United Airlines</option>
                <option value="Avianca Ecuador">AVIANCA-Ecuador dba AVIANCA</option>
                <option value="Avianca">Aerovías del Continente Americano S.A. AVIANCA</option>
                <option value="Egyptair">Egyptair</option>
                <option value="Aeroméxico">Aerovías de México SA de CV dba AeroMexico</option>
                <option value="Aerolíneas Argentinas">Aerolíneas Argentinas S.A.</option>
                <option value="Air Transat">Air Transat</option>
                <option value="Royal Jordanian">Alia - The Royal Jordanian Airlines dba Royal Jordanian</option>
                <option value="Qatar Airways">Qatar Airways Group Q.C.S.C dba Qatar Airways</option>
            </select>

            <label for="precio">Precio(€)</label>
            <input type="number" id="precio" required>

            <label for="fecha-salida">Fecha de salida:</label>
            <input type="date" id="fecha-salida">

            <label for="hora-salida">Hora de salida</label>
            <input type="time" id="hora-salida">

            <label for="duracion-viaje">Duración del viaje (en horas):</label>
            <input type="number" id="duracion-viaje">
            <!-- Sección Ida y Vuelta -->
            <div id="vuelta-section" class="ocultar">
                <p>Vuelo(Vuelta)</p>
                <label for="fecha-vuelta">Fecha de Vuelta:</label>
                <input type="date" id="fecha-vuelta">

                <label for="hora-vuelta">Hora de Vuelta:</label>
                <input type="time" id="hora-vuelta">

                <label for="duracion-vuelo-vuelta">Duracion del vuelo de vuelta (en horas):</label>
                <input type="number" id="duracion-vuelo-vuelta">

                <label for="vuelo-codigo-vuelta">Código del Vuelo de Vuelta:</label>
                <input type="text" id="vuelo-codigo-vuelta">

                <label for="aerolinea-vuelta">Aerolinea de vuelta:</label>
                <select name="aerolinea-vuelta" id="aerolinea-vuelta" required>
                    <option value="">--Elige--</option>
                    <option value="Vueling">Aerolínea Vueling SA</option>
                    <option value="Ryanair">RYANAIR</option>
                    <option value="World2Fly">World2Fly</option>
                    <option value="Air France">Air France</option>
                    <option value="KLM">KLM</option>
                    <option value="KLM Cityhopper">KLM Cityhopper</option>
                    <option value="TAP Portugal">TAP Portugal</option>
                    <option value="World2Fly Portugal">World 2 Fly Portugal, S.A.</option>
                    <option value="Finnair">Finnair</option>
                    <option value="Brussels Airlines">Brussels Airlines</option>
                    <option value="Condor">Condor Flugdienst GmbH</option>
                    <option value="Lufthansa">Lufthansa</option>
                    <option value="Lufthansa CityLine">Lufthansa CityLine GmbH</option>
                    <option value="TUIfly">TUIfly Gmbh</option>
                    <option value="TUIfly Nordic">TUIfly Nordic AB</option>
                    <option value="Croatia Airlines">Croatia Airlines d.d.</option>
                    <option value="Air Nostrum">Air Nostrum, Líneas Aéreas del Mediterráneo SA</option>
                    <option value="SATA Air Acores">SATA (Air Acores)</option>
                    <option value="SATA Internacional">SATA Internacional - Azores Airlines, S.A.</option>
                    <option value="Air Europa">Air Europa Líneas Aéreas, S.A.</option>
                    <option value="British Airways">British Airways PLC</option>
                    <option value="BA Euroflyer">BA Euroflyer Limited dba British Airways</option>
                    <option value="Virgin Atlantic">Virgin Atlantic Airways Ltd</option>
                    <option value="Norse Atlantic Airways">Norse Atlantic Airways AS</option>
                    <option value="Challenge Airlines">Challenge Airlines (BE) S.A.</option>
                    <option value="EasyJet UK">EASYJET UK LIMITED</option>
                    <option value="EasyJet Switzerland">Easyjet Switzerland S.A.</option>
                    <option value="Edelweiss Air">Edelweiss Air AG</option>
                    <option value="Air Greenland">Air Greenland</option>
                    <option value="SWISS">SWISS International Air Lines Ltd</option>
                    <option value="Turkish Airlines">Turkish Airlines Inc</option>
                    <option value="Pegasus Airlines">Pegasus Airlines</option>
                    <option value="Malta Air">Malta Air Travel Ltd dba Malta MedAir</option>
                    <option value="Alitalia">Alitalia</option>
                    <option value="American Airlines">American Airlines</option>
                    <option value="LATAM Cargo">BSA - Aerolinhas Brasileiras S.A dba LATAM Cargo Br</option>
                    <option value="LATAM Brasil">Tam Linhas Aereas SA dba Latam Airlines Brasil</option>
                    <option value="Delta">Delta Air Lines Inc</option>
                    <option value="United Airlines">United Airlines Inc</option>
                    <option value="China United Airlines">China United Airlines</option>
                    <option value="Avianca Ecuador">AVIANCA-Ecuador dba AVIANCA</option>
                    <option value="Avianca">Aerovías del Continente Americano S.A. AVIANCA</option>
                    <option value="Egyptair">Egyptair</option>
                    <option value="Aeroméxico">Aerovías de México SA de CV dba AeroMexico</option>
                    <option value="Aerolíneas Argentinas">Aerolíneas Argentinas S.A.</option>
                    <option value="Air Transat">Air Transat</option>
                    <option value="Royal Jordanian">Alia - The Royal Jordanian Airlines dba Royal Jordanian</option>
                    <option value="Qatar Airways">Qatar Airways Group Q.C.S.C dba Qatar Airways</option>
                </select>
            </div>
        </div>
        <!-- Seccion hotel -->
        <div id="hotel-section" class="ocultar">

            <label for="nombre-hotel">Nombre hotel:</label>
            <input type="text" id="nombre-hotel" required>

            <label for="ciudad">Ciudad:</label>
            <input type="text" id="ciudad" required>

            <label for="precio">Precio (€):</label>
            <input type="number" id="precio" required>

            <label for="dia-entrada">Día de entrada:</label>
            <input type="date" id="dia-entrada" required>

            <label for="dia-salida">Día de salida:</label>
            <input type="date" id="dia-salida" required>


            <label for="tipo-habitacion">Tipo de habitación:</label>
            <input list="tipos" id="tipo-habitacion" name="tipo-habitacion" placeholder="--Elige--" required>
            <datalist id="tipos">
                <option value="Doble"></option>
                <option value="Doble uso individual"></option>
                <option value="Individual"></option>
                <option value="Triple"></option>
            </datalist>

        </div>
        <!-- Sección Otros servicios -->
        <div id="otros-section" class="ocultar">
            <label for="otros-info">Información de Otros Servicios:</label>
            <textarea id="otros-info"></textarea>
        </div>

        <button type="submit" id="guardar">Guardar Servicios</button>

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
        function mostrarFormulario(tipo) {
            document.getElementById('vuelo-section').classList.add('ocultar');
            document.getElementById('hotel-section').classList.add('ocultar');
            document.getElementById('otros-section').classList.add('ocultar');

            if (tipo === 'vuelo') {
                document.getElementById('vuelo-section').classList.remove('ocultar');

            } else if (tipo === 'hotel') {

                document.getElementById('hotel-section').classList.remove('ocultar');
            } else if (tipo === 'otros') {
                document.getElementById('otros-section').classList.remove('ocultar');
            }

        }
        function mostrarFormularioVuelo(tipo) {
            document.getElementById('vuelta-section').classList.add('ocultar');

            if (tipo === 'ida-vuelta') {
                document.getElementById('vuelta-section').classList.remove('ocultar');
            }
        }

        document.getElementById("botonCerrar").addEventListener("click", function(event) {
        event.preventDefault();
        window.location.replace("logout.php");
    });


    </script>
</body>

</html>