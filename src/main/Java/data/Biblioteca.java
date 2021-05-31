package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Proyecto libre 3r trimestre en Java - Módulo de Programación (FP 1º DAW)
 *  Autores: Daniel Maestre Hermoso / Jeroni Mateo Curieses
 *  Fecha de presentación: 31/05/2021
 *  Versión: 1.0
 *
 *  Programa para gestionar los libros, las reservas, los usuarios y otros datos esenciales de una biblioteca.
 *  Hemos escrito el código de la manera más parecida posible a lo que se indicaba en el enunciado.
 */

public class Biblioteca {
    private String nombre;
    private static List<Libro> librolist = new ArrayList<>();
    private static List<Persona> personas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    // Este setter implementa el control del nombre de la biblioteca, que solo puede empezar con mayúscula
    public void setNombre(String nombre) {
        int nom = 0;
        while (nom < 1) {
            if (nombre.matches("^[A-Z].{0,99}$")) {
                this.nombre = nombre;
                nom += 1;
            } else {
                System.out.print("El nombre no se ha introducido correctamente. \nVuelve a intentarlo: ");
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

    public static List<Persona> getPersonas() {
        return personas;
    }

    public static void setPersonas(List<Persona> personas) {
        Biblioteca.personas = personas;
    }

    public Biblioteca() {

    }

    public Biblioteca(String nombre, List<Persona> personas) {
        this.nombre = nombre;
        Biblioteca.personas = personas;
    }

    public Biblioteca(Biblioteca biblioteca) {
        this.nombre = biblioteca.nombre;
    }

    // Aquí nace la biblioteca con la que se puede interactuar
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("Proyecto Biblioteca. Antes de nada, vamos a crear una biblioteca.");
        System.out.print("Escribe el nombre de la biblioteca (debe empezar en mayúscula): ");
        Scanner scannombre = new Scanner(System.in);
        String nombre = scannombre.nextLine();
        biblioteca.setNombre(nombre);
        System.out.println("Biblioteca creada");
        System.out.println("Bienvenido a nuestra Biblioteca Virtual: " + biblioteca.getNombre() + ".");
        mostrarMenu();
        menu();
    }

    /* Creamos el menú principal del programa con el cual el Usuario o Bibliotecario va a interactuar
    para poder realizar todas las funciones de la biblioteca */
    public static void mostrarMenu() {
        System.out.println("");
        System.out.println("-----------------MENU-----------------");
        System.out.println("1. Buscar libro");
        System.out.println("2. Gestiones de personal");
        System.out.println("3. Reservas y devoluciones");
        System.out.println("4. Gestionar libros");
        System.out.println("5. Mostrar listado de libros");
        System.out.println("6. Añadir datos por defecto");
        System.out.println("7. Mostrar inscritos");
        System.out.println("0. Salir");
        System.out.println("--------------------------------------");
        System.out.print("Elige una Opción: ");
    }

    public static void menu() {
        try {
            Scanner menuScan = new Scanner(System.in);
            Integer menu = menuScan.nextInt();

        /* Creamos un while para que, una vez finalizada una operación, vuelva a salir el menú
        El switch lo creamos para dividir las diferentes acciones que pueden realizar el Usuario o el Bibliotecario*/
            while (menu != -1) {
                switch (menu) {
                    case 0:
                        System.exit(0);
                        break;

                    case 1:
                        // Solo se puede acceder a este submenú registrando previamente algún libro
                        if (getLibrolist().isEmpty()) {
                            System.out.println("Para acceder a este menú es necesario tener registrado al menos algún libro.");
                            System.out.println("Instrucciones: ");
                            System.out.println("Debes añadir libros por defecto.\n" +
                                    "Lo podrás hacer en la opción 6 'Añade datos por defecto' y, dentro, elegir la opción 1 o la 4.");
                            System.out.println("También puedes añadir un libro de manera manual en la opción 4 'Gestionar Libros'\n" +
                                    "y, dentro, elegir la opción 1.");
                        } else {
                            System.out.println("-------Búsqueda de libro-------");
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
                        }
                        mostrarMenu();
                        menu = menuScan.nextInt();
                        break;

                    case 2:
                        // Solo se puede acceder a este submenú registrando previamente a alguien
                        if (Biblioteca.getPersonas().isEmpty()) {
                            System.out.println("Para acceder a este menú es necesario tener registrado al menos al bibliotecario fundador.");
                            System.out.println("Instrucciones: ");
                            System.out.println("Debes añadir al bibliotecario por defecto.\n" +
                                    "Lo podrás hacer en la opción 6 'Añade datos por defecto' y, dentro, elegir la opción 3 o la 4.");
                        } else {
                            System.out.println("-------Gestión del personal y usuarios-------");
                            System.out.println("1. Dar de alta a un usuario o bibliotecario");
                            System.out.println("2. Cambiar contraseña");
                            System.out.println("3. Login del bibliotecario");
                            System.out.println("0. Salir");
                            System.out.print("Elige opción: ");
                            Scanner gestiones = new Scanner(System.in);
                            Integer hacergestiones = gestiones.nextInt();

                            if (hacergestiones == 1) {
                                Persona.solicitarDatosPersona();
                            } else if (hacergestiones == 2) {
                                Bibliotecario.cambioContraseña();
                            } else if (hacergestiones == 3) {
                                System.out.println("Login del bibliotecario");
                                System.out.print("Introduce el NIF: ");
                                Scanner bibliot = new Scanner(System.in);
                                String NIF = bibliot.nextLine();
                                System.out.print("Introduce la contraseña: ");
                                String contraseña = bibliot.nextLine();
                                Bibliotecario.loginBibliotecario(NIF, contraseña);
                            }
                        }
                        mostrarMenu();
                        menu = menuScan.nextInt();
                        break;

                    case 3:
                        System.out.println("Comprobando que algún bibliotecario haya realizado login previamente...");
                        if (Biblioteca.getPersonas().size() > 0) {
                            if (Bibliotecario.asignarBibliotecario().isLogin()) {
                                System.out.println("-------Reservas y devoluciones-------");
                                System.out.println("El bibliotecario asignado es: " + Bibliotecario.asignarBibliotecario().getNIF());
                                System.out.println("------------------");
                                System.out.println("1. Reservar Libro");
                                System.out.println("2. Devolver Libro");
                                System.out.println("0. Salir");
                                System.out.print("Elige opción: ");
                                Scanner reservas = new Scanner(System.in);
                                Integer reservaLibro = reservas.nextInt();

                                if (reservaLibro == 1) {
                                    System.out.println("Lista de libros");
                                    imprimirLibros();
                                    System.out.print("Introduce el ISBN del libro a reservar: ");
                                    Scanner libreserva = new Scanner(System.in);
                                    String isbn = libreserva.nextLine();
                                    Libro libro = null; // Se determina el libro que se guardará en el historial de reservas del usuario
                                    for (int i = 0; i < Biblioteca.getLibrolist().size(); i++) {
                                        if (Biblioteca.getLibrolist().get(i).getISBN().equals(isbn)) {
                                            libro = Biblioteca.getLibrolist().get(i);
                                        }
                                    }
                                    System.out.println("Para reservar el libro, el usuario deberá introducir: ");
                                    System.out.print("Número de teléfono: ");
                                    Scanner user = new Scanner(System.in);
                                    String telefono = user.nextLine();
                                    System.out.print("Dirección de correo electrónico: ");
                                    String correo = user.nextLine();
                                    Usuario usuario = Usuario.loginUsuario(telefono, correo);
                                    if (usuario != null) { // Solo hace la reserva si el login ha sido correcto
                                        Reserva.reservarLibro(isbn);
                                        Reserva reserva = new Reserva();
                                        reserva.setLibro(libro);
                                        reserva.setFechaReserva(Reserva.determinarFecha());
                                        usuario.getListareservas().add(reserva);
                                    } else {
                                        System.out.println("Intenta hacer login de nuevo");
                                    }

                                } else if (reservaLibro == 2) {
                                    System.out.println("Para devolver el libro, el usuario deberá introducir: ");
                                    System.out.print("Número de teléfono: ");
                                    Scanner user = new Scanner(System.in);
                                    String telefono = user.nextLine();
                                    System.out.print("Dirección de correo electrónico: ");
                                    String correo = user.nextLine();
                                    Usuario usuario = Usuario.loginUsuario(telefono, correo);
                                    if (usuario != null) { // Solo hace la devolución si el login ha sido correcto
                                        System.out.print("Introduce el ISBN del libro a devolver: ");
                                        Scanner libreserva = new Scanner(System.in);
                                        String isbn = libreserva.nextLine();
                                        Reserva.devolverLibro(isbn);
                                    } else {
                                        System.out.println("Intenta hacer login de nuevo");
                                    }
                                }
                            } else {
                                System.out.println("Es necesario que un bibliotecario haga login primero. Volviendo al menú principal");
                            }
                        } else {
                            System.out.println("No se puede reservar porque no hay bibliotecarios ni usuarios. Introdúcelos.");
                        }
                        mostrarMenu();
                        menu = menuScan.nextInt();
                        break;

                    case 4:
                        System.out.println("-------Gestionar libros-------");
                        System.out.println("1. Añadir libro");
                        System.out.println("2. Eliminar libro");
                        System.out.println("3. Añadir copias");
                        System.out.print("Elige opción: ");
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
                            Libro.añadirCopias(isbn);
                            mostrarMenu();
                            menu = menuScan.nextInt();
                        }
                        break;

                    case 5:
                        System.out.println("-------Listados de libros-------");
                        System.out.println("1. Lista de libros completa");
                        System.out.println("2. Libros disponibles");
                        System.out.print("Elige opción: ");
                        Scanner listado = new Scanner(System.in);
                        Integer listados = listado.nextInt();
                        if (listados == 1) {
                            imprimirLibros();
                            mostrarMenu();
                            menu = menuScan.nextInt();
                        } else if (listados == 2) {
                            imprimirLibrosDisponibles();
                            mostrarMenu();
                            menu = menuScan.nextInt();
                        }
                        break;

                    case 6:
                        System.out.println("-------Añadir datos por defecto-------");
                        Libro.ponerDatosPorDefecto();
                        mostrarMenu();
                        menu = menuScan.nextInt();
                        break;

                    case 7:
                        System.out.println("¿Qué integrantes de la Biblioteca quieres consultar?");
                        System.out.println("1. Mostrar personal");
                        System.out.println("2. Mostrar usuarios inscritos");
                        System.out.print("Elige opción: ");
                        Scanner integrantes = new Scanner(System.in);
                        Integer integrantesSC = integrantes.nextInt();
                        if (integrantesSC == 1) {
                            Bibliotecario.mostrarBibliotecarios();
                        } else if (integrantesSC == 2) {
                            Usuario.mostrarUsuarios();
                        }
                        mostrarMenu();
                        menu = menuScan.nextInt();
                        break;

                    default:
                        System.out.println("No existe esa opción");
                        mostrarMenu();
                        menu = menuScan.nextInt();
                        break;
                }
            }
            // Evita que deje de funcionar la aplicación en caso de introducir mal la opción
        } catch (Exception e) {
            System.out.println("Error al introducir opción");
            mostrarMenu();
            menu();
        }

    }

    // Imprime todos los libros que hay en la biblioteca y las copias totales y disponibles que hay de cada uno
    public static void imprimirLibros() {
        if (Libro.contadorLibros() < 1) {
            System.out.println("No hay libros que mostrar, añade libros a la biblioteca y vuelve a intentarlo.");
        } else {
            System.out.println("Estos son todos los libros que tenemos registrados: ");
            System.out.println(getLibrolist());
            if (Libro.contadorLibros() == 1) {
                System.out.println("Hay 1 libro en la biblioteca");
            } else {
                System.out.println("Hay " + Libro.contadorLibros() + " libros distintos en la biblioteca.");
            }
        }
    }

    // Solo imprime los libros que hay disponibles para ser reservados
    public static void imprimirLibrosDisponibles() {
        System.out.println("Libros disponibles: ");
        for (int i = 0; i < Biblioteca.getLibrolist().size(); i++) {
            if (Biblioteca.getLibrolist().get(i).getnCopiasDisponibles() > 0) {
                System.out.print(Biblioteca.getLibrolist().get(i));
            }
        }
    }
}
