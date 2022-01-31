import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Un objeto de esta clase permite registrar estudiantes de un
 * curso (leyendo la información de un fichero de texto) y 
 * emitir listados con las faltas de los estudiantes, justificar faltas, 
 * anular matrícula dependiendo del nº de faltas, .....
 *
 */
public class GestorFaltas {
    private Estudiante[] curso;
    private int pos;

    public GestorFaltas(int n) 
    {
        curso= new Estudiante[n];
    }

    /**
     * Devuelve true si el array de estudiantes está completo,
     * false en otro caso
     */
    public boolean cursoCompleto() 
    {
        return pos==curso.length;
    }

    /**
     *    Añade un nuevo estudiante solo si el curso no está completo y no existe ya otro
     *    estudiante igual (con los mismos apellidos). 
     *    Si no se puede añadir se muestra los mensajes adecuados 
     *    (diferentes en cada caso)
     *    
     *    El estudiante se añade de tal forma que queda insertado en orden alfabético de apellidos
     *    (de menor a mayor)
     *    !!OJO!! No hay que ordenar ni utilizar ningún algoritmo de ordenación
     *    Hay que insertar en orden 
     *    
     */
    public void addEstudiante(Estudiante nuevo) 
    {
        int c=0;
        int t1=0;
        
        while(c<pos)
        {
            String s1=curso[c].getApellidos();
            String s2=nuevo.getApellidos();
            if (s2.compareTo(s1)=0)
            {
                t1++;
            }
            c++;
        }
        if (t1==0)
        {
            curso[pos]=nuevo;
            pos++;
            Arrays.sort(curso);
        }
    }
    
    /**
     * buscar un estudiante por sus apellidos
     * Si está se devuelve la posición, si no está se devuelve -1
     * Es indiferente mayúsculas / minúsculas
     * Puesto que el curso está ordenado por apellido haremos la búsqueda más
     * eficiente
     *  
     */
    public int buscarEstudiante(String apellidos) 
    {
        int c=0;
        int t1=-1;
        while(c<pos && t1!=c)
        {
            String s1=curso[c].getApellidos();
            if (apellidos.compareTo(s1)=0)
            {
                t1=c;
            }
            c++;
        }
        return t1;
    }

    /**
     * Representación textual del curso
     * Utiliza StringBuilder como clase de apoyo.
     *  
     */
    public String toString() 
    {
        
        return null;
    }

    /**
     *  Se justifican las faltas del estudiante cuyos apellidos se proporcionan
     *  El método muestra un mensaje indicando a quién se ha justificado las faltas
     *  y cuántas
     *  
     *  Se asume todo correcto (el estudiante existe y el nº de faltas a
     *  justificar también)
     */
    public void justificarFaltas(String apellidos, int faltas) 
    {
        int c=0;
        int t1=-1;
        while(c<pos && t1!=c)
        {
            String s1=curso[c].getApellidos();
            if (apellidos.compareTo(s1)=0)
            {
                curso[c].setFaltasJustificadas(curso[c].getFaltasJustificadas()+faltas);
                curso[c].setFaltasNoJustificadas(curso[c].getFaltasNoJustificadas()-faltas);
            }
            c++;
        }
    }

    /**
     * ordenar los estudiantes de mayor a menor nº de faltas injustificadas
     * si coinciden se tiene en cuenta las justificadas
     * Método de selección directa
     */
    public void ordenar() 
    {
            for (int i = 0; i < curso.length - 1; i++) {
                int posmin = i;
                for (int j = i + 1; j < curso.length; j++) {
                    if (curso[j].getFaltasNoJustificadas() < curso[posmin].getFaltasNoJustificadas()) {
                        posmin = j;
                    }
                }
                Estudiante aux = curso[posmin];
                curso[posmin] = curso[i];
                curso[i] = aux;
            }
    }

    /**
     * anular la matrícula (dar de baja) a 
     * aquellos estudiantes con 30 o más faltas injustificadas
     */
    public void anularMatricula() 
    {
        int c=0;
        int t1=-1;
        while(c<pos && t1!=c)
        {
            if (curso[c].getFaltasNoJustificadas()>30)
            {
                curso[c]=curso[c+1];
                pos--;
            }
            c++;
        }
        
    }

    /**
     * Lee de un fichero de texto los datos de los estudiantes
     *   con ayuda de un objeto de la  clase Scanner
     *   y los guarda en el array. 
     */
    public void leerDeFichero() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("estudiantes.txt"));
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                Estudiante estudiante = new Estudiante(linea);
                this.addEstudiante(estudiante);

            }

        }
        catch (IOException e) {
            System.out.println("Error al leer del fichero");
        }
        finally {
            if (sc != null) {
                sc.close();
            }
        }

    }

}
