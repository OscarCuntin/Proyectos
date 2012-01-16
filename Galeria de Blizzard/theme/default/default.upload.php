
	<body >
	
	<div class="subheader">
		<div class="fanart">
			<div class="navsub">
	<form name="gs" method="get" onSubmit="return goSearch()">
	<div class="navigation">
		<div class="bg"></div>
		<div class="bar">
			<a href="http://us.blizzard.com/es-mx/games/" class="navgames"></a>
			<a href="http://us.blizzard.com/es-mx/company/" class="navcompany"></a>
			<a href="http://us.blizzard.com/es-mx/community/" class="navcommunity"></a>
				<a href="http://us.blizzard.com/support/index.xml?locale=es_MX" class="navsupport"></a>
				<a href="http://us.blizzard.com/store/index.xml?locale=es_MX" class="navstore"></a>
		</div>
		<div class="searchbox">
			<input type="text" name="q" id="q" class="box" placeholder="<?php echo LANG('BUSCAR_BLIZZARD'); ?>" />
		</div>
		<div class="searchbutton">
			<input type="image" value="" class="button" src="<?php echo WEB_URL; ?>theme/default/_images/layout/pixel.gif"/>
		</div>
		<a href="http://us.blizzard.com/es-mx/" class="blizzlink"></a>
	</div>
	</form>
			</div>
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
		<div class="right"></div>
	</div>

		<div class="fn_holder">

		<div class="top_rounded"><img style="float:right;" src="<?php echo WEB_URL; ?>theme/default/_images/layout/tr_rounded.gif"/><img style="float:left;" src="<?php echo WEB_URL; ?>theme/default/_images/layout/tl_rounded.gif"/></div>

		<div class="blizzart-gallery">

			<div class="searches">
				<div id="gallery-search" class="search">
					<div class="left">
						<div class="right">
							<a href="javascript:;" class="cancel"></a>
							<input type="text" placeholder="Buscar..."></input>
						</div>
					</div>
				</div>
			</div>

			<div class="top_pagenav" id="gallery-toppages">
				<div class="fn_submit">
					<?php 
						if(isset($_SESSION['userId']) && $_SESSION['userId'] != "")
							echo LANG('SUBIR_IMAGEN_USUARIO');
						else
							echo LANG('NO_IMPLEMENTADO');
					?>
						
				</div>
			</div>

			<div id="gallery-message" class="message"></div>

			<div id="gallery-pictures" class="pictures">
			
			</div>

			<div id="gallery-pages" class="pages">
				<div class="numbers">
					<a href="javascript:;" class="disabled" id="prevendpg"></a>
					<a href="javascript:;" class="disabled" id="prevpg"></a>
					<div></div>
					<a href="javascript:;" class="disabled" id="nextpg"></a>
					<a href="javascript:;" class="disabled" id="nextendpg"></a>
				</div>
				<a href="javascript:;" class="disabled" id="gotopg"><span></span></a>
			</div>
		</div>
	</div>






