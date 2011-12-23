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
	if(!DEFINED('_ACCESS'))
		die("<h1>Error</h1><p>No puedes acceder a este archivo directamente</p>");
	 function Route()
	 {
	 
	 }
	 
	 function Segment($Segment = 0, $r = FALSE)
	 {
		if($r === FALSE)//FALSE === FALSE | false != FALSE
		{
			$route = Route();
			
			if(count($route) > 0)
			{
											//To Do:Ver si hay otro método mejor para analizar la longitud de la string
				if(isset($route[$segment]) && strlen($route[$segment]) > 0)
				{
					if($route[$segment] == "0")
						return 0;
					/*
					To Do: Ver si con la parte superior cuenta como "0" en string y retorne un entero en 0
					En caso de que deba obligar a ser exactamente "0", se abrirá este comentario
					elseif($route[$segment]) === "0")
						return 0;
					*/
					else
						return filter($route[$segment]);
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			die("<h1>Error</h1><p>La ruta (en la funci&oacute;n: <b>Segment()</b> no puede ser verdadera si no ha sido marcada</p>");
	 }
	 function Segments($r = FALSE)
	 {
		if($r === FALSE)
		{
			$route = Route();
			return count($route);
		}
		else
			die("<h1>Error</h1><p>La ruta (en la funci&oacute;n: <b>Segments()</b> no puede ser verdadera si no ha sido marcada</p>");
	 }
	 function Execute()
	 {
		global $Load;
		//To Do: Ver si es mejor hacerlas globales...
		$controlApp = FALSE; /* --- */ $Match = FALSE;
		
		//Ruta visual: "www/config/config.routes.php"
		if(FILE_EXISTS(WWW_PATH . DS . 'config' . DS . 'config.routes.php'))
		{
			include WWW_PATH . DS . 'config' . DS . 'config.routes.php';
			
				if(is_array($Routes))
				{
					if(isLang())//isLang() == true
						$App = segment(1);
					else
						$App = segment(0);
					//Separamos todas las rutas de 1 x 1
					foreach($Routes as $Route)
					{
						$Pattern = $Route['pattern'];
						$Match = preg_match($Pattern, $App); //El valor de la variable $Match deberá ser true ó false si son compatibles los valores
						
						if($Match) //$Match == true
						{
							$Application 			= $Route['application'];
							$controlApp				= $Route['controller'];
							$Method					= $Route['method'];
							$Params					= $Route['params'];
							//Se rompe el búcle sin perder información
							break;
						}
						
					}
				}//Es obligatorio que sea un array la ruta...Por ahora si no lo es, solamente retornará falso
				//To Do: Buscar una mejor forma de hacer que el usuario la tenga como "array" siempre.
				else
					return false;
		}
		
		if(!$Match) //$Match == false | Esto se comprueba ajeno a la sección superior ya que si no entró en el if superior, $Match permanece con el valor: FALSE.
		{
			if(!segment(0))
				$App = DEFAULT_APPLICATION;
			elseif(segment(0) && !segment(1))
				if(isLang()) //isLang() == true
					$App = DEFAULT_APPLICATION;
				else
					$App = segment(0);
			else
			{
				if(isLang()) //isLang() == true
					$App = segment(1);
				
				if(segment(2))
				{
				
				}
			}
		}
	 }
	
//EOF
?>