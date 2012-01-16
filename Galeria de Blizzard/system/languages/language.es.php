<?php
/***********************************************************
 *	
 *		Galer�a de Blizzard
 * 		----------------------------------------------------
 *		Autor		:	Asfo Zavala
 *		Copyright	: 	Copyright (C) 2012, Asfo Zavala
 *		Licencia	:	GNU GPL v3
 *		Link		: 	http://github.com/Asfo/
 *		----------------------------------------------------
 *
 **********************************************************/
 //Acceso denegado a la visualizaci�n del archivo directamente.
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
		case 'MENSAJE_INICIAR_SESION_ADICIONAL': return 'para subir tus propias im&aacute;genes'; break;
		case 'MENSAJE_INICIAR_SESION': return 'Inicia sesi&oacute;n'; break;
		case 'ANTERIOR': return 'Anterior'; break;
		case 'SIGUIENTE': return 'Siguiente'; break;
		case 'MENSAJE_ENVIO_IMAGEN': return '&iquest;Has creado alguna ilustraci&oacute;n excepcional que tenga relaci�n con los universos de Blizzard? '; break;
		case 'ENVIAR_AQUI': return 'Env&iacute;ala aqu&iacute;'; break;
		case 'ERROR_INICIO_DE_SESION_REQUERIDO': return 'Necesitas <a href="'.WEB_URL.'login/">iniciar sesi&oacute;n</a> para poder subir im&aacute;genes'; break;
		case 'SIN_IMAGENES': return 'No hay im&aacute;genes a&uacute;n, <b>se el primero</b> en subir una...'; break;
	}
	
  }

 ?>