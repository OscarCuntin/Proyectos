<?php
/***********************************************************
 *	
 *		Galería de Blizzard
 * 		----------------------------------------------------
 *		Autor		:	Asfo Zavala
 *		Copyright	: 	Copyright (C) 2012, Asfo Zavala
 *		Licencia	:	GNU GPL v3
 *		Link		: 	http://github.com/Asfo/
 *		----------------------------------------------------
 *
 **********************************************************/
 
 DEFINE('CORE_VERSION', '0.0.1.82');
 
 DEFINE('ERROR_REPORTING_CONFIG', E_ALL);
 
 DEFINE('ACCESS', true);
 
 DEFINE('ROOT', dirname(__FILE__));
 
 DEFINE('DS', DIRECTORY_SEPARATOR);
 
 DEFINE('DOT', '.');
 
 DEFINE('SYSTEM_PATH', ROOT . DS . 'system');
 
 DEFINE('THEME_PATH', ROOT . DS . 'theme');
 
 if(FILE_EXISTS(SYSTEM_PATH . DS . 'load.php'))
	include (SYSTEM_PATH . DS . 'load.php');
 else
	die('<h1>Error</h1><p>La carga del sistema no fue encontrada</p>');
 ?>