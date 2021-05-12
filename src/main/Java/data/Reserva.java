package data;

import java.util.Date;
import java.util.Scanner;

public class Reserva {
    private Libro libro;
    private Date fecha_reserva;

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Reserva(){

    }

    public Reserva(Libro libro, Date fecha_reserva) {
        this.libro = libro;
        this.fecha_reserva = fecha_reserva;
    }

    public Reserva(Reserva reserva){
        this.libro = reserva.libro;
        this.fecha_reserva = reserva.fecha_reserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "libro=" + libro +
                ", fecha_reserva=" + fecha_reserva +
                '}';
    }

    public static   void reservarLibro(String isbn){


        //El usuario nos mete sus datos  para poder reservar un libro i se llama al meto para realizar la reserva
        System.out.println("Reserva de libro. Introduce los datos: ");
        if (Libro.libroReservado(isbn)){
            System.out.println("Se ha reservado el libro. Revisa la lista de libros para ver las copias que quedan.");
        } else {
            System.out.println("No se pudo reservar el libro porque ya no quedan copias disponibles.");
        }
    }

    public static void devolverLibro(String isbn){
        //El usuario nos mete sus datos  para poder reservar un libro i se llama al meto para realizar la devolución

        System.out.println("Devolución de libro. Introduce los datos:");
        Libro.buscarLibroISBN();
        if (Libro.libroDevuelto(isbn)){
            System.out.println("Se ha devuelto el libro a la biblioteca.");
        } else {
            System.out.println("No es posible devolver el libro porque no se ha reservado primero.");
        }
    }

    public static void añadirLibroCopia(){
        Libro libro = new Libro();
        System.out.println("Escribe el ISBN");
        Scanner scanner = new Scanner(System.in);
        String busquedaLibroISBN = scanner.nextLine();
        for (int i = 0; i < Biblioteca.listadoISBN.size(); i++) {
            // Recorrer el listado de ISBNs para encontrar el que solicita el usuario
            if (busquedaLibroISBN.equals(Biblioteca.listadoISBN.get(i))) {
                System.out.println("Cuantas copias quieres añadir");
                Scanner añadirCopiassc = new Scanner(System.in);
                Integer añadirCopias =añadirCopiassc.nextInt();
                if (libro.getNum_copias_disponibles() > 0) {
                    libro.setNum_copias_disponibles(libro.getNum_copias_disponibles()+añadirCopias);
                    libro.setNum_copias(libro.getNum_copias()+añadirCopias);
                }

                //Si algun ISBN del listado de ISBN's es igual al introducido por el usuario en ese caso lo muestra por pantalla
                System.out.println("El libro está en la posición " + Biblioteca.listadoISBN.indexOf(busquedaLibroISBN));
                System.out.println("Información del libro que buscabas: " + Biblioteca.librolist.get(i));
                break;
            } else if (!busquedaLibroISBN.equals(Biblioteca.listadoISBN.get(i))){
                System.out.println(-1); // Si no encuentra el ISBN que se pide

            }
        }
    }

    }

