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
	
	if(empty($_POST['usuario']) || empty($_POST['contrasena']) || empty($_POST['repetir_contrasena']) || empty($_POST['email']))
		$Mensaje = LANG('CAMPOS_REQUERIDOS');
	else
	{
		$Database = new Database();
			if($_POST['contrasena'] != $_POST['repetir_contrasena'])
				echo '<meta HTTP-EQUIV="REFRESH" content="0; url='. WEB_URL .'register/fail/1">';
			else
				$Database -> Query('');
	}
?>
			<div class="landingcontents">
				<div class="holder">
	<div class="breadcrumb breadcrumbsub">
		<div class="left"></div>
		<div class="center">
			<div class="ref">
				<div class="contents">
						<div class="text"><?php echo LANG('MENSAJE_BARRA_PAGINACION'); ?></div>
				</div>
			</div>
		</div>
	</div>

		<div class="fn_holder">

		<div class="top_rounded"><img style="float:rig'ht;" src="<?php echo WEB_URL; ?>theme/default/_images/layout/tr_rounded.gif"/><img style="float:left;" src="<?php echo WEB_URL; ?>theme/default/_images/layout/tl_rounded.gif"/></div>

		<div class="blizzart-gallery">

			<div class="searches">
				<div id="gallery-search" class="search">
					<div class="left">
						<div class="right">
							<input type="text" placeholder="Buscar..."></input>
						</div>
					</div>
				</div>
			</div>

			<div class="top_pagenav" id="gallery-toppages">
				<div class="fn_submit">
					<?php 
						if(isset($_SESSION['userId']) && $_SESSION['userId'] != "")
							echo "<span>".LANG('MENSAJE_ENVIO_IMAGEN') . "<a href=\"". WEB_URL . "/upload/\"> " . LANG('ENVIAR_AQUI') . "</a>.</span>";
						else
							echo LANG('MENSAJE_REGISTRO');
						
						if(isset($_GET['section']) && $_GET['section'] == 'fail')
							if(isset($_GET['value']) && $_GET['value'] == 1)
								echo "<br /><span style=\"color:red;\"><b>".LANG('ERROR')."</b>: ".LANG('CONTRASENAS_DIFERENTES')."</span>";
							elseif(isset($_GET['value']) && $_GET['value'] == 2)
								echo "<br /><span style=\"color:red;\"><b>".LANG('ERROR')."</b>: ".LANG('NOMBRE_USUARIO_EN_USO')."</span>";
							elseif(isset($_GET['value']) && $_GET['value'] == 3)
								echo "<br /><span style=\"color:red;\"><b>".LANG('ERROR')."</b>: ".LANG('EMAIL_EN_USO')."</span>";
							else
								echo "<br /><span style=\"color:red;\"><b>".LANG('ERROR')."</b>: ".$Mensaje."</span>";
						elseif(isset($_GET['section']) && $_GET['section'] == 'success' && $Mensaje != LANG('CAMPOS_REQUERIDOS'))
							echo "<br /><span style=\"color:green;\"><b>".LANG('EXITO')."</b>: ".$Mensaje."</span>";
						else
							echo '';
					?>
				</div>
			</div>

			<div id="gallery-message" class="message">
				<form action="#" method="post">
					<?php echo LANG('NOMBRE_USUARIO'); ?>:<br />
						<input type="text" name="usuario" style="width: 200px;"/><br /><br />
					<?php echo LANG('CONTRASENA'); ?>:<br /> 
						<input type="password" name="contrasena" style="width: 200px;" /><br /><br />
					<?php echo LANG('REPETIR_CONTRASENA'); ?>:<br /> 
						<input type="password" name="repetir_contrasena" style="width: 200px;" /><br /><br />
					<?php echo LANG('EMAIL'); ?>: <br />
						<input type="text" name="email" style="width: 200px;" /> <br /> <br />
						<input type="submit" value="<?php echo LANG('ENVIAR'); ?>" />&nbsp; <input type="reset" value="<?php echo LANG('REINICIAR'); ?>" />
				</form>
			</div>
		</div>
	</div>