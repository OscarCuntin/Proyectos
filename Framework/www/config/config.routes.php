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
	if(!DEFINED('_ACCESS'))
		die("<h1>Error</h1><p>No puedes acceder a este archivo directamente.</p>");
	
	$Routes = array(
		0 => array(
			"pattern" 	  => "/^test/",
			"application" => "default",
			"controller"  => "default",
			"method"	  => "test",
			"params"	  => array("Hola", "Adios")
		),
	);
 ?>