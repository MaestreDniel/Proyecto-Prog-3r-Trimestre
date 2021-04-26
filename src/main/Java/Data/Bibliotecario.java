package Data;

import java.util.Scanner;

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

    public  Bibliotecario(Bibliotecario bibliotecario){
        this.trabajo = bibliotecario.trabajo;
        this.NIF_Bibliotecario = bibliotecario.NIF_Bibliotecario;
        this.contraseña_Bibliotecario = bibliotecario.NIF_Bibliotecario;
    }


    public Bibliotecario(String nombre, String apellido1, String apellido2, Integer edad, String trabajo, String NIF_Bibliotecario, String contraseña_Bibliotecario) {
        super(nombre, apellido1, apellido2, edad);
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

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "trabajo='" + trabajo + '\'' +
                ", NIF_Bibliotecario='" + NIF_Bibliotecario + '\'' +
                ", contraseña_Bibliotecario='" + contraseña_Bibliotecario + '\'' +
                '}';
    }

    //Aqui el usuario se registrará introduciendo su nif y la contraseña
    public static void login(){
        Bibliotecario bibliotecario = new Bibliotecario();
        System.out.println("Introduce el NIF");
        Scanner nif = new Scanner(System.in);
        String setnif = nif.nextLine();
        bibliotecario.setNIF_Bibliotecario(setnif);
        System.out.println("Introduce contraseña");
        Scanner pass = new Scanner(System.in);
        String password = pass.nextLine();
        bibliotecario.setNIF_Bibliotecario(password);
    }

}
