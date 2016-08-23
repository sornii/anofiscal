package sornii.anofiscal;

import lombok.Getter;

import java.time.Month;
import java.time.Year;

/**
 * Define padrões usadas no mundo para calendários diversos de ano fiscal
 */
public enum AnoFiscalPadraoMundial {

    REINO_UNIDO(Month.APRIL),

    SINGAPURA(REINO_UNIDO);

    @Getter
    private final PeriodoMeses periodoMeses;

    @Getter
    private final OrganizadorMeses organizadorMeses;

    @Getter
    private final AnoFiscalMesReferencia offsetTipo;

    AnoFiscalPadraoMundial(Month primeiroMes) {
        periodoMeses = new PeriodoMesesImmutable(primeiroMes);
        organizadorMeses = new OrganizadorMeses(periodoMeses);
        offsetTipo = AnoFiscalMesReferencia.PRIMEIRO_MES;
    }

    AnoFiscalPadraoMundial(AnoFiscalPadraoMundial anoFiscalPadraoMundial) {
        this.periodoMeses = anoFiscalPadraoMundial.getPeriodoMeses();
        this.organizadorMeses = anoFiscalPadraoMundial.getOrganizadorMeses();
        offsetTipo = AnoFiscalMesReferencia.PRIMEIRO_MES;
    }

    public AnoFiscal construirAnoFiscal(Year ano) {
        return new AnoFiscal(this, ano);
    }
}
