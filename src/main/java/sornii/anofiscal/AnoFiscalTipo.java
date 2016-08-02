package sornii.anofiscal;

import lombok.Getter;

import java.time.Month;
import java.time.Year;

public enum AnoFiscalTipo {

    REINO_UNIDO(Month.APRIL),

    SINGAPURA(REINO_UNIDO);

    @Getter
    private final PeriodoMeses periodoMeses;

    @Getter
    private final OrganizadorMeses organizadorMeses;

    AnoFiscalTipo(Month primeiroMes) {
        periodoMeses = new PeriodoMesesImmutable(primeiroMes);
        organizadorMeses = new OrganizadorMeses(periodoMeses);
    }

    AnoFiscalTipo(AnoFiscalTipo anoFiscalTipo) {
        this.periodoMeses = anoFiscalTipo.periodoMeses;
        this.organizadorMeses = anoFiscalTipo.organizadorMeses;
    }

    public AnoFiscal construirAnoFiscal(Year ano) {
        return new AnoFiscal(this, ano);
    }
}
