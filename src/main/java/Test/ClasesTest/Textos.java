package Test.ClasesTest;

public class Textos {

    public static String reporte(String letra,int repetidor){
        String palabra = "";
        for (int i = 0; i < repetidor; i++) {
            palabra += letra;
        }
        return palabra;
    }

    public static int suma(int a, int b){
        int suma = a + b;
        return suma;
    }
}
