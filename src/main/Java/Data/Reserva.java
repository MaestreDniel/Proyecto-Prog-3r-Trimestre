package Data;

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

    public Reserva(Reserva reserva) {
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
        System.out.println("Introduce tu número de teléfono: ");
        Usuario usuario = new Usuario();
        Scanner telef = new Scanner(System.in);
        Integer telefono = telef.nextInt();
        usuario.setTelefono(telefono);

        System.out.println("Introduce tu email: ");
        Scanner mail = new Scanner(System.in);
        String email = mail.nextLine();
        usuario.setCorreo(email);

        //Finalmente reservamos el libro y el numero de copias de ese libro se resta en 1
        Libro libro = new Libro();
        Libro.buscarLibroISBN();


    }
    public static void devolverLibro(){
        //Para que se pueda devolver un libro el usuario tiene que introducir su telefono i su email
        System.out.println("Devolucion de libro. Introduce los datos: ");
        System.out.println("Introduce tu número de teléfono: ");
        Usuario usuario = new Usuario();
        Scanner telef = new Scanner(System.in);
        Integer telefono = telef.nextInt();
        usuario.setTelefono(telefono);

        System.out.println("Introduce tu email: ");
        Scanner mail = new Scanner(System.in);
        String email = mail.nextLine();
        usuario.setCorreo(email);

        //llamara a la clase añadir libro para asi las copias se sumen 1
        Libro libro = new Libro();
        Libro.añadirLibro();
    }


}

