<?php
/***********************************************************
 *	
 *		Asfo Framework			
 * 		----------------------------------------------------
 *		Autor		:	Asfo Zavala
 *		Copyright	: 	Copyright (C) 2011, Asfo Zavala
 *		Licencia	:	GNU GPL v3
 *		----------------------------------------------------
 *
 **********************************************************/
 
 class AsfoLoad	{
 
	public $Application = false;
	
	public $Templates;
	
	public $Views = array();
	
	public function __construct()
	{
		$Helpers = array('autoload', 'router', 'validations');
		
		$this -> Helper($Helpers);
		$this -> Config('cache');
		$this -> Config('exceptions');
		$this -> Config('languages');
	}
	
	public function Helper($Helper, $Application = false)
	{
	
	}
	
	public function Config($Name, $Application = false)
	{
	
	}
 }
 ?>