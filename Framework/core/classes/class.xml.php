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

class XML
{
		private $XML = NULL;
		
		public function __construct()
		{
			$Helpers = array('errors', 'security');
			$this -> Helper($Helpers);
		}
		
		private function checkForHTML($String)
		{
			if(strlen($String) != strlen(strip_tags($String)))
				return true;
			//---//
			return false; //Predefinidamente retorna falso
		}
		
		public function Build($Array, $Id)
		{
			if( is_array($Array) )
			{
				$Keys = array_keys($Array);
				
				// <tag>data</tag> || <id>data</id>
				for($i = 0; $i < sizeof($Keys);
				{
					$Tag = $Keys[$i]; //[1 => $A][2 => $B][3 => $C][4 => $D]
					if(is_numeric($Tag))
						$Tag = $Id;
					if($Tag == "_id") // _id -> id
						$Tag = "id";
					if($Tag == $Id)
						$this -> XML .= "<" . strtolower($Tag) . ">"; //<id>
					else
						$this -> XML .= "<" . strtolower($Tag) . ">"; //<tag>
					//---//
					$this -> Build($Array[$Keys[$i]], $Id);
					//---//
					if($Tag == $Id)
						$this -> XML .= "</" . strtolower($Tag) . ">"; //</id>
					else
						$this -> XML .= "</" . strtolower($Tag) . ">"; //</tag>
					//---//	
				}//Fin búcle
			}//Fin IF
			elseif(!empty($Array)) //No está vacío
			{
				if($this -> checkForHTML($Array)) //True
					$Array = '<![CDATA[' . $Array . ']]>';
					
				$this -> XML .= $Array;
			}//Fin ELSEIF
			else
				return false; //Falló "todo"
		}
		
		public function toXML($Array, $Root = 'data', $Id = 'node')
		{
			//---//
			$this -> XML .= '<?xml version="1.0" encoding="UTF-8" ?>'."\n"; 
			$this -> XML .= "<" . strtolower($Root) . ">"."\n";
			$this -> XML .= $this -> Build($Array, $Id) . "\n";
			$this -> XML .= "</" . strtolower($Root). ">" . "\n";
			//---//
			return $this -> XML;
		}
		
		public function printXML($Array, $Root = 'data', $Id = 'node')
		{
			$this -> toXML($Array, $Root, $Id);
			
			header("Content-Type: text/xml");
			print $this -> XML;
		}
		

}

//EOF
?>