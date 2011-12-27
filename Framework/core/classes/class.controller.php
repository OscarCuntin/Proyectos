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
	die(Error("Error", "No puedes acceder a este archivo directamente"));

 class AsfoController extends AsfoLoad
 {
	
	public $Helpers;
 
	public function __construct(){
		$this -> Helpers = array('alerts', 'debugging', 'time', 'string', 'forms', 'security');
	}
 
	public function Helpers(){
		$this -> Helper($this -> Helpers);
	}
 }
 ?>