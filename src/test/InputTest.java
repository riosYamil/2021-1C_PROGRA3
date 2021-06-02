import org.junit.Assert;
import org.junit.Test;
import src.main.java.DistanciaImplementacion;
import java.io.ByteArrayInputStream;
import java.util.Vector;

public class InputTest {
    @Test
    public void testObtenerOrigenPorPantalla() {
        //Configuro el standard input y simulo el ingreso de una palabra
        String inputSample = "ingreso_de_ejemplo";
        ByteArrayInputStream bais = new ByteArrayInputStream(inputSample.getBytes());
        System.setIn(bais);

        //Ejecuto la función que obtiene una cadena s
        DistanciaImplementacion di = new DistanciaImplementacion();
        String s = di.obtenerOrigenPorPantalla();

        //Verifico
        Assert.assertEquals(inputSample, s);
    }

    @Test
    public void testObtenerConjuntoDeCandidatos() {
        //Configuro el standard input y simulo el ingreso del tamaño del conjunto
        String inputSample = String.format("3%scantar%scanta%scontar",System.lineSeparator(),System.lineSeparator(),System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(inputSample.getBytes());
        System.setIn(bais);

        //Ejecuto la función que obtiene una cadena s
        DistanciaImplementacion di = new DistanciaImplementacion();
        Vector<String> candidates = di.obtenerCandidatasPorPantalla();

        //Resultado experado
        Vector<String> expected = new Vector<>();
        expected.add("cantar");
        expected.add("canta");
        expected.add("contar");

        //Verifico
        Assert.assertEquals(expected, candidates);
    }
}