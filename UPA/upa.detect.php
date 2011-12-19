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
	* Analiza si el Cliente está navegando a través de un iPhone
	* @Acceso: 	Público
	* @Retorna: Bool (true/false)
	*/
	public function isiPhone()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'iPhone');
	}
	/*
	* Analiza si el Cliente está navegando a través de un iPod
	* @Acceso: 	Público
	* @Retorna: Bool (true/false)
	*/
	public function isiPod()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'iPod');
	}
	/*
	* Analiza si el Cliente está navegando a través de un iPad
	* @Acceso: 	Público
	* @Retorna: Bool (true/false)
	*/
	public function isiPad()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'iPad');
	}
	/*
	* Analiza si el Cliente está navegando a través de un Android
	* @Acceso: 	Público
	* @Retorna: Bool (true/false)
	*/
	public function isAndroid()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'Android');
	}
	/*
	* Analiza si el Cliente está navegando a través de un Palm
	* @Acceso: 	Público
	* @Retorna: Bool (true/false)
	*/
	public function isPalm()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'webOS');
	}
	/*
	* Analiza si el Cliente está navegando a través de un BlackBerry
	* @Acceso: 	Público
	* @Retorna: Bool (true/false)
	*/
	public function isBlackberry()
	{
		return (bool) strpos($_SERVER['HTTP_USER_AGENT'], 'BlackBerry');
	}
	/*
	* Analiza si el Cliente está navegando a través del uso de SSL (https://)
	* @Acceso: 	Público
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
	* @Acceso: 	Público
	* @Retorna: Bool (true/false)
	*/
	public function isReferral()
	{
		return (!isset($_SERVER['HTTP_REFERER']) OR $_SERVER['HTTP_REFERER'] == '') ? false : true;
	}
	
}
?>