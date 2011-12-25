<?php
/***********************************************************
 *	
 *		Asfo Framework			
 * 		----------------------------------------------------
 *		Autor		:	Asfo Zavala
 *		Copyright	: 	Copyright (C) 2011, Asfo Zavala
 *		Licencia	:	GNU GPL v3
 *		Link		: 	http://github.com/Asfo/
 *		----------------------------------------------------
 *
 **********************************************************/
 /*
 *	Función que demuestra un error con un estilo predefinido
 *	@Parámetro: String $Title
 *	@Parámetro: String $Message
 */
 function Error($Title = "", $Message = "")
 {
?>
	<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
			<title><?php print $Title; ?></title>
			<link rel="stylesheet" href="<?php print CORE_PATH . DS . 'pages' . DS . 'error.css'; ?>" type="text/css" />
		</head>

		<body>
			<div id="container-error">
				<h1><?php print $Title; ?></h1>
				<p><?php print $Message; ?></p>
			</div>
			<footer>
				Copyright &copy; 2011 Asfo Framework
			</footer>
		</body>
	</html>
<?php
 }
	/*
	*	Función de excepción
	*	@Parámetro: Object $e
	*/
	function Exception($e)
	{
		if(is_object($e))
		{
			echo "C&oacute;digo de Error: " . $e -> getCode() . "<br />";
			echo "Mensaje de Error: " . $e -> getMessage() . "<br />";
			echo "Archivo de Error: " . $e -> getFile() . "<br />";
			echo "L&iacute;nea de Error: " . $e -> getLine() . "<br />";
			exit;
		}
		else
			die(Error('Error', 'La funci&oacute;n <b>Exception($e)</b>debe recibir un argumento de tipo objeto'));
	}
 
 ?>