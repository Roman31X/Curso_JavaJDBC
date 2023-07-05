
package Manejo_JDBC.test;

import Manejo_JDBC.Coneccion_Mysql.PersonaDAO;
import Manejo_JDBC.domin.Persona;

import java.util.List;

public class TestManejoPersona {
    public static void main(String[] args) {
        /**VER REGISTRO DE L ABASE DE DATOS*/
        //SENTENCIA PARA RECPCION DE PERSONADAO
        PersonaDAO personaDao =new PersonaDAO();
        /*FUNCIÓN LAMBDA
        listaPersonas.forEach(persona -> {
            System.out.println("Persona : " + listaPersonas);
        });*/

        /**AGREGAR UN NUEVO DATO A LA BASE DE DATOS*/
        //CREMAOS UN NUEVO OBJETO DE TIPO PERSONA
        Persona persona = new Persona("Camila","Loza","Loza@gmail.com","985154124");
        personaDao.insertar(persona);

        //AGREGAMOS LA INFORMACION DEL OBJETO PERSONADAO
        //List<Persona> listaPersonas  = personaDao.seleccionar();
        //CICLO FORIACH PARA ITERR LA INFORMACION DE LA LISTA
        /*for(Persona personas : listaPersonas){
            System.out.println("Persona : " + personas);
        }*/
        System.out.println();
        /**ACTUALIZAR UN DATO EN EL REGISTRO*/
        /*Persona personaUPDATE = new Persona(4,"Renne","Magallanes","rene.ma25@gmail.com","923788052");
        personaDao.actualizar(personaUPDATE);
        List<Persona> listaPersonas  = personaDao.seleccionar();
        for(Persona persona : listaPersonas){
            System.out.println("Persona : " + persona);
        }
        */
        /**ELIMINAR UN DATO EN EL REGISTRO
        Persona personaDELE = new Persona(9);
        personaDao.eliminar(personaDELE);
        //AGREGAMOS LA INFORMACION DEL OBJETO PERSONADAO
        List<Persona> listaPersonas  = personaDao.seleccionar();
        for(Persona persona : listaPersonas){
            System.out.println("Persona : " + persona);
        }*/

    }
}
