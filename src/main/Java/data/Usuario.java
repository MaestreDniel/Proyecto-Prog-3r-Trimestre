package data;

import java.util.List;
import java.util.Scanner;

public class Usuario extends Persona {
    private Integer telefono;
    private String direccion;
    private Integer codigo_postal;
    private String email;
    private List<String> reservas;

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(Integer codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getReservas() {
        return reservas;
    }

    public void setReservas(List<String> reservas) {
        this.reservas = reservas;
    }

    public Usuario(){

    }

    public Usuario(Integer telefono, String direccion, Integer codigo_postal, String email, List<String> reservas) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.email = email;
        this.reservas = reservas;
    }

    public Usuario(String nombre, String apellido1, String apellido2, Integer edad, Integer telefono, String direccion, Integer codigo_postal, String email, List<String> reservas) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.email = email;
        this.reservas = reservas;
    }

    public Usuario(Persona persona, Integer telefono, String direccion, Integer codigo_postal, String email, List<String> reservas) {
        super(persona);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.email = email;
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", codigo_postal=" + codigo_postal +
                ", email='" + email + '\'' +
                ", reservas=" + reservas +
                '}';
    }

    public static void solicitarDatosUsuario(){
        System.out.println("Escribe los datos: ");
        System.out.println("Nombre de usuario: ");
        Scanner usuario = new Scanner(System.in);
        String usuariosc = usuario.nextLine();
        System.out.println(usuariosc);

        System.out.println("Número de teléfono: ");
        Scanner telefono = new Scanner(System.in);
        String telefonosc = telefono.nextLine();
        System.out.println(telefonosc);

        System.out.println("Dirección: ");
        Scanner direccion = new Scanner(System.in);
        String direccionsc = direccion.nextLine();
        System.out.println(direccionsc);

        System.out.println("Código postal: ");
        Scanner codigopostal = new Scanner(System.in);
        String codigopostalsc = codigopostal.nextLine();
        System.out.println(codigopostalsc);

        System.out.println("Dirección email: ");
        Scanner email = new Scanner(System.in);
        String emailsc = email.nextLine();
        System.out.println(emailsc);

        /*Scanner reservas = new Scanner(System.in);
        String reservassc = reservas.nextLine();*/
        //System.out.println(reservassc);
    }
}
