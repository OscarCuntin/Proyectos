<?php
/*
	Index.php
	Ayuda: Este archivo es �nicamente para demostrar el uso de Utilidades por Asfo (UpA)
	Primero se incluye el archivo de la librer�a UpA
*/
	require("upa.includes.php");
/*
	Se crea el objeto "ChecarAgente" para comprobar si se navega por un Android
*/
	$ChecarAgente = new UpA\Detect();
/*
	Se comprueba e imprime si es un Android.
*/
	if($ChecarAgente -> isAndroid()) //Si se est� navegando por Android, imprimimos el aviso
		echo "Se est&aacute; navegando por un Android";
	else							//Si no, avisamos que no se est� navegando por Android
		echo "No se est&aacute; navegando por un Android";
?>