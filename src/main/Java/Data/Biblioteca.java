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

   public void imprimirLibros(Libro libro){
       System.out.println(lista_libros);
   }
    public void imprimirLibrosDisponibles(Libro libro){
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("-----------------MENU--------------");
        System.out.println("1.Buscar Libro");
        System.out.println("2.Personal biblioteca");
        System.out.println("3. Reservas");
        Scanner menuScan = new Scanner(System.in);
        Integer menu = menuScan.nextInt();
        switch (menu){
            case 1:
                System.out.println("1.Por titulo");
                System.out.println("2.Por ISBN");
                Scanner menubusqueda = new Scanner(System.in);
                Integer busquedaLibro = menubusqueda.nextInt();
                if (busquedaLibro==1){
                    Libro libro = new Libro();
                    Libro.buscarISBN();
                }if(busquedaLibro==2){
                Libro libro = new Libro();
                Libro.buscarLibro();
            }
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("No existe esa opcion");
                break;

        }
    }

}
