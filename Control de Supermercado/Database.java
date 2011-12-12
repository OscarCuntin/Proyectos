package elcarritomagico;
/*
 *  Class: Database
 *  Extends: Helpers
 *  Implements: Ninguno
 *  Ayuda: Base de datos con los métodos que incluyen la información
 *  con la cual podrá ser buscado un producto por categorías
 */
public class Database extends Helpers{
    /*
     * Método: electronics(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = (String) _returnData;
     * Ayuda: Retorna la información de un producto en caso de ser
     *  encontrado en la base de datos de electrónicos, si no
     *  es retornado con error ""
     */
    public String electronics(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _electronics[][] = {
                                    {"Televisión LG Modelo 42LW650 3D", "12000", "42LW650", ""},//i = 0
                                    {"Televisión LG Modelo 42LV3550 3D", "13000", "42LV3550", ""}, //i = 1
                                    {"Estereo Sony Modelo SFX250", "6500", "SFX250", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _electronics.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_electronics[i][2]))
                    _returnData = _electronics[i][0]+","+_electronics[i][1];
            }
        return _returnData;
    }
    /*
     * Método: whiteLine(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = (String) _returnData;
     * Ayuda: Retorna la información de un producto en caso de ser
     *  encontrado en la base de datos de línea blanca, si no
     *  es retornado con error ""
     */
	public String whiteLine(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _whiteLine[][] = {
                                    {"Lavadora Whirpool Modelo MWF120", "5000", "MWF120", ""},//i = 0
                                    {"Secadora LG Modelo SLLM12", "4500", "SLLM12", ""}, //i = 1
                                    {"Refrigerador Samsung Modelo MMS120", "9800", "MMS120", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _whiteLine.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_whiteLine[i][2]))
                    _returnData = _whiteLine[i][0]+","+_whiteLine[i][1];
            }
        return _returnData;
    }
    
	public String Furniture(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Furniture[][] = {
                                    {"Sala Troncoso Modelo HX7425", "8500", "HX7425", ""},//i = 0
                                    {"Cama Springair Modelo ", "4500", "SLLM12", ""}, //i = 1
                                    {"Sillon Acme Modelo SILLAC", "8700", "SILLAC", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Furniture.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Furniture[i][2]))
                    _returnData = _Furniture[i][0]+","+_Furniture[i][1];
            }
        return _returnData;
    }
    
	public String White(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _White[][] = {
                                    {"Sabana Disney Modelo OIINNF", "500", "OIINNF", " "},//i = 0
                                    {"Cortina blanquillas Modelo CORBL", "450", "CORBL", ""}, //i = 1
                                    {"Colcha El valiente Modelo WEFF", "310", "WEFF", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _White.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_White[i][2]))
                    _returnData = _White[i][0]+","+_White[i][1];
            }
        return _returnData;
    }
 
	public String Home(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Home[][] = {
                                    {"Bote basura Chango Modelo HX5", "845", "HX5", ""},//i = 0
                                    {"Plumero plumas Modelo SZ12", "322", "SZ12", ""}, //i = 1
                                    {"Trapeador 2000 Modelo GASE", "123", "GASE", "  "}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Home.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Home[i][2]))
                    _returnData = _Home[i][0]+","+_Home[i][1];
            }
        return _returnData;
    }
  
	public String DiscMovies(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _DiscMovies[][] = {
                                    {"Conde Patula", "155", "ASDNE", ""},//i = 0
                                    {"Iron Man", "99", "VESAA", ""}, //i = 1
                                    {"EL Aro", "153", "FESAA", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _DiscMovies.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_DiscMovies[i][2]))
                    _returnData = _DiscMovies[i][0]+","+_DiscMovies[i][1];
            }
        return _returnData;
    }
   
	public String Books(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Books[][] = {
                                    {"Narnia", "80", "AFBA", ""},//i = 0
                                    {"Un mundo feliz ", "655", "SADFA", ""}, //i = 1
                                    {"Harry Potter ", "344", "HP001", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Books.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Books[i][2]))
                    _returnData = _Books[i][0]+","+_Books[i][1];
            }
        return _returnData;
    }
    
	public String Ferretera(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Ferretera[][] = {
                                    {"Clavos Nilon tamaño 1in", "1", "CLIN1", ""},//i = 0
                                    {"Cable para soldar tamaño 1mt", "CS1MT", "7", ""}, //i = 1
                                    {"Desarmador acme Modelo 12DSFA", "1211", "12DSFA", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Ferretera.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Ferretera[i][2]))
                    _returnData = _Ferretera[i][0]+","+_Ferretera[i][1];
            }
        return _returnData;
    }
     
	public String Lotions(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Lotions[][] = {
                                    {"Black Posion Modelo H3454", "850", "H3454", ""},//i = 0
                                    {"Paris Hilton Modelo S32KM", "2300", "S32KM", ""}, //i = 1
                                    {"Chanel Modelo AFAFF ", "5000", "AFAFF", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Lotions.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Lotions[i][2]))
                    _returnData = _Lotions[i][0]+","+_Lotions[i][1];
            }
        return _returnData;
    }
      
	public String Pharmacy(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Pharmacy[][] = {
                                    {"Aspirnas Modelo SASG5", "113", "SASG5", ""},//i = 0
                                    {"Peptovismol Modelo VASSD", "110", "VASSD", ""}, //i = 1
                                    {"Genoprasol Modelo DFSDF", "23", "DFSDF", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Pharmacy.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Pharmacy[i][2]))
                    _returnData = _Pharmacy[i][0]+","+_Pharmacy[i][1];
            }
        return _returnData;
    }
       
	public String Stationary(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Stationary[][] = {
                                    {"Papel Barato Modelo PPBLC", "123", "PPBLC", ""},//i = 0
                                    {"Plastilina Playdoll Modelo DSFD2", "124", "DSFD2", ""}, //i = 1
                                    {"Pincelin Acuarela Modelo SDFR", "11", "SDFR", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Stationary.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Stationary[i][2]))
                    _returnData = _Stationary[i][0]+","+_Stationary[i][1];
            }
        return _returnData;
    }

	public String Garden(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Garden[][] = {
                                    {"Arbol Guayabo", "144", "GUAY", ""},//i = 0
                                    {"Tijeras Cortlin Modelo SASD1", "322", "SASD1", ""}, //i = 1
                                    {"Fuente Canario Modelo HTR1", "1211", "HTR1", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Garden.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Garden[i][2]))
                    _returnData = _Garden[i][0]+","+_Garden[i][1];
            }
        return _returnData;
    }
         
         
	public String Toys(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Toys[][] = {
                                    {"Carrito Hotwheels Modelo MRZ1", "331", "MRZ1", ""},//i = 0
                                    {"Scrabble Matel Modelo SSDF2", "123", "SSDF2", ""}, //i = 1
                                    {"4EnLinea Matel Modelo 1SDF0", "111", "1SDF0", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Toys.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Toys[i][2]))
                    _returnData = _Toys[i][0]+","+_Toys[i][1];
            }
        return _returnData;
    }
          
	public String Sports(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Sports[][] = {
                                    {"Bat de baseball Modelo ASD5", "300", "ASD5", ""},//i = 0
                                    {"Balon adidas Modelo ARF22", "500", "ARF22", ""}, //i = 1
                                    {"Guantes Fuerte Modelo TERF", "120", "TERF", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Sports.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Sports[i][2]))
                    _returnData = _Sports[i][0]+","+_Sports[i][1];
            }
        return _returnData;
    }
           
	public String Gifts(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Gifts[][] = {
                                    {"Bola de nieve globo Modelo BLA5", "120", "BLA5", ""},//i = 0
                                    {"Anillo Acme Modelo AACM", "110", "AACM", ""}, //i = 1
                                    {"Oso teddy Modelo TDBR", "600", "TDBR", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Gifts.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Gifts[i][2]))
                    _returnData = _Gifts[i][0]+","+_Gifts[i][1];
            }
        return _returnData;
    }
            
	public String Cloth(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Cloth[][] = {
                                    {"Camisa Tommy  Modelo HXBJ5", "500", "HXBJ5", ""},//i = 0
                                    {"Pantalon Lacosste Modelo SLLK", "4500", "SLLK", ""}, //i = 1
                                    {"Chamarra DC Modelo PINEO", "1130", "PINEO", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Cloth.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Cloth[i][2]))
                    _returnData = _Cloth[i][0]+","+_Cloth[i][1];
            }
        return _returnData;
    }
             
	public String Fruits(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Fruits[][] = {
                                    {"Manzanas Granja Modelo GESA", "232", "GESA", ""},//i = 0
                                    {"Brocolis Verde Modelo 1EE2", "123", "1EE2", ""}, //i = 1
                                    {"Aguacate Uruapan Modelo 15SD", "151", "15SD", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Fruits.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Fruits[i][2]))
                    _returnData = _Fruits[i][0]+","+_Fruits[i][1];
            }
        return _returnData;
    }
              
	public String Fish(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Fish[][] = {
                                    {"Tsurimi Tsunami Modelo TTSM", "12", "TTSM", ""},//i = 0
                                    {"Almeja Laperla Modelo SLLR", "31", "SLLR", ""}, //i = 1
                                    {"Camaron enano Modelo FEA0", "43", "FEA0", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Fish.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Fish[i][2]))
                    _returnData = _Fish[i][0]+","+_Fish[i][1];
            }
        return _returnData;
    }
               
	public String Meat(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Meat[][] = {
                                    {"Barbacoa De Vaca Modelo CAPRI", "124", "CAPRI", ""},//i = 0
                                    {"Chuleta Puerco Modelo SASD", "53", "SASD", ""}, //i = 1
                                    {"Salchichas Puerco Modelo PAVO", "22", "PAVO", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Meat.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Meat[i][2]))
                    _returnData = _Meat[i][0]+","+_Meat[i][1];
            }
        return _returnData;
    }
                
	public String Salch(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Salch[][] = {
                                    {"Jamon de Cerdo Modelo CAPN", "144", "CAPN", ""},//i = 0
                                    {"Mortadela de Cerdo Modelo SLGD", "57", "SLGD", ""}, //i = 1
                                    {"Chorizo de Pavo Modelo PVJG", "72", "PVJG", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Salch.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Salch[i][2]))
                    _returnData = _Salch[i][0]+","+_Salch[i][1];
            }
        return _returnData;
    }
                
	public String Breat(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Breat[][] = {
                                    {"Pastelitos Pinguinos Modelo PING", "32", "PING", ""},//i = 0
                                    {"Muffins Cupcake Modelo MUFF", "21", "MUFF", ""}, //i = 1
                                    {"Bolillo-Telera Modelo TELRA", "54", "TELRA", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Breat.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Breat[i][2]))
                    _returnData = _Breat[i][0]+","+_Breat[i][1];
            }
        return _returnData;
    }
                 
	public String Masa(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Masa[][] = {
                                    {"Tortilla Maiz Clave HXAS", "12", "HXAS", ""},//i = 0
                                    {"Tortilla Harina Trigo Clave TRTR ", "33", "HXAS", ""}, //i = 1
                                    {"Tortilla Nopal Clave TRNP ", "11", "TRNP", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Masa.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Masa[i][2]))
                    _returnData = _Masa[i][0]+","+_Masa[i][1];
            }
        return _returnData;
    }
                  
 
	public String Chesse(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Chesse[][] = {
                                    {"Queso Chedar Modelo HSDH", "23", "HSDH", ""},//i = 0
                                    {"Crema LALA Modelo SDSF", "45", "SDSF", ""}, //i = 1
                                    {"Queso de puerco Modelo QUEP", "11", "QUEP", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Chesse.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Chesse[i][2]))
                    _returnData = _Chesse[i][0]+","+_Chesse[i][1];
            }
        return _returnData;
    }

	public String Milk(String Value)
    {
        String _returnData = "";
        //j = 0 | Nombre del producto
        //j = 1 | Costo del producto
        //j = 2 | Código del producto
        //j = 3 | Campo adicional
        String _Milk[][] = {
                                    {"Leche LALA", "12", "LELA", ""},//i = 0
                                    {"Leche en polvo Nido", "210", "LENI", ""}, //i = 1
                                    {"NUTRILECHE Form Lac", "11", "NUTR", ""}, //i = 2
                                  };
           //Método de búsqueda
            for(int i = 0; i < _Milk.length; i++)
            {
                //Si se encontró el artículo, se retorna el artículo, si no, se retorna vacío
                if(Value.equalsIgnoreCase(_Milk[i][2]))
                    _returnData = _Milk[i][0]+","+_Milk[i][1];
            }
        return _returnData;
    }
 
}
        
