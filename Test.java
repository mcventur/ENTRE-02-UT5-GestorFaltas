import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {

        String nombre;
        String apellidos;

        int faltasNoJustificadas;
        int faltasJustificadas;

        String lineaDatos = "  ander ibai  ,  Ruiz Sena , 12, 23 ";

        String[] clean = lineaDatos.trim().split(",");
        //.replaceAll("\\s{2,}"," ")
        nombre = clean[0].trim();
        apellidos = clean[1].trim().toUpperCase();
        faltasNoJustificadas = Integer.parseInt(clean[2].trim());
        faltasJustificadas = Integer.parseInt(clean[3].trim());

        System.out.println(nombre);
        System.out.println(apellidos);
        System.out.println(faltasNoJustificadas);
        System.out.println(faltasJustificadas);
    }
}
