package src.main.java;

import PalabraDistancias.MejorDistancia;
import java.util.Vector;

public class Principal {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //recibir por teclado los string
        DistanciaImplementacion distanciaImp = new DistanciaImplementacion();
        String origen = distanciaImp.obtenerOrigenPorPantalla();
        Vector<String> candidatas = distanciaImp.obtenerCandidatasPorPantalla();
        MejorDistancia resultado = distanciaImp.calcularDistancia(origen, candidatas);
        System.out.println("Mejor Palabra Obtenida: "+resultado.palabra+" con distancia: "+resultado.distancia);
    }
}
