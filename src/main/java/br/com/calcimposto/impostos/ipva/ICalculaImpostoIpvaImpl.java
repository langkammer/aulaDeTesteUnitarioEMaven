package br.com.calcimposto.impostos.ipva;

import br.com.calcimposto.domain.TipoImposto;
import br.com.calcimposto.impostos.ICalculaImposto;

public class ICalculaImpostoIpvaImpl implements ICalculaImposto {
    @Override
    public double calcular(double valor) {
        return valor * TipoImposto.IPVA.getTaxa();
    }
}
