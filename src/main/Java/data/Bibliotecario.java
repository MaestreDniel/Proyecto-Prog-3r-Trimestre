package data;

public class Bibliotecario extends Persona {
    private String trabajo;
    private String NIF;
    private String contraseña_Bibliotecario;

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContraseña_Bibliotecario() {
        return contraseña_Bibliotecario;
    }

    public void setContraseña_Bibliotecario(String contraseña_Bibliotecario) {
        this.contraseña_Bibliotecario = contraseña_Bibliotecario;
    }

    public Bibliotecario() {

    }

    public Bibliotecario(String trabajo, String NIF, String contraseña_Bibliotecario) {
        this.trabajo = trabajo;
        this.NIF = NIF;
        this.contraseña_Bibliotecario = contraseña_Bibliotecario;
    }

    public Bibliotecario(Bibliotecario bibliotecario) {
        this.trabajo = bibliotecario.trabajo;
        this.NIF = bibliotecario.NIF;
        this.contraseña_Bibliotecario = bibliotecario.NIF;
    }


    public Bibliotecario(String nombre, String apellido1, String apellido2, Integer edad, String trabajo, String NIF, String contraseña_Bibliotecario) {
        super(nombre, apellido1, apellido2, edad);
        this.trabajo = trabajo;
        this.NIF = NIF;
        this.contraseña_Bibliotecario = contraseña_Bibliotecario;
    }

    public Bibliotecario(Persona persona, String trabajo, String NIF, String contraseña_Bibliotecario) {
        super(persona);
        this.trabajo = trabajo;
        this.NIF = NIF;
        this.contraseña_Bibliotecario = contraseña_Bibliotecario;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "trabajo='" + trabajo + '\'' +
                ", NIF_Bibliotecario='" + NIF + '\'' +
                ", contraseña_Bibliotecario='" + contraseña_Bibliotecario + '\'' +
                '}';
    }

}