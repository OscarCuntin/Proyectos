<?php
/***********************************************************
 *	
 *		Asfo Framework			
 * 		----------------------------------------------------
 *		Autor		:	Asfo Zavala
 *		Copyright	: 	Copyright (C) 2011, Asfo Zavala
 *		Licencia	:	GNU GPL v3
 *		----------------------------------------------------
 *
 **********************************************************/

 //Definici�n de seguridad
 DEFINE('_ACCESS', TRUE);
 
 //Definici�n de la carpeta ra�z
 DEFINE('ROOT', dirname(__FILE__));
 
 //Definici�n de separaci�n para todos los directorios
 // \ = Windows | / = Linux
 DEFINE('DS', DIRECTORY_SEPARATOR);
 
 //Definici�n de la ruta a la aplicaci�n
 DEFINE('APP_PATH', ROOT . DS . 'www');

 //Se incluye el arranque del framework
 include(APP_PATH . DS . 'load.php');
?>
