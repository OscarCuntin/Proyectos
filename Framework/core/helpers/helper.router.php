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
	
	include('helper.errors.php');
	
	if(!DEFINED('_ACCESS'))
		die(Error('Error', 'No puedes acceder a este archivo directamente'));
		
	/*
	* Esta función obtiene la URI del navegador y la explota utilizando las "/"
	* @Parámetro: $r
	* @Retorna: Array
	*/
	 function Route($r = FALSE)
	 {
		$mURL   = explode("/", substr($_SERVER['REQUEST_URI'], 1)); //mURL | m = Main | Referencia
		$mPaths = explode("/", dirname($_SERVER['SCRIPT_FILENAME'])); //mPaths | m = Main | Referencia
		$Path = $mPaths[count($mPaths) - 1]; // - 1 -> Evita el desbordamiento del arreglo
		
		if(is_array($mURL)) //¿Realmente podría no serlo?...Tengo que comprobarlo bien...
		{
			$mURL = array_diff($mURL, array(""));
			
			if(DOMAIN) //Configuración									|
				$Vars[] = array_shift($mURL);//------------------------>|
			if(isset($mURL) && $mURL[0] == $Path)					  //|
				$Vars[] = array_shift($mURL);//------------------------>|\No son los mismos
				//Configuración											|/valores recibidos
			if(!MOD_REWRITE && isset($mURL))					     // |
				if($mURL[0] == basename($_SERVER['SCRIPT_FILENAME']))// |
					$Vars[] = array_shift($mURL);//-------------------->|
		}
		//Temporalmente el valor de "$r" debe ser predefinido Y NO CAMBIADO (funcionará para referencias futuras)
		if($r != FALSE)
			die(Error('Error', 'La funci&oacute;n <b>Route($r = FALSE)</b> debe recibir un valor FALSO por predefinici&oacute;n obligatoriamente'));
		
		return $mURL;
	 }
	 
	 /*
	 *	Esta función obtiene un segmento específico de la URI obtenida por la función Route($r = FALSE)
	 * @Parámetro: $Segment
	 * @Parámetro: $r 
	 * @Retorna: Mezclado (Boolean(true/false), Array)
	 */
	 function Segment($Segment = 0, $r = FALSE) //En esta función $r = FALSE funciona para que la ruta siempre sea falsa si es emitida por el usuario
	 {
		if($r === FALSE)//FALSE === FALSE | false != FALSE
		{
			$route = Route(); //Ruta obtenida de la URI en la función nombrada.
			
			if(count($route) > 0)
			{
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
			die(Error('Error', 'La ruta en la funci&oacute;n: <b>Segment($Segment = 0, $r = FALSE)</b> no puede ser verdadera si no ha sido marcada por el sistema'));
	 }
	 /*
	 * Esta función obtiene todos los segmentos de la ruta
	 * @Parámetro: $r
	 * @Retorna: Entero
	 */
	 function Segments($r = FALSE)
	 {
		if($r === FALSE)
		{
			$route = Route();
			return count($route);
		}
		else
			die(Error('Error', 'La ruta (en la funci&oacute;n: <b>Segments($r = FALSE)</b> no puede ser verdadera si no ha sido marcada'));
	 }
	 /*
	 * Esta función analiza si es un controlador un archivo
	 * @Parámetro: $Controller
	 * @Parámetro: $App
	 * @Retorna: Booleano (true/false)
	 */
	 function isController($Controller, $App)
	 {
		$checkFile = WWW_PATH . DS . APPLICATION_PATH . DS . $App . DS . CONTROLLERS . DS . CONTROLLER . '.' . $Controller . '.php';
		//Analiza si el controlador de la aplicación existe
		if(FILE_EXISTS($checkFile))
			return true;
		else
			return false;
	 }
	 /*
	 *	Esta función ejecuta todo el sistema
	 */
	 function Execute()
	 {
		global $Load;
		$controlApp = FALSE; 
		/* --- */ 
		$Match = FALSE;
		
		//Ruta visual: "www/config/config.routes.php"
		if(FILE_EXISTS(WWW_PATH . DS . 'config' . DS . 'config.routes.php'))
		{
			include WWW_PATH . DS . 'config' . DS . 'config.routes.php';
			
				if(is_array($Routes))
				{
					if(isLang())//isLang() == true
						$App = Segment(1);
					else
						$App = Segment(0);
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
			if(!Segment(0))
				$App = DEFAULT_APPLICATION;
			elseif(Segment(0) && !Segment(1))
				if(isLang()) //isLang() == true
					$App = DEFAULT_APPLICATION;
				else
					$App = Segment(0);
			else
			{
				if(isLang()) //isLang() == true
				{
					$App = Segment(1);
				
					if(Segment(2))
					{
						if(isController(Segment(2), Segment(1)))
						{
							$App = Segment(2);
							
							if(Segment(3) && !isNumber(Segment(3)))
								$Method = Segment(3);
							else
								$Method = 'index';
						}
						else
							if(!isNumber(Segment(2)))
								$Method = Segment(2);
					}
				
					if($controlApp)
					{
						if(Segments() > 4)
							$Count = 4;
						for($i = 0; $i <= Segments() - 1; $i++)
						{
							if(Segment($Count) || Segment($Count) == 0)
							{
								$Params[$i] = Segment($Count);
								$Count++;
							}
						}
					}
					else
					{
						if(Segments() > 3)
							$Count = 3;
						for($i = 0; $i <= Segments() - 1; $i++)
						{
							if(Segment($Count) || Segment($Count) == 0)
							{
								$Params[$i] = Segment($Count);
								$Count++;
							}
						}
					}
				}
				else
				{
					$App = Segment(0, FALSE);
					
					if(Segment(1, FALSE))
					{
						if(isController(Segment(1, FALSE), Segment(0, FALSE)))
						{
							// -->
							$controlApp = Segment(1, FALSE);
							// <--
							if(Segment(2, FALSE) && !isNumber(Segment(2, FALSE)))
								$Method = Segment(2, FALSE);
							else
								$Method = 'index';
						}
						else
						{
							if(!isNumber(Segment(1, FALSE)))
								$Method = Segment(1, FALSE);
						}
					}
					
					if($controlApp)
					{
						if(Segments() > 3)
						{
							$Count = 3;
							for($i = 0; $i <= Segments() - 1; $i++)
							{
								if(Segment($Count) || Segment($Count) == 0)
								{
									$Params[$i] = Segment($Count);
									$Count++;
								}
							}
						}
					}
					else
					{
						if(Segments() > 2)
						{
							$Count = 2;
							for($i = 0; $i <= Segments() - 1; $i++)
							{
								if(Segment($Count) || Segment($J) == 0)
								{
									$Params[$i] = Segment($Count);
									$Count++;
								}
							}
						}
					}
				}
			}
		}
		//Sección para el modo mantenimiento
		if(ACTIVE_WEB != TRUE && !_SESSION("AsfoUserID") && $App != "cpanel")
			die(DISABLED_WEB_MESSAGE);
		
		$Load ->  App($App);
		
		if(isController($controlApp, $App))
		{
			$Controller = ucfirst($controlApp) . "_Controller";
								//Ruta visual: "www/applications/default/controllers/controller.$controlerApp.php
			$ControllerFile = WWW_PATH . DS . APPLICATION_PATH . DS . strtolower($App) . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($controlerApp) . '.php';
			//Se cargan los controladores de la aplicación
			$_Controller = $Load -> Controller($Controller);
		}
		else
		{
			$Controller = ucfirst($App) . "_Controller";
								//Ruta visual: "www/applications/default/controller/controller.$App.php
			$controllerFile = WWW_PATH . DS . APPLICATION_PATH . DS . strtolower($App) . DS . CONTROLLERS . DS . CONTROLLER . '.' . strtolower($App) . '.php';
			//Se cargan los controladores de la aplicación
			$_Controller = $Load -> Controller($Controller);
		}
		
		if(FILE_EXISTS($controllerFile))
		{
			if(isset($Method) && isset($Params))
			{
				if(METHOD_EXISTS($_Controller, $Method))
				{
					try
					{
						$Reflection = new ReflectionMethod($_Controller, $Method);
						
						if(!$Reflection -> isPublic())
							throw new RuntimeException("El m&eacute;todo no es p&uacute;blico y por lo tanto no puede ser ejecutado.", 100);
					}
					catch(RuntimeException $e)
					{
						Exception($e);
					}
				}
				else
					$_Controller -> index();
			}
			elseif(isset($Method))
			{
				if(METHOD_EXISTS($_Controller, $Method))
				{
					try
					{
						$Reflection = new ReflectionMethod($_Controller, $Method);
						
						if(!$Reflection -> isPublic())
							throw new RuntimeException("El m&eacute;todo no es p&uacute;blico y por lo tanto no puede ser ejecutado.", 100);
						elseif(($Reflection -> getRequiredParameters(TRUE) > 0) && !isset($Params))
						{
							$Params = $Reflection -> getParameters();
							$Parameters = NULL;
							
							if(count($Params) > 0)
							{
								$Count = 0;
								//Rly?
								foreach($Params as $Param)
								{
									if($i == count($Params) - 1)
										$Parameters .= $Param -> name;
									else
										$Parameters .= $Param -> name . ", ";
										
									$Count++;
								}
							}
							
							throw new RuntimeException("El m&eacute;todo no es p&uacute;blico y por lo tanto no puede ser ejecutado.", 100);
						}
						
						$_Controller -> $Method();
					}
					catch(RuntimeException $e)
					{
						Exception($e);
					}
				
				}
				else
					$_Controller -> index();
			}
			else
				$_Controller -> index();
		}
		else
			die(Error('Error', 'Al parecer un controlador (o m&aacute;s) no pudo ser cargado, comprueba que los archivos est&eacute;n conforme al formato correcto y tengan los nombres correctos'));
	 }
	
//EOF
?>