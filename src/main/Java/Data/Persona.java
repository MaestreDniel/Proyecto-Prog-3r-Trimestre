package Data;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona  {
    private String nombre;
    private String apellido;
    private String  NIF;
    private String contraseña;

    public Persona() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        Scanner scanner = new Scanner(System.in);
        Pattern pat = Pattern.compile("/^[^\\w]{8,20}$/");
        System.out.print(contraseña);
        contraseña = scanner.nextLine();
        Matcher mat = pat.matcher(contraseña);
        this.contraseña = contraseña;
    }

    public Persona(String nombre, String apellido, String NIF, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }

    public Persona(Persona persona){
        this.nombre = persona.nombre;
        this.apellido = persona.apellido;
        this.NIF = persona.NIF;
        this.contraseña = persona.contraseña;

    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", NIF=" + NIF +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
