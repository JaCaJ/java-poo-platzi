package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.util.List;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Platzi PLAY ";
    public static final String VERSION = "1.0.0";
    public static final int AGREGAR_CONTENIDO = 1;
    public static final int MOSTRAR_TITULOS = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int ELIMINAR_CONTENIDO = 8;
    public static final int SALIR = 9;
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + "v" + VERSION);

        cargarPeliculas(plataforma);

        while (true){
            int opcionElegida = ScannerUtils.capturarNumero(
                   """
                    Selecciona una opción:
                    1. Agregar contenido a la plataforma
                    2. Mostrar los títulos disponibles
                    3. Buscar por título
                    4. Buscar por genero
                    8. Eliminar contenido de la plataforma
                    9. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR_CONTENIDO -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
                    String genero = ScannerUtils.capturarTexto("Género del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración en minutos");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");

                    plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                    System.out.println("Contenido agregado correctamente.");
                }
                case MOSTRAR_TITULOS -> {
                    List<String> titulos = plataforma.getTitulos();
                    titulos.forEach(System.out::println);
                }
                case BUSCAR_POR_TITULO -> {
                    String nombreBuscado = ScannerUtils.capturarTexto("Nombre del contenido a buscar");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreBuscado);

                    if(pelicula != null){
                        System.out.println(pelicula.obtenerFichaTecnica());
                    } else{
                        System.out.println(nombreBuscado + " no existe dentro de " + plataforma.getNombre());
                    }
                }
                case BUSCAR_POR_GENERO -> {
                    String generoBuscado = ScannerUtils.capturarTexto("Genero del contenido a buscar: ");

                    List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println(contenidoPorGenero.size() + " encontradas para el genero " + generoBuscado);
                    contenidoPorGenero.forEach( contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case ELIMINAR_CONTENIDO -> {
                    String peliculaAeliminar = ScannerUtils.capturarTexto("Nombre de la pelicula a eliminar: ");
                    Pelicula pelicula = plataforma.buscarPorTitulo(peliculaAeliminar);

                    if (pelicula != null){
                        plataforma.eliminar(pelicula);
                        System.out.println("Pelicula "+ pelicula.getTitulo() +" eliminada correctamente.");
                    } else{
                        System.out.println(peliculaAeliminar + " no existe dentro de " + plataforma.getNombre());
                    }
                }
                case SALIR -> {
                    System.out.println("Gracias por usar " + NOMBRE_PLATAFORMA);
                    System.exit(0);
                }
            }
        }
    }
    private static void cargarPeliculas(Plataforma plataforma){
        plataforma.agregar(new Pelicula("The Batman", 180, "Acción", 4.5));
        plataforma.agregar(new Pelicula("Soul", 120, "Animación", 4.8));
        plataforma.agregar(new Pelicula("El Señor de los Anillos", 200, "Fantasía", 4.9));
        plataforma.agregar(new Pelicula("Harry Potter", 150, "Fantasía", 4.7));
        plataforma.agregar(new Pelicula("Toy Story", 90, "Animación", 4.6));
        plataforma.agregar(new Pelicula("Inception", 160, "Ciencia Ficción", 4.4));
        plataforma.agregar(new Pelicula("Avatar", 162, "Ciencia Ficción", 4.3));
        plataforma.agregar(new Pelicula("Titanic", 195, "Romance", 4.2));
        plataforma.agregar(new Pelicula("Gladiador", 155, "Acción", 4.1));
        plataforma.agregar(new Pelicula("Forrest Gump", 142, "Drama", 4.0));
    }
}



































