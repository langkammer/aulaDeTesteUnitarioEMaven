package br.com.calcimposto;

import br.com.calcimposto.domain.TipoImposto;
import br.com.calcimposto.impostos.icms.ICalculaImpostoIcmsImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmitirGuiaImpostoIpvaTest  {

    @InjectMocks
    private EmitirGuiaImpostoIpva emitirGuiaImpostoIpva;

    @Mock
    private CalculaImpostoStrategy calculaImpostoStrategy;

    @Mock
    private ICalculaImpostoIcmsImpl implCalculaImpostIcms;


    @Test
    public void testeEmitirGuiaSucesso() throws Exception {
        //dado que
        String placa = "AAAA-001";
        Double valorCarro = 50000.00;
        when(calculaImpostoStrategy.delegate(TipoImposto.IPVA)).thenReturn(implCalculaImpostIcms);
        when(implCalculaImpostIcms.calcular(valorCarro)).thenReturn(3000.00);
        //quando
        String retorno = emitirGuiaImpostoIpva.emitirGuia(placa, valorCarro);

        //entao
        Assert.assertEquals("Guia Emitida", retorno);
        Mockito.verify(calculaImpostoStrategy).delegate(TipoImposto.IPVA);
        Mockito.verify(implCalculaImpostIcms).calcular(valorCarro);

    }


//    @Test
//    public void testeEmitirGuiaFracasso() throws Exception {
//        //dado que
//        String placa = "AAAA-001";
//        Double valorCarro = 50000.00;
//        when(calculaImpostoStrategy.delegate(TipoImposto.IPVA)).thenThrow(new Exception("Erro"));
//        //quando
//        String retorno = emitirGuiaImpostoIpva.emitirGuia(placa, valorCarro);
//
//
//
//    }
}