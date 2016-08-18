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

    @Getter
    private final AnoFiscalOffsetTipo offsetTipo;

    AnoFiscalTipo(Month primeiroMes) {
        periodoMeses = new PeriodoMesesImmutable(primeiroMes);
        organizadorMeses = new OrganizadorMeses(periodoMeses);
        offsetTipo = AnoFiscalOffsetTipo.ATRASADO;
    }

    AnoFiscalTipo(AnoFiscalTipo anoFiscalTipo) {
        this.periodoMeses = anoFiscalTipo.getPeriodoMeses();
        this.organizadorMeses = anoFiscalTipo.getOrganizadorMeses();
        offsetTipo = AnoFiscalOffsetTipo.ATRASADO;
    }

    public AnoFiscal construirAnoFiscal(Year ano) {
        return new AnoFiscal(this, ano);
    }
}
