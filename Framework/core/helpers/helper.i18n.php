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
		die("<h1>Error</h1><p>No tienes permiso para acceder aqu&iacute;</p>");
	
	 function isLang($Language = FALSE) {
		if(!$Language) 
			$Language = segment(0);	
		//en = English
		if($Language == "en")
			return true;
		//es = Español
		elseif($Language == "es")
			return true;
		//Por default, retorna falso
		return false;
	}
 ?>