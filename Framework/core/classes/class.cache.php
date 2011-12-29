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
		
class AsfoCache extends AsfoLoad
{
	private $Status;
	
	public function __construct()
	{
		$this -> Status = CACHE_STATUS;
		$this -> Config('cache');
		$this -> setCache();
	}
	
	private function setCache()
	{
		$driverName = CACHE_DRIVER . "_Cache";
		$this -> Driver = $this -> Driver($driverName, "cache");
		$this -> Driver -> setUP(CACHE_HOST, CACHE_PORT, CACHE_TIME);
	}
	
	public function getCache($Id, $groupId = 'default')
	{
		return $this -> Driver -> getCache($Id, $groupId); //Comprobar...
	}
	
	public function getStatus()
	{
		return $this -> Driver -> getStatus();
	}
	
	public function Remove($Id, $groupId = 'default', $groupLevel = false)
	{
		return $this -> Driver -> Remove($Id, $groupId, $groupLevel);
	}
	
	public function removeAll($groupId = 'default')
	{
		return $this -> Driver -> removeAll($groupId);
	}
	
	public function Save($Data, $Id, $groupId = 'default', $time = CACHE_TIME)
	{
		return $this -> Driver -> Save($Data, $Id, $groupId, $time);
	}
	
	public function setStatus($Status)
	{
		return $this -> Driver -> setStatus($Status);
	}
}

//EOF
?>