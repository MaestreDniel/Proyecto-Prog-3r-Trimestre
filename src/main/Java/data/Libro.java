package data;

import java.util.*;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private Integer nCopias;
    private Integer nCopiasDisponibles;


    @Override
    public String toString() {
        return "\nLibro: {" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", nCopias=" + nCopias +
                ", nCopiasDisponibles=" + nCopiasDisponibles +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getNCopias() {
        return nCopias;
    }

    public void setNCopias(Integer nCopias) {
        int libro = 0;
        while (libro < 1) {
            if (nCopias < 1) {
                System.out.println("No se puede añadir un libro sin copias. Vuelve a intentarlo.");
                System.out.print("¿Cuántas copias quieres realizar? ");
                Scanner copiassc = new Scanner(System.in);
                this.nCopias = copiassc.nextInt();
                this.nCopiasDisponibles = this.nCopias;
                nCopias = this.nCopias;
            } else {
                libro += 1;
            }
        }

        this.nCopias = nCopias;
    }

    public Integer getnCopiasDisponibles() {
        return nCopiasDisponibles;
    }

    public void setnCopiasDisponibles(Integer nCopiasDisponibles) {
        this.nCopiasDisponibles = nCopiasDisponibles;
    }

    public Libro() {

    }

    public Libro(String ISBN, String titulo, String autor, String editorial, Integer nCopias, Integer nCopiasDisponibles) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.nCopias = nCopias;
        this.nCopiasDisponibles = nCopiasDisponibles;
    }

    public Libro(Libro libro) {
        this.ISBN = libro.ISBN;
        this.titulo = libro.titulo;
        this.autor = libro.autor;
        this.editorial = libro.editorial;
        this.nCopias = libro.nCopias;
        this.nCopiasDisponibles = libro.nCopiasDisponibles;
    }


    public static void añadirLibro() {
        try {
            Libro libro = new Libro();
            System.out.println("Vas a añadir un libro nuevo, para hacerlo introduce...");
            System.out.print("Escribe el ISBN: ");
            Scanner datos = new Scanner(System.in);
            String ISBNS = datos.nextLine();
            libro.setISBN(ISBNS);

            System.out.print("Escribe el titulo: ");
            String tituloS = datos.nextLine();
            libro.setTitulo(tituloS);

            System.out.print("Escribe el autor: ");
            String autorS = datos.nextLine();
            libro.setAutor(autorS);

            System.out.print("Escribe la editorial: ");
            String editorialS = datos.nextLine();
            libro.setEditorial(editorialS);

            System.out.print("¿Cuántas copias quieres realizar? ");
            libro.nCopias = datos.nextInt();
            libro.nCopiasDisponibles = libro.nCopias;
            libro.setNCopias(libro.nCopias);
            libro.setnCopiasDisponibles(libro.nCopiasDisponibles);
            Biblioteca.getLibrolist().add(libro);
            System.out.println("Libro añadido con éxito");
            System.out.println("Este es el libro (o lista de libros): ");
            System.out.println(Biblioteca.getLibrolist());

        } catch (Exception e) {
            System.out.println("Error al añadir libro. ¡Asegúrate de introducir bien los datos!");
        }
    }

    public static void eliminarLibro(String isbn) {
        try {
            /* Si queremos eliminar el libro de la biblioteca hacemos que el usuario nos diga el ISBN del libro
            y acto seguido, se eliminará el libro que tenga ese ISBN */
            Libro libro = null;
            // En este for se especifica cuál es el objeto libro que hay que tratar
            for (int i = 0; i < Biblioteca.getLibrolist().size(); i++) {
                if (Biblioteca.getLibrolist().get(i).getISBN().equals(isbn)) {
                    libro = Biblioteca.getLibrolist().get(i);
                    //assert libro != null;
                    if (!libro.nCopias.equals(libro.nCopiasDisponibles)) {
                        System.out.println("Este libro no se puede eliminar porque tiene reservas.");
                    } else {
                        if (isbn.equals(libro.getISBN())) {
                            //Si el ISBN introducido es igual a una posición de la lista elimina el libro que coincide
                            String eliminar;
                            System.out.println("Este es el libro que estás a punto de eliminar: " + libro);
                            System.out.println("Confirma si quieres eliminarlo: s/n");
                            Scanner eliminacion = new Scanner(System.in);
                            eliminar = eliminacion.nextLine();
                            if (eliminar.equals("s")) {
                                Biblioteca.getLibrolist().remove(i);
                                System.out.println("Libro eliminado");
                            } else if (eliminar.equals("n")) {
                                System.out.println("El libro no será eliminado");
                            }
                            break;
                        } else if (!isbn.equals(libro.getISBN())) {
                            i = i;
                        } else {
                            System.out.println("No se encontró ningún libro con el ISBN indicado"); // Si no encuentra el ISBN que se pide
                        }
                    }
                }
                // Recorrer el listado de libros para encontrar el que solicita el usuario
            }

        } catch (Exception E) {
            System.out.println("Error al eliminar libro. Es posible que el ISBN introducido no exista.");
        }

    }

    public static void buscarLibroISBN(String isbn) {
        Libro libro = null;
        for (int i = 0; i < Biblioteca.getLibrolist().size(); i++) {
            // Recorrer el listado de libros para encontrar el que solicita el usuario
            if (Biblioteca.getLibrolist().get(i).getISBN().equals(isbn)) {
                libro = Biblioteca.getLibrolist().get(i);
                //assert libro != null;
                if (isbn.equals(libro.getISBN())) {
                    // Si algun ISBN del listado de libros es igual al introducido por el usuario en ese caso lo muestra por pantalla
                    System.out.println("El libro está en la posición " + Biblioteca.getLibrolist().indexOf(libro));
                    System.out.println("Información del libro que buscabas: " + libro);
                    break;
                } else if (!isbn.equals(libro.getISBN())) {
                    i = i;
                } else {
                    System.out.println("No se pudo encontrar el libro solicitado.");
                }
            }

        }
    }

    public static void buscarLibroTitulo(String titulo) {
        Libro libro = null;
        for (int i = 0; i < Biblioteca.getLibrolist().size(); i++) {
            // Recorrer el listado de libros para encontrar el que solicita el usuario
            if (Biblioteca.getLibrolist().get(i).getTitulo().equals(titulo)) {
                libro = Biblioteca.getLibrolist().get(i);
                //assert libro != null;
                if (titulo.equals(libro.getTitulo())) {
                    // Si algun título del listado de libros es igual al introducido por el usuario en ese caso lo muestra por pantalla
                    System.out.println("El libro está en la posición " + Biblioteca.getLibrolist().indexOf(libro));
                    System.out.println("Información del libro que buscabas: " + libro);
                    break;
                } else if (!titulo.equals(libro.getTitulo())) {
                    i = i;
                } else {
                    System.out.println("No se pudo encontrar el libro solicitado.");
                }
            }
        }
    }


    public static void ponerlibrosPorDefecto() {
        // Creamos varios libros por defecto para testear más rápido las funcionalidades del programa
        Libro libro = new Libro(
                "1234", "Quijote", "Cervantes", "Edad media", 3, 3);
        Libro libro2 = new Libro(
                "9876", "Principito", "Antoine", "Edeme", 5, 5);
        Libro libro3 = new Libro(
                "5555", "Bernarda Alba", "García Lorca", "Vicens Vives", 2, 2);
        Biblioteca.getLibrolist().add(libro);
        Biblioteca.getLibrolist().add(libro2);
        Biblioteca.getLibrolist().add(libro3);
        System.out.println("Libros por defecto añadidos con éxito");
        System.out.println("Este es el libro (o lista de libros): ");
        System.out.println(Biblioteca.getLibrolist());
    }

    public static void ponerDatosPorDefecto() {

        System.out.println("Elige qué datos quieres introducir por defecto");
        System.out.println("1. Libros por defecto");
        System.out.println("2. Usuarios por defecto");
        System.out.println("3. Bibliotecarios por defecto");
        System.out.println("4. Todo por defecto");
        Scanner defecto = new Scanner(System.in);
        Integer defectoSc = defecto.nextInt();

        if (defectoSc == 1) {
            ponerlibrosPorDefecto();
        } else if (defectoSc == 2) {
            Usuario.crearUsuariosPorDefecto();
        } else if (defectoSc == 3) {
            Bibliotecario.crearBibliotecariosPorDefecto();
        } else if (defectoSc == 4) {
            ponerlibrosPorDefecto();
            Usuario.crearUsuariosPorDefecto();
            Bibliotecario.crearBibliotecariosPorDefecto();
        }
    }

    public static boolean libroReservado(String isbn) {
        // Recorre la lista de libros para encontrar el libro que se quiere reservar a partir del ISBN
        boolean reservado = true;
        Libro libro = null;
        for (int i = 0; i < Biblioteca.getLibrolist().size(); i++) {
            if (Biblioteca.getLibrolist().get(i).getISBN().equals(isbn)) {
                libro = Biblioteca.getLibrolist().get(i);
            }
        }

        // Cuando el libro está reservado el contador de copias baja en 1 siempre y cuando no sea = 0
        assert libro != null;
        if (libro.getnCopiasDisponibles() > 0) {
            libro.setnCopiasDisponibles(libro.getnCopiasDisponibles() - 1);
            Reserva reserva = new Reserva();
            reserva.setLibro(libro);
            reserva.setFechaReserva(Reserva.determinarFecha());
            Usuario usuario = Usuario.asignarUsuario();
            usuario.getListareservas().add(reserva);
        } else {
            reservado = false;
        }
        return reservado;
    }

    public static boolean libroDevuelto(String isbn) {
        // Funciona de manera casi análoga a libroReservado
        boolean devuelto = true;
        Libro libro = null;
        for (int i = 0; i < Biblioteca.getLibrolist().size(); i++) {
            if (Biblioteca.getLibrolist().get(i).getISBN().equals(isbn)) {
                libro = Biblioteca.getLibrolist().get(i);
            }
        }

        // Solo se puede devolver un libro si se ha reservado primero
        assert libro != null;
        if (libro.getnCopiasDisponibles() < libro.getNCopias()) {
            libro.setnCopiasDisponibles(libro.getnCopiasDisponibles() + 1);
        } else {
            devuelto = false;
        }
        return devuelto;
    }

    public static Integer contadorLibros() {
        return Biblioteca.getLibrolist().size();
    }

}
