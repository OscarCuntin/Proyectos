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
 //Se denega el acceso directo a este archivo
 if(!DEFINED('_ACCESS'))
	die("<h1>Error</h1><p>No tienes permiso para acceder aqu&iacute;</p>");
	
ob_start();
session_start();

//Definición de la ruta a la carpeta de la aplicación (www)
DEFINE('WWW_PATH', dirname(__FILE__));

//Archivos de configuración básica y del núcleo del sistema.
if(FILE_EXISTS(WWW_PATH . DS . 'config' . DS . 'config.basics.php'))
{
		include('config' . DS . 'config.basics.php');
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
include CORE_PATH . DS . 'classes' . DS . 'class.controller.php';
include CORE_PATH . DS . 'classes' . DS . 'class.model.php';	

$Load = new AsfoLoad();

$Helpers = array('il8n', 'router', 'benchmark', 'exceptions', 'string', 'sessions', 'security');

$Load -> Helper($Helpers);


?>