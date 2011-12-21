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

 //Definición de seguridad
 DEFINE('_ACCESS', TRUE);
 
 //Definición de la carpeta raíz
 DEFINE('ROOT', dirname(__FILE__));
 
 //Definición de separación para todos los directorios
 // \ = Windows | / = Linux
 DEFINE('DS', DIRECTORY_SEPARATOR);
 
 //Definición de la ruta a la aplicación
 DEFINE('APP_PATH', ROOT . DS . 'www');

 //Se incluye el arranque del framework
 include(APP_PATH . DS . 'load.php');
?>
