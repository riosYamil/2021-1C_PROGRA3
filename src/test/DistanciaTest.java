import org.junit.Assert;
import org.junit.Test;
import src.main.java.DistanciaImplementacion;
import src.main.java.PalabraDistancias.MejorDistancia;
import java.util.Vector;

public class DistanciaTest {
    @Test
    public void testMejorDistanciaCasoBorde() {
        //Inicializo variables de entrada
        String origen = "";
        Vector<String> vectorPalabras = new Vector<>();
        vectorPalabras.add("a");

        //Ejecuto la función calcularDistancia
        MejorDistancia mejorDistancia;
        DistanciaImplementacion distanciaImp = new DistanciaImplementacion();
        mejorDistancia = distanciaImp.calcularDistancia(origen, vectorPalabras);

        //Verifico
        Assert.assertEquals(1, mejorDistancia.distancia);
        Assert.assertEquals("a", mejorDistancia.palabra);
    }

    @Test
    public void testMejorDistanciaInfinitivoAR() {
        //Inicializo variables de entrada
        String origen = "a";
        Vector<String> vectorPalabras = new Vector<>();
        vectorPalabras.add("ar");

        //Ejecuto la función calcularDistancia
        MejorDistancia mejorDistancia;
        DistanciaImplementacion distanciaImp = new DistanciaImplementacion();
        mejorDistancia = distanciaImp.calcularDistancia(origen, vectorPalabras);

        //Verifico
        Assert.assertEquals(1, mejorDistancia.distancia);
        Assert.assertEquals("ar", mejorDistancia.palabra);

    }

    @Test
    public void testMejorDistanciaInfinitivoER() {
        //Inicializo variables de entrada
        String origen = "a";
        Vector<String> vectorPalabras = new Vector<>();
        vectorPalabras.add("er");

        //Ejecuto la función calcularDistancia
        MejorDistancia mejorDistancia;
        DistanciaImplementacion distanciaImp = new DistanciaImplementacion();
        mejorDistancia = distanciaImp.calcularDistancia(origen, vectorPalabras);

        //Verifico
        Assert.assertEquals(2, mejorDistancia.distancia);
        Assert.assertEquals("ar", mejorDistancia.palabra);
    }

    @Test
    public void testMejorDistanciaPrimerEjemploDelTP() {
        //Inicializo variables de entrada
        String origen = "padron";
        Vector<String> vectorPalabras = new Vector<>();
        vectorPalabras.add("patron");

        //Ejecuto la función calcularDistancia
        MejorDistancia mejorDistancia;
        DistanciaImplementacion distanciaImp = new DistanciaImplementacion();
        mejorDistancia = distanciaImp.calcularDistancia(origen, vectorPalabras);

        //Verifico
        Assert.assertEquals(1, mejorDistancia.distancia);
        Assert.assertEquals("patron", mejorDistancia.palabra);
    }

    @Test
    public void testMejorDistanciaSegundoEjemploDelTP() {
        //Inicializo variables de entrada
        String origen = "cara";
        Vector<String> vectorPalabras = new Vector<>();
        vectorPalabras.add("carro");

        //Ejecuto la función calcularDistancia
        MejorDistancia mejorDistancia;
        DistanciaImplementacion distanciaImp = new DistanciaImplementacion();
        mejorDistancia = distanciaImp.calcularDistancia(origen, vectorPalabras);

        //Verifico
        Assert.assertEquals(2, mejorDistancia.distancia);
        Assert.assertEquals("carro", mejorDistancia.palabra);
    }

    @Test
    public void testMejorDistanciaTercerEjemploDelTP() {
        //Inicializo variables de entrada
        String origen = "cantor";
        Vector<String> vectorPalabras = new Vector<>();
        vectorPalabras.add("cantar");
        vectorPalabras.add("canta");
        vectorPalabras.add("contar");

        //Ejecuto la función calcularDistancia
        MejorDistancia mejorDistancia;
        DistanciaImplementacion distanciaImp = new DistanciaImplementacion();
        mejorDistancia = distanciaImp.calcularDistancia(origen, vectorPalabras);

        //Verifico
        Assert.assertEquals(1, mejorDistancia.distancia);
        Assert.assertEquals("cantar", mejorDistancia.palabra);
    }
}