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
DEFINE('APPLICATION_PATH', 'application');

//Configuraci�n (por medio de una definici�n) para la carpeta de librer�as del n�cleo [Obligatoria]
DEFINE('LIBRARY_PATH', 'lib');

//Configuraci�n (por medio de una definici�n) para el tipo de traducci�n
DEFINE('TRANSLATION', 'normal');
?>