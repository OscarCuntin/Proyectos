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
	/*---*/
	public $InsertQuery;
	/*---*/
	public $simpleDeleteQuery;
	
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
	
	public function Query($SQL)
	{
		if($SQL != "") //Diferente de vacío
		{
			if(stristr($SQL, "call") && stripos($SQL, "call") == 0)
			{
				//Con la @ evitamos que nos marque un error, sin embargo, debe hacerse un log para errores como este
				@mysql_multi_query($SQL, self::$Connection);
				
				$this -> Query = @mysql_store_result(self::$Connection);
				
				if(@mysql_more_results(self::$Connection))
					@mysql_next_result(self::$Connection);
			}
			else
				$this -> Query = mysql_query($SQL, self::$Connection);
		}
		
		return ($this -> Query) ? $this -> Query : FALSE;
	}
	
	public function Insert($Table, $Columns, $Values)
	{
		if(!$Table || !$Columns || !$Values)
			return false;
								//Visual: "INSERT INTO tabla (`algo`) VALUES (1)";
		$this -> InsertQuery = "INSERT INTO ".$Table." (".$Columns.") VALUES (".$Values.");";
		
		return (mysql_query(self::$Connection, $this -> InsertQuery)) ? true : false;
	}
	
	public function simpleDelete($Table, $Identifier, $Where)
	{
		if(!$Table || !$Identifier || !$Where)
			return false;
									//Visual: "DELETE FROM tabla WHERE algo = 1"
		$this -> simpleDeleteQuery = "DELETE FROM ".$Table." WHERE ".$Where." = ".$Identifier."";
		
		return (mysql_query(self::$Connection, $this -> simpleDeleteQuery)) ? true : false;
	}
}
?>