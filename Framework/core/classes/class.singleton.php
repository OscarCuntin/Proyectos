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
	private static $Instances = array();
	
	public function __construct() { }
	
	public static function Instance($Class)
	{
		if(is_null($Class))
			die(Error("Error", "El m&eacute;todo <b>Instance()</b> no est&aacute; recibiendo un valor"));
		
		if(!array_key_exists($Class, self::$Instances))
			self::$Instances[$Class] = new $Class;
		
		return self::$Instances[$Class];
	}
	
	public function __clone() { }
 
 }
 ?>