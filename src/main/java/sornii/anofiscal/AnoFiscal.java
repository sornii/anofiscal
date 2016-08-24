package sornii.anofiscal;

import lombok.Data;

import java.time.Year;

@Data
public class AnoFiscal {

    private Year ano;

    private AnoFiscalPadrao anoFiscalPadrao;

    protected AnoFiscal() {
    }

    private AnoFiscal(Year ano) {
        setAno(ano);
    }

    public AnoFiscal(AnoFiscalPadrao anoFiscalPadrao, Year ano) {
        this(ano);
        setAnoFiscalPadrao(anoFiscalPadrao);
    }

    public AnoFiscal(AnoFiscalPadraoMundial tipo, Year ano) {
        this(ano);
        setAnoFiscalPadrao(tipo.getAnoFiscalPadrao());
    }
}
