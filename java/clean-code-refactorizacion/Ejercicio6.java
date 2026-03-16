package cleanCodeRefactorizacion;

import java.util.*;

/*
Ejercicio 6 - Mastermind

Se genera una secuencia secreta de cuatro colores.
El jugador tiene diez intentos para adivinarla.
Se indican bolas blancas (posición correcta) y negras
(color correcto pero posición incorrecta).
 */

public class Ejercicio6 {

    private static final String[] COLORES = {"Azul", "Rojo", "Verde", "Amarillo"};
    private static final int INTENTOS_MAXIMOS = 10;
    private static final int LONGITUD_CODIGO = 4;

    public static void main(String[] args) {

        List<String> codigoSecreto = generarCodigo();
        Scanner scanner = new Scanner(System.in);

        for (int intento = 1; intento <= INTENTOS_MAXIMOS; intento++) {

            System.out.println("Intento " + intento);

            List<String> intentoJugador = new ArrayList<>();

            for (int i = 0; i < LONGITUD_CODIGO; i++) {

                System.out.print("Introduce color " + (i + 1) + ": ");
                intentoJugador.add(scanner.next());
            }

            int blancas = contarBlancas(codigoSecreto, intentoJugador);
            int negras = contarColores(codigoSecreto, intentoJugador) - blancas;

            System.out.println("Blancas: " + blancas);
            System.out.println("Negras: " + negras);

            if (blancas == LONGITUD_CODIGO) {

                System.out.println("¡Has ganado en el intento " + intento + "!");
                return;
            }
        }

        System.out.println("Has perdido. El código era: " + codigoSecreto);
    }

    private static List<String> generarCodigo() {

        Random random = new Random();
        List<String> codigo = new ArrayList<>();

        for (int i = 0; i < LONGITUD_CODIGO; i++) {

            codigo.add(COLORES[random.nextInt(COLORES.length)]);

        }

        return codigo;
    }

    private static int contarBlancas(List<String> secreto, List<String> intento) {

        int contador = 0;

        for (int i = 0; i < secreto.size(); i++) {

            if (secreto.get(i).equalsIgnoreCase(intento.get(i))) {

                contador++;

            }
        }

        return contador;
    }

    private static int contarColores(List<String> secreto, List<String> intento) {

        int contador = 0;

        for (String color : secreto) {

            if (secreto.contains(color)) {

                contador++;
            }
        }

        return contador;
    }
}
