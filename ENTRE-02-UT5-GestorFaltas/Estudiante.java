import java.util.StringTokenizer;

/**
 * Un objeto de esta clase guarda la información de un estudiante
 *
 */
public class Estudiante {

    private final static String SEPARADOR = ",";

    private String nombre;
    private String tempNombre;
    private String apellidos;

    private int faltasNoJustificadas;
    private int faltasJustificadas;

    /**
     * Inicializa los atributos a partir de la información recibida
     * Esta información se encuentra en lineaDatos
     * (ver enunciado)
     */
    public Estudiante(String lineaDatos) {

        String[] clean = lineaDatos.trim().split(SEPARADOR);

        tempNombre = clean[0].trim();
        nombre = esSimpleOCompuesto();
        apellidos = clean[1].toUpperCase().trim().replaceAll("\\s{2,}", " ");
        faltasNoJustificadas = Integer.parseInt(clean[2].trim());
        faltasJustificadas = Integer.parseInt(clean[3].trim());

    }

    private boolean tieneMas() {
        StringTokenizer name = new StringTokenizer(tempNombre);
        if (name.countTokens() > 1) {
            return true;
        }
        return false;
    }

    private String esSimpleOCompuesto() {
        if (!tieneMas()) {
            nombre = tempNombre.substring(0, 1).toUpperCase() + tempNombre.substring(1);
            return nombre;
        }

        String temp2nombre = tempNombre.replaceAll("\\s{2,}", " "); //Limpio los espacios entre las palabras
        String[] complejo = temp2nombre.split(" "); // Las divido con un split para manipularlas de forma independiente

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < complejo.length - 1; i++) { // Solo busca los dos primeros nombres menos el último
            str.append(complejo[i].substring(0, 1).toUpperCase()).append("."); // Para mostrar solo las iniciales con el punto
        }
        //Junto la cadena de Strings
        nombre = str + complejo[complejo.length - 1].replace(complejo[complejo.length - 1].charAt(0), complejo[complejo.length - 1].toUpperCase().charAt(0));
        return nombre;
    }

    /**
     * accesor para el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * mutador para el nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * accesor para los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * mutador para los apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * accesor para el número de faltas no justificadas
     */
    public int getFaltasNoJustificadas() {
        return faltasNoJustificadas;
    }

    /**
     * mutador para el nº de faltas no justificadas
     */
    public void setFaltasNoJustificadas(int faltasNoJustificadas) {
        this.faltasNoJustificadas = faltasNoJustificadas;
    }

    /**
     * accesor para el nº de faltas justificadas
     */
    public int getFaltasJustificadas() {
        return faltasJustificadas;
    }

    /**
     * mutador para el nº de faltas justificadas
     */
    public void setFaltasJustificadas(int faltasJustificadas) {
        this.faltasJustificadas = faltasJustificadas;
    }

    /**
     * se justifican n faltas que hasta el momento eran injustificadas
     * Se asume n correcto
     */
    public void justificar(int n) {
        this.faltasNoJustificadas -= n;
        this.faltasJustificadas += n;
    }

    /**
     * Representación textual del estudiante
     * (ver enunciado)
     */
    public String toString() {

        String nYApellido;
        String fNoJustificadas;
        String fJustificadas;
        String aper;

        String finish;

        nYApellido = String.format("%-25s %s %s", "Apellidos y Nombre:", getApellidos() + ",", getNombre());
        fNoJustificadas = String.format("%-25s %d", "Faltas No Justificadas:", getFaltasNoJustificadas());
        fJustificadas = String.format("%-25s %d", "Faltas Justificadas:", getFaltasJustificadas());
        aper = String.format("%-25s %s", "Apercibimientos:", avisos());


        finish = (  nYApellido + "\n" +
                    fNoJustificadas + "\n" +
                    fJustificadas + "\n" +
                    aper + "\n" +
                    "-----------------" + "\n");

        return finish;

    }

    private String avisos() {

        String nada = "Sin Apercibimiento";
        String diez = String.valueOf(Apercibimiento.DIEZ);
        String veinte =diez + " "+ Apercibimiento.VEINTE;
        String treinta = veinte + " " + Apercibimiento.TREINTA;

        if (getFaltasNoJustificadas() >= 10 && getFaltasNoJustificadas() < 20) {
            return diez;
        }
        if (getFaltasNoJustificadas() >= 20 && getFaltasNoJustificadas() < 30) {
            return veinte;
        }
        if (getFaltasNoJustificadas() >= 30) {
            return treinta;
        }
        if (getFaltasNoJustificadas() < 10){
            return nada;
        }
        return null;
    }

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante(" pedro josé   andrés  ,  Troya Baztarrica , 42, 6 ");
        System.out.println(e1);
    }
}

