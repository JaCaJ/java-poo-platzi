package platzi.play;

import platzi.play.contenido.*;
import platzi.play.exception.PeliculaExistenteException;
import platzi.play.plataforma.Plataforma;
import platzi.play.util.ScannerUtils;

import java.util.List;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Platzi PLAY ";
    public static final String VERSION = "1.0.0";
    public static final int AGREGAR_CONTENIDO = 1;
    public static final int MOSTRAR_TITULOS = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int VER_POPULARES = 5;
    public static final int VER_LARGA = 6;
    public static final int VER_CORTA = 7;
    public static final int ELIMINAR_CONTENIDO = 8;
    public static final int SALIR = 9;
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + "v" + VERSION);

        cargarPeliculas(plataforma);
        System.out.println("Más de " + plataforma.getDuracionTotal() + " minutos de entretenimiento. \n");

        while (true){
            int opcionElegida = ScannerUtils.capturarNumero(
                   """
                    Selecciona una opción:
                    1. Agregar contenido a la plataforma
                    2. Mostrar los títulos disponibles
                    3. Buscar por título
                    4. Buscar por genero
                    5. Ver populares
                    6. Ver película mas larga
                    7. Ver película mas corta
                    8. Eliminar contenido de la plataforma
                    9. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR_CONTENIDO -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
                    Genero genero = ScannerUtils.capturarGenero("Género del contenido");
                    Idioma idioma = ScannerUtils.capturarIdioma("Idioma del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración en minutos");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");
                    Calidad calidad = ScannerUtils.capturarCalidad("Calidad del contenido: ");

                     try{
                        plataforma.agregar(new Pelicula(nombre, duracion, genero, idioma, calidad, calificacion));
                     }catch (PeliculaExistenteException e){
                         System.out.println(e.getMessage());
                     }

                    System.out.println("Contenido agregado correctamente.");
                }
                case MOSTRAR_TITULOS -> {
                    List<ResumenContenido> contenidosResumidos = plataforma.getResumenes();
                    contenidosResumidos.forEach(resumen -> System.out.println(resumen.toString()));
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
                    Genero generoBuscado = ScannerUtils.capturarGenero("Género del contenido a buscar");

                    List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println(contenidoPorGenero.size() + " encontradas para el genero " + generoBuscado);
                    contenidoPorGenero.forEach( contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case VER_POPULARES -> {
                    int cantidadPopulares = ScannerUtils.capturarNumero("Cuantas peliculas quiere mostrar?");

                    List<Pelicula> contenidoPopulares = plataforma.getPopulares(cantidadPopulares);
                    contenidoPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case VER_LARGA -> {
                    Pelicula pelicula = plataforma.verLarga();
                    if (pelicula != null) {
                        System.out.println("Con una duración de " + pelicula.getDuracion() +
                                " la película más corta es: ");
                        System.out.println(pelicula.obtenerFichaTecnica());
                    } else {
                        System.out.println("No hay películas en " + plataforma.getNombre());
                    }

                }
                case VER_CORTA -> {
                    Pelicula pelicula = plataforma.verCorta();
                    if(pelicula != null){
                        System.out.println("Con una duración de " + pelicula.getDuracion() +
                                " min. \nla película más corta es: ");
                        System.out.println(pelicula.obtenerFichaTecnica());
                    } else {
                        System.out.println("No hay películas en " + plataforma.getNombre());
                    }

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
        plataforma.agregar(new Pelicula("The Batman", 180, Genero.ACCION, Idioma.CASTELLANO, Calidad.CUATRO_K,4.5));
        plataforma.agregar(new Pelicula("Soul", 120, Genero.ANIMACION, Idioma.INGLES, Calidad.ULTRA_HD,4.8));
        plataforma.agregar(new Pelicula("El Señor de los Anillos", 200, Genero.DRAMA, Idioma.GUARANI, Calidad.HD,4.9));
        plataforma.agregar(new Pelicula("Harry Potter", 150, Genero.DRAMA, Idioma.JAPONES, Calidad.BAJA,4.7));
        plataforma.agregar(new Pelicula("Toy Story", 90, Genero.ANIMACION, Idioma.CHINO, Calidad.CUATRO_K,4.6));
        plataforma.agregar(new Pelicula("Inception", 160, Genero.CIENCIA_FICCION, Idioma.COREANO, Calidad.ULTRA_HD,4.4));
        plataforma.agregar(new Pelicula("Avatar", 162, Genero.CIENCIA_FICCION, Idioma.CASTELLANO, Calidad.HD,4.3));
        plataforma.agregar(new Pelicula("Titanic", 195, Genero.DRAMA, Idioma.INGLES, Calidad.BAJA,4.2));
        plataforma.agregar(new Pelicula("Gladiador", 155, Genero.ACCION, Idioma.GUARANI, Calidad.CUATRO_K,4.1));
        plataforma.agregar(new Pelicula("Forrest Gump", 142, Genero.DRAMA, Idioma.JAPONES, Calidad.ULTRA_HD,4.0));
    }
}



































