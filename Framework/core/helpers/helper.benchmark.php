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
 
 function benchMarkStart(){
	global $totalTime;
	$totalTime = microtime(true);
 }
 
 function benchMarkEnd(){
	global $totalTime;
	$totalTime = microtime(true) - $totalTime;
 }
 ?>