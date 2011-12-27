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
 
 //Se denega el acceso a este archivo
 if(!DEFINED('_ACCESS'))
	die("<h1>Error</h1><p>No tienes permiso para acceder aqu&iacute;</p>");
	
//Configuraci�n (por medio de una definici�n) del nombre de la carpeta de la aplicaci�n [Obligatoria]
DEFINE('CORE_PATH', 'core');

//Configuraci�n (por medio de una definici�n) en caso de que exista la carpeta "application"
DEFINE('APPLICATION_PATH', 'applications');

//Configuraci�n (por medio de una definici�n) para la carpeta de librer�as del n�cleo [Obligatoria]
DEFINE('LIBRARY_PATH', 'lib');

//Configuraci�n (por medio de una definici�n) para el idioma
DEFINE('LANGUAGE', 'spanish');

//Configuraci�n (por medio de una definici�n) para la carpeta de los controladores
DEFINE('CONTROLLERS', 'controllers');

//Configuraci�n (por medio de una definici�n) para el nombre inicial del archivo del controlador (controller.nombre.php)
DEFINE('CONTROLLER', 'controller');

//Configuraci�n (por medio de una definici�n) para saber si se est� utilizando el dominio
DEFINE('DOMAIN', FALSE);

//Configuraci�n (por medio de una definici�n) para las URLs amigables (Para un mejor funcionamiento, se debe dejar como "TRUE")
//Posiblemente se elimine esta configuraci�n para hacerla predefinida como TRUE y que siempre se base en URLs amigables
DEFINE('MOD_REWRITE', TRUE);
?>