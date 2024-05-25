package zona_Fit.presentacion;

import zona_Fit.datos.ClienteDAO;
import zona_Fit.datos.IClienteDAO;
import zona_Fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }
    private static void zonaFitApp(){
        var salir = false;
        var consola = new Scanner(System.in);

        var clienteDao = new ClienteDAO();

        while (!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, clienteDao);

            }catch (Exception e){
                System.out.println("Error al ejecutar opciones: "+e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.println("|-----------------------------|\n"+
                           "|  SISTEMA ZONA FIT (GYM)🔱  |\n"+
                           "|-----------------------------|\n"+
                           "| [1] - Listar Cliente        |\n"+
                           "| [2] - Buscar Cliente        |\n"+
                           "| [3] - Agregar Cliente       |\n"+
                           "| [4] - Modificar Cliente     |\n"+
                           "| [5] - Eliminar Cliente      |\n"+
                           "| [6] - Salir del Sistema Fit |\n"+
                           "|-----------------------------|\n"+
                           "Seleccione una opción del menu");
        System.out.print("=> ");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner consola, int opciones, IClienteDAO clienteDAO){
        var salir = false;

        switch (opciones){
            case 1 -> {
                System.out.println("|-----------------------CLIENTES DE ZONA FIT GYM 🔱--------------------|");
                var clientes = clienteDAO.listarClientes();
                clientes.forEach(System.out::println);
                System.out.println("|----------------------------------------------------------------------|");
            }
            case 2 -> {
                System.out.print("| Ingrese el ID: [?] del cliente a buscar => ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                System.out.println((encontrado)?"Cliente encontrado: "+cliente:"Cliente no encontrado: "+cliente);
            }
            case 3 -> {
                System.out.println("|----REGISTRAR NUEVO CLIENTE----|");
                System.out.print("| Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("| Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("| Membresía: ");
                var membresia = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(nombre,apellido,membresia);
                var agregado = clienteDAO.agregarCliente(cliente);
                System.out.println((agregado)?"| Cliente agregado: "+cliente:"| Cliente no agregado: "+cliente);
            }
            case 4 -> {
                System.out.println("|----MODIFICAR DATO DEL CLIENTE----|");
                System.out.print("| ID Cliente: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                System.out.print("| Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("| Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("| Membresía: ");
                var membresia = Integer.parseInt(consola.nextLine());
                var clienteModificado = new Cliente(idCliente,nombre,apellido,membresia);
                var modificado = clienteDAO.modificarCliente(clienteModificado);
                System.out.println((modificado)?"| Cliente fue modificado: "+clienteModificado:"| Cliente no modificado: "+clienteModificado);
            }
            case 5 -> {
                System.out.println("|----ELIMINAR CLIENTE DE LA ZONA FIT GYM ----|");
                System.out.print("| ID Cliente: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var clienteEliminar = new Cliente(idCliente);
                var modificado = clienteDAO.eliminarCliente(clienteEliminar);
                System.out.println((modificado)?"| Cliente fue modificado: "+clienteEliminar:"| Cliente no modificado: "+clienteEliminar);
            }
            case 6 -> {
                System.out.println("|------GRACIAS POR USAR EL SISTEMA DE ZONA FIT GYM 🔱------|");
                return true;
            }
            default -> {
                System.out.println("Opción ingresada no reconocida dentro del menú: "+opciones);
            }
        }
        return salir;
    }

}
