package Test.ClasesTest;


import com.mysql.cj.util.StringUtils;

public class TextosTest {

    public static void main(String[] args) {

        String cadena = Textos.reporte("Hola",3);
        System.out.println("cadena : " + cadena);
        VerificaResultado(cadena,"HolaHolaHola");
        /*if(cadena.equals("HolaHolaHola")){
            System.out.println("Todo salio bien");
        }else{
            //System.out.println("jajaja Fallo como tu relación");
            throw new RuntimeException("Error como tu relacion de de paso que");
        }*/
         
    }

    private static void VerificaResultado(String cadena, String palabra) {
        if(cadena.equals(palabra)){
            System.out.println("Todo salio bien");
        }else{
            //System.out.println("jajaja Fallo como tu relación");
            throw new RuntimeException("Error como tu relación");
        }
    }

}