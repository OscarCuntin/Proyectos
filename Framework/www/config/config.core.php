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
	
//Configuración (por medio de una definición) del nombre de la carpeta de la aplicación [Obligatoria]
DEFINE('CORE_PATH', 'core');

//Configuración (por medio de una definición) en caso de que exista la carpeta "application"
DEFINE('APPLICATION_PATH', 'application');

//Configuración (por medio de una definición) para la carpeta de librerías del núcleo [Obligatoria]
DEFINE('LIBRARY_PATH', 'lib');

//Configuración (por medio de una definición) para el tipo de traducción
DEFINE('TRANSLATION', 'normal');
?>