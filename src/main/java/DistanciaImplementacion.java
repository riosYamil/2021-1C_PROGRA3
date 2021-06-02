package src.main.java;

import PalabraDistancias.Distancia;
import PalabraDistancias.MejorDistancia;
import java.util.Scanner;
import java.util.Vector;

public class DistanciaImplementacion implements Distancia {
    @Override
    public MejorDistancia calcularDistancia(String origen, Vector<String> candidatas) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String obtenerOrigenPorPantalla() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Ingrese cadena:");
        String origen = scn.nextLine();

        return origen;
    }

    @Override
    public Vector<String> obtenerCandidatasPorPantalla(){
        Scanner scn = new Scanner(System.in);
        Vector<String> candidatas = new Vector<>();

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
}
