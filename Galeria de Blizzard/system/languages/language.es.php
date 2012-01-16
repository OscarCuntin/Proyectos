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
 
  function LANG($Message = '')
  {

	switch($Message)
	{
		case '404': return 'Error 404.'; break;
		case 'BUSCAR_BLIZZARD': return 'Buscar en Blizzard'; break;
		case 'MENSAJE_BARRA_PAGINACION': return 'Galer&iacute;a de Arte'; break;
		case 'SUBIR_IMAGEN_USUARIO': return 'Sube tu imagen'; break;
		case 'NO_IMPLEMENTADO': return 'No implementado'; break;
	}
	
  }

 ?>