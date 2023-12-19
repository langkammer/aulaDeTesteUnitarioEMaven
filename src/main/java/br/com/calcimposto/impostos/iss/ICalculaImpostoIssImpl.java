package br.com.calcimposto.impostos.iss;

import br.com.calcimposto.domain.TipoImposto;
import br.com.calcimposto.impostos.ICalculaImposto;

public class ICalculaImpostoIssImpl implements ICalculaImposto {
    @Override
    public double calcular(double valor) {
        return valor * TipoImposto.ISS.getTaxa();
    }
}
