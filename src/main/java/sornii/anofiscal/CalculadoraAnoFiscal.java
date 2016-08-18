package sornii.anofiscal;

import java.time.Month;
import java.time.YearMonth;

public class CalculadoraAnoFiscal {

    public YearMonth calcularDataGregoriana(AnoFiscalData anoFiscalData) {
        AnoFiscal anoFiscal = anoFiscalData.getAnoFiscal();
        AnoFiscalOffsetTipo offsetTipo = anoFiscal.getOffsetTipo();

        YearMonth data = anoFiscalData.getData();

        OrganizadorMeses organizadorMeses = anoFiscal.getOrganizadorMeses();
        int ordemDezembro = organizadorMeses.getOrdemDoMes(Month.DECEMBER);
        int ordemDoMes = organizadorMeses.getOrdemDoMes(data.getMonth());

        if (offsetTipo == AnoFiscalOffsetTipo.ATRASADO) {
            if (ordemDoMes <= ordemDezembro) {
                return data;
            }
            return data.plusYears(1);

        } else if (offsetTipo == AnoFiscalOffsetTipo.ADIANTADO) {
            if (ordemDoMes <= ordemDezembro) {
                return data.minusYears(1);
            }
            return data;

        }

        return null;
    }

    public AnoFiscalData calcularAnoFiscalData(YearMonth dataGregoriana, AnoFiscal anoFiscal) {
        //todo:

        return null;
    }
}
