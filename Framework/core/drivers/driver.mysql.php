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

class AsfoMySQL extends AsfoLoad
{
	private static $Connection;
	/*---*/
	private $SQL;
	
	public function __construct()
	{
	
	}
	/*
	*
	*/
	public function Connect($Enable = true)//Predefinidiamente, está activada la conexión
	{
		if($Enable)//$Enable == True
		{
			if(self::$Connection == NULL)
			{
				if(!DEFINED('DB_HOST'))
					die("<h1>Error</h1><p>La configuraci&oacute;n: <b>DB_HOST</b> no existe.</p>");
				if(!DEFINED('DB_USER'))
					die("<h1>Error</h1><p>La configuraci&oacute;n <b>DB_USER</b> no existe.</p>");
				if(!DEFINED('DB_PASSWORD'))
					die("<h1>Error</h1><p>La configuraci&oacute;n <b>DB_PASSWORD</b> no existe.</p>");
				if(!DEFINED('DB_NAME'))
					die("<h1>Error</h1><p>La configuraci&oacute;n <b>DB_NAME</b> no existe.</p>");
				/*---*/
				self::$Connection = mysql_connect(DB_HOST, DB_USER, DB_PASSWORD) or die ("<h1>Error</h1><p>Error conectando a la base de datos</p>");
				mysql_select_db(DB_NAME);
			}
		}
		else
			return self::$Connection;
	}
}
?>