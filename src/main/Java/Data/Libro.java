package Data;

import java.util.*;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private Integer num_copias = 1;
    private Integer num_copias_disponibles;
    private static List<String> librolist;
    private static List<Integer> copiaslista;


    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", num_copias=" + num_copias +
                ", num_copias_disponibles=" + num_copias_disponibles +
                ", librolist=" + librolist +
                ", copiaslista=" + copiaslista +
                '}';
    }

    public List<String> getLibrolist() {
        return librolist;
    }

    public void setLibrolist(List<String> librolist) {
        this.librolist = librolist;
    }

    public List<Integer> getCopiaslista() {
        return copiaslista;
    }

    public void setCopiaslista(List<Integer> copiaslista) {
        this.copiaslista = copiaslista;
    }

    public Libro(String ISBN, String titulo, String autor, String editorial, Integer num_copias, Integer num_copias_disponibles, List<String> librolist, List<Integer> copiaslista) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.num_copias = num_copias;
        this.num_copias_disponibles = num_copias_disponibles;
        this.librolist = librolist;
        this.copiaslista = copiaslista;

    }

    public String getISBN() {
        return ISBN;
    }

    public Object setISBN(String ISBN) {
        this.ISBN = ISBN;
        return null;
    }

    public String getTitulo() {
        return titulo;
    }

    public Object setTitulo(String titulo) {
        this.titulo = titulo;
        return null;
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

    public Integer getNum_copias() {
        return num_copias;
    }

    public void setNum_copias(Integer num_copias) {
        this.num_copias = num_copias;
    }

    public Integer getNum_copias_disponibles() {
        return num_copias_disponibles;
    }

    public void setNum_copias_disponibles(Integer num_copias_disponibles) {
        this.num_copias_disponibles = num_copias_disponibles;
    }

    public Libro() {

    }

    public Libro(String ISBN, String titulo, String autor, String editorial, Integer num_copias, Integer num_copias_disponibles) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.num_copias = num_copias;
        this.num_copias_disponibles = num_copias_disponibles;
    }

    public Libro(Libro libro) {
        this.ISBN = libro.ISBN;
        this.titulo = libro.titulo;
        this.autor = libro.autor;
        this.editorial = libro.editorial;
        this.num_copias = libro.num_copias;
        this.num_copias_disponibles = libro.num_copias_disponibles;
    }

    List<String> libroList = new ArrayList<String>();

    public static void numerocopias() {

    }

    public static void añadirLibro() {
        try {
            Libro libro = new Libro();
            /*
             *
             * Para que el usuario pueda añadir un libro nos tiene que dar
             * todos los datos del libro(ISBN,titulo,autor,editorial)
             * Todos los datos seran añadidos por teclad0
             * */
            System.out.println("Vas a añadir un libro nuevo, para hacerlo introduce");
            System.out.println("Escrbie el ISBN");
            Scanner ISBNsc = new Scanner(System.in);
            String ISBNS = ISBNsc.nextLine();
            libro.setISBN(ISBNS);

            System.out.println("Escrbie el titulo");
            Scanner titulosc = new Scanner(System.in);
            String tituloS = titulosc.nextLine();
            libro.setTitulo(tituloS);

            System.out.println("Escrbie el autor");
            Scanner autorsc = new Scanner(System.in);
            String autorS = autorsc.nextLine();
            libro.setAutor(autorS);

            System.out.println("Escribe la editorial");
            Scanner editorialsc = new Scanner(System.in);
            String editorialS = editorialsc.nextLine();
            libro.setEditorial(editorialS);

            //Como nos daba un NullPointerException hemos creado un try-catch


            /*
             * creamos 2 variables para saber el numero de copias totales y el numero de copias disponibles
             * que nos ayudara a controlar a la hora de realizar las reservas de los libros y devolverlos
             *
             * */
            int contCopias;
            int contDisponibles;


            System.out.println("Cuantas copias quieres realizar");
            Scanner copiassc = new Scanner(System.in);
            contCopias = copiassc.nextInt();


            for (int i = 0; i < contCopias; i++) {
                Libro.librolist.add(ISBNS);
                Libro.librolist.add(tituloS);
                Libro.librolist.add(autorS);
                Libro.librolist.add(editorialS);


            }
            contDisponibles = contCopias;
            System.out.println(contCopias);
            System.out.println(contDisponibles);


        } catch (Exception E) {
            System.out.println("Error");
        }
    }


    public static void eliminarLibro() {
        try {

            //Si queremos eliminar el libro de la biblioteca hacemos que el uuario nos diga todos los datos del libro
            // y acto segido seran elimiados
            Libro libro = new Libro();
            System.out.println("Vas a eliminar un libro , para hacerlo introduce");
            System.out.println("Escrbie el ISBN");
            Scanner ISBNsc = new Scanner(System.in);
            String ISBNS = ISBNsc.nextLine();
            libro.setISBN(ISBNS);


            System.out.println("Escrbie el titulo");
            Scanner titulosc = new Scanner(System.in);
            String tituloS = titulosc.nextLine();
            libro.setTitulo(tituloS);

            System.out.println("Escrbie el autor");
            Scanner autorsc = new Scanner(System.in);
            String autorS = autorsc.nextLine();
            libro.setAutor(autorS);

            System.out.println("Escribe la editorial");
            Scanner editorialsc = new Scanner(System.in);
            String editorialS = editorialsc.nextLine();
            libro.setEditorial(editorialS);


            int copiasEliminadas;


            System.out.println("Cuantas copias quieres eliminar");
            Scanner copiassc = new Scanner(System.in);
            copiasEliminadas = copiassc.nextInt();


            for (int i = 0; i < copiasEliminadas; i++) {
                Libro.librolist.add(ISBNS);
                Libro.librolist.add(tituloS);
                Libro.librolist.add(autorS);
                Libro.librolist.add(editorialS);


            }

            System.out.println("Libro eliminado");


        } catch (Exception E) {
            System.out.println("Error");
        }


    }

    public static void buscarLibroISBN() {
        /*
        * Para buscar un libro por ISBN, el usuario escribe el ISBN del libro que queire buscar y despues miramos si ese ISBN existe
        * si existe apracera toda la informacion de ese libro y la imprimimos
        * */
        Libro libro =  new Libro();
        System.out.println("Escribe el ISBN");
        Scanner scanner = new Scanner(System.in);
        String busquedaLibroISBN = scanner.nextLine();
        if (busquedaLibroISBN.equals(libro.setISBN(busquedaLibroISBN))) { // Revisar libroList.get(1)
            libro.getISBN();
            libro.getAutor();
            libro.getEditorial();
            libro.getTitulo();

            System.out.println("El libro está en la posición "); // + Arrays.asList(libroList).indexOf(libro.ISBN);
        } else {
            System.out.println("-1");
        }
    }

    public static void buscarLibroTitulo() {
        /*
         * Para buscar un libro por Título, el usuario escribe el Título del libro que queire buscar y después miramos si ese Título existe
         * si existe apracera toda la informacion de ese libro y la imprimimos
         * */
        Libro libro = new Libro();
        System.out.println("Escribe el titulo");
        Scanner scanner2 = new Scanner(System.in);
        String busquedaLibroTitulo = scanner2.nextLine();

        if (busquedaLibroTitulo.equals(libro.setTitulo(busquedaLibroTitulo))) {
            libro.getISBN();
            libro.getAutor();
            libro.getEditorial();
            libro.getTitulo();
            // Revisar libroList.get(1)
            System.out.println("Mostrar libro "); // + Arrays.asList(libroList).indexOf(libro.ISBN);
        } else {
            System.out.println("-1");
        }
    }
}