<?php
/*
	Creador		:	Asfo
	Proyecto	:	iNotas
	Versión		:	1.0
	Copyright	:	(C) 2011 Asfo
	Archivo		:	index.php
*/
	require("System.php");
	if(isset($_GET['file']))
	{
		$Codigo = mysql_real_escape_string($_GET['file']);
		$InfoSQL = "SELECT `titulo`, `paste`, `lenguaje`, `usuario` FROM `pastes` WHERE `codigo` = '".$Codigo."' LIMIT 1";
		$InfoQuery = @mysql_query($InfoSQL);
		if(!$InfoQuery)
		{
			$Titulo = "Error";
			$Lenguaje = "leng-simple";
			$Usuario = "";
			$Paste = "Al parecer hubo un error al obtener la informaci&oacute;n de esta iNota";
		}
		else
		{
			$Titulo = "";
			$Paste = "";
			$Lenguaje = "";
			$Usuario = "";
			if(mysql_num_rows($InfoQuery) < 1)
			{
				$Titulo = "Error";
				$Paste = "La iNota solicitada no fue encontrada";
				$Lenguaje = "leng-simple";
				$Usuario = "";
			}
			else
			{
				while($Info = mysql_fetch_object($InfoQuery))
				{
					$Titulo = $Info -> titulo;
					$Paste = $Info -> paste;
					$Lenguaje = $Info -> lenguaje;
					$Usuario = $Info -> usuario;
				}
			}
		}
		if($_GET['file'] == 'error')
		{
			$Titulo = "Error";
			$Usuario = "";
			$Lenguaje = "leng-simple";
			$Paste = "Al parecer hubo un errror al procesar esta iNota";
		}
	}
	else
	{
		$Titulo = "Error";
		$Lenguaje = "leng-simple";
		$Usuario = "";
		$Paste = "No se envi&oacute; la referencia del archivo";
	}
?>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" /> 
	<title>iNotas - Creador de notas</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<!--
		 _ _   _       _            
		(_) \ | | ___ | |_ __ _ ___ 
		| |  \| |/ _ \| __/ _` / __|
		| | |\  | (_) | || (_| \__ \
		|_|_| \_|\___/ \__\__,_|___/ v1beta
		Desarrollado por Asfo (C) 2011.
	-->
	<style type="text/css">
		
	</style>
	<script src="../js/jquery.elastic.source.js" type="text/javascript" charset="utf-8"></script>
	<script src="../js/jquery.dropkick-1.0.0.js" type="text/javascript" charset="utf-8"></script>
	<script src="../js/jquery.showMessage.js" type="text/javascript" charset="utf-8"></script>
	<script src="../js/prettify.js" type="text/javascript" charset="utf-8"></script>
	<link href="../css/prettify.css" type="text/css" rel="stylesheet" />
	<link href="../css/style.css" type="text/css" rel="stylesheet" />
	<link href="../css/dropkick.css" type="text/css" rel="stylesheet" />
</head>
<body onload="prettyPrint()">
	<!--<div id="mensajeSuperior">
		<div class="contenedor">
			<div class="contenidoMensajeSuperior">
				<span style="float:left;" id="mensaje">Esto es una p&aacute;gina de <b>pruebas</b> &uacute;nicamente...</span><span style="float:right;"><a href="#cerrarMensajeSuperior" id="cerrarMensajeSuperior"><img src="cerrar.gif" alt="cerrar"/></a></span>
			</div>
		</div>
	</div>-->
	<div class="clear">&nbsp;</div>
	<header>
		<div class="contenedor">
			<div style="float:left;">
				<div id="logo">iNotas</div>
				<span id="logoSub">Guarda tus notas y comp&aacute;rtelas con el mundo.</span>
			</div>
			<div style="float:right;">
				<div id="menu">
					<a href="http://<?php echo $_SERVER['SERVER_NAME']; ?>">Crear nueva iNota</a> | <a href="#ayuda">Ayuda</a>
				</div>
			</div>
		</div>
	</header>
	<section id="contenido">
		<div class="contenedor">
			<div id="nuevoPaste">
				<div style="float:left;">
					<span><?php echo $Titulo; ?></span>
				</div>
				<div style="float:right;">
					<a href="#iniciarSesion" id="iniciarSesion">Iniciar Sesi&oacute;n</a> | 
					<a href="#Registrarse">Registrarse</a>
				</div>
			</div>
			<div id="nuevoPasteContenido" style="margin-top: -3px;">
				<img src="../images/notas_top.jpg" alt="top" style="margin-top: -6px; margin-left: 0px; border-left: solid rgb(202, 207, 213) 1px;  border-right: solid rgb(202, 207, 213) 1px; " />
				<div id="contenidoPaste">
					<code class="<?php if($Lenguaje == 'leng-simple') echo ""; else echo "prettyprint ".$Lenguaje; ?>">
						<?php echo nl2br($Paste); ?>
					</code>
				</div>
					<img src="../images/bottom_paste.jpg" alt="bottom" style="margin-top: -6px; margin-left: -1px; width: 951px; "/>
					<div style="float:left;">
						<span style="font-size:12px; color: #AAA; font-weight: bold; text-shadow: #DDD 0px 1px 0px;">URL:</span><br />
						<input type="text" name="url" value="<?php echo $_SERVER['SERVER_NAME']; ?>/N/?file=<?php if(isset($_GET['file'])) echo $_GET['file']; else echo "error"; ?>	"  style="background:#fff; outline:none; -moz-box-shadow:inset 0 1px 1px #f2f2f2; width:216px; font:12px 'Helvetica Neue', Helvetica, Arial, sans-serif; padding:7px; margin:0 0 15px 0; -webkit-box-shadow:inset 0 1px 1px #f2f2f2; box-shadow:inset 0 1px 1px #f2f2f2; color:#888; border:1px solid #cdcdce;" />	
					</div>
					<div style="float:right;">
						<span style="font-size:12px; color: #AAA; font-weight: bold; text-shadow: #DDD 0px 1px 0px;">Compartir en:</span><br />
						<img src="../images/twitter.png" alt="twitter" />
						<img src="../images/facebook.png" alt="facebook" />
					</div>
			</div>
		</div>
	</section>
	<div class="clear">&nbsp;</div>
	<footer>
		<div class="contenedor">
			<hr />
			Copyright &copy; 2011 <b>iAsfo</b> | Funciona mejor con <b>Google Chrome</b>.
		</div>
	</footer>
	<div class="clear">&nbsp;</div>
</body>
</html>