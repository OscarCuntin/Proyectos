<?php
/*
	Creador		:	Asfo
	Proyecto	:	iNotas
	Versión		:	1.0beta
	Copyright	:	(C) 2011 Asfo
	Archivo		:	doPaste.php
*/
	require("System.php");
	
	if(empty($_POST['titulo']))
		$Titulo = "Sin t&iacute;tulo";
	else
		$Titulo = $_POST['titulo'];
	if(empty($_POST['Lenguaje']))
		$Lenguaje = "lang-plain";
	else
		$Lenguaje = $_POST['lenguaje'];
		
	if(isset($_POST['paste']))
	{
		global $finalName;
		$Usuario = "An&oacute;nimo";
		$finalName = "";
		$Paste = htmlentities($_POST['paste'], ENT_QUOTES);
		$str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		$Codigo = "";
			for( $i = 0;$i < 12; $i++) {
				$Codigo .= substr($str,rand(0,62),1);
			}
			$returnName = $Codigo;
			$sqlInsertNewPaste = "INSERT INTO `pastes` (`titulo`, `paste`, `lenguaje`, `usuario`, `codigo`) VALUES ('".$Titulo."', '".$Paste."', '".$Lenguaje."', '".$Usuario."', '".$Codigo."')";
				$queryInsertNewPaste = mysql_query($sqlInsertNewPaste);
				if(!$queryInsertNewPaste)
					echo "error";
				else
					echo $returnName;	
	}
	else
		exit("<h1>Error</h1><p>No se puede acceder a este archivo directamente</p>");
?>