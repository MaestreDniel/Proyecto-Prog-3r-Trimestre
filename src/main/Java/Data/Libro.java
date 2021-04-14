package Data;


import java.util.*;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private Integer num_copias = 1;
    private Integer num_copias_disponibles;



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

    Integer contadorLibros = 0;

    public static String añadirLibro(Libro libro){
      List<Libro> libroList = new ArrayList<Libro>();
      libroList.add(libro.contadorLibros);
    };

    public static String eliminarLibro(Libro libro){
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();

}
    public static String buscarISBN(Libro libro){
        Scanner scanner = new Scanner(System.in);
        String busquedaISBN = scanner.nextLine();
        //Añadir un for para recorrer la lista
        if (busquedaISBN == ){
            System.out.println(libro.ISBN);
        }
        else{
            System.out.println(-1);
        }
    }


    public static String  buscarLibro( Libro libro){
        Scanner scanner = new Scanner(System.in);
        String busquedaLibro = scanner.nextLine();
        return libro.titulo;
    }

}
