package data;

import java.util.List;

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

    public Usuario(String nombre, String apellido, String NIF, String contraseña, Integer telefono, String direccion, Integer codigo_postal, String email, List<String> reservas) {
        super(nombre, apellido, NIF, contraseña);
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

    public Usuario(Usuario usuario){
        super(usuario);
        this.telefono = usuario.telefono;
        this.direccion = usuario.direccion;
        this.codigo_postal = usuario.codigo_postal;
        this.email = usuario.email;
        this.reservas = usuario.reservas;
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
}
