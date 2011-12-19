<?php
/*
* UpA
* Utiidades por Asfo
* 
* @Paquete			Utilidades por Asfo
* @Version			0.1
* @Autor			Asfo
* @Licencia			GPL v2
* @Link				http://github.com/asfo
* @Copyright		Copyright (C) 2011 Asfo
*/
namespace UpA;

class Detect{
	/*
	* Analiza si el Cliente est� navegando a trav�s de un iPhone
	* @Acceso: 	P�blico
	* @Retorna: Bool (true/false)
	*/
	public function isiPhone()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'iPhone');
	}
	/*
	* Analiza si el Cliente est� navegando a trav�s de un iPod
	* @Acceso: 	P�blico
	* @Retorna: Bool (true/false)
	*/
	public function isiPod()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'iPod');
	}
	/*
	* Analiza si el Cliente est� navegando a trav�s de un iPad
	* @Acceso: 	P�blico
	* @Retorna: Bool (true/false)
	*/
	public function isiPad()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'iPad');
	}
	/*
	* Analiza si el Cliente est� navegando a trav�s de un Android
	* @Acceso: 	P�blico
	* @Retorna: Bool (true/false)
	*/
	public function isAndroid()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'Android');
	}
	/*
	* Analiza si el Cliente est� navegando a trav�s de un Palm
	* @Acceso: 	P�blico
	* @Retorna: Bool (true/false)
	*/
	public function isPalm()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'webOS');
	}
	/*
	* Analiza si el Cliente est� navegando a trav�s de un BlackBerry
	* @Acceso: 	P�blico
	* @Retorna: Bool (true/false)
	*/
	public function isBlackberry()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'BlackBerry');
	}
	/*
	* Analiza si el Cliente est� navegando a trav�s del uso de SSL (https://)
	* @Acceso: 	P�blico
	* @Retorna: Bool (true/false)
	*/
	public function isSSL()
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
	* @Acceso: 	P�blico
	* @Retorna: Bool (true/false)
	*/
	public function isReferral()
	{
		return (!isset($_SERVER['HTTP_REFERER']) OR $_SERVER['HTTP_REFERER'] == '') ? false : true;
	}
	
}
?>