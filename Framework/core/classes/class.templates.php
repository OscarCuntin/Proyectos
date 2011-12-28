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
	
class AsfoTemplates extends AsfoLoad
{
	public $CSS = NULL;
	/*---*/
	public $Helpers;
	/*---*/
	public $JS = NULL;
	/*---*/
	private $THEME = NULL;
	/*---*/
	private $themePath;
	/*---*/
	private $Vars = array();
	
	public function __construct()
	{
		$this -> Helpers = array('array', 'browser', 'detect', 'debugging', 'forms', 'html', 'scripts', 'validations');
		$this -> Helper($this -> Helpers);
		$this -> Config('cache');
		$this -> Config('templates');
	}
	
	public function CSS($CSS = NULL, $App = NULL, $Print = FALSE, $Name = NULL)
	{
	
	}
	
	public function Exists($Template, $View = FALSE)
	{
	
	}
	
	public function getThemes($Theme)
	{
	
	}
	
	public function Theme($Theme)
	{
	
	}
	
	public function JS($JS = NULL, $App, $Print = FALSE, $Name = NULL)
	{
	
	}
	
	public function getTitle($ExtraTitle = NULL)
	{
		if(is_null($ExtraTitle))
			return WEB_NAME; //Configuración
		else
			return WEB_NAME . '-' . $ExtraTitle; //Configuración - Título Extra
	}
	
	public function isTheme()
	{
		
	}
	
	public function Load()
	{
	
	}
	
	public function Vars($Vars)
	{
		return $this -> Vars = $Vars;
	}

}
 ?>