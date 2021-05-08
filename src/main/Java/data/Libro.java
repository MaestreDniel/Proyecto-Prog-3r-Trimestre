package data;


import java.util.*;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private static Integer num_copias = 1;
    private static Integer num_copias_disponibles;

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", num_copias=" + num_copias +
                ", num_copias_disponibles=" + num_copias_disponibles +
                '}';
    }

    public Libro(String ISBN, String titulo, String autor, String editorial, Integer num_copias, Integer num_copias_disponibles, List<String> librolist, List<Integer> copiaslista) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.num_copias = num_copias;
        this.num_copias_disponibles = num_copias_disponibles;
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
                libro.num_copias = 0;
                libro.num_copias_disponibles = 0;
                System.out.println("¿Cuántas copias quieres realizar? Escribe '1' para tener solo el original");
                Scanner copiassc = new Scanner(System.in);
                libro.num_copias = copiassc.nextInt();
                Biblioteca.listadoISBN.add(ISBNS); // Necesitaba una lista aparte para poder buscar por ISBN!!!
                Biblioteca.listadoTitulos.add(tituloS);
                libro.num_copias_disponibles = libro.num_copias;
                Biblioteca.librolist.add(libro);
                libro.setNum_copias(libro.num_copias);
                libro.setNum_copias_disponibles(libro.num_copias_disponibles);
            } catch (Exception E) {
                System.out.println("Error al intentar añadir copias");
            }
        } catch (Exception e) {
            System.out.println("Error al añadir libro");
        }
        System.out.println("Libro añadido con éxito");
        System.out.println("Este es el libro (o lista de libros): ");
        System.out.println(Biblioteca.librolist);
    }

    public static void eliminarLibro() {
        try {
            // Si queremos eliminar el libro de la biblioteca hacemos que el usuario nos diga el ISBN del libro
            // y acto seguido, se eliminará el libro que tenga ese ISBN
            // Libro libro = new Libro();
            System.out.println("Vas a eliminar un libro, para hacerlo introduce");
            System.out.println("Escribe el ISBN");
            Scanner ISBNsc = new Scanner(System.in);
            String ISBNS = ISBNsc.nextLine();

            for (int i = 0; i < Biblioteca.listadoISBN.size(); i++) { // Recorrer el listado de ISBNs para encontrar el que solicita el usuario
                if (ISBNS.equals(Biblioteca.listadoISBN.get(i))) {
                    String eliminar;
                    System.out.println("Este es el libro que estás a punto de eliminar: " + Biblioteca.librolist.get(i));
                    System.out.println("Confirma si quieres eliminarlo: s/n");
                    Scanner eliminacion = new Scanner(System.in);
                    eliminar = eliminacion.nextLine();
                    if (eliminar.equals("s")){
                        Biblioteca.librolist.remove(i);

                    }
                    else {
                        System.out.println("El libro no será eliminado");
                    }
                    break;
                } else if (!ISBNS.equals(Biblioteca.listadoISBN.get(i))){
                    i=i;
                } else {
                    System.out.println("No se encontró ningún libro con el ISBN indicado"); // Si no encuentra el ISBN que se pide
                }
            }

            System.out.println("Libro eliminado");

        } catch (Exception E) {
            System.out.println("Error al eliminar libro");
        }

    }

    public static void buscarLibroISBN(){
        System.out.println("Escribe el ISBN");
        Scanner scanner = new Scanner(System.in);
        String busquedaLibroISBN = scanner.nextLine();
        for (int i = 0; i < Biblioteca.listadoISBN.size(); i++) { // Recorrer el listado de ISBNs para encontrar el que solicita el usuario
            if (busquedaLibroISBN.equals(Biblioteca.listadoISBN.get(i))) {
                System.out.println("El libro está en la posición " + Biblioteca.listadoISBN.indexOf(busquedaLibroISBN));
                System.out.println("Información del libro que buscabas: " + Biblioteca.librolist.get(i));
                break;
            } else if (!busquedaLibroISBN.equals(Biblioteca.listadoISBN.get(i))){
                i=i;
            } else {
                System.out.println("-1"); // Si no encuentra el ISBN que se pide
            }
        }
    }

    public static void buscarLibroTitulo() { // Recorrer el listado de títulos para encontrar los libros que coincidan con lo que solicita el usuario
        System.out.println("Escribe el titulo");
        Scanner scanner2 = new Scanner(System.in);
        String busquedaLibroTitulo = scanner2.nextLine();
        for (int i = 0; i < Biblioteca.listadoTitulos.size(); i++) {
            if (busquedaLibroTitulo.equals(Biblioteca.listadoTitulos.get(i))) {
                System.out.println("Información del libro que buscabas: " + Biblioteca.librolist.get(i));
            } else if (!busquedaLibroTitulo.equals(Biblioteca.listadoTitulos.get(i))){
                i=i;
            }
            else {
                System.out.println("No se encontró ningún libro con el título indicado");
            }
        }
    }

    public static void ponerLibrosPorDefecto(){
        Libro libro = new Libro("1234", "Quijote", "Cervantes", "Edad media",
                3, 3);
        Biblioteca.listadoISBN.add("1234");
        Biblioteca.listadoTitulos.add("Quijote");
        Biblioteca.librolist.add(libro);
        System.out.println("Libro añadido con éxito");
        System.out.println("Este es el libro (o lista de libros): ");
        System.out.println(Biblioteca.librolist);
    }

    public static boolean libroReservado(){
        boolean reservado = true;
        if (num_copias_disponibles > 0) {
            num_copias_disponibles--;
        } else {
            reservado = false;
        }
        return reservado;
    }

    //public static void libroReservado(){
        //buscarLibroISBN();

        /*try {
            Libro libro = new Libro();

            System.out.println("Escribe el ISBN");
            Scanner scanner = new Scanner(System.in);
            String busquedaLibroISBN = scanner.nextLine();
            for (int i = 0; i < listadoISBN.size(); i++) { // Recorrer el listado de ISBNs para encontrar el que solicita el usuario
                if (busquedaLibroISBN.equals(listadoISBN.get(i))) {
                    libro.getNum_copias();
                    libro.setNum_copias_disponibles(libro.num_copias_disponibles = libro.num_copias_disponibles - 1);
                    System.out.println("El libro está en la posición " + listadoISBN.indexOf(busquedaLibroISBN));
                    System.out.println("Información del libro que buscabas: " + librolist.get(i));

                    break;
                } else if (!busquedaLibroISBN.equals(listadoISBN.get(i))) {
                    i = i;
                } else {
                    System.out.println("-1"); // Si no encuentra el ISBN que se pide
                }
            }
        }    catch (Exception e){
            System.out.println("Error");
        }*/
        //setNum_copias_disponibles(num_copias_disponibles-1);
    //}

    public static void libroDevuelto(){
        Libro libro = new Libro();
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
    }
}


