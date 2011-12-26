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
 
 //Definición de la versión del Framework
 DEFINE('CORE_VERSION', '0.0.2');
 
 //Definición de seguridad
 DEFINE('_ACCESS', TRUE);
 
 //Definición de la carpeta raíz
 DEFINE('ROOT', dirname(__FILE__));
 
 //Definición de separación para todos los directorios
 // \ = Windows | / = Linux
 DEFINE('DS', DIRECTORY_SEPARATOR);
 
 //Definición de la ruta a la aplicación
 DEFINE('APP_PATH', ROOT . DS . 'www');

	if(FILE_EXISTS(APP_PATH . DS . 'load.php'))
		//Se incluye el arranque del framework
		include(APP_PATH . DS . 'load.php');
	else
		die("<h1>Error</h1><p>El archivo de carga (<b>load.php</b>) no existe o no est&aacute; en la ruta especificada</p>");

?>
