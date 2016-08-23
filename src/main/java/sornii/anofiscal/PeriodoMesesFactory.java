package sornii.anofiscal;

import java.time.Month;

/**
 * Fábrica para construção de um período de meses
 */
public class PeriodoMesesFactory {

    PeriodoMesesFactory() {
    }

    /**
     * Construção de um período de meses utilizando apenas o primeiro mês
     *
     * @param primeiroMes Primeiro mês do intervalo
     * @return Período de 12 meses a partir do {@code primeiroMes}
     */
    public static PeriodoMeses construirUsandoPrimeiroMes(Month primeiroMes) {
        PeriodoMeses periodoMeses = new PeriodoMeses();
        periodoMeses.setPrimeiroMes(primeiroMes);

        return periodoMeses;
    }

    /**
     * Construção de um período de meses utilizando apenas o último mês
     *
     * @param ultimoMes Primeiro mês do intervalo
     * @return Período de 12 meses a partir do {@code ultimoMes}
     */
    public static PeriodoMeses construirUsandoUltimoMes(Month ultimoMes) {
        PeriodoMeses periodoMeses = new PeriodoMeses();
        periodoMeses.setUltimoMes(ultimoMes);

        return periodoMeses;
    }
}
