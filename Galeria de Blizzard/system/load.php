<?php
/***********************************************************
 *	
 *		Galería de Blizzard
 * 		----------------------------------------------------
 *		Autor		:	Asfo Zavala
 *		Copyright	: 	Copyright (C) 2012, Asfo Zavala
 *		Licencia	:	GNU GPL v3
 *		Link		: 	http://github.com/Asfo/
 *		----------------------------------------------------
 *
 **********************************************************/
 //Acceso denegado a la visualización del archivo directamente.
 if(!DEFINED('ACCESS'))
	die("<h1>Error 403</h1><p>No tienes los permisos suficientes para acceder a este archivo.</p><hr /><i>Galer&iacute;a de Blizzard por <b>Asfo</b> &copy; 2011 | Sistema de Seguridad | <b>Error 403</b>");
	
 if(FILE_EXISTS(SYSTEM_PATH . DS . 'configs' . DS . 'config.main.php'))
	include(SYSTEM_PATH . DS . 'configs' . DS . 'config.main.php');
 else
	die("<h1>Error 105</h1><p>El archivo de configuraci&oacute;n <b>config.main.php</b> no existe. <br />La ruta representada es: <b>".SYSTEM_PATH . DS . 'configs' . DS . "config.main.php</b></p><hr /><i>Galer&iacute;a de Blizzard por <b>Asfo</b> &copy; 2011 | Sistema de Errores | Error 105</b>");
	
 if(FILE_EXISTS(SYSTEM_PATH . DS . 'classes' . DS . 'class.load.php'))
	include(SYSTEM_PATH . DS . 'classes' . DS . 'class.load.php');
 else
	die("<h1>Error 105</h1><p>El archivo de clases <b>class.load.php</b> no existe. <br />La ruta representada es: <b>".SYSTEM_PATH . DS . 'classes' . DS . "class.main.php</b></p><hr /><i>Galer&iacute;a de Blizzard por <b>Asfo</b> &copy; 2011 | Sistema de Errores | Error 105</b>");

 ob_start();
 session_start();
 
 $Load = new Load();
 
 $Load -> getLanguage(MAIN_LANGUAGE);
 
 $Load -> Classes('Database');
 
 $Database = new Database();
 
 $Database -> Connect();
 
 $Database -> SelectDB(DB_NAME);
	
 switch($Load -> getPage())
 {
	case 'upload':
		$Load -> getTemplate(MAIN_TEMPLATE, 'head');
		$Load -> getTemplate(MAIN_TEMPLATE, 'header');
		$Load -> getTemplate(MAIN_TEMPLATE, 'upload');
		$Load -> getTemplate(MAIN_TEMPLATE, 'footer');
		break;
	case 'login':
		switch($Load -> getLogin())
		{
			case 'successful':
				break;
			case 'failure':
				$Load -> getTemplate(MAIN_TEMPLATE, 'head');
				$Load -> getTemplate(MAIN_TEMPLATE, 'header');
				$Load -> getTemplate(MAIN_TEMPLATE, 'login');
				$Load -> getTemplate(MAIN_TEMPLATE, 'footer');
				break;
			default:
				$Load -> getTemplate(MAIN_TEMPLATE, 'head');
				$Load -> getTemplate(MAIN_TEMPLATE, 'header');
				$Load -> getTemplate(MAIN_TEMPLATE, 'login');
				$Load -> getTemplate(MAIN_TEMPLATE, 'footer');
				break;
		}
		break;
	case 'logout':
		
		break;
	case 'admin':
		$Load -> getTemplate(MAIN_TEMPLATE, 'head');
		$Load -> getTemplate(MAIN_TEMPLATE, 'header');
		$Load -> getTemplate(MAIN_TEMPLATE, 'body');
		$Load -> getTemplate(MAIN_TEMPLATE, 'footer');
		break;
	case 'register':
		$Load -> getTemplate(MAIN_TEMPLATE, 'head');
		$Load -> getTemplate(MAIN_TEMPLATE, 'header');
		$Load -> getTemplate(MAIN_TEMPLATE, 'register');
		$Load -> getTemplate(MAIN_TEMPLATE, 'footer');
		break;
	case 'index':
		$Load -> getTemplate(MAIN_TEMPLATE, 'head');
		$Load -> getTemplate(MAIN_TEMPLATE, 'header');
		$Load -> getTemplate(MAIN_TEMPLATE, 'body');
		$Load -> getTemplate(MAIN_TEMPLATE, 'footer');
		break;
	default:
		$Load -> getTemplate(MAIN_TEMPLATE, '404');
		break;
 }
 ?>