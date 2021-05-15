package data;

import java.util.Date;
import java.util.Scanner;

public class Reserva {
    private Libro libro;
    private Date fechaReserva;

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Reserva() {

    }

    public Reserva(Libro libro, Date fechaReserva) {
        this.libro = libro;
        this.fechaReserva = fechaReserva;
    }

    public Reserva(Reserva reserva) {
        this.libro = reserva.libro;
        this.fechaReserva = reserva.fechaReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "libro=" + libro +
                ", fechaReserva=" + fechaReserva +
                '}';
    }

    public static void reservarLibro(String isbn) {
        // El usuario nos mete sus datos para poder reservar un libro y se llama al método para realizar la reserva
        if (Libro.libroReservado(isbn)) {
            System.out.println("Se ha reservado el libro. Revisa la lista de libros para ver las copias que quedan.");
        } else {
            System.out.println("No se pudo reservar el libro porque ya no quedan copias disponibles.");
        }
    }

    public static void devolverLibro(String isbn) {
        // Funciona de manera análoga a reservarLibro
        if (Libro.libroDevuelto(isbn)) {
            System.out.println("Se ha devuelto el libro a la biblioteca, así que hay otra copia disponible del mismo.");
        } else {
            System.out.println("No es posible devolver el libro porque no se ha reservado primero.");
        }
    }

    public static void añadirLibroCopia(String isbn) {
        Libro libro = null;
        for (int i = 0; i < Biblioteca.getLibrolist().size(); i++) {
            if (Biblioteca.getLibrolist().get(i).getISBN().equals(isbn)) {
                libro = Biblioteca.getLibrolist().get(i);
                System.out.println("Cuantas copias quieres añadir?");
                Scanner añadirCopiassc = new Scanner(System.in);
                Integer añadirCopias = añadirCopiassc.nextInt();
                libro.setnCopiasDisponibles(libro.getnCopiasDisponibles() + añadirCopias);
                libro.setNCopias(libro.getNCopias() + añadirCopias);
                System.out.println("Copias añadidas. Así queda el libro: " + libro);
            } else if (!Biblioteca.getLibrolist().get(i).getISBN().equals(isbn)){
                i=i;
            } else {
                System.out.println("No hemos podido encontrar ese libro");
            }
        }
    }
}