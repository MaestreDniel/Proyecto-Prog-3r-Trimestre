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

    public static void reservarLibro(){
        //El usuario nos mete los datos de su numero de telefono y email para poder reservar un libro
        System.out.println("Reserva de libro. Introduce los datos: ");
        //Usuario.login();
        Libro.buscarLibroISBN();
        //Finalmente reservamos el libro y el numero de copias de ese libro se resta en 1
        if (Libro.libroReservado()){
            System.out.println("Se ha reservado el libro. Revisa la lista de libros para ver las copias que quedan.");
        } else {
            System.out.println("No se pudo reservar el libro porque ya no quedan copias disponibles.");
        }
    }

    public static void devolverLibro(){
        System.out.println("Devolución de libro. Introduce los datos:");
        //Usuario.login();

        Libro libro = new Libro();
        Libro.buscarLibroISBN();
    }

    public static void añadirLibroCopia(){
        Libro libro = new Libro();

    }
}
