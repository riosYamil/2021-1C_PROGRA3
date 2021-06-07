package src.main.java.PalabraDistancias;

import java.util.Vector;

public interface Distancia {
    String obtenerOrigenPorPantalla();

    Vector<String> obtenerCandidatasPorPantalla();

    MejorDistancia calcularDistancia(String var1, Vector<String> var2);
}
