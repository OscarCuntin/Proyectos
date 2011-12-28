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
		die("<h1>Error</h1> No puedes acceder a este archivo directamente");
	
	
	function _SESSION($SessionName, $Check = FALSE)
	{
		if(!$Check)
		{
			if(isset($_SESSION[$SessionName]))
				return filter($_SESSION[$SessionName]);
			else
				return false;
		}
		else
			$_SESSION[$SessionName] = $Check;
		
		return true;
	}
 ?>