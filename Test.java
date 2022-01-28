public class Test {
    public static void main(String[] args) {

        String nombre;
        String apellidos;

        int faltasNoJustificadas;
        int faltasJustificadas;

        String lineaDatos = "  Asier  Elorri, Oyarzun Guallar,  45, 7";

        String[] clean = lineaDatos.trim().split(",");

        nombre = clean[0].trim();
        apellidos = clean[1].trim().toUpperCase();
        faltasNoJustificadas = Integer.parseInt(clean[2].trim());
        faltasJustificadas = Integer.parseInt(clean[3].trim());

        String temp2nombre = nombre.replaceAll("\\s{2,}"," "); //Limpio los espacios entre las palabras
        String[] complejo = temp2nombre.split(" "); // Las divido con un split para manipularlas de forma independiente

        String str = "";
        for(int i=0; i<complejo.length-1; i++){ // Solo busca los dos primeros nombres menos el último
            str += complejo[i].substring(0,1).toUpperCase() + "."; // Para mostrar solo las iniciales con el punto
        }

        nombre = str + complejo[complejo.length-1].replace(complejo[complejo.length-1].charAt(0), complejo[complejo.length-1].toUpperCase().charAt(0));

        System.out.println(nombre);
        System.out.println(apellidos);
        System.out.println(faltasNoJustificadas);
        System.out.println(faltasJustificadas);
    }
}
