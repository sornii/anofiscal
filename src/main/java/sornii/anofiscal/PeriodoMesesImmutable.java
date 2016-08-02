package sornii.anofiscal;

import java.time.Month;

public class PeriodoMesesImmutable extends PeriodoMeses {

    public PeriodoMesesImmutable(Month primeiroMes) {
        super.setPrimeiroMes(primeiroMes);
    }

    @Override
    public void setPrimeiroMes(Month primeiroMes) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setUltimoMes(Month ultimoMes) {
        throw new UnsupportedOperationException();
    }
}
