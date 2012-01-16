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
 //Acceso denegado a la visualización del archivo directamente.
 if(!DEFINED('ACCESS'))
	die("<h1>Error 403</h1><p>No tienes los permisos suficientes para acceder a este archivo.</p><hr /><i>Galer&iacute;a de Blizzard por <b>Asfo</b> &copy; 2011 | Sistema de Seguridad | <b>Error 403</b>");
	
	DEFINE('WEB_NAME', 'Galer&iacute;a de Blizzard');
	
	DEFINE('MAIN_LANGUAGE', 'es');
	
	DEFINE('WEB_URL', 'http://localhost/fanart/');
	
	DEFINE('MAIN_TEMPLATE', 'default');
	
	DEFINE('DB_HOST', 'localhost');
	
	DEFINE('DB_USER', 'root');
	
	DEFINE('DB_PASS', '');
	
	DEFINE('DB_NAME', 'galeria');
?>