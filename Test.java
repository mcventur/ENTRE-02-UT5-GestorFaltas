import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {

        String nombre;
        String apellidos;

        int faltasNoJustificadas;
        int faltasJustificadas;

        String lineaDatos = " Diego nikolay , hristozov pardo,13, 8";

        String[] clean = lineaDatos.trim().split(",");

        nombre = clean[0].trim();
        apellidos = clean[1].trim().toUpperCase();
        faltasNoJustificadas = Integer.parseInt(clean[2]);
        faltasJustificadas = Integer.parseInt(clean[3]);

        System.out.println(nombre);
        System.out.println(apellidos);
        System.out.println(faltasNoJustificadas);
        System.out.println(faltasJustificadas);
    }
}
