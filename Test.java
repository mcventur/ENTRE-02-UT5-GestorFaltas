public class Test {
    public static void main(String[] args) {

        String nombre;
        String apellidos;

        int faltasNoJustificadas;
        int faltasJustificadas;

        String lineaDatos = " pedro josé   andrés  ,  Troya Baztarrica , 42, 6 ";

        String[] clean = lineaDatos.trim().split(",");

        nombre = clean[0].trim();
        apellidos = clean[1].trim().toUpperCase();
        faltasNoJustificadas = Integer.parseInt(clean[2].trim());
        faltasJustificadas = Integer.parseInt(clean[3].trim());

        String temp2nombre = nombre.replaceAll("\\s{2,}"," "); //Limpio los espacios entre las palabras
        String[] complejo = temp2nombre.split(" "); // Las divido con un split para manipularlas de forma independiente

        for(int i=0; i<complejo.length-1; i++){ // Solo busca los dos primeros nombres menos el último
            System.out.print(complejo[i].substring(0,1).toUpperCase() + "."); // Para mostrar solo las iniciales con el punto
        }

        //System.out.println(nombre);
        System.out.println("\n" + apellidos);
        System.out.println(faltasNoJustificadas);
        System.out.println(faltasJustificadas);
    }
}
