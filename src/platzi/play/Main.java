package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Platzi PLAY ";
    public static final String VERSION = "1.0.0";
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + "v" + VERSION);

        String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
        String genero = ScannerUtils.capturarTexto("Género del contenido");
        int duracion = ScannerUtils.capturarNumero("Duración en minutos");
        double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");


        Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion);
        Pelicula pelicula2 = new Pelicula("Titanic", 210, "Romance", 4.5);
        pelicula.getTitulo();
        pelicula2.getTitulo();

        plataforma.agregar(pelicula);
        plataforma.agregar(pelicula2);
        System.out.println("Numero de elementos en la plataforma " + plataforma.getContenido().size());
        plataforma.eliminar(pelicula2);
        plataforma.mostrarTitulos();

        Usuario usuario = new Usuario("Jorge", "email@gmail.com");

        //también puede ser
        //usuario.fechaRegistro = LocalDateTime.of(2025, 12, 23, 17, 15, 19);
        usuario.ver(pelicula);
    }
}



































