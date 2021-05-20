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
                "nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                ", apellido2='" + getApellido2() + '\'' +
                ", edad='" + getEdad() + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codigo postal=" + codigo_postal +
                ", correo='" + correo + '\'' +
                ", historial de reservas='" + listareservas + '\'' +
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

    // Aquí el Usuario rellenará todos sus datos personales
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

    /* Utiliza el constructor sobrecargado de Usuario para generar uno directamente
    Además, hereda de la clase abstracta Persona */
    public static void crearUsuariosPorDefecto() {
        Biblioteca.getPersonas().add(new Usuario
                ("Jeroni", "Mateo", "Curieses", 22, "9999", "casa", 777, "hola@hola"));
        System.out.println("Usuario por defecto añadido con éxito");
        Usuario.mostrarUsuarios();
    }

    // Muestra la lista de los usuarios inscritos
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

    // Hace el login del Usuario y retorna al usuario en cuestión si ha conseguido hacerlo correctamente
    public static Usuario loginUsuario(String telefono, String correo) {
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
            System.out.println("Bienvenido, usuario: " + usuario.getNombre() + " " + usuario.getApellido1());
            return usuario;
        } else {
            System.out.println("Las credenciales no coinciden");
            return null;
        }
    }
}

