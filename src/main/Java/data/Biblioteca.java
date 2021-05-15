package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private String nombre;
    private static List<Libro> librolist = new ArrayList<>();
    private List<Persona> personal;

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

    public List<Persona> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Persona> personal) {
        this.personal = personal;
    }

    public Biblioteca() {

    }

    public Biblioteca(String nombre, List<Persona> personal) {
        this.nombre = nombre;
        this.personal = personal;
    }

    public Biblioteca(Biblioteca biblioteca) {
        this.nombre = biblioteca.nombre;
        this.personal = biblioteca.personal;
    }

    public static void main(String[] args) {
        // El usuario tiene que crear una biblioteca y acto seguido podrá inteactuar con ella
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
        /* Creamos el menú principal del programa desde el cual el Usuario va a interactuar
        para poder realizar todas las funciones de la biblioteca */
        System.out.println("");
        System.out.println("-----------------MENU--------------");
        System.out.println("1. Buscar Libro");
        System.out.println("2. Personal biblioteca");
        System.out.println("3. Reservas");
        System.out.println("4. Gestionar Libros");
        System.out.println("5. Mostrar listado de libros");
        System.out.println("6. Añade libros por defecto (Método auxiliar para probar cosas más rápido)");
        System.out.println("0. Salir");
        System.out.println("-------------------------------------");
        System.out.println("**********Elige una Opción***********");
    }

    public static void menu() {
        Scanner menuScan = new Scanner(System.in);
        Integer menu = menuScan.nextInt();

        /* Creamos un while para que una vez finalizada una opción vuelva a salir el menú
        El switch lo creamos para dividir las diferentes acciones que puede realizar el Usuario */
        while (menu != -1) {
            switch (menu) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    System.out.println("1. Por titulo");
                    System.out.println("2. Por ISBN");
                    System.out.println("0. Salir");
                    Scanner menubusqueda = new Scanner(System.in);
                    Integer busquedaLibro = menubusqueda.nextInt();
                    if (busquedaLibro == 1) {
                        System.out.print("Introduce el título del libro para buscarlo: ");
                        Scanner libquery = new Scanner(System.in);
                        String titulo = libquery.nextLine();
                        Libro.buscarLibroTitulo(titulo);
                    } else if (busquedaLibro == 2) {
                        System.out.print("Introduce el ISBN del libro para buscarlo: ");
                        Scanner libquery = new Scanner(System.in);
                        String isbn = libquery.nextLine();
                        Libro.buscarLibroISBN(isbn);
                    }

                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

                case 2:
                    System.out.println("Elige opción: ");
                    System.out.println("1. Darse de Alta");
                    System.out.println("2. Registrarse");
                    System.out.println("3. Cambiar Contraseña");
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
                    System.out.println("1. Reservar Libro");
                    System.out.println("2. Devolver Libro");
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
                    System.out.println("1. Añadir libro");
                    System.out.println("2. Eliminar libro");
                    System.out.println("3. Añadir copias");
                    Scanner librosSc = new Scanner(System.in);
                    Integer libros = librosSc.nextInt();
                    if (libros == 1) {
                        Libro.añadirLibro();
                        mostrarMenu();
                        menu = menuScan.nextInt();
                    } else if (libros == 2) {
                        System.out.print("Introduce el ISBN del libro a eliminar: ");
                        Scanner libelimina = new Scanner(System.in);
                        String isbn = libelimina.nextLine();
                        Libro.eliminarLibro(isbn);
                        mostrarMenu();
                        menu = menuScan.nextInt();
                    } else if (libros == 3) {
                        System.out.print("Introduce el ISBN del libro original: ");
                        Scanner librocopia = new Scanner(System.in);
                        String isbn = librocopia.nextLine();
                        Reserva.añadirLibroCopia(isbn);
                        mostrarMenu();
                        menu = menuScan.nextInt();
                    }
                    break;

                case 5:
                    System.out.println("1. Lista de libros completa");
                    System.out.println("2. Libros disponibles");
                    Scanner listado = new Scanner(System.in);
                    Integer listados = listado.nextInt();
                    if (listados == 1) {
                        imprimirLibros();
                        mostrarMenu();
                        menu = menuScan.nextInt();
                    } else if (listados == 2){
                        imprimirLibrosDisponibles();
                        mostrarMenu();
                        menu = menuScan.nextInt();
                    }
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
        // Imprime todos los libros que hay en la biblioteca y las copias totales y disponibles que hay de cada uno
        if (Libro.contadorLibros() < 1){
            System.out.println("No hay libros que mostrar, añade libros a la biblioteca y vuelve a intentarlo.");
        } else {
            System.out.println("Estos son todos los libros que tenemos registrados: ");
            System.out.println(getLibrolist());
            if (Libro.contadorLibros() == 1){
                System.out.println("Hay 1 libro en la biblioteca");
            } else {
                System.out.println("Hay " + Libro.contadorLibros() + " libros distintos en la biblioteca.");
            }
        }
    }

    public static void imprimirLibrosDisponibles(){
        for (int i = 0; i < Biblioteca.getLibrolist().size(); i++) {
            if (Biblioteca.getLibrolist().get(i).getnCopiasDisponibles() > 0) {
                System.out.print("Libro disponible: " + Biblioteca.getLibrolist().get(i));
            }
        }
    }
}
