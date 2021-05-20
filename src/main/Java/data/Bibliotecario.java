package data;

import java.util.Scanner;

public class Bibliotecario extends Persona {
    private String trabajo;
    private String NIF;
    private String contraseña;
    private boolean login;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

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

    public Bibliotecario() {

    }

    /*public Bibliotecario(String trabajo, String NIF, String contraseña) {
        this.trabajo = trabajo;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }*/

    public Bibliotecario(String nombre, String apellido1, String apellido2, Integer edad, String trabajo, String NIF, String contraseña, boolean login) {
        super(nombre, apellido1, apellido2, edad);
        this.trabajo = trabajo;
        this.NIF = NIF;
        this.contraseña = contraseña;
        this.login = login;
    }

    /*public Bibliotecario(Persona persona, String trabajo, String NIF, String contraseña) {
        super(persona);
        this.trabajo = trabajo;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }*/

    public Bibliotecario(Bibliotecario bibliotecario) {
        this.trabajo = bibliotecario.trabajo;
        this.NIF = bibliotecario.NIF;
        this.contraseña = bibliotecario.contraseña;
        this.login = bibliotecario.login;
    }

    @Override
    public String toString() {
        return "Bibliotecario: {" +
                "trabajo='" + trabajo + '\'' +
                ", NIF='" + NIF + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", login='" + login + '\'' +
                '}';
    } // En este caso se pide que NO imprima los datos de la clase padre (tal y como se genera el toString por defecto)


    // Para que el Bibliotecario rellene sus datos personales
    public static void solicitarDatosPersona(String nombre, String apellido1, String apellido2, Integer edad) {
        try {
            Bibliotecario bibliotecario = new Bibliotecario();
            bibliotecario.setNombre(nombre);
            bibliotecario.setApellido1(apellido1);
            bibliotecario.setApellido2(apellido2);
            bibliotecario.setEdad(edad);

            System.out.print("Introduce tu puesto de trabajo: ");
            Scanner datos = new Scanner(System.in);
            String trabajoSc = datos.nextLine();
            bibliotecario.setTrabajo(trabajoSc);

            System.out.print("Introduce tu nif: ");
            String NIFSc = datos.nextLine();
            bibliotecario.setNIF(NIFSc);

            System.out.print("Introduce tu contraseña: ");
            String contraseñaSc = datos.nextLine();
            bibliotecario.setContraseña(contraseñaSc);

            Biblioteca.getPersonas().add(bibliotecario);
            System.out.println("Nuevo bibliotecario añadido. Revisa la lista de bibliotecarios inscritos.");
        } catch (Exception E) {
            System.out.println("Error al introducir algún dato.");
        }
    }

    /* Utiliza el constructor sobrecargado de Bibliotecario para generar uno directamente
    Además, hereda de la clase abstracta Persona */
    public static void crearBibliotecariosPorDefecto() {
        Biblioteca.getPersonas().add(new Bibliotecario
                ("Daniel", "Maestre", "Hermoso", 24, "Fundador", "46397701P", "87654321", false));
        System.out.println("Bibliotecario por defecto añadido con éxito");
        Bibliotecario.mostrarBibliotecarios();
    }

