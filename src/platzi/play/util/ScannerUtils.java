package platzi.play.util;

import platzi.play.contenido.Genero;

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
            String entrada = capturarTexto(mensaje);
            try{
                return Genero.valueOf(entrada.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Dato no aceptado. " + mensaje);
            }
        }
    }

}

























































