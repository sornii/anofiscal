package sornii.anofiscal;

import lombok.Getter;

import java.time.Month;
import java.time.Year;

@Getter
public class AnoFiscalPadrao {

    public static final AnoFiscalPadrao JANEIRO = new AnoFiscalPadrao(Month.JANUARY);

    public static final AnoFiscalPadrao ABRIL = new AnoFiscalPadrao(Month.APRIL);

    private final PeriodoMeses periodoMeses;

    private final AnoFiscalMesReferencia mesReferencia;

    AnoFiscalPadrao(Month primeiroMes) {
        periodoMeses = new PeriodoMeses(primeiroMes);
        mesReferencia = AnoFiscalMesReferencia.ULTIMO_MES;
    }

    public AnoFiscal construirAnoFiscal(Year ano) {
        return new AnoFiscal(this, ano);
    }
}
