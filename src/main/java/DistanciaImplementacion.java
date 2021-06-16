package src.main.java;

import src.main.java.PalabraDistancias.Distancia;
import src.main.java.PalabraDistancias.MejorDistancia;


import java.util.Scanner;
import java.util.Vector;

public class DistanciaImplementacion implements Distancia {
    @Override
    public MejorDistancia calcularDistancia(String origen, Vector<String> candidatas) {
        long startTime = System.currentTimeMillis();

        int cantidadDePalabras = candidatas.size();
        int i = 0;
        MejorDistancia res = new MejorDistancia();

        while (i < cantidadDePalabras) {
            int distanciaDePalabraActual = evaluarLetras(origen, 0, candidatas.get(i), 0, 0, res.distancia);

            if (distanciaDePalabraActual < res.distancia) {
                res.distancia = distanciaDePalabraActual;
                res.palabra = candidatas.get(i);
            }

            i = i + 1;
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(origen.length() + "," + cantidadDePalabras + "," + estimatedTime);
        return res;
    }

    @Override
    public String obtenerOrigenPorPantalla() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Ingrese cadena:");
        String origen = scn.nextLine();

        return origen;
    }

    @Override
    public Vector<String> obtenerCandidatasPorPantalla() {
        Scanner scn = new Scanner(System.in);
        Vector<String> candidatas = new Vector<>(); //Si este vector lo ordeno por longitud de palabra nuestro algoritmo sería mejor? Si empiezo por el menor las palabras mas grande usaran menos tiempo de ejecuciòn.

        System.out.println("Ingrese la cantidad de elementos del conjuntos de cadenas:");
        int cantidadDeCandidatas = Integer.parseInt(scn.nextLine());
        System.out.println("Cantidad de elementos del conjunto: " + cantidadDeCandidatas);

        for (int i = 1; i <= cantidadDeCandidatas; i++) {
            System.out.println("Ingrese la " + i + "ª cadena: ");
            String cadena = scn.nextLine();
            candidatas.add(cadena);
        }

        return candidatas;
    }

    public int evaluarLetras(String origen, int indiceOrigen, String palabraVector, int indicePalabraVector, int distanciaPalabraActual, int mejorDistancia) {

        int distanciaDelete = Integer.MAX_VALUE;
        int distanciaReplace = Integer.MAX_VALUE;
        int distanciaInsert = Integer.MAX_VALUE;

        if (indiceOrigen == origen.length()) {
            return distanciaPalabraActual + (palabraVector.length() - indicePalabraVector);
        }

        if (indicePalabraVector == palabraVector.length()) {
            return distanciaPalabraActual + (origen.length() - indiceOrigen);
        }

        if (distanciaPalabraActual < mejorDistancia) {
            if (origen.charAt(indiceOrigen) == palabraVector.charAt(indicePalabraVector)) {
                //Todo OK, analizo próximas letras en ambas palabras
                return evaluarLetras(origen,
                        indiceOrigen + 1,
                        palabraVector,
                        indicePalabraVector + 1,
                        distanciaPalabraActual,
                        mejorDistancia);
            } else {
                //DELETE
                distanciaDelete = evaluarLetras(origen,
                        indiceOrigen + 1,
                        palabraVector,
                        indicePalabraVector,
                        distanciaPalabraActual + 1,
                        mejorDistancia);

                //REPLACE
                distanciaReplace = evaluarLetras(origen,
                        indiceOrigen + 1,
                        palabraVector,
                        indicePalabraVector + 1,
                        distanciaPalabraActual + 1,
                        mejorDistancia);

                //INSERT
                distanciaInsert = evaluarLetras(origen,
                        indiceOrigen,
                        palabraVector,
                        indicePalabraVector + 1,
                        distanciaPalabraActual + 1,
                        mejorDistancia);
            }
        }
        return Math.min(distanciaDelete, Math.min(distanciaReplace, distanciaInsert));
    }
}


