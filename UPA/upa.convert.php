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

class Convert{
	
	public function countryName($Code)
	{
		return $Code;
	}
	
	public function countryToContinent($Country)
	{
		return $Country;
	}
	
	public function httpStatus($Code)
	{
		$Code = absint($Code);
		return $Code;
	}
	
	public function fileExtType($Extension)
	{
		return $Type;
	}
}

?>