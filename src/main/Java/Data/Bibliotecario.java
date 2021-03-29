package Data;

public class Bibliotecario extends Persona {
    private String trabajo;
    private String NIF_Bibliotecario;
    private String contraseña_Bibliotecario;

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getNIF_Bibliotecario() {
        return NIF_Bibliotecario;
    }

    public void setNIF_Bibliotecario(String NIF_Bibliotecario) {
        this.NIF_Bibliotecario = NIF_Bibliotecario;
    }

    public String getContraseña_Bibliotecario() {
        return contraseña_Bibliotecario;
    }

    public void setContraseña_Bibliotecario(String contraseña_Bibliotecario) {
        this.contraseña_Bibliotecario = contraseña_Bibliotecario;
    }

    public Bibliotecario(){

    }

    public Bibliotecario(String trabajo, String NIF_Bibliotecario, String contraseña_Bibliotecario) {
        this.trabajo = trabajo;
        this.NIF_Bibliotecario = NIF_Bibliotecario;
        this.contraseña_Bibliotecario = contraseña_Bibliotecario;
    }

    public Bibliotecario(String nombre, String apellido, String NIF, String contraseña, String trabajo, String NIF_Bibliotecario, String contraseña_Bibliotecario) {
        super(nombre, apellido, NIF, contraseña);
        this.trabajo = trabajo;
        this.NIF_Bibliotecario = NIF_Bibliotecario;
        this.contraseña_Bibliotecario = contraseña_Bibliotecario;
    }

    public Bibliotecario(Persona persona, String trabajo, String NIF_Bibliotecario, String contraseña_Bibliotecario) {
        super(persona);
        this.trabajo = trabajo;
        this.NIF_Bibliotecario = NIF_Bibliotecario;
        this.contraseña_Bibliotecario = contraseña_Bibliotecario;
    }

    public Bibliotecario(Bibliotecario bibliotecario){
        super(bibliotecario);
        this.trabajo = bibliotecario.trabajo;
        this.NIF_Bibliotecario = bibliotecario.NIF_Bibliotecario;
        this.contraseña_Bibliotecario = bibliotecario.contraseña_Bibliotecario;
    }

    @Override
    public String toString() {
        return "Biblotecario{" +
                "trabajo='" + trabajo + '\'' +
                ", NIF_Bibliotecario='" + NIF_Bibliotecario + '\'' +
                ", contraseña_Bibliotecario='" + contraseña_Bibliotecario + '\'' +
                '}';
    }
}
