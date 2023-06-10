package LaboratorioJDBC.test;

import LaboratorioJDBC.datos.UsuarioJDBC;
import LaboratorioJDBC.domain.Usuario;

import java.util.List;

public class TestUsuario {
    public static void main(String[] args) {
        UsuarioJDBC usuariojdbc = new UsuarioJDBC();

        /**LISTADO DE USUARIO*/
        List<Usuario> listausuarios = usuariojdbc.select();
        for (Usuario usuario : listausuarios) {
            System.out.println("USUARIO : " + usuario);
        }
        System.out.println();/*
        /**AGREGAR UN NUEVO USUARIO
        Usuario nuevoUsuario = new Usuario("Dante","1254");
        usuariojdbc.insert(nuevoUsuario);
        List<Usuario> listados = usuariojdbc.select();
        for (Usuario usuario : listados) {
            System.out.println("USUARIO : " + usuario);
        }*/
        /*
        /**MODIFICAR DATOS EN LA BASE DE DATOS UPDATE
        Usuario updateusuario = new Usuario(2,"Daniel","1999");
        usuariojdbc.update(updateusuario);
        List<Usuario> listaupdate = usuariojdbc.select();
        for (Usuario usuario : listaupdate) {
            System.out.println("USUARIO : " + usuario);
        }*/
        /**ELIMINAR UN DATO DEL REGISTRO*/
        usuariojdbc.eliminar(new Usuario(3));
        List<Usuario> listaeliminar = usuariojdbc.select();
        for (Usuario usuario : listaeliminar) {
            System.out.println("USUARIO : " + usuario);
        }

    }
}
