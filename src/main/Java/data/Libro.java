package data;

import java.util.*;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private static Integer num_copias = 1;
    private  Integer num_copias_disponibles;



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

    public Libro(String ISBN, String titulo, String autor, String editorial, Integer num_copias, Integer num_copias_disponibles, Integer num_copias_disponibles2, List<String> librolist, List<Integer> copiaslista) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        Libro.num_copias = num_copias;
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
        Libro.num_copias = num_copias;
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
        Libro.num_copias = num_copias;
        this.num_copias_disponibles = num_copias_disponibles;
    }

    public Libro(Libro libro) {
        this.ISBN = libro.ISBN;
        this.titulo = libro.titulo;
        this.autor = libro.autor;
        this.editorial = libro.editorial;
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
                num_copias = 0;
                libro.num_copias_disponibles = 0;
                System.out.println("¿Cuántas copias quieres realizar?");
                Scanner copiassc = new Scanner(System.in);
                num_copias = copiassc.nextInt();
                Biblioteca.listadoISBN.add(ISBNS); // Necesitaba una lista aparte para poder buscar por ISBN!!!
                Biblioteca.listadoTitulos.add(tituloS);
                libro.num_copias_disponibles= num_copias;
                Biblioteca.librolist.add(libro);
                libro.setNum_copias(num_copias);
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
            System.out.println("Vas a eliminar un libro, para hacerlo introduce");
            System.out.println("Escribe el ISBN");
            Scanner ISBNsc = new Scanner(System.in);
            String ISBNS = ISBNsc.nextLine();

            //Creamos un for para que recorra la lista donde estan almacenados todos los ISBN's("listadoISBN),
            for (int i = 0; i < Biblioteca.listadoISBN.size(); i++) {
                // Recorrer el listado de ISBNs para encontrar el que solicita el usuario
                if (ISBNS.equals(Biblioteca.listadoISBN.get(i))) {
                    //Si el ISBN introducido es igual a una posición de la lista elimina todo el libro
                    String eliminar;
                    System.out.println("Este es el libro que estás a punto de eliminar: " + Biblioteca.librolist.get(i));
                    System.out.println("Confirma si quieres eliminarlo: s/n");
                    Scanner eliminacion = new Scanner(System.in);
                    eliminar = eliminacion.nextLine();
                    if (eliminar.equals("s")){
                        Biblioteca.librolist.remove(i);

                    }
                     else if(eliminar.equals("n")) {
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
        for (int i = 0; i < Biblioteca.listadoISBN.size(); i++) {
            // Recorrer el listado de ISBNs para encontrar el que solicita el usuario
            if (busquedaLibroISBN.equals(Biblioteca.listadoISBN.get(i))) {
                //Si algun ISBN del listado de ISBN's es igual al introducido por el usuario en ese caso lo muestra por pantalla
                System.out.println("El libro está en la posición " + Biblioteca.listadoISBN.indexOf(busquedaLibroISBN));
                System.out.println("Información del libro que buscabas: " + Biblioteca.librolist.get(i));
                break;
            } else if (!busquedaLibroISBN.equals(Biblioteca.listadoISBN.get(i))){
                System.out.println(-1); // Si no encuentra el ISBN que se pide

            }
        }
    }

    public static void buscarLibroTitulo() {
        System.out.println("Escribe el titulo");
        Scanner scanner2 = new Scanner(System.in);
        String busquedaLibroTitulo = scanner2.nextLine();
        // Recorrer el listado de títulos para encontrar los libros que coincidan con lo que solicita el usuario
        for (int i = 0; i < Biblioteca.listadoTitulos.size(); i++) {
            if (busquedaLibroTitulo.equals(Biblioteca.listadoTitulos.get(i))) {
                //Si algun Título del listado de Titulos es igual al introducido por el usuario en ese caso lo muestra por pantalla
                System.out.println("Información del libro que buscabas: " + Biblioteca.librolist.get(i));
            } else if (!busquedaLibroTitulo.equals(Biblioteca.listadoTitulos.get(i))){
                System.out.println(-1);

            }
        }
    }

    public static void ponerLibrosPorDefecto(){
        //Para que la ejecución del programa sea mas ágil creamos un libro por defecto
        Libro libro = new Libro("1234", "Quijote", "Cervantes", "Edad media",
                3, 3);
        Biblioteca.listadoISBN.add("1234");
        Biblioteca.listadoTitulos.add("Quijote");
        Biblioteca.librolist.add(libro);
        System.out.println("Libro añadido con éxito");
        System.out.println("Este es el libro (o lista de libros): ");
        System.out.println(Biblioteca.librolist);
    }

    public static boolean libroReservado(String isbn){
        //A la hora de reservar un libro recorre la lista de libros para encontrar ese libro que quiere reservar a partir del ISBN
        boolean reservado = true;
        Libro libro = null;
        for (int i = 0; i < Biblioteca.librolist.size(); i++) {
            System.out.println(Biblioteca.librolist.get(i).getISBN());
            if (Biblioteca.librolist.get(i).getISBN().equals(isbn)){
                libro = Biblioteca.librolist.get(i);
            }

        }
        //Cuando el libro está reservado el contador de copias baja en 1 siempre y cuando no sea =0
        if (libro.getNum_copias_disponibles() > 0) {
            libro.setNum_copias_disponibles(libro.getNum_copias_disponibles()-1);
        } else {
            reservado = false;
        }
        return reservado;
    }

    public static boolean libroDevuelto(String isbn){
        //A la hora de devolver un libro recorre la lista de libros para encontrar ese libro que quiere devolver a partir del ISBN
        //Y asi vuelve a estar en su sitio

        boolean devuelto = true;
        Libro libro = null;
        for (int i = 0; i < Biblioteca.librolist.size(); i++) {
            System.out.println(Biblioteca.librolist.get(i).getISBN());
            if (Biblioteca.librolist.get(i).getISBN().equals(isbn)){
                libro = Biblioteca.librolist.get(i);
            }

        }
        //Cuando el libro está devuelto el contador de copias sube en 1
        if (libro.getNum_copias_disponibles() >= 0) {
            libro.setNum_copias_disponibles(libro.getNum_copias_disponibles()+1);
        }
        else {
            devuelto = false;
        }
        return devuelto;
    }

}
