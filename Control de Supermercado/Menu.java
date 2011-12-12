package elcarritomagico;

import java.util.Calendar;
import java.util.GregorianCalendar;
/*
 *  Class: Menu
 *  Extends: Helpers
 *  Implements: Ninguno
 *  Ayuda: Menú general para el inicio del sistema
 */
public final class Menu extends Helpers{
    /*
     * Clase: Database
     * Objeto: _database
     */
    Database _database = new Database();
    Lists _GetList = new Lists();
    /*
     * Clase: GregorianCalendar
     * Objeto: _date
     * Adicional: Relacionados a la fecha y hora
     */
    Calendar _date = new GregorianCalendar();
    String day, month, year, fullDate, _fullDate, fullHour;
    int hour, minute, seconds;
    //Variable para el nombre del supermercado 
    String _name = "";
    //Variable para el nombre de la persona que atiende 
    String  _vendorName = "";
    //Variable del RFC
    String _rfc = "";
    //Variable para la dirección
    String _address = "";
    //Variable para el teléfono
    String _phone = "";
    //Arreglo para la información del Software
    String[] _softwareData = new String[3];
    //Variable para el reinicio del sistema
    boolean restart = false;
    //Variable para la cantidad de objetos comprados y ganancias totales
    int totalItems = 0; double cashWinned = 0.0;
    //Variable para la salida de ventas
    String finishSell = "";
    //Variable para buscar el código del objeto a comprar
    String itemToSearch = "";
    //Variable para la selección de la categoría
    int category = 0;
    int categoryList = 0;
    //Variable para conocer si fue o no encontrado el objeto
    String _finded = "";
    //Variable para los objetos comprados
    String buyedItems = "";
    //Variable para el análisis de los objetos comprados
    String _items = "";
    //Variable especial para el folio
    int _folio = 00000;
    //Arreglo de información para ventas. Y variables de uso
    String sellsInfo[][] = new String[100][5];
    int _count = 0;
    /*
     * Método: __construct();
     * Parámetros:
     * @Param: Ninguno
     * @Return: Ninguno
     * Ayuda: Constructor principal para configuraciones y valores iniciales
     */
    public void __construct()
    {
        // Información del Supermercado //
        _name = "El Carrito Mágico"; //Nombre del Supermercado
        _rfc = "LOOM 640924 IL1"; //RFC del Supermercado
                                                                //Se hace un salto de línea ya que la info. adicional va debajo de la dirección
        _address = "Bartolome de las casas #97 Colonia Centro\r\n Morelia Michoacán México"; //Dirección del supermercado
        _phone = "(443) 312 07 20"; //Teléfono del Supermercado
        _vendorName = _getStringData("Introduzca el nombre del vendedor:"); //Variable para el nombre del vendedor en turno
        // Información del Software //
        _softwareData[0] = "0.1.0";
        _softwareData[1] = "Equipo de Mario (Mario, Cesar y Tim)"; 
        _softwareData[2] = "07/Diciembre/2011";
        //-------------------//
        day = Integer.toString(_date.get(Calendar.DATE));
        //Comprobamos que no sea una fecha del 1 al 9 ya que retorna sin "0"
        //Y es más compleja la búsqueda del archivo en otra forma
        if(day.equalsIgnoreCase("9")) day = "09";
        if(day.equalsIgnoreCase("8")) day = "08";
        if(day.equalsIgnoreCase("7")) day = "07";
        if(day.equalsIgnoreCase("6")) day = "06";
        if(day.equalsIgnoreCase("5")) day = "05";
        if(day.equalsIgnoreCase("4")) day = "04";
        if(day.equalsIgnoreCase("3")) day = "03";
        if(day.equalsIgnoreCase("2")) day = "02";
        if(day.equalsIgnoreCase("1")) day = "01";
        //Se obtiene la demás información de la fecha ya obtenido el día
        month = Integer.toString(_date.get(Calendar.MONTH) + 1); //Mes
        year = Integer.toString(_date.get(Calendar.YEAR)); //Año
        fullDate = day+"/"+month+"/"+year; //Se arma la fecha en formato: DD/MM/YYYY
        _fullDate = day + "_" + month + "_" + year; //Se arma una sub-fecha en formato: DD_MM_YYYY
		//Se arma la hora
        hour = _date.get(Calendar.HOUR_OF_DAY); //Hora actual
        minute = _date.get(Calendar.MINUTE); //Minuto actual
        seconds = _date.get(Calendar.SECOND); //Segundo actual
        fullHour = hour+":"+minute+":"+seconds; //Se arma la hora actual
    }
    /*
     * Método: Menu();
     * Parámetros:
     * @Param: Ninguno
     * @Return: Ninguno
     * Ayuda: Constructor secundario, menú general que inicia el trabajo del sistema
     */
    Menu()
    {
        __construct();
        //Opción del menú escogida por el usuario
        int _menuOption = 0;
        //Se estará realizando todo dentro de un proceso hasta que "_menuOption" sea
        //diferente de 10.
        do
        {
            //Obtenemos desde un menú la selección
            _menuOption = _getIntFromStringData("Control de Supermercado: " + _name
                    + "\n1) Realizar una nueva venta"
                    + "\n2) Imprimir última venta"
                    + "\n3) Mostrar recibos disponibles"
                    + "\n4) Listar productos"
                    + "\n5) Imprimir información del día"
                    + "\n8) Reiniciar el Sistema"
                    + "\n9) Información del Software"
                    + "\n10) Salir");
            //Si no fue el valor esperado (entero) se demuestra un error
            if(_menuOption == 400 || empty(_menuOption) || _menuOption > 10)
                _print("Por favor, selecciona una opción válida.");
            else
            {
                //Dependiendo a la selección, llamaremos la información
                switch(_menuOption)
                {
                    //Realizar venta
                    case 1:
                        //Incremento de una venta, por lo que se creará un ticket para ella y el folio
                        //aumentará para dar un nuevo folio por cada venta
                        _folio++;
                        //Se reinicia el contador por venta realizada
                        _count = 0;
                        //Se reinicia por cada nueva compra toda la información
                        for(int i = 0; i < 100; i++)
                        {
                            for(int j = 0; j < 5; j++)
                            {
                                if(sellsInfo[i][j] == null || sellsInfo[i][j].equalsIgnoreCase(""))
                                    sellsInfo[i][j] = "";
                            }
                        }
                        do
                        {
                           category = _getIntFromStringData("Categoría:"
                                   + "\n1) Electrónicos"
                                   + "\n2) Línea blanca"
                                   + "\n3) Muebles"
                                   + "\n4) Blancos"
                                   + "\n5) Hogar"
                                   + "\n6) Discos y Películas"
                                   + "\n7) Revistas y Libros"
                                   + "\n8) Ferretería"
                                   + "\n9) Perfumería"
                                   + "\n10) Farmacia"
                                   + "\n11) Papelería"
                                   + "\n12) Jardinería"
                                   + "\n13) Juguetería"
                                   + "\n14) Deportes"
                                   + "\n15) Regalos"
                                   + "\n16) Ropa"
                                   + "\n17) Frutas y Verduras"
                                   + "\n18) Pescados y Mariscos"
                                   + "\n19) Carnes"
                                   + "\n20) Salchichonería"
                                   + "\n21) Panadería"
                                   + "\n22) Tortillería"
                                   + "\n23) Cremas y Quesos"
                                   + "\n24) Lácteos"
                                   + "\n25) Salir");
                           //Si la selección de la categoría fue mala, se dará un aviso
                           if(category >= 26)
                               category = 26;
                           //Si la selección de la categoría fue "25" se saldrá
                           if(category == 25)
                               break;
                           //En caso contrario, pedirá el código (solo si es una categoría)
                           else
                               //Si es una categoría, pedimos el código
                                if(isNotCategory(category))
                                    //Se obtiene el código del objeto introducido por el usuario
                                    itemToSearch = _getStringData("Código:");
                               //Si no lo es, demostramos que la categoría está incorrecta y por lo tanto no existirá ningún artículo
                                else
                                    category = 26;
                           finishSell = itemToSearch;
                           switch(category)
                           {
                               //Electrónicos
                               case 1:
                                    //Se busca el código en las bases de datos
                                   _finded = _database.electronics(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.electronics(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   break;
                               //Línea blanca
                               case 2:
                                   //Se busca el código en las bases de datos
                                   _finded = _database.whiteLine(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.whiteLine(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   break;
                               //Muebles
                               case 3:
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Furniture(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Furniture(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   break;
                                   
                                      
                               case 4:
                                   
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.White(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.White(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 5:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Home(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Home(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   
                                   break;
                               case 6:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.DiscMovies(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.DiscMovies(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   break;
                               case 7:
                                   
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Books(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Books(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   break;
                               case 8:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Ferretera(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Ferretera(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 9:
                                   
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Lotions(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Lotions(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   break;
                               case 10:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Pharmacy(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Pharmacy(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   break;
                               case 11:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Stationary(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Stationary(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   
                                   break;
                               case 12:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Garden(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Garden(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   break;
                               case 13:
                                   
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Toys(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Toys(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 14:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Sports(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Sports(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 15:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Gifts(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Gifts(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   
                                   break;
                               case 16:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Cloth(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Cloth(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 17:
                                   
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Fruits(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Fruits(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 18:
                                   
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Fish(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Fish(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   break;
                               case 19:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Meat(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Meat(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   break;
                               case 20:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Salch(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Salch(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   
                                   break;
                               case 21:
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Breat(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Breat(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 22:
                                   
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Masa(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Masa(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 23:
                                   
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Chesse(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Chesse(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 24:
                                   
                                   
                                   //Se busca el código en las bases de datos
                                   _finded = _database.Milk(itemToSearch);
                                   //Se convierte a mayúsculas por cualquier caso necesario
                                   _finded.toUpperCase();
                                   //Si no fue encontrado,el retorno de el método es "" (vacío)
                                   //Adicional, el código deberá ser diferente de "s1" ya que "s1" es el comando
                                   //para salir de la venta.
                                   if(_finded.equalsIgnoreCase("") && !itemToSearch.equalsIgnoreCase("s1"))
                                       _print("Objeto no encontrado");
                                   else
                                   {
                                       //Si el código introducido fue "s1" se rompe el búcle
                                       if(itemToSearch.equalsIgnoreCase("s1"))
                                           break;
                                       else
                                       {
                                           int quantity = 0;
                                            itemToSearch.toUpperCase();
                                            _items = _database.Milk(itemToSearch);
                                            buyedItems = _getItemName(_items);
                                            quantity = _getIntFromStringData("Cantidad: ");
                                            if(quantity == 400)
                                                quantity = _getIntFromStringData("La cantidad solo pueden ser valores enteros, introduzca una nueva cantidad:");
                                             _print("Se compró: " + buyedItems
                                                     + "\nCantidad: " + quantity
                                                     + "\nPrecio: $" + (_getPriceValue(_items) * quantity));
                                             sellsInfo[_count][0] = quantity + "";
                                             sellsInfo[_count][1] = buyedItems;
                                             sellsInfo[_count][2] = "0%";
                                             sellsInfo[_count][3] = (_getPriceValue(_items) * quantity) + "";
                                            _count++;
                                            totalItems += quantity;
                                            cashWinned += (_getPriceValue(_items) * quantity);
                                       }
                                   }
                                   
                                   break;
                               case 26:  
                                   _print("Categoría no encontrada");
                                   break;
                           }
                        }while(!finishSell.equalsIgnoreCase("s1"));
                        break;
                    //Imprimir la venta
                    case 2:
                    //Si el contador es 0, significa que no hay ventas realizadas aún
                    if(_count == 0)
                       _print("Se debe realizar una venta antes de poder imprimir el recibo");
                    //Si ya se realizo, se procede a impimir la información
                    else
                    {
                        String sell = "";
                        double totalPrice = 0.00;
                        for(int i = 0; i < sellsInfo.length; i++)
                        {
                            for(int j = 0; j < sellsInfo[i].length; j++)
                            {
                                if(sellsInfo[i][j].equalsIgnoreCase(""))
                                    break;

                                if(j == 3)
                                {
                                    sell += sellsInfo[i][j];
                                    totalPrice += convertToDouble(sellsInfo[i][j]);
                                    sell += "\n";
                                }
                                else
                                {
                                    sell += sellsInfo[i][j];
                                    sell += " | ";
                                }
                            }
                        }
                        double totalCash = _getDoubleFromStringData("Total a pagar: $" + totalPrice
                                + "\nEfectivo total: ");
                                if(totalCash == 400.0)
                                    totalCash = _getDoubleFromStringData("El efectivo introducido no es válido, introduzca nuevamente el efectivo: ");
                        String _ticketContent = "";
                        _ticketContent = _name
                           + "\r\nLe atendió: " + _vendorName
                           + "\r\nRFC: " + _rfc
                           + "\r\nDirección: " + _address
                           + "\r\nTeléfono: " + _phone
                           + "\r\n====================================================="
                           + "\r\nFolio: " + _folio
                           + "\r\nFecha: " + fullDate
                           + "\r\nHora: " + fullHour
                           + "\r\n====================================================="
                           + "\r\n Cantidad | Nombre | Descuento | Total"
                           + "\r\n " + sell
                           + "\r\nSubtotal: $" + totalPrice
                           + "\r\nMonedero: 0.00"
                           + "\r\nDescuento: 0.0%"
                           + "\r\nCargo: $0.00"
                           + "\r\nTotal: $" + totalPrice
                           + "\r\nEfectivo: $" + totalCash
                           + "\r\nCambio: $" + (totalCash - totalPrice)
                           + "\r\n¡Gracias por su preferencia, Vuelva pronto!"
                           + "\r\nEste no es un comprobante fiscal"
                           + "\r\nControl de Supermercados v" + _softwareData[0];
                           _createTxtFile(_folio + "", _fullDate);
                           writeOnTxtFile(_ticketContent, _folio + "", _fullDate);
                           _print(_ticketContent);
                        }
                        break;
                    //Mostrar recibos disponibles
                    case 3:
                        //Variable para la petición de la "fecha"
                        int _from = 0;
                        //Se pregunta si es del mismo día u otro, de esta forma, evitamos la entrada contínua de "fechas"
                        _from = _getIntFromStringData("Mostrar recibos disponibles de..."
                                + "\n1) Hoy"
                                + "\n2) Otro día");
                                //Si la opción escogida es incorrecta, lo demostramos
                                if(_from >= 3 || _from == 0)
                                    _from = _getIntFromStringData("La opción indicada es incorreca, seleccione nuevamente una opción:"
                                            + "\n1) Hoy"
                                            + "\n2) Otro día");
                                else
                                {
                                    switch(_from)
                                    {
                                        //Si se seleccionó el día de hoy, solamente mostramos los recibos de hoy
                                        case 1:
                                                //Pedimos el número de recibo
                                                String _fileToRead = _getStringData("Número del recibo: ");
                                                //Imprimimos el recibo
                                                _getFileFromDirectory(_fileToRead, _fullDate);
                                            break;
                                       //Si se seleccionó otro día, pedimos el número del recibo y la fecha en el formato
                                       //DD/MM/YYYY
                                        case 2:
                                            //Pedimos la fecha
                                            String _findDate = _getStringData("Fecha: "
                                                        + "\nEl formato debe ser: DD/MM/YYYY");
                                            //Pedimos el recibo
                                                String _fileToReadSecondary = _getStringData("Número del recibo: ");
                                            //A la fecha le reemplazamos: "/" por "_"
                                                _findDate = _findDate.replace("/", "_");
                                            //Buscamos el recibo
                                                _getFileFromDirectory(_fileToReadSecondary, _findDate);
                                            break;
                                    }
                                }
                        break;
                    case 4:
                        categoryList = _getIntFromStringData("Categoría:"
                                   + "\n1) Electrónicos"
                                   + "\n2) Línea blanca"
                                   + "\n3) Muebles"
                                   + "\n4) Blancos"
                                   + "\n5) Hogar"
                                   + "\n6) Discos y Películas"
                                   + "\n7) Revistas y Libros"
                                   + "\n8) Ferretería"
                                   + "\n9) Perfumería"
                                   + "\n10) Farmacia"
                                   + "\n11) Papelería"
                                   + "\n12) Jardinería"
                                   + "\n13) Juguetería"
                                   + "\n14) Deportes"
                                   + "\n15) Regalos"
                                   + "\n16) Ropa"
                                   + "\n17) Frutas y Verduras"
                                   + "\n18) Pescados y Mariscos"
                                   + "\n19) Carnes"
                                   + "\n20) Salchichonería"
                                   + "\n21) Panadería"
                                   + "\n22) Tortillería"
                                   + "\n23) Cremas y Quesos"
                                   + "\n24) Lácteos"
                                   + "\n25) Salir");
                           //Si la selección de la categoría fue mala, se dará un aviso
                           if(categoryList >= 26)
                               categoryList = 26;
                           //Si la selección de la categoría fue "25" se saldrá
                           if(categoryList == 25)
                               break;
                           //En caso contrario, pedirá el código (solo si es una categoría)
                           else
                               //Si es una categoría, pedimos el código
                                if(isNotCategory(categoryList)==false)
                                    //Se obtiene el código del objeto introducido por el usuario
                                    categoryList = categoryList;
                               //Si no lo es, demostramos que la categoría está incorrecta y por lo tanto no existirá ningún artículo
                                else
                                    categoryList = 26;
                           switch(categoryList){
                               case 1:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.electronics());
                                   break;
                               case 2:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.whiteLine());
                                   break;
                               case 3:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Furniture());
                                   break;
                               case 4:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.White());
                                   break;
                               case 5:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Home());
                                   break;
                               case 6:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.DiscMovies());
                                   break;
                               case 7:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Books());
                                   break;
                               case 8:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Ferretera());
                                   break;
                               case 9:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Lotions());
                                   break;
                               case 10:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Pharmacy());
                                   break;
                               case 11:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Stationary());
                                   break;
                               case 12:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Garden());
                                   break;
                               case 13:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Toys());
                                   break;
                               case 14:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Sports());
                                   break;
                               case 15:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Gifts());
                                   break;
                               case 16:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Cloth());
                                   break;
                               case 17:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Fruits());
                                   break;
                               case 18:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Fish());
                                   break;
                               case 19:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Meat());
                                   break;
                               case 20:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Salch());
                                   break;
                               case 21:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Breat());
                                   break;
                               case 22:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Masa());
                                   break;
                               case 23:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Chesse());
                                   break;
                               case 24:
                                   _print("Nombre     |     Precio       |       Código\n" + _GetList.Milk());
                                   break;
                               case 25:
                                   break;
                               case 26:
                                   _print ("Categoria no Encontrada");
                                   break;
                           }
                        
                        break;
                    case 5:
                        //Se imprime la información del día
                        String _dayInfo = (_name
                                + "\r\nInformación del Día: " + fullDate
                                + "\r\n====================================================="
                                + "\r\nCantidad total de compradores: " + _folio
                                + "\r\nGanancias totales: " + cashWinned
                                + "\r\nVentas totales: " + totalItems);
                        String _itemsSelled = "";
                        if(_count == 0)
                            _itemsSelled = "Último registro: " + fullDate + " a las: " + fullHour
                                    + "\r\nNo hay ventas aún"
                                    + "\r\n=================================";
                        else
                        {
                            for(int i = 0; i < sellsInfo.length; i++)
                            {
                                for(int j = 0; j < sellsInfo[i].length; j++)
                                {
                                    if(sellsInfo[i][j].equalsIgnoreCase(""))
                                        break;

                                    if(j == 3)
                                    {
                                        _itemsSelled += sellsInfo[i][j];
                                        _itemsSelled += "\n";
                                    }
                                    else
                                    {
                                        _itemsSelled += sellsInfo[i][j];
                                        _itemsSelled += " | ";
                                    }
                                }
                            }
                        }
                        _print("Se creará un recibo para las ventas del día");
                        _createTxtFile("InD" + _folio,_fullDate);
                        _print("Se creará un recibo adicional de los objetos vendidos durante el día");
                        _createTxtFile("ObV" + _folio, _fullDate);
                        writeOnTxtFile(_dayInfo, "InD" + _folio, _fullDate);
                        writeOnTxtFile(_itemsSelled, "ObV" + _folio, _fullDate);
                        _print(_dayInfo);
                        break;
                    case 6:
                        break;
                    //Reinicio global del sistema
                    case 8:
                        int _restart = _getIntFromStringData("¿Desea reiniciar el sistema?"
                                + "\n1) Si"
                                + "\n2) No");
                                //Si la opción elegida fue 1, es que se reiniciará el sistema
                                if(_restart == 1)
                                    restart = true; //Se usa el valor booleano solamente para posibles referencias.
                                else
                                    restart = false; //Si la opción elegida fue diferente de 1, es que no se quiere reiniciar el sistema
                                       //Ya que sabemos que si se desea reiniciar, lo hacemos
                                if(restart == true)
                                {
                                    //Por cualquier referencia generamos una nueva variable
                                    String vendorName = _getStringData("Ingrese el nombre del vendedor nuevo:");
                                    //Se almacena en la variable global _vendorName el nuevo nombre.
                                    _vendorName = vendorName;
                                    //Se reinician las ventas
                                    for(int i = 0; i < 100; i++)
                                    {
                                        for(int j = 0; j < 5; j++)
                                        {
                                           sellsInfo[i][j] = "";
                                        }
                                    }
                                    //Se reinicia el folio:
                                    _folio = 0;
                                    //Se reinicia la cantidad de items totales 
                                    totalItems = 0;
                                    _print("El sistema fue reiniciado correctamente.");
                                  }
                                   else
                                        //Se reinicia el valor de _restart
                                         _restart = 0;
                        break;
                    //Información del Sistema
                    case 9:
                        _print("Versión del Software: " + _softwareData[0]
                           + "\nDesarrollado por: "     + _softwareData[1]
                           + "\nÚltima actualización: " + _softwareData[2]);
                        break;
                }
            }
        }while(_menuOption != 10);
    }
}
