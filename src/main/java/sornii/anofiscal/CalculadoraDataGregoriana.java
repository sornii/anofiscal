package sornii.anofiscal;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

public class CalculadoraDataGregoriana {

    public YearMonth calcularDataGregoriana(AnoFiscalData anoFiscalData) {
        AnoFiscal anoFiscal = anoFiscalData.getAnoFiscal();
        AnoFiscalMesReferencia offsetTipo = anoFiscal.getOffsetTipo();

        YearMonth data = anoFiscalData.getData();

        OrganizadorMeses organizadorMeses = anoFiscal.getOrganizadorMeses();
        int ordemDezembro = organizadorMeses.getOrdemDoMes(Month.DECEMBER);
        int ordemDoMes = organizadorMeses.getOrdemDoMes(data.getMonth());

        if (offsetTipo == AnoFiscalMesReferencia.PRIMEIRO_MES) {
            if (ordemDoMes <= ordemDezembro) {
                return data;
            }
            return data.plusYears(1);
        }

        if (ordemDoMes <= ordemDezembro) {
            return data.minusYears(1);
        }
        return data;
    }

    public YearMonth calcularDataGregoriana(AnoFiscal anoFiscal, Month mes) {
        return calcularDataGregoriana(new AnoFiscalData(anoFiscal, mes));
    }

    public YearMonth calcularDataGregoriana(AnoFiscalPadraoMundial anoFiscalPadraoMundial, Month mes, Year ano) {
        return calcularDataGregoriana(new AnoFiscal(anoFiscalPadraoMundial, ano), mes);
    }
}
