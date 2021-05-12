package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private String nombre;
    public static List<Libro> librolist = new ArrayList<>();
    public static List<String> listadoISBN = new ArrayList<>();
    public static List<String> listadoTitulos = new ArrayList<>();
    private List<String> personal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        int nom = 0;
        while (nom < 1) {
            if (nombre.matches("^[A-Z].{0,99}$")) {
                this.nombre = nombre;
                nom += 1;
            } else {
                System.out.println("El nombre no se ha introducido correctamente. Vuelve a intentarlo. ");
                Scanner scannombre = new Scanner(System.in);
                nombre = scannombre.nextLine();
            }
        }
    }

    public static List<Libro> getLibrolist() {
        return librolist;
    }

    public static void setLibrolist(List<Libro> librolist) {
        Biblioteca.librolist = librolist;
    }

    public static List<String> getListadoISBN() {
        return listadoISBN;
    }

    public static void setListadoISBN(List<String> listadoISBN) {
        Biblioteca.listadoISBN = listadoISBN;
    }

    public static List<String> getListadoTitulos() {
        return listadoTitulos;
    }

    public static void setListadoTitulos(List<String> listadoTitulos) {
        Biblioteca.listadoTitulos = listadoTitulos;
    }

    public List<String> getPersonal() {
        return personal;
    }

    public void setPersonal(List<String> personal) {
        this.personal = personal;
    }

    public Biblioteca() {

    }

    public Biblioteca(String nombre, List<String> personal) {
        this.nombre = nombre;
        this.personal = personal;
    }

    public Biblioteca(Biblioteca biblioteca) {
        this.nombre = biblioteca.nombre;
        this.personal = biblioteca.personal;
    }

    public static void main(String[] args) {
        //Antes de empezar entrar en la biblioteca habra que crearla
        // por eso el usuario tiene que crear una biblioteca y acto seguido podrá entrar
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("Proyecto Biblioteca. Antes de nada, vamos a crear una biblioteca.");
        System.out.println("Escribe el nombre de la biblioteca (debe empezar en mayúscula): ");
        Scanner scannombre = new Scanner(System.in);
        String nombre = scannombre.nextLine();
        biblioteca.setNombre(nombre);
        System.out.println("Biblioteca creada");
        System.out.println("Bienvenido a nuestra Biblioteca Virtual: " + biblioteca.getNombre() + ".");
        mostrarMenu();
        menu();
    }


    public static void mostrarMenu() {

        //Creamos el menú principal del programa desde el cual el Usuario va interactuar
        // para poder realizar todas las funciones de la biblioteca
        System.out.println("");
        System.out.println("-----------------MENU--------------");
        System.out.println("1. Buscar Libro");
        System.out.println("2. Personal biblioteca");
        System.out.println("3. Reservas");
        System.out.println("4. Gesionar Libros");
        System.out.println("5. Mostrar listado de libros");
        System.out.println("6 Añade un libro por defecto (Método auxiliar para probar cosas más rápido)");
        System.out.println("0. Salir");
        System.out.println("-------------------------------------");
        System.out.println("**********Elige una Opción***********");
    }

    public static void menu() {
        Scanner menuScan = new Scanner(System.in);
        Integer menu = menuScan.nextInt();


        //Creamos un while para que una vez finalizada una opcion vuelva a salir el menú
        //El switch lo creamos para dividir las diferentes acciones que puede realizar el Usuario
        while (menu != -1) {
            switch (menu) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("1.Por titulo");
                    System.out.println("2.Por ISBN");
                    System.out.println("0. Salir");

                    Scanner menubusqueda = new Scanner(System.in);
                    Integer busquedaLibro = menubusqueda.nextInt();
                    if (busquedaLibro == 1) {
                        Libro.buscarLibroTitulo();
                    } else if (busquedaLibro == 2) {
                        Libro.buscarLibroISBN();
                    }

                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

                case 2:
                    System.out.println("Elige opción: ");
                    System.out.println("1.Darse de Alta");
                    System.out.println("2.Registrarse");
                    System.out.println("3.Cambiar Contraseña");
                    System.out.println("0. Salir");

                    Scanner gestiones = new Scanner(System.in);
                    Integer hacergestiones = gestiones.nextInt();
                    if (hacergestiones == 1) {
                        Persona.solicitarDatosPersona();
                    }
                    if (hacergestiones == 2) {
                        Usuario.registrarse();
                    }
                    if (hacergestiones == 3) {
                        Usuario.cambioContraseña();
                    }

                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

                case 3:
                    Usuario.login();
                    System.out.println("1.Reservar Libro");
                    System.out.println("2.Devolver Libro");
                    System.out.println("0. Salir");
                    Scanner reservas = new Scanner(System.in);
                    Integer reservaLibro = reservas.nextInt();

                    if (reservaLibro == 1) {
                        System.out.println("Lista de libros");
                        imprimirLibros();
                        System.out.print("Introduce el ISBN del libro a reservar: ");
                        Scanner libreserva = new Scanner(System.in);
                        String isbn = libreserva.nextLine();
                        Reserva.reservarLibro(isbn);
                    } else if (reservaLibro == 2) {
                        System.out.print("Introduce el ISBN del libro a devolver: ");
                        Scanner libreserva = new Scanner(System.in);
                        String isbn = libreserva.nextLine();
                        Reserva.devolverLibro(isbn);
                    } else {
                        System.out.println("No se ha marcado ninguna opción correcta. Volviendo al menú principal.");
                    }

                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

                case 4:
                    System.out.println("1.Añadir libro");
                    System.out.println("2.Eliminar libro");
                    System.out.println("3.Añadir copias");
                    Scanner librosSc = new Scanner(System.in);
                    Integer libros = librosSc.nextInt();
                    if (libros ==1) {
                        Libro.añadirLibro();
                        mostrarMenu();
                        menu = menuScan.nextInt();
                    }
                    if (libros ==2) {
                        Libro.eliminarLibro();
                        mostrarMenu();
                        menu = menuScan.nextInt();
                    }
                    else if (libros ==3){
                        Reserva.añadirLibroCopia();
                    }
                    break;
                case 5:
                    imprimirLibros();
                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

                case 6:
                    Libro.ponerLibrosPorDefecto();
                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

                default:
                    System.out.println("No existe esa opcion");
                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

            }
        }
    }
    public static void imprimirLibros() {
        //Nos imprime todos los libros que hay en la bilbioteca y las copias que hay de cada uno y cuantas hay de disponibles
        System.out.println("Estos son todos los libros que tenemos registrados: ");
        System.out.println(getLibrolist());
    }

}
