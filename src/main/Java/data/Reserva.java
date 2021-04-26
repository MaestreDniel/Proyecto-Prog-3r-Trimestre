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
        System.out.println("Reserva de libro. Introduce los datos: ");
        System.out.println("Introduce tu número de teléfono: ");
        Usuario usuario = new Usuario();
        Scanner telef = new Scanner(System.in);
        Integer telefono = telef.nextInt();
        usuario.setTelefono(telefono);
        System.out.println("Introduce tu email: ");
        Scanner mail = new Scanner(System.in);
        String email = mail.nextLine();
        usuario.setEmail(email);
        Libro libro = new Libro();
        Libro.buscarLibroISBN();
    }
    public static void devolverLibro(){
        System.out.println("Devolución de libro. Introduce los datos:");
        System.out.println("Introduce tu número de teléfono: ");
        Usuario usuario = new Usuario();
        Scanner telef = new Scanner(System.in);
        Integer telefono = telef.nextInt();
        usuario.setTelefono(telefono);
        System.out.println("Introduce tu email: ");
        Scanner mail = new Scanner(System.in);
        String email = mail.nextLine();
        usuario.setEmail(email);
        Libro libro = new Libro();
        Libro.buscarLibroISBN();
    }

    public static void añadirLibroCopia(){
        Libro libro = new Libro();

    }
}
