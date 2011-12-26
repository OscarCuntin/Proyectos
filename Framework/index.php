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
 
 //Definici�n de la versi�n del Framework
 DEFINE('CORE_VERSION', '0.0.2');
 
 //Definici�n de seguridad
 DEFINE('_ACCESS', TRUE);
 
 //Definici�n de la carpeta ra�z
 DEFINE('ROOT', dirname(__FILE__));
 
 //Definici�n de separaci�n para todos los directorios
 // \ = Windows | / = Linux
 DEFINE('DS', DIRECTORY_SEPARATOR);
 
 //Definici�n de la ruta a la aplicaci�n
 DEFINE('APP_PATH', ROOT . DS . 'www');

	if(FILE_EXISTS(APP_PATH . DS . 'load.php'))
		//Se incluye el arranque del framework
		include(APP_PATH . DS . 'load.php');
	else
		die("<h1>Error</h1><p>El archivo de carga (<b>load.php</b>) no existe o no est&aacute; en la ruta especificada</p>");

?>
