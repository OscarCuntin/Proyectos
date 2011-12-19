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
	/*
	* Se incluye el archivo: 'upa.convert.php'
	* Si no existe, se da un aviso
	* Si existe, se incluye
	*/
	if(!file_exists('upa.convert.php'))
		exit('El archivo: <b>upa.convert.php</b> no existe o no fue encontrado');
	else
		require_once('upa.convert.php');
	
	/*
	* Se incluye el archivo: 'upa.detect.php'
	* Si no existe, se da un aviso
	* Si existe, se incluye
	*/
	if(!file_exists('upa.detect.php'))
		exit('El archivo: <b>upa.detect.php</b> no existe o no fue encontrado');
	else
		require_once('upa.detect.php');
?>