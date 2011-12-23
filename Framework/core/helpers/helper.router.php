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
		die("<h1>Error</h1><p>No puedes acceder a este archivo directamente</p>");
	 function Segment($Segment = 0, $r = FALSE)
	 {
		if($r === FALSE)
		{
			$route = Route();
			
			if(count($route) > 0)
			{
											//To Do:Ver si hay otro método mejor para analizar la longitud de la string
				if(isset($route[$segment]) && strlen($route[$segment]) > 0)
				{
					if($route[$segment] == "0")
						return 0;
					/*
					To Do: Ver si con la parte superior cuenta como "0" en string y retorne un entero en 0
					En caso de que deba obligar a ser exactamente "0", se abrirá este comentario
					elseif($route[$segment]) === "0")
						return 0;
					*/
					else
						return filter($route[$segment]);
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			die("<h1>Error</h1><p>La ruta (en la funci&oacute;n: <b>Segment()</b> no puede ser verdadera si no ha sido marcada</p>");
	 }
	 function Segments($r = FALSE)
	 {
		if($r === FALSE)
		{
			$route = Route();
			return count($route);
		}
		else
			die("<h1>Error</h1><p>La ruta (en la funci&oacute;n: <b>Segments()</b> no puede ser verdadera si no ha sido marcada</p>");
	 }
	 function Execute()
	 {
		global $Load;
		//To Do: Ver si es mejor hacerlas globales...
		$controlApp = FALSE; /* --- */ $Match = FALSE;
		
		if(FILE_EXISTS(WWW_PATH . DS . 'config' . DS . 'config.routes.php'))
		{
		
		}
	 }
?>