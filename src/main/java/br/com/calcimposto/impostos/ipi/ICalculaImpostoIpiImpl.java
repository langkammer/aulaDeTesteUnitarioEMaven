package br.com.calcimposto.impostos.ipi;

import br.com.calcimposto.domain.TipoImposto;
import br.com.calcimposto.impostos.ICalculaImposto;

public class ICalculaImpostoIpiImpl implements ICalculaImposto {
    @Override
    public double calcular(double valor) {
        return valor * TipoImposto.ISS.getTaxa();
    }
}
