package br.com.calcimposto.impostos.icms;

import br.com.calcimposto.domain.TipoImposto;
import br.com.calcimposto.impostos.ICalculaImposto;

public class ICalculaImpostoIcmsImpl implements ICalculaImposto {
    @Override
    public double calcular(double valor) {
        return valor * TipoImposto.ICMS.getTaxa();
    }
}
