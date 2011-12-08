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
}
