package platzi.play.util;

import platzi.play.contenido.Calidad;
import platzi.play.contenido.Genero;
import platzi.play.contenido.Idioma;

import java.util.Scanner;

public class ScannerUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String capturarTexto(String mensaje){
        System.out.println(mensaje + ": ");
        while (!SCANNER.hasNext()){
            System.out.println("Dato no aceptado. " + mensaje + ": ");
            SCANNER.next();
        }
        return SCANNER.nextLine();
    }

    public static int capturarNumero(String mensaje){
        System.out.println(mensaje + ": ");
        while (!SCANNER.hasNextInt()){
            System.out.println("Dato no aceptado. " + mensaje + ": ");
            SCANNER.next();
        }
        int dato = SCANNER.nextInt();
        SCANNER.nextLine(); // Limpiar el buffer
        return dato;
    }

    public static double capturarDecimal(String mensaje){
        System.out.println(mensaje + ": ");

        while (!SCANNER.hasNextDouble()){
            System.out.println("Dato no aceptado. " + mensaje + ": ");
            SCANNER.next();
        }

        double dato = SCANNER.nextDouble();
        SCANNER.nextLine(); // Limpiar el buffer
        return dato;
    }

    public static Genero capturarGenero(String mensaje){
        while (true){
            System.out.println(mensaje + "... Opciones: ");
            for (Genero genero : Genero.values()){
                System.out.println("- " + genero.name());
            }
            System.out.println("Cuál quiere?");
            String entrada = SCANNER.nextLine();
            try{
                return Genero.valueOf(entrada.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Género no aceptado. ");
            }
        }
    }
    public static Idioma capturarIdioma(String mensaje){
        while (true){
            System.out.println(mensaje + "... Opciones: ");
            for (Idioma idioma : Idioma.values()){
                System.out.println("- " + idioma.name());
            }
            System.out.println("Cuál elige?");
            String entrada = SCANNER.nextLine();
            try{
                return Idioma.valueOf(entrada.toUpperCase());
            } catch (IllegalArgumentException e){
                System.out.println("Idioma no válido. ");
            }
        }
    }

    public static Calidad capturarCalidad(String mensaje){
        while (true){
            System.out.println("... Opciones: ");
            for(Calidad calidad : Calidad.values()){
                System.out.println("- " + calidad.name());
            }
            System.out.println("Cuál elige? ");
            String entrada = SCANNER.nextLine();
            try{
                return Calidad.valueOf(entrada.toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Calidad no válida. ");
            }
        }
    }

}

























































