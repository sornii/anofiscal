package sornii.anofiscal;

import lombok.Data;

import java.time.Month;
import java.time.YearMonth;

@Data
public class AnoFiscalData {

    private AnoFiscal anoFiscal;

    private Month mes;

    public AnoFiscalData(AnoFiscal anoFiscal, Month mes) {
        this.anoFiscal = anoFiscal;
        this.mes = mes;
    }

    public AnoFiscalData(AnoFiscal anoFiscal, YearMonth dataGregoriana) {
        this.anoFiscal = anoFiscal;
    }

    public AnoFiscalData(AnoFiscalPadraoMundial anoFiscalPadraoMundial, YearMonth dataGregoriana) {
        //this.anoFiscal = anoFiscalTipo.construirAnoFiscal()
    }

    public YearMonth getDataGregoriana() {
        return null;
    }

    public YearMonth getData() {
        return YearMonth.of(getAnoFiscal().getAno().getValue(), getMes());
    }
}
