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
		die(Error('Error','No tienes permiso para acceder aqu&iacute;'));
	
 //Configuración (por medio de una definición) de la aplicación en uso
 DEFINE('DEFAULT_APPLICATION', 'default');
 
 //Configuración (por medio de una definición) de el estado de la web [TRUE != true] | [TRUE = ACTIVADA | FALSE = DESACTIVADA]
 DEFINE('ACTIVE_WEB', TRUE);
 
 //Configuración (por medio de una definición) del mensaje a mostrar en caso de que esté en construcción la web/aplicación
 DEFINE('DISABLED_WEB_MESSAGE', '<h1>En Construcci&oacute;n</h1><p>Esta web se encuentra en construcci&oacute;n, vuelva m&aacute;s tarde</p>');
?>