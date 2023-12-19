package br.com.calcimposto.impostos.icms;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ICalculaImpostoIcmsImplTest  {

    private ICalculaImpostoIcmsImpl calculaImpostoIcms;

    @Before
    public void setUp()  {
        this.calculaImpostoIcms = new ICalculaImpostoIcmsImpl();
    }

    @Test
    public void testCalcularDeSucesso() {
        //dado que
        Double valor = 100.0;
        //quando
        Double retornoDaTaxa = calculaImpostoIcms.calcular(valor);
        //entao
        Assert.assertEquals(Double.valueOf(30.00), retornoDaTaxa);
    }

    @Test
    public void testCalcularDeFracasso() {
        //dado que
        Double valor = 100.00;
        //quando
        Double retornoDaTaxa = calculaImpostoIcms.calcular(valor);
        //entao
        Assert.assertFalse(Double.valueOf(30.00) == retornoDaTaxa);
    }
}