/*
 *  Control de Supermercado
 */
package elcarritomagico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
/*
 *  Class: Helpers
 *  Extends: Ninguno
 *  Implements: Ninguno
 *  Ayuda: Métodos de ayuda para la creación del programa
 */
public class Helpers {
    /*
     * Método: _getIntData(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = (Int) _returnInt;
     * Ayuda: Retorna el valor de una String introducida (por el usuario)
     * y la convierte a entero.
     */
    public int _getIntFromStringData(String Value)
    {
        try
        {
            int _returnInt = Integer.parseInt(JOptionPane.showInputDialog(Value));
            return _returnInt;
        }
        catch(NumberFormatException ex)
        {
            //Si no fue introducido un valor "entero", se mostrará un error.
            int _returnInt = 400; //El error es marcado con un valor de "400"_vendorName
            return _returnInt;
        }
    }

    public double _getDoubleFromStringData(String Value)
    {
        try
        {
            double _returnDouble = Double.parseDouble(JOptionPane.showInputDialog(Value));
            return _returnDouble;

        }
        catch(NumberFormatException ex)
        {
            double _returnDouble = 400;
            return _returnDouble;
        }
    }
    /*
     * Método: _getStringData(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = (String) _returnString;
     * Ayuda: Retorna el valor de una String 
     */
    public String _getStringData(String Value)
    {
        String _returnString = JOptionPane.showInputDialog(Value);
        return _returnString;
    }
    /*
     * Método: _print(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = Ninguno;
     * Ayuda: Imprime una String
     */
    public void _print(String Value)
    {
        JOptionPane.showMessageDialog(null, Value);
    }
    /*
     * Método: _print(int Value);
     * Parámetros:
     * @Param = (int) Value;
     * @Return = Ninguno;
     * Ayuda: Imprime un entero.
     */
    public void _print(int Value)
    {
        JOptionPane.showMessageDialog(null, Value);
    }
    /*
     * Método: empty(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = true/false;
     * Ayuda: Mide el tamaño de el valor introducido, si es 0, está vacío
     * y por lo tanto retorna verdadero, en caso contrario, retorna falso
     */
    public boolean empty(String Value)
    {
        if(Value.length() == 0)
            return true;
        else
            return false;
    }
    /*
     * Método: empty(int Value);
     * Parámetros:
     * @Param = (int) Value;
     * @Return = true/false;
     * Ayuda: Mide el tamaño de el valor introducido, si es 0, está vacío
     * y por lo tanto retorna verdadero, en caso contrario, retorna falso
     */
    public boolean empty(int Value)
    {
        String _Value = Value+"";
        if(_Value.length() == 0)
            return true;
        else
            return false;
    }
    /*
     * Método empty(String[][] Value);
     * Parámetros:
     * @Param = (String[][]) Value;
     * @Return = true/false;
     * Ayuda: Mide el tamaño de un arreglo, si está vacío
     * se retorna true, en caso contrario, retorna false
     */
    public boolean empty(String[][] Value)
    {
        if(Value.length == 0)
            return true;
        else
            return false;
    }
    /*
     * Método: _getItemName(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = _itemName;
     * Ayuda: Retorna el nombre del objeto comprado eliminando el costo
     */
    public String _getItemName(String Value)
    {
        String _separedItemName[] = Value.split(",");
        String _itemName = _separedItemName[0];
            return _itemName;
    }
    /*
     * Método: _getPriceValue(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = _itemPrice;
     * Ayuda: Retorna el costo de un objeto comprado.
     */
    public double _getPriceValue(String Value)
    {
        double _itemPrice = 0.00;
        String _separedPriceFromItemName[] = Value.split(",");
        String itemPrice = _separedPriceFromItemName[1];
            _itemPrice = Double.parseDouble(itemPrice);
        return _itemPrice;
    }
    /*
     * Método: convertToInt(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = _converted;
     * Ayuda: Convierte un valor a "entero" basado en un "String".
     */
    public int convertToInt(String Value)
    {
        int _converted = 0;
        _converted = Integer.parseInt(Value);
        return _converted;
    }
    /*
     * Método: convertToDouble(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = _converted;
     * Ayuda: Convierte un valor a "doble(double)" basado en un "String".
     */
    public double convertToDouble(String Value)
    {
        double _converted = 0.00;
        _converted = Double.parseDouble(Value);
        return _converted;
    }
    /*
     * Método: createTxtFile(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Return = Ninguno
     * Ayuda: Crea archivos con el nombre introducido a través
     * del parámetro. El nombre del archivo está en el formato:
     * recibo_no_X_fecha_DD_MM_YYYY.txt
     */
    public void _createTxtFile(String Value, String secondValue)
    {
        File _file = new File("C:\\temp\\recibo_no_" + Value + "_fecha_" + secondValue + ".txt");
        try
        {
            if(_file.createNewFile())
                _print("Se creó el recibo");
            else
                _print("No se pudo crear el recibo, o el archivo ya existía.");
                
        }
        catch(Exception e) 
        {
            _print("Error en la función _createTxtFile(String Value), no se pudo crear el archivo");
        }
    }
    /*
     * Método: writeOnTxtFile(String Value);
     * Parámetros:
     * @Param = (String) Value;
     * @Param = (String) secondValue;
     * @Param = (String) thirdValue;
     * @Return = Ninguno
     * Ayuda: Escribe el texto indicado por medio del parámetro Value.
     * El nombre del archivo es dado por el formato:
     * recibo_no_X_fecha_DD_MM_YYYY.txt
     */
    public void writeOnTxtFile(String Value, String secondValue, String thirdValue)
    {
        FileWriter _file = null;
        try
        {
            _file = new FileWriter("C:\\temp\\recibo_no_" + secondValue + "_fecha_" + thirdValue + ".txt");
            _file.write(Value);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(null != _file)
                    _file.close();
            }
            catch(Exception sE)
            {
                sE.printStackTrace();
            }
        }
    }
    /*
     * Método: _getFileFromDirectory(String Value, String secondValue);
     * Parámetros:
     * @Param = (String) Value;
     * @Param = (String) secondValue;
     * @Return = Ninguno
     * Ayuda: Obtiene la información de un archivo desde el directorio C:\temp
     * e imprime su información, si no se encuentra el archivo, imrpime un error
     */
    public void _getFileFromDirectory(String Value, String secondValue)
    {
        File _file = null;
        FileReader _fileReader = null;
        BufferedReader _bufferedReader = null;
            try
            {
                _file = new File("C:\\temp\\recibo_no_" + Value + "_fecha_" + secondValue +".txt");
                _fileReader = new FileReader(_file);
                _bufferedReader = new BufferedReader(_fileReader);
                String _content = "", _line;
                while((_line = _bufferedReader.readLine()) != null)
                    _content += _line + "\n";
                _print(_content);
            }
            catch(Exception e)
            {
                _print("El recibo no fue encontrado");
            }
    }
    /*
     * Método: isCategory(int Value);
     */
    public boolean isNotCategory(int Value)
    {
        if(Value != 1 || Value != 2 || Value != 3 || Value != 4 || Value != 5
                || Value != 6 || Value != 7 || Value != 8 || Value != 9 || Value != 10
                || Value != 11 || Value != 12 || Value != 13 || Value != 14 || Value != 15
                || Value != 16 || Value != 17 || Value != 18 || Value != 19 || Value != 20
                || Value != 21 || Value != 22 || Value != 23 || Value != 24)
            return true;
        else
            return false;
    }
}
