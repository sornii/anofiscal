package sornii.anofiscal;

import lombok.Data;

import java.time.Year;

@Data
public class AnoFiscal {

    private Year ano;

    private AnoFiscalPadrao anoFiscalPadrao;

    public AnoFiscal(AnoFiscalPadrao anoFiscalPadrao, Year ano) {
        setAno(ano);
        setAnoFiscalPadrao(anoFiscalPadrao);
    }

    public AnoFiscal(AnoFiscalPadraoMundial tipo, Year ano) {
        setAno(ano);
        setAnoFiscalPadrao(tipo.getAnoFiscalPadrao());
    }
}
