package br.com.calcimposto.domain;

public enum TipoImposto {
    ISS(0.05),
    ICMS(0.30),
    IPVA(0.06),
    IPI(0.08);

    double taxa;

    public double getTaxa() {
        return taxa;
    }

    TipoImposto(double taxa) {
        this.taxa = taxa;
    }
}
