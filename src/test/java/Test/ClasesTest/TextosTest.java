package Test.ClasesTest;

import org.junit.Assert;
import org.junit.Test;

import static Test.ClasesTest.Textos.*;

public class TextosTest {

    //Mediante la notación de [@TesT] podemos lograr que un método
    //nos sirva de prueba en vez de implementar la clase main
    @Test
    public void PruebaCadena (){
        Assert.assertEquals("HolaHolaHola", reporte("Hola",3));
        Assert.assertEquals("HolaHolaHola", reporte("Hola",1)); //en esta linea estara el error
        Assert.assertEquals("HolaHolaHola", reporte("Hola",-1)); //en esta linea estara el error

    }

    @Test
    public void PruevaNumeros(){
        Assert.assertEquals(10,suma(5,5));
        Assert.assertEquals(10,suma(4,5)); //enviamos una respuesta y se evalua que no corresponde por lo tanto esta mal
    }

    @Test
    public void ComprobarVerdad(){
        Assert.assertEquals(false,pregunta(5,5)); //no se lanza una ecepcion ya que la respuesta es falso
        Assert.assertEquals(false,pregunta(10,5)); // en este caso es verdadero pero la repsuesta indicada es falso por lo que se lanza una ecepción

    }

    /*public static void main(String[] args) {

        String cadena = reporte("Hola",3); // cambiar el numero para salir mensaje de error en tes
        System.out.println("cadena : " + cadena);
        VerificaResultado(cadena,"HolaHolaHola");
        /*if(cadena.equals("HolaHolaHola")){
            System.out.println("Todo salio bien");
        }else{
            //System.out.println("jajaja Fallo como tu relación");
            throw new RuntimeException("Error como tu relacion de de paso que");
        }

        //Dependencia que también es util parar ahorrar la importación
        //de objetos para realizar test de una clase
        Assert.assertEquals("HolaHolaHola", reporte("Hola",3));
        Assert.assertEquals("HolaHolaHola", reporte("Hola",2));

         
    }*/

    //Método llamado por la clase main para verificar una exepción manual
    private static void VerificaResultado(String cadena, String palabra) {
        if(cadena.equals(palabra)){
            System.out.println("Todo salio bien");
        }else{
            //System.out.println("jajaja Fallo como tu relación");
            throw new RuntimeException(cadena + " Error como tu relación no es igual a "+palabra);
        }
    }

}