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
 class AsfoSingleton
 {
	private static $Instances = array(); //Private (?)
	
	public static function Instance($Class)
	{
		if(is_null($Class))
			die("<h1>Error</h1><p>El m&eacute;todo <b>Instance()</b> no est&aacute; recibiendo un valor</p>");
		
		if(!array_key_exists($Class, self::$Instances))
			self::$Instances[$Class] = new $Class;
		
		return self::$Instances[$Class];
	}
 
 }
 ?>