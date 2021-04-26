package Data;

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
        System.out.print(nombre);
        nombre = miScanner.nextLine();
        Matcher mat = patron.matcher(nombre);
        this.nombre = nombre;
        System.out.print(nombre);
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
        System.out.println();
    }

    public void imprimirLibrosDisponibles(Libro libro) {
        System.out.println();
    }


    public static void mostrarMenu() {
        /*
        * Creamos una clase para que salga el menú principal despues de haber finalizado cualquiera de las acciones que hay en el
        * Entonces en todos los casos serà llamado al final
        * */
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

        /*
        *A nuestra aplicacion no le puede faltar un menu principal donde realizar las diversas acciones que ofrece nuesta Biblioteca
         * */
        System.out.println("Bienvenido a nuestra Biblioteca Virtual");
        mostrarMenu();
        Scanner menuScan = new Scanner(System.in);
        Integer menu = menuScan.nextInt();

        //Creamo un while para que que mientras el usuario quiera realizar acciones pueda hacerlo
        while (menu != -1) {

            /*A continuación creamos un switch para poder llevar a cabo la opción del menu que ha elegido el usuario
            * Donde llamara a los metedos que le peretencen para realizar sus acciones una vez finalizada esas acciones
            * volvera a aparecer el menu principal para que pueda realizar otra opción*/
            switch (menu) {

                case 0:
                    //Si el usuario pulsa cero se cierra la aplicacion
                    System.exit(0);
                    break;

                case 1:
                     /*
                     *Si el usuario pulsa 1 puede elegir como buscar el libro si por ISBN o por Título
                     * Si es por Titulo llama al metodo buscarLibroTitulo()
                     * Si es por ISBN  llama al metodo buscarLibroISBN()
                     * */
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
                    /*
                    * Aqui nos metemos en la parte de Personal donde podemos dar de alta a un bibliotecario
                    * o Dar de alta a un Usuario

                    * */
                    System.out.println("Elige opción: ");
                    System.out.println("1.Alta Biblitecario");
                    System.out.println("2.Alta Usuario");
                    Scanner gestiones = new Scanner(System.in);
                    Integer hacergestiones = gestiones.nextInt();
                //Si queremos dar de alta a un Bibliotecario o a un Usuario solicitaremos sus datos Personales

                    if (hacergestiones == 1) {
                        Persona.solicitarDatosPersona();                    }
                    if (hacergestiones == 2) {
                        Persona.solicitarDatosPersona();
                    } else {
                        System.out.println("Todavía no hago nada");
                    }
                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

                case 3:
                    /*
                    * Para poder realizar una reserva el usuario tiene que hacer LOGIN
                    * Despues puede reservarlo y si ya lo ha reservado puede devolverlo
                    * */
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
                    /*
                    * Vamos a ampliar la biblioteca añadiendo libros nuevos,
                    * llamamos la metodo añadirLibro() y se añade un nuevo libro con sus copias
                    * */
                    Libro.añadirLibro();
                    System.out.println("Libro añadido");
                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

                case 5:
                    /*
                    * Como podemos añadir libros también existe la opción de elimiarlos
                    * llamando al metodo eliminarLibro()
                    * */
                    Libro.eliminarLibro();
                    System.out.println("Libro Eliminado");
                    mostrarMenu();
                    menu = menuScan.nextInt();
                    break;

                default:
                    //Si el usuario introduce una opción erronea salta el error con el siguiente mensaje
                    System.out.println("No existe esa opcion");
                    mostrarMenu();

                    menu = menuScan.nextInt();
                    break;
            }
        }
    }
}
