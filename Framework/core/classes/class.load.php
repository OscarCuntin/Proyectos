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
 include('../helpers/helper.errors.php');
 
 if(!DEFINED('_ACCESS'))
	die(Error("Error", "No puedes acceder a este archivo directamente"));

 include ("class.singleton.php");
 
 class AsfoLoad
 {
	/*
	*
	*/
	public $Application = false;
	/*
	*
	*/
	public $Templates;
	/*
	*
	*/
	public $Views = array();
	/*
	*
	*/
	public function __construct()
	{
		$Helpers = array('autoload', 'router', 'validations');
		
		$this -> Helper($Helpers);
		$this -> Config('cache');
		$this -> Config('exceptions');
		$this -> Config('languages');
	}
	/*
	*
	*/
	public function Helper($Helper, $Application = NULL)
	{
		if(is_array($Helper))
		{
			for($i = 0; $i <= count($Helper) - 1; $i++)
			{
				if($Application === NULL) //null != NULL | NULL === NULL
				{
					//Ruta visual: "core/helpers/helper.$Name.php"
					if(FILE_EXISTS(CORE_PATH . DS . "helpers" . DS 	. "helper." . $Helper[$i] . ".php"))
						include_once(CORE_PATH . DS . "helpers" . DS 	. "helper." . $Helper[$i] . ".php");
					//Ruta visual: "www/helpers/helper.$Name.php"
					elseif(FILE_EXISTS(WWW_PATH . DS . "helpers" . DS 	. "helper." . $Helper[$i] . ".php"))
						include_once(WWW_PATH . DS . "helpers" . DS 	. "helper." . $Helper[$i] . ".php");
					else
						die("<h1>Error</h1><p>El archivo de ayuda: <b>$Helper[$i]</b> no existe</p>");
				}
			}//Fin búcle
		}
	}
	/*
	* Carga un archivo de configuración
	* @Parámetro: String $Name
	* @Parámetro: String $Application
	* @Retorna: Void
	*/
	public function Config($Name, $Application = NULL)
	{
		if($Application)
		{
			//Ruta visual: "www/application/$Application/config/config.$Name.php"
			if(FILE_EXISTS(WWW_PATH . DS . APPLICATION_PATH . DS . "$Application" . DS . 'config' . DS . "config.$Name.php"))
				include_once(WWW_PATH . DS . APPLICATION_PATH . DS . "$Application" . DS . 'config' . DS . "config.$Name.php");
			else
				die("<h1>Error</h1><p>La configuraci&Oacute;n <b>$Name</b> no existe</p>");
		}
		//Ruta visual: "www/config/config.$Name.php"
		elseif(FILE_EXISTS(WWW_PATH . DS . 'config' . DS . "config.$Name.php"))
			include_once(WWW_PATH . DS . 'config' . DS . "config.$Name.php");
		else
		{
			//Ruta visual: "www/applications/$Name/config/config.$Name.php"
			if(FILE_EXISTS(WWW_PATH . DS . APPLICATION_PATH . DS . "$Name" . DS . 'config' . DS . "config.$Name.php"))
				include_once(WWW_PATH . DS . APPLICATION_PATH . DS . "$Name" . DS . 'config' . DS . "config.$Name.php");
			else
				die("<h1>Error</h1><p>La configuraci&oacute;n <b>$Name</b> no existe</p>");
		}
	}
	/*
	*
	*/
	public function App($Application)
	{
		return $this -> Application = $Application;
	}
	
	public function Execute()
	{
	
	}
	
	public function Library($Name, $Library = NULL, $Application = NULL)
	{
		$Lib = str_replace("lib.", "", $Name);
		
		if(isset($Name) && $Library != NULL)
		{
			//Ruta visual: "core/lib/$Library/$Name.php"
			if(FILE_EXISTS(CORE_PATH . DS . LIBRARY_PATH . DS . "$Library" . DS . "$Name.php"))
				include_once(CORE_PATH . DS . LIBRARY_PATH . DS . "$Library" . DS . "$Name.php");
			else
				die("<h1>Error</h1>La librer&iacute;a <b>$Name</b> no existe</p>");
		}
		elseif(isset($Name) && !is_null($Application))
		{
			//Ruta visual "www/application/$Application/lib/lib.$Name.php
			if(FILE_EXISTS(WWW_PATH . DS . APPLICATION_PATH . DS . "$Application" . DS . 'lib' . DS . "lib.$Name.php"))
				include_once(WWW_PATH . DS . APPLICATION_PATH . DS . "$Application" . DS . 'lib' . DS . "lib.$Name.php");
			else
				die("<h1>Error</h1>La librer&iacute;a <b>$Name</b> no existe</p>");
		}
		else
		{
			$Lib = str_replace("class.", "", $Name);
			//Ruta visual: "core/lib/$Name.php"
			if(FILE_EXISTS(CORE_PATH . DS . LIBRARY_PATH . DS . $Lib . DS . strtolower($Name) . ".php"))
				include_once(CORE_PATH . DS . LIBRARY_PATH . DS . $Lib . DS . strtolower($Name) . ".php");
			else
				die("<h1>Error</h1>La librer&iacute;a <b>$Name</b> no existe</p>");
		}
	}
	
	public function Controller($Controller, $App = NULL)
	{
		$Parts = explode("_", $Controller);
		
		if(!$this -> Application) //true
		{
			if(FILE_EXISTS(WWW_PATH . DS . APPLICATION_PATH . DS . $App . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($Parts[0]) . '.php'))
				$File = WWW_PATH . DS . APPLICATION_PATH . DS . $App . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($Parts[0]) . '.php';
			elseif(count($Parts) == 2)
				$File = WWW_PATH . DS . APPLICATION_PATH . DS . strtolower($Parts[0]) . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($Parts[0]) . '.php';
			echo $File;
		}
		else
		{
			if(FILE_EXISTS(WWW_PATH . DS . APPLICATION_PATH . DS . $App . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($Parts[0]) . '.php'))
				$File = WWW_PATH . DS . APPLICATION_PATH . DS . $App . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($Parts[0]) . '.php';
			elseif(FILE_EXISTS(WWW_PATH . DS . APPLICATION_PATH . DS . $this -> Application . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($Parts[0]) . '.php'))
				$File = WWW_PATH . DS . APPLICATION_PATH . DS . $this -> Application . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($Parts[0]) . '.php';
			else
				$File = WWW_PATH . DS . APPLICATION_PATH . DS . strtolower($Parts[0]) . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($Parts[0]) . '.php';
		}

		if(FILE_EXISTS($File))
		{
			if(CLASS_EXISTS($Controller))
				return AsfoSingleton::instance($Controller);
			
			include $File;
			
			return AsfoSingleton::instance($Controller);
		}
		return false;
	}
	
 }
 ?>