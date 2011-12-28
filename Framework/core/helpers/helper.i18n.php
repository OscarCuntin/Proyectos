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
 	include('helper.errors.php');
	
	if(!DEFINED('_ACCESS'))
		die(Error('Error', 'No puedes acceder a este archivo directamente'));
	
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