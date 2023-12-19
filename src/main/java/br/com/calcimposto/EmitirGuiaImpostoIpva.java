package br.com.calcimposto;

import br.com.calcimposto.domain.TipoImposto;

import static java.lang.String.format;

public class EmitirGuiaImpostoIpva {

    private CalculaImpostoStrategy calculaImpostoStrategy;

    public EmitirGuiaImpostoIpva() {
        this.calculaImpostoStrategy = new CalculaImpostoStrategy();
    }

    public String emitirGuia(String placa, double valorCarro)  {
        System.out.println(format("Emitindo guia imposto ipva para o o carro %s", placa));
        double valorGuia = 0;
        try {
            valorGuia = this.calculaImpostoStrategy.delegate(TipoImposto.IPVA).calcular(valorCarro);
            System.out.println(format("Valor da guia é R$ ", valorGuia));
            return "Guia Emitida";
        } catch (Exception e) {
            e.printStackTrace();
            return String.format("Guia não Emitida causa s%", e.getMessage());
        }
    }


}
