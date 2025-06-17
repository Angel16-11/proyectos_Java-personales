public class EncuestaEstudiantes {
    public static void main(String[] args) {
        int[] respuestas = {1, 2, 5, 4, 3, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14};
        int[] frecuencia = new int[6]; // índices de 0 a 5, usamos del 1 al 5

        for (int respuesta = 0; respuesta < respuestas.length; respuesta++) {
            try {
                ++frecuencia[respuestas[respuesta]];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: índice fuera de rango.");
                System.out.printf("respuestas[%d] = %d%n%n", respuesta, respuestas[respuesta]);
            }
        }

        // Mostrar encabezado de resultados
        System.out.printf("%s%10s%n", "Calificación", "Frecuencia");

        // Mostrar la frecuencia de calificaciones del 1 al 5
        for (int calificacion = 1; calificacion < frecuencia.length; calificacion++) {
            System.out.printf("%6d%10d%n", calificacion, frecuencia[calificacion]);
        }
    }
}
