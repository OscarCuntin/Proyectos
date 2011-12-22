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
	
	function Exception($e)
	{
		if(is_object($e))
		{
			echo "C&oacute;digo de Error: " . $e -> getCode() . "<br />";
			echo "Mensaje de Error: " . $e -> getMessage() . "<br />";
			echo "Archivo de Error: " . $e -> getFile() . "<br />";
			echo "L&iacute;nea de Error: " . $e -> getLine() . "<br />";
			exit;
		}
		else
			die("<h1>Error</h1><p>La funci&oacute;n <b>Exception()</b>debe recibir un argumento de tipo objeto</p>");
	}
	
//EOF
 ?>