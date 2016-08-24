package sornii.anofiscal;

import java.time.Month;
import java.time.YearMonth;

public class CalculadoraDataFiscal {

    public YearMonth calcularDataFiscal(AnoFiscalPadrao anoFiscalPadrao, YearMonth dataGregoriana) {
        AnoFiscalMesReferencia mesReferencia = anoFiscalPadrao.getMesReferencia();
        PeriodoMeses periodoMeses = anoFiscalPadrao.getPeriodoMeses();
        OrganizadorMeses organizadorMeses = periodoMeses.getOrganizadorMeses();

        Month mesUltimaOrdem = organizadorMeses.getMesNaOrdem(OrganizadorMeses.ULTIMA_ORDEM);
        if (mesUltimaOrdem == Month.DECEMBER) {
            return dataGregoriana;
        }

        if (mesReferencia == AnoFiscalMesReferencia.PRIMEIRO_MES) {
            if (dataGregoriana.getMonth().compareTo(mesUltimaOrdem) <= 0) {
                return dataGregoriana.minusYears(1);
            }
            return dataGregoriana;
        }

        if (dataGregoriana.getMonth().compareTo(mesUltimaOrdem) <= 0) {
            return dataGregoriana;
        }
        return dataGregoriana.plusYears(1);
    }
}
