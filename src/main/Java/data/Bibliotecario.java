package data;

import java.util.Scanner;

public class Bibliotecario extends Persona {
    private String trabajo;
    private String NIF;
    private String contraseña;

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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Bibliotecario(){

    }

    public Bibliotecario(String trabajo, String NIF, String contraseña) {
        this.trabajo = trabajo;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }

    public Bibliotecario(String nombre, String apellido1, String apellido2, Integer edad, String trabajo, String NIF, String contraseña) {
        super(nombre, apellido1, apellido2, edad);
        this.trabajo = trabajo;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }

    public Bibliotecario(Persona persona, String trabajo, String NIF, String contraseña) {
        super(persona);
        this.trabajo = trabajo;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }

    public Bibliotecario(Bibliotecario bibliotecario) {
        this.trabajo = bibliotecario.trabajo;
        this.NIF = bibliotecario.NIF;
        this.contraseña = bibliotecario.contraseña;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "trabajo='" + trabajo + '\'' +
                ", NIF='" + NIF + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

    public static void login(){
        Bibliotecario bibliotecario = new Bibliotecario();
        System.out.println("---------Login---------");
        System.out.println("Introduce el NIF");
        Scanner nif = new Scanner(System.in);
        String setnif = nif.nextLine();
        bibliotecario.setNIF(setnif);
        System.out.println("Introduce contraseña");
        Scanner pass = new Scanner(System.in);
        String password = pass.nextLine();
        bibliotecario.setNIF(password);
    }

}