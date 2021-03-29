package data;

import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<String> lista_libros;
    private List<String> personal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getLista_libros() {
        return lista_libros;
    }

    public void setLista_libros(List<String> lista_libros) {
        this.lista_libros = lista_libros;
    }

    public List<String> getPersonal() {
        return personal;
    }

    public void setPersonal(List<String> personal) {
        this.personal = personal;
    }

    public Biblioteca() {

    }

    public Biblioteca(String nombre, List<String> lista_libros, List<String> personal) {
        this.nombre = nombre;
        this.lista_libros = lista_libros;
        this.personal = personal;
    }

    public Biblioteca(Biblioteca biblioteca) {
        this.nombre = biblioteca.nombre;
        this.lista_libros = biblioteca.lista_libros;
        this.personal = biblioteca.personal;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", lista_libros=" + lista_libros +
                ", personal=" + personal +
                '}';
    }
}
