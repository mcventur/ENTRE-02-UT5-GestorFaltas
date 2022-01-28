import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {

        String nombre;
        String apellidos;

        int faltasNoJustificadas;
        int faltasJustificadas;

        String lineaDatos = "Catarina    rafaela , Layos Almeida , 45, 23";

        String[] clean = lineaDatos.trim().split(",");

        nombre = clean[0].trim();
        apellidos = clean[1].trim().toUpperCase();
        faltasNoJustificadas = Integer.parseInt(clean[2].trim());
        faltasJustificadas = Integer.parseInt(clean[3].trim());

        StringTokenizer name = new StringTokenizer(nombre);
        if(name.countTokens()>1){
            System.out.println("true");
        } else {
            System.out.println("false");
        }


        System.out.println(nombre);
        System.out.println(apellidos);
        System.out.println(faltasNoJustificadas);
        System.out.println(faltasJustificadas);


    }
}
