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
		die("<h1>Error</h1><p>No puedes acceder a este archivo directamente.</p>");
	
 //Configuraci�n (por medio de una definici�n) de la aplicaci�n en uso
 DEFINE('DEFAULT_APPLICATION', 'default');
 
 //Configuraci�n (por medio de una definici�n) de el estado de la web [TRUE != true] | [TRUE = ACTIVADA | FALSE = DESACTIVADA]
 DEFINE('ACTIVE_WEB', TRUE);
 
 //Configuraci�n (por medio de una definici�n) del mensaje a mostrar en caso de que est� en construcci�n la web/aplicaci�n
 DEFINE('DISABLED_WEB_MESSAGE', '<h1>En Construcci&oacute;n</h1><p>Esta web se encuentra en construcci&oacute;n, vuelva m&aacute;s tarde</p>');
 
 //Configuraci�n (por medio de una definici�n) del nombre de la web
 DEFINE('WEB_NAME', 'Asfo Framework');
?>