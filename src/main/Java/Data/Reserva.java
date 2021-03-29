package Data;

import java.util.Date;

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
}

