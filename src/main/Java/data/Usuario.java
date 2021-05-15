package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario extends Persona {

    private String telefono;
    private String direccion;
    private Integer codigo_postal;
    private String correo;
    private List<Reserva> reservas;
    private static List<String> loginUsuario = new ArrayList<String>();
    private static List<String> loginBibliotecario = new ArrayList<String>();
    private static List<String> listaAltaUsuarios = new ArrayList<String>();
    private static List<String> listaAltaBibliotecarios = new ArrayList<String>();


    @Override
    public String toString() {
        return "Usuario{" +
                "telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", codigo_postal=" + codigo_postal +
                ", correo='" + correo + '\'' +
                ", reservas=" + reservas +
                '}';
    }

    public static List<String> getLoginUsuario() {
        return loginUsuario;
    }

    public static void setLoginUsuario(List<String> loginUsuario) {
        Usuario.loginUsuario = loginUsuario;
    }


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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Usuario() {

    }

    public Usuario(String telefono, String direccion, Integer codigo_postal, String correo, List<Reserva> reservas) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.correo = correo;
        this.reservas = reservas;
    }


    public Usuario(String nombre, String apellido1, String apellido2, Integer edad, String telefono, String direccion, Integer codigo_postal, String correo, List<Reserva> reservas) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.correo = correo;
        this.reservas = reservas;
    }

    public Usuario(Persona persona, String telefono, String direccion, Integer codigo_postal, String correo, List<Reserva> reservas) {
        super(persona);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.correo = correo;
        this.reservas = reservas;
    }

    public Usuario(Usuario usuario) {
        super(usuario);
        this.telefono = usuario.telefono;
        this.direccion = usuario.direccion;
        this.codigo_postal = usuario.codigo_postal;
        this.correo = usuario.correo;
        this.reservas = usuario.reservas;
    }

    //Aqui el Usuario rellenara todos sus datos personales
    public static void solicitarDatosUsuario() {
        System.out.println("Escribe los datos: ");
        System.out.println("Nombre de usuario: ");
        Scanner usuario = new Scanner(System.in);
        String usuariosc = usuario.nextLine();
        System.out.println(usuariosc);
        listaAltaUsuarios.add(usuariosc);

        System.out.println("Número de teléfono: ");
        Scanner telefono = new Scanner(System.in);
        String telefonosc = telefono.nextLine();
        System.out.println(telefonosc);
        listaAltaUsuarios.add(telefonosc);


        System.out.println("Dirección: ");
        Scanner direccion = new Scanner(System.in);
        String direccionsc = direccion.nextLine();
        System.out.println(direccionsc);
        listaAltaUsuarios.add(direccionsc);

        System.out.println("Código postal: ");
        Scanner codigopostal = new Scanner(System.in);
        String codigopostalsc = codigopostal.nextLine();
        System.out.println(codigopostalsc);
        listaAltaUsuarios.add(codigopostalsc);

        System.out.println("Dirección email: ");
        Scanner email = new Scanner(System.in);
        String emailsc = email.nextLine();
        System.out.println(emailsc);
        listaAltaUsuarios.add(emailsc);
    }


    //Aqui el Bilbiotecario rellenara todos sus datos personales

    public static void solicitarDatosBibliotecario() {
        System.out.println("Escribe los datos: ");
        System.out.println("Nombre de usuario: ");
        Scanner usuario = new Scanner(System.in);
        String usuariosc = usuario.nextLine();
        System.out.println(usuariosc);
        listaAltaBibliotecarios.add(usuariosc);

        System.out.println("Número de teléfono: ");
        Scanner telefono = new Scanner(System.in);
        String telefonosc = telefono.nextLine();
        System.out.println(telefonosc);
        listaAltaBibliotecarios.add(telefonosc);

        System.out.println("Dirección: ");
        Scanner direccion = new Scanner(System.in);
        String direccionsc = direccion.nextLine();
        System.out.println(direccionsc);
        listaAltaBibliotecarios.add(direccionsc);

        System.out.println("Código postal: ");
        Scanner codigopostal = new Scanner(System.in);
        String codigopostalsc = codigopostal.nextLine();
        System.out.println(codigopostalsc);
        listaAltaBibliotecarios.add(codigopostalsc);

        System.out.println("Dirección email: ");
        Scanner email = new Scanner(System.in);
        String emailsc = email.nextLine();
        System.out.println(emailsc);
        listaAltaBibliotecarios.add(emailsc);

    }

    //Este metodo se crea para que se puedan registrar en la biblioteca tanto como Usario como Bibliotecario
    public static void registrarse() {
        System.out.println("1.Registrarse como Usuario");
        System.out.println("2.Registrarse como Bibliotecario");
        Scanner registrosc = new Scanner(System.in);
        Integer registro = registrosc.nextInt();
        if (registro == 1) {

            Usuario usuario = new Usuario();

            System.out.println("Introduce el telefono");
            Scanner tel = new Scanner(System.in);
            String settel = tel.nextLine();
            usuario.setTelefono(settel);
            loginUsuario.add(settel);


            System.out.println("Introduce el correo");
            Scanner correosc = new Scanner(System.in);
            String correo = correosc.nextLine();
            usuario.setCorreo(correo);
            loginUsuario.add(correo);

        } else if (registro == 2) {


            Bibliotecario bibliotecario = new Bibliotecario();


            System.out.println("Introduce el NIF");
            Scanner nif = new Scanner(System.in);
            String setnif = nif.nextLine();
            bibliotecario.setNIF(setnif);
            loginBibliotecario.add(setnif);


            System.out.println("Introduce contraseña");
            Scanner pass = new Scanner(System.in);
            String password = pass.nextLine();
            bibliotecario.setNIF(password);
            loginBibliotecario.add(password);
        }
    }


    //Si el Usuario/Bibliotecario ya esta registrado pues solo tendra que iniciar sesion
    public static void login() {

        System.out.println("1.Login como Bibliotecario");
        System.out.println("2.Login como Usuario");
        Scanner loginsc = new Scanner(System.in);
        Integer login = loginsc.nextInt();


        if (login == 1) {
            System.out.println("Introduce el NIF");
            Scanner nif = new Scanner(System.in);
            String setnif = nif.nextLine();
            //Comprobamos que existe el NiF recorriendo la lista de Bibliotecarios registrados
            for (int i = 0; i < loginBibliotecario.size(); i++) {
                if (setnif.equals(loginBibliotecario.get(i))) {
                    System.out.println("Correcto " + loginBibliotecario.indexOf(setnif));
                    break;
                } else if (!setnif.equals(loginBibliotecario.get(i))) {
                    System.out.println("-1"); // Si no encuentra el NIF que se introduce
                }
            }


            System.out.println("Introduce contraseña");
            Scanner pass = new Scanner(System.in);
            String password = pass.nextLine();
            for (int i = 0; i < loginBibliotecario.size(); i++) {
                //Comprobamos que existe el la contraseña recorriendo la lista de Bibliotecarios registrados
                if (password.equals(loginBibliotecario.get(i))) {
                    System.out.println("Correcto" + loginBibliotecario.indexOf(password));
                    break;
                } else if (!password.equals(loginBibliotecario.get(i))) {
                    System.out.println("-1"); // Si no encuentra la contraseña que se introduce
                }
            }
        } else if (login == 2) {

            System.out.println("Introduce el telefono");
            Scanner tel = new Scanner(System.in);
            String settel = tel.nextLine();
            for (int i = 0; i < loginUsuario.size(); i++) {
                //Comprobamos que existe el telefono recorriendo la lista de Usuarios registrados
                if (settel.equals(loginUsuario.get(i))) {
                    System.out.println("Correcto " + loginUsuario.indexOf(settel));
                    break;
                } else if (!settel.equals(loginUsuario.get(i))) {
                    System.out.println("-1"); // Si no encuentra el telefono que se introduce
                }
            }


            System.out.println("Introduce el correo");
            Scanner correosc = new Scanner(System.in);
            String correo = correosc.nextLine();
            for (int i = 0; i < loginUsuario.size(); i++) {
                //Comprobamos que existe el correo recorriendo la lista de Usuarios registrados
                if (correo.equals(loginUsuario.get(i))) {
                    System.out.println("Correcto " + loginUsuario.indexOf(correo));
                    break;
                } else if (!correo.equals(loginUsuario.get(i))) {
                    System.out.println("-1"); // Si no encuentra el correo que se introduce
                }
            }
        }
    }

    //Si deciden cambair la contraseña pues podran hacerlo pero previamente haciendo login
    public static void cambioContraseña() {
        System.out.println("1.Cambio como Bibliotecario");
        System.out.println("2.Cambio como Usuario");
        Scanner cambioC = new Scanner(System.in);
        Integer cambioCsc = cambioC.nextInt();


        if (cambioCsc == 1) {
            System.out.println("Introduce el NIF");
            Scanner nif = new Scanner(System.in);
            String setnif = nif.nextLine();
            for (int i = 0; i < loginBibliotecario.size(); i++) {
                //Comprobamos que existe el NIF recorriendo la lista de Bibliotecarios registrados
                if (setnif.equals(loginBibliotecario.get(i))) {
                    System.out.println("Correcto " + loginBibliotecario.indexOf(setnif));
                    break;
                } else if (!setnif.equals(loginBibliotecario.get(i))) {
                    System.out.println("-1"); // Si no encuentra el NIF que introducimos
                }
            }

            Bibliotecario bibliotecario = new Bibliotecario();
            System.out.println("Introduce contraseña");
            Scanner pass = new Scanner(System.in);
            String password = pass.nextLine();

            for (int i = 0; i < loginBibliotecario.size(); i++) {
                //Comprobamos que existe la contraseña recorriendo la lista de Bibliotecarios registrados
                if (password.equals(loginBibliotecario.get(i))) {
                    System.out.println("Correcto " + loginBibliotecario.indexOf(password));

                    //Una vez hecho el login tendran que introducir la antigua contraseña y la nueva
                    System.out.println("Introduce la antigua contraseña");
                    pass = new Scanner(System.in);
                    password = pass.nextLine();
                    bibliotecario.setNIF(password);
                    loginBibliotecario.remove(password);

                    System.out.println("Introduce la nueva contraseña");
                    pass = new Scanner(System.in);
                    password = pass.nextLine();
                    bibliotecario.setNIF(password);
                    loginBibliotecario.add(password);

                    System.out.println("Contraseña cambiada con exito" +
                            "La nueva contraseña es" + password);
                    break;
                } else if (!password.equals(loginBibliotecario.get(i))) {
                    System.out.println("-1"); // Si no encuentra la contraseña que se introducida
                }




            }
            //En el caso de los usuarios como no tienen contraseña lo que pueden cambiar es el teléfono que lo usan como contraseña
        } else if (cambioCsc == 2) {

            System.out.println("Introduce el telefono");
            Scanner tel = new Scanner(System.in);
            String telsc = tel.nextLine();
            for (int i = 0; i < loginUsuario.size(); i++) {
                //Comprobamos que existe el telefono recorriendo la lista de Usuarios registrados
                if (telsc.equals(loginUsuario.get(i))) {
                    System.out.println("Correcto " + loginUsuario.indexOf(telsc));
                    break;
                } else if (!telsc.equals(loginUsuario.get(i))) {
                    System.out.println("-1"); // Si no encuentra el telefono que se introduce
                }

            }

            Usuario usuario = new Usuario();
            System.out.println("Introduce el correo");
            Scanner cor = new Scanner(System.in);
            String correosc = cor.nextLine();
            for (int i = 0; i < loginUsuario.size(); i++) {
                //Comprobamos que existe el correo recorriendo la lista de Usuarios registrados
                if (correosc.equals(loginUsuario.get(i))) {
                    System.out.println("Correcto " + loginUsuario.indexOf(correosc));
                    //Para realizar el cambio tendran que escribir la antigua y acto seguido la nueva

                    System.out.println("Introduce el antigua numero");
                    tel = new Scanner(System.in);
                    telsc = tel.nextLine();
                    usuario.setTelefono(telsc);
                    loginUsuario.remove(telsc);

                    System.out.println("Introduce el nuevo numero");
                    tel = new Scanner(System.in);
                    telsc = tel.nextLine();
                    usuario.setTelefono(telsc);
                    loginUsuario.add(telsc);

                    System.out.println("Numero cambiado con exito" +
                            " el nuevo numero es" + telsc);
                    break;
                } else if (!correosc.equals(loginUsuario.get(i))) {
                    System.out.println("-1"); // Si no encuentra el coreo que se introduce
                }
            }
        }
    }
}

