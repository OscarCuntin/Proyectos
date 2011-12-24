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
 /*
	Archivo bajo pruebas.
	Liberación inicial.
	Por ahora esta prueba hará la magia de demostrar el funcionamiento del framework.
 */
 class Default_Controller //extends AsfoController [Temporalmente la clase: AsfoController no existe]
 {
	/*---*/
	public $Title;
	/*---*/
	public $Message;
	/*---*/
	public $Footer;
	
	public function __construct()
	{
		$this -> Title = "Bienvenido usuario";
		$this -> Message = "Bienvenido a <b>Asfo Framework</b>. Actualmente estamos en la versi&oacute;n: " . CORE_VERSION . ". Se paciente, Roma no se hizo en un d&iacute;a<hr />";
		$this -> Footer = "Copyright &copy; 2011 <b>Asfo</b> | Asfo Framework";
	}
	public function index()
	{
		echo "<h1>".$this -> Title."</h1><p>".$this -> Message."</p>".$this -> Footer;
	}

 }
?>