    // Este método asigna el primer bibliotecario que se encuentre disponible para que el usuario haga después su reserva
    public static Bibliotecario asignarBibliotecario() {
        Bibliotecario bibliotecario = null;
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Bibliotecario) {
                bibliotecario = (Bibliotecario) persona;
                break;
            }
        }
        return bibliotecario;
    }

    // Este es un método especial que retorna el bibliotecario que quiere hacer efectivo su cambio de contraseña
    public static Bibliotecario biblioPassword(String NIF, String contraseña) {
        boolean nif = false;
        boolean pass = false;
        Bibliotecario bibliotecario = null;
        // Comprobamos que existe el NIF recorriendo la lista de Personas registradas
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Bibliotecario) {
                bibliotecario = (Bibliotecario) persona;
                if (NIF.equals(bibliotecario.getNIF())) {
                    nif = true;
                    break;
                }
            }
        }
        // Comprobamos que existe la contraseña recorriendo la lista de Personas registradas
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Bibliotecario) {
                bibliotecario = (Bibliotecario) persona;
                if (contraseña.equals(bibliotecario.getContraseña())) {
                    pass = true;
                    break;
                }
            }
        }
        // Comprueba que el nif y la contraseña estén correctos
        if (nif && pass) {
            return bibliotecario;
        } else {
            System.out.println("Las credenciales no coinciden");
            return null;
        }
    }

    // Muestra la lista de los bibliotecarios inscritos
    public static void mostrarBibliotecarios() {
        Bibliotecario bibliotecario = null;
        System.out.println("Estos son nuestros bibliotecarios: ");
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Bibliotecario) {
                bibliotecario = (Bibliotecario) persona;
                System.out.println(bibliotecario);
            }
        }
    }

    // Hace el login del Bibliotecario y retorna si ha hecho login correctamente o no
    public static boolean loginBibliotecario(String NIF, String contraseña) {
        boolean login = false;
        boolean nif = false;
        boolean pass = false;
        Bibliotecario bibliotecario = null;
        // Comprobamos que existe el NIF recorriendo la lista de Personas registradas
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Bibliotecario) {
                bibliotecario = (Bibliotecario) persona;
                if (NIF.equals(bibliotecario.getNIF())) {
                    nif = true;
                    break;
                }
            }
        }
        // Comprobamos que existe la contraseña recorriendo la lista de Personas registradas
        for (int i = 0; i < Biblioteca.getPersonas().size(); i++) {
            Persona persona = Biblioteca.getPersonas().get(i);
            if (persona instanceof Bibliotecario) {
                bibliotecario = (Bibliotecario) persona;
                if (contraseña.equals(bibliotecario.getContraseña())) {
                    pass = true;
                    break;
                }
            }
        }
        // Comprueba que el nif y la contraseña estén correctos
        if (nif && pass) {
            login = true;
            bibliotecario.setLogin(true);
            System.out.println("Bienvenido: " + bibliotecario.getNombre() + " " + bibliotecario.getApellido1());
        } else {
            System.out.println("Las credenciales no coinciden");
        }
        return login;
    }

    // Realiza el cambio de contraseña (o teléfono) de las personas
    public static void cambioContraseña() {
        try {
            System.out.println("1.Cambio de contraseña de bibliotecario");
            System.out.println("2.Cambio de teléfono de Usuario");
            Scanner cambio = new Scanner(System.in);
            Integer opcion = cambio.nextInt();
            if (opcion == 1) {
                System.out.print("Introduce el NIF: ");
                Scanner dni = new Scanner(System.in);
                String NIF = dni.nextLine();
                System.out.print("Introduce la contraseña antigua: ");
                String contraseña = dni.nextLine();
                Bibliotecario bibliotecario = Bibliotecario.biblioPassword(NIF, contraseña);
                if (bibliotecario != null) {
                    System.out.print("Introduce tu nueva contraseña: ");
                    Scanner pass = new Scanner(System.in);
                    String password = pass.nextLine();
                    bibliotecario.setContraseña(password);
                    System.out.println("La contraseña se ha cambiado, ahora es: " + password);
                } else {
                    System.out.println("Intenta hacer login de nuevo");
                }

            } else if (opcion == 2) {
                System.out.print("Introduce el teléfono antiguo: ");
                Scanner tel = new Scanner(System.in);
                String telefono = tel.nextLine();
                System.out.print("Introduce el correo: ");
                String correo = tel.nextLine();
                Usuario usuario = Usuario.loginUsuario(telefono, correo);
                if (usuario != null) {
                    System.out.print("Introduce tu nuevo número de teléfono: ");
                    Scanner telef = new Scanner(System.in);
                    String telefononuevo = telef.nextLine();
                    usuario.setTelefono(telefononuevo);
                    System.out.println("El teléfono se ha cambiado, ahora es: " + telefononuevo);
                } else {
                    System.out.println("Intenta hacer login de nuevo");
                }
            } else {
                System.out.println("Al no seleccionar ninguna de estas opciones, se volverá al menú principal directamente.");
            }
        } catch (Exception E) {
            System.out.println("Error al introducir algún dato. Volviendo al menú principal");
        }
    }
}