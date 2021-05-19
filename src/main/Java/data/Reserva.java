package data;

import java.text.SimpleDateFormat;
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
        try {
            if (Libro.libroReservado(isbn)) {
                System.out.println("Se ha reservado el libro. Revisa la lista de libros para ver las copias que quedan.");
            } else {
                System.out.println("No se pudo reservar el libro porque ya no quedan copias disponibles.");
            }
        } catch (Exception E) {
            System.out.println("Error al intentar reservar libro. Es posible que no existiera ese libro.");
        }

    }

    public static void devolverLibro(String isbn) {
        // Funciona de manera análoga a reservarLibro
        try {
            if (Libro.libroDevuelto(isbn)) {
                System.out.println("Se ha devuelto el libro a la biblioteca, así que hay otra copia disponible del mismo.");
            } else {
                System.out.println("No es posible devolver el libro porque no se ha reservado primero.");
            }
        } catch (Exception E) {
            System.out.println("Error al intentar devolver libro. Es posible que no existiera ese libro.");
        }
    }

    public static Date determinarFecha(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        //System.out.println(formatter.format(date));
        return date;
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
            } else if (!Biblioteca.getLibrolist().get(i).getISBN().equals(isbn)) {
                i = i;
            } else {
                System.out.println("No hemos podido encontrar ese libro");
            }
        }
    }
}