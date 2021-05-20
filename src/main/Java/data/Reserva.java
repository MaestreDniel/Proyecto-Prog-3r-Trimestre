package data;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    // El usuario introduce sus datos para poder reservar un libro y se llama al método para realizar la reserva
    public static void reservarLibro(String isbn) {
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

    // Funciona de manera análoga a reservarLibro
    public static void devolverLibro(String isbn) {
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

    // Retorna la fecha en la cual se reservó un libro
    public static Date determinarFecha() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        //System.out.println(formatter.format(date));
        return date;
    }
}