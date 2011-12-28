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
* Helper basado en:
* ------------------------------------------------------------
* UpA
* Utiidades por Asfo
* 
* @Paquete			Utilidades por Asfo
* @Version			0.1
* @Autor			Asfo
* @Licencia			GPL v2
* @Link				http://github.com/asfo
* @Copyright		Copyright (C) 2011 Asfo
* ------------------------------------------------------------
*/
	if(!DEFINED('_ACCESS'))
		die("<h1>Error</h1> No puedes acceder a este archivo directamente");
	
	/*
	* Analiza si el Cliente está navegando a través de un iPhone
	* -----
	* @Retorna: Bool (true/false)
	*/
	function isiPhone()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'iPhone');
	}
	/*
	* Analiza si el Cliente está navegando a través de un iPod
	* -----
	* @Retorna: Bool (true/false)
	*/
	function isiPod()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'iPod');
	}
	/*
	* Analiza si el Cliente está navegando a través de un iPad
	* -----
	* @Retorna: Bool (true/false)
	*/
	function isiPad()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'iPad');
	}
	/*
	* Analiza si el Cliente está navegando a través de un Android
	* -----
	* @Retorna: Bool (true/false)
	*/
	function isAndroid()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'Android');
	}
	/*
	* Analiza si el Cliente está navegando a través de un Palm
	* -----
	* @Retorna: Bool (true/false)
	*/
	function isPalm()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'webOS');
	}
	/*
	* Analiza si el Cliente está navegando a través de un BlackBerry
	* -----
	* @Retorna: Bool (true/false)
	*/
	function isBlackberry()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'BlackBerry');
	}
	/*
	* Analiza si el Cliente está navegando a través del uso de SSL (https://)
	* -----
	* @Retorna: Bool (true/false)
	*/
	function isSSL()
	{
		if ( isset($_SERVER['HTTPS']) ) {
            if ( 'on' == strtolower($_SERVER['HTTPS']) )
                return true;
            if ( '1' == $_SERVER['HTTPS'] )
                return true;
        } elseif ( isset($_SERVER['SERVER_PORT']) && ( '443' == $_SERVER['SERVER_PORT'] ) ) {
            return true;
        }
        return false;
	}
	/*
	* Analiza si el Cliente es referido
	* -----
	* @Retorna: Bool (true/false)
	*/
	function isReferral()
	{
		return (!isset($_SERVER['HTTP_REFERER']) OR $_SERVER['HTTP_REFERER'] == '') ? false : true;
	}
	
	/*
	* Analiza si está navegando por un "móbil"(de la lista de móbiles disponibles en este helper)
	* @Retorna: Bool(true/false)
	*/
	function isMobile()
	{
		if((isiPhone() == true) || (isiPod() == true) || (isiPad() == true) || (isAndroid() == true) || (isPalm() == true) || (isBlackberry() == true))
			return true;
		else
			return false;
	}

//EOF
?>