package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario extends Persona {

    private String telefono;
    private String direccion;
    private Integer codigo_postal;
    private String correo;
    private List<Reserva> listareservas = new ArrayList<>();

    public List<Reserva> getListareservas() {
        return listareservas;
    }

    public void setListareservas(List<Reserva> listareservas) {
        this.listareservas = listareservas;
    }

    @Override
    public String toString() {
        return "Usuario: {" +
                "nombre=" + getNombre() + '\'' +
                ", apellido1=" + getApellido1() + '\'' +
                ", apellido2=" + getApellido2() + '\'' +
                ", edad=" + getEdad() + '\'' +
                ", telefono=" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codigo postal=" + codigo_postal +
                ", correo='" + correo + '\'' +
                ", lista de reservas='" + listareservas + '\'' +
                "}" + "\n";
    } // En este caso se pide que imprima también los datos de la clase padre

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario() {

    }

    public Usuario(String nombre, String apellido1, String apellido2, Integer edad, String telefono, String direccion, Integer codigo_postal, String correo) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.correo = correo;
    }

    /*public Usuario(Persona persona, String telefono, String direccion, Integer codigo_postal, String correo) {
        super(persona);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.correo = correo;
    }*/

    public Usuario(Usuario usuario) {
        super(usuario);
        this.telefono = usuario.telefono;
        this.direccion = usuario.direccion;
        this.codigo_postal = usuario.codigo_postal;
        this.correo = usuario.correo;
    }

    //Aqui el Usuario rellenara todos sus datos personales
    public static void solicitarDatosPersona(String nombre, String apellido1, String apellido2, Integer edad) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido1(apellido1);
            usuario.setApellido2(apellido2);
            usuario.setEdad(edad);

            System.out.print("Número de teléfono: ");
            Scanner datos = new Scanner(System.in);
            String telefonosc = datos.nextLine();
            usuario.setTelefono(telefonosc);

            System.out.print("Dirección: ");
            String direccionsc = datos.nextLine();
            usuario.setDireccion(direccionsc);

            System.out.print("Código postal: ");
            Integer codigopostalsc = datos.nextInt();
            usuario.setCodigo_postal(codigopostalsc);

            System.out.print("Introduce tu correo: ");
            Scanner mail = new Scanner(System.in);
            String emailsc = mail.nextLine();
            usuario.setCorreo(emailsc);

            Biblioteca.getPersonas().add(usuario);
            System.out.println("Nuevo usuario añadido. Revisa la lista de usuarios inscritos.");

        } catch (Exception E) {
            System.out.println("Error al introducir algún dato.");
        }
    }

    public static void crearUsuariosPorDefecto() {
        Biblioteca.getPersonas().add(new Usuario
                ("Jeroni", "Mateo", "Curieses", 22, "9999", "casa", 777, "hola@hola"));
        System.out.println("Usuario por defecto añadido con éxito");
        Usuario.mostrarUsuarios();
    }

    public static Usuario asignarUsuario(){
        Usuario usuario = null;
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Usuario) {
                usuario = (Usuario) persona;
            }
        }
        return usuario;
    }

    public static void mostrarUsuarios() {
        Usuario usuario = null;
        System.out.println("Estos son nuestros usuarios: ");
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Usuario) {
                usuario = (Usuario) persona;
                System.out.println(usuario);
            }
        }
    }

    public static boolean loginUsuario(String telefono, String correo) {
        boolean login = false;
        boolean tel = false;
        boolean mail = false;
        Usuario usuario = null;
        // Comprobamos que existe el teléfono recorriendo la lista de Personas registradas
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Usuario) {
                usuario = (Usuario) persona;
                if (telefono.equals(usuario.getTelefono())) {
                    tel = true;
                    break;
                }
            }
        }
        // Comprobamos que existe el correo recorriendo la lista de Personas registradas
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Usuario) {
                usuario = (Usuario) persona;
                if (correo.equals(usuario.getCorreo())) {
                    mail = true;
                    break;
                }
            }
        }
        // Comprueba que el teléfono y el correo estén correctos
        if (tel && mail) {
            login = true;
            //usuario.setLogin(true);
            System.out.println("Bienvenido, usuario: " + usuario.getNombre() + " " + usuario.getApellido1());
        } else {
            System.out.println("Las credenciales no coinciden");
        }
        return login;
    }

    //Si deciden cambair la contraseña pues podran hacerlo pero previamente haciendo login
    /*public static void cambioContraseña() {
        System.out.println("1.Cambio como Bibliotecario");
        System.out.println("2.Cambio como Usuario");
        Scanner cambioC = new Scanner(System.in);
        Integer cambioCsc = cambioC.nextInt();


        if (cambioCsc == 1) {
            System.out.println("Introduce el NIF");
            Scanner nif = new Scanner(System.in);
            String setnif = nif.nextLine();
            for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
                //Comprobamos que existe el NIF recorriendo la lista de Bibliotecarios registrados
                if (setnif.equals(Biblioteca.getPersonas().get(i))) {
                    System.out.println("Correcto " + Biblioteca.getPersonas().indexOf(setnif));
                    break;
                } else if (!setnif.equals(Biblioteca.getPersonas().get(i))) {
                    System.out.println("-1"); // Si no encuentra el NIF que introducimos
                }
            }

            Bibliotecario bibliotecario = new Bibliotecario();
            System.out.println("Introduce contraseña");
            Scanner pass = new Scanner(System.in);
            String password = pass.nextLine();

            for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
                //Comprobamos que existe la contraseña recorriendo la lista de Bibliotecarios registrados
                if (password.equals(Biblioteca.getPersonas().get(i))) {
                    System.out.println("Correcto " + Biblioteca.getPersonas().indexOf(password));

                    //Una vez hecho el login tendran que introducir la antigua contraseña y la nueva
                    System.out.println("Introduce la antigua contraseña");
                    pass = new Scanner(System.in);
                    password = pass.nextLine();
                    bibliotecario.setNIF(password);
                    Biblioteca.getPersonas().remove(password);

                    System.out.println("Introduce la nueva contraseña");
                    pass = new Scanner(System.in);
                    password = pass.nextLine();
                    bibliotecario.setNIF(password);


                    System.out.println("Contraseña cambiada con exito" +
                            "La nueva contraseña es" + password);
                    break;
                } else if (!password.equals(Biblioteca.getPersonas().get(i))) {
                    System.out.println("-1"); // Si no encuentra la contraseña que se introducida
                }


            }
            //En el caso de los usuarios como no tienen contraseña lo que pueden cambiar es el teléfono que lo usan como contraseña
        } else if (cambioCsc == 2) {

            System.out.println("Introduce el telefono");
            Scanner tel = new Scanner(System.in);
            String telsc = tel.nextLine();
            for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
                //Comprobamos que existe el telefono recorriendo la lista de Usuarios registrados
                if (telsc.equals(Biblioteca.getPersonas().get(i))) {
                    System.out.println("Correcto " + Biblioteca.getPersonas().indexOf(telsc));
                    break;
                } else if (!telsc.equals(Biblioteca.getPersonas().get(i))) {
                    System.out.println("-1"); // Si no encuentra el telefono que se introduce
                }

            }

            Usuario usuario = new Usuario();
            System.out.println("Introduce el correo");
            Scanner cor = new Scanner(System.in);
            String correosc = cor.nextLine();
            for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
                //Comprobamos que existe el correo recorriendo la lista de Usuarios registrados
                if (correosc.equals(Biblioteca.getPersonas().get(i))) {
                    System.out.println("Correcto " + Biblioteca.getPersonas().indexOf(correosc));
                    //Para realizar el cambio tendran que escribir la antigua y acto seguido la nueva

                    System.out.println("Introduce el antigua numero");
                    tel = new Scanner(System.in);
                    telsc = tel.nextLine();
                    usuario.setTelefono(telsc);
                    Biblioteca.getPersonas().remove(telsc);

                    System.out.println("Introduce el nuevo numero");
                    tel = new Scanner(System.in);
                    telsc = tel.nextLine();
                    usuario.setTelefono(telsc);


                    System.out.println("Numero cambiado con exito" +
                            " el nuevo numero es" + telsc);
                    break;
                } else if (!correosc.equals(Biblioteca.getPersonas().get(i))) {
                    System.out.println("-1"); // Si no encuentra el coreo que se introduce
                }
            }
        }
    }*/
}

