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
	
	/*
	* Analiza el momento en que arrancará el sistema.
	*/
	function benchMarkStart(){
		global $totalTime;
		$totalTime = microtime(true);
	}
	/*
	* Basado en el momento en que arrancó el sistema, comprueba en que momento
	* finalizó la carga del sistema.
	*/
	 function benchMarkEnd(){
		global $totalTime;
		$totalTime = microtime(true) - $totalTime;
	 }
 
	/*
	* Analiza la cantidad de memoria utilizada.
	* @Retorna: String
	*/
	function memoryUsage(){
		$Usage = "";
		$memUsage = memory_get_usage(true);
		if($memUsage < 1024)
			$Usage = $memUsage . " Bytes";
		elseif($memUsage < 1048576)
			$Usage = $memUsage . " Kilobytes";
		else
			$Usage = $memUsage. . " Megabytes";
		return $Usage;
	}
 
 //EOF
 ?>