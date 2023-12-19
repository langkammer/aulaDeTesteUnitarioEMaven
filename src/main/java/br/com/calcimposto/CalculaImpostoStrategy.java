package br.com.calcimposto;

import br.com.calcimposto.domain.TipoImposto;
import br.com.calcimposto.impostos.ICalculaImposto;
import br.com.calcimposto.impostos.icms.ICalculaImpostoIcmsImpl;
import br.com.calcimposto.impostos.ipi.ICalculaImpostoIpiImpl;
import br.com.calcimposto.impostos.ipva.ICalculaImpostoIpvaImpl;
import br.com.calcimposto.impostos.iss.ICalculaImpostoIssImpl;

import java.util.HashMap;
import java.util.Optional;

import static br.com.calcimposto.domain.TipoImposto.*;

public class CalculaImpostoStrategy {
    private final HashMap<TipoImposto, ICalculaImposto> MAP_CALCULA_IMPOSTO = new HashMap<>();


    public CalculaImpostoStrategy() {
        MAP_CALCULA_IMPOSTO.put(ICMS, new ICalculaImpostoIcmsImpl());
        MAP_CALCULA_IMPOSTO.put(ISS, new ICalculaImpostoIssImpl());
        MAP_CALCULA_IMPOSTO.put(IPVA, new ICalculaImpostoIpvaImpl());
        MAP_CALCULA_IMPOSTO.put(IPI, new ICalculaImpostoIpiImpl());

    }

    public ICalculaImposto delegate(TipoImposto tipoImposto) throws Exception {
        return Optional
                .ofNullable(MAP_CALCULA_IMPOSTO.get(tipoImposto))
                .orElseThrow(() -> new Exception("Tipo de Imposto Inexistente"));
    }
}
