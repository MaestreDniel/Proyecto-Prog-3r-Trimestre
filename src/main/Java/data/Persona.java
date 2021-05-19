package data;

import java.util.Scanner;

public abstract class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Integer edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Persona() {

    }

    public Persona(String nombre, String apellido1, String apellido2, Integer edad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }

    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.apellido1 = persona.apellido1;
        this.apellido2 = persona.apellido2;
        this.edad = persona.edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", edad=" + edad +
                '}';
    }

    //Creamos esta clase para que se soliciten todos los datos del usuario para poder darse de alta
    public static void solicitarDatosPersona() {
        try {
            System.out.println("1. Alta a un Usuario");
            System.out.println("2. Alta a un Bibliotecario");
            Scanner dato = new Scanner(System.in);
            Integer datosPersonasc = dato.nextInt();

            System.out.println("Escribe los datos: ");
            System.out.print("Introduce tu nombre: ");
            Scanner datos = new Scanner(System.in);
            String nombre = datos.nextLine();

            System.out.print("1er apellido: ");
            String apellido1 = datos.nextLine();

            System.out.print("2do apellido: ");
            String apellido2 = datos.nextLine();

            System.out.print("Introduce tu edad: ");
            Integer edad = datos.nextInt();

            if (datosPersonasc == 1) {
                Usuario.solicitarDatosPersona(nombre, apellido1, apellido2, edad);
            } else if (datosPersonasc == 2) {
                Bibliotecario.solicitarDatosPersona(nombre, apellido1, apellido2, edad);
            }
        } catch (Exception E) {
            System.out.println("Error al introducir algún dato.");
        }
    }
}
