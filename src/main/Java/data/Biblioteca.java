package data;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Biblioteca {
    private String nombre;
    private List<String> lista_libros;
    private List<String> personal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Scanner miScanner = new Scanner(System.in);
        Pattern patron = Pattern.compile("[A-Z]{1}+[A-Z-a-z]{1,100}");
        //System.out.print("Introduce: ");
        nombre = miScanner.nextLine();
        Matcher mat = patron.matcher(nombre);
        this.nombre = nombre;
        System.out.println(nombre);
    }

    public List<String> getLista_libros() {
        return lista_libros;
    }

    public void setLista_libros(List<String> lista_libros) {
        this.lista_libros = lista_libros;
    }

    public List<String> getPersonal() {
        return personal;
    }

    public void setPersonal(List<String> personal) {
        this.personal = personal;
    }

    public Biblioteca() {

    }

    public Biblioteca(String nombre, List<String> lista_libros, List<String> personal) {
        this.nombre = nombre;
        this.lista_libros = lista_libros;
        this.personal = personal;
    }

    public Biblioteca(Biblioteca biblioteca) {
        this.nombre = biblioteca.nombre;
        this.lista_libros = biblioteca.lista_libros;
        this.personal = biblioteca.personal;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", lista_libros=" + lista_libros +
                ", personal=" + personal +
                '}';
    }

    public void imprimirLibros(Libro libro) {
        //System.out.println(Libro.getLibroList());
    }

    public static void mostrarMenu() {
        System.out.println("");
        System.out.println("-----------------MENU--------------");
        System.out.println("1. Buscar Libro");
        System.out.println("2. Personal biblioteca");
        System.out.println("3. Reservas");
        System.out.println("4. Añadir Libro");
        System.out.println("5. Eliminar libro");
        System.out.println("0. Salir");
        System.out.println("-------------------------------------");
        System.out.println("**********Elige una Opción***********");
    }

    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestra Biblioteca Virtual");
        mostrarMenu();
        Scanner menuScan = new Scanner(System.in);
        Integer menu = menuScan.nextInt();

        while (menu != -1) {
            switch (menu) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("1.Por titulo");
                    System.out.println("2.Por ISBN");
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
                    System.out.println("1.Alta Biblitecario");
                    System.out.println("2.Alta Usuario");
                    Scanner gestiones = new Scanner(System.in);
                    Integer hacergestiones = gestiones.nextInt();
                    if (hacergestiones == 1) {
                        System.out.println("(Añadir método)");
                    }
                    if (hacergestiones == 2) {
                        Persona.solicitarDatosPersona();
                    } else {
                        System.out.println("Todavía no hago nada");
                    }
                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;
                case 3:
                    Bibliotecario.login();
                    System.out.println("1.Reservar Libro");
                    System.out.println("2.Devolver Libro");
                    Scanner reservas = new Scanner(System.in);
                    Integer reservaLibro = reservas.nextInt();
                    if (reservaLibro == 1) {
                        Reserva reserva = new Reserva();
                        Reserva.reservarLibro();
                        System.out.println("Libro reservado con exito");
                    }
                    if (reservaLibro == 2) {
                        Reserva reserva = new Reserva();
                        Reserva.devolverLibro();
                        System.out.println("El libro ha vuelto a la Biblioteca");
                    }
                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;
                case 4:
                    Libro.añadirLibro();
                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;
                case 5:
                    //Libro.eliminarLibro();
                    System.out.println("Todavía no hago nada");
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
}
