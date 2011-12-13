<?php
/*
	Creador		:	Asfo
	Proyecto	:	iNotas
	Versión		:	1.0beta
	Copyright	:	(C) 2011 Asfo
	Archivo		:	System.php
*/
	DEFINE('HOST', 'localhost'); 	//Host de la base de datos
	DEFINE('USER', 'root');		 	//Usuario de la base de datos
	DEFINE('PASS', 'contrasena');	//Contraseña de la base de datos
	DEFINE('DB',   'webdb');		//Nombre de la base de datos (dónde se encuentra la tabla "pastes"
	//Conexión a la base de datos
	$Conexion = mysql_connect(HOST, USER, PASS) or die ("<h1>Error</h1><p>No se pudo conectar a la base de datos</P>");
	//Si no se conectó, retorna false*
	if(!$Conexion)
		return false;
	//Si se conecta, selecciona la base de datos
	else
		$Database = mysql_select_db(DB, $Conexion);
?>