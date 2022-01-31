/**
 * Punto de entrada a la aplicación
 * @author Jonathan Del Arco */
public class TestGestorFaltas {
    /**
     * Se acepta como argumento del main() el n máximo de estudiantes
     * y una vez creado el gestor de faltas se muestra la información solicitada
     * (ver enunciado)
     */
    public static void main(String[] args) {


        //Crear el curso
        GestorFaltas curso = new GestorFaltas(16);

        //Cargar el fichero
        curso.leerDeFichero();

        // Justifica 6 faltas al estudiante de apellidos IRISO FLAMARIQUE
        curso.justificarFaltas("IRISO FLAMARIQUE", 6);

        // Ordena el curso
        curso.ordenar();

        // Anula matrícula a los estudiantes con más de 30 faltas injustificadas
        curso.anularMatricula();

        //muestra el curso
        System.out.println(curso);

        /*System.out.println("""
                Error en Argumentos
                Sintaxis: java TestGestorFaltas <max_estudiantes>
                ------------------------------------------------------------""");*/
    }
}
