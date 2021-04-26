package data;


import java.util.*;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private Integer num_copias = 1;
    private Integer num_copias_disponibles;
    private static List<String> librolist = new ArrayList<String>();
    private static List<Integer> copiaslista;
    private static List<String> listadoISBN = new ArrayList<String>();

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


    public static void añadirLibro() {
        try {
            Libro libro = new Libro();
            System.out.println("Vas a añadir un libro nuevo, para hacerlo introduce...");
            System.out.println("Escribe el ISBN");
            Scanner ISBNsc = new Scanner(System.in);
            String ISBNS = ISBNsc.nextLine();
            libro.setISBN(ISBNS);

            System.out.println("Escribe el titulo");
            Scanner titulosc = new Scanner(System.in);
            String tituloS = titulosc.nextLine();
            libro.setTitulo(tituloS);

            System.out.println("Escribe el autor");
            Scanner autorsc = new Scanner(System.in);
            String autorS = autorsc.nextLine();
            libro.setAutor(autorS);

            System.out.println("Escribe la editorial");
            Scanner editorialsc = new Scanner(System.in);
            String editorialS = editorialsc.nextLine();
            libro.setEditorial(editorialS);

            try {
                int contCopias;
                int contDisponibles;

                System.out.println("¿Cuántas copias quieres realizar? Escribe '1' para tener solo el original");
                Scanner copiassc = new Scanner(System.in);
                contCopias = copiassc.nextInt();

                for (int i = 0; i < contCopias; i++) {
                    listadoISBN.add(ISBNS); // Necesitaba una lista aparte para poder buscar por ISBN!!!
                    librolist.add("ISBN: " + ISBNS + " / Título: " + tituloS + " / Autor: " + autorS + " / Editorial: " + editorialS);
                }
                contDisponibles = contCopias;
                /*System.out.println(contCopias);
                System.out.println(contDisponibles);*/ // Para cuando queramos mostrar el número de copias

            } catch (Exception E) {
                System.out.println("Error al intentar añadir copias");
            }
        } catch (Exception e) {
            System.out.println("Error al añadir libro");
        }
        System.out.println("Libro añadido con éxito");
        System.out.println("Este es el libro (o lista de libros): ");
        System.out.println(librolist);
    }

    public static void eliminarLibro() {
        Libro libro = new Libro();
        System.out.println("Escribe el ISBN del libro ");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        if (isbn == libro.getISBN()){
            libro.setISBN(isbn);

        }else {
            System.out.println("ISBN erroneo");
        }
    }
    public static void buscarLibroISBN(){
        System.out.println("Escribe el ISBN");
        Scanner scanner = new Scanner(System.in);
        String busquedaLibroISBN = scanner.nextLine();
        for (int i = 0; i < listadoISBN.size(); i++) { // Recorrer el listado de ISBNs para encontrar el que solicita el usuario
            if (busquedaLibroISBN.equals(listadoISBN.get(i))) {
                System.out.println("El libro está en la posición " + listadoISBN.indexOf(busquedaLibroISBN));
                System.out.println("Información del libro que buscabas: " + librolist.get(i));
                break;
            } else if (!busquedaLibroISBN.equals(listadoISBN.get(i))){
                i=i;
            } else {
                System.out.println("-1"); // Si no encuentra el ISBN que se pide
            }
        }
    }

    public static void buscarLibroTitulo() {
        System.out.println("Escribe el titulo");
        Scanner scanner2 = new Scanner(System.in);
        String busquedaLibroTitulo = scanner2.nextLine();
        if (busquedaLibroTitulo.equals(busquedaLibroTitulo)) { // Revisar libroList.get(1)
            System.out.println("Mostrar libro "); // + Arrays.asList(libroList).indexOf(libro.ISBN);
        } else {
            System.out.println("-1");
        }
    }
}