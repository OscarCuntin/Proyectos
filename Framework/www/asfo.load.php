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
 //Se denega el acceso directo a este archivo
if(!DEFINED('_ACCESS'))
	die("<h1>Error</h1><p>No tienes permiso para acceder aqu&iacute;</p>");
	
ob_start();
session_start();

//Definición de la ruta a la carpeta de la aplicación (www)
DEFINE('WWW_PATH', dirname(__FILE__));

//No sirve esta definición, se elimina su descripción de ayuda
//DEFINE('GET_TEXT', "gettext");

//Demostramos todos los errores, advertencias y noticias que pueda tener el sistema.
error_reporting(E_ALL);

//Archivos de configuración básica y del núcleo del sistema.
if(FILE_EXISTS(WWW_PATH . DS . 'config' . DS . 'config.basics.php'))
{
	include('config' . DS . 'config.basics.php');
	// --- //
	if(FILE_EXISTS(WWW_PATH . DS . 'config' . DS . 'config.core.php'))
		include('config'. DS . 'config.core.php');
	else
		die("<h1>Error</h1><p>El archivo <b>config.core.php</b> no existe</p>");
}
else 
	die("<h1>Error</h1><p>El archivo <b>config.basics.php</b> no existe</p>");

if(!DEFINED('CORE_PATH'))
	die("<h1>Error</h1><p>La configuraci&oacute;n <b>CORE_PATH</b> no est&aacute; definida</p>");	

include CORE_PATH . DS . 'classes' . DS . 'class.load.php';

$Load = new AsfoLoad();

$Helpers = array('i18n', 'router', 'benchmark', 'string', 'sessions', 'security', 'errors');

$Load -> Helper($Helpers);


include CORE_PATH . DS . 'classes' . DS . 'class.controller.php';
include CORE_PATH . DS . 'classes' . DS . 'class.model.php';	


//Si la versión de PHP es menor a la 5.1.0 el sistema no funcionará correctamente.
if(!version_compare(PHP_VERSION, "5.1.0", ">="))
	die("<h1>Error</h1><p>Tu versi&oacute;n de PHP es menor a la 5.1.0 y Asfo Framework necesita una versi&oacute;n superior para funcionar");

//Carga del idioma.
/*
Este formato no sirve por ahora
if(TRANSLATION == GET_TEXT)
{
	$Load -> Library("class.gettext", GET_TEXT);
	$Load -> Library("class.streams", GET_TEXT);
	$Load -> Config("languages");
	
	$languageFile = WWW_PATH . DS . LIB . DS . LANGUAGES . DS . GET_TEXT . DS . LANGUAGE . strtolower(Language()) . DOT . PHP;

	if(!FILE_EXISTS($languageFile))
	{
		$GetText = new GetText($languageFile);
		$GetText -> LoadTables();
	}
	else
		die("<h1>Error</h1><p>Error, el lenguaje seleccionado no existe</p>");
}
*/
//Inicio  de la medición del rendimiento del sistema, aquí se conoce en que momento inició la carga del sistema
benchMarkStart();

header("Cache-Control: no-cache, must-revalidate");
header("Expires: Mon, 26 Jul 1997 05:00:00 GMT"); 
header("Content-type: text/html; charset=utf-8");

//Se ejecuta el sistema y todo el framework
Execute();

//Finaliza la medición del rendimiento del sistema, en este punto sabremos en cuanto tiempo se cargó la aplicación
benchMarkEnd();

//EOF
?>