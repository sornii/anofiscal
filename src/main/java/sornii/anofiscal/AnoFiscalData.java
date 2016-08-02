package sornii.anofiscal;

import lombok.Data;

import java.time.Month;
import java.time.YearMonth;

@Data
public class AnoFiscalData {

    private AnoFiscal anoFiscal;

    private Month mes;

    public AnoFiscalData(AnoFiscal anoFiscal, YearMonth dataGregoriana) {
        this.anoFiscal = anoFiscal;
    }

    public AnoFiscalTipo getTipo() {
        return anoFiscal.getTipo();
    }

    public AnoFiscal getAnoFiscal() {
        return getTipo().construirAnoFiscal(anoFiscal.getAno());
    }

    public YearMonth getDataGregoriana() {
        return null;
    }
}
