package sornii.anofiscal;

import java.time.Month;
import java.time.YearMonth;

public class CalculadoraDataGregoriana {

    public YearMonth calcularDataGregoriana(AnoFiscalPadrao anoFiscalPadrao, YearMonth dataFiscal) {
        AnoFiscalMesReferencia mesReferencia = anoFiscalPadrao.getMesReferencia();

        PeriodoMeses periodoMeses = anoFiscalPadrao.getPeriodoMeses();
        OrganizadorMeses organizadorMeses = periodoMeses.getOrganizadorMeses();

        int ordemDezembro = organizadorMeses.getOrdemDoMes(Month.DECEMBER);
        if (ordemDezembro == OrganizadorMeses.ULTIMA_ORDEM) {
            return dataFiscal;
        }

        int ordemDoMes = organizadorMeses.getOrdemDoMes(dataFiscal.getMonth());

        if (mesReferencia == AnoFiscalMesReferencia.PRIMEIRO_MES) {
            if (ordemDoMes <= ordemDezembro) {
                return dataFiscal;
            }
            return dataFiscal.plusYears(1);
        }

        if (ordemDoMes <= ordemDezembro) {
            return dataFiscal.minusYears(1);
        }
        return dataFiscal;
    }
}
