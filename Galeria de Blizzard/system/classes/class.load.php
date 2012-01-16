<?php
/***********************************************************
 *	
 *		Galería de Blizzard
 * 		----------------------------------------------------
 *		Autor		:	Asfo Zavala
 *		Copyright	: 	Copyright (C) 2012, Asfo Zavala
 *		Licencia	:	GNU GPL v3
 *		Link		: 	http://github.com/Asfo/
 *		----------------------------------------------------
 *
 **********************************************************/
 //Acceso denegado a la visualización del archivo directamente.
 if(!DEFINED('ACCESS'))
	die("<h1>Error 403</h1><p>No tienes los permisos suficientes para acceder a este archivo.</p><hr /><i>Galer&iacute;a de Blizzard por <b>Asfo</b> &copy; 2011 | Sistema de Seguridad | <b>Error 403</b>");
	
 class Load
 {
 
	public $Page;
	/*
	*	Constructor
	*/
	public function __construct()
	{
		//URL: http://localhost/?page=ALGO
		if(isset($_GET['page']) && $_GET['page'] != "")
			$this -> Page = $_GET['page']; //Se obtiene la página
		else //Si en la URL ?page='' no tiene contenidos, será el valor 'index'
			$this -> Page = 'index'; //Sin embargo, en la función getPage() se sabrá si en realidad lo es...
	}
	
	/*
	*	Con esta función obtenemos las únicas páginas que son posibles
	*	'upload', 'index', login', 'logout', 'register', '404'
	*	No hay ninguna otra posibilidad y de esta forma es más seguro
	*/
	public function getPage()
	{
		if($this -> Page == 'index')
			return $this -> Page = 'index';
		elseif($this -> Page == 'upload')
			return $this -> Page = 'upload';
		elseif($this -> Page == 'login')
			return $this -> Page = 'login';
		elseif($this -> Page == 'logout')
			return $this -> Page = 'logout';
		elseif($this -> Page == 'register')
			return $this -> Page = 'register';
		else
			return $this -> Page = '404';
	}
	
	public function getLanguage($Language = 'es')
	{
		if(FILE_EXISTS(SYSTEM_PATH . DS . 'languages' . DS . 'language.'.$Language.'.php'))
			include_once(SYSTEM_PATH . DS . 'languages' . DS . 'language.'.$Language.'.php');
		else
			die("<h1>Error 105</h1><p>El archivo de lenguajes <b>language.".$Language.".php</b> no existe. <br />La ruta representada es: <b>".SYSTEM_PATH . DS . 'languages' . DS . "language.".$Language.".php</b></p><hr /><i>Galer&iacute;a de Blizzard por <b>Asfo</b> &copy; 2011 | Sistema de Errores | Error 105</b>");

	}
	
	public function getTemplate($Template = 'default', $File = FALSE)
	{
		if(FILE_EXISTS(THEME_PATH . DS . $Template . DS . $Template.'.'.$File.'.php'))
			include (THEME_PATH . DS . $Template . DS . $Template.'.'.$File.'.php');
		else
			die("<h1>Error 105</h1><p>El archivo de templates <b>".$Template.".".$File.".php</b> no existe. <br />La ruta representada es: <b>".THEME_PATH . DS . $Template . DS . $Template.".".$File.".php</b></p><hr /><i>Galer&iacute;a de Blizzard por <b>Asfo</b> &copy; 2011 | Sistema de Errores | Error 105</b>");
	}
	
	
 }