package Test.ClasesTest;

public class PruebaClave {

    public enum SeguridadTIPO{
        BAJA, MEDIA, ALTA
    }

    public static SeguridadTIPO analisisClave(String password){
        int contador = password.length();

        if(contador <=8 ){
            return SeguridadTIPO.BAJA;
        }else if(contador <= 10){
            return SeguridadTIPO.MEDIA;
        }else{
            return SeguridadTIPO.ALTA;
        }
    }

    public static SeguridadTIPO analisisCadena(String password){

        //Creamos variables para contar Minusculas y Mayusculas
        int minusculas = 0;
        int mayusculas = 0;

        //BUCLE PARA RECORRER TODA LA PALABRA
        for(int i=0;i<password.length();i++){
            //Condición
            if(password.charAt(i) <= 'z' && password.charAt(i) >= 'a'){
                minusculas++;
            }
            else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                mayusculas++;
            }
        }

        int contador = minusculas + mayusculas;

        //Condición
        if(contador <= 8 ){
            return SeguridadTIPO.BAJA;
        }else if(contador <= 10){
            return SeguridadTIPO.MEDIA;
        }else{
            return SeguridadTIPO.ALTA;
        }
    }

    public static SeguridadTIPO analisisCadenas(String password){
        //Creamos variables para contar Minusculas y Mayusculas
        int minusculas = 0;
        int mayusculas = 0;
        int numeros = 0;

        //BUCLE PARA RECORRER TODA LA PALABRA
        for(int i=0;i<password.length();i++){
            //Condición
            if(password.charAt(i) <= 'z' && password.charAt(i) >= 'a'){
                minusculas++;
            }else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                mayusculas++;
            }else if(password.charAt(i) >= '0' && password.charAt(i) <= '9'){
                numeros++;
            }
        }

        int contador = minusculas + mayusculas + numeros;

        //Condición
        if(contador <= 8 ){
            return SeguridadTIPO.BAJA;
        }else if(contador <= 10){
            return SeguridadTIPO.MEDIA;
        }else{
            return SeguridadTIPO.ALTA;
        }

    }

    public static int Contador (String cadena){
        int c = cadena.length();
        return c;
    }



}
