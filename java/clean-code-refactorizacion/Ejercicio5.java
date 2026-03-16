package cleanCodeRefactorizacion;

import java.util.*;

/*
Ejercicio 5 - Euromillones

Se genera una apuesta aleatoria de Euromillones.
Se crean cinco números entre 1 y 50 y dos estrellas entre 1 y 12,
evitando que se repitan.
 */

public class Ejercicio5 {

    public static void main(String[] args) {

        List<Integer> numeros = generarNumeros(5, 50);
        List<Integer> estrellas = generarNumeros(2, 12);

        System.out.println("Numeros: " + numeros);
        System.out.println("Estrellas: " + estrellas);
    }

    private static List<Integer> generarNumeros(int cantidad, int maximo) {

        Random random = new Random();
        Set<Integer> numeros = new HashSet<>();

        while (numeros.size() < cantidad) {

            int numero = random.nextInt(maximo) + 1;
            numeros.add(numero);

        }

        return new ArrayList<>(numeros);
    }
}
