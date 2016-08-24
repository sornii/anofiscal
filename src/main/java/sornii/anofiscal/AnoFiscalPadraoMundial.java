package sornii.anofiscal;

import lombok.Getter;

import java.time.Month;
import java.time.Year;

/**
 * Define padrões usadas no mundo para calendários diversos de ano fiscal
 */
@Getter
public enum AnoFiscalPadraoMundial {

    AUSTRALIA(Month.JULY),
    AUSTRIA(AnoFiscalPadrao.JANEIRO),
    BRASIL(AnoFiscalPadrao.JANEIRO),
    CANADA_GOV(AnoFiscalPadrao.ABRIL),
    CANADA_CORP(AnoFiscalPadrao.JANEIRO),
    CHINA(AnoFiscalPadrao.JANEIRO),
    COSTA_RICA(Month.OCTOBER),
    EGITO(Month.JULY),
    HONG_KONG(AnoFiscalPadrao.ABRIL),
    INDIA(AnoFiscalPadrao.ABRIL),
    IRA(AnoFiscalPadrao.ABRIL),
    ALEMANHA(AnoFiscalPadrao.JANEIRO),
    JAPAO_GOV(AnoFiscalPadrao.ABRIL),
    JAPAO_CORP(AnoFiscalPadrao.JANEIRO),
    NEPAL(Month.JULY),
    PAISES_BAIXOS(AnoFiscalPadrao.JANEIRO),
    NOVA_ZELANDIA_GOV(Month.JULY),
    NOVA_ZELANDIA_CORP(AnoFiscalPadrao.ABRIL),
    PAQUISTAO(Month.JULY),
    PORTUGAL(AnoFiscalPadrao.JANEIRO),
    ESPANHA(AnoFiscalPadrao.JANEIRO),
    REINO_UNIDO(AnoFiscalPadrao.ABRIL),
    SINGAPURA(AnoFiscalPadrao.ABRIL);

    private final AnoFiscalPadrao anoFiscalPadrao;

    AnoFiscalPadraoMundial(Month primeiroMes) {
        anoFiscalPadrao = new AnoFiscalPadrao(primeiroMes);
    }

    AnoFiscalPadraoMundial(AnoFiscalPadrao anoFiscalPadrao) {
        this.anoFiscalPadrao = anoFiscalPadrao;
    }

    public AnoFiscal construirAnoFiscal(Year ano) {
        return new AnoFiscal(this, ano);
    }
}
