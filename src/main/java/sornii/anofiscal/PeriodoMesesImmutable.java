package sornii.anofiscal;

import java.time.Month;

/**
 * Bloqueia mudanças imprevistas para os períodos utilizados nos padrões mundiais
 */
final class PeriodoMesesImmutable extends PeriodoMeses {

    PeriodoMesesImmutable(Month primeiroMes) {
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
