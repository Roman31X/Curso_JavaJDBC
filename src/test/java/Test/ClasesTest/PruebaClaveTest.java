package Test.ClasesTest;

import org.junit.Test;

import static Test.ClasesTest.PruebaClave.SeguridadTIPO.*;
import static org.junit.Assert.*;

public class PruebaClaveTest {

    @Test
    public void ClaveBaja_8Caracteres() {
        assertEquals(BAJA,PruebaClave.analisisClave("12345678"));
    }

    @Test
    public void ClaveMedia_10Caracteres() {
        assertEquals(MEDIA,PruebaClave.analisisClave("123456789"));
    }

    @Test
    public void ClaveAlta_15Carcteres() {
        assertEquals(ALTA,PruebaClave.analisisClave("1234567892222"));
    }

    @Test
    public void ClaveContador_Carcteres() {
        assertEquals(8,PruebaClave.Contador("12345678"));
    }

    @Test
    public void Clave_con_Minusculas_y_Mayusculas() {
        assertEquals(BAJA,PruebaClave.analisisCadena("HolaMund"));
        assertEquals(MEDIA,PruebaClave.analisisCadena("HOLAmundo"));
        assertEquals(ALTA,PruebaClave.analisisCadena("HoLaMuNdOgItHuB"));

    }

    @Test
    public void Clave_con_Minusculas_Mayudculas_Numeros() {
        assertEquals(BAJA,PruebaClave.analisisCadenas("H0la1und"));
        assertEquals(MEDIA,PruebaClave.analisisCadenas("H4la7und04"));
        assertEquals(ALTA,PruebaClave.analisisCadenas("Hol3Mund4518"));

    }
}