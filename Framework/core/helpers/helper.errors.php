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
 
 function Error($Title = "", $Message = "")
 {
	//Si, se ve tonto, pero por ahora tengo flojera xD
	if($Title == "" || $Message == "")
		echo "";
	else
	{
		echo "<h1>".$Title."</h1>";
		echo "<p>".$Message."</p>";
		/*
			<h1>Hola</h1>
			<p>Mundo</p>
		*/
	}
 }
 ?>