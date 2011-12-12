package elcarritomagico;

public class Lists extends Helpers{
    
    public String electronics()
    {
        String _electronics[][] = {
                                    {"Televisión LG Modelo 42LW650 3D", "12000", "42LW650", ""},//i = 0
                                    {"Televisión LG Modelo 42LV3550 3D", "13000", "42LV3550", ""}, //i = 1
                                    {"Estereo Sony Modelo SFX250", "6500", "SFX250", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_electronics[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
    public String whiteLine()
    {
        String _whiteLine[][] = {
                                    {"Lavadora Whirpool Modelo MWF120", "5000", "MWF120", ""},//i = 0
                                    {"Secadora LG Modelo SLLM12", "4500", "SLLM12", ""}, //i = 1
                                    {"Refrigerador Samsung Modelo MMS120", "9800", "MMS120", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_whiteLine[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
    
    public String Furniture()
    {
        String _Furniture[][] = {
                                    {"Sala Troncoso Modelo HX7425", "8500", "HX7425", ""},//i = 0
                                    {"Cama Springair Modelo ", "4500", "SLLM12", ""}, //i = 1
                                    {"Sillon Acme Modelo SILLAC", "8700", "SILLAC", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Furniture[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
    
    public String White()
    {
        String _White[][] = {
                                    {"Sabana Disney Modelo OIINNF", "500", "OIINNF", " "},//i = 0
                                    {"Cortina blanquillas Modelo CORBL", "450", "CORBL", ""}, //i = 1
                                    {"Colcha El valiente Modelo WEFF", "310", "WEFF", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_White[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
 
    public String Home()
    {
        String _Home[][] = {
                                    {"Bote basura Chango Modelo HX5", "845", "HX5", ""},//i = 0
                                    {"Plumero plumas Modelo SZ12", "322", "SZ12", ""}, //i = 1
                                    {"Trapeador 2000 Modelo GASE", "123", "GASE", "  "}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Home[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
    public String DiscMovies()
    {
        String _DiscMovies[][] = {
                                    {"Conde Patula", "155", "ASDNE", ""},//i = 0
                                    {"Iron Man", "99", "VESAA", ""}, //i = 1
                                    {"EL Aro", "153", "FESAA", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_DiscMovies[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
   
    public String Books()
    {
        String _Books[][] = {
                                    {"Narnia", "80", "AFBA", ""},//i = 0
                                    {"Un mundo feliz ", "655", "SADFA", ""}, //i = 1
                                    {"Harry Potter ", "344", "HP001", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Books[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
    
    public String Ferretera()
    {
        String _Ferretera[][] = {
                                    {"Clavos Nilon tamaño 1in", "1", "CLIN1", ""},//i = 0
                                    {"Cable para soldar tamaño 1mt", "CS1MT", "7", ""}, //i = 1
                                    {"Desarmador acme Modelo 12DSFA", "1211", "12DSFA", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Ferretera[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
     
    public String Lotions()
    {
        String _Lotions[][] = {
                                    {"Black Posion Modelo H3454", "850", "H3454", ""},//i = 0
                                    {"Paris Hilton Modelo S32KM", "2300", "S32KM", ""}, //i = 1
                                    {"Chanel Modelo AFAFF ", "5000", "AFAFF", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Lotions[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
      
    public String Pharmacy()
    {
        String _Pharmacy[][] = {
                                    {"Aspirnas Modelo SASG5", "113", "SASG5", ""},//i = 0
                                    {"Peptovismol Modelo VASSD", "110", "VASSD", ""}, //i = 1
                                    {"Genoprasol Modelo DFSDF", "23", "DFSDF", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Pharmacy[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
       
    public String Stationary()
    {
        String _Stationary[][] = {
                                    {"Papel Barato Modelo PPBLC", "123", "PPBLC", ""},//i = 0
                                    {"Plastilina Playdoll Modelo DSFD2", "124", "DSFD2", ""}, //i = 1
                                    {"Pincelin Acuarela Modelo SDFR", "11", "SDFR", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Stationary[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }

    public String Garden()
    {
        String _Garden[][] = {
                                    {"Arbol Guayabo", "144", "GUAY", ""},//i = 0
                                    {"Tijeras Cortlin Modelo SASD1", "322", "SASD1", ""}, //i = 1
                                    {"Fuente Canario Modelo HTR1", "1211", "HTR1", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Garden[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
         
         
    public String Toys()
    {
        String _Toys[][] = {
                                    {"Carrito Hotwheels Modelo MRZ1", "331", "MRZ1", ""},//i = 0
                                    {"Scrabble Matel Modelo SSDF2", "123", "SSDF2", ""}, //i = 1
                                    {"4EnLinea Matel Modelo 1SDF0", "111", "1SDF0", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Toys[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
          
    public String Sports()
    {
        String _Sports[][] = {
                                    {"Bat de baseball Modelo ASD5", "300", "ASD5", ""},//i = 0
                                    {"Balon adidas Modelo ARF22", "500", "ARF22", ""}, //i = 1
                                    {"Guantes Fuerte Modelo TERF", "120", "TERF", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Sports[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
           
    public String Gifts()
    {
        String _Gifts[][] = {
                                    {"Bola de nieve globo Modelo BLA5", "120", "BLA5", ""},//i = 0
                                    {"Anillo Acme Modelo AACM", "110", "AACM", ""}, //i = 1
                                    {"Oso teddy Modelo TDBR", "600", "TDBR", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Gifts[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
            
    public String Cloth()
    {
        String _Cloth[][] = {
                                    {"Camisa Tommy  Modelo HXBJ5", "500", "HXBJ5", ""},//i = 0
                                    {"Pantalon Lacosste Modelo SLLK", "4500", "SLLK", ""}, //i = 1
                                    {"Chamarra DC Modelo PINEO", "1130", "PINEO", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Cloth[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
             
    public String Fruits()
    {
        String _Fruits[][] = {
                                    {"Manzanas Granja Modelo GESA", "232", "GESA", ""},//i = 0
                                    {"Brocolis Verde Modelo 1EE2", "123", "1EE2", ""}, //i = 1
                                    {"Aguacate Uruapan Modelo 15SD", "151", "15SD", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Fruits[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
              
    public String Fish()
    {
        String _Fish[][] = {
                                    {"Tsurimi Tsunami Modelo TTSM", "12", "TTSM", ""},//i = 0
                                    {"Almeja Laperla Modelo SLLR", "31", "SLLR", ""}, //i = 1
                                    {"Camaron enano Modelo FEA0", "43", "FEA0", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Fish[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
               
    public String Meat()
    {
        String _Meat[][] = {
                                    {"Barbacoa De Vaca Modelo CAPRI", "124", "CAPRI", ""},//i = 0
                                    {"Chuleta Puerco Modelo SASD", "53", "SASD", ""}, //i = 1
                                    {"Salchichas Puerco Modelo PAVO", "22", "PAVO", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Meat[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
                
    public String Salch()
    {
        String _Salch[][] = {
                                    {"Jamon de Cerdo Modelo CAPN", "144", "CAPN", ""},//i = 0
                                    {"Mortadela de Cerdo Modelo SLGD", "57", "SLGD", ""}, //i = 1
                                    {"Chorizo de Pavo Modelo PVJG", "72", "PVJG", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Salch[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
                
    public String Breat()
    {
        String _Breat[][] = {
                                    {"Pastelitos Pinguinos Modelo PING", "32", "PING", ""},//i = 0
                                    {"Muffins Cupcake Modelo MUFF", "21", "MUFF", ""}, //i = 1
                                    {"Bolillo-Telera Modelo TELRA", "54", "TELRA", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Breat[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
                 
    public String Masa()
    {
        String _Masa[][] = {
                                    {"Tortilla Maiz Clave HXAS", "12", "HXAS", ""},//i = 0
                                    {"Tortilla Harina Trigo Clave TRTR ", "33", "HXAS", ""}, //i = 1
                                    {"Tortilla Nopal Clave TRNP ", "11", "TRNP", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Masa[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
                  
 
    public String Chesse()
    {
        String _Chesse[][] = {
                                    {"Queso Chedar Modelo HSDH", "23", "HSDH", ""},//i = 0
                                    {"Crema LALA Modelo SDSF", "45", "SDSF", ""}, //i = 1
                                    {"Queso de puerco Modelo QUEP", "11", "QUEP", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Chesse[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }

    public String Milk()
    {
        String _Milk[][] = {
                                    {"Leche LALA", "12", "LELA", ""},//i = 0
                                    {"Leche en polvo Nido", "210", "LENI", ""}, //i = 1
                                    {"NUTRILECHE Form Lac", "11", "NUTR", ""}, //i = 2
                                  };
        String cad="";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cad+=_Milk[i][j]+"     ";
            cad+="\n";
        }
        return cad;
    }
 
}